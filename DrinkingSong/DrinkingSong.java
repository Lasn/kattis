import java.util.Scanner;
import java.util.regex.Pattern;

public class DrinkingSong{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());
        String beverage = sc.next();
        sc.close();
        for(int i = n; i>0; i--){
            printVerse(i, beverage);
        }
    }

    private static void printVerse(int n, String beverage){
        String verse = "N bottles of B on the wall, N bottles of B.\nTake one down, pass it around, N1 bottles of B on the wall.";
        verse = Pattern.compile("\\bN\\W").matcher(verse).replaceAll(n+" ");
        verse = Pattern.compile("\\bN1\\W").matcher(verse).replaceAll(n-1+" ");
        verse = Pattern.compile("\\b0\\W").matcher(verse).replaceAll("no more ");
        verse = Pattern.compile("\\b1 bottles\\W").matcher(verse).replaceAll("1 bottle ");
        verse = Pattern.compile("\\bTake one down,.* no more .*\\W").matcher(verse).replaceAll("Take it down, pass it around, no more bottles of B.");
        verse = Pattern.compile("\\bB").matcher(verse).replaceAll(beverage);
        System.out.println(verse+ "\n");
    }
}