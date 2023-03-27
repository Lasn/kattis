import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class MusicYourWay{
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] attributes = bf.readLine().split(" ");
        int n = Integer.parseInt(bf.readLine());
        ArrayList<String[]> songs = new ArrayList<>(); 
        for(int i = 0; i<n;i++){
            songs.add(bf.readLine().split(" ")); 
        }
        n = Integer.parseInt(bf.readLine());
        for(int i = 0; i<n; i++){
            int idx = 0;
            String att = bf.readLine();
            for (String a : attributes) {
                if(a.equals(att)){break;}
                idx++;
            }
            final int index = idx;
            System.out.println(String.join(" ",attributes));
            songs.sort((x1,x2) -> x1[index].compareTo(x2[index]));
            songs.forEach(x -> System.out.println(String.join(" ",x)));
            System.out.println();
        }

    }

}