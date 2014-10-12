import java.awt.Button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class BeginListener implements ActionListener{

	private Button button;
    private Controller controller;
	
public BeginListener(Button button, Controller controller )
    {
        this.controller=controller;
        this.button=button;
    }
	public void actionPerformed(ActionEvent arg0) {
		
		button.setLabel("Reset");
        controller.reset();
        controller.showSequence();

		} // Close actionPerformed




}


