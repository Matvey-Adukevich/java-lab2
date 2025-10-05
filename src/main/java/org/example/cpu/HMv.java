package org.example.cpu;

public class HMv extends Handler{
    @Override
    void run(Command command, Cpu cpu) throws CpuException{
        if(command.getName().equals("mv")){
            String register1 = command.getArg1();
            String register2 = command.getArg2();
            cpu.setRegister(register1, cpu.getRegister(register2));
        }
        else{
            super.run(command, cpu);
        }
    }

}
