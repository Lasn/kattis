import java.util.Scanner;

public class HairoftheDog{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int count = 0;
        String last = sc.nextLine(); 
        while(sc.hasNext()){
            String line = sc.nextLine();
            if(line.equals("sober") && last.equals("drunk")){
                count += 1;
            }
            last = line;
        }
        sc.close();

        System.out.println(count);
    }
}