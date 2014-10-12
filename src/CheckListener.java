
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CheckListener implements ActionListener {
    private Controller controller;
	public CheckListener(Controller controller)
	{
	this.controller=controller;
	}

	public void actionPerformed(ActionEvent arg0)
    {
		controller.checkAnswer();
	}

}
