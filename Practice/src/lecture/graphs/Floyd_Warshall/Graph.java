package lecture.graphs.Floyd_Warshall;

import java.util.ArrayList;
import java.util.List;

public class Graph {

	public List<GraphNode> allNodes;
	public List<Edge> allEdges;

	public String[] pred;

	public Graph(int[][] Adj) {

		int n = Adj[0].length;
		allNodes = new ArrayList<GraphNode>();
		allEdges = new ArrayList<Edge>();
		this.pred = new String[n];

		for (int i = 0; i < n; i++) {
			pred[i] = null;
		}

		String NodeName = "V";
		String EdgeName = "E";

		for (int i = 0; i < n; i++) {
			GraphNode node = new GraphNode(NodeName, i);
			allNodes.add(node);

		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (Adj[i][j] != 0) {

					Edge e = new Edge(allNodes.get(i), allNodes.get(j), Adj[i][j], EdgeName + allEdges.size());
					allNodes.get(i).addEdge(e);
					allEdges.add(e);

				}

			}

		}

	}

	public void Dijkstra(int NodeIndex) {
		for (int i = 0; i < allNodes.size(); i++) {
			allNodes.get(i).dist = Integer.MAX_VALUE;
			allNodes.get(i).pred = null;
		}

		GraphNode curr = allNodes.get(NodeIndex);
		curr.dist = 0;

		PrioQ H = new PrioQ();

		for (int i = 0; i < allNodes.size(); i++) {
			H.Insert(allNodes.get(i), allNodes.get(i).dist);
		}

		while (!H.isEmpty()) {

			GraphNode u = (GraphNode) H.ExtractMin();
			for (int i = 0; i < u.edges.size(); i++) {
				GraphNode v = u.edges.get(i).end;
				int w = u.edges.get(i).cost;

				if (v.dist > u.dist + w) {
					v.dist = u.dist + w;

					v.pred = u;

					H.DecreaseKey(v, v.dist);
				}

			}

		}

		System.out.println("Pred Tabel:");
		printPred();

		// printpredField();

	}

	public void BellmanFord(int NodeIndex) {

		for (int i = 0; i < allNodes.size(); i++) {
			allNodes.get(i).dist = Integer.MAX_VALUE;
			allNodes.get(i).pred = null;
		}

		GraphNode curr = allNodes.get(NodeIndex);
		curr.dist = 0;

		for (int i = 0; i < allNodes.size() - 1; i++) {

			for (int j = 0; j < allEdges.size(); j++) {
				GraphNode u = allEdges.get(j).start;
				GraphNode v = allEdges.get(j).end;
				int w = allEdges.get(j).cost;
				if (v.dist > u.dist + w && u.dist != Integer.MAX_VALUE) {
					v.dist = u.dist + w;
					v.pred = u;

				}

			}

		}

		for (int j = 0; j < allEdges.size(); j++) {
			GraphNode u = allEdges.get(j).start;
			GraphNode v = allEdges.get(j).end;
			int w = allEdges.get(j).cost;
			if (v.dist > u.dist + w) {

				System.out.println("Negativer Zyklus");
				return;

			}

		}

		System.out.println("Pred Tabel:");
		printPred();

	}

	public void printpredField() {
		String s = "Pred: [ ";
		for (int i = 0; i < pred.length; i++) {
			s += pred[i];
		}
		s += " ]";

		System.out.println(s);
	}

	public void printPred() {
		String s = "";
		for (int i = 0; i < allNodes.size(); i++) {
			if (allNodes.get(i).pred != null) {
				s += "|" + "V" + i + " Pred: " + allNodes.get(i).pred.fullname + "|";
			} else {
				s += "|" + "V" + i + " Pred: null " + "|";
			}
			if (i != allNodes.size() - 1) {
				s += " ";
			}

		}
		System.out.println(s);

	}

	public int[][] APSP(int[][] W) {
		int n = W[0].length;

		System.out.println("L1 = W: ");
		printMatrix(W);
		System.out.println();

		int[][] L = new int[n][n];
		L = W;

		for (int i = 1; i < n; i++) {

			L = ExtendShortestPaths(L, W);

			System.out.println("L" + (i + 1) + " : ");
			printMatrix(L);
			System.out.println();

		}

		return L;

	}

	private int[][] ExtendShortestPaths(int[][] L, int[][] W) {

		int n = W[0].length;

		int[][] Lm = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				Lm[i][j] = Integer.MAX_VALUE;

				for (int k = 0; k < n; k++) {

					if (L[i][k] != Integer.MAX_VALUE && W[k][j] != Integer.MAX_VALUE) {

						Lm[i][j] = min(Lm[i][j], L[i][k] + W[k][j]);

					}

				}

			}
		}

		return Lm;

	}

	private void printMatrix(int M[][]) {

		for (int i = 0; i < M.length; i++) {

			for (int j = 0; j < M[0].length; j++) {

				if (M[i][j] != Integer.MAX_VALUE)
					System.out.print(" " + M[i][j] + " ");
				else
					System.out.print(" Inf ");

			}
			System.out.println();
		}

	}

	public int[][] FasterAPSP(int[][] W) {
		int n = W[0].length;

		System.out.println("W = L1 : ");
		printMatrix(W);
		System.out.println();

		int[][] L = new int[n][n];
		L = W;

		for (int i = 1; i < n;) {

			L = ExtendShortestPaths(L, L);

			i = i * 2;
			System.out.println("L" + (i) + " : ");
			printMatrix(L);
			System.out.println();

		}

		return L;

	}

	private int min(int a, int b) {
		return a > b ? b : a;
	}

	public int[][] FloydWarshall(int[][] W) {

		int n = W.length;

		Integer[][] pred0 = getPred(W);

		int[][] D0 = W;

		for (int k = 0; k < n; k++) {
			int[][] D = new int[n][n];
			Integer[][] pred = new Integer[n][n];
			// make a deep copy of the arrays
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					D[i][j] = D0[i][j];
					pred[i][j] = pred0[i][j];

				}
			}

			for (int i = 0; i < n; i++) {

				for (int j = 0; j < n; j++) {

					if (D0[i][k] != Integer.MAX_VALUE && D0[k][j] != Integer.MAX_VALUE) {
						D[i][j] = min(D0[i][j], D0[i][k] + D0[k][j]);

						if (D[i][j] != D0[i][j]) {

							if (pred0[k][j] == null) {

								pred[i][j] = i + 1;
							} else {
								pred[i][j] = pred0[k][j];
							}

						}

					}

				}

			}

			System.out.println("D" + (k + 1));
			printMatrix(D);
			System.out.println("Pre" + (k + 1));

			for (int l = 0; l < n; l++) {
				for (int m = 0; m < n; m++) {
					System.out.print(pred[l][m] + " ");
				}
				System.out.println();
			}
			D0 = D;
			pred0 = pred;
		}

		return D0;
	}

	private Integer[][] getPred(int[][] w) {

		Integer[][] pred = new Integer[w.length][w.length];

		for (int i = 0; i < w.length; i++) {

			for (int j = 0; j < w[0].length; j++) {

				if (w[i][j] != 0 && w[i][j] != Integer.MAX_VALUE) {
					pred[i][j] = i + 1;
				}

			}

		}

		return pred;
	}

}
