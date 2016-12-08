package zork;
/**
 * Unlocks a locked exit state. Transforms exit boolean from false to true, allowing the user
 * to access the exit.
 * @author Scott, David, Ryan
 * @version Group Project 2
 * 
 */
public class UnlockCommand extends Command {

	private String dir;
        private Exit attempt;
	
	/**
	 * Takes the key to be checked against an Hashtable of keys that an Exit has.
	 * @param dir String value to check against hashtable
	 */
	public UnlockCommand(String dir){
           this.dir = dir;
	}
	
	/**
	 * Executes command and then returns String to be printed stating which door's unlocked.
	 * @Override Command
	 * @return String  to be printed to User
	 */
	public String execute() {
            attempt = GameState.instance().getAdventurersCurrentRoom().getExit(dir);
            if (attempt.getLockState() == true){
            attempt.unlock();
            if (attempt.getLockState() == true)
                return "";
            }
            if (attempt.getLockState() == false){
            return "You can now go " + dir + " to " + attempt.getDest().getTitle() + ".\n";
            }
            return "This door isn't locked.\n";
        }

}
