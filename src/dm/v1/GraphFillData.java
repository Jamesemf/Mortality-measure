package dm.v1;

import java.util.ArrayList;
import javafx.scene.chart.XYChart;

public interface GraphFillData {

    public static void barFill(ArrayList<XYChart.Series<String, Number>> Barss) {
        for (int i = 0; i < Bar.Bars.size(); i++) {
            int Value = Bar.Bars.get(i).getValue();
            String identifier = Bar.Bars.get(i).getIdentifier();

            XYChart.Series<String, Number> barr = new XYChart.Series<>();
            barr.getData().add(new XYChart.Data<>(identifier, Value));
            Barss.add(barr);

        }
    }

    public static ArrayList<XYChart.Series<String, Number>> lineFill(ArrayList ArrayOfLines) {
        for (int i = 0; i < Line.Lines.size(); i++) {
            XYChart.Series<String, Number> Linear = new XYChart.Series<>();
            Linear.setName(Line.Lines.get(i).Identifier);
            for (int j = 0; j < Line.Lines.get(i).values.size(); j++) {                                                                             //Can't get values arraylist through line objext

                int Value = Line.Lines.get(i).values.get(j).value;
                // System.out.println(Value);
                String identifier = Line.Lines.get(i).values.get(j).date;
                // System.out.println(identifier);

                Linear.getData().add(new XYChart.Data<>(identifier, Value));
                ArrayOfLines.add(Linear);
            }
            
            
        }
      return ArrayOfLines;

    }

}
