import java.awt.Button;
import java.awt.TextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class BeginListener implements ActionListener{

	private Button button;
    private Controller controller;
    TextField input;
	
public BeginListener(TextField input, Button button, Controller controller )
    {
        this.controller=controller;
        this.button=button;
        this.input=input;
    }
	public void actionPerformed(ActionEvent arg0) {
		
		button.setLabel("Reset");
		//TODO: fix this not clearing textfield
        input.setText("");
        controller.reset();
        controller.showSequence();

		} // Close actionPerformed




}


