import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class IveBeenEverywhereMan{

    private static Set<String> cities;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int trips = Integer.valueOf(sc.nextLine());
        for(int i = 0; i<trips; i++){
            cities = new HashSet<>();
            int intCities = Integer.valueOf(sc.nextLine());
            for(int j = 0; j<intCities; j++){
                cities.add(sc.nextLine().trim().toLowerCase());
            }
            System.out.println(cities.size());
        }
        sc.close();

    }

}