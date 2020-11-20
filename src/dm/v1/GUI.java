package dm.v1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class GUI extends JPanel implements WindowListener, ActionListener, Inject {

    private JPanel panel;
    public JButton selectButton;

    public GUI(String Name, HashMap<String, String> hashMap, Boolean IsBarChart) {

        JPanel outerWrapperPanel = new JPanel(new BorderLayout());
        panel = new JPanel();

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        outerWrapperPanel.add(panel, BorderLayout.PAGE_START);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 0, 5, 0));

        selectButton = new JButton("Selected");
        selectButton.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectButton.setText("Clicked");
                ArrayList<JCheckBox> BA = SetUpGUI.perfectBoxArray;
                //ArrayList<String> CA = SetUpGUI.CodeArray;

                int n = 0;
                for (int i = 0; i < BA.size(); i++) {
                    if (BA.get(i).isSelected()) {
                        n++;
                    }
                }

                System.out.println(n);
                if (n > 1 && Name.equals("Countries") && IsBarChart.equals(false) || n > 1 && Name.equals("Causes") && IsBarChart.equals(false)) {
                    selectButton.setText("Select One");
                    selectButton.setForeground(Color.red);
                } else if (n == 0) {
                    selectButton.setText("Nothing Selected");
                    selectButton.setForeground(Color.red);
                    System.out.println("sfsdfd");
                } else if(n == 1 && Name.equals("Years") && IsBarChart.equals(false)){
               selectButton.setText("Select Multiple");
                } else {
                    Inject.AddToInject(BA, hashMap);
                    end(IsBarChart);
                }

            }

        }
        );

        buttonPanel.add(selectButton);

        if (Name == "Countries" || Name == "Causes") {
            JTextField textField = new JTextField(20);
            textField.addActionListener(this);
            panel.add(textField);

            JButton searchButton = new JButton("SEARCH");
            searchButton.addActionListener(
                    new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String text = textField.getText();
                    System.out.println(text);
                    SetUpGUI.SetUPGUI(Name, text, hashMap, IsBarChart);

                    refresh();
                }
            }
            );

            panel.add(searchButton);

        }

        setLayout(new BorderLayout());
        add(new JScrollPane(outerWrapperPanel), BorderLayout.EAST);
        add(buttonPanel, BorderLayout.PAGE_END);

    }
    
    
    
    
//    public static void AddToInject(ArrayList<JCheckBox> BA, HashMap<String, String> hashMap) {
//        for (int i = 0; i < BA.size(); i++) {
//            if (BA.get(i).isSelected()) {
//                if (DMV1.n == 1) {
//
//                    Inject.Countries.add(hashMap.get(BA.get(i).getText()));
//                    System.out.println(hashMap.get(BA.get(i).getText()));
//                } 
//                else if (DMV1.n == 2) {
//
//                    Inject.Years.add(hashMap.get(BA.get(i).getText()));
//                    System.out.println(hashMap.get(BA.get(i).getText()));
//                } 
//                else if (DMV1.n == 3) {
//
//                    System.out.println(BA.get(i).getText());
//                    Inject.Causes.add(hashMap.get(BA.get(i).getText()));
//                    System.out.println(hashMap.get(BA.get(i).getText()));
//                }
//                //Retrives the codes 
//            }
//        }
//
//    }
    


    public void addCheckBox(JCheckBox box) {
        panel.add(box);
    }

    public void refresh() {
        Component comp = SwingUtilities.getRoot(this);
        ((Window) comp).dispose();
    }

    public void end(Boolean isBarChart) {
        Component comp = SwingUtilities.getRoot(this);
        ((Window) comp).dispose();
        DMV1.n++;
        DMV1.newBar(isBarChart); // Gonna have to pass the type of chart into end
    }

    @Override
    public void windowOpened(WindowEvent we) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowClosing(WindowEvent we) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowClosed(WindowEvent we) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowIconified(WindowEvent we) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeiconified(WindowEvent we) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowActivated(WindowEvent we) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeactivated(WindowEvent we) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
