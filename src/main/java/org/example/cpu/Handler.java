package org.example.cpu;

public class Handler {
    Handler next;

    void run(Command command, Cpu cpu){
        if(next != null){
            next.run(command, cpu);

        }
//        else{
//            throw new CpuException("не могу выполнить");
//        }
    }

//    void run(Command command, Cpu cpu) throws CpuException{
//        if(next != null){
//            next.run(command, cpu);
//
//        }
//        else{
//            throw new CpuException("не могу выполнить");
//        }
//    }

    Handler add(Handler next){
        this.next = next;
        return next;
    }
}
