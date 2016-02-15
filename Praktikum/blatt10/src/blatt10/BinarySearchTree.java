// O. Bittel
// 17.5.2011

package blatt10;

import java.util.LinkedList;
import java.util.List;

public class BinarySearchTree {
	// 'static' here ensures that each 'Node' does not cache a reference to
	// 'BinarySearchTree'.
	static private class Node {
		private int data;
		private Node left;
		private Node right;

		private Node(int x) {
			data = x;
			left = null;
			right = null;
		}
	}

	private Node root = null;
	private int size = 0;

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder("BinarySearchTree: ");
		appendR(s, root);
		s.append(" size = ").append(size);
		return s.toString();
	}

	private static void appendR(StringBuilder s, Node p) {
		if (p != null) {
			appendR(s, p.left);
			s.append(p.data).append(", ");
			appendR(s, p.right);
		}
	}

	public boolean contains(int x) {
		return containsR(x, root);
	}

	private boolean containsR(int x, Node p) {
		if (p == null)
			return false;
		else if (x < p.data)
			return containsR(x, p.left);
		else if (x > p.data)
			return containsR(x, p.right);
		else
			return true;
	}

	public void insert(int x) {
		root = insertR(x, root);
		assert isBinarySearchTree(root);
	}

	private Node insertR(int x, Node p) {
		if (p == null) {
			size++;
			return new Node(x);
		}
		if (x < p.data)
			p.left = insertR(x, p.left);
		else if (x > p.data)
			p.right = insertR(x, p.right);
		// im else-Fall ist nicht zu tun; keine doppelten Werte
		return p;
	}

	public void remove(int x) {
		root = removeR(x, root);
		assert isBinarySearchTree(root);
	}

	private Node removeR(int x, Node p) {
		if (p == null)
			return null;
		if (x < p.data)
			p.left = removeR(x, p.left);
		else if (x > p.data)
			p.right = removeR(x, p.right);
		else {
			// Knoten loeschen:
			if (p.left == null || p.right == null) {
				// One or no child can be deleted directly:
				size--;
				p = (p.left != null) ? p.left : p.right;
			} else {
				// Two children Node p = null;

				p.data = getMin(p.right);
				p.right = removeR(p.data, p.right);
			}
		}
		return p;
	}

	private int getMin(Node p) {
		assert (p != null);
		while (p.left != null)
			p = p.left;
		return p.data;
	}

	public void clear() {
		root = null;
		size = 0;
	}

	public int getSize() {
		return size;
	}

	/*----------------------------------------------------------------------------------------
	 * --------------------------------------------------------------------------------------
	 * -------------------------------------------------------------------------
	 * --------------------------------------------------------
	 * -------------------------------------------
	 * -----------------------------*/
	public void prettyPrint() {
		StringBuilder s = new StringBuilder();
		// 0 damit kein Ding "|_" für root geprintet wird; wird zu ""size""
		// ansonsten
		prettyPrintR(root, 0, s);
		System.out.println(s);
	}

	private static void prettyPrintR(Node p, int tiefe, StringBuilder s) {
		// Einrückung
		for (int i = 1; i < tiefe; i++) {
			// System.out.print(" ");
			s.append("  ");
		}
		// das wird am Anfang nicht geprintet (siehe Kommentar in prettyPrint)
		if (tiefe > 0)
			s.append("|__");

		if (p != null)
			s.append(p.data);
		else
			s.append("#");

		s.append("\n");
		// bei dem Knoten '1' im Baum wird das nicht ausgeführt da 1 hat keine
		// Kinder weder left
		// noch right
		if (p != null && (p.left != null || p.right != null)) {
			prettyPrintR(p.left, tiefe + 1, s);
			prettyPrintR(p.right, tiefe + 1, s);
		}
		// System.out.println(p.data); wenn p != null
		// prettyPrint(p.left, tiefe ); alle left Knoten printen
		// prettyPrint(p.right, tiefe );
	}

	private static int getHight(Node p) {

		if (p != null) {
			// Die 1 ist für die Wurzel
			return 1 + Math.max(getHight(p.left), getHight(p.right));
		} else
			return -1;

	}

	public void statistik() {

		/*
		 * FORMEL für Durchschnitliche Tiefe : Höhe 0 hat einen Knoten (root);
		 * Höhe 1 hat zwei Knoten; Höhe 2 hat 3 Knoten; Höhe 3 hat 1 Knoten
		 */
		double depth = 0;
		int anzahlInEbene = 0;
		// ArrayList<Integer> liste = new ArrayList<Integer>();
		//
		// for (int i = 0; i <= getHight(root); i++) {
		// anzahlInEbene += liste.get(i) * (i);
		// }
		// depth = anzahlInEbene / (double) getSize();

		// System.out.println("Durchschnitliche Tiefe  : " + depth);
		int[] array = new int[getHight(root) + 1];
		getAnzEbene(0, root, array);

		for (int i = 0; i < array.length; i++) {
			anzahlInEbene += array[i] * (i);
		}
		depth = anzahlInEbene / (double) getSize();

		System.out.println("Durchschnitliche Tiefe  : " + depth);

		System.out.println("Anzahl Einträge : " + getSize());
		System.out.println("Baumhöhe : " + getHight(root));
	}

	private void getAnzEbene(int ebene, Node node, int[] array) {
		array[ebene] += 1;
		if (node != null && node.left != null) {
			getAnzEbene(ebene + 1, node.left, array);
		}
		if (node != null && node.right != null) {
			getAnzEbene(ebene + 1, node.right, array);
		}

	}

	public void subSet(int a, int b, List<Integer> list) {
		subSetR(root, a, b, list);
	}

	private static void subSetR(Node p, int a, int b, List<Integer> list) {
		if (p == null)
			return;
		if (p.data >= a && p.data <= b)
			list.add(p.data);
		if ((p.left != null && p.left.data >= a) || p.data >= a)
			subSetR(p.left, a, b, list);
		if ((p.right != null && p.right.data <= b) || p.data <= b)
			subSetR(p.right, a, b, list);

	}

	private boolean isBinarySearchTree(Node p) {
//		if (p == null)
//			return true;
//		if (p.left == null && p.right == null) {
//			return true;
//		}
//		if (lessThan(maximum(p.left), root) && lessThan(minimum(p.right), root)) {
//			return true;
//		}
//		return false;
		 return p == null
		 || (isBinarySearchTree(p.left)
		 && isBinarySearchTree(p.right)
						&& (maximum(p.left) == null || maximum(p.left).data < p.data) && (minimum(p.right) == null || minimum(p.right).data > p.data));
	}

	public Node minimum(Node p) {
		if (p == null)
			return null;
		if (p.left == null)
			return p;
		return minimum(p.left);
	}

	public Node maximum(Node p) {
		if (p == null)
			return null;
		if (p.right == null)
			return p;
		return maximum(p.right);
	}

	public boolean lessThan(Node p, Node q) {
		if (p == null || q == null)
			return true;
		if (p != null && q != null)
			return p.data < q.data;
		return false;
	}

	public static void main(String[] args) {

		BinarySearchTree t = new BinarySearchTree();
		t.insert(5);
		t.insert(3);
		t.insert(8);
		t.insert(1);
		t.insert(4);
		t.insert(6);
		t.insert(7);
		// t.remove(7);

		System.out.println(t);
		t.prettyPrint();
		t.statistik();
		LinkedList<Integer> list = new LinkedList<>();
		t.subSet(1, 4, list);
		System.out.println(list);
		// System.out.println(t.inBinarySearchTree(t.root));

	}

}