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
    @Override
    String execute(){
          if (GameState.instance().getPlayerScore() <= 24){
            return "Your current score is: " + GameState.instance().getPlayerScore() + "\nYour current rank is Bronze.\n";
        }
          if (GameState.instance().getPlayerScore() > 24 && GameState.instance().getPlayerScore() <= 49){
            return "Your current score is: " + GameState.instance().getPlayerScore() + "\nYour current rank is Silver.\n";
        }
         if (GameState.instance().getPlayerScore() > 49 && GameState.instance().getPlayerScore() <= 74){
            return "Your current score is: " + GameState.instance().getPlayerScore() + "\nYour current rank is Gold.\n";
        } 
         else{
            return "Your current score is: " + GameState.instance().getPlayerScore() + "\nYour current rank is Platinum.\n";
        }
    }
}
