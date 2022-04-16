import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_7562 {
    private static int size;
    private static int answer = 0;
    private static boolean[][] isVisited;
    private static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    private static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
    private static int startX;
    private static int startY;
    private static int desX;
    private static int desY;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCaseCnt = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < testCaseCnt; i++) {
            size = sc.nextInt();
            isVisited = new boolean[size][size];
            startX = sc.nextInt();
            startY = sc.nextInt();
            desX = sc.nextInt();
            desY = sc.nextInt();
            bfs(new Point(startX, startY, 0));
            System.out.println(answer);
        }

    }

    private static void bfs(Point point) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(point);
        isVisited[point.x][point.y] = true;
        while (!queue.isEmpty()) {
            Point point2 = queue.poll();
            if (point2.x == desX && point2.y == desY) {
                answer = point2.count;
                break;
            }
            for (int i = 0; i < 8; i++) {
                int x2 = point2.x + dx[i];
                int y2 = point2.y + dy[i];
                int count = point2.count + 1;
                if ((x2 >= 0 && x2 < size && y2 < size && y2 >= 0) && !isVisited[x2][y2]) {
                    queue.offer(new Point(x2, y2, count));
                    isVisited[x2][y2] = true;
                }
            }
        }
    }

    static class Point {
        int x;
        int y;
        int count;

        Point(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}