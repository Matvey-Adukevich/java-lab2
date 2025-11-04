package org.example;

import org.example.cpu.*;

public class Main
{
    public static void main( String[] args )
    {
//            Command prog[] = {
//                    new Command("init", "10", "20"),
//                    new Command("init", "11", "25"),
//                    new Command("init", "12", "5"),
//                    new Command("ld", "reg1", "10"),
//                    new Command("ld", "reg2", "11"),
//                    new Command("ld", "reg3", "12"),
//                    new Command("add"),
//                    new Command("print"),
//                    new Command("mv reg1 reg4"),
//                    new Command("mv reg2 reg3"),
//                    new Command("div"),
//                    new Command("print")
//            };
        Program prog = new Program();
        prog.add(new Command("init 10 20"));
        prog.add(new Command("init" ,"11", "25"));
        prog.add(new Command("ld", "reg1" ,"10"));
        prog.add(new Command("ld", "reg2" ,"11"));
        prog.add(new Command("ld", "reg3" ,"11"));
        prog.add(new Command("add"));
        prog.add(new Command("mv", "reg1" ,"reg4"));
        prog.add(new Command("add"));
        prog.add(new Command("print"));

//        for(Command c: prog) System.out.println(c);
        System.out.println(prog.MostPopularInstruction()); // ld
        System.out.println(prog.RangeOfMemAddresses());
        System.out.println(prog.getInstructionListOfPopularity());

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
