package zork;

/**
 * Command for transforming multiple items into a different item
 * @author David, Scott, Ryan
 * @version Group Project 2
 */
public class CraftCommand extends Command {
        private String item1;
        private String item2;
        
	public CraftCommand(String s1, String s2){
            this.item1 = s1;
            this.item2 = s2;
	}
	
        /**
         * Checks to see if the player has both the specified items
         * removes them from the player’s inventory and adds the crafted item if they are both present
         * notifies the player that they do not have the necessary items if they are not
         * @return String - affirmation that the items have been crafted
         * @return String - Notice that the player does not have the necessary items
         */

	@Override
	String execute() {
		if (item1 == null || item2 == null){
                    return "craft what?";
                }
                try{
                    Item i1 = GameState.instance().getItemFromInventoryNamed(item1);
                    Item i2 = GameState.instance().getItemFromInventoryNamed(item2);
                    Item i3 = GameState.instance().getDungeon().items.get("sling");
                    
                    if ((i1.goesBy("rock") || i2.goesBy("rock")) && ((i1.goesBy("rope")) || i2.goesBy("rope"))) {
                        GameState.instance().removeFromInventory(i1);
                        GameState.instance().removeFromInventory(i2);
                        GameState.instance().addToInventory(i3);
                        return i1.toString() + " was crafted with " + i2.toString() + " to make a " + i3.toString() + "\n";
                    }
                    else{
                        return "these items cannot be crafted.\n";
                    }
                }
                catch (Item.NoItemException e){
                    return "Check your inventory again. You're missing an item.";
                }
	}

}
