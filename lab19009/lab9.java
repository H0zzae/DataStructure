// Lab 009	: Graph Floyd Algorithm
// Name : 허채림
// Student ID : 20181707

import java.util.*;


class Graph {
	int numofnodes;  // the number of nodes in the graph
	private int[][] CostAdj; // Adjacency matrix
	private int[] dist; // dist array
	private int[] p; // p array

	final int LargeCost = 999999;

	Graph() {
		// Graph constructor.
		numofnodes = 0;
	}


	void Init(int n) {
		numofnodes = n;
		// now create 2 dimensional array of numofnodes * numofnodes
		CostAdj = new int[numofnodes][numofnodes];
		dist = new int[numofnodes];
		p = new int[numofnodes];

		for(int i = 0; i < numofnodes; i++) {
			// initialize all entries to 0
			for(int j = 0; j < numofnodes; j++){
				CostAdj[i][j] = 0;
			}
		}
	}

		public String toString() {
		String str;
		int i = 0;
		str = "Dist : ";
		for(i = 0; i < numofnodes; i++)
			str +=  dist[i] + " ";
		str += "\n";

		str += "P    : ";
		for( i = 0; i < numofnodes; i++)
			str += p[i] + " ";
		str += "\n";

		// show the paths to all the destinations
		for( i = 0; i < numofnodes; i++) {
			str += "Path to " + i + " : ";
			str += OutPath(i);
			str += "\n";
		}
		return str;
	}



	void Edge(int v1, int v2, int cost) {
		// NEED TO IMPLEMENT
		CostAdj[v1][v2] = cost;
	}


	String OutPath(int i) {
		String str;
		if (p[i] == -1){
			return str = "" + i;
		}
		else{
			return  OutPath(p[i]) +" "+ i;
		}
	}

	void BellmanFord(int v) {
			for(int i =0;i<numofnodes;i++){
				dist[i] = LargeCost;
			}
			for(int a=0;a<numofnodes;a++){
				p[a] = 0;
			}
			dist[v] = 0;
			p[v] = -1;
			for(int b =0;b<numofnodes;b++){
				for(int c =0;c<numofnodes;c++){
					for(int d =0;d<numofnodes;d++){
						if(CostAdj[c][d]!=0 && ((CostAdj[c][d]+dist[c]) < dist[d])){
							dist[d] = CostAdj[c][d] + dist[c];
							p[d] = c;
						}
					}
				}
			}
		}
}
