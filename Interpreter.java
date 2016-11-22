/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zork;

import java.util.Scanner;


public class Interpreter {

    private static GameState state; // not strictly necessary; GameState is 
                                    // singleton

    public static String USAGE_MSG = 
        "Usage: Interpreter borkFile.bork|saveFile.sav.";

    public static void main(String args[]) {
        Scanner init = new Scanner(System.in);
        System.out.println("enter a file");
        String initFile = init.next();
        

        String command;
        Scanner commandLine = new Scanner(System.in);

        try {
            state = GameState.instance();
            if (initFile.endsWith(".bork")) {
                state.initialize(new Dungeon(initFile));
                System.out.println("\nWelcome to " + 
                    state.getDungeon().getName() + "!");
            } else if (initFile.endsWith(".sav")) {
                state.restore(initFile);
                System.out.println("\nWelcome back to " + 
                    state.getDungeon().getName() + "!");
            } else {
                System.err.println(USAGE_MSG);
                System.exit(2);
            }
            
            System.out.print("\n" + 
                state.getAdventurersCurrentRoom().describe() + "\n");

            command = promptUser(commandLine);

            while (!command.equals("q")) {

                System.out.print(
                    CommandFactory.instance().parse(command).execute());

                command = promptUser(commandLine);
            }

            System.out.println("Bye!");

        } catch(Exception e) { 
            e.printStackTrace(); 
        }
    }

    private static String promptUser(Scanner commandLine) {

        System.out.print("> ");
        return commandLine.nextLine();
    }

}

