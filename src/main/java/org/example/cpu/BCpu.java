package org.example.cpu;

public class BCpu {
    static Cpu cpu;

    public static ICpu build(Memory mem){
        if(cpu == null){
            cpu = new Cpu(mem);
            cpu.getHandler()
                    .add(new HMemCommands())
//                    .add(new HLd())
//                    .add(new HSt())
                    .add(new HNoMemCommands());
//                    .add(new HPrint())
//                    .add(new HAdd())
//                    .add(new HSub())
//                    .add(new HMult())
//                    .add(new HDiv());
        }
        return cpu;
    }
}
