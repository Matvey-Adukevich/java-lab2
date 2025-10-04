package org.example.cpu;

public class BCpu {
    static Cpu cpu;

    public static ICpu build(Memory mem){
        if(cpu == null){
            cpu = new Cpu(mem);
            cpu.getHandler()
                    .add(new HLd());

        }
        return cpu;
    }
}
