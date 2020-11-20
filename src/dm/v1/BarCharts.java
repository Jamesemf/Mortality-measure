package dm.v1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javafx.scene.chart.XYChart;
import javafx.embed.swing.JFXPanel;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;

public class BarCharts extends JComponent implements ActionListener {

    private static void init(Boolean IsBarChart) {

        ChartFrame.ChartFrame(IsBarChart);

    }

    public static void start(JFXPanel fxPanel, Boolean IsBarChart) {
        if (IsBarChart) {
            ArrayList<XYChart.Series<String, Number>> Bars = new ArrayList<>();

            GraphFillData.barFill(Bars);
            BarSetup.BarSetup(Bars, fxPanel);

        } else {
            ArrayList<XYChart.Series<String, Number>> ArrayOfLines = new ArrayList<>();

            ArrayOfLines = GraphFillData.lineFill(ArrayOfLines);
            BarSetup.LineSetup(ArrayOfLines, fxPanel);

        }
    }

    public static void main(Boolean IsBarChart) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                init(IsBarChart);
            }

        });

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
