package dm.v1;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

public class StackList {

    protected static JButton removeButton;
    
    public static void createList(Boolean IsBarChart, JFrame frame) {

        JPanel ListPanel = new JPanel(new GridLayout());

        DefaultListModel<String> li = new DefaultListModel<>();
        JList<String> list;
        
        
        if (IsBarChart) {                                                       //Creating stack functions for the bar chart
            removeButton = new JButton("Remove Bar");
            for (int i = 0; i < Bar.Bars.size(); i++) {
                li.addElement(Bar.Bars.get(i).Identifier);
            }

            list = new JList<>(li);
            list.setBounds(200, 200, 75, 75);

        } else {
            removeButton = new JButton("Remove Line");                          //Creating stack functions for the line chart
            for (int i = 0; i < Line.Lines.size(); i++) {
                li.addElement(Line.Lines.get(i).Identifier);
            }

            list = new JList<>(li);
            list.setBounds(200, 200, 75, 75);

        }

        removeButton.setSize(40, 40);

        removeButton.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (IsBarChart) {
                    Bar.Bars.remove(Bar.Bars.size() - 1);                       //Removes the last object on the stack 
                } else {
                    Line.Lines.remove(Line.Lines.size() - 1);
                }
                frame.dispose();
                BarCharts.main(IsBarChart);
                
            }
        }
        );

        ListPanel.add(list);
        ListPanel.add(removeButton);
        frame.add(ListPanel);
    }

}
