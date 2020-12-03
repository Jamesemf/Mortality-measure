package dm.v1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DMV1 {

    public static int selectionProgress = 1;
    
    public static void main(String[] args) { 
        //Calling mainMenu method
        Menu();

    }
    
    public static void newBar(Boolean IsBarChart) {
        
    //Calls Panels for different indicators (Countries, years, death indicators)
        
        if (selectionProgress == 1) {
            C(IsBarChart);
        }
        if (selectionProgress == 2) {
            Y(IsBarChart);
        }
        if (selectionProgress == 3) {
            D(IsBarChart);
        }
        if (selectionProgress == 4) {
                                        //Calls looplist depending on the type of chart
            if (IsBarChart) {
                Bar.LoopList();
            } else {
                Line.LoopList();
            }
            
            BarCharts.main(IsBarChart);
            
        }
    }
    
    public static void C(Boolean IsBarChart) {              //Retrieves Countries and county codes using the API
        ArrayList<String> Countries = RetrieveData.RetrieveData("DIMENSION/COUNTRY/DimensionValues");
        HashMap CountriesHash = hash("Countries", Countries);            //Creates a HashMap of the country name and the code 
        
        Countries = AlphaMergeSort.OrderAlphabeticaly(CountriesHash);   //Uses a merge sort to sort Countries Alphabetically and re-appends to the arraylist
                                                                                                    
        SetUpGUI.SetUpGUI(Countries, "Countries", CountriesHash, IsBarChart); //Sets up the countries GUI
        
    }
    
    public static void Y(Boolean IsBarChart) {          //Retrieves Years and year codes using API
        ArrayList<String> Years = RetrieveData.RetrieveData("DIMENSION/YEAR/DimensionValues");
        HashMap YearsHash = hash("Years", Years);           //Creates a HashMap of the Years and the year code
        
        Years = ToArrayList("Years", YearsHash);                //Add to year arraylsit 
        
        SetUpGUI.SetUpGUI(Years, "Years", YearsHash, IsBarChart);   //Sets up the Years GUI
        
    }
    
    public static void D(Boolean IsBarChart) {           //Retrieves indicators and Indicator codes using API
        ArrayList<String> Causes = RetrieveData.RetrieveData("Indicator?$filter=contains(indicatorName,'death')");
        HashMap CausesHash = hash("Causes", Causes);      //Hashmap of indicator names and codes 
        
        Causes = ToArrayList("Causes", CausesHash);         //Adds  to arraylist
        
        SetUpGUI.SetUpGUI(Causes, "Causes", CausesHash, IsBarChart); //Sets up thhe Causes of death GUI
        
    }
    
    
    //Method for retrieving the Key or Value (depends) and adding to arrayList which is returned 
    public static ArrayList ToArrayList(String name, HashMap<String, String> HM) {
        ArrayList<String> returnArrayList = new ArrayList<>();
        
        if (name == "Years") {
            for (Map.Entry m : HM.entrySet()) {
                returnArrayList.add(m.getValue().toString());
            }
        }
        if (name == "Causes") {
            for (Map.Entry m : HM.entrySet()) {
                returnArrayList.add(m.getKey().toString());
            }
        }
        return returnArrayList;
    }

    public static void Menu() {
        Menu menu = new Menu();
        menu.show();
    }
    
    
    //Method for creating HashMaps from an ArrayList
    public static HashMap hash(String str, ArrayList<String> arrayList) {
        HashMap<String, String> Hmap = new HashMap<>();
        
        if (str == "Countries") {
            for (int i = 0; i < arrayList.size(); i++) {
                String[] breaks = new String[2];
                breaks = arrayList.get(i).split("/");           //In arrayList values are like 'Germany/GER' 
                
                if (breaks[0].length() > 3) {               //Breaks it apart and makes one the KEy and the other the Value
                  
                } else {
                    Hmap.put(breaks[1], breaks[0]);
                }
            }
        }
        
        if (str == "Years") {
            for (int i = 0; i < arrayList.size(); i++) {
                String[] breaks = new String[2];
                breaks = arrayList.get(i).split("/");
                if (breaks[1].length() > 4) {
                   
                } else if (Integer.parseInt(breaks[1]) < 2020 && Integer.parseInt(breaks[1]) > 2000) {      //Limits the values that can be chosen from as past 2018 and before 2000 there is very limited
                    Hmap.put(breaks[1], breaks[0]);
                }
                
            }
        }
        
        if (str == "Causes") {
            for (int i = 0; i < arrayList.size(); i++) {
                String[] breaks = new String[2];
                breaks = arrayList.get(i).split("/");
                Hmap.put(breaks[1], breaks[0]);
            }

        }
        return Hmap;
    }
    
}
