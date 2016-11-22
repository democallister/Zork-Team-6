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
public class HealthCommand extends Command{
    
    public String HealthCommand;
    
    public HealthCommand(String h){
        this.HealthCommand = h;
    }
    
    public String execute(){
        if (GameState.instance().getPlayerHealth() >= 75){
            return "All is well.\n";
        }
        if (GameState.instance().getPlayerHealth() < 75 && GameState.instance().getPlayerHealth() >= 50){
            return "Fatigue is starting to rear its ugly head...\n";
        }
        if (GameState.instance().getPlayerHealth() < 50 && GameState.instance().getPlayerHealth() >= 25){
            return "Your body is starting to give out on you...\n";
        }
        else{
            return "Bruh, just leave and rest up.\n";
        }
    }
    
}
