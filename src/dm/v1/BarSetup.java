
package dm.v1;

import java.util.ArrayList;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;


public interface BarSetup {
    
  
    public static void BarSetup(ArrayList<XYChart.Series<String, Number>> Barss , JFXPanel fxPanel){
      System.out.println("Its getting started");
            CategoryAxis xAxis = new CategoryAxis();
            xAxis.setLabel("Identifier");

            NumberAxis yAxis = new NumberAxis();
            yAxis.setLabel("Deaths");

            //Creating the Bar chart
            BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
            barChart.setTitle("Death Comparisons");

           
            barChart.getData().addAll(Barss);
            //Creating a Group object 
            Group root = new Group(barChart);
            //Creating a scene object
            Scene scene = new Scene(root, 600, 400);

            fxPanel.setScene(scene);
            System.out.println("Set scence");
    
    }
    
    public static void LineSetup(ArrayList<XYChart.Series<String, Number>> ArrayOfLines , JFXPanel fxPanel){
      CategoryAxis xAxis = new CategoryAxis();
            xAxis.setLabel("Years");

            NumberAxis yAxis = new NumberAxis();
            yAxis.setLabel("Deaths");

            LineChart<String, Number> lineChart = new LineChart<>(xAxis, yAxis);
            lineChart.setTitle(Inject.Causes.get(0));

             for (int i = 0; i < ArrayOfLines.size(); i++) {
                lineChart.getData().add(ArrayOfLines.get(i));
            }

            //Creating a scene object
            Scene scene = new Scene(lineChart, 800, 600);
            
           
           
            fxPanel.setScene(scene);
            System.out.println("Set scence");

    
    
    }
    
    
    
//  
    
}
