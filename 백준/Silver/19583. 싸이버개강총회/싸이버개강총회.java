import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static String S, E, Q;
    public static Set<String> enter = new HashSet<>();
    public static Set<String> result = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        S = st.nextToken();
        E = st.nextToken();
        Q = st.nextToken();

        String line;
        while ((line = br.readLine()) != null) {
            if(line.isEmpty()) break;

            String[] arr = line.split(" ");
            String time = arr[0];
            String name = arr[1];

            if(time.compareTo(S) <= 0){
                enter.add(name);
            } else if (time.compareTo(E) >= 0 && time.compareTo(Q) <= 0) {
                if (enter.contains(name)) {
                    result.add(name);
                }
            }
        }
        System.out.println(result.size());
    }
}