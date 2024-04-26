import java.util.*;
import java.math.*;
public class solution2 {

	public static void jump(){
		int a[] = {3,1,1,1,4};
		//int a[] = {3,1,1,0,4}; //not reachable
		int count = 0;
		int lastIndex = a.length-1;
		for(int i = a.length-1; i>=0; i--){
			count = i + a[i];
			if(count >= lastIndex){
				lastIndex = i;
			if(lastIndex == 0) {System.out.println("jump: reachable ");  return;}
			}
		}
		System.out.println("jump: not reachable");
		
		
	}
	public static void string_same(){
		String a ="#abc#";
		String b = "b#abc#";
		Stack<String> aa = new Stack<>();
		Stack<String> bb = new Stack<>();
		for(int i =0;i<a.length(); i++){
			if(i==0 && a.charAt(i) == '#') continue;
			if( a.charAt(i) == '#'){
				aa.pop();
			} 
			else{
				aa.push(String.valueOf(a.charAt(i)));
			}
		}
		for(int i =0;i<b.length(); i++){
			if(b.charAt(i) == '#'){
				bb.pop();
			}
			else{
				bb.push(String.valueOf(b.charAt(i)));
			}
		}
		System.out.println("string_same backspace# :"+aa+" "+bb);
	}
	public static void ballons_1189(){
		String c = "loonbalxballpoon";
		int [] alpha = new int[26];
		for(int i=0; i<c.length(); i++){
			alpha[c.charAt(i)-'a']++;
		}
		
		int min = alpha[1];
		min = Math.min(min, alpha[1]);
		min = Math.min(min, alpha['l'-'a'] / 2);
		min = Math.min(min, alpha['o'-'a']/2);
		min = Math.min(min, alpha['n'-'a']);
		
		System.out.println("minimum word in the string: "+min);
	}
	public static void dictionary_words(){
	String a[] = {"a", "banana", "app", "appl", "ap", "apply", "apple", "aapples", "b", "ba", "ban", "bana", "banan", "banana"};
		Arrays.sort(a);
		
		int n =a.length;
		int max = -1;
		String r = "";
		HashSet<String> set = new HashSet<>();
		//set.add("a");
		//set.add("ap");
		//System.out.println("ap".substring(0, "ap".length()-1)+" "+set.contains("ap".substring(0, "ap".length()-1)));
		
		for(int i = 0; i<n; i++){
			if( a[i].length() == 1 || set.contains(a[i].substring(0, a[i].length()-1)) ){
				set.add(a[i]);
				//System.out.println(set);
				if(max < a[i].length()){
					r = a[i];
					max = r.length();
					//System.out.println(r+" "+ max);
				}
				
			}
		}
		
		System.out.println("dictionary_words: "+r);
		//System.out.println(Arrays.toString(a));
	}
	public static void word_latter(){
		String begin = "hit", end = "cog";
        String list[] = {"hot", "dot", "dog", "lot", "log", "cog"};

        HashSet<String> endw = new HashSet<>();
		for(String z : list){
			endw.add(z);
		}
		
		int level = 1;
		
		Queue<String> q = new LinkedList<>();
		q.offer(begin);
		
		while(!q.isEmpty()){
			int n = q.size();
			
			
			for(int i =0; i<n; i++){
				String current = q.poll();
				char new_word[] = current.toCharArray();
				for(int j=0; j< current.length(); j++){
					char current_char = new_word[j];
					
					for(char a='a'; a<'z'; a++){
						if(current_char == a) continue;
						new_word[j] = a;
						
						String new_wordd = String.valueOf(new_word);
						
						if(new_wordd.equals(end)) {System.out.println("word_latter: "+(level+1)); return;}
						
						if(endw.contains(new_wordd)){
							endw.remove(new_wordd);
							q.offer(new_wordd);
					
						}
					}
					new_word[j] = current_char;
				}
			}
			level++;
		}
	}
	public static void vowel_consonat(){
		String a = "population"; //cv;
		String b = "aeiou";
		String r = "";
		String re = "";
		int n= a.length();
		for(int i = 0; i<n; i++){
			if(vowel(a.charAt(i))){
				r+="v";
				while(i+1 < n && vowel(a.charAt(i+1))){ i++; }
			}else{
				r+="c";
				while(i+1 < n && !vowel(a.charAt(i+1))){ i++; }
			}
		}
		//r+=re;
		System.out.println("vowel_consonant: "+r);
	}
	public static boolean vowel(char a){
		if(a == 'a' || a == 'e' || a=='i' || a=='o' || a=='u') return true;
		return false;
	}
	public static void longest_substring_palindrome(){
		String b = "racecar";
		char a[] = b.toCharArray();
		int n = a.length;
		int max = 0;
		for(int i = 0; i<n; i++){
			String p = String.valueOf(a[i]);
			for(int j =i+1; j<n; j++){
				p+= String.valueOf(a[j]);
				//System.out.println(p);
				if(palindrome(p)){
					max = Math.max(max, p.length());
				}
			}
		}
		System.out.println("longest_substring_palindrome: "+max);
		b = "azabbaa";
		int start = 0;
		int end = 0;
		for(int i =0; i<b.length(); i++){
			int len1 = expand_palindrome(i, i, b);
			int len2 = expand_palindrome(i, i+1, b);
			int len = Math.max(len1, len2);
			if(len > end - start){
				start = i - ((len-1)/2);
				end = i + (len/2);
			}
		}
		//System.out.println(start +" "+end);
		System.out.println(b.substring(start, end+1));
	}
	public static int expand_palindrome(int left, int right, String a){
		if(a == null || left > right) return 0;
		while(left >=0 && right < a.length() && a.charAt(left) == a.charAt(right)) {
			left--;
			right++;
		}
		return right - left -1;
	}
	public static boolean palindrome(String r){
		StringBuilder sb = new StringBuilder(r);
		if(r.equals(sb.reverse().toString())){
			//System.out.println(r+" "+ sb.reverse().toString()+" "+ r.equals(sb.reverse().toString()));
			return true;
		}
		return false;
	}
	public static void house_robber(){
		int a[] = {100, 1, 1, 100};
		int n = a.length;
		int db[] = new int[n];
		db[0] = a[0];
		db[1] = Math.max(a[0], a[1]);
		
		for(int i = 2; i< n; i++){
			db[i] = Math.max(db[i-1], a[i]+db[i-2]);
		}
		System.out.println("house_robber: "+db[n-1]);
	}
	public static void generate_paranthesis(){
		int n = 3;
		List<String> result = new ArrayList<>();
		backtrack(result, 0, 0, "", n);
		System.out.println("generate_paranthesis: "+ result);
	}
	public static void backtrack(List<String> o, int i, int j, String current, int max){
		if(current.length() == 2*max) o.add(current);
		if(i < max) backtrack(o, i+1, j, current+"(", max);
		if(j < i) backtrack(o, i, j+1, current+")", max);
	}
	public static void search_2d_matrix(){
		System.out.println("\nsearch_2d_matrix: ");
		int a[][] ={{1,2,3,4}, {5,6,7,8}, {10,11, 12, 13}};
		int r = a.length, c = a[0].length;
		int left = 0, right = r * c -1;
		int target = 8;
		while(left <= right){
			int midpoint = left + (right-left)/2;
			int mitpoint_element = a[midpoint/c][midpoint%c];
			
			if(target == mitpoint_element){
				System.out.println("Element found :"+ a[midpoint/c][midpoint%c]+" position: "+(midpoint/c) +" "+(midpoint%c) );
				return;
			}
			if(target < mitpoint_element) right = midpoint-1;
			if(target > mitpoint_element) left = midpoint+1;
		}
	}
	public static void find_word_in_2dArray_charachters(){
		System.out.println("find_word_in_2dArray_charachters: ");
		String a[][] = {{"a","a","b"},
						{"c","d","e"}};
				
		int r = a.length, c = a[0].length;				
		String s = "abe";
		boolean visited[][] = new boolean[r][c];
		for(int i =0 ;i<r; i++){
			for(int j =0; j<c; j++){
				int index = 0;
				if(String.valueOf(s.charAt(0)).equals(a[i][j]) && q(i, j, r, c, visited, index , a, s)){
					//System.out.println(i+" "+j);
					
					System.out.print("Found");
					
				}
			}
		}
	}
	public static boolean q(int i, int j,int r, int c, boolean visited[][], int index, String a[][], String s){
		if(index == s.length()) {
			System.out.println("Found");
			return true;
		}
		if(i<0 || i>=r || j < 0 || j >=c || visited[i][j] || !String.valueOf(s.charAt(index)).equals(a[i][j]) ){
			return false;
		}
		visited[i][j] = true;
		if(q(i+1 , j, r, c, visited, index+1, a, s) ||
		   q(i , j+1, r, c, visited, index+1, a, s) ||
		   q(i-1 , j, r, c, visited, index+1, a, s) ||
		   q(i , j-1, r, c, visited, index+1, a, s) ){
			   return true;
		}
		visited[i][j] = false;
		return false;
	}
	public static void merge_intervals(){
		System.out.println("merge overlap: ");
		int a[][] = {{1,3}, {2,5}, {4,7}, {7,8}, {9,11}, {10,15}};
		int index = 0;
		int n = a.length;
		while(index < n){
			int start = a[index][0];
			int end = a[index][1];
			while( index+1 < n && end >= a[index+1][0] ){
				
				end = Math.max(end, a[index+1][1]);
				index++;
			}
			index++;
			System.out.println(start+" "+end);
		}
	}
	public static void mitsogo3(){
		System.out.println("mitsogo3: ");
		int a[] = {6, 3, 3, 4, 6};
		int b[] = {1, 10, 15 ,10, 10};
		int n = a.length;
		HashMap<Integer, Integer> m = new HashMap<>();
		
		for(int i = 0; i<n; i++){
			if(b[i] > 0){
				if(!m.containsKey(a[i])){
					m.put(a[i], b[i]);
				}else{
					if(a[i-1] == a[i]){
						m.put(a[i], Math.max(m.get(a[i]), b[i]));
					}else{
						m.put(a[i], m.get(a[i])+b[i]);
					}
				}
			}
		}
		System.out.println(m);
	}
	public static void mitsogo2(){
		String s = "125";
		int a = Integer.parseInt(s);
		int n = s.length();
		int sum = 0;
		for(int i =0; i<n; i++){
			//System.out.println(a / (int)(Math.pow(10, i)) +" "+ a % (int)(Math.pow(10, i)));
			sum +=  a / (int)(Math.pow(10, i)) + (int)a % (Math.pow(10, i));
		}
		for(char c : s.toCharArray()){
			sum += c - '1' +1;
		}
		System.out.println("mitsogo 125 sum: "+sum);
	}
	public static void mitsogo1(){
		String a = "lockdown";
		String s[][] = {{"lo", "5"}, {"ck", "5"}, {"lock", "50"}, {"down", "50"}};
		
		String k[] = {"lo", "ck", "lock", "down"};
		int v[] = {5, 5, 10, 10};
		

		int n = s.length;
		int sum = 0;
		HashMap <String, Integer> m = new HashMap<>();
		
		for(int i = 0; i<s.length;i++){
			System.out.println(s[i][0]);
			
			while(a.indexOf(s[i][0]) >= 0){
				a = a.replace(s[i][0], "0");
				System.out.println(a+" "+s[i][0]);
				sum+=Integer.parseInt(s[i][1]);
			}
		}
		System.out.println("mitsogo string replace lockdown: "+sum);
	}
	public static void normalpattern(){
		System.out.println("pattern: ");
		int n = 4;
		for(int i = 0; i<=n;i++){
			for(int j=0; j<=n-i;j++){
				System.out.print(j+1);
				//System.out.print(n-j+1);
			}System.out.print("\n");
		}
		//pascal c *(a-b) / (b+1)
		for(int i =0; i<n;i++){
			for(int j =0;j<n-i;j++){ System.out.print(" ");}
			int c = 1;
			for(int k =0;k<=i;k++){
				System.out.print(c+" ");
				c = c *(i-k) /(k+1);
			}
			System.out.print("\n");
		}
		String s = "syedm";
		int c = 0;
		for(int i =0; i<n;i++){
			for(int j =0;j<i;j++){
				if(c < s.length()){
					System.out.print(s.charAt(c));
					c++;
				}else System.out.print("*");
			}
			System.out.println("");
		}
		c = 0;
		int t = 0;
		for(int i =0; i<n;i++){
			c = (i == 0)? 1:t+i+1; 
			for(int j =i;j>=0;j--){
				System.out.print(c);
				c--;
				t++;
			}
			c = t;
			System.out.println("");
		}
	}
	public static void prime(){
		int n = 100;
		int count=2;
		int primel[] = new int[25];
		primel[0] = 2; primel[1] =3;
		for(int i = 4; i<n;i++){
			boolean flag = false;
			for(int j =2; j<n/2; j++){
				if(i % j == 0 && i != j){
					flag = true;
					
				}
			}
			if(!flag){primel[count++] = i; System.out.print(i+" "); flag = false;}
		}
		System.out.println("total prime between 1 to 100: "+count);
		//System.out.println(primel[24]);
		//2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97 total 25
	}
	public static void count_subarray_with_k_sum(){
		/*
			bruteforce - 2 for loop 
			optimization hashmap (0,1) -> (sum, count)
				sum+=a[i]
				hm.conatins(sum-k)
			ella element um kuditite varanum
				varum pothu hashmap la check panannum sum-k iruka nu
					iruntha result oda count add panikaranum
				hashmap la sum,count insert pannaum
		*/
		
		int a[] = {1,1,1};
		int k = 2;
		HashMap<Integer, Integer> hm = new HashMap<>();
		hm.put(0, 1);
		int sum = 0;
		int result = 0;
		
		for(int i =0;i<a.length; i++){
			sum+=a[i];
			
			if(hm.containsKey(sum-k)){
				result+= hm.get(sum-k);
			}
			hm.put(sum, hm.getOrDefault(sum, 0)+1);
		}
		System.out.println("count_subarray_with_k_sum: "+result);
		result = 0;
		
		for(int i =0; i<a.length;i++){
			sum=a[i];
			for(int j =i+1; j<a.length; j++){
				sum+=a[j];
				if(sum == k){
					result++;
				}
			}
		}
		System.out.println("count_subarray_with_k_sum: "+result);

	}
	public static void count_and_say(){
		System.out.println("count_and_say: \n1");
		String val = "1";
		
		int n = 4;
		for(int i =0;i<n-1;i++){
			char c = val.charAt(0);
			int size = val.length();
			int count = 1;
			StringBuilder sp = new StringBuilder();
			for(int j = 1; j< size; j++){
				if(c != val.charAt(j)){
					sp.append(count);
					sp.append(c);
					count = 0;
					c = val.charAt(j);
				}
				count++;
			}
			
			sp.append(count);
			sp.append(c);
			val = sp.toString();
			
			System.out.println(val);
			
		}
	}
	public static void swap(char s[], int a, int b){
			char temp = s[a];
			s[a]= s[b];
			s[b] = temp;
		}
	public static void permute_string(char a[], int fi){
		
		if(fi == a.length -1) {
			System.out.println(a); return;
		}
		
		for(int i = fi; i<a.length;i++){
			swap(a, i, fi);
			permute_string(a, fi+1);
			swap(a, i, fi);
		}
	}
	public static void most_common_word(){
		String a = "Bob hit a ball, the hit BALL, flew far after it was hit";
		String banned[] = {"hit"};
		String result = "";
		
		HashSet<String> ban = new HashSet<>(Arrays.asList(banned));
		
		String a1[] = a.toLowerCase().split("\\W+");
		HashMap<String, Integer> map = new HashMap<>();
		for(int i = 0; i<a1.length; i++){
			if(!ban.contains(a1[i])){
				map.put(a1[i], map.getOrDefault(a1[i], 0)+1);
			}
		}
		int max = 0;
		for(Map.Entry<String, Integer> m : map.entrySet()){
			int val = m.getValue();
			if(val > max){
				max = val;
				result = m.getKey();
			}
		}
		System.out.println(result);
	}
	public static void open_the_lock(){
		System.out.println("open_the_lock: ");
		/*
			bfs use pannaum
			level order !q.isEmpty(){
							q.size() > 0{
								size--
							}
						}
			0000 to 1234 there are deadends too find move?
		*/
		String target = "0202";
		String deadends[] = {"0201", "0101", "0102", "1212", "2002"};
		
		
		HashSet<String> de = new HashSet<String>(Arrays.asList(deadends));
		HashSet<String> visited = new HashSet<>();
		Queue<String> q = new LinkedList<>();
		
		visited.add("0000");
		q.offer("0000");
		int count = 0;
		int level = 0;
		while(!q.isEmpty()){
			int size = q.size();
			while(size > 0){
				String lock = q.poll();
				if(de.contains(lock)){
					size--;
					continue;
				}
				if(target.equals(lock)){
					System.out.println(level+" "+count);
					return;
				}
				
				
				StringBuilder sb = new StringBuilder(lock);
				for(int i = 0; i<4; i++){
					char cp = sb.charAt(i);
					
					String s1 = sb.substring(0, i) + (cp == '9' ? 0:cp - '0' + 1) + sb.substring(i+1);
					String s2 = sb.substring(0, i) + (cp == '0' ? 9:cp - '0' - 1) + sb.substring(i+1);
					
					//System.out.print(s1+" "+s2+"\n");
					
					if(!visited.contains(s1) && !de.contains(s1)){
						visited.add(s1);
						q.offer(s1);
					}
					
					if(!visited.contains(s2) && !de.contains(s2)){
						visited.add(s2);
						q.offer(s2);
						
					}
					count++;
				}
				size--;
			}
			level++;
		}
		
		System.out.println("level: "+level+" "+-1);
	}
	public static void zig_zag_pattern(){
		/*
			1st row increase panikite varoom
			2nd middle ku porrom, row(0, math.max(row-2))
			3rd row > 0
				row-- ++col
		*/
		System.out.println("zig_zag_pattern:");
		int n = 5;
		String s = "syedmasooddivanoli";
		char a[] = s.toCharArray();
		int row = 0;
		int col = 0;
		int curr = 0;
		char res[][] = new char [n][s.length()];
		for(int i = 0; i<n; i++){
			while(row < n && curr<a.length ){
				res[row++][col] = a[curr++];
			}
			row = Math.max(0, row-1);
			while(row>0 && curr < a.length){
				res[row--][++col] = a[curr++];
			}
			col++;
			
		}
		for(int i = 0; i<n; i++){
			for(int j = 0; j<a.length; j++){
				System.out.print(res[i][j]);
			}
			System.out.println("");
		}
	}
	public static void odd_even_jump(){
		/*
			Array
			boolean higher , lower array
			Treamap use pannuvoom put-method for adding element
			athula ceil for next highest value
				   floor for next smallest value
				   
				   boolean la update pannanum
		*/
		
		int a[] = {10, 13, 12, 14, 15};
		int n = a.length;
		int good_start = 1;
		boolean higher[] = new boolean[n];
		boolean lower[] = new boolean[n];
		higher[n-1] = true;
		lower[n-1] = true;
		TreeMap<Integer, Integer> tm = new TreeMap<>();
		tm.put(a[n-1], n-1);
		
		for(int i = n-2; i>=0;i--){
			Map.Entry higher_key = tm.ceilingEntry(a[i]);
			Map.Entry lower_key = tm.floorEntry(a[i]);
			
			if(!(higher_key == null)){
				higher[i] = lower[(int) higher_key.getValue()];
			}
			if(!(lower_key == null)){
				lower[i] = higher[(int) lower_key.getValue()];
			}
			if(higher[i]) good_start++;
			tm.put(a[i], i);
		}
		System.out.println("odd_even_jump: "+good_start);
	}
	public static void middle_in_array_rabit_hare(){
		int a[] = {1,2,3,4,5,6,2};
		int f = 0;
		int s = 0;
		int n = a.length;
		while( f< n && s < n){
			f++;
			s+=2;
		}
		System.out.println("middle_in_array_rabit_hare: "+a[f-1]);
		String mail[] = ("Syed@gmail.com").split("@");
		System.out.println(mail[0]+" "+mail[1]);
	}
	public static void xpattern_digit(){
		int n = 5;
		int m = (n+1)/2;
		for(int i = 1;i<=n; i++){
			for(int j = 1; j<=n; j++){
				if(i==j){
					if(i < m){
						System.out.print(n-i+1);
					}else{
						System.out.print(i);
					}
				}
				else if(i+j == n+1){
					if(i < m){
						System.out.print(i);
					}else{
						System.out.print(j);
					}
				}
				else{
					System.out.print(" ");
				}
			}
			System.out.print("\n");
		}
	}
	public static void xpattern(){
		int n =5;
		for(int i = 1 ;i <=n; i++){
			for(int j = 1; j<=n; j++){
				if(i == j) System.out.print("x");
				else if(i+j == n+1) System.out.print("x");
				else System.out.print(" ");
			}
			System.out.print("\n");
		}
	}
	public static void coin_need(){
		//1 10 25
		int n = 30;
		int count = 0;
		if(n < 10){ count+=n; return;}
		if(n >9 && n <25){
			count = (n/10)+ (n % 10);
			return;
		}
		if(n > 24){
			count = n/25;
			if(n %25 <10){
				count+=n%25;
				return;
			}
			if(n %25 > 9){
				count = count + (n%25) /10 + (n%25) %10;  // 0 + 5
				return;
			}
				
		}
		System.out.println("number of coin need: "+ count);
	}
	public static void poisonus_pig(){
		int buckets = 1000, dieT = 15, totalT = 60;
		
		System.out.println((int) Math.ceil(Math.log(buckets) / Math.log((totalT/dieT) +1)));
		
	}
	public static void laptop_required(){
		//int a[][] = {{1,2}, {5,6}, {2,3}};
		//Arrays.sort(a, new Comparator<int[], int[]> (a[], b[]) -> b[0]-a[0]);
		//int a[] = {1,2,3}, b[] = {4,4,6};
		int a[] = {1,5,2}, b[] = {2,6,3};
		int n = a.length;
		Arrays.sort(a);
		Arrays.sort(b);
		
		int i = 0, j =0, count = 0, ans = 0;
		while(i < n){
			if(a[i] < b[j]){
				count++;
				ans = Math.max(ans, count);
				i++;
			}else{
				count--;
				j++;
			}
		}
		System.out.println("laptop_required :"+ans);
	}
	public static void largest_sum_contiguous_subarray(){
		//int a[] = {-2, -3, 4, -1, -2, 1, 5, -3};
				//  0,  1, 2,  3,  4, 5, 6,  7
		int a[] = {5,2,-2};
		int max=a[0], upto=0, n = a.length;
		int start = 0, end=0;
		for(int i = 0; i<n; i++){
			upto += a[i];
			if(upto < a[i])  {
				start = i;
				upto = a[i];
				
			}
			else if(upto > max) {
				end = i;
				max = upto;
				
			}
		}
		System.out.println("\n"+max+" "+start + " "+end);
	}
	public static void move_negative_to_first(){
		int a[] = {-12, 11, -13, -5, 6, -7, 5, -3, -6};
		int n = a.length;
		/*int j = 0;
		for(int i = 0 ;i< n ;i++){
			if(a[i] < 0){
				if(i != j){
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				
				}
				j++;
			}
		} */
		int j = 0, temp;
        for (int i = 0; i < n; i++) {
            if (a[i] < 0) {
                if (i != j) {
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
                j++;
            }
        }
		System.out.println("");
		for(int i = 0 ;i<n ;i++) System.out.print(a[i]+" ");
	}
	public static void find_peek(){
		int a[] = {10, 20, 15, 2, 23, 90, 67};
		int n = a.length;
		for(int i = 1; i<=n-2;i++){
			if(a[i] > a[i-1] && a[i]> a[i+1]) System.out.print(a[i]+" ");
		}
		
	}
	public static void long_mulplication_bigInteger(){
		int n = 20;
		BigInteger f = new BigInteger("1");
		for(int i = 2; i<= 20 ;i++){
			f = f.multiply(BigInteger.valueOf(i));
		}
		System.out.print("\n"+f+"\n");
	}
	public static void long_integer_addition_bigInteger(){
		String str="7777555511111111";
        String str1="3332222221111";
		
		BigInteger a = new BigInteger(str);
		BigInteger b = new BigInteger(str1);
		System.out.println("\n"+a.add(b));
	}
	public static void binary_addition(){
		String a = "11", b = "1";
		int n = a.length();
		int n1 = b.length();
		int sum = 0, sum1 = 0;
		for(int i=n-1;i>=0;i++){
			sum+=(Character.getNumericValue(a.charAt(i)) * Math.pow(2, i));
			//System.out.println(sum)
			if(i<n1)
				sum1+=(Character.getNumericValue(a.charAt(i)) * Math.pow(2, i));
		}
		int result = sum+sum1;
		
		System.out.print(sum+" "+sum1+" "+ Integer.toBinaryString(result));
	}
	public static void string_3replace_(){
		String S = "geeksforgeeks", S1 = "eek", S2 = "ok";
		int n = S1.length();
		int pos = S.indexOf(S1);
		String result ="";
		while(pos != -1){
			for(int i = 0;i< S.length(); i++){
				if(pos == i){
					result+=S2;
					i+=n;
				}
				result+=S.charAt(i);
			}
			S = result;
			result= "";
			pos = S.indexOf(S1);
			//System.out.println(S+" "+pos);
		}
		System.out.println(S);
	}
	public static void pattern(){
		int n = 5;
		int c = 1;
		for(int i = 0 ;i<=n;i++){
			for(int j = 0 ;j<n-i; j++) System.out.print(" ");
			for(int k = 0; k<((2*i)-1); k++){
				int m = ((2*i)-1) /2;
				System.out.print(c);
				if(k<m) c++;
				else c--;
			}
			c= i+1;
			System.out.println("");
		}
		
	}
	public static void ip_address(){
		String ip1 = "222.111.111.111";
        String ip2 = "5555..555";
        String ip3 = "0000.0000.0000.0000";
        String ip4 = "1.1.1.1";
		
		String a[] = ip2.split("\\.");
		int n = a.length;
		if(n <4) {
			System.out.println("NOT ip Length");
			return;
		}
		
		//leading zero
		for(int i = 0 ;i<n;i++){
			if(i == 0 && a[i].charAt(0) == '0')  {
				System.out.println("NOT ip Zero");
				return;
			}
			try{
				int p = Integer.parseInt(a[i]);
				if(!(p > 0 && p <=255))  return;
			}catch(Exception e) {System.out.print(e);}
		}
		System.out.println("IP");
	}
	public static void roman(){
		String i[] = {"", "I", "II", "III", "IV", "V", "VII", "VIII", "IX", "X"}; //1 to 9
		String x[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "LC"}; //10 to 90
		String c[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "XM"}; //100 to 900
		String m[] = {"", "M", "MM", "MMM"}; //1000 to 3000;
		
		int a = 15;
		String thousand = m[a / 1000];
		String hundred = c[(a%1000)/100];
		String tens = x[(a%100)/10];
		String ones = i[a%10];
		System.out.println(thousand+hundred+tens+ones);
	}
	public static void reverse(){
		String s = "Syed Masood Divan Oli";
		String a[] = s.split(" ");
		int n = a.length;
		for(int i = 0; i<a.length/2; i++){
			String temp = a[i];
			a[i] = a[n-1-i];
			a[n-1-i] = temp;
		}
		for(int i = 0;i<n;i++){
			System.out.print(a[i]+" ");
		}
	}
	public static void pyramid(){
		int n = 5;
		for(int i = 0; i<n;i++){
			for(int j =0; j<n-i; j++) System.out.print(" ");
			//for(int k =0; k<i; k++) System.out.print(k+" ");
			for(int k =0; k<((2*i)-1); k++) System.out.print(k+" ");
			System.out.print("\n");
		}
	}
	public static void conversion(){
		System.out.println(Integer.toBinaryString(5));
		//System.out.println(Integer.toOctalString(5));
		//System.out.println(Integer.toHexString(5));
		System.out.println("1<<8 " +(1<<8));
	}
	public static void smallestSubarray_SlidingWindow(){
		int a[] = { 1, 4, 2, 10, 2, 3, 1, 0, 20 };
		int k = 4, j =0;
		int n = a.length;
		int sum = 0;
		
		for(int i = 0;i < k;i++){
			sum+=a[i];
		}
		int window = sum;
		for(int i = k ; i<n;i++){
			window = window + a[i] - a[i-k];
			sum = Math.max(sum, window);
		}
			System.out.println("smallestSubarray_SlidingWindow :"+sum);
		
		
	}
	public static void isAnagram(){
		String a = "aaab";
		String b = "aabb";
		int c[] = new int[256];
		Arrays.fill(c, 0);
		int n = a.length();
		for( int i =0;i<n;i++){
			char q = a.charAt(i);
			char w = b.charAt(i);
			
			c[q]++;
			c[w]--;
		}
		for(int i =0;i<256;i++){
			if(c[i] != 0){
				System.out.println("Anagram Not");
				return;
			}
		}
		System.out.println("Anagram");
	}
	public static void comperession(){
		String a = "aab"; //a2b1
		String r = "";
		int sum=1;
		for(int i =0;i<a.length()-1;i++){
			if(a.charAt(i) == a.charAt(i+1)){
				sum++;
			}else{
				r = r+sum+a.charAt(i);
				sum = 1;
			}
		}
		if(a.length() > r.length()) r = r+sum+a.charAt(a.length()-1);
			else r=a;
		System.out.println(r);
	}
	static int p[] = new int[26];
	public static void lexographical_1061(){
		String a ="axs";
		String b = "bdf";
		String base = "def";

		for(int i =0;i<26;i++) p[i] = i;

		for(int i = 0;i<3;i++){
			int f = a.charAt(i) - 'a';
			int s = b.charAt(i) - 'a';
			int pa = find(f);
			int pb = find(s);
			if(pa < pb) p[pb] = pa;
			else p[pa] = pb;

		}
		
		//for(int i =0;i<=6;i++) System.out.print(p[i]+" ");
		
		//System.out.print("\n");
		StringBuilder sb = new StringBuilder();
		
		for(char c : base.toCharArray()){
			char r = (char) (p[find(c - 'a', c)]+'a');
			int z = find(c - 'a');
			//System.out.println(z);
			//System.out.print((c - 'a')+" "+r);
			sb.append(r);
		}
		System.out.println("1061: "+sb.toString());
	}
	public static int find(int x, char a){
		if(p[x] != x) p[x] = find(p[x]);
		//System.out.println(p[x]+" "+a);
		return x;
	}
	public static int find(int x){
		if(p[x] != x) p[x] = find(p[x]);
		//System.out.println(p[x]);
		return x;
	}
    public static void keyboardtype(){
		String p = "";
		String a[] = new String[] {"0", "1", "abc", "def", "ghi", "jk1", "mno", "pqrs", "tuv", "wxyz"};
		String code = "233";
		int n = code.length();
		LinkedList<String> r = new LinkedList<>();
		r.add("");
		for(int i = 0; i<n; i++){
			int d = Character.getNumericValue(code.charAt(i));
			//System.out.println(d);
			while(r.peek().length() == i){
				p = r.remove();
				for(char c : a[d].toCharArray()){
					r.add(p+c);
				}
			}
		}
		System.out.print(r);
	}
	public static void monkey(){
		int a[] = new int[101];
		Arrays.fill(a, 0);
		for(int j = 1;j<101;j++){
			for(int i = 1;i<101;i++){
				if(i %j == 0) {
					if(a[i] == 0) a[i] = 1;
					else a[i] = 0;
				}
			}
		}
		System.out.println("\n");
		for(int j = 1;j<101;j++) {
			if(a[j] == 1)
			System.out.print(j+" ");
		}
	}
	public static void main(String args[]){
		
		
		int ae[][] = {{1,2}, {5,6}, {2,3}};
		//Arrays.sort(a, new Comparator<int[], int[]> (b[], c[]) -> b[0]-c[0]);
		Arrays.sort(ae, (a, b) -> Integer.compare(a[1],b[1]));	
		//SORT 2D array, 1D array, HashSet, HashMap
		
		conversion();
		lexographical_1061();
		smallestSubarray_SlidingWindow();
		comperession();
		isAnagram();
		
		
		keyboardtype();
		
		monkey();
		pyramid();
		//short x = 5; x = x * 5; compile-time error lossy conversion int to short
		
	
		//20/9/23 zoho
		reverse();
		roman();
		ip_address();
		pattern();
		string_3replace_();
		//binary_addition();
		long_integer_addition_bigInteger();
		long_mulplication_bigInteger();
		find_peek();
		move_negative_to_first();
		largest_sum_contiguous_subarray();
		
		//21/9/23
		poisonus_pig();
		laptop_required();
		coin_need();
		xpattern();
		xpattern_digit();
		middle_in_array_rabit_hare();
		
		//23/9/23
		odd_even_jump();
		
		String s ="syed";
		//System.out.println("L: "+s.substring(0,0)); /prints empty	
		zig_zag_pattern();
		open_the_lock();
		most_common_word();
		permute_string(("ABC").toCharArray(), 0);
		count_and_say();
		count_subarray_with_k_sum();
		prime();
		normalpattern();
		mitsogo1();
		mitsogo2();
		
		//27/9/23
		merge_intervals();
		find_word_in_2dArray_charachters();
		search_2d_matrix();
		mitsogo3();
		
		//19/10/23
		generate_paranthesis();
		house_robber();
		longest_substring_palindrome();
		
		//20/10/23
		vowel_consonat();
		word_latter();
		
		//21/10/23
		dictionary_words();
		ballons_1189();
		
		jump();
		

	}

}

/*

*/