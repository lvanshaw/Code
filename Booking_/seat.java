class seat{
	int no;
	
	int a[] = new int[4];
	
	seat(int k){
		no = k;
		for(int i =0; i<4; i++){
			a[i] = 0;
		}
	}
	
	public void print(){
		System.out.println(no);
	}
}