import java.awt.*;

public class Controller {


    private String number;
    private String answer = "";
    private UI ui;
    private char a;
    public int roundNo = 3;
    private double randomNum;
    private int hideTime, showTime;
    final int maxRounds = 4;
    private int score = 1;


    //Constructor
    public Controller(UI ui)
    {
        this.ui =ui;
        hideTime=300;
        showTime=500;
    }

    public void win()
    {
        ui.animate("you won ", Color.ORANGE);
        ui.animate("Score: "+score++, Color.GREEN);
        increaseDifficulty();
        reset();
    }
    public void lose()
    {
        ui.animate("you lost ", Color.RED);
        ui.animate("Score: "+score, Color.RED);
        reset();
    }
    public void nextRound()
    {
        if (roundNo++ >= maxRounds)

        {
        	
        	ui.drawPie(); 
            win();
        }
        else
        {
        	
            ui.drawPie(); 
            answer=number.substring(2,roundNo+2);
            ui.clearInput();
            ui.animate("Correct", Color.GREEN);
            ui.animate("Score: "+score++, Color.GREEN);
            showSequence();
            increaseDifficulty();
        }
    }
    public void increaseDifficulty()
    {
        if (hideTime>100)
    	    hideTime -= 10;
        if (showTime>100)
            showTime -= 25;
    }
    public void displayDigit(int index) {
        a = answer.charAt(index);
        sleep(hideTime);
        ui.showNo(a);
        sleep(showTime);
        ui.hideNo();
    }

    public void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e1)
        {
            e1.printStackTrace();
        }
    }


    public void reset()
    {
//    	if(ui!=null)
//    		ui.clearPie();
    	

        randomNum = Math.random();
        number = String.valueOf(randomNum);
        System.out.println(number);
        roundNo = 3;
        answer=number.substring(2,5);
        
    }
    public void showSequence()
    {
        for(int i=0;i<roundNo;i++)
        {
            displayDigit(i);
        }

    }

    public void checkAnswer()
    {
        String userInput = ui.getUserInput();
        ui.clearInput();
        if (userInput.equals(answer))
        {
            nextRound();

        }
        else
        {
            lose();
        }

    }

    


}
