// Lab 011	: Huffman Merging Runs
// Name : 허채림
// Student ID : 20181707

import java.util.*;


class Huffman {
	int noe;  // the number of elements
	private int[] inputArray; // input array


	Huffman() {
		// Graph constructor.
		noe = 0;
	}

	void Init(int [] arr, int n) {
		noe = n;
		inputArray = new int[noe];
		System.arraycopy(arr, 0, inputArray, 0, n);
		System.out.print("Runs : ");
		for(int i = 0; i < noe; i++) {
			System.out.print(inputArray[i] + " ");
		}
		System.out.println();
	}

	void MergeRuns() {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		int sum =0,num=0;
		for(int i=0;i<noe;i++){
			pq.add(inputArray[i]);
		}
		while(noe>=2) {
			num = pq.poll();
			System.out.println("Merging "+num+" "+pq.peek());
			sum = num+pq.poll();
			pq.add(sum);
			noe--;
		}

	}
}
