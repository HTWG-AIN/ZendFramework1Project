package blatt9;

import java.awt.Color;

public class ArrayDraw {
	// private static double x;
	// private static double y;
	static long startTime;
	static int width;

	private ArrayDraw() {
	}

	public static void init(final int b, final int h) {
		//StdDraw.setCanvasSize(b, h);
		StdDraw.setXscale(0, b);
        StdDraw.setYscale(-2, h);
		StdDraw.clear(Color.WHITE);
		// StdDraw.filledRectangle(0.5, 0.5, 1, 1);
		// StdDraw.setPenColor(Color.WHITE);
		startTime = System.nanoTime();
		width = b;

	}

	public static void draw(int[] a, Color c) {
		StdDraw.clear(Color.WHITE);
		StdDraw.filledSquare(width/2, width/2, width/2);
		StdDraw.setPenColor(c);

		for (int j = 0; j < a.length; j++) {
			StdDraw.filledRectangle(j + 0.5, a[j]/2, 0.5, a[j]/2);
			// StdDraw.filledRectangle((i + 0.5) * x, a[i] * y * 0.5, x * 0.5,
			// a[i]
			// * y * 0.5);
		}

		StdDraw.show(10);
	}

	public static void draw(final int[] a, int i, Color c) {
		StdDraw.setPenColor(c);

		StdDraw.filledRectangle(i + 0.5, a[i]/2, 0.5, a[i]/2);

		StdDraw.show(10);
	}

	public static void showTime() {
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.filledRectangle(width / 2.0, -2.0, width / 2.0, 2.0);
		StdDraw.setPenColor(StdDraw.BLACK);
		double timeSinceStart = ((System.nanoTime() - startTime) / 10000000) / 100.0;
		StdDraw.text(width / 2.0, -3.0, "Time since start: " + timeSinceStart
				+ "s");
		StdDraw.show(10);
	}

}
