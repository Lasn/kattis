import java.util.Scanner;

public class Autori{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        sc.close();
        String[] strArray = input.split("-");
        String shortName = "";
        for (String name : strArray) {
            shortName += name.substring(0, 1);
        }
        System.out.println(shortName);
    }
}