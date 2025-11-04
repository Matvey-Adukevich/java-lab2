package org.example.cpu;

public class HMemCommands extends Handler {
    @Override
    void run(Command command, Cpu cpu) throws CpuException{
        if(command.getName().equals("init")){
            String address = command.getArg1();
            String value = command.getArg2();
            cpu.mem.write(Integer.parseInt(address), Integer.parseInt(value));
        }
        else if(command.getName().equals("ld")){
            String reg = command.getArg1();
            String address = command.getArg2();
            cpu.setRegister(reg, cpu.mem.read(Integer.parseInt(address)));
        }
        else if(command.getName().equals("st")){
            String register = command.getArg1();
            String address = command.getArg2();
            cpu.mem.write(Integer.parseInt(address), cpu.getRegister(register));
        }
        else{
            super.run(command, cpu);
        }
    }
}
