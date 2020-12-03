
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


//Classes involved in creating and appending the grpahs to the fxPanel


public class BarSetup {
    
  
    public static void BarSetup(ArrayList<XYChart.Series<String, Number>> Barss , JFXPanel fxPanel){    //Sets up graph axis, takes in the Barss arraylist so data can be displayed.
      System.out.println("Its getting started");
            CategoryAxis xAxis = new CategoryAxis();
            xAxis.setLabel("Identifier");           //Axis labels

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
    
    public static void LineSetup(ArrayList<XYChart.Series<String, Number>> ArrayOfLines , JFXPanel fxPanel){ //Sets up graph axis, takes in the Lines arraylist so data can be displayed and fxpanel so the graph can be displayed.
      CategoryAxis xAxis = new CategoryAxis();
            xAxis.setLabel("Years");

            NumberAxis yAxis = new NumberAxis();
            yAxis.setLabel("Deaths");

            LineChart<String, Number> lineChart = new LineChart<>(xAxis, yAxis);
            lineChart.setTitle(Inject.Causes.get(0));

             for (int i = 0; i < ArrayOfLines.size(); i++) {        //Data for a line chart must be appended reursively so that the data points don't become individual lines.  
                lineChart.getData().add(ArrayOfLines.get(i));
            }

            //Creating a scene object
            Scene scene = new Scene(lineChart, 800, 600);
            
           
           
            fxPanel.setScene(scene);
            System.out.println("Set scence");

    
    
    }  
}
