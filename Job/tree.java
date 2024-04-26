import java.util.*;
class tree{
	/*
	1.	level_order_traversal
	2.	depth
	3.	invert_tree
	4.	root to node
	5.	vertical order
	6.	zig zag order
	7.	lowest common ancestor
	8.	diameter of tree
	9.	balanced binary tree
			The height of the left and right tree for any node does not differ by more than 1.
			The left subtree of that node is also balanced.
			The right subtree of that node is also balanced.
			
			
	1.	list has a cycle
	*/
	static class node{
		int val;
		node left, right;
		node(int x){
			val = x;
			left = null;
			right = null;
		}
	}
	static class pair{
		node _n;
		int lv;
		pair(node _node, int level){
			_n = _node;
			lv = level;
		}
	}
	static class list{
		int v;
		list next;
		list(){}
		list(int n ){
			v = n;
			next = null;
		}
	}
	public static void balance(boolean c){
		if(c){
			System.out.println("balanced tree");
		}else{
			System.out.println("not balanced tree");
		}
	}
	public static void main(String args[]){

		node root = createtree();
		node root1 = createtree();
		node balanced_t = balanced_tree();
		
		
		int depth = depth_of_tree(root1);
		System.out.println("depth_of_tree: "+depth);
		level_order_traversal(root1);
		length_of_tree(root.left, 1); //returns total size, left+right -> max is called diameter
		top_view(root);
		
		node inverttree = invert_tree(root);
		System.out.print("invert_tree: ");
		level_order_traversal(inverttree);
		
		zigzag_order_traversal(inverttree);
		
		list lst = createlist();
		//list_iterator(lst);
		list kth_node = remove_kth_node_from_list(lst, 3);
		list_iterator(kth_node);
		
		
		//root to node
		ArrayList<Integer> path = new ArrayList<>();
		ArrayList<Integer> path1 = new ArrayList<>();
		node_to_path(root1, path, 4);
		node_to_path(root1, path1, 5);
		print_arraylist(path);
		print_arraylist(path1);
		
		node ancestor = lowest_common_ancestor(root1, 6,7);
		System.out.println("\nlowest_common_ancestor: "+ ancestor.val);
		
		System.out.println("\ndiameter_of_tree: "+diameter_of_tree(root1.left));
		
		
	}
	
	

	//balanced subtree 1,
	//the subtree height of left and right <=1
	public static boolean isBalanced(node root) {
        if(root == null) return true;
        //if(dfsheight(root) == -1) return false;
        
        int le = depth_of_tree(root.left);
        int ri = depth_of_tree(root.right);

        if(Math.abs(le-ri) > 1) return false;
        boolean left = isBalanced(root.left);
        boolean right = isBalanced(root.right);
        if(!left || !right) return false;
        
        return true;
    }
    //2,
    public static int dfsheight(node r){
        if(r == null) return 0;

        int l = dfsheight(r.left);
        if(l == -1) return -1;
        int re = dfsheight(r.right);
        if(re == -1) return -1;
        if(Math.abs(l-re)>1) return -1;
        return 1+Math.max(l,re);
    }
	
	
	public static int diameter_of_tree(node head){
		
		if(head == null) return 0;
		int max = 0;
		int lh = depth_of_tree(head.left);
		int rh = depth_of_tree(head.right);
		max = Math.max(max, lh+rh);
		diameter_of_tree(head.left);
		diameter_of_tree(head.right);
		//System.out.println("\ndiameter_of_tree: "+max);
		return max;
	}
	//height of tree;
	public static int length_of_tree(node path1, int d){
		if(path1 == null) return 0;
		int lh = length_of_tree(path1.left, d);
		int rh = length_of_tree(path1.right, d);
		d = Math.max(d, lh+rh);
		System.out.println(d);
		return 1+(Math.max(lh, rh));
	}
	
	public static int depth_of_tree(node path1){
		if(path1 == null) return 0;
		return 1+(Math.max(depth_of_tree(path1.left), depth_of_tree(path1.right)));
	}
	public static node lowest_common_ancestor(node head, int a, int b){
		if(head == null) return head;
		
		if(head.val == a) return head;
		if(head.val == b) return head;
		node left = lowest_common_ancestor(head.left, a, b);
		node right = lowest_common_ancestor(head.right, a, b);
		
		if(left == null) return right;
		else if(right == null) return left;
		else return head;
	}
	
	
	
	
	public static boolean node_to_path(node head, ArrayList<Integer> path, int x){
		if(head == null) return false;
		path.add(head.val);
	
		if(head.val == x) return true;
		if(node_to_path(head.left, path, x) || node_to_path(head.right, path, x)){
			return true;
		}
		path.remove(path.size()-1);
		return false;
	}
	
	public static list remove_kth_node_from_list(list head, int n){
		//1 2 3 4 5 6
		//0 1 2 3 4 5
		System.out.println("\nremove_kth_node_from_list:");
		
		list dumy = new list();
		dumy.next = head;
		list slow = dumy;
		list fast = dumy;
		
		while(n>0){
			fast = fast.next;
			n--;
		}
		//System.out.println(fast.v);
		while(fast.next != null){
			fast = fast.next;
			slow = slow.next;
		}
		//System.out.println(slow.v);
		slow.next = slow.next.next;
		return head;
	}
	
	public static void zigzag_order_traversal(node head){
		node root = head;
		System.out.print("\nzigzag_tree: ");
		Queue<node> q = new LinkedList<>();
		q.add(root);
		boolean j =true;
		while(!q.isEmpty()){

			int size = q.size();
			
				int n[] = new int[size];
				for(int i =0; i<size; i++){
					
					node t = q.poll();
					int index = j?i:size-i-1;
					n[index] = t.val;
					//System.out.print(t.val+", ");
					if(t.right != null) q.add(t.right);
					if(t.left != null) q.add(t.left);
				}
				j = !j;
			System.out.print(Arrays.toString(n)+" ");
			
		}	
	}
	public static void level_order_traversal(node head){
		node root = head;
		int level = 0;
		Queue<node> q = new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()){
			int n = q.size();
			for(int i =0; i<n; i++){
				node t = q.poll();
				System.out.print(t.val+", ");
				if(t.left != null) q.add(t.left);
				if(t.right != null) q.add(t.right);
			}
			level++;
		}
		System.out.println("level (depth): "+level);
	}
	public static void top_view(node head){
		node root = head;
		Queue<pair> q = new LinkedList<>();
		q.add(new pair(root, 0));
		HashMap<Integer, Integer> map = new HashMap<>();
		HashMap<Integer, ArrayList<Integer>> vertical = new HashMap<>();
		int mn = 0, mx = 0;
		while(!q.isEmpty()){
			//q.add(root);
			pair temp = q.poll();
			if(map.get(temp.lv) == null) map.put(temp.lv, temp._n.val);
			if(!vertical.containsKey(temp.lv)){
				vertical.put(temp.lv, new ArrayList<>());
			}
				vertical.get(temp.lv).add(temp._n.val);
			
			if(temp._n.left != null) q.add(new pair(temp._n.left, temp.lv -1));
			if(temp._n.right != null) q.add(new pair(temp._n.right, temp.lv +1));
			if(mn > temp.lv) mn = temp.lv;
			else if(mx < temp.lv) mx = temp.lv;
		}
		
		
		System.out.println("\nvertical level order: "+vertical+"\nlevels: "+mn+", "+mx+"\nTOP View map: "+map);
		
		
	}
	public static node invert_tree(node root){
		if(root == null) return root;

		node left = invert_tree(root.left);
		node right = invert_tree(root.right);

		root.right = left;
		root.left = right;
		return root;
	}
	
	public static void print_arraylist(ArrayList<Integer> a){
		int n = a.size();
		for(int c : a){
			System.out.print(c+" ");
		}
	}
	public static list createlist(){
		list lst = new list(1);
		lst.next = new list(2);
		lst.next.next = new list(3);
		lst.next.next.next = new list(4);
		lst.next.next.next.next = new list(5);
		lst.next.next.next.next.next = new list(6);
		return lst;
	}
	
	public static node balanced_tree(){
		node root = new node(1);
		root.left = new node(2);
		root.right = new node(3);
		root.left.left = new node(4);
		
		root.left.right = new node(5);
		root.right.left = new node(6);
		root.right.right = new node(7);
		return root;
	}
	public static node createtree(){
		node root = new node(1);
		root.left = new node(2);
		root.right = new node(3);
		root.left.left = new node(4);
		root.left.left.left = new node(8);
		root.left.right = new node(5);
		root.right.left = new node(6);
		root.right.right = new node(7);
		return root;
	}

	public static void list_iterator(list head){
		list temp = head;
		while(temp != null){
			System.out.print(temp.v+", ");
			temp = temp.next;
		}
		System.out.println("");
	}
}
/*
1.	Merge Tree
	if element in both side add it
	(N t1, N t2)
		
		if(t1 == null) return t1;
		if(t2 == null) return t2;
		
		t1.val += t2.val;
		t1.left = (t1.left, t2.left)
		t1.right = (t1.right, t2.right)
		return t1;


2. 	Invert Tree
	(N root)
	
	if(root == null) return root;
	N left = (root.left);
	N right = (root.right);
	
	root.right = left;
	root.left = right;
	
	return root;
	
3.	Inorder
	DFS - Stack use pannuvoom
	so stack use panni pannalam ilina recursion panlam
	
	Recursion
	(left)
	val
	(right)

4.	Depth
	Recursion 
		left ku pogum pothu depth+1 kuduvoom
		right ku pogum pothu depth+1 kuduvoom
		
	(root, depth)
		if(root == null) return;
		if(root.left == null && root.right == nul) 
			answer = max(answer, depth`)
		
		(root.left, depth+1);
		(root.right, depth+1);
		
*/