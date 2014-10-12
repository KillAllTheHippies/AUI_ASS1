/**
 * Created by Jamie on 11/10/14.
 */
public class Controller {


    private String number;
    private String answer = "";
    private UI ui;
    private char a;
    private int roundNo = 3;
    private double randomNum;
    private int hideTime, showTime;
    final int maxRounds = 10;

    //Constructor
    public Controller(UI ui)
    {
        this.ui =ui;
    }

    public void win()
    {
        System.out.println("you won ");
        reset();
    }
    public void lose()
    {
        System.out.println("you lost ");
        reset();
    }
    public void nextRound()
    {
        if (roundNo >= maxRounds)

        {
            win();
        }
        else
        {
            roundNo++;
            answer=number.substring(2,roundNo+2);
            showSequence();
        }
    }
    public void displayDigit(int index) {
        a = answer.charAt(index);
        sleep(showTime);
        ui.showNo(a);
        sleep(hideTime);
        ui.hideNo();
    }

    public void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e1) {}
    }


    public void reset()
    {
        hideTime=500;
        showTime=1000;
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
