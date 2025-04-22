import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int N, K;
    public static int[] time = new int[100001];
    public static int count = 0;
    static int minTime = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Arrays.fill(time, -1);
        bfs();

        System.out.println(minTime);
        System.out.println(count);
    }

    public static void bfs(){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        time[N] = 0;

        while(!queue.isEmpty()){
            int now = queue.poll();


            if(now == K) {
                if(minTime == Integer.MAX_VALUE) {
                    minTime = time[now];
                    count = 1;
                } else if(time[now] == minTime) {
                    count++;
                }
                continue;
            }

            int[] move = {now - 1, now + 1, now * 2};

            for(int next : move) {
                if(next < 0 || next > 100000) continue;

                if(time[next] == -1 || time[next] == time[now] + 1){
                    queue.add(next);
                    if(time[next] == -1){
                        time[next] = time[now] + 1;
                    }
                }
            }
        }
    }
}