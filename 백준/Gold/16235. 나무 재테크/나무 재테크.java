import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static int n, m, k;
    public static int[][] A;
    public static int[][] map;
    public static LinkedList<Integer>[][] tree;

    static LinkedList<int[]> deadTrees = new LinkedList<>();
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        A = new int[n][n];
        map = new int[n][n];
        tree = new LinkedList[n][n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
                map[i][j] = 5;
                tree[i][j] = new LinkedList<>();
            }
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int age = Integer.parseInt(st.nextToken());
            tree[x][y].add(age);
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                Collections.sort(tree[i][j]);
            }
        }

        for(int i = 0; i < k; i++) {
            Spring();
            Summer();
            Fall();
            Winter();
        }

        Count();
    }

    public static void Spring(){
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                LinkedList<Integer> list = tree[i][j];
                LinkedList<Integer> newList = new LinkedList<>();

                for(int age : list) {
                    if(map[i][j] >= age) {
                        map[i][j] -= age;
                        newList.add(age + 1);
                    } else {
                        deadTrees.add(new int[]{i, j, age});
                    }
                }
                tree[i][j] = newList;
            }
        }

    }

    public static void Summer(){
        for(int[] deadTree : deadTrees) {
            int x = deadTree[0];
            int y = deadTree[1];
            int age = deadTree[2];
            map[x][y] += age / 2;
        }

        deadTrees.clear();
    }

    public static void Fall(){
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                for(int age : tree[i][j]) {
                    if(age % 5 == 0){
                        for(int l = 0; l < 8; l++) {
                            int x = i + dx[l];
                            int y = j + dy[l];

                            if(x >= 0 && x < n && y >= 0 && y < n) {
                                tree[x][y].addFirst(1);
                            }
                        }
                    }
                }
            }
        }
    }

    public static void Winter(){
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                map[i][j] += A[i][j];
            }
        }
    }

    public static void Count(){
        int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                count += tree[i][j].size();
            }
        }
        System.out.println(count);
    }
}
