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

    public static JFXPanel fxPanel;

    public static void ChartFrame(Boolean IsBarChart) {
        JFrame frame = new JFrame("FX");
        frame.setSize(1000, 800);
        frame.setLocationByPlatform(true); //???
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER));
       
        StackList.createList(IsBarChart, frame);

        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));

        JButton button = new JButton("Add Data");
        button.setSize(40, 40);

        button.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Inject.clear();
                DMV1.n = 1;
                frame.dispose();
                DMV1.newBar(IsBarChart);
                //frame.repaint();

            }
        }
        );

        JButton restartButton = new JButton("Restart Selection");
        restartButton.setSize(40, 40);

        restartButton.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Bar.clear();
                Inject.clear();
                DMV1.n = 1;
                frame.dispose();
                DMV1.main();

            }
        }
        );

        JButton emailButton = new JButton("Email Graph");
        emailButton.setSize(40, 40);

        emailButton.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Print");
                HaveEmail HE = new HaveEmail();
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
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                BarCharts.start(fxPanel, IsBarChart);
            }

        });

    }

}
