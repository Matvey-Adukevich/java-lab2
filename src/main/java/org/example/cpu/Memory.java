package org.example.cpu;

public class Memory {
    int[] mem = new int[1024];

    public Memory(){

    }

    public int read(int address){
        return mem[address];
    }

    public void write(int address, int value){
        mem[address] = value;
    }
}
