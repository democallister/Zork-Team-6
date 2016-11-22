package zork;
import java.util.*;
public class Tester {

	public static void main(String[] args){
		
		String test = "Stringone, Stringtwo";
		String[] event = test.split(",");
		System.out.println(event[1]);
		
		String eventName = "kick[Wound(2)]:Ouch! That hurt your foot. ";
		String[] eventParts = eventName.split("\\[");
		System.out.println(eventParts[0]);
		System.out.println(eventParts[1].substring(0,eventParts[1].indexOf(']')));
	}
}
