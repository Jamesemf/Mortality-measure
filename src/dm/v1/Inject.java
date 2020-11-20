
package dm.v1;

import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JCheckBox;

public interface Inject{
    
    public ArrayList<String> Countries = new ArrayList<>();
    public ArrayList<String> Years = new ArrayList<>();
    public ArrayList<String> Causes = new ArrayList<>();
       
   
    public static void AddToInject(ArrayList<JCheckBox> BA, HashMap<String, String> hashMap) {
        for (int i = 0; i < BA.size(); i++) {
            if (BA.get(i).isSelected()) {
                if (DMV1.n == 1) {

                   Countries.add(hashMap.get(BA.get(i).getText()));
                    System.out.println(hashMap.get(BA.get(i).getText()));
                } 
                else if (DMV1.n == 2) {

                    Years.add(hashMap.get(BA.get(i).getText()));
                    System.out.println(hashMap.get(BA.get(i).getText()));
                } 
                else if (DMV1.n == 3) {

                    System.out.println(BA.get(i).getText());
                    Causes.add(hashMap.get(BA.get(i).getText()));
                    System.out.println(hashMap.get(BA.get(i).getText()));
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
                   temp = array.get(j - 1);                                             //Swapping 
                   array.set(j-1, array.get(j));
                   array.set(j, temp);
                }
                
            }

        }
        return (float) array.get(array.size() -1);
    }
    
    public static void clear(){
    Inject.Causes.clear();
    Inject.Countries.clear();
    Inject.Years.clear();
    
    }

    }
     
 

