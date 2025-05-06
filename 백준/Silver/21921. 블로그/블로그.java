import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N, X;
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        int max = 0;
        int count = 0;

        for(int i = 0; i < X; i++) {
            sum += arr[i];
        }

        max = sum;
        count = 1;

        for(int i = X; i < N; i++) {
            sum = sum - arr[i - X] + arr[i];

            if(sum > max) {
                max = sum;
                count = 1;
            } else if(sum == max) {
                count++;
            }
        }

        if(max == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(max);
            System.out.println(count);

        }

    }
}