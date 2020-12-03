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
    private JButton selectButton;
    private JButton searchButton;
    
    
//Method for creating the GUI that presents the arraylists and contains the necessary buttons 
    
    
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
                selectButton.setText("Clicked");                              //Text changes to indicate press 
                ArrayList<JCheckBox> BA = SetUpGUI.perfectBoxArray;

                int n = 0;
                for (int i = 0; i < BA.size(); i++) {
                    if (BA.get(i).isSelected()) {
                        n++;
                    }
                }

                //Code checks if the right number of selections have been made depending on whether a barchart or a line graph
                
                System.out.println(n);
                if (n > 1 && Name.equals("Countries") && IsBarChart.equals(false) || n > 1 && Name.equals("Causes") && IsBarChart.equals(false)) {
                    selectButton.setText("Select One");
                    selectButton.setForeground(Color.red);
                } else if (n == 0) {
                    selectButton.setText("Nothing Selected");
                    selectButton.setForeground(Color.red);
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
        
        //Adds a search button for GUIs that present the countries or causes list

        if (Name == "Countries" || Name == "Causes") {
            JTextField textField = new JTextField(20);
            textField.addActionListener(this);
            panel.add(textField);

            searchButton = new JButton("SEARCH");
            searchButton.addActionListener(
                    new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String text = textField.getText();                                  
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
    
    
    public void addCheckBox(JCheckBox box) {
        panel.add(box);
    }

    //Disposes the current GUI
    
    public void refresh() {
        Component comp = SwingUtilities.getRoot(this);
        ((Window) comp).dispose();
    }

    //Method call closes the current GUI and opens the next one 
    public void end(Boolean isBarChart) {
        Component comp = SwingUtilities.getRoot(this);    
        ((Window) comp).dispose();
        DMV1.selectionProgress++;
        DMV1.newBar(isBarChart); 
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
