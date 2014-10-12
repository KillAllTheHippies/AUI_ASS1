import java.awt.*;

public class ShapeCanvas extends Canvas{

	
	public void paint(Graphics g){
		drawShapes();
	}
	
	public void drawShapes()
    {
        Graphics g = getGraphics();
        g.setColor(Color.BLUE);

        g.drawOval(50, 50, 50, 50);
        int x[] = {20,10,30,95};
        int y[] = {50,40,10,47};
        g.drawPolygon(x,y,4);

    }
}
