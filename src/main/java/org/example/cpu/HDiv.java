package org.example.cpu;

public class HDiv extends Handler{
    @Override
    void run(Command command, Cpu cpu) throws CpuException{
        if(command.getName().equals("div")){
            cpu.setRegister("reg4", cpu.getRegister("reg1")/cpu.getRegister("reg2"));
        }
        else{
            super.run(command, cpu);
        }
    }
}
