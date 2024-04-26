import java.util.*;


class collecting_coins{
	static class Pair{
		int first;
		int second;
		Pair(int f, int s){
			first = f;
			second = s;
		}
	}
	
	public static void main(String args[]){
		/*
		7
1 1
2 2
3 3
2 4
1 5
4 2
5 1
		6
1 1
3 2
5 3
4 1
2 3
1 4
		*/
		//int Coins[][] = {{1,1}, {3,2}, {5,3}, {4,1}, {2,3},{1,4}}; //4
		//int n =6;
		int Coins[][] = {{1,1}, {2,2}, {3,3}, {2,4}, {1,5},{4,2}, {5, 1}}; //5
		int n =7;
		int island[][] = new int[n][n];
		int result[] = new int[Coins.length];
		for(int i=0; i<n;i++){
			island[Coins[i][0]][Coins[i][1]] = 1;
		}
		
		for(int i=0; i<n; i++){
			for(int j =0; j<n;j++){
				System.out.print(island[i][j]+" ");
			}
			System.out.print("\n");
		}
		
		HashMap<Integer, List<Integer>> map = new HashMap<>();
		
		
		for(int i = 0; i < Coins.length; i++) {
			int coinValue = Coins[i][0];
			int associatedValue = Coins[i][1];
			
			if (map.containsKey(coinValue)) {
				map.get(coinValue).add(associatedValue);
			} else {
				List<Integer> associatedValues = new ArrayList<>();
				associatedValues.add(associatedValue);
				map.put(coinValue, associatedValues);
			}
		}
		
		for (Integer key : map.keySet()) {
			System.out.print("Coin value " + key + ": ");
			List<Integer> values = map.get(key);
			for (Integer value : values) {
				System.out.print(value + " ");
			}
			System.out.println();
		}
		for(int i = 0; i < Coins.length; i++) {
			int row = Coins[i][0];
			int col = Coins[i][1];
		
			int right = 1, left= 1, up=1, down= 1, leftd=1, rightd= 1, downld=1, downrd= 1;
			
			//right -> col ++
			List<Integer> values = map.get(row);
			for (Integer value : values) {
				if(col < value)
					right++;
				if(col > value)
					left++;
				//System.out.print(value + " ");
			}
				
			//left -> col --
			
			//up -> row --
			for (Integer key : map.keySet()) {
				if(row > key){
					List<Integer> valuess = map.get(key);
					int dif = row-key;
					for (Integer value : valuess) {
						if(col-dif == value)
							leftd++;
						if(col+dif == value)
							rightd++;
						//System.out.print(value + " ");
					}
					for (Integer value : valuess) {
						if(col == value){
							up++;
							break;
						}
						//System.out.print(value + " ");
					}
				}
				if(row < key){
					List<Integer> valuess = map.get(key);
					for (Integer value : valuess) {
						int dif = key-row;
						if(col == value)
							down++;
						if(col-dif == value)
							downld++;
						if(col+dif == value)
							downrd++;
						//System.out.print(value + " ");
					}
				}
			}
			
			//down -> row ++
			//leftd -> row-- col--
			
			//rightd -> row-- col++
			//downld -> row++ col --
			
			//downrd -> row++ col++
			
			System.out.println(right+" "+left+" "+ up+" "+ down+" "+ leftd+" "+ rightd+" "+ downld+" "+ downrd);
			int[] valuesss = {right, left, up, down, leftd, rightd, downld, downrd};

			Arrays.sort(valuesss);

			int max = valuesss[valuesss.length - 1];

			System.out.println("Maximum value: " + max);
			result[i] = max;
			
		}
		Arrays.sort(result);
		int max = result[result.length - 1];

		System.out.println("Result: " + max);
	}
	public static void works(){
				int Coins[][] = {{1,1}, {2,2}, {3,3}, {2,4}, {1,5},{4,2}, {5, 1}}; //5
		int n =7;
		int island[][] = new int[n][n];
		int result[] = new int[Coins.length];
		for(int i=0; i<n;i++){
			island[Coins[i][0]][Coins[i][1]] = 1;
		}
		
		for(int i=0; i<n; i++){
			for(int j =0; j<n;j++){
				System.out.print(island[i][j]+" ");
			}
			System.out.print("\n");
		}
		
		HashMap<Integer, List<Integer>> map = new HashMap<>();
		
		
		for(int i = 0; i < Coins.length; i++) {
			int coinValue = Coins[i][0];
			int associatedValue = Coins[i][1];
			
			if (map.containsKey(coinValue)) {
				map.get(coinValue).add(associatedValue);
			} else {
				List<Integer> associatedValues = new ArrayList<>();
				associatedValues.add(associatedValue);
				map.put(coinValue, associatedValues);
			}
		}
		
		for (Integer key : map.keySet()) {
			System.out.print("Coin value " + key + ": ");
			List<Integer> values = map.get(key);
			for (Integer value : values) {
				System.out.print(value + " ");
			}
			System.out.println();
		}
		for(int i = 0; i < Coins.length; i++) {
			int row = Coins[i][0];
			int col = Coins[i][1];
		
			int right = 1, left= 1, up=1, down= 1, leftd=1, rightd= 1, downld=1, downrd= 1;
			
			//right -> col ++
			List<Integer> values = map.get(row);
			for (Integer value : values) {
				if(col < value)
					right++;
				//System.out.print(value + " ");
			}
				
			//left -> col --
			for (Integer value : values) {
				if(col > value)
					left++;
				//System.out.print(value + " ");
			}
			//up -> row --
			for (Integer key : map.keySet()) {
				if(row > key){
					List<Integer> valuess = map.get(key);
					for (Integer value : valuess) {
						if(col == value)
							up++;
						//System.out.print(value + " ");
					}
				}
			}
			
			//down -> row ++
			for (Integer key : map.keySet()) {
				if(row < key){
					List<Integer> valuess = map.get(key);
					for (Integer value : valuess) {
						if(col == value)
							down++;
						//System.out.print(value + " ");
					}
				}
			}
			//leftd -> row-- col--
			for (Integer key : map.keySet()) {
				if(row> key){
					List<Integer> valuess = map.get(key);
					int dif = row-key;
					for (Integer value : valuess) {
						if(col-dif == value)
							leftd++;
						//System.out.print(value + " ");
					}
				}
			}
			//rightd -> row-- col++
			for (Integer key : map.keySet()) {
				if(row> key){
					List<Integer> valuess = map.get(key);
					int dif = row-key;
					for (Integer value : valuess) {
						if(col+dif == value)
							rightd++;
						//System.out.print(value + " ");
					}
				}
			}
			//downld -> row++ col --
			for (Integer key : map.keySet()) {
				if(row< key){
					List<Integer> valuess = map.get(key);
					int dif = key-row;
					for (Integer value : valuess) {
						if(col-dif == value)
							downld++;
						//System.out.print(value + " ");
					}
				}
			}
			//downrd -> row++ col++
			for (Integer key : map.keySet()) {
				if(row< key){
					List<Integer> valuess = map.get(key);
					int dif = key-row;
					for (Integer value : valuess) {
						if(col+dif == value)
							downrd++;
						//System.out.print(value + " ");
					}
				}
			}

			System.out.println(right+" "+left+" "+ up+" "+ down+" "+ leftd+" "+ rightd+" "+ downld+" "+ downrd);
			int[] valuesss = {right, left, up, down, leftd, rightd, downld, downrd};

			Arrays.sort(valuesss);

			int max = valuesss[valuesss.length - 1];

			System.out.println("Maximum value: " + max);
			result[i] = max;
			
		}
		Arrays.sort(result);
		int max = result[result.length - 1];

		System.out.println("Result: " + max);

	}
	/*
	int island[][] = new int[n][n];
		
		for(int i=0; i<n;i++){
			island[Coins[i][0]][Coins[i][1]] = 1;
		}
		
		for(int i=0; i<n; i++){
			for(int j =0; j<n;j++){
				System.out.print(island[i][j]+" ");
			}
			System.out.print("\n");
		}
		
		int visited[][] = new int[island.length][island[0].length];
		int count =0;
		for(int i =0; i<island.length; i++){
			for(int j =0; j<island[0].length; j++){
				if(island[i][j] == 1){
					count++;
					int right = 0;
					int left = 0;
					int top = 0;
					int down = 0;
					System.out.println("position: "+ i+" "+ j+" values: " +top +" " + right+" " +down+" " +left);
					//right
					
					for(int k = i; k< island.length; k++){
						if(island[i][k] == 1)  right++;
					}
					
					for(int k = i ; k>=0; k--){
						if(island[i][k] == 1) left++;
					}
					
					for(int k = j ; k>=0; k--){
						if(island[k][i] == 1) top++;
					}
					
					for(int k = j ; k<island[0].length; k++){
						if(island[k][i] == 1) down++;
					}
					
					
					System.out.println(top +" " + right+" " +down+" " +left);
					
					//bfs_island(island, visited, i , j);
				}
			}
		}
		//System.out.println("number_of_islands_bfs: "+count +" "+ sum);
	*/
	static int sum =0;
	public static void bfs_island(int land[][], int v[][], int i, int j ){
		Queue<Pair> q = new LinkedList<Pair>();
		v[i][j] = 1;
		q.add(new Pair(i, j));
		int s = 0;
		while(!q.isEmpty()){
			int currentr = q.peek().first;
			int currentc = q.peek().second;
			System.out.println(currentr+":"+currentc);
			s++;
			q.remove();
			
			
			
			
			for(int delrow = -1 ; delrow <=1; delrow++){
				for(int delcol = -1 ; delcol <= 1; delcol++){
					
					int r = delrow + currentr; //System.out.println(delrow+"+"+currentr);
					int c = delcol + currentc;
					int op = 0;
					if(c >=0 && c<land[0].length && r >= 0 && r<land.length  && land[r][c] == 1){
						//System.out.println(r+" -- "+c);
						int pp =0;
						for(int k = r; k< 6; k++){
							System.out.print(land[k][c]+", ");
							if(land[k][c] == 1) pp++;
						}
						System.out.println();
						op  = Math.max(pp, op);
					}
					//System.out.println(op);
					if(false && c >=0 && c<land[0].length && r >= 0 && r<land.length && v[r][c] == 0 && land[r][c] == 1){
						v[r][c] = 1;
						sum = Math.max(s, sum);
						System.out.println("sum: "+sum);
						q.add(new Pair(r, c));
					}
				}
			}
		}
		System.out.println();
		//sum = Math.max(s, sum);
	}
}