package zork;
/**
 * Unlocks a locked exit state. Transforms exit boolean from false to true, allowing the user
 * to access the exit.
 * @author Scott, David, Ryan
 * @version Group Project 2
 * 
 */
public class UnlockCommand extends Command {

	private String key;
	
	/**
	 * Takes the key to be checked against an Hashtable of keys that an Exit has.
	 * @param key String value to check against hashtable
	 */
	public UnlockCommand(String key){
	}
	
	/**
	 * Executes command and then returns String to be printed stating which door's unlocked.
	 * @Override Command
	 * @return String  to be printed to User
	 */
	public String execute() {
		return null;
	}

}
