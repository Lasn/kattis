import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TGIF {

    private static List<Month> months;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] date = sc.nextLine().split(" ");
        String firstDay = sc.nextLine();
        sc.close();
        int startInt = startInt(firstDay);
        months = createMonths();
        int day = (startInt + returnDay(date))%7;
        isItFriday(day,date);
    }

    private static List<Month> createMonths(){
        String[] data = "JAN 31,FEB 28,MAR 31,APR 30,MAY 31,JUN 30,JUL 31,AUG 31,SEP 30,OCT 31,NOV 30,DEC 31".split(",");
        List<Month> months = new ArrayList<>();
        int i = 1;
        for (String m : data) {
            String[] ms = m.split(" ");
            months.add(new Month(i++, ms[0], Integer.parseInt(ms[1])));
        }
        return months;
    }

    private static int startInt(String day) {
        switch(day){
            case "MON": return 1;
            case "TUE": return 2;
            case "WED": return 3;
            case "THU": return 4;
            case "FRI": return 5;
            case "SAT": return 6;
            case "SUN": return 0;
        }
        return -1;
    }

    private static int returnDay(String[] date) {
        int daysCount = -1;
        for (Month m : months) {
            if(m.getName().equals(date[1])){
                daysCount += Integer.valueOf(date[0]);
                break;
            } else {
                daysCount += m.getDays();
            }
        }
        return daysCount % 7;
    }

    private static void isItFriday(int day, String[] date) {
        boolean pastFeb = date[1].equals("JAN") || date[1].equals("FEB") ? false : true;
        if(day == 5 && !pastFeb){
            System.out.println("TGIF");
        } else if(day == 5 || day == 4 && pastFeb){
            System.out.println("not sure");
        } else {
            System.out.println(":(");
        }
    }
}