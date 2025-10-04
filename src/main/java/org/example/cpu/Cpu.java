package org.example.cpu;

public class Cpu implements ICpu {
    int reg1;
    int reg2;
    int reg3;
    int reg4;
    Memory mem;

    Handler handler = new Handler();

    public Cpu(Memory mem){
        this.mem = mem;
    }

    public Handler getHandler(){
        return handler;
    }

    public int getReg1() {return reg1;}
    public int getReg2() {return reg2;}
    public int getReg3() {return reg3;}
    public int getReg4() {return reg4;}
    public void setRegister(String register, int value){
        switch(register){
            case "reg1":
                reg1 = value;
                break;
            case "reg2":
                reg2 = value;
                break;
            case "reg3":
                reg3 = value;
                break;
            case "reg4":
                reg4 = value;
                break;
        }
    }

//    public int[] getMemory(){
//        return mem;
//    }

    @Override
    public void exec(Command command){
        handler.run(command, this);
    }
//    @Override
//    public void exec(Command command) throws CpuException{
//        handler.run(command, this);
//    }

//    @Override
//    public String toString() {
//        return "Shop{" +
//                "cnt_board=" + cnt_board +
//                ", cnt_table=" + cnt_table +
//                ", cnt_money=" + cnt_money +
//                '}';
//    }
}
