package org.example.cpu;

public interface ICpu {
    void exec(Command command) throws CpuException;
}
