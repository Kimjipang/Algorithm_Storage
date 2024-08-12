import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static boolean[] visited;
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int node = Integer.parseInt(br.readLine());
        int vertex = Integer.parseInt(br.readLine());
        visited = new boolean[node+1];
        graph = new ArrayList[node + 1];

        for (int i = 1; i < node+1; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < vertex; i++) {
            String computer = br.readLine();
            int a = Integer.parseInt(computer.split(" ")[0]);
            int b = Integer.parseInt(computer.split(" ")[1]);
            graph[a].add(b);
            graph[b].add(a);
        }

        System.out.println(bfs(1));
    }

    private static int bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        int count = 0;

        while(!queue.isEmpty()) {
            int value = queue.poll();
            if(!visited[value]) {
                count++;
                visited[value] = true;
                for (int i = 0; i < graph[value].size(); i++) {
                    queue.add(graph[value].get(i));
                }
            }
        }
        return count - 1;
    }
}
