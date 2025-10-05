package org.example.cpu;

public class HPrint extends Handler{
    @Override
    void run(Command command, Cpu cpu) throws CpuException{
        if(command.getName().equals("print")){
            System.out.println(cpu.getRegister("reg1")+" "+cpu.getRegister("reg2")+" "+cpu.getRegister("reg3")+" "+cpu.getRegister("reg4"));
        }
        else{
            super.run(command, cpu);
        }
    }

}
