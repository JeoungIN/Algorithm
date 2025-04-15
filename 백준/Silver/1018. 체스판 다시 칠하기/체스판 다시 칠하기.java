import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int n, m;
    public static char[][] chessboard;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        chessboard = new char[n][m];

        for (int i = 0; i < n; i++) {
            chessboard[i] = br.readLine().toCharArray();
        }

        int min = Integer.MAX_VALUE;

        for(int i = 0; i <= n - 8; i++) {
            for(int j = 0; j <= m - 8; j++) {
                min = Math.min(min, countRepaint(chessboard, i, j));
            }
        }
        System.out.println(min);
    }

    public static int countRepaint(char[][] board, int row, int col) {
        int startWhite = 0;
        int startBlack = 0;

        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                char white = ((i + j) % 2 == 0) ? 'W' : 'B';
                char black = ((i + j) % 2 == 0) ? 'B' : 'W';

                if(board[row + i][col + j] != white) startWhite++;
                if(board[row + i][ col + j] != black) startBlack++;
            }
        }

        return Math.min(startWhite, startBlack);
    }
}