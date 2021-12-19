package Server.core;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private DetailsPanel detailsPanel;
    public MainFrame(String title){
        super(title);

        setLayout(new BorderLayout());
        JButton button1=new JButton("Start");
        JButton button2=new JButton("Stop");
        JButton button3=new JButton("Maintenance");
        JButton button4=new JButton("Close");

        detailsPanel=new DetailsPanel();

        Container c = getContentPane();
        c.add(button1,BorderLayout.NORTH);
        c.add(button2,BorderLayout.WEST);
        c.add(button3,BorderLayout.NORTH);
        c.add(button4,BorderLayout.NORTH);
        c.add(detailsPanel,BorderLayout.WEST);
    }



}
