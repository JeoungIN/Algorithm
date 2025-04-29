import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int n, T;
    public static ArrayList<Integer>[] rock;
    public static Set<String> visited = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        rock = new ArrayList[200001];
        for (int i = 0; i <= 200000; i++) {
            rock[i] = new ArrayList<>();
        }

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            rock[y].add(x);
        }

        System.out.println(bfs());
    }

    public static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 0});
        visited.add("0,0");

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];
            int count = now[2];

            if(y == T) return count;
            for (int dy = -2; dy <= 2; dy++) {
                int ny = y + dy;
                if (ny < 0 || ny > 200000) continue;

                for (int i = 0; i < rock[ny].size(); i++) {
                    int nx = rock[ny].get(i);

                    if (Math.abs(nx - x) <= 2) {
                        String key = nx + "," + ny;
                        if (!visited.contains(key)) {
                            visited.add(key);
                            queue.offer(new int[]{nx, ny, count + 1});
                        }
                    }
                }
            }
        }


        return -1;
    }
}