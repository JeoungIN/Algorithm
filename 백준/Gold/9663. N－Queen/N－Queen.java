import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static int[] arr;
    public static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        arr = new int[N];
        dfs(0);
        System.out.println(count);

    }

    public static void dfs(int d) {
        if (d == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            arr[d] = i;
            if(possible(d)) dfs(d+1);
        }
    }

    public static boolean possible(int col) {
        for (int i = 0; i < col; i++) {
            if(arr[i] == arr[col]) return false;
            else if(Math.abs(col - i) == Math.abs(arr[col] - arr[i])) return false;
        }

        return true;
    }
}