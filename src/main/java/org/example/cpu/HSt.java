package org.example.cpu;

public class HSt extends Handler {
    @Override
    void run(Command command, Cpu cpu) throws CpuException{
        if(command.getName().equals("st")){
            String register = command.getArg1();
            String address = command.getArg2();
            cpu.mem.write(Integer.parseInt(address), cpu.getRegister(register));
        }
        else{
            super.run(command, cpu);
        }
    }
}
