import java.awt.Button;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class BeginListener implements ActionListener{

	private int roundNo = 0;
	private String number;
	private String smallString;
	private String userInput;
	private int counter = 2;
	private Label label;
	private int sleepTime = 1000;
	private Button button;
	
public BeginListener(Label numberSeq,Button b, String userInput )
{
	this.label=numberSeq;
	this.button=b;
	this.userInput=userInput;
	
}
	public void actionPerformed(ActionEvent arg0) {
		
		button.setLabel("Next");
		for(int i=1; i < 4-roundNo; i++){
			
			displayNo();
			
			clearLabel();
			
			if (counter < 12)
			{
			counter++;
			}
			else 
			{
				label.setText("Game Over");
			}
			
		}// end for
		
		System.out.println(smallString);

		
		} // Close actionPerformed
	private void displayNo() {
		char a = number.charAt(counter);
		smallString = smallString + a;
		label.setText(""+a);
	}
	private void clearLabel() {
		sleep(sleepTime);
		label.setText("");
		sleep(500);
	}
	private void sleep(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e1) {}
	}
	
	}


