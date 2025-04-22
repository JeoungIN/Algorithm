import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N, M;
    public static int[][] graph;
    public static boolean[] visited;
    public static int count = 0 ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N+1][N+1];
        visited = new boolean[N+1];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = graph[b][a] = 1;
        }

        for(int i = 1; i <= N; i++) {
            if(!visited[i]) {
                dfs(i);
                count++;
            }
        }

        System.out.println(count);
    }

    public static void dfs(int node) {
        visited[node] = true;

        for(int i = 1; i <= N; i++) {
            if(!visited[i] && graph[node][i] == 1) dfs(i);
        }
    }
}