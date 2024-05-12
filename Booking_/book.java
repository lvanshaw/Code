import java.util.*;

class book{
	
	int pnr;
	char source;
	char destination;
	int seatnumber;
	int extra;
	seat seatinfo;
	
	List<book> multiple = new ArrayList<>();
	
	book(char s, char d, int no, seat i){
		
		source = s;
		destination =d;
		seatnumber = no;
		seatinfo = i;
	}
	book(int id, char s, char d, int no, seat se){
		pnr = id;
		source = s;
		destination =d;
		seatnumber = no;
		seatinfo = se;
	}
	book(int id, char s, char d, int no, seat se, int ex, List<seat> e){
		pnr = id;
		source = s;
		destination =d;
		seatnumber = e.get(0).no-1;
		seatinfo = se;
		extra = ex;
		
		for(int i=0; i<e.size(); i++){
			
			for(int j = (s - 'a'); j<= (d - 'a'); j++){
				e.get(i).a[j] = 1;
			}
			if(i !=0)
			multiple.add(new book(s, d, e.get(i).no, e.get(i)));
		}	
	}
}
	
	
	

