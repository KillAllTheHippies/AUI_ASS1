import java.awt.*;

public class ShapeCanvas extends Canvas{

	private Controller controller;
	private Graphics g;
	
	
	public ShapeCanvas(Controller controller)
	{
		this.controller=controller;
	}
	
	public void paint(Graphics g){
		this.g= g;
		drawShapes();
		drawPieChart();
		
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
	
	public void drawPieChart()
	{
		int roundNo = controller.roundNo -3 ; // because roundNo starts at 3.
		int maxRounds = controller.maxRounds -2; 
		int angle = (360 / maxRounds);	// get the angle of each pie slice	
		g.setColor(Color.BLACK);
		g.fillOval(50, 50, 50, 50); // draw pie chart circle
		g.setColor(Color.RED);
		g.fillArc(50, 50, 50, 50, 0, (angle*roundNo)); // draw all pie slices
		
		
	}
//	public void clearPieChart()
//	{
//		if (g == null) return;
//		g.setColor(Color.BLACK);
//		g.fillOval(50, 50, 50, 50); // draw pie chart circle
//	}
}

