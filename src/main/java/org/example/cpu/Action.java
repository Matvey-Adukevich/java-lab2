package org.example.cpu;

public class Action {
    String name;
    typeAction action;

    public Action(String name, typeAction action){
        this.name = name;
        this.action = action;
    }

    public String getName() {return name;}

    public typeAction getAction() {return action;}

//    @Override
//    public String toString() {
//        return "Action{" +
//                "name='" + name + '\'' +
//                ", action=" + action +
//                '}';
//    }
}
