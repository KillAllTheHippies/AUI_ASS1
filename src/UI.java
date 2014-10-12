import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class UI extends Applet {

	Label numberSeq;
	TextField input;
	Button b = new Button("Begin");
	Button c = new Button("Check answer");
    Controller controller;
	
	
	public void paint(Graphics g)
	{
		
		
	} // Close paint


	
	public void init() {

        controller = new Controller(this);
        numberSeq = new Label();

        input = new TextField(10);

        add(numberSeq); // put prompt on applet
        add(input); // put input on applet
        add(b);
        add(c);

        ActionListener beginListener = new BeginListener(b, controller);
        ActionListener chkListener = new CheckListener(controller);
        b.addActionListener(beginListener);
        c.addActionListener(chkListener);
       // input.addActionListener(beginListener);

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
    }
	
} // Close UI
