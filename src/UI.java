

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.net.URL;


public class UI extends Applet {

	Label numberSeq, info;
	TextField input;
	Button beginButton = new Button("Begin");
	Button checkButton = new Button("Check answer");
    Controller controller;
	Panel panel;
    ShapeCanvas canvas; //ShapeCanvas Extends Canvas
    Image background;
    URL base;
    MediaTracker tracker;

    public void paint(Graphics g)
	{
        g.drawImage(background, 0, 0, this);
	}

	public void init() {

        base = getDocumentBase();
        background = getImage(base, "background.gif");

        tracker = new MediaTracker(this);
        tracker.addImage(background, 1);

        try {
            tracker.waitForAll();
        }
        catch (InterruptedException  e) {}

        controller = new Controller(this);
        panel = new Panel();

        numberSeq = new Label();
        info = new Label();

        canvas=new ShapeCanvas(controller);

        canvas.setBounds(0,0,100,100);
        canvas.setBackground(Color.GRAY);
        

        input = new TextField(10);
        add(panel);// put panel on applet
        panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));
        //this.setBackground(Color.black);
        
        Font f = new Font("Serif",Font.BOLD,50);
        numberSeq.setForeground(Color.yellow);
        numberSeq.setBackground(Color.black);
        numberSeq.setAlignment(Label.CENTER);
        numberSeq.setFont(f);
        //numberSeq.setAlignment(CENTER_ALIGNMENT);
        
        panel.add(numberSeq); // put prompt on applet
        panel.add(input); // put input on applet
        panel.add(beginButton);
        panel.add(checkButton);


        panel.add(info);
        info.setAlignment(Label.CENTER);

        panel.add(canvas);
        info.setText("Ready");

        ActionListener beginListener = new BeginListener(input, beginButton, controller);
        ActionListener chkListener = new CheckListener(controller);
        ActionListener inputListener = new InputListener(controller);
        beginButton.addActionListener(beginListener);
        checkButton.addActionListener(chkListener);
        input.addActionListener(inputListener);

        start();


    } // Close init
    public void showNo(char a)
    {

        numberSeq.setText(""+a);
    }
    public void hideNo()
    {
        numberSeq.setText("");
    }
    public void start()
    {
        controller.reset();

    }
    public String getUserInput()
    {
        return input.getText();
    }
    public void clearInput()
    {
        input.setText("");
        input.requestFocus();
    }
    public void animate(String text, Color color)
    {
    	Graphics g = info.getGraphics();
        Font f = new Font("Serif",Font.BOLD,12);
        FontMetrics metrics = g.getFontMetrics(f);
    	
        info.setForeground(color);
        info.setFont(f);
        info.setText(text);

        int size = 12; // give the while loop a counter
        while(metrics.getHeight() < info.getHeight() && getStringWidth(text, f, g) < info.getWidth())
        {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            f = new Font("Serif",Font.BOLD, size++ ); // increment size
            metrics = g.getFontMetrics(f);
            
            info.setFont(f);
        }
        info.setText("");
    }
    	
    public int getStringWidth(String s, Font f, Graphics g)
    {
    	FontMetrics metrics;
    	metrics = g.getFontMetrics(f);
    	return metrics.stringWidth(s);
	
    	}
    	
    public void drawPie()
    {
    	canvas.drawPieChart();
    	canvas.paint(canvas.getGraphics());
    }
    
	
} // Close UI
