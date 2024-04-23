import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/1766
// 위상정렬(Topological Sort)

// 1. 먼저 푸는 것이 좋은 문제에 대한 정보를 이용하여 방향 그래프를 생성
//    각 문제를 노드로 표현하고, A번 문제가 B번 문제보다 먼저 풀어야 한다는 정보를 이용하여 A에서 B로 가는 방향 간선을 추가
// 2. 그래프에서 진입 차수(Indegree)가 0인 노드를 찾는다. 선행해서 풀어야 할 문제가 없는 노드를 찾아 큐에 넣는다.
// 3. 큐에서 노드를 하나씩 꺼내면서 아래 과정을 반복:
//    - 큐에서 꺼낸 노드를 정렬된 순서(PriorityQueue)에 추가
//    - 꺼낸 노드에서 나가는 간선을 제거(해당 노드에 연결된 다른 노드들의 진입 차수를 1씩 감소시킴)
//    - 진입 차수가 0이 된 노드들을 큐에 추가한다.
// 4. 큐가 빌 때까지 위의 과정을 반복
// 5. 정렬된 순서를 출력
public class bj_1766 {
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