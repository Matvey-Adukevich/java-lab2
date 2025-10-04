package org.example.cpu;

public class Command {
    String name;
    String arg1, arg2;


    public Command(String command){
        String[] g = command.split(" ");
        if(g.length == 3){
            this.name = g[0];
            this.arg1 = g[1];
            this.arg2 = g[2];
        }
        if(g.length == 1){
            this.name = g[0];
            this.arg1 = null;
            this.arg2 = null;
        }
    }

    public Command(String name, String arg1, String arg2) {
        this.name = name;
        this.arg1 = arg1;
        this.arg2 = arg2;
    }

    public String getName() {return name;}
    public String getArg1() {return arg1;}
    public String getArg2() {return arg2;}
}
