import java.util.*;

class zohol2{
	static String alphabet = "abcdefghijklmnopqrstuvwxyz";
	public static void main(String args[]){
		int j =0;
		forbex();
		sub_array();
		number_alpha();
	}
	
	
	public static void number_alpha(){
		reverse(new int[] {1,2,2},0, "");
	}
	public static void reverse(int a[], int index, String output){
		if(index == a.length){
			System.out.println(output);
			return;
		}
		int sum =0;
		for(int i =index; i<=a.length-1; i++){
			sum = sum * 10 + a[i];
			if(sum >0 && sum<=26)
				reverse(a, i+1, output+ alphabet.charAt(sum-1));
		}
	}
	public reverse_to_same_size(){
		int a[] = {1,2,4,15,8};
		int n = a.length;
		int max = a[0]
		for(int i = 0; i<n ; i++){
			if(a[i] < max){
				max = a[i];
			}
		}
		int size = max.toString().length();
		
	}
	public static void sub_array(){
		//int a[] = {2,5,3,8,9,1,0,5,8,3};
		//int b[] = {3,8,5};
		int a[] = {2,5,8,9,3,1,0,5,8,3};
		int b[] = {3,8,5};
		//int a[] = {-1,-4,-5,-6,-8,-10,-20,-2};
		//int b[] = {1,2,3,4};
		int n2 = b.length;
		HashSet <Integer> set = new HashSet<>();
		for(int i =0; i<n2; i++){
			set.add(b[i]);
		}
		for(int i =0; i<= a.length-n2; i++){
			boolean t = false;
			if(set.contains(a[i]) && a[i] != a[i+1] ){
				for(int j=i; j< i+n2; j++){
					if(set.contains(a[j])){
						t = true;
					}else{
						t = false;
						break;
					}
				}
				if(t) System.out.println(i + " "+ (i+n2));
			}
		}
	}
	public static void forbex(){
		int profit = 0;
		//int a[] = {1,5,2,2,7,6,4,9};
		int a[]={5,5,10,8,7,6,4,5,2,6,1,1,10};
		int n = a.length;
		int i =0;
		for(i =0; i<n; i++){
			for(int j = i; j<n-1; j++){
				if((a[i] < a[j] && a[j] > a[j+1])){
					
					System.out.println(a[i] + " " + " "+ a[j] + "  " +(a[j] - a[i]));
					profit += a[j]-a[i];
					i = j;
					break;
				}
			}
			if(i == n-2 && a[i] < a[n-1]){
				System.out.println(a[i] + " " + " "+ a[n-1] + "  " +(a[n-1] - a[i]));
				profit += a[n-1]-a[i];
			}
		}
		
		System.out.println("forbex profit: "+ profit);
	}
}