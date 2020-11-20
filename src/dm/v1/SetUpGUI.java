package dm.v1;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SetUpGUI {

    public static GUI mainPanel;

    public static ArrayList<JCheckBox> perfectBoxArray = new ArrayList<>();

    public static ArrayList<JCheckBox> BoxArray = new ArrayList<>();

    public static void SetUPGUI(ArrayList<String> stringArray, String Name, HashMap hashMap, Boolean IsBarChart) {
        perfectBoxArray.clear();
        BoxArray.clear();

        adapt(stringArray);
        mainPanel = new GUI(Name, hashMap, IsBarChart);
       
        mainPanel.setOpaque(true);
        mainPanel.setBackground(Color.yellow);
        JFrame frame = new JFrame(Name);
        
        frame.setSize(800, 800);
       
         
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(mainPanel);

        //frame.pack();
        frame.setLocationByPlatform(true);

        for (int i = 0; i < perfectBoxArray.size(); i++) {
            mainPanel.addCheckBox(perfectBoxArray.get(i));

        }

        if (IsBarChart.equals(false)) {
            JLabel Label = null;
            if (Name.equals("Countries")) {
                Label = new JLabel("Only select a single country", JLabel.LEFT);
            }
            if (Name.equals("Causes")) {
                Label = new JLabel("Only select a single cause", JLabel.LEFT);
            }

            if (Name.equals("Years")) {
                Label = new JLabel("Select multiple years ", JLabel.LEFT);
            }

            Label.setVerticalAlignment(JLabel.TOP);
            Label.setFont(new Font("Verdana", Font.BOLD, 20));
            Label.setPreferredSize(new Dimension(250, 100));
            Label.setForeground(new Color(250, 0, 0));

            mainPanel.add(Label);

        }
       

        frame.setVisible(true);
    }

    public static void SetUPGUI(String Name, String text, HashMap hashMap, Boolean IsBarChart) {

        mainPanel = new GUI(Name, hashMap, IsBarChart);
        mainPanel.setOpaque(true);
        mainPanel.setBackground(Color.yellow);
        
        
        
        JFrame frame = new JFrame(Name);
        frame.setSize(600, 600);

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(mainPanel);

        //frame.pack();
        frame.setLocationByPlatform(true);

        refresh(text);
        frame.setVisible(true);
    }

    public static void refresh(String text) {

        if (text == "") {
            for (int i = 0; i < perfectBoxArray.size(); i++) {
                mainPanel.addCheckBox(perfectBoxArray.get(i));
            }
        } else {
            BoxArray.clear();

            for (int i = 0; i < perfectBoxArray.size(); i++) {
                if (perfectBoxArray.get(i).getText().contains(text)) {
                    // System.out.println("Contains");
                    BoxArray.add(perfectBoxArray.get(i));//Leaving in countries that do not contain 
                }

            }
            for (int i = 0; i < BoxArray.size(); i++) {
                mainPanel.addCheckBox(BoxArray.get(i));
            }

        }

    }

    public static void adapt(ArrayList<String> Carray) {
        for (int i = 0; i < Carray.size(); i++) {

            //String[] breaks = new String[2];
            // breaks = Carray.get(i).split("/");
            // perfectCodeArray.add(breaks[0]);
            JCheckBox box = new JCheckBox(Carray.get(i));
            perfectBoxArray.add(box);
        }

    }

//    public static void refresh() {
//        mainPanel.repaint();
//        mainPanel.revalidate();
//    }
}
