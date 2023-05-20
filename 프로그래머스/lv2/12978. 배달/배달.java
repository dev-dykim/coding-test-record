import java.util.ArrayList;
import java.util.PriorityQueue;

class Solution {

    static class Edge {
        public int to, weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static class Info {
        public int idx, dist;

        public Info(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }
    }

    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[] dist = new int[N+1];
        ArrayList<Edge>[] edges = new ArrayList[N+1];

        for (int i = 1; i <= N; i++)
            edges[i] = new ArrayList<>();

        for (int[] r : road) {
            int from = r[0];
            int to = r[1];
            int weight = r[2];
            edges[from].add(new Edge(to, weight));
            edges[to].add(new Edge(from, weight));
        }

        dijkstra(1, N, dist, edges);

        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K)
                answer++;
        }

        return answer;
    }

    private void dijkstra(int start, int N, int[] dist, ArrayList<Edge>[] edges) {
        for (int i = 1; i <= N; i++)
            dist[i] = Integer.MAX_VALUE;

        PriorityQueue<Info> pq = new PriorityQueue<>((o1, o2) -> o1.dist - o2.dist);

        pq.add(new Info(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Info info = pq.poll();

            if (dist[info.idx] != info.dist) continue;

            for (Edge e : edges[info.idx]) {
                if (dist[info.idx] + e.weight >= dist[e.to])
                    continue;

                dist[e.to] = dist[info.idx] + e.weight;
                pq.add(new Info(e.to, dist[e.to]));
            }
        }
    }
}