package dm.v1;

import java.util.ArrayList;

public class Bar extends GraphData implements Inject{

    public static ArrayList<Bar> Bars = new ArrayList<>();
    private int value;

    public Bar(String Identifier , int value) {  //Inherited from super class
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

    // Set up loop to create all bars and add to arraylist
    public static void LoopList() {

        for (int i = 0; i < Countries.size(); i++) {   //Loops through all the countries for each of the years for each of the causes of deaths 
            for (int j = 0; j < Years.size(); j++) {
                for (int k = 0; k < Causes.size(); k++) {  
                    String c = Countries.get(i);
                    String y = Years.get(j);  
                    String ca = Causes.get(k);
                    barToArrayList(CreateNew(c, y, ca));    
                }
            }
        }
        
    }

    public static void barToArrayList(Bar bar) { //Adds new Bar object to Bars arraylist
        Bars.add(bar);
    }
    

    public static Bar CreateNew(String country, String year, String CauseOD) {                 //Creates new bar with data put in
        String identify = country.substring(0, 2) + year;       //Creating an identifier for the bar 
        Bar bar = new Bar(identify , Query.Query(country, year, CauseOD)); //Bar is created with the identifier and then calling a subroutine in class 'Query' where data it retrieved according to parameters passed in 

        return bar;
    }


    public static void clear() {  //Clears Bar arraylist for if selection is restarted 
        Bars.clear();
    }

}
