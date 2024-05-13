import java.util.*;

class tickedinfo{
	
	static int id = 1;;
	public void book(char source, char destination, int m){
		int totaltictets =0;
		List<seat> temp = new ArrayList<>();
        
		for(int k=0; k<m+1; k++){
			
			for(int i =0; i<main.seats.size(); i++){
				boolean available = true;
				for(int j=(source-'a'); j<=(destination-'a'); j++){
					if(main.seats.get(i).a[j] != 0){
						available = false;
						break;
					}
				}
				System.out.println(main.seats.size() +" seat: "+ i + " "+ available + " "+ totaltictets);

				if(available){
					if(temp.contains(main.seats.get(i))){
						
					}else{
						temp.add(main.seats.get(i));
						totaltictets++;
					}
				}
				if(totaltictets == m+1) break;
			}
			if(totaltictets == m+1) break;
		}
		if(totaltictets == m+1){
			main.ticked.add(new book(id, source, destination, temp.get(0).no, temp.get(0), m, temp, "booked"));
			//System.out.println(id+"  " + source+ " " +destination+ " "+ temp.get(0).no+  "  "+ temp.get(0)+ " "+ m);
			System.out.println("PNR: "+ id +"\nSeat Number: "+ temp.get(0).no);

			id++;
			System.out.println("Seat Available");
		}else{
			
			System.out.println(totaltictets+" "+"Seat Not Available");
		}
	}
	
	public int book(char source, char destination){
		//System.out.println("No Multiple");
		for(int i =0; i<main.seats.size(); i++){
			//main.seats.get(i).print();
			boolean available = true;
			//System.out.println((source - 'a') +" " +(destination - 'a'));
			for(int j=(source-'a'); j<=(destination-'a'); j++){
				//System.out.print(main.seats.get(i).a[j] +" ");
				if(main.seats.get(i).a[j] != 0){
					available = false;
					break;
				}
			}
			if(available){
				
				//System.out.println("Seat Available");
				for(int j=(source-'a'); j<=(destination-'a'); j++){
					
						main.seats.get(i).a[j] = 1;
					
				}
				System.out.println("PNR: "+ id +"\nSeat Number: "+ i);
				main.ticked.add(new book(id, source, destination, i, main.seats.get(i), "booked"));
				id++;
				return i;
				
			}
			
		}
		return -1;
	}
}
