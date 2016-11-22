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
 public class Event {
    private String fullEvent;
    private static GameState state;
    private static Dungeon dungeon;
    Item item;
    
    public Event(Item item, String fullEvent){
   	this.fullEvent = fullEvent;
   	this.item = item;
    }


    String execute(){
        state = GameState.instance();
   	dungeon = state.getDungeon();
   	 
   	//Gets whatever's inside the []
   	String events = fullEvent.substring(0,fullEvent.indexOf(']'));
   	//Splits that into individual events
   	String[] eventList = events.split(",");
   	 
   	//Runs through every event and does their action
   	for(String a : eventList){
            this.determineType(a);
   	}
   	 
   	//Returns the flavor text to be printed
    	return fullEvent.substring(fullEvent.indexOf(":")+1) + "\n";
    }


    void determineType(String eventName){
        if(eventName.contains("Wound"))
            this.woundEvent(eventName); 
        else if(eventName.contains("Score"))
            this.scoreEvent(eventName);
        else if(eventName.contains("Die"))
            this.deathEvent();
        else if(eventName.contains("Teleport"))
            this.teleportEvent();
        else if(eventName.contains("Disappear"))
            this.disappearEvent();
        else if(eventName.contains("Transform"))
            this.transformEvent(eventName);
        else if(eventName.contains("Win"))
            this.winEvent();
    }


    private void deathEvent(){
   	Interpreter.endState = true;
    }


    private void scoreEvent(String eventName){
   	int points = Integer.parseInt(eventName.replaceAll("[\\D]", ""));
   	state.setPlayerScore(state.getPlayerScore()+points);
    }

    private void woundEvent(String eventName){
   	int points = Integer.parseInt(eventName.replaceAll("[\\D]", ""));
   	state.setPlayerHealth(state.getPlayerHealth()-points);
    }


    private void teleportEvent(){
   	state.setAdventurersCurrentRoom(dungeon.getRandomRoom());
    }

    private void disappearEvent(){
   	state.removeFromInventory(item);
   	state.getAdventurersCurrentRoom().remove(item);
    }

    private void transformEvent(String eventName){
   	state.removeFromInventory(item);
   	state.getAdventurersCurrentRoom().remove(item);
   	 
   	String itemName = eventName.substring(eventName.indexOf('(')+1, eventName.indexOf(')'));
   	 
   	try {
            state.addToInventory(dungeon.getItem(itemName));
   	}catch (Item.NoItemException e) {
            System.out.println("Couldn't find the item!");
   	}
    }


    private void winEvent(){
   	Interpreter.endState = true;
    }
}
