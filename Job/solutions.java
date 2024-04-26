import java.util.*;


import java.util.*;
class solutions {
	
	public static void zig_zag_pattern(){
		String a = "zigzag";
		int n = a.length();
		int m = 3;
		 
	}
	public static void climbing_stairs_price(){
		//int a[] = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
		int a[] = {10, 15, 20};
		for(int i  =2 ; i< a.length; i++){
			a[i] += Math.min(a[a.length-1], a[a.length-2]);
		}
		for(int i = 0; i< a.length; i++)
			System.out.print(a[i]+ ", ");

	}
	public static int climbing_stairs(int n){
		if(n < 2) return 1;
		return climbing_stairs(n-1) + climbing_stairs(n-2);
	}
	public static void number_of_char_string(){
		String a1  = "aaabbbvvvz";
		String b1 = "aaabbvv";
		String r = "";
		char a[] = a1.toCharArray();
		char b[] = b1.toCharArray();
		
		int count = 1;
		int n = a1.length(),n1 = b1.length(); 
		for(int i = 0;i<n-1;i++){
			if(a[i] == a[i+1]){
				count++;
			}else{
				r+=a[i]+""+count;
				count=1;
			}
				
		}
		r+=a[n-1]+""+count;
		System.out.println(r);
	}
	public static void longest_substring_distinct_s(){
		String a = "geeksforgeeks";
		//String a = "syedss";
		int n = a.length();
		int max = 0;
		int start = 0, end = 0;
		HashMap<Character,Integer> h = new HashMap<>();
		for(int i = 0;i < n;i++){
			for(int j = i;j<n;j++){
				//System.out.print(a.charAt(j));
				if(!(h.containsKey(a.charAt(j)))){
					h.put(a.charAt(j), j);
					//max = Math.max(max, h.size());
					if(max < h.size()){
						start = i; end = j;
						max = h.size();
						//System.out.println(start+", "+end);
					}
				}else{
					break;
				}
			}
			h.clear();
			//System.out.println();
		}
		System.out.println("longest_substring_distinct_s: geeksforgeeks => "+a.substring(start, end+1)+" length: "+ max);
	}
	public static void rooms_keys(){
		List<List<Integer>> rk = new ArrayList(){{
			add(new ArrayList<Integer>(){{add(1);}});
			add(new ArrayList<Integer>(){{add(2); }});
			//add(new ArrayList<Integer>(){{}});
			//add(new ArrayList<Integer>(){{}});
		}};
		boolean visited[] = new boolean[rk.size()];
		visited[0] = true;
		for(int i =0;i<rk.size();i++){
			for(int keys: rk.get(i)){
				//System.out.print(keys+" ");
				visited[keys] = true;
			}
			//System.out.println();
		}
		for( int i=0;i<visited.length;i++){
			if(!(visited[i])){ System.out.println("there is a room locked: " + i ); return; }
		}
		System.out.println("all room unlocked");
		System.out.println(rk);
	}
	public static void longest_substring_distinct(){
		String s = "abcbeabcd";
		int i=0,j=0;
		int max = 0;
		HashSet <Character> r = new HashSet<>();
		
		while(j<s.length()){
			if(!(r.contains(s.charAt(j)))){
				r.add(s.charAt(j));
				j++;
				max = Math.max(r.size(), max);
			}else{
				r.remove(s.charAt(i));
				i++;
			}
		}
		System.out.println("longest_substring_distinct: "+max);
		}
	public static void list_pascal(){
		System.out.print("list pascal: ");
		List<List<Integer>> triangle = new ArrayList();
		List<Integer> frow = new ArrayList();
		frow.add(1);
		triangle.add(frow);
		int n = 5;
		for(int i = 1;i<n;i++){
			List<Integer> prev_row = triangle.get(i-1);
			List<Integer> row = new ArrayList();
			row.add(1);
			for(int j = 1; j<i;j++){
				row.add(prev_row.get(j-1)+prev_row.get(j));
			}
			row.add(1);
			triangle.add(row);
		}
		System.out.println(triangle);
	}
	public static int  fact(int n){
		if(n == 0) return 1;
		return n*fact(n-1);
	}
	public static void pascal(){
		System.out.println("pascal:");
		int n = 5;
		for(int i = 0;i<n;i++){
			for(int j =0;j<n-i;j++){
				System.out.print(" ");
			}
			for(int j=0;j<=i;j++){
				System.out.print(fact(i)/(fact(i-j)*fact(j)));
			}
			System.out.println();
		}
	}
	public static void max_product_subset(){
		//int a[] = {-6, 4,-5,8,-10,0,8}; //15360
		int a[] = {-1,-1,-2,4,3};
		int n = a.length;
		int zero_count = 0;
		int negative_count = 0;
		int product = 1;
		int max_negative = Integer.MAX_VALUE;
		for(int i = 0 ; i< n;i++){
			if(a[i] == 0){
				zero_count++;
				continue;
			}
			if(a[i] < 0){
				negative_count++;
				max_negative = Math.min(Math.abs(a[i]), max_negative);
			}
			product = product * a[i];
		}
		if(zero_count == n){ System.out.println("product of subset: 0"); return; }		
		else if(negative_count == 1 && zero_count+negative_count==n){
			System.out.println("product of subset: 0") ; 
			return;
		}
		else if ((negative_count&1) !=0){
			product = product/-max_negative;
		}
		//System.out.println("\nis it: "+negative_count +" ,"+(negative_count&1));
		System.out.println("\nproduct of subset: "+product);
	}
	public static void one_swap(){
		System.out.print("one swap: ");
		int a[] = {3, 5, 6, 9, 8, 7};
		int x = -1, y = -1, prev = a[0];
		int n = a.length;
		for(int i =1;i<n;i++){
			if (prev > a[i]){
				if(x == -1){
					x = i-1;
					y = i;
				}else y = i;
			}
			prev = a[i];
		}
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
		
		for(int i = 0;i<n;i++)
			System.out.print(a[i]+" ");
	}
	public static void equlibrium_index(){
		int a[] = {-7, 1,5,2,-4,3,0};
		int n = a.length;
		
		for(int i = 0;i<n;i++){
			int l=0,r=0;
			for(int left = 0;left <i ;left++) l+=a[left];
			for(int right = i+1;right < n;right++) r+=a[right];
			if(l == r){
				System.out.println("equlibrium_index: "+ i);
				return;
			}
		}
	}
	public static void largest_sum_contigous_subarray(){
		int a[]={-2, -3, 4, -1, -2, 1, 5, -3 };
		int max = Integer.MIN_VALUE;
		int up_to_max = 0;
		int n = a.length;
		for(int i =0;i<n;i++){
			up_to_max +=a[i];
			if(up_to_max < a[i]){
				up_to_max = a[i];
			}
			if(max < up_to_max){
				max = up_to_max;
			}
		}
		System.out.println("largest_sum_contigous_subarray :"+ max);
	}
	public static void all_duplicate_in_array(){
		int a[] = {4,3,2,7,8,2,3,1};
		int n = a.length;
		List<Integer> list = new ArrayList();
		for(int i=0;i<n;i++){
			int index = Math.abs(a[i]) -1;
			if(a[index] < 0) list.add(index+1);
			a[index] = - a[index];
		}
		
		System.out.println("duplicate in array"+list);
	}
	public static void subarray_with_zero_position(){
		int a[] = {6,3,-4,-4,-1};
		int n = a.length;
		for(int i=0;i<n;i++){
			int sum=0;
			for(int j =i;j<n;j++){
				sum+=a[j];
				if(sum == 0)
					System.out.println("subarray sum zero position :"+ i+", "+j);
			}
		}
	}
	public static void subarray_with_zero(){
		int a[] = {6,3,-4,4};
		int n = a.length;
		
		Set<Integer> s = new HashSet<>();
		s.add(0);
		int sum=0;
		for(int i=0;i<n;i++){
			sum+=a[i];
			if(s.contains(sum)) {
				System.out.println("subarray sum zero contains");
				return;
			}
			s.add(sum);
		}
	}
	public static void give_two_sum(){
		int a[] = {1,4,2,6,2,8,};
		int target = 10;
		for(int i =0;i<a.length;i++) System.out.print(a[i]+" ");
		System.out.print("\n");
		Arrays.sort(a);
		int low = 0, high = a.length - 1;
		for(int i =0;i<a.length;i++) System.out.print(a[i]+" ");

		while(low < high){
			if(a[low]+a[high] == target){
				System.out.println("pair :"+low +" "+high+" = "+a[low] +" "+a[high]);
			return;
			}
			if(a[low]+a[high] < target) low++;
			else high--;
		}
	}
	public static void main(String args[]){
		
		give_two_sum();
		subarray_with_zero();
		subarray_with_zero_position();
		all_duplicate_in_array(); 
		largest_sum_contigous_subarray();
		//kadanes algorithm
		//longest_number()
		equlibrium_index();
		one_swap();
		max_product_subset();
		pascal();
		list_pascal();
		longest_substring_distinct();
		rooms_keys();
		longest_substring_distinct_s();
		System.out.println("climbing_stairs ways: "+ climbing_stairs(5));
		climbing_stairs_price();
		
		number_of_char_string(); //aaabbb a3b3
		if(true) System.out.println("hel0");
		else if(true) System.out.println("s");
	}
}