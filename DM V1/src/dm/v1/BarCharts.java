package dm.v1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javafx.scene.chart.XYChart;
import javafx.embed.swing.JFXPanel;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;

public class BarCharts extends JComponent implements ActionListener{

    private static void callChartFrame(Boolean IsBarChart) {

        ChartFrame.ChartFrame(IsBarChart);

    }

    
    public static void start(JFXPanel fxPanel, Boolean IsBarChart) {
        if (IsBarChart) {
            ArrayList<XYChart.Series<String, Number>> graphBars = new ArrayList<>();     //Instantiating the arryalist where Bar data for the graph will be stored 

            GraphFillData.barFill(graphBars);                
            BarSetup.BarSetup(graphBars, fxPanel);          //Invoking method to display bars

        } else {
            ArrayList<XYChart.Series<String, Number>> ArrayOfLines = new ArrayList<>();  //Instantiating the arryalist where data for the graph will be stored 

            ArrayOfLines = GraphFillData.lineFill(ArrayOfLines);
            BarSetup.LineSetup(ArrayOfLines, fxPanel);

        }
    }

    public static void main(Boolean IsBarChart) {
        
                                                         
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                callChartFrame(IsBarChart);
            }

        });

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
