package org.example;

import org.example.cpu.*;

public class Main
{
    public static void main( String[] args )
    {
            Command prog[] = {
                    new Command("ld", "reg2", "20"),
                    new Command("ld", "reg1", "10")
            };

            Memory mem = new Memory();
            ICpu cpu = BCpu.build(mem);

            Executer exec = new Executer(cpu);
            exec.run(prog);
//        } catch(CpuException e){
//            System.out.println("exception");
//        }

    }
}
