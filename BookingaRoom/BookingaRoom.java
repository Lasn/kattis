import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BookingaRoom{

    Set <Integer> rooms;

    public BookingaRoom(){
        importData();
    }

    public void importData(){
        rooms = new HashSet<>();
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int n = sc.nextInt();
        for(int i = 1; i<=r; i++){
            rooms.add(i);
        }
        for(int i = 0; i<n;i++){
            rooms.remove(sc.nextInt());
        }
        sc.close();
    }

    public void getRoom(){
        if(rooms.isEmpty()){
            System.out.println("too late");
        } 
        for (Integer room : rooms) {
            System.out.println(room);
            break;
        }
  
    }

    public static void main(String[] args) {
        BookingaRoom br = new BookingaRoom();
        br.getRoom();

    }
}