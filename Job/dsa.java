import java.util.*;

class dsa{
	static class Pair{
		int first;
		int second;
		Pair(int f, int s){
			first = f;
			second = s;
		}
	}
	static class graph{
		int V;
		ArrayList<ArrayList<Integer>> adj;
		
		graph(int n){
			V = n;
			adj = new ArrayList<ArrayList<Integer>>(V);
			for(int i=0; i<6; i++)
				adj.add(new ArrayList<Integer>());
		}
		void addEdges(int u, int v){
			adj.get(u).add(v);
			adj.get(v).add(u);
		}
		void printGraph(){
			for(int i =0; i<adj.size(); i++){
				System.out.print(i+" -> ");
				for(int j =0; j<adj.get(i).size(); j++){
					System.out.print(adj.get(i).get(j)+", ");
				}
				System.out.println("");
			}
		}
	}
	public static void main(String args[]){
		two_sum();
		valid_parantheses();
		merge_sorted_list();
		best_time_to_buy_and_sell_stock();
		valid_palindrome();
		
		graph_representation();
		topological_sort();
		
		binary_search();
		flood_fill();
		
		ransome_note();
		climbing_stairs(5);
		
		// 547 number of provinces
		// number of islands using bfs
		number_of_islands_bfs();
		
		zero_one_two_sort();
	}
	public static void zero_one_two_sort(){
		int a[] = {1,2,0,2,1,0,2,1,0};
		int n = a.length;
		int j = 0;
		int k = n-1;
		for(int i =0; i<n && i<=k;){
			 if(a[i] == 0){
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				j++;
				i++;
			}else if(a[i] == 2){
				int temp = a[k];
				a[k]= a[i];
				a[i] = temp;
				k--;
			}else
				i++;
		}
		for(int i =0; i<n ;i++){
			System.out.print(a[i]);;
		}
	}
	public static void number_of_islands_bfs(){
		//in this it also checks diagonaly using (-1, 0, 1)
		int island[][]= {{1,0,0}, {0,0,1},{0,0,0}, {1,0,0}};
		int visited[][] = new int[island.length][island[0].length];
		int count =0;
		for(int i =0; i<island.length; i++){
			for(int j =0; j<island[0].length; j++){
				if(island[i][j] == 1 && visited[i][j] == 0){
					count++;
					bfs_island(island, visited, i , j);
				}
			}
		}
		System.out.println("number_of_islands_bfs: "+count);
	}
	public static void bfs_island(int land[][], int v[][], int i, int j){
		Queue<Pair> q = new LinkedList<Pair>();
		v[i][j] = 1;
		q.add(new Pair(i, j));
		
		while(!q.isEmpty()){
			int currentr = q.peek().first;
			int currentc = q.peek().second;
			q.remove();
			for(int delrow = -1 ; delrow <=1; delrow++){
				for(int delcol = -1 ; delcol <= 1; delcol++){
					int c = delcol + currentc;
					int r = delrow + currentr;
					
					if(c >=0 && c<land[0].length && r >= 0 && r<land.length && v[r][c] ==0 && land[r][c] == 1){
						v[r][c] = 1;
						q.add(new Pair(r, c));
					}
				}
			}
		}
	}
	public static int climbing_stairs(int n){
		if(n<1) return 1;
		//return climbing_stairs(n-2)+climbing_stairs(n-1);
		
		int db[] = new int[n+1];
		db[0] = db[1] = 1;
		for(int i =2; i<=n; i++){
			db[i] = db[i-2]+db[i-1];
		}
		return db[n];
	} 
	public static void ransome_note(){
		String ransomNote = "aa", magazine = "aab";
		int a[] = new int[26];
		for(int i =0; i<magazine.length(); i++){
			a[magazine.charAt(i) - 'a']++;
		}
		for(int i=0; i<ransomNote.length(); i++){
			if(a[ransomNote.charAt(i)-'a'] == 0){
				System.out.println("ransome_note cant be created");
				return;
			}
		}
		System.out.println("ransom_note can be created");
	}
	public static void flood_fill(){
		int a[][] = {{1,1,1}, {1,1,0}, {1,0,1}};
		int r = a.length;
		int c = a[0].length;
		
		int sr = 1, sc = 1, color = 2;
		a = dfs_flood_fill(sr, sc, color, r, c, a);
		System.out.println("flood_fill: ");
		print_array(a, r, c);
	}
	public static void print_array(int b[][], int r, int c){
		for(int i =0; i<r; i++){
			for(int j=0; j<c; j++){
				System.out.print(b[i][j]+" ");
			}
			System.out.println("");
		}
	}
	public static int[][] dfs_flood_fill(int sr, int sc, int x, int r, int c, int a[][]){
		if(sr >=r || sr <0 || sc >= c || sc<0 || a[sr][sc] != x) return a;
		a[sr][sc] = x;
		
		dfs_flood_fill(sr-1, sc, x, r, c, a);
		dfs_flood_fill(sr+1, sc, x, r, c, a);
		dfs_flood_fill(sr, sc-1, x, r, c, a);
		dfs_flood_fill(sr, sc+1, x, r, c, a);
		return a;
		
		
	}
	public static void binary_search(){
		int a[] = {1,2,3,4};
		
		int n = a.length;
		int x = 4;
		int l = 0;
		int r = n;
		while(l<r){
			int m = l+ (r-l)/2;
			if(a[m] == x){
				System.out.println("binary_search: "+m);
				return;
			}
			else if(a[m] < x){
				l = m+1;
			}else{
				r = m-1;
			}
		}
		System.out.println("binary_search not");
	}
	public static void graph_representation(){
		System.out.println("graph_representation: ");
		int v =5;
		graph g = new graph(v);
		g.addEdges(0,1);
		g.addEdges(0,2);
		g.addEdges(0,4);
		g.addEdges(4,3);
		g.printGraph();
	}
	public static void two_sum(){
		int a[] = {1,2,3,4,0,7,5};
		int target = 7;
		int n = a.length;
		HashSet<Integer> set = new HashSet<>();
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i =0; i<n; i++){
			int sum = target-a[i];
			if(!set.contains(sum)){
				set.add(a[i]);
				map.put(sum, i);
			}else{
				System.out.println("Contains "+ a[i]+" "+sum+" "+ i+" "+map.get(a[i]) );
			}
		}
		//System.out.println(map);
		
	}
	public static void valid_parantheses(){
		String p = "{{[}}";
		int n = p.length();
		Stack<Character> par = new Stack<>();
		
		for(int i =0; i<n; i++){
			char c = p.charAt(i);
			
			if(c == '{' || c == '[' || c == ')'){
				par.push(c);
			}else{
				char close = par.peek();
				if(close == '{' && c == '}'){
					par.pop();
				}else if(close == '[' && c == ']'){
					par.pop();
				}else if(close == '(' && c == ')'){
					par.pop();
				}else{
					System.out.println("Not valid_parantheses");
					return;
				}
			}
		}
		System.out.println(par);
	}
	public static void merge_sorted_list(){
		System.out.println("merge_sorted_list:");
		List<Integer> a = new ArrayList<Integer>(List.of(1,2,3,5));
		List<Integer> b = new ArrayList<Integer>(List.of(2,3,4));
		
		int n = a.size();
		int n1 = b.size();
		int i=0, j=0;
		while(i<n && j<n1){
			if(a.get(i) < b.get(j)){
				System.out.print(a.get(i)+", ");
				i++;
			}else{
				System.out.print(b.get(j)+", ");
				j++;
			}
		}
		while(i<n){
			System.out.print(a.get(i)+", ");
			i++;
		}
		while(j<n1){
			System.out.print(b.get(j)+", ");
			j++;
		}
	}
	public static void best_time_to_buy_and_sell_stock(){
		int a[] = {1,4,6,10};
		int n = a.length;
		int max = 0;
		int buy = a[0];
		
		for(int i =1; i<n; i++){
			if(buy > a[i]){
				buy = a[i];
			}else if(a[i] - buy > max){
				max = a[i] - buy;
			}
		}
		System.out.println("\nmax_profit: "+max);
	}
	public static void valid_palindrome(){
		String a = "b1ava ,! va1b";
		a = a.replaceAll("[^a-zA-Z0-9]", "");
		int l = 0;
		int r = a.length()-1;
		while(l<r){
			char c = a.charAt(l);
			char c1 = a.charAt(r);
			if(c != c1) {
				System.out.println("not valid_palindrome");
				return;
			}
			++l;
			--r;
		}
		System.out.println("valid_palindrome");
	}
	
	public static void topological_sort(){
		int nodes = 6;
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>(nodes);
		for(int i=0; i<6; i++){
			graph.add(new ArrayList<Integer>());
		}
		graph.get(5).addAll(Arrays.asList(2,0));
		graph.get(4).addAll(Arrays.asList(0,1));
		graph.get(2).addAll(Arrays.asList(3));
		graph.get(3).addAll(Arrays.asList(1));
		System.out.println("acyclic graph (topological_sort): ");
		printG(graph);
		
		
		int[] visited = new int[nodes];
		Arrays.fill(visited, 0);
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0; i<nodes; i++){
			if(visited[i] == 0){
				dfsgraph(visited, stack, graph, i);
			}
		}
		System.out.println(stack);
	}
	public static void dfsgraph(int visited[], Stack<Integer> s, ArrayList<ArrayList<Integer>> g, int i){
		visited[i] = 1;
		for(int j : g.get(i)){
			if(visited[j] == 0){
				dfsgraph(visited, s, g, j);
			}
		}
		s.push(i);
	}
	public static void printG(ArrayList<ArrayList<Integer>> adj){
		for(int i =0; i<adj.size(); i++){
			System.out.print(i+" -> ");
			for(int j =0; j<adj.get(i).size(); j++){
				System.out.print(adj.get(i).get(j)+", ");
			}
			System.out.println("");
		}
	}
}