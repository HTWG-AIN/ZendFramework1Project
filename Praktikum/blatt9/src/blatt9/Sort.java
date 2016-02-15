package blatt9;

import java.awt.Color;

public class Sort {

	private Sort() {
	}

	/*--------------------------------------------------------------------------------------------------------------*/

	public static void insertionSort(final int[] a) {

		for (int i = 1; i < a.length; i++) {

			int v = a[i]; // Nach vertauschen kommt BLUE
			ArrayDraw.draw(a, StdDraw.BLUE);
			int j = i - 1;
			while (j >= 0 && a[j] > v) { // Feldelement in einem Vergleich
											// beteiligt -> Das gesamte Feld neu
											// gezeichnet

		//		ArrayDraw.draw(a, j, Color.RED);

				a[j + 1] = a[j];// Nach vertauschen kommt BLUE
		//		ArrayDraw.draw(a, StdDraw.BLUE);

				j--;
			}
			if(j != -1)
			ArrayDraw.draw(a, j, Color.RED);

			a[j + 1] = v;
			// Nach vertauschen kommt BLUE -> Das gesamte Feld neu gezeichnet
			ArrayDraw.draw(a, Color.BLUE);

		}
		// ArrayDraw.draw(a, Color.BLUE);
		ArrayDraw.showTime();
	}

	/*--------------------------------------------------------------------------------------------------------------*/

	public static void quickSort(final int[] a) {
		// ArrayDraw.init(a.length, a.length, "QuickSort");
		ArrayDraw.draw(a, Color.BLUE);

		quickSort(a, 0, a.length - 1);
		ArrayDraw.draw(a, Color.BLUE);

		ArrayDraw.showTime();
	}

	/*--------------------------------------------------------------------------------------------------------------*/

	public static void quickSort(final int[] a, final int links,
			final int rechts) {

		int li = links;
		int re = rechts;

		while (re > li) {
			ArrayDraw.draw(a,re, Color.RED);
			ArrayDraw.draw(a,li, Color.RED);


			// Teileschritt:
			int i = partition(a, li, re);
			// Herrscheschritt:
			if (i - li < re - i) {
				quickSort(a, li, i - 1);
				li = i + 1; // quicksortTailRecElim(a,i+1,re);
			} else {
				quickSort(a, i + 1, re);
				re = i - 1; // quicksortTailRecElim(a,li,i-1);
			}
		}
	}

	/*--------------------------------------------------------------------------------------------------------------*/

	private static int partition(final int[] a, final int li, final int re) {
		int v = a[re]; // Pivotelement
	//	ArrayDraw.draw(a, StdDraw.BLUE);
		int i = li - 1;
		int j = re;
		while (true) {

			do {
				i++;
			//	ArrayDraw.draw(a, i, StdDraw.RED);
			//	ArrayDraw.draw(a, re, StdDraw.RED);
			} while (a[i] < v);
			do {
			//	ArrayDraw.draw(a, i, StdDraw.RED);
			//	ArrayDraw.draw(a, re, StdDraw.RED);
				j--;
			} while (j >= li && a[j] > v);
			if (i >= j) {
				break;
			}

			// a[i] und a[j] vertauschen:
			int t = a[i];
			a[i] = a[j];
		//	ArrayDraw.draw(a, StdDraw.BLUE);
			a[j] = t;
			ArrayDraw.draw(a, StdDraw.BLUE);

		}
		// Pivotelement a[r] und a[i] vertauschen:
		a[re] = a[i];
	//	ArrayDraw.draw(a, Color.BLUE);

		a[i] = v;
	//	ArrayDraw.draw(a, Color.BLUE);

		ArrayDraw.showTime();
		return i;
	}

	/*--------------------------------------------------------------------------------------------------------------*/
	/*--------------------------------------------------------------------------------------------------------------*/
	/*--------------------------------------------------------------------------------------------------------------*/
	/*--------------------------------------------------------------------------------------------------------------*/
	/*--------------------------------------------------------------------------------------------------------------*/
	/*--------------------------------------------------------------------------------------------------------------*/
	/*--------------------------------------------------------------------------------------------------------------*/

	public static void quickSort3Median(final int[] a) {
		// ArrayDraw.init(a.length, a.length, "QuickSort3Median");
		quickSort3Median(a, 0, a.length - 1);
		 ArrayDraw.draw(a, Color.BLUE);
			ArrayDraw.showTime();


	}

	/*--------------------------------------------------------------------------------------------------------------*/

	private static void quickSort3Median(final int[] a, final int links,
			final int rechts) {

		int li = links;
		int re = rechts;

		while (re > li) {
			// Teileschritt:
			int i = partition3Median(a, li, re);
			 ArrayDraw.draw(a,  Color.BLUE);
			 ArrayDraw.draw(a, re, Color.RED);
			 ArrayDraw.draw(a, li, Color.RED);

			// Herrscheschritt:
			if (i - li < re - i) {
				quickSort3Median(a, li, i - 1);
				li = i + 1; // quicksortTailRecElim(a,i+1,re);
			} else {
				quickSort3Median(a, i + 1, re);
				re = i - 1; // quicksortTailRecElim(a,li,i-1);
			}
		}
	}

	/*--------------------------------------------------------------------------------------------------------------*/

	private static int partition3Median(final int[] a, final int li,
			final int re) {

		// 3 Median
		int mi = (re + li) / 2;

	//	ArrayDraw.draw(a, Color.BLUE);

		if ((a[li] < mi && a[li] > re) || (a[li] > mi && a[li] < re)) {
			// ArrayDraw.draw(a, li, Color.RED);
			int t = a[li];
			a[li] = a[re];
			a[re] = t;
		} else if ((a[mi] < li && a[mi] > re) || (a[mi] > li && a[mi] < re)) {
			// ArrayDraw.draw(a, mi, Color.RED);
			int t = a[mi];
			a[mi] = a[re];
			a[re] = t;
		} else {
			// ArrayDraw.draw(a, re, Color.RED);
		}
	//	ArrayDraw.draw(a, StdDraw.BLUE);
		int v = a[re]; // Pivotelement
		int i = li - 1;
		int j = re;
		while (true) {
			do {
				i++;
			//	ArrayDraw.draw(a, i, StdDraw.RED);
			//	ArrayDraw.draw(a, re, StdDraw.RED);
			} while (a[i] < v);
			do {
			//	ArrayDraw.draw(a, i, StdDraw.RED);
			//	ArrayDraw.draw(a, re, StdDraw.RED);
				j--;

			} while (j >= li && a[j] > v);
			if (i >= j) {
				break;
			}

			// a[i] und a[j] vertauschen:
			int t = a[i];
			a[i] = a[j];
	//		ArrayDraw.draw(a,re, StdDraw.BLUE);
			a[j] = t;
	//		ArrayDraw.draw(a,li, StdDraw.BLUE);

		}

		// Pivotelement a[r] und a[i] vertauschen:
		a[re] = a[i];
	//	ArrayDraw.draw(a, StdDraw.BLUE);
		a[i] = v;
	//	ArrayDraw.draw(a, StdDraw.BLUE);

		ArrayDraw.showTime();
		return i;
	}

}
