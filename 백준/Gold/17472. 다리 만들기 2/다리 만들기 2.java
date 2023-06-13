import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge> {
    int start;
    int end;
    int value;

    public Edge(int start, int end, int value) {
        this.start = start;
        this.end = end;
        this.value = value;
    }

    @Override
    public int compareTo(Edge o) {
        return this.value - o.value;
    }
}

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int islandNum;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    static int[][] map;
    static boolean[][] visit;
    static int[] parent;
    static PriorityQueue<Edge> edges;
    static ArrayList<ArrayList<int[]>> islands;
    static ArrayList<int[]> island;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        map = new int[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = scan.nextInt();
            }
        }
    }

    static void pro() {
        islands = new ArrayList<>();
        islandNum = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0 && !visit[i][j]) {
                    bfs(i, j);
                    islandNum++;
                    islands.add(island);
                }
            }
        }

        edges = new PriorityQueue<>();
        for (int i = 0; i < islands.size(); i++) {
            ArrayList<int[]> now = islands.get(i);
            for (int j = 0; j < now.size(); j++) {
                int x = now.get(j)[0];
                int y = now.get(j)[1];
                int now_island = map[x][y];
                for (int[] d : dir) {
                    int nx = x + d[0];
                    int ny = y + d[1];
                    int len = 0;

                    while (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                        if (map[nx][ny] == now_island) break;
                        else if (map[nx][ny] == 0) len++;
                        else {
                            if (len > 1) {
                                edges.add(new Edge(now_island, map[nx][ny], len));
                            }
                            break;
                        }

                        if (d[0] < 0) nx--;
                        else if (d[0] > 0) nx++;
                        else if (d[1] < 0) ny--;
                        else if (d[1] > 0) ny++;
                    }
                }
            }
        }

        parent = new int[islandNum + 1];
        for (int i = 1; i <= islandNum; i++) {
            parent[i] = i;
        }
        int useEdge = 1;
        int answer = 0;
        while (!edges.isEmpty()) {
            Edge now = edges.poll();
            if (find(now.start) != find(now.end)) {
                union(now.start, now.end);
                answer += now.value;
                useEdge++;
            }

            if (useEdge == islandNum - 1) {
                System.out.println(answer);
                break;
            }
        }

        if (useEdge < islandNum - 1)
            System.out.println(-1);


    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            parent[y] = x;
        }
    }

    private static int find(int x) {
        if (x == parent[x])
            return x;
        else
            return parent[x] = find(parent[x]);
    }

    private static void bfs(int i, int j) {
        Queue<Integer> q = new LinkedList<>();
        island = new ArrayList<>();
        q.add(i);
        q.add(j);
        island.add(new int[]{i, j});
        map[i][j] = islandNum;
        visit[i][j] = true;

        while (!q.isEmpty()) {
            int x = q.poll();
            int y = q.poll();
            for (int[] d : dir) {
                int nx = x + d[0];
                int ny = y + d[1];

//                while(nx >= 0 && nx < N && ny >= 0 && ny < M) {
//                    if (!visit[nx][ny] && map[nx][ny] != 0) {
//                        visit[nx][ny] = true;
//                        map[nx][ny] = islandNum;
//                        island.add(new int[]{nx, ny});
//                        q.add(nx);
//                        q.add(ny);
//                    } else break;
//
//                    if (d[0] == -1) nx--;
//                    else if (d[0] == 1) nx++;
//                    else if (d[1] == -1) ny--;
//                    else if (d[1] == 1) ny++;
//                }

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (visit[nx][ny]) continue;
                if (map[nx][ny] == 0) continue;

                visit[nx][ny] = true;
                map[nx][ny] = islandNum;
                island.add(new int[]{nx, ny});
                q.add(nx);
                q.add(ny);
            }
        }
    }

    public static void main(String[] args) {
        input();
        pro();
    }


    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}

