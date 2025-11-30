package org.example;

import org.example.cpu.Command;
import org.example.cpu.CpuException;
import org.example.cpu.ICpu;
import org.example.cpu.Program;

public class Executer {
    ICpu cpu;

    public Executer(ICpu cpu){
        this.cpu = cpu;
    }

    public void run(Iterable<Command> prog) throws CpuException {
        for (Command command : prog) {
            cpu.exec(command);
        }
    }

    public void run(Command command) throws CpuException{
        cpu.exec(command);
    }
//        Iterator<Command> it = prog.iterator();
//        while (it.hasNext()){
//            cpu.exec(it.next());
//        }
//        for (Command command: prog.iterator()){};
//        for(Command command: prog){
//            cpu.exec(command);
//        }
}

