import java.util.Scanner;

public class PizzaCrust{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double R2 = sc.nextInt();
        double R1 = R2-sc.nextInt();
        double C = (Math.pow(R2, 2)*Math.PI-(Math.pow(R1, 2)*Math.PI));
        double A = Math.pow(R2, 2)*Math.PI;
        double cheese = 100-((C/A)*100);
       
        System.out.println(cheese);
        sc.close();

    }
}