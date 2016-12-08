
package zork;

import java.util.List;
import java.util.Arrays;

public class CommandFactory {

    private static CommandFactory theInstance;
    public static List<String> MOVEMENT_COMMANDS = 
        Arrays.asList("n","w","e","s","u","d" );
    
    public static List<String> DIALOGUE_OPTIONS = 
    		Arrays.asList("Dialogue", "Hello", "Trade", "Moon");
    public static synchronized CommandFactory instance() {
        if (theInstance == null) {
            theInstance = new CommandFactory();
        }
        return theInstance;
    }

    private CommandFactory() {
    }

    public Command parse(String command) {
        String parts[] = command.split(" ");
        String verb = parts[0];
        String noun = parts.length >= 2 ? parts[1] : "";
        String noun2 = "temp";
        if(parts.length >= 3)
        	 noun2 = parts[2];
        if (verb.equals("save")) {
            return new SaveCommand(noun);
        }
        if (verb.equals("health")){
            return new HealthCommand(noun);
        }
        if (verb.equals("score")){
            return new ScoreCommand(noun);
        }
        if (verb.equals("take")) {
            return new TakeCommand(noun);
        }
        if (verb.equals("drop")) {
            return new DropCommand(noun);
        }
        if (verb.equals("i") || verb.equals("inventory")) {
            return new InventoryCommand();
        }
        if (verb.equals("unlock")){
            return new UnlockCommand(noun);
        }
        if (verb.equals("craft")){
            return new CraftCommand(parts[1], parts[2]);
        }
        if (MOVEMENT_COMMANDS.contains(verb)) {
            return new MovementCommand(verb);
        }
        if(parts.length == 3 && verb.equals("Trade")){
        	return new TradeCommand(verb, noun, noun2);
        }
        if(parts.length == 2 && DIALOGUE_OPTIONS.contains(verb)){
        	return new TalkCommand(verb, noun);
        }
        if (parts.length == 2 && !DIALOGUE_OPTIONS.contains(verb)) {
            return new ItemSpecificCommand(verb, noun);
        }
        
        return new UnknownCommand(command);
    }
}
