
package dm.v1;


//Class used to sort the arraylist in to alphabetical order after being retrieved from the API

public class OrderAlpha {
    
    private String name;
    private int number;

    public OrderAlpha(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    
    
}
