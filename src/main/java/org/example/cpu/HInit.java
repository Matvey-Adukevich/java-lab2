package org.example.cpu;

public class HInit extends Handler {
    @Override
    void run(Command command, Cpu cpu) throws CpuException{
        if(command.getName().equals("init")){
            String address = command.getArg1();
            String value = command.getArg2();
            cpu.mem.write(Integer.parseInt(address), Integer.parseInt(value));
        }
        else{
            super.run(command, cpu);
        }
    }
}
