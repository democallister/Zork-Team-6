/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zork;

/**
 *
 * @author Dave
 */
public class ScoreCommand extends Command{
    public String ScoreCommand;
    
    public ScoreCommand(String s){
        this.ScoreCommand = s;
    }
    
    String execute(){
        return "Your current score is: " + GameState.instance().getPlayerScore() + "\n";
    }
}
