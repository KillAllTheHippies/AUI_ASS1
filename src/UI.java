import java.awt.*;
import java.awt.event.*;
import java.applet.*;


public class UI extends Applet {

	Label numberSeq, info;
	TextField input;
	Button beginButton = new Button("Begin");
	Button checkButton = new Button("Check answer");
    Controller controller;
	
	
	public void paint(Graphics g)
	{
		
		
	} // Close paint


	
	public void init() {

        controller = new Controller(this);
        numberSeq = new Label();
        info = new Label();

        input = new TextField(10);

        add(numberSeq); // put prompt on applet
        add(input); // put input on applet
        add(beginButton);
        add(checkButton);
        add(info);

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
        input.repaint();
        input.requestFocus();
        
    }
	
} // Close UI
