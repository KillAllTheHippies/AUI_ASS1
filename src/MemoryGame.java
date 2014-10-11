import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class MemoryGame extends Applet implements ActionListener {

	Label numberSeq;
	TextField input;
	double randomNum;
	int counter = 2;
	String userInput;
	Button b = new Button("Begin");
	Button c = new Button("Check answer");
	String number;
	int roundNo = 0;
	int sleepTime = 1000;
	String smallString = "";
	
	
	public void paint(Graphics g)
	{
		
		
	} // Close paint
	
	public void init() {
		
		randomNum = Math.random();
		number = String.valueOf(randomNum);
		numberSeq = new Label(number);

		input = new TextField(10);
		
		add(numberSeq); // put prompt on applet
		add(input); // put input on applet
		add(b);
		add(c);
		System.out.println(number);
		//for (int i = 1; i < 11; i++)
		//{
		
			//char a = number.charAt(counter);
			//numberSeq.setText(""+a);
		
		//}
		
		
		 //input.addActionListener(this);
		
		 b.addActionListener(this);
		 c.addActionListener(this);
		 input.addActionListener(this);
		
	} // Close init
	
	public void actionPerformed (ActionEvent e) {
		
		b.setLabel("Next");
		for(int i=1; i < 4-roundNo; i++){
			
			char a = number.charAt(counter);
			smallString = smallString + a;
			numberSeq.setText(""+a);
			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			numberSeq.setText("");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if (counter < 12)
			{
			counter++;
			}
			else 
			{
				numberSeq.setText("Game Over");
			}
			
		}// end for
		
		System.out.println(smallString);
		
		
		
		
		//number = Integer.parseInt(e.getActionCommand());// get number
		//input.setText(""); // clear data entry field
		userInput = input.getText();// get number
		
		
		//number = Integer.parseInt(input.getText());
		//sum = sum + number; // add number to sum
		//repaint();
		
		} // Close actionPerformed
	
	
	
} // Close MemoryGame
