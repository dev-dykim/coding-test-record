import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static boolean[][][][] visit;

    public int solution(String dirs) {
        int answer = 0;
        visit = new boolean[11][11][11][11];
        answer = bfs(5, 5, dirs);
        return answer;
    }

    private int bfs(int x, int y, String dirs) {
        visit[x][y][x][y] = true;
        int dist = 0;
        for(int i = 0; i < dirs.length(); i++) {
            char ch = dirs.charAt(i);
            switch (ch) {
                case 'U' :
                    if(!isInRange(x, y+1)) continue;
                    if(!visit[x][y+1][x][y] && !visit[x][y][x][y+1]) {
                        visit[x][y][x][y+1] = true;
                        dist++;
                    }
                    y++;
                    break;
                case 'D' :
                    if(!isInRange(x, y-1)) continue;
                    if(!visit[x][y][x][y-1] && !visit[x][y-1][x][y]) {
                        visit[x][y][x][y-1] = true;
                        dist++;
                    }
                    y--;
                    break;
                case 'L' :
                    if(!isInRange(x-1, y)) continue;
                    if(!visit[x][y][x-1][y] && !visit[x-1][y][x][y]) {
                        visit[x][y][x-1][y] = true;
                        dist++;
                    }
                    x--;
                    break;
                case 'R' :
                    if(!isInRange(x+1, y)) continue;
                    if(!visit[x][y][x+1][y] && !visit[x+1][y][x][y]) {
                        visit[x][y][x+1][y] = true;
                        dist++;
                    }
                    x++;
                    break;
            }
        }
        return dist;
    }

    private boolean isInRange(int x, int y) {
        return x >= 0 && x <= 10 && y >= 0 && y <= 10;
    }
}