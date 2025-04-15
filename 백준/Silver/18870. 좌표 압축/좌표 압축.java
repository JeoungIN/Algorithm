import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static int[] arr;
    public static int[] sort;
    public static HashMap<Integer, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        arr = new int[N];
        map = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        sort = arr.clone();
        Arrays.sort(sort);

        int rank = 0;
        for(int i = 0; i < N; i++) {
            if(!map.containsKey(sort[i])) {
                map.put(sort[i], rank++);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            sb.append(map.get(arr[i])).append(" ");
        }
        System.out.println(sb);
    }
}