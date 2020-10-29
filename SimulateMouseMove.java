import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public class SimulateMouseMove {
	public static final int WAIT = 60000;   // How Long To Delay Between Mouse Moves in Milliseconds
	public static void main(String[] args) throws Exception {
		Robot myMouse = new Robot();
		int lastx = -65000;
		int lasty = -65000;
		while(true) {
			myMouse.delay(WAIT);
			Point p = MouseInfo.getPointerInfo().getLocation();    // Get current mouse pointer location
			int x = p.x;
			int y = p.y;
			if (lastx == -65000) { lastx = x; }
			if (lasty == -65000) { lasty = y; }
			int randx = ThreadLocalRandom.current().nextInt(-1,2);   // Generate random integer between -1 and 1 (to be used for x axis mouse move)
			int randy = ThreadLocalRandom.current().nextInt(-1,2);   // Generate random integer between -1 and 1 (to be used for y axis mouse move)
			int movex = x+randx;
			int movey = y+randy;
			if (((x-lastx)<=2) && ((y-lasty)<=2)) {     // If the mouse has not been moved manually -- prevents jiggle if the mouse is actually in use
				myMouse.mouseMove(movex,movey);     // Move mouse
				myMouse.delay(100);
				myMouse.mouseMove(x,y);             // Move mouse back to original location
				System.out.print("#");
			}
			else {
				System.out.print("-");
			}
			lastx = x;
			lasty = y;
		}
	}
}