import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;


public class Nsum {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int sum = Stream.of(br.readLine().split(" "))
                        .map(x -> Integer.parseInt(x))  
                        .reduce(0, (x1,x2) -> x1+x2);
        System.out.println(sum); 
    }
  
}