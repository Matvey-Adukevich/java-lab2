package org.example.cpu;

public class HLd extends Handler {
    @Override
    void run(Command command, Cpu cpu){
        if(command.getName().equals("ld")){
            String reg = command.getArg1();
            String address = command.getArg2();
            cpu.setRegister(reg, cpu.mem.read(Integer.parseInt(address)));
        }
        else{
            super.run(command, cpu);
        }
    }
//    void run(Command command, Cpu cpu) throws CpuException{
//        if(command.getAction() == typeAction.ld){
////
//        }
//    }
}
