////****************************************************************************************************
// StopWatch.java
//  Represents a stopwatch. Frame includes radio buttons for controls to stop, start and reset the watch.
//  A timer object is used to display a string representation of the time in seconds.
//  *****************************************************************************************************

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StopWatch extends JFrame {

    //labels
    private JLabel heading = new JLabel("Timer");
    private JLabel seconds = new JLabel("seconds");

    //text field
    private JTextField timerarea = new JTextField(10);

    //buttons
    private ButtonGroup timerGroup = new ButtonGroup();
    private JRadioButton startbutton = new JRadioButton("Start");
    private JRadioButton stopbutton = new JRadioButton("Stop");
    private JRadioButton resetbutton = new JRadioButton("Reset");
    private ButtonListener listener = new ButtonListener();

    //timer
    private Timer timer = new Timer(100, new TimerListener());
    private int miliseconds;
    private double time;
    private String timestr;

    //panel
    private JPanel headingpanel = new JPanel();
    private JPanel datapanel = new JPanel();
    private JPanel buttonpanel = new JPanel();


    public StopWatch()
    {
            setTitle("Stop Watch");

            //borders and fonts
            Font font = new Font("Bauhaus 93", Font.PLAIN, 30);
            Font borderfont = new Font("Helvetica", Font.PLAIN, 13);
            LineBorder border = new LineBorder(Color.MAGENTA, 1);
            TitledBorder titledBorder = new TitledBorder(border, "Controls");

             //heading area

            heading.setFont(font);
            heading.setForeground(Color.MAGENTA);
            headingpanel.add(heading);

            //data area
            timerarea.setText(0.0 +  "");
            seconds.setFont(borderfont);
            datapanel.add(timerarea);
            datapanel.add(seconds);
            seconds.setForeground(Color.MAGENTA);
            timerarea.setEditable(false);
            timerarea.setFont(font);
            timerarea.setForeground(Color.MAGENTA);
            timerarea.setBackground(Color.pink);
            timerarea.setHorizontalAlignment(JTextField.CENTER);
            timerarea.setBorder(BorderFactory.createEmptyBorder());


            //timerarea.setBorder(border);

            //button area
            startbutton.addActionListener(listener);
            startbutton.setActionCommand("start");
            startbutton.setBackground(Color.pink);
            startbutton.setForeground(Color.MAGENTA);
            startbutton.setFont(borderfont);

            //start button controlled by 'S' + Alt key
            startbutton.setMnemonic('S');

            stopbutton.addActionListener(listener);
            stopbutton.setActionCommand("stop");
            stopbutton.setBackground(Color.pink);
            stopbutton.setForeground(Color.MAGENTA);
            stopbutton.setFont(borderfont);

            //stop button controlled by 'T' + Alt key
            stopbutton.setMnemonic('T');

            resetbutton.addActionListener(listener);
            resetbutton.setActionCommand("reset");
            resetbutton.setBackground(Color.pink);
            resetbutton.setForeground(Color.MAGENTA);
            resetbutton.setFont(borderfont);

            //reset button controlled by 'R + Alt key
            resetbutton.setMnemonic('R');

            timerGroup.add(startbutton);
            timerGroup.add(stopbutton);
            timerGroup.add(resetbutton);
            timerGroup.clearSelection();

            buttonpanel.add(startbutton);
            buttonpanel.add(stopbutton);
            buttonpanel.add(resetbutton);

            //set borders
            titledBorder.setTitleFont(borderfont);
            titledBorder.setTitleColor(Color.MAGENTA);
            buttonpanel.setBorder(titledBorder);

            //add panels to frame
            add(headingpanel);
            add(datapanel);
            add(buttonpanel);

            //set frame colour and borders
            headingpanel.setBackground(Color.PINK);
            datapanel.setBackground(Color.PINK);
            buttonpanel.setBackground(Color.PINK);
            getContentPane().setBackground(Color.PINK);
            getRootPane().setBorder(BorderFactory.createLineBorder(Color.MAGENTA, 3));

            //layouts
            setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
            buttonpanel.setLayout(new BoxLayout(buttonpanel, BoxLayout.X_AXIS));
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

    //starts timer
    public  void startWatch(ActionEvent evt)
    {
        timer.start();
    }

    //stops timer
    public void stopWatch(ActionEvent evt)
    {
        timer.stop();
    }

    //resets timer
    public void resetWatch(ActionEvent evt)
    {
        miliseconds = 0;
        setTime();
        timerarea.setText(getTime());
    }

    //returns string representation of the time
    public String getTime()
    {
        timestr = new Double(time) + "";
        return timestr;
    }

    //sets the time
    public void setTime()
    {
        time = ((double) miliseconds) / 10.0;
    }

    //sets error message
    public void setError()
    {
        timerarea.setText("Timer Error");
    }

    //represents a listener for timer events
    public class TimerListener implements ActionListener
    {
        public void actionPerformed(ActionEvent evt)
        {
            miliseconds++;
            setTime();
            timerarea.setText(getTime());
        }
    }

    //represents a listener for button push events
    public class ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent evt)
        {
            try
            {
                if (evt.getActionCommand().equals("start"))
                {
                    startWatch(evt);
                }

                if (evt.getActionCommand().equals("stop"))
                {
                    stopWatch(evt);
                }

                if (evt.getActionCommand().equals("reset"))
                {
                    resetWatch(evt);
                }

            }
            catch (Exception ex)
            {
                setError();
            }
        }
    }

}


