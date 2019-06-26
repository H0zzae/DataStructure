// Lab 007	: Disjoint Sets
// Name :
// Student ID :

import java.util.*;


class DisjointSets {
	int numofelements;  // the total number of elements in all the disjoint sets
	private int[] parent; // maintains the parent pointer of each element in the disjoint sets
	private int[] weight; // maintains the weight of each set


	DisjointSets() {
		// DisjointSets constructor.
	}

	public String toString() { // Show all the element in sequence
		String str = new String();
	    // Show the array elements in parent[]

		str = "parent[] = - ";
		for(int i = 1; i <= numofelements; i++)
			str += parent[i] + " ";
		return str;
	}

	void InitSet(int n) {
		// Initialize the array parent[] and weight[]
			numofelements = n;
			parent = new int[n+1];
			for(int i=1;i<n+1;i++){
				parent[i] = 0;
			}
			weight = new int[n+1];

	}

	boolean Union(int i, int j) {
	// Union the set that contains i and the set that contains j
	// the set that has larger weight is the new root of the unioned set
	// when the weights are the same, choose the root of smaller value

		// first find the root of i and j
		int rooti,rootj,sroot,broot,roots,rootb;
		rooti = SimpleFind(i);
		rootj = SimpleFind(j);
		if(rooti==rootj){
			return false;
		}else{
			if(weight[rooti]==weight[rootj]){
				sroot = rooti>rootj?rootj:rooti;
				broot = sroot==rooti?rootj:rooti;

				parent[sroot] = broot;
				if((weight[broot]==0)&&(weight[sroot]==0)){
					weight[sroot] = 1;
			}
				weight[broot] += weight[sroot];
				weight[sroot] = 0;
			}else{
				roots = weight[rooti]>weight[rootj]?rootj:rooti;
				rootb = (roots==rooti)?rootj:rooti;

				parent[roots] = rootb;
				if((weight[rootb]==0)&&(weight[roots]==0)){
					weight[roots] = 1;
			}
				weight[rootb] +=weight[roots];
				weight[roots] = 0;
			}
		return true;
		}



	}

	int SimpleFind(int i) {
	// return the root node that contains the element i

		int root = i;
		while(true){
			if(parent[root]!=0){
				root = parent[root];
			}else if(parent[root]==0){
				break;
			}
		}


		return root;
	}
}
