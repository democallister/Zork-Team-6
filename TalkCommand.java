package zork;
/**
 * Allows a player to talk to an NPC, giving different dialogue based on Player input.
 * @author Scott, David, Ryan
 * @version Group Project 2
 */
public class TalkCommand extends Command{

	private String prompt;
	private String npcName;
	
	/**
	 * Stores variables for execute
	 * @param p String inputed by player
	 */
	public TalkCommand(String prompt, String npcName){
		this.prompt = prompt;
		this.npcName = npcName;
	}
	
	/**
	 * Returns String by checking player inputed String against a hashtable of NPC dialogue options
	 * @return String - Returns string based on dialogue hashtable
	 */
	public String execute() {
		NPC npcReferredTo = null;
    	try {
    		npcReferredTo = GameState.instance().getNPCInVicinityNamed(npcName);
    	} catch (NPC.NoNPCException e) {
        	return "There's no NPC named " + npcName + " here. \n";
    	}
   	 
    	if(npcReferredTo.hasDialogue(prompt)){
    		return npcReferredTo.talk(prompt) + "\n";
    	}
        
    	return("Sorry, " + npcName + " doesn't want to talk about that." + "\n");
    
	}
	}


