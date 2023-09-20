class solution{
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
		
		System.out.println("s".matches("[a-z]+"));
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
	}
}