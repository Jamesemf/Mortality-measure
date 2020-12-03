package dm.v1;

import java.util.ArrayList;

public abstract class GraphDataFormat {  // Made this abstract may break something -----------------------------------
    
    private ArrayList<GraphDataFormat> Data = new ArrayList<GraphDataFormat>();    
    private String Identity;
    private ArrayList<Integer> values;

    public GraphDataFormat(String Identity, ArrayList values) {
        this.Identity = Identity;
        this.values = values;
    }

    public String getIdentity() {
        return Identity;
    }

    public ArrayList getValues() {
        return values;
    }

    public ArrayList<GraphDataFormat> getData() {
        return Data;
    }

 
}
