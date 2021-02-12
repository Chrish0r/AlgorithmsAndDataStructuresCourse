package lecture.graphs.Floyd_Warshall;

public class Main {

	public static void main(String[] args) {
		
		
		
		int [][] Adj1= {

				{0,	12,	8,	2,	0},
				{0,	0,	0,  1,	0},
				{0,	0,	0,	0,	1},
				{3,	6,	5,	0,	2},
				{0,	1,	1,	0,	0},
		};
		
		
		Graph G= new Graph(Adj1);
		
		G.Dijkstra(0);
		
		G.BellmanFord(0);
		
		// Task 3
		int inf=Integer.MAX_VALUE;
		
		int [][] W= {
				
				{0, inf, inf, 5},    // 1
				{inf, 0, inf, 2},		// 2
				{-8, inf, 0, inf},		// 3
				{inf, inf, 3, 0},     //4

		};
		
	int [][] W2= {
				
				{0,		3,	8,	inf,	 -4 }, 		//1
				{inf,	  	  0,	inf,      1,	7},		//2
				{inf,     4,	  0,	inf,	inf},		//3
				{2,	inf,	-5,	  0,	  inf},		//4
				{inf,	  inf,	inf,	6,	  0},		//5
		};


		System.out.println("Dijkstra");

		
		
		
		System.out.println("APSP");
		
		G.APSP(W);
	
		System.out.println("FasterAPSP");
		G.FasterAPSP(W);
		System.out.println("-------------------------------------");

		System.out.println("Floyed-Warshall");
		G.FloydWarshall(W);
		
		
		// G.FloydWarshall(W2);
		
		
	int [][] W3= {
				
				{0,		-5,	   inf,		inf }, 		//1
				{inf,	 0,		-3,     inf},		//2
				{inf,  inf,	  	 0,		-5},		//3
				{inf,	20,	   inf,	  	 0},		//4
		};
		
	
//	G.FloydWarshall(W3);
		
		


	}
	
	
	

	
	
	

	
	

}
