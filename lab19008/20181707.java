import java.util.*;

// ---------- Graph class -------------

class Graph {
    int numofnodes;  // the number of nodes in the graph
    private int[][] AdjMatrix; // Adjacency matrix
    private boolean[] visited; // mark the visitied node


    Graph() {
        // Graph constructor.
        numofnodes = 0;
    }

    void Init(int n) {
        numofnodes = n;
        // now create 2 dimensional array of numofnodes * numofnodes
        AdjMatrix = new int[numofnodes][numofnodes];
        for(int i = 0; i < numofnodes; i++) {
            // initialize all entries to 0
            for(int j = 0; j < numofnodes; j++)
                AdjMatrix[i][j] = 0;  // initialize the adjacency matrix
        }

    }


	void Edge(int n1, int n2) {
    AdjMatrix[n1][n2] = 1;
    AdjMatrix[n2][n1] = 1;
	}

	void Bfs(int v) {
		Queue<Integer> q = new LinkedList<>();
    visited = new boolean[numofnodes];
    q.add(v);
    visited[v] = true;
    while(!q.isEmpty()){
      v = q.poll();
      System.out.print(v+ " ");
      for(int i=0; i<numofnodes; i++){
        if(AdjMatrix[v][i]==1&&!visited[i]){
          q.add(i);
          visited[i] = true;
        }
      }
    }
   }


}
