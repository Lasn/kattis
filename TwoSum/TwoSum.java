import java.util.Scanner;

public class TwoSum{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] ints = sc.nextLine().split(" ");
        System.out.println(Integer.valueOf(ints[0])+Integer.valueOf(ints[1]));
        sc.close();
    }
}