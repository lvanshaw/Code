import java.util.*;
class zoho{
	
	public static void main(String args[]){
		zoho s = new zoho();
		//System.out.println("1: "+ s.zoh("abca"));
		//s.z(5);
		int b[] = {6,5,4,8};
		System.out.println("\n2: ");
		s.b(b);
		
		int nums[] = {0,2,1,5,3,4};
		System.out.println("\n8: ");
		s.a8(nums);
		
		int arr[] = {3,1,7,11};
		System.out.println("\n7: "+ s.a7(arr));
		System.out.println("9: "+ s.a9("aA", "aAAbbbb"));
		//int c[] = {0,3,2,1};
		//System.out.println("\n3: "+ s.c(c));
	}
	public int a9(String str1, String str2){
		int num =0;
		for(int i =0; i<str2.length(); i++){
			if(str1.indexOf(str2.charAt(i)) != -1){
				num++;
			}
		}
		return num;
	}
	
	public boolean a7(int[] arr){
		Arrays.sort(arr);
		for(int i =0 ; i< arr.length; i++){
			int target = 2 * arr[i];
			int lo =0, hi = arr.length -1;
			while(lo <= hi){
				int mid = lo + (hi-lo)/2;
				if(arr[mid]==target && mid != i)
					return true;
				if(arr[mid] < target)
					lo = mid + 1;
				else
					hi = mid - 1;
			}
		}
		return false;
	}
	public boolean zoh(String s){
		int i =0;
		int j = s.length()-1;
		
		while(i<=j){
			if(s.charAt(i) == s.charAt(j)){
				i++;
				j--;
			}
			else
				return help(s, i+1, j) || help(s, i, j-1);
		}
		return true;
	}
	
	public boolean help(String s, int i, int j){
		while(i <= j){
			if(s.charAt(i) == s.charAt(j)){
				i++;
				j--;
			}
			else
				return false;
		}
		return true;
		
	}
	public int[] b(int[] nums){
		System.out.print(Arrays.toString(nums));
		int[] temp = new int[101];
		System.out.print(Arrays.toString(temp));
		for(int i = 0; i<nums.length; i++)
			temp[nums[i]] +=1;
		System.out.print(Arrays.toString(temp));
		for(int j =1; j<=100; j++)
			temp[j] += temp[j-1];
		System.out.print(Arrays.toString(temp));
		for(int k =0; k<nums.length; k++){
			int pos = nums[k];
			
			nums[k] = pos == 0? 0: temp[pos-1];
		}
		System.out.print(Arrays.toString(nums));
		return nums;
	}
	public boolean c(int[] arr){
		if(arr.length < 3) return false;
		int l =0;
		int r = arr.length -1;
		while(l+1 < arr.length-1 && arr[l] < arr[l+1]) l++;
		while(r-1 > 0 && arr[r] < arr[r-1]) r--;
		return l == r;
	}
	public int[] z(int num){
		int[] f = new int[num+1];
		for(int i = 1; i<=num; i++) f[i] = f[i>>1] + (i & 1);
		for(int n : f){
			System.out.print(n+", ");
		}
		return f;
	}
	
	public int[] a8(int[] nums){
		int[] ans = new int[nums.length];
		for(int i=0; i<nums.length; i++)
			ans[i] = nums[nums[i]];
		for(int n : ans){
			System.out.print(n+", ");
		}
		return ans;		
	}
}