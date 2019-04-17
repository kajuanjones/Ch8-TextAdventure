 /**
 * 
 * This is the "Game" class of my text based adventure game.
 * "Desert Adventure"
 * 
 * This class is the main launcher of the game. It creates and initialises
 * game and the  15 rooms. 
 *  
 *  
 * 
 * @author KaJuan Jones
 * @version 2019.05.04
 */

public class Game 
{
    private Parser parser;
    private Room currentRoom;
  
        
    /**
     * Creates the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
        
    }
    /**
     * @makes the game playable outside of BlueJ
     */
    public static void main(String[] args)
    {
        Game mygame = new Game();
        mygame.play();
    }

    
    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        Room desert, city, ruins, cave, oasis, market,
        tavern, shop, clearing, village, mountains, 
        camp, restroom, fortress, fortressinterior, citadel, shack, 
        shackinterior, deepruins, palace, 
        palaceinterior, tunnel, inn, shop2, sandmountain;
           
      
        // create the room
        desert = new Room(" wander into the desert, looking for new places to explore. You can scavenge on the way. The items in this room are:");
        city = new Room(" arrive in city of Lat, it is bustling.There is a market and a tavern.There is a fresh water fountain you can fill up from. The items in this room are:");
        tavern = new Room(" enter the tavern, looking a meal and a soft bed. There are food and drinks on the table. The items in this room are:");
        ruins = new Room(" find the ruins of a  ancient town, it looks a thousand years old. A tall structure is in the distance. There are a few old chests in a few houses. The items in this room are:");
        cave = new Room(" discover a dark, warm cave, maybe you can set up camp here. the cave goes deep though. There are odd plants down there.");
        market = new Room(" enter the Lat marketplace, ready to buy equipment. The items in this room are:");
        shop = new Room(" enter the equipment shop, the nice old lady at the counter offers assistance. You can add stuff to your pack, or maybe a new sword? The items in this room are:");
        shop2 = new Room(" enter the local village store, a young man at the counter barely acknowlegdes you. This shop smaller than the one in Lat. Maybe you could by some supplies? The items in this room are:");
        clearing = new Room(" find a clearing in the cave, moonlight beams from the sky. For some reason, foodstuffs like cabbage, tomatos, and leeks grow down here. The items in this room are:");
        village = new Room(" arrive at the village of Dell, a small farming town at the base of the mountain. Some free food is offered in a cart. The items in this room are:");
        mountains = new Room(" arrive at a mountain range, and began your hike. A few vegetables are growing around, but the sand renders most useless. A village is in the distance. The items in this room are:");
        fortress = new Room(" find a old fortress, bandits may be inside. But also gold. The items in this room are:");
        fortressinterior = new Room("  go deeper into the fort, so far no bandits. You look around for gold and other rooms. The items in this room are:");
        citadel = new Room( " climb atop the fort, the desert is beautiful. And a big chest is here. The items in this room are:");
        shack = new Room(" discover a cozy stone shack. The items in this room are:");
        shackinterior = new Room(" go inside the shack, there is a soft bed and a fireplace. There is some good food in the kitchen. The items in this room are:");
        oasis = new Room(" find a glistening oasis, the water is fresh. You can scoop some in your canteen.There is a imposing structure in the distance. The items in this room are:");
        deepruins = new Room(" keep exploring the ruins, finding a old palace");
        palace = new Room(" go into the palace, thirsty for treasure. The items in this room are:");
        palaceinterior = new Room(" find the throne room, it had been looted already, and your are sad.Some weapons are still in good shape. There is also a strange looking door under the throne. The items in this room are:");
        tunnel = new Room(" fall into a tunnel under the door, the door locks behind you and you can't open it. You hear desert winds at the end of the tunnel. The tunnel is completely empty. The items in this room are:");
        inn = new Room(" enter the inn, looking for a good bed. There is some food on some of the tables.The items in this room are:");
        sandmountain = new Room(" find Sand mountain, it reaches for the heavens. There is a small freshwater pool. The items in this room are:");
        
        
        // initialise room exits
        desert.setExit("east", city);
        desert.setExit("south", ruins);
        desert.setExit("west", cave);
        desert.setExit("north", oasis);
        desert.setExit("northwest",mountains);
        desert.setItem(new Item("veggies", 2));
        desert.setItem(new Item("sandy water", 1));

        city.setExit("market", market);
        city.setExit("desert", desert);
        city.setItem(new Item("fresh water",1));
        
        
        oasis.setExit("leave", desert);
        oasis.setExit("fort", fortress);
        oasis.setItem(new Item("fresh water",1));
        
        ruins.setExit("wandering",desert);
        ruins.setExit("ruins", deepruins);
        ruins.setItem(new Item("old chest", 3));
        ruins.setItem(new Item("rusted chest",3));
        ruins.setItem(new Item("weathered chest",3));
        
        
        cave.setExit("inside", clearing);
        cave.setExit("wandering", desert);
        cave.setItem(new Item("odd plants",2));
        cave.setItem(new Item("veggies", 2));
        
        market.setExit("shop", shop);
        market.setExit("city", city);
        
        tavern.setExit("leave", city);
        tavern.setItem(new Item("beer",1));
        tavern.setItem(new Item("fresh water",1));
        tavern.setItem(new Item("lamb chop",3));
        tavern.setItem(new Item("chicken",3));
        tavern.setItem(new Item("meat and veggie stir fry",4));
        
        shop.setExit("market", market);
        shop.setItem(new Item("dry chicken",3));
        shop.setItem(new Item("dry lamb meat",3));
        shop.setItem(new Item("fresh water",1));
        shop.setItem(new Item("small dagger",3));
        shop.setItem(new Item("curved sword",6));
        shop.setItem(new Item("giant maul", 9));
        shop.setItem(new Item("great warhammer",11));
        shop.setItem(new Item("shovel",4));
        
        shop2.setExit("village", village);
        shop2.setItem(new Item("small dagger",3));
        shop2.setItem(new Item("dry beef",4));
        shop2.setItem(new Item("longsword",5));
        shop2.setItem(new Item("mace",7));
        shop2.setItem(new Item("dry lamb chop",3));
        shop2.setItem(new Item("fresh water",1));
        
        
        clearing.setExit("cave", cave);
        clearing.setItem(new Item("veggies:",2));
        
        
        village.setExit("shop", shop2);
        village.setExit("wandering", desert);
        village.setExit("inn", inn);
        village.setExit("mountains", mountains);
        village.setItem(new Item("dry beef",4));
        village.setItem(new Item("dry chicken",3));
        village.setItem(new Item("dry lamb chop",3));
        
        mountains.setExit("climb", sandmountain);
        mountains.setExit("wandering", desert);
        mountains.setExit("village" , village);
        mountains.setItem(new Item("veggies",2));
        
        fortress.setExit("wandering", desert);
        fortress.setExit("inside", fortressinterior);
        
        fortressinterior.setExit("climbladder", citadel);
        fortressinterior.setExit("back", fortress);
        
        citadel.setExit("desend", fortressinterior);
        citadel.setItem(new Item("big chest",7));
        
        shack.setExit("inside", shackinterior);
        shack.setExit("leave", desert);
        
        shackinterior.setExit("outside", desert);
        shackinterior.setItem(new Item("lamb chop",3));
        shackinterior.setItem(new Item("chicken",3));
        shackinterior.setItem(new Item("beer",1));
        
        deepruins.setExit("palace",palace);
        deepruins.setExit("leave", desert);
        
        palace.setExit("inside", palaceinterior);
        palace.setExit("leave", ruins);
        
        palaceinterior.setExit("leave", ruins);
        palaceinterior.setExit("door", tunnel);
        palaceinterior.setItem(new Item("curved sword",6));
        palaceinterior.setItem(new Item("longsword",5));
        palaceinterior.setItem(new Item("spear",4));
        
        tunnel.setExit("outside", desert);
        
        inn.setExit("leave", village);
        inn.setItem(new Item("veggies",2));
        inn.setItem(new Item("lamb chop",3));
        inn.setItem(new Item("good beef",4));
        inn.setItem(new Item("beer",1));
        inn.setItem(new Item("fresh water",1));
        
        sandmountain.setExit("desend",mountains);
        sandmountain.setItem(new Item("fresh water",1));
        
        
        
        
        
        
        
        
        
        
        
        

       
        currentRoom = desert;  // start game outside
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     * @Added basic directions to help the player play the game.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to Desert Adventure! By KaJuan Jones.");
        System.out.println("Desert Adventure is a adventure game! Explore the world!");
        System.out.println("Type go and a direction or location to go to place");
        System.out.println("Your other commands are look, quit, and camp.");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println("Have Fun!!!");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     * @added the look command to proceesCommand
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        switch (commandWord) {
            case UNKNOWN:
                System.out.println("Type that again please...");
                break;

            case HELP:
                printHelp();
                break;

            case GO:
                goRoom(command);
                break;

            case QUIT:
                wantToQuit = quit(command);
                break;
                
            case LOOK:
                 look();
                 break;
                 
            case CAMP:
                  camp();
                  break;
                  
        }
        
        
        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    /** 
     * Try to go in one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("That is the Void, don't go there.");
        }
        else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
        }
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if tshis command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
    /**
     * @prints the description of the room the player is in.
     */
    private void look()
    {
        System.out.println(currentRoom.getLongDescription());
        
    }
    /**
     * Sets up a camp 
     */
    private void camp()
    {
        System.out.println("You set up camp");
        System.out.println("What will you do?");
        parser.showCommands();
    }
    
    private void sleep()
    {
        System.out.println("You go to sleep");
        System.out.println("Your health and stamina are replenished");
        System.out.println("What will you do?");
        parser.showCommands();
    }
    
  
        
    
        
}
