import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static int[] nums;
    public static int[] ops = new int[4];
    public static int max = Integer.MIN_VALUE;
    public static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        nums = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            ops[i] = Integer.parseInt(st.nextToken());
        }

        dfs(nums[0], 1);
        System.out.println(max);
        System.out.println(min);
    }

    public static void dfs(int num, int index) {
        if(index == N) {
            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if(ops[i] > 0){
                ops[i]--;
                switch (i) {
                    case 0: dfs(num + nums[index], index + 1);   break;
                    case 1: dfs(num - nums[index], index + 1);   break;
                    case 2: dfs(num * nums[index], index + 1);   break;
                    case 3: dfs(num / nums[index], index + 1);   break;
                }
                ops[i]++;
            }
        }
    }
}