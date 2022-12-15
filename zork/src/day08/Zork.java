package day08;

import java.io.BufferedReader;
import java.io.Console;
import java.io.FileReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class Zork {
  public static void main(String[] args) throws Exception{

    //establish file as args[0]
    String fileName = args [0];
    //System.out.printf("Processing %s\n\n", fileName);

    //read the file
    FileReader fr = new FileReader(fileName);
    BufferedReader br = new BufferedReader(fr);

    //establish a console to get user input
    Console cons = System.console();
    Boolean stop = false;

    String line;
    List<String> lines = new LinkedList<>();

    //read line continuously till end of file and add to a List of lines
    while((line = br.readLine()) != null){
      lines.add(line);
    } //System.out.println(lines);

    String currentRoom="";
    String currentName="";
    String currentDescription="";
    String currentDirection="";
    String initialRoom="";
    Map<String, String> currentDirections = new HashMap<>();
    Map<String, Room> rooms = new HashMap<>();

    for(Integer i = 0; i<lines.size();i++){
      if(lines.get(i).startsWith("room")){
        currentRoom = lines.get(i).substring(6);
      //System.out.println(currentRoom);
    }else if(lines.get(i).startsWith("name")){
      currentName = lines.get(i).substring(6);
      //System.out.println(currentName);
    }else if(lines.get(i).startsWith("description")){
      currentDescription = lines.get(i).substring(13);
      //System.out.println(currentDescription);
    }else if(lines.get(i).startsWith("direction")){
      currentDirection = lines.get(i).substring(11);
      String[] splitCurrentDirection = currentDirection.split(" ");
      currentDirections.put(splitCurrentDirection[0].trim(), splitCurrentDirection[1].trim());
      //System.out.println(currentDirections);
    }else if(lines.get(i).startsWith("start")){
      initialRoom = lines.get(i).substring(7);
      //System.out.println(initialRoom);
    }else if(lines.get(i).equals("")){
      Room location = new Room(currentRoom,currentName,currentDescription,currentDirections); //**creating new location
      //System.out.println(location);
      rooms.put(currentRoom,location);
      currentDirections = new HashMap<>(); //**creating new currentDirections for each new location
    }}

    System.out.printf("Welcome to Zork!\nYou are starting at %s.\n%s\n",initialRoom,rooms.get(initialRoom).getDescription());
    currentRoom = initialRoom;

    while (!stop){
      
      String userinput = cons.readLine(">");

      if ((userinput.equals("north"))||(userinput.equals("south"))||(userinput.equals("east"))||(userinput.equals("west"))){
        if(!rooms.get(currentRoom).getDirection().containsKey(userinput)){
          System.out.printf("Invalid direction. You cannot go there.\n");
        }else {
          currentRoom = rooms.get(currentRoom).getDirection().get(userinput);
          System.out.printf("You are at %s.\n",currentRoom);
          System.out.printf("%s\n",rooms.get(currentRoom).getDescription());
        }
      }else if (userinput.equals("look")){
        System.out.printf("You are at %s.\n",currentRoom);
        System.out.printf("%s\n",rooms.get(currentRoom).getDescription());
      } else if (userinput.equals("exit")){
        stop = true;
        System.out.printf("Thank you for playing. See you again.");
      } else {
        System.out.println("Invalid key.");
      }
      
      }

  }//main

}//class

