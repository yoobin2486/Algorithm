package baekjoon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Exam1260 {

	static int N, M, V; // 정점의 갯수, 간선의 갯수, 시작 정점
	static boolean[][] map;
	static boolean[] visit;
	static Queue<Integer> queue = new LinkedList<Integer>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		V = sc.nextInt();

		visit = new boolean[N + 1]; // default : false
		map = new boolean[N + 1][N + 1]; //N+1 : 0123.. X, 1234로 할것

		//map초기화
		for (int i = 0; i < M; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			map[v1][v2] = map[v2][v1] = true;
		}
		
		dfs(V);
		Arrays.fill(visit, false); //다시 초기화
		
		System.out.println();
		bfs(V);
	}

	// 현재 위치에서 dfs할거
	static void dfs(int start) {
		if (visit[start] == true) {
			return;
		}
		System.out.print(start + " ");
		visit[start] = true;

		for (int i = 1; i <= N; i++) {
			//간선이 적혀 있는 것들 재귀함수를 이용해 dfs사용
			if (map[start][i] == true) { 
				dfs(i);
			}
		}
	}
	
	// 현재 위치에서 bfs
	static void bfs(int start) {
		if(visit[start] == true) {
			return;
		}
		System.out.print(start+" ");
		visit[start] = true;

		for(int i=1; i<= N; i++) {
			if(map[start][i] == true) {
				queue.add(i);
			}
		}
		//큐가 비어 있지 않으면 다음 것을 하나 꺼내서  bfs다시 재귀함수 돌리기
		while(!queue.isEmpty()) {
			int next = queue.poll();
			bfs(next);
		}
	}
	
}
