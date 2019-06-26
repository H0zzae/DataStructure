import java.util.*;

// Name : 허채림
// Student ID : 20181707


class HeapSort {
	int [] heap;	// Heap Array
	int heapSize;	// number of elements in the Heap

	HeapSort(int cap) {
		heap = new int[cap + 1];
		heapSize = 0;
	}

	public String toString() {
		// Convert heap array into a string
		String str;
		str = "Heap : - ";

		for(int i = 1; i <= heapSize; i++)
			str +=  heap[i] + "  ";

		return str;
	}

	void  Init(int [] es, int n) {
		// fill the heap array by the input
		// we need to create heap structure when we call Sort()
		heapSize = n;
		for(int i = 1; i <= n; i++)
			heap[i] = es[i];
	}


	void  Adjust(int root, int n) {
		// adjust binary tree with root "root" to satisfy heap property.
		// The left and right subtrees of "root" already satisfy the heap
		// property. No node index is > n.

		//	"NEED TO IMPLEMENT"
		int left_child = root*2;
		int right_chlid = root*2+1;
		int max;
		if (left_child<n+1&&heap[left_child]>heap[root]){
			max = left_child;
		}
		else max = root;

		if(right_chlid<n+1&&heap[right_chlid]>heap[max]){
			max = right_chlid;
		}
		if (max!=root){
			swap(root,max);
			Adjust(max,n);
		}


	}


	void swap(int i, int j) {
        int tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }

	void  Sort() {
		// sort heap[1:n] into nondecreasing order
		//	"NEED TO IMPLEMENT"
		int [] heapcopy = new int[heapSize+1];
		System.arraycopy(heap,0,heapcopy,0,heapSize+1);
		Arrays.sort(heapcopy);
		for(int i=heapSize/2+1;i>=1;i--){
			Adjust(i,heapSize);
		}
		System.out.println(this);
		for (int i =heapSize; i>1; i--) {
        swap(1, i);
				Adjust(1,i-1);
				System.out.println(this);
    }

	}
}
