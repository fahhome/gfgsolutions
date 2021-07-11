package gfg;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;


// Given a square chessboard,the initial position of Knight and position of a target.Find out the minimum steps a Knight will take to reach the target position.
// Note:The initial and the target position co-ordinates of Knight have been given accoring to 1-base indexing.

// tc = 1
// n m = 6 6 
// knightPos[ ] = {4, 5}
// targetPos[ ] = {1, 1}
// Output:
// 3

public class Knight {

    private static boolean issafe(int x, int y, int n, int m) {

        if (x >= 1 && x <= n && y >= 1 && y <= m) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        // Scanner sc = new Scanner(System.in);
        // int tc = sc.nextInt() ;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {

            String[] str1 = br.readLine().split(" ");

            String[] str2 = br.readLine().split(" ");

            int n = Integer.parseInt(str1[0]);
            int m = Integer.parseInt(str1[1]);

            int sx = Integer.parseInt(str2[0]);
            int sy = Integer.parseInt(str2[1]);

            int dx = Integer.parseInt(str2[2]);
            int dy = Integer.parseInt(str2[3]);

            Cdn start = new Cdn(sx, sy, 0);
            Cdn dest = new Cdn(dx, dy, 0);

            int[][] visited = new int[n + 2][m + 2];

            Queue<Cdn> q = new LinkedList<>();

            int found = -1;
            q.add(start);

            while (!q.isEmpty()) {

                Cdn popped = q.remove();

                int curx = popped.x;
                int cury = popped.y;

                int curm = popped.moves;

                if (curx == dest.x && cury == dest.y) {

                    found = curm;
                    break;

                }

                int px = 0, py = 0;
                // lt1

                px = curx + 1;
                py = cury - 2;

                if (issafe(px, py, n, m) && visited[px][py] == 0) {
                    Cdn obj = new Cdn(px, py, curm + 1);
                    q.add(obj);
                    visited[px][py] = 1;
                }

                // lt2
                px = curx + 2;
                py = cury - 1;

                if (issafe(px, py, n, m) && visited[px][py] == 0) {
                    Cdn lt2 = new Cdn(px, py, curm + 1);
                    q.add(lt2);
                    visited[px][py] = 1;
                }

                // rt1

                px = curx + 1;
                py = cury + 2;

                if (issafe(px, py, n, m) && visited[px][py] == 0) {
                    Cdn obj = new Cdn(px, py, curm + 1);
                    q.add(obj);
                    visited[px][py] = 1;
                }

                // rt2

                px = curx + 2;
                py = cury + 1;

                if (issafe(px, py, n, m) && visited[px][py] == 0) {
                    Cdn obj = new Cdn(px, py, curm + 1);
                    q.add(obj);
                    visited[px][py] = 1;
                }

                // ld1

                px = curx - 2;
                py = cury - 1;

                if (issafe(px, py, n, m) && visited[px][py] == 0) {
                    Cdn obj = new Cdn(px, py, curm + 1);
                    q.add(obj);
                    visited[px][py] = 1;
                }

                // ld2

                px = curx - 1;
                py = cury - 2;

                if (issafe(px, py, n, m) && visited[px][py] == 0) {
                    Cdn obj = new Cdn(px, py, curm + 1);
                    q.add(obj);
                    visited[px][py] = 1;
                }

                // rd1
                px = curx - 1;
                py = cury + 2;

                if (issafe(px, py, n, m) && visited[px][py] == 0) {
                    Cdn obj = new Cdn(px, py, curm + 1);
                    q.add(obj);
                    visited[px][py] = 1;
                }

                // rd2

                px = curx - 2;
                py = cury + 1;

                if (issafe(px, py, n, m) && visited[px][py] == 0) {
                    Cdn obj = new Cdn(px, py, curm + 1);
                    q.add(obj);
                    visited[px][py] = 1;
                }

            }

            System.out.println(found);
        }

    }

}

class Cdn {

    int x, y;
    int moves;

    Cdn(int x, int y, int moves) {
        this.x = x;
        this.y = y;
        this.moves = moves;
    }
}