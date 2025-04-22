import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int N, M, V;
    public static int[][] graph;
    public static boolean[] visited;
    public static StringBuilder bfsB = new StringBuilder();
    public static StringBuilder dfsB = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graph = new int[N+1][N+1];

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = graph[b][a] = 1;
        }

        visited = new boolean[N+1];
        dfs(V);
        System.out.println(dfsB);

        visited = new boolean[N+1];
        bfs(V);
        System.out.println(bfsB);

    }

    public static void dfs(int node) {
        visited[node] = true;
        dfsB.append(node).append(" ");

        for(int i = 1; i <= N; i++) {
            if(!visited[i] && graph[node][i] == 1) {
                dfs(i);
            }
        }
    }

    public static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            bfsB.append(now).append(" ");

            for(int i = 1; i <= N; i++) {
                if(!visited[i] && graph[now][i] == 1) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }

    }
}