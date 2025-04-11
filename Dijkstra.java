import java.util.*;

class Edge {
    int dest, weight;
    Edge(int dest, int weight) {
        this.dest = dest;
        this.weight = weight;
    }
}

public class Dijkstra {
    public static void dijkstra(List<List<Edge>> graph, int src) {
        int[] dist = new int[graph.size()];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{src, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0];

            for (Edge edge : graph.get(u)) {
                if (dist[edge.dest] > dist[u] + edge.weight) {
                    dist[edge.dest] = dist[u] + edge.weight;
                    pq.offer(new int[]{edge.dest, dist[edge.dest]});
                }
            }
        }

        System.out.println(Arrays.toString(dist));
    }

    public static void main(String[] args) {
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < 5; i++) graph.add(new ArrayList<>());

        graph.get(0).add(new Edge(1, 10));
        graph.get(0).add(new Edge(4, 3));
        graph.get(1).add(new Edge(2, 2));
        graph.get(2).add(new Edge(3, 9));
        graph.get(4).add(new Edge(1, 1));
        graph.get(4).add(new Edge(2, 8));

        dijkstra(graph, 0);
    }
}
