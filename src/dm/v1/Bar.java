package dm.v1;

import java.util.ArrayList;

public class Bar extends GraphData{

    public static ArrayList<Bar> Bars = new ArrayList<>();

    private int value;

    public Bar(String Identifier , int value) {
        super(Identifier);
        this.value = value;
        this.Identifier = Identifier;
    }

    public static ArrayList<Bar> getBars() {
        return Bars;
    }

    public int getValue() {
        return value;
    }

    public String getIdentifier() {
        return Identifier;
    }

    // Set up loop to create all bars and add to an arraylist
    public static void LoopList() {

        for (int i = 0; i < Inject.Countries.size(); i++) {
            for (int j = 0; j < Inject.Years.size(); j++) {
                for (int k = 0; k < Inject.Causes.size(); k++) {
                    String c = Inject.Countries.get(i);
                    String y = Inject.Years.get(j); //Conversion to integer
                    String ca = Inject.Causes.get(k);
                    barToArrayList(CreateNew(c, y, ca));
                }
            }
        }
        
    }

  
//    public void ViewBars(Boolean IsBarChart) {
//        for (int i = 0; i < Bars.size(); i++) {
//            System.out.println("Value = " + Bars.get(i).value + "\nIdentity = " + Bars.get(i).Identifier);
//        }
//        
//        BarCharts.main(IsBarChart);
//
//    }

    public static void barToArrayList(Bar bar) {
        Bars.add(bar);
    }

    public static Bar CreateNew(String country, String year, String CauseOD) {                 //Creates new bar with data put in
       String identify = country.substring(0, 2) + year;       //Creating an identifier for the bar 
        Bar bar = new Bar(identify , Query.Query(country, year, CauseOD));

        return bar;
    }


    public static void clear() {
        Bars.clear();
    }

}
