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
        return "You are currently at " + GameState.instance().getPlayerHealth() + "% health\n";
    }
    
}
