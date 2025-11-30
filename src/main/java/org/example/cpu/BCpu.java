package org.example.cpu;

public class BCpu {
    static Cpu cpu;
    static Memory memory = new Memory();

    public static ICpu build(){
        if(cpu == null){
            cpu = new Cpu(memory);
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

    public static Memory getMemory(){
        return memory;
    }
}
