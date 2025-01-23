import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class PhoneList {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i<t; i++){
            int n = Integer.parseInt(br.readLine());
            List<String> phoneList = new ArrayList<>();
            for(int j = 0; j<n;j++){
                phoneList.add(br.readLine());
            }
            System.out.println(listCheck(phoneList) ? "YES" : "NO" );
        }
    }

    private static boolean listCheck(List<String> phoneList) {
        phoneList.sort(null);
        for(int l = 1; l < phoneList.size(); l++){
            String s1 = phoneList.get(l-1);
            String s2 = phoneList.get(l);
            if(isClash(s1, s2)){return false;}
        }
        return true;
    }

    private static boolean isClash(String s1, String s2){
        if(s2.startsWith(s1)){return true;}
        if(s1.startsWith(s2)){return true;}
        return false;
    }
}
