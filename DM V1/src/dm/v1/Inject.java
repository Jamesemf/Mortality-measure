
package dm.v1;

import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JCheckBox;

public interface Inject{
    
    
    //Interface holds the arrays which are required for other classes
    //If required, class imlements inject 
    
    public ArrayList<String> Countries = new ArrayList<>();
    public ArrayList<String> Years = new ArrayList<>();
    public ArrayList<String> Causes = new ArrayList<>();
       
    
    
    //Method retrieves the codes from the the values stored in the arraylists 
    //Each value is stored with a hashmap that contains the code (This is done in the DMV1 class)
   
    public static void AddToInject(ArrayList<JCheckBox> BA, HashMap<String, String> hashMap) {
        for (int i = 0; i < BA.size(); i++) {
            if (BA.get(i).isSelected()) {
                if (DMV1.selectionProgress == 1) {
                   Countries.add(hashMap.get(BA.get(i).getText()));
   
                } 
                else if (DMV1.selectionProgress == 2) {
                    Years.add(hashMap.get(BA.get(i).getText()));
            
                } 
                else if (DMV1.selectionProgress == 3) {
                    Causes.add(hashMap.get(BA.get(i).getText()));
                 
                }
                //Retrives the codes 
            }
        }

    }
    

   
    public static float bubbleSort(ArrayList<Float> array){
     int n = array.size();
        float temp = 0;
      

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n ; j++) {
                if (array.get(j - 1) > array.get(j)) {
                   temp = array.get(j - 1);                //Swapping 
                   array.set(j-1, array.get(j));
                   array.set(j, temp);
                }
                
            }

        }
        return (float) array.get(array.size() -1);
    }
    
    //Clears the arrays for if selection is restarted.
    
    public static void clear(){
    Inject.Causes.clear();
    Inject.Countries.clear();
    Inject.Years.clear();
    
    }

    }
     
 

