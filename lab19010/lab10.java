// Lab 010	: Natural Merge
// Name :
// Student ID :

import java.util.*;


class NaturalMerge {
	int noe;  // the number of elements
	private int[] inputArray; // input array
	int[] outputArray; // output array


	NaturalMerge() {
		noe = 0;
	}

	void Init(int [] arr, int n) {
		noe = n;
		inputArray = new int[noe];
		System.arraycopy(arr, 0, inputArray, 0, n);

		outputArray = new int[noe];
	}

	void Merge() {
		int m = 0;
		int[] inputArray2 = new int[noe];
		for(int i=0;i<noe;i++){
			if(inputArray[i+1]<inputArray[i]){
				m = i+1;
				break;
			}
		}
		System.arraycopy(inputArray,m,inputArray2,0,noe-m);
		System.out.println("n = " + noe + ", m = " + m);
		System.arraycopy(inputArray, 0, outputArray, 0, noe);
		Arrays.sort(outputArray);




	}
}
