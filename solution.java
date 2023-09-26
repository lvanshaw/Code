class solution{
	public static void chess_moving(){
		System.out.print("\nchess_moving: \n");
		int d[] = {2,2}, s[] = {3,3};
		int count = 0;
		while(s[0] != d[0] || s[1] != d[1]){
			if(s[0] < d[0] && s[1] < d[1]){
				s[0]++;
				s[1]++;
				count++;
				System.out.println(s[0]+" "+s[1]);
			}else if(s[0] > d[0] && s[1] < d[1]){
				s[0]--;
				s[1]++;
				System.out.println(s[0]+" "+s[1]);
				count++;
				
			}else if(s[0] > d[0] && s[1] > d[1]){
				s[0]--;
				s[1]--;
				System.out.println(s[0]+" "+s[1]);
				count++;
				
			}else if(s[0] < d[0] && s[1] > d[1] ){
				s[0]++;
				s[1]--;
				System.out.println(s[0]+" "+s[1]);
				count++;				
			}else if(s[0] < d[0] ){
				s[0] = s[0]+1;
				s[1] = s[1]+1;
				count++;
			}
			else if( s[1] < d[1]){
				s[1] = s[1]+1;
				count++;
			}
			else if(s[0] > d[0] ){
				s[0] = s[0]-1;
				s[1] = s[1]-1;
				count++;
			}
			else if( s[1] > d[1]){
				s[1] = s[1]-1;
				count++;
			}else { break;}
		}
		System.out.println(s[0]+" "+s[1]+"\n"+d[0]+" "+d[1]+" \ncount: "+count);
	}
	public static void choloate_distribution(){
		int a[] = {12, 4, 7, 9, 2, 23, 25, 41, 30, 40, 28, 42, 30, 44, 48, 43, 50} , m = 7 ;
		int n = a.length;
		int ans = Integer.MAX_VALUE;
		Arrays.sort(a);
		System.out.print("\ncholoate_distribution: \n");
		for(int i = 0; i<n-m+1;i++){
			//System.out.println(a[i]);
			int def = a[i+m-1] - a[i];
			if(def < ans) ans = def;
			
		}
		System.out.println(ans);
	}
	public static int sum_of_numbers(int n){
		if(n < 10) return n;
 		return (n%10)+sum_of_numbers(n/10);
		//return 1+sum_of_numbers(n-1) //sum of numbers
	}
	public static void merge_arrays(){
		int a[] = {1,2,3,4}, m = 4, b[] = {2,5,6}, n = 3;
		int rr[] = new int[m+n];
		int l = 0, r = 0;
		int count = 0;
		
		while(l < m && r < n){
			if(a[l] < b[r]){
				rr[count] = a[l];
				count++;
				l++;
			}else{
				rr[count] = b[r];
				count++;
				r++;
			}
		}
		while(l < m) rr[count++] = a[l++];
		while(r < n) rr[count++] = b[r++]; 
		System.out.println(r);
		for(int i = 0 ; i<rr.length ;i++){
			System.out.print(rr[i]+" ");
		}
	}
	public static void merging_overlap_array(){
		int[][] a = {{1, 3}, {8, 10}, {2, 6}, {15, 18}};
		int n = a.length;
		Arrays.sort(a, (b,c) -> b[0] - c[0]);
		/*for(int i = 0 ;i< n; i++ ){
			System.out.println(a[i][0]);
		}*/
		
		int index = 0;
		while(index < n){
			int start = a[index][0];
			int end = a[index][1];
			
			while(index < n-1 && end >= a[index+1][0]){
				end = Math.max(end , a[index+1][1]);
				index++;
			}
			System.out.println(start+" "+end);
			
			index++;
		}
	}
	public static void unique_(){
		int a[] = {1,1,2,2,3,4};
		int n = a.length;
		int res[] = new int[n+1];
		for(int i=0; i<n ;i++){
			res[a[i]]++;
		}
		System.out.print("\n");
		for(int i = 1 ; i<n ;i++){
			if(res[i] == 1) System.out.print(i+" ");
		}
	}
	public static void unique(){
		int a[] = { 2, 3, 5, 4, 5, 3, 4 };
		int n = a.length;
		int unique = a[0];
		for(int i = 1 ;i<n;i++){
			unique = unique ^ a[i];
		}
		System.out.print("\n"+unique);
	}
	public static void leader_in_array(){
		int a[] = {16, 17, 4, 3, 5, 2}; //17, 5, 2
		int n = a.length;
		int j = 0;
		for(int i = 0 ; i<n; i++ ){
			for(j = i ; j<n;j++){
				if(a[i] < a[j]) break;
			}
			if(j ==n) System.out.print(a[i]+" ");
		}
		int max = a[n-1];
		System.out.print("\n"+max+" ");
		for(int i = n-2; i>0; i--){
			if(a[i] > max){
				max = a[i];
				System.out.print(a[i] +" ");
			}
		}
	}
	public static void pattern(){
		int n = 5;
		int c = 1;
		for(int i =0; i<n;i++){
			
			for(int j = 0; j<n-i;j++) System.out.print(" ");	
			
			for(int k =0; k<((2*i)-1);k++){
				System.out.print(c);
				int m = ((2*i)-1)/2;
				if(k < m) c++;
				else c--;
			}
			c = i+1;
			System.out.println("");
			
		}
		
		//System.out.println("s".matches("[a-z]+")); //true
	}
	public static void subarray_sum_equal_to_k(){
				  //0   1, 2, 3, 4, 5, 6,  7
		int a[] = { 15, 2, 4, 8, 9, 5, 10, 23 };
		int n = a.length; 
		int sum = 23;
		int max = a[0];
		int start = 0;
		for(int i = 1; i < n; i++){
			while(max > sum && start < i -1){
				max = max - a[start];
				start++;
			}
			if(max == sum ){
				System.out.println(start+" "+(i-1));
				break;
			}
			if(i<n) max+=a[i];
		}
	}
	public static void main(String args[]){
		subarray_sum_equal_to_k();
		pattern();
		leader_in_array();
		unique();
		unique_();
		System.out.println("");
		merging_overlap_array();
		merge_arrays();
		System.out.print("\n"+ sum_of_numbers(115));
		
		choloate_distribution();
		chess_moving();
	}
}
