package zork;
import java.util.*;

import zork.Item.NoItemException;
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
	private Hashtable<String, String> dialogue;
	private String RoomName;
	
	static class NoNPCException extends Exception{}
	
	/**
	 * Reads off the npcs and places them in their locations.
	 * @param S Takes a scanner tossed from Room to read off the list of NPCs 
	 */
	NPC(Scanner S, Dungeon d) throws Dungeon.IllegalDungeonFormatException, NoNPCException{
		Inventory = new ArrayList<Item>();
		dialogue = new Hashtable<String, String>();
		
		name = S.nextLine();
		if(name.equals("==="))
			throw new NoNPCException();
		
		RoomName = S.nextLine();
		description = S.nextLine();
		String lineOfDesc = S.nextLine();
		
		while (!lineOfDesc.equals(Dungeon.SECOND_LEVEL_DELIM) &&
	               !lineOfDesc.equals(Dungeon.TOP_LEVEL_DELIM)) {
			
				if(lineOfDesc.contains(":")){
					String[] dialogueParts = lineOfDesc.split(":");
					dialogue.put(dialogueParts[0], dialogueParts[1]);
				}else{
					try {
						Inventory.add(d.getItem(lineOfDesc));
					} catch (NoItemException e) {
					}
				}
				lineOfDesc = S.nextLine();
	        }
		
		d.getRoom(RoomName).add(this);
	}

	
	/**
	 * Removes item from players inventory and adds it to NPCs
	 * @param gift Item to be given
	 */
	public void give(Item gift){
		System.out.println("Thanks friend");
		Inventory.add(gift);
	}
	
	/**
	 * Takes in a String prompt, checks it against hashtable of npc dialogue, returns a String
	 * based on result of hashtable for what to say.
	 * @param prompt String to be checked against
	 * @return String - response to prompt
	 */
	String talk(String prompt){
		return dialogue.get(prompt);
	}
	
	/**
	 * Describes an npc
	 * @return String - description of npc
	 */
	public String describe(){
		return description;
	}
	
	/**
	 * Returns the name of an npc
	 * @return String - name of npc
	 */
	String getName(){
		return name;
	}
	
	/**
	 * Sets the description of an npc
	 * @param desc description of npc
	 */
	void setDesc(String desc){
		description = desc;
	}
	
	String getRoomName(){
		return RoomName;
	}

	boolean goesBy(String name){
		return this.name.equals(name);
	}
	
	boolean hasDialogue(String prompt){
		return dialogue.containsKey(prompt);
	}
	
	Item getItem() {
		return Inventory.get(0);
	}
	
	boolean hasItem(){
		return !Inventory.isEmpty();
	}
	
	void removeItem(String name){
		for(Item a: Inventory){
			if (a.goesBy(name));
				Inventory.remove(a);
		}
	}
	/**
	 * Adds npc line to save file, including inventory, location, status.
	 */
	public void storeState(){
	}
}
