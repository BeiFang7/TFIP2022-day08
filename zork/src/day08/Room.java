package day08;

import java.util.Map;

public class Room {
  private String room;
  private String name;
  private String description;

  public Room(String room, String name, String description, Map<String, String> direction) {
    this.room = room;
    this.name = name;
    this.description = description;
    this.direction = direction;
  }

  private Map<String, String> direction;

  public String getRoom() {
    return room;
  }
  public void setRoom(String room) {
    this.room = room;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getDescription() {
    return description.replaceAll("<break>","\n");
  }
  public void setDescription(String description) {
    this.description = description;
  }
  public Map<String, String> getDirection() {
    return direction;
  }
  public void setDirection(Map<String, String> direction) {
    this.direction = direction;
  }
  
}
