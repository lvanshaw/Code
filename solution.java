class solution{
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
	}
}
