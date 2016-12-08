package zork;
/**
 * Trades an item from a player to an NPC, or vice versa, adding the item to their respective inventories.
 * @author David, Ryan, Scott
 * @version Group Project 2
 */
public class TradeCommand extends Command {


	private String item;
	private String npc;
	/**
	 * Sets up variables for execute method.
	 * @param give Item to be given
	 * @param take Item to be taken
	 * @param npc NPC to interact with
	 */
	public TradeCommand(String verb, String npc, String item){
		this.item = item;
		this.npc = npc;
	}
	
	/**
	 * Trades item from user to NPC or vice versa, then returns String to be printed.
	 * @Override execute() 
	 * @return String - Prints string to display action to User
	 */
	public String execute() {
		 if (item == "temp" || item.trim().length() == 0) {
	            return "Trade what?\n";
	        }
	            try {
	            	Room currentRoom = 
	    	                GameState.instance().getAdventurersCurrentRoom();
	            	Item toTrade = GameState.instance().getItemFromInventoryNamed(item);
	            	try{
	            		NPC Temp = currentRoom.getNPCNamed(npc);
	            		if(Temp.hasItem()){
	            			Temp.give(toTrade);
	            			GameState.instance().addToInventory(Temp.getItem());
	            			GameState.instance().removeFromInventory(toTrade);
	            			return(Temp.talk("Trade") + "\n");
	            		}else
	            			return("NPC has no items to trade! \n");
	            		
	            	}catch(NPC.NoNPCException e){
	            		return("No NPC by that Name! \n");
	            	}
	            	
	                
	            } catch (Item.NoItemException e2) {
	                return "You do not have " + item + "\n";
	            }
	        }
	

}
