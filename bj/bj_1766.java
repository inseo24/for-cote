import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/1766
// 위상정렬(Topological Sort)
public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            // 그래프 초기화
            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i <= N; i++) {
                graph.add(new LinkedList<>());
            }

            // 진입차수 배열 초기화
            int[] inDegree = new int[N + 1];

            // 그래프의 간선(edge)을 추가하고 진입 차수 증가시킴
            for (int i = 0; i < M; i++) {
                String[] edge = br.readLine().split(" ");
                int A = Integer.parseInt(edge[0]);
                int B = Integer.parseInt(edge[1]);

                // 진입차수 표현
                graph.get(A).add(B);
                inDegree[B]++;
            }

            PriorityQueue<Integer> pq = new PriorityQueue<>();
            // 진입차수가 0인 노드를 찾아 큐에 넣음(선행으로 풀 필요가 없는 문제)
            for (int i = 1; i <= N; i++) {
                if (inDegree[i] == 0) {
                    pq.offer(i);
                }
            }

            while (!pq.isEmpty()) {
                int problem = pq.poll();
                bw.write(problem + " ");

                // 꺼낸 노드의 간선(edge)을 제거(해당 노드에 연결된 다른 노드들의 진입 차수를 1씩 감소시킴)
                for (int next : graph.get(problem)) {
                    inDegree[next]--;
                    if (inDegree[next] == 0) { // 진입차수가 0인 노드들을 큐에 추가
                        pq.offer(next);
                    }
                }
            }

            bw.flush();
        }
    }
}