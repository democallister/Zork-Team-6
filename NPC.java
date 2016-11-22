package zork;
import java.util.*;
/**
 * New Supplementary feature. NPCs can trade items with the player, talk, have their own descriptions and inventory.
 * NPCs are placed in certain rooms, and are read from new lines added to the save/bork files.
 * @author Scott, David, Ryan
 * @version Group Project 2
 *
 */
public class NPC {

	private String name;
	private String description;
	private ArrayList<Item> Inventory;
	private Hashtable dialogue;
	private Room location;
	
	/**
	 * Reads off the npcs and places them in their locations.
	 * @param S Takes a scanner tossed from Room to read off the list of NPCs 
	 */
	NPC(Scanner S){
	}
	/**
	 * Removes item from players inventory, and gives it to npc. Vice versa for npc.
	 * @param give Item to be given
	 * @param take Item to be received
	 * @return Item - Gives item to player
	 */
	Item trade(Item give, Item take){
		return null;
	}
	
	/**
	 * Removes item from players inventory and adds it to NPCs
	 * @param gift Item to be given
	 */
	public void give(Item gift){
	}
	
	/**
	 * Takes an item from an npcs inventory and adds it to the players.
	 * @param present item to be taken
	 * @return Item - Item to add to players inventory
	 */
	Item take(Item present){
		return null;
	}
	
	/**
	 * Takes in a String prompt, checks it against hashtable of npc dialogue, returns a String
	 * based on result of hashtable for what to say.
	 * @param prompt String to be checked against
	 * @return String - response to prompt
	 */
	String talk(String prompt){
		return null;
	}
	
	/**
	 * Describes an npc
	 * @return String - description of npc
	 */
	public String describe(){
		return null;
	}
	
	/**
	 * Returns the name of an npc
	 * @return String - name of npc
	 */
	String getName(){
		return null;
	}
	
	/**
	 * Sets the description of an npc
	 * @param desc description of npc
	 */
	void setDesc(String desc){
	}
	
	/**
	 * Adds npc line to save file, including inventory, location, status.
	 */
	public void storeState(){
	}
}
