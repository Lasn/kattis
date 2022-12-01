import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int crates = sc.nextInt();
        sc.close();
        FillingCrates fc = new FillingCrates(crates);
        String print = fc.crates(crates);
        System.out.println(print);
    
    }
}