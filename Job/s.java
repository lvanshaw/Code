import java.util.*;

public class s {
	
	public static void main(String[] args) {
		String a = "1";
		int n =5;
		/*
			1
			11
			21
			1211
			111221
		*/
		
		if(palindrom(0, "MADAM")){System.out.println("yes");}
		no_of_words();
		asteroidCollision();
		except_multiply();
		minimum_absolute_difference();
		longest_substring();
		//c*(a-b)/(b+1)
		min_climbing_stairs_price();
		string_decode();
		sort_012();
		
		anagaram_index();
		no_of_island();
	}
	public static void no_of_island(){
		int i[][] = {{1,1,1},{0,0,0},{1,1,1},{1,1,1}};
		int r = i.length;
		int c = i[0].length;
		int count = 0;
		for(int j =0; j<r; j++){
			for(int k = 0; k<c; k++){
				if(i[j][k] == 1){
					count++;
					area(i, j, k);
				}
			}
		}
		System.out.println("\nno_of_island: "+count);
	}
	public static void area(int g[][], int a, int b){
		if(a >=0 && a<g.length && b>=0 && b<g[0].length && g[a][b] != 0){
			g[a][b] = 0;
			area(g, a-1, b);
			area(g, a, b-1);
			area(g, a+1, b);
			area(g, a, b+1);
		}else{
			return;
		}
		
	}
	public static void anagaram_index(){
		String a = "bccabcsd", b ="abc";
		
		if(a.indexOf(b) != -1) System.out.println("-- i"+ a.indexOf(b));
		int n = a.length(), n1 = b.length();
		int chars_count[] = new int[26];
		Arrays.fill(chars_count, 0);
		for(int i =0; i<n1; i++){
			chars_count[(b.charAt(i) - 'a')] +=1;
		}
		System.out.println("");
		for(int i=0; i<chars_count.length; i++)
			System.out.print(chars_count[i]+" ");
		System.out.println("");
		int left = 0;
		int right = 0;
		int count =n1;
		while(right < n){
			
			if(chars_count[a.charAt(right++) - 'a']-- >= 1) count--;
			if(count == 0) System.out.print(left+" ");
			if(right - left == n1 && chars_count[a.charAt(left++) - 'a']++ >= 0) count++;
		}
	}
	public static void sort_012(){
		int a[] = {1,1,1,2,2,2,0,0,0};
		int n = a.length;
		int i =0, j=0, k=a.length-1;
		
		while(j <= k){
			if(a[j] == 0){
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;

				i++;
				j++;
			}else if(a[j] == 1){
				j++;
			}else{
				int temp = a[k];
				a[k] = a[j];
				a[j] = temp;

				k--;

			}
		}
		System.out.print("sort_012: ");
		for(int l=0; l<n; l++){
			System.out.print(a[l]+", ");
		}
		
	}
	
	public static void swap(int a[], int b, int c){
		int temp = a[b];
		a[b] = a[c];
		a[c] = a[b];
	}
		
	public static void string_decode(){
		String a = "3[ab2[v]]";
		
		Stack<Integer> num = new Stack<>();
		Stack<String> val = new Stack<>();
		int i =0, n = a.length();
		String res = "";
		while(i<n){
			if(Character.isDigit(a.charAt(i))){
				//System.out.println("inside number");
				int count =0;
				while(Character.isDigit(a.charAt(i))){
					count = 10*count+ (a.charAt(i)-'0');
					i++;
				}
				num.push(count);
			}
			else if(a.charAt(i) == '['){
				val.push(res);
				res ="";
				i++;
			}else if(a.charAt(i) == ']'){
				int c = num.pop();
				String q = val.peek();
				StringBuilder sb = new StringBuilder(val.pop());
				for(int j =0; j<c;j++){
					sb.append(res);
					
				}
				res = sb.toString();
				i++;
			}else{
				res+=String.valueOf(a.charAt(i));
				i++;
			}
		}
		System.out.println("\nstring_decode: "+res);
	}
	public static void min_climbing_stairs_price(){
		int a[] = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
		
		int n = a.length;
		
		
		for(int i =2; i<n;i++){
			a[i] += Math.min(a[i-2], a[i-1]);
		}
		System.out.println("min_climbing_stairs_price: "+ Math.min(a[n-1], a[n-2]));
		for(int i=0; i<n;i++)
		System.out.print(a[i]+",");
		
	}
	public static void longest_substring(){
		String a= "syed";
		int n =a.length(), j=0, max_length=0;
		Set<Character> s = new HashSet<>();
		for(int i=0; i<n; i++){
			char c = a.charAt(i);
			//System.out.println(a);
			if(s.contains(c)){
				s.remove(a.charAt(j++));
			}
			max_length = Math.max(max_length, i-j+1);
			s.add(c);
		}
		System.out.println("longest substring: "+ max_length);
	}
	public static void except_multiply(){
		int a[] = {1, 2, 3, 4};
		int n = a.length;
		int b[] = new int[n];
		int c[] = new int[n];
		b[0] = 1;
		c[n-1] = 1;
		int R = 1;
		for(int i=1; i<n;i++){
			//System.out.println(a[i-1]+" "+b[i-1]);
			b[i] = a[i-1]*b[i-1];
		}
		for(int i=n-1; i>0; i--){
			c[i-1] = a[i] * c[i];
		}
		/*
		for(int i = n-1; i>=0; i--){
			b[i] = b[i]*R;
			System.out.println(R+"*"+a[i]);
			R = R*a[i];
		} */
		
		
		
		System.out.println("except_multiply: "+Arrays.toString(b)+" "+Arrays.toString(c));
	}
	public static void minimum_absolute_difference(){
		int a[] = {1,4,2,5,55};
		
		Arrays.sort(a);
		int min_diff = Integer.MAX_VALUE;
		int n = a.length;
		for(int i =1; i<n; i++){
			min_diff = Math.min(min_diff, a[i]-a[i-1]);
		}
		System.out.println("min_diff: "+min_diff);
		for(int i=1; i<n;i++){
			int mins = a[i]-a[i-1];
			if(mins == min_diff) System.out.println(a[i-1]+" "+a[i]);
		}
		
	}
	public static void no_of_words(){
		String s = "Hello, iam Divan";
		int n = s.length();
		int count =0;
		for(int i=0; i<n; i++){
			if(s.charAt(i)==' '){
				count++;
			}
		}
		
		String trimmed = s.trim(); //first space last space clear
		String sa[] = trimmed.split("\\s");
		System.out.println("no_of_words: "+ ++count+ " "+trimmed.split("\\s").length+" "+ Arrays.toString(sa));
	}
	public static void asteroidCollision(){
		int asteroid[] = {3,2,1,-4};
		Stack<Integer> st = new Stack<>();
		
		for(int i =0; i<asteroid.length; i++){
			if(st.isEmpty() || asteroid[i] >0){
				st.push(asteroid[i]);
			}else{
				while(true){
					int peek = st.peek();
					if(peek<0){
						st.push(asteroid[i]);
						break;
					}else if(peek == -asteroid[i]){
						st.pop();
						break;
					}else if(peek > -asteroid[i]){
						break;
					}else{
						st.pop();
						if(st.isEmpty()){
							st.push(asteroid[i]);
							break;
						}
					}
				}
				
			}
		}
		System.out.println(st);
	}
	public static boolean palindrom(int n, String a){
		if(n<= a.length()/2) return true;
		
		if(a.charAt(n) != a.charAt(a.length()-n-1)){
			System.out.println("Not");
			return false;
		}
		return palindrom(n+1, a);
	}
	
}	


