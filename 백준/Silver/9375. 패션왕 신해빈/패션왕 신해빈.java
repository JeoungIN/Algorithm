import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static int t, n;
    public static Map<String, Integer> clothes = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        t = Integer.parseInt(st.nextToken());

        while (t-- > 0) {
            clothes.clear();

            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());

            for (int i = 0; i < n; i++) {
                String[] input = br.readLine().split(" ");
                String item = input[0];
                String type = input[1];

                clothes.put(type, clothes.getOrDefault(type, 0) + 1);
            }

            int result = 1;
            for(int count : clothes.values()) {
                result *= (count + 1);
            }
            System.out.println(result - 1);
        }
    }
}