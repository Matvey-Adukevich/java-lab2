package org.example.cpu;

public class HNoMemCommands extends Handler{
    @Override
    void run(Command command, Cpu cpu) throws CpuException{
        if(command.getName().equals("add")){
            cpu.setRegister("reg4", cpu.getRegister("reg1")+cpu.getRegister("reg2"));
        }
        else if(command.getName().equals("div")){
            cpu.setRegister("reg4", cpu.getRegister("reg1")/cpu.getRegister("reg2"));
        }
        else if(command.getName().equals("mult")){
            cpu.setRegister("reg4", cpu.getRegister("reg1")*cpu.getRegister("reg2"));
        }
        else if(command.getName().equals("sub")){
            cpu.setRegister("reg4", cpu.getRegister("reg1")-cpu.getRegister("reg2"));
        }
        else if(command.getName().equals("mv")){
            String register1 = command.getArg1();
            String register2 = command.getArg2();
            cpu.setRegister(register1, cpu.getRegister(register2));
        }
        else if(command.getName().equals("print")){
            System.out.println(cpu.getRegister("reg1")+" "+cpu.getRegister("reg2")+" "+cpu.getRegister("reg3")+" "+cpu.getRegister("reg4"));
        }
        else{
            super.run(command, cpu);
        }
    }
}
