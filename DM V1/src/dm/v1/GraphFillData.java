package dm.v1;

import java.util.ArrayList;
import javafx.scene.chart.XYChart;

public abstract class GraphFillData { //Made abstract recent

    
    //Method takes each data value from either arraylist arraylist held in another clas
    //Creates an identiier 
    //Creates a XYChart.series object with the data  
    //Adds that object to an arraylist which is passed in 
    
    public static void barFill(ArrayList<XYChart.Series<String, Number>> Barss) {   //In the case of barFill, no data is returned and instead added to the arraylist passed in
        for (int i = 0; i < Bar.Bars.size(); i++) {
            int Value = Bar.Bars.get(i).getValue();
            String identifier = Bar.Bars.get(i).getIdentifier();

            XYChart.Series<String, Number> barr = new XYChart.Series<>();
            barr.getData().add(new XYChart.Data<>(identifier, Value));
            Barss.add(barr);

        }
    }

    public static ArrayList<XYChart.Series<String, Number>> lineFill(ArrayList ArrayOfLines) { //In the case of lineFill, Multiple XYseries charts are created and appended to and arraylist of these charts which are then returned.
        for (int i = 0; i < Line.Lines.size(); i++) {
            XYChart.Series<String, Number> Linear = new XYChart.Series<>();        
            Linear.setName(Line.Lines.get(i).Identifier);
            for (int j = 0; j < Line.Lines.get(i).values.size(); j++) {            //Arraylist must loop to get each data point for each value                                                        
                int Value = Line.Lines.get(i).values.get(j).value;
                String identifier = Line.Lines.get(i).values.get(j).date;
     

                Linear.getData().add(new XYChart.Data<>(identifier, Value));
                ArrayOfLines.add(Linear);
            }
            
            
        }
      return ArrayOfLines; 

    }

}
