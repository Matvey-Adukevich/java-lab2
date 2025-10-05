package org.example;

import org.example.cpu.Command;
import org.example.cpu.CpuException;
import org.example.cpu.ICpu;

public class Executer {
    ICpu cpu;

    public Executer(ICpu cpu){
        this.cpu = cpu;
    }

    public void run(Command[] prog) throws CpuException{
        for(Command command: prog){
            cpu.exec(command);
        }
    }
}
