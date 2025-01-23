import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Multpoly {

    private void multpoly(int[] a, int[] b) {

        int n = 1;
        while (n < a.length + b.length - 1) {
            n <<= 1;
        }

        Complex[] x1 = new Complex[n];
        Complex[] x2 = new Complex[n];

        for (int i = 0; i < a.length; i++) {
            x1[i] = new Complex(a[i], 0);
        }
        for (int i = a.length; i < n; i++) {
            x1[i] = new Complex(0, 0); // Padding with zeros
        }

        for (int i = 0; i < b.length; i++) {
            x2[i] = new Complex(b[i], 0);
        }
        for (int i = b.length; i < n; i++) {
            x2[i] = new Complex(0, 0); // Padding with zeros
        }

        x1 = FFT.fft(x1);
        x2 = FFT.fft(x2);

        Complex[] x3 = new Complex[n];
        for (int i = 0; i < n; i++) {
            x3[i] = x1[i].times(x2[i]);
        }

        x3 = FFT.ifft(x3);

        System.out.println(a.length + b.length - 2);
        for (int i = 0; i < a.length + b.length - 1; i++) {
            System.out.printf("%d ", (int) Math.round(x3[i].re()));
        }
        System.out.println();

    }

    public static void main(String[] args) throws IOException {
        Multpoly multp = new Multpoly();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int ac = Integer.parseInt(br.readLine());
            int[] a = new int[ac + 1];
            String[] line = br.readLine().split(" ");
            for (int j = 0; j <= ac; j++) {
                a[j] = Integer.parseInt(line[j]);
            }
            int bc = Integer.parseInt(br.readLine());
            int[] b = new int[bc + 1];
            line = br.readLine().split(" ");
            for (int j = 0; j <= bc; j++) {
                b[j] = Integer.parseInt(line[j]);
            }
            multp.multpoly(a, b);
        }

    }
}
