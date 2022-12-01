import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class PhoneList{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        Boolean[] r = new Boolean[t];
        for(int i = 0; i<t;i++){
            String s = "";
            String regex = "";
            int n = Integer.parseInt(br.readLine());
            for(int g = 0; g<n;g++){
                String pn = br.readLine();
                regex += "\\b"+ pn +"\\B|";
                s += pn + " ";
            }
            regex = regex.substring(0, regex.length()-1);
            r[i] = Pattern.compile(regex).matcher(s).find();
    }
    for (Boolean b : r) {
        System.out.print(b ? "NO\n" : "YES\n");
    }
}
}