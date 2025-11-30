package org.example.cpu;

import java.util.ArrayList;
import java.util.List;

public class Cpu implements ICpu {
    int reg1;
    int reg2;
    int reg3;
    int reg4;
    Memory mem;

    Handler handler = new Handler();

    private List<IObserver> Observers = new ArrayList<>();

    public Cpu(Memory mem){
        this.mem = mem;
    }

    public void AddObserver(IObserver o){
        Observers.add(o);
    }

    private void notifyObservers() {
        for (IObserver observer : Observers) {
            observer.event();
        }
    }

    public Handler getHandler(){
        return handler;
    }

    public int getReg1() {return reg1;}
    public int getReg2() {return reg2;}
    public int getReg3() {return reg3;}
    public int getReg4() {return reg4;}

    public int getRegister(String register) throws CpuException{
        switch(register){
            case "reg1":
                return this.reg1;
            case "reg2":
                return this.reg2;
            case "reg3":
                return this.reg3;
            case "reg4":
                return this.reg4;
            default:
                throw new CpuException("reg exception");
        }
    }

    public void resetRegisters() {
        reg1 = 0;
        reg2 = 0;
        reg3 = 0;
        reg4 = 0;
        notifyObservers(); // Уведомляем об изменении
    }

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
        notifyObservers();
    }

    @Override
    public void exec(Command command) throws CpuException{
        handler.run(command, this);
    }
}
