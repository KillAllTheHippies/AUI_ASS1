import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Event listener for textField
 */

public class InputListener implements ActionListener {

    private Controller controller;

    public InputListener(Controller controller)
    {
        this.controller=controller;
    }

    
    public void actionPerformed(ActionEvent e)
    {
        controller.checkAnswer();
    }
}
