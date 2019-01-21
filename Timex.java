////****************************************************************************************************
// Timex.java
//  This application creates a stop watch GUI that displays the time in seconds and can be controlled by
//  the user using keyboard mnemonics and buttons.
//  *****************************************************************************************************

public class Timex {

    public static void main(String[] args)
    {

        StopWatch sw = new StopWatch();

        sw.setSize(250, 250);
        sw.setResizable(false);
        sw.setVisible(true);
    }
}
