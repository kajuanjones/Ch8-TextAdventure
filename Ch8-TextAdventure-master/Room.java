import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;


/**
 * This is the Room class of "Desert Adventure"
 * 
 * This class creates the rooms and thier exits inside of the game.
 * It displays a description of each room.
 * 
 * @author KaJuan Jones
 * @version 2019.04.13
 */

public class Room 
{
    private String description;
    private HashMap<String, Room> exits; // stores exits of this room.
    private String room;
    private Item itemsandroom;
    private String itemString;
    
    
    

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<String, Room>();
        this.itemsandroom = null;
        String itemString;
        
    }

    /**
     * Define an exit from this room.
     * @param direction The direction of the exit.
     * @param neighbor  The room to which the exit leads.
     */
    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }
    
    /**
     * Wrote a new method to get the room name
     */
    
    public String getcurrentRoom()
    {
        return room;
    }

    /**
     * @return The short description of the room
     * (the one that was defined in the constructor).
     */
    public String getShortDescription()
    {
        return description;
    }

    /**
     * Return a description of the room in the form:
     *     You are in the kitchen.
     *     Exits: north west
     * @return A long description of this room
     */
    public String getLongDescription()
    {String returnvalue = "";
        returnvalue += "You " + description + ".\n";
        if(itemsandroom != null){
            returnvalue += itemsandroom.getdescription()+"\n";
        }
        returnvalue += getExitString();
        return returnvalue;
       
        
    }

    /**
     * Return a string describing the room's exits, for example
     * "Exits: north west".
     * @return Details of the room's exits.
     */
    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     * @param direction The exit's direction.
     * @return The room in the given direction.
     */
    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }
    /**
     * This is the method for setting items into a room.
     * 
     * @sets items in a room.
     */
    public void setItem(Item item)
    {
        itemsandroom = item;
        
        
    }
    
    
    
    
   
        
    }
    
    
   
    
    


