import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[] visitOrder; // 각 노드가 탐색된 순서
    static int order; // 탐색 순서 기록
    static ArrayList<Integer>[] graph; // 각 노드의 인접 노드를 저장하는 배열
    static boolean[] visited; // 각 노드 방문 여부

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]); // 정점의 수
        int M = Integer.parseInt(input[1]); // 간선의 수
        int R = Integer.parseInt(input[2]); // 시작 정점

        graph = new ArrayList[N + 1]; // 각 노드에 대응하는 인덱스에 매핑하기 위한 크기 설정
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) { //
            String[] egdeList = br.readLine().split(" "); // 무방향 그래프이기에 양방향으로 다 간선을 추가
            int u = Integer.parseInt(egdeList[0]);
            int v = Integer.parseInt(egdeList[1]);
            graph[u].add(v);
            graph[v].add(u);
        }
        for (int i = 1; i <= N; i++) { // 인점 정점 오름차순으로 방문
            Collections.sort(graph[i]);
        }

        visitOrder = new int[N + 1];
        visited = new boolean[N + 1];
        order = 1;
        
        bfs(R);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(visitOrder[i]).append('\n');
        }

        System.out.print(sb);
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        visitOrder[start] = order++;
        queue.add(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int next : graph[node]) {
                if (!visited[next]) {
                    visited[next] = true;
                    visitOrder[next] = order++;
                    queue.add(next);
                }
            }
        }
    }
}
