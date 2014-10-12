import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;


public class UI extends Applet {

	Label numberSeq, info;
	TextField input;
	Button beginButton = new Button("Begin");
	Button checkButton = new Button("Check answer");
    Controller controller;
	Panel panel;
	
	public void paint(Graphics g)
	{
		
		
	} // Close paint


	
	public void init() {

        controller = new Controller(this);
        panel = new Panel();
        numberSeq = new Label();
        info = new Label();

        input = new TextField(10);
        add(panel);// put panel on applet
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        this.setBackground(Color.black);
        Font f = new Font("Serif",Font.BOLD,20);
        numberSeq.setForeground(Color.yellow);
        numberSeq.setFont(f);
        panel.add(numberSeq); // put prompt on applet
        panel.add(input); // put input on applet
        panel.add(beginButton);
        panel.add(checkButton);
        panel.add(info);
        info.setText("TEST");

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
    public void animate(String text, Color color)
    {

        Font f = new Font("Serif",Font.BOLD,12);
        info.setForeground(color);
        info.setFont(f);
        info.setText(text);

        for(int i = 12; i<20; i+=1)
        {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            f = new Font("Serif",Font.BOLD, i );
            info.setFont(f);
        }
        info.setText("");
    }
	
} // Close UI
