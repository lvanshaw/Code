import java.util.*;


public class countandsay{
	public static void main(String args[]){
		//countas();
		xpattern();
		pattern();
	}
	public static void pattern(){
		int n = 5;
		for(int i =0; i<n; i++){
			for(int j=0; j<2*i+1; j++){
				System.out.print(Math.abs(j-1)+" ");
			}
			System.out.println("");	
		}
	}
	public static void xpattern(){
		int n =5;
		
		for(int i =1; i<=n; i++){
			for(int j=1; j<=n; j++){
				if(i == j) System.out.print(j);
				else if(n-i+1 == j) System.out.print(j);
				else System.out.print(" ");
			}
			System.out.println("");
		}
	}
	public static void countas(){
		String a = "11";
		int j = 1, n = 5;
		while(j <=n){
			int len = a.length();
			int count = 1;
			StringBuilder res= new StringBuilder();
			int i =1;
			for( i=1;i<len;i++){
				if(a.charAt(i-1) == a.charAt(i)){
					count++;
				}else{
					res.append(count);
					res.append(a.charAt(i-1));		
					count = 1;
				}
			}
			res.append(count);
			res.append(a.charAt(i-1));
			a = res.toString();
			System.out.println("res: "+res);
			j++;
		}
		
	}
}