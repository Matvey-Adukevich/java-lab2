package org.example;

import org.example.cpu.Command;
import org.example.cpu.ICpu;

public class Executer {
    ICpu cpu;

    public Executer(ICpu cpu){
        this.cpu = cpu;
    }

    public void run(Command[] prog){
        for(Command command: prog){
            cpu.exec(command);
        }
    }
}
