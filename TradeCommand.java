package zork;
/**
 * Trades an item from a player to an NPC, or vice versa, adding the item to their respective inventories.
 * @author David, Ryan, Scott
 * @version Group Project 2
 */
public class TradeCommand extends Command {

	private Item give;
	private Item take;
	
	/**
	 * Sets up variables for execute method.
	 * @param give Item to be given
	 * @param take Item to be taken
	 * @param npc NPC to interact with
	 */
	public TradeCommand(String give, String take, String npc){
	}
	
	/**
	 * Trades item from user to NPC or vice versa, then returns String to be printed.
	 * @Override execute() 
	 * @return String - Prints string to display action to User
	 */
	public String execute() {
		return null;
	}

}
