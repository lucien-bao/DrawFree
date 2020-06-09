package DrawFree;

import java.awt.*;
import java.util.*;

/**
 * <code>Pencil</code> class. Can draw itself on the canvas.
 */
public class Pencil implements Shape {
	// FIELDS //
	private final static int DRAW_RADIUS = 8;
	private final int[] x, y;
	private final int n;
	
	/**
	 * Creates a new <code>Pencil</code> with the specified coordinates.
	 * @param x X coordinates for the points.
	 * @param y Y coordinates for the points.
	 */
	Pencil(ArrayList<Integer> x, ArrayList<Integer> y) {
		// Converts corners format to x, y, width, height format
		this.x = toArray(x);
		this.y = toArray(y);
		n = x.size();
	}
	
	/**
	 * Helper method to convert from an <code>ArrayList<Integer></code> to <code>int[]</code>.
	 * @param a The <code>ArrayList<Integer></code> to convert.
	 * @return The <code>int[]</code> representation of it.
	 */
	private static int[] toArray(ArrayList<Integer> a) {
		int[] b = new int[a.size()];
		for(int i = 0; i < a.size(); i++)
			b[i] = a.get(i);
		return b;
	}
	
	/**
	 * Returns information about the <code>Pencil</code>'s start- and endpoints.
	 * @return A <code>String</code> representation of this <code>Pencil</code>.
	 */
	@Override
	public String toString() {
		return String.format("Pencil (%d, %d, %d, %d)", x[0], y[0], x[n-1], y[n-1]);
	}
	
	/**
	 * Returns information about the <code>Pencil</code>.
	 * @return A <code>String</code> representation of this <code>Pencil</code>.
	 */
	@Override
	public String toCode() {
		StringBuilder sb = new StringBuilder();
		sb.append("Pencil ");
		for(int i = 0; i < n; i++)
			sb.append(x[i]).append(" ").append(y[i]).append(" ");
		return sb.toString();
	}
	
	/**
	 * Draws this <code>Pencil</code>.
	 * @param g The <code>Graphics2D</code> instance used to draw.
	 */
	@Override
	public void drawShape(Graphics2D g) {
		for(int i = 0; i < n; i++)
			g.fillOval(x[i]-DRAW_RADIUS, y[i]-DRAW_RADIUS,
					DRAW_RADIUS*2, DRAW_RADIUS*2);
	}
}
