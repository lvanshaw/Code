import java.util.*;

class main{
	public static List<seat> seats = new ArrayList<>();
	public static List<book> ticked = new ArrayList<>();
	public static tickedinfo info = new tickedinfo();
	public static void printAllDetails(List<book> ticked) {
    for (book b : ticked) {
        System.out.println("PNR: " + b.pnr);
        System.out.println("Source: " + b.source);
        System.out.println("Destination: " + b.destination);
        System.out.println("Seat Number: " + b.seatnumber);
        System.out.println("Extra: " + b.extra);
        System.out.println("Seat Info: " + b.seatinfo);
        System.out.println("Multiple:");
        for (book m : b.multiple) {
            System.out.println("\tPNR: " + m.pnr);
            System.out.println("\tSource: " + m.source);
            System.out.println("\tDestination: " + m.destination);
            System.out.println("\tSeat Number: " + m.seatnumber);
            System.out.println("\tExtra: " + m.extra);
            System.out.println("\tSeat Info: " + m.seatinfo);
        }
    }
	System.out.println("-----------------------");
}

	public static void main(String args[]){
		
		for(int i=1; i<9; i++){
			seats.add(new seat(i));
		}
		
		Scanner scan = new Scanner(System.in);
		
		boolean flag = true;
		
		while(flag){
			System.out.println("\n1.Book \n2.Cancel \n3.Chart \n4.Exit");
			System.out.print("Enter Choice: ");
			int n = scan.nextInt();
			switch(n){
				case 1:
					System.out.print("Enter Source: ");
					char s =  scan.next().charAt(0);   
					System.out.print("Enter Destination: ");
					char d =  scan.next().charAt(0);   
					System.out.print("Extra Ticked: (yes/no): ");
					String yes = scan.next();
					//System.out.println( +" "+ yes);
					if(yes.equals("y")){
						System.out.print("Number of tickets: ");
						int no = scan.nextInt();
						info.book(s, d, no);
						
					}else{
						int seat = info.book(s, d);
						if(seat == -1) System.out.println("Seat Not Available");
					}
				break;
				case 2:
					System.out.print("Enter PNR: ");
					int pnr = scan.nextInt();
					System.out.print("Enter No of Ticked to be Removed: ");
					int r = scan.nextInt();
					for(int i =0; i<ticked.size(); i++){
						if(ticked.get(i).pnr == pnr){
							book tobeRemoved = ticked.get(i);
							
							char ss = ticked.get(i).source;
							char dd = ticked.get(i).destination;
							int extra_t = ticked.get(i).extra;
							
							int seat_number = ticked.get(i).seatnumber;
							System.out.println("Removed: " + ticked.get(i).pnr+" "+ ss +" "+ dd+" " + extra_t+" "+ seat_number + " == "+ (seats.get(ticked.get(i).seatnumber).no-1));

							if(extra_t == 0){
								for(int j =(ss - 'a'); j<=(dd - 'a'); j++){
									seats.get(ticked.get(i).seatnumber).a[j] = 0;
								}
								ticked.remove(i);
								break;
							}
							
							if(r!=0){
								for(int l =0; l<r; l++){
									tobeRemoved.multiple.remove(tobeRemoved.multiple.get(multiple.size() - 1));
									ticked.get(i).extra -=1;
								}
							}
						}
					}
				break;
				case 3:
					for(int i=0; i<seats.size(); i++){
						System.out.println(Arrays.toString(seats.get(i).a));
					}
		
					System.out.println("booked ticket count: "+ticked.size());
					printAllDetails(ticked);
				break;
				case 4:
				flag = false;
				break;
			}
		}
		
		//System.out.println("seat no: "+info.book('a', 'b'));
		
		//info.book('a', 'b', 1);
		for(int i=0; i<seats.size(); i++){
			System.out.println(Arrays.toString(seats.get(i).a));
		}
		System.out.println("booked ticket count: "+ticked.size());
		//info.book('c', 'd', 1);
		//System.out.println("seat no: "+info.book('a', 'b'));
		//insert();
		}
	
	public static void insert(){
		System.out.println("seat no: "+info.book('a', 'b'));
		
		System.out.println("seat no: "+info.book('a', 'd'));
		
		System.out.println("seat no: "+info.book('c', 'd'));
		
		System.out.println("seat no: "+info.book('c', 'd'));
		
	}
}
