package org.example;

import org.example.cpu.*;

public class Main
{
    public static void main( String[] args )
    {
            Command prog[] = {
                    new Command("init", "10", "20"),
                    new Command("init", "11", "25"),
                    new Command("init", "12", "5"),
                    new Command("ld", "reg1", "10"),
                    new Command("ld", "reg2", "11"),
                    new Command("ld", "reg3", "12"),
                    new Command("add"),
                    new Command("print"),
                    new Command("mv reg1 reg4"),
                    new Command("mv reg2 reg3"),
                    new Command("div"),
                    new Command("print")
            };

            Memory mem = new Memory();
            ICpu cpu = BCpu.build(mem);

            Executer exec = new Executer(cpu);
            try{
                exec.run(prog);
            }
            catch(CpuException ce){
                System.out.println("Exception");
            }
    }
}
