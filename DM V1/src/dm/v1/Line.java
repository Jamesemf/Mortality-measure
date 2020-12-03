package dm.v1;

import java.util.ArrayList;

public class Line extends GraphData implements Inject {

     public static ArrayList<Line> Lines = new ArrayList<>();
     protected ArrayList<DateVal> values = new ArrayList<>();
     
    public Line(String Identifier, ArrayList<DateVal> values) {
        super(Identifier);
        this.Identifier = Identifier;
        this.values = values;
    }

    //Similar to Bar looplist however, only one line can be created at a time 
    //Loops through the years arraylist 
    //creates datapoints for line graph
    
    public static void LoopList() {
        ArrayList<DateVal> values = new ArrayList<>();
        String c = Countries.get(0);
        String ca = Causes.get(0);
        for (int i = 0; i < Years.size(); i++) {
            String y = Years.get(i);
            values.add(CreateNew(c, y, ca));
        }

        sortValues(values);
        Line TheLine = new Line(c, values);

        Lines.add(TheLine);
        values.clear();
    }

    
    
    private static DateVal CreateNew(String country, String year, String CauseOD) {                 
        String identify = year;                                                                     //Identifier is the year it represents   
        DateVal val = new DateVal(identify, Query.Query(country, year, CauseOD));       

        return val;
    }
    
    
    //Bubble sort
    private static void sortValues(ArrayList<DateVal> values) {

        DateVal temp = new DateVal("", 0);

        for (int i = 0; i < values.size(); i++) {
            for (int j = 1; j < values.size(); j++) {
                if (Integer.parseInt(values.get(j - 1).date )> Integer.parseInt(values.get(j).date)) {
                    temp = values.get(j - 1);                                             //Swapping 
                    values.set(j - 1, values.get(j));
                    values.set(j, temp);
                }

            }

        }

    }
}
