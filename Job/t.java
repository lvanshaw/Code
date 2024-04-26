import java.util.*;
public class t{
    static Vector<Integer> e = new Vector<>();
  static int maxn = 10;
   static Vector<Integer> []g = new Vector[maxn];
   static void add_edge(int u, int v)
  {
    g[u].add(v);
    g[v].add(u);
  }
  static boolean []visited = new boolean[maxn];
 
  // storing the dfs traversal
  // in the array e
  static void dfs(int src)
  {
    e.add(src);
    visited[src] = true;
    for (int i = 0; i < (g[src]).size(); i++)
    {
      int des = g[src].get(i);
      if (!visited[des])
      {
        dfs(des);
        e.add(src);
      }
    }
  }
  
   public static void main(String args[]){
        for (int i = 0; i < g.length; i++) {
            g[i] = new Vector<Integer>();
        }

        add_edge(1, 2);
    add_edge(1, 3);
    add_edge(1, 4);
    add_edge(3, 5);
   add_edge(3, 5);
   add_edge(5, 8);
    add_edge(5, 9);
    dfs(1);
    System.out.println(e);     

    for (int i = 0; i < e.size(); i++)
		System.out.print(e.get(i)+" ");

	range_min_query();
     }
	 
	public static void range_min_query(){
		int[][] a = { { 5, 8, 2, 4 },
                       { 7, 2, 9, 1 },
                       { 1, 4, 7, 3 },
                       { 3, 5, 6, 8 } };
					   
		for(int i =0; i<a.length; i++){
			for(int j = 1; j<a[0].length; j++){
				a[i][j] +=a[i][j-1];
			}
		}
		System.out.println("");
		for(int i =0; i<a.length; i++){
			for(int j = 0; j<a[0].length; j++){
				System.out.print(a[i][j]+" ");
			}
			System.out.println("");
		}
		for(int i =1; i<a.length; i++){
			for(int j = 0; j<a[0].length; j++){
				a[i][j] +=a[i-1][j];
			}
		}
		System.out.println("");
		for(int i =0; i<a.length; i++){
			for(int j = 0; j<a[0].length; j++){
				System.out.print(a[i][j]+" ");
			}
			System.out.println("");
		}
		
		int query[] = {1,1,2,2};
					// 0 1 2 3
		//int query[] = {0, 0, 3, 3};
					 //0  1  2  3 
		int row1 = query[0];
		int col1 = query[1];
		int row2 = query[2];
		int col2 = query[3];
		int total = a[row2][col2];
		int extra = 0;
		//int plus1 = (col1 != 0? a[row2][col1-1] : 0);
		//int plus2 = (row1 != 0? a[row1-1][col2] : 0);
		//int minus =((row1 != 0 && col1 != 0)? a[row1-1][col1-1] : 0); 
		
		//int extra = (col1 != 0? a[row2][col1-1] : 0)+ (row1 != 0? a[row1-1][col2] : 0)- ((row1 != 0 && col1 != 0)? a[row1-1][col1-1] : 0); 
		
		//int extra = plus1 + plus2 - minus;
		
		
		
		System.out.println("\n"+(total-extra));
	}
  }