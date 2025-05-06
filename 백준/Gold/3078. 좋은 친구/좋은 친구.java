import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N, K;
    public static int[] len;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        len = new int[N];
        for(int i = 0; i < N; i++) {
            len[i] = br.readLine().length();
        }

        int[] count = new int[21];
        long result = 0;

        for(int i = 0; i < N; i++) {
            int length = len[i];

            result += count[length];
            count[length]++;

            if (i >= K) {
                int outLen = len[i - K];
                count[outLen]--;
            }
        }

        System.out.println(result);
    }
}