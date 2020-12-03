package dm.v1;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JPanel;





public class ChartFrame {

    public static JFXPanel fxPanel ;

    //Method creates a JFrame which contians and fxPanel which the graph can then be added too
    
    public static void ChartFrame(Boolean IsBarChart) {
        JFrame frame = new JFrame("FX");
        frame.setSize(1000, 800);
        frame.setLocationByPlatform(true); //???
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER));
       
        StackList.createList(IsBarChart, frame);

        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));      //Layout of the GUI

        JButton button = new JButton("Add Data");       //Restarts the selection of data but saves the data already appeneed to the graph
        button.setSize(40, 40);
        
        button.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Inject.clear();
                DMV1.selectionProgress = 1;
                frame.dispose();
                DMV1.newBar(IsBarChart);
                //frame.repaint();

            }
        }
        );

        JButton restartButton = new JButton("Restart Selection");  //Cleares all arraylists and sends you back to the menu where you can choose a line graph or bar graph
        restartButton.setSize(40, 40);

        restartButton.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Bar.clear();
                Inject.clear();
                DMV1.selectionProgress = 1;
                frame.dispose();
                DMV1.Menu();

            }
        }
        );

        JButton emailButton = new JButton("Email Graph");   //Opens GUI that allows you to email a PNG of the graph
        emailButton.setSize(40, 40);

        emailButton.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HaveEmail HE = new HaveEmail();    //GUI pop up for email sending
                HE.setVisible(true);

            }
        }
        );

        fxPanel = new JFXPanel();

        p.add(button);
        p.add(emailButton);
        p.add(restartButton);
        frame.add(p);

        frame.setVisible(true);
        frame.add(fxPanel);

        Platform.setImplicitExit(false);           
        Platform.runLater(new Runnable() { //Invokes the runnable which will create the barchart and add it to the FxPanel
            @Override
            public void run() {
                BarCharts.start(fxPanel, IsBarChart);
            }

        });

    }

}
