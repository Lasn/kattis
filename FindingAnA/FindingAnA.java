import java.util.Scanner;

public class FindingAnA{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder(sc.nextLine());
        System.out.println(sb.substring(sb.indexOf("a", 0)));
        sc.close();
    }
}