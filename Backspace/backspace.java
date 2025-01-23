import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class backspace {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String word = bf.readLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            Character letter = word.charAt(i);
            if (letter.equals('<')) {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(letter);
            }
        }
        System.out.println(sb.toString());

    }
}