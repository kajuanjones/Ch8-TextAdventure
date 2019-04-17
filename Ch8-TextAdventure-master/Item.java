
/**
 * This is the Item class for "Desert Adventure"
 * 
 * 
 *
 * @author KaJuan Jones
 * @version 04/15/2019
 */
public class Item
{
    // instance variables - replace the example below with your own
    private int weight;
    private String description;
    

    /**
     *This is the constructer for Item.
     */
    public Item(String itemdescription, int itemweight)
    {
        description= itemdescription;
        weight = itemweight; 
        
       
    }

    /**
     *
     *
     * 
     * @return Returns the description of the item.
     */
    public String getdescription()
    {
        
        return description;
        
    }
    /**
     * @returns the Weight of an item.
     */
    public int getWeight()
    {
        
        return weight;
    }
    
  
}
