package org.example.cpu;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class RegisterFrameController {
    
    @FXML
    private Label regAValue;
    
    @FXML
    private Label regBValue;
    
    @FXML
    private Label regCValue;
    
    @FXML
    private Label regDValue;
    
//    private Cpu cpu;
    
    @FXML
    void initialize() {
        resetRegisters();
    }

    public void resetRegisters() {
        regAValue.setText("*");
        regBValue.setText("*");
        regCValue.setText("*");
        regDValue.setText("*");
    }

    public void updateRegisters(Cpu cpu) {
        regAValue.setText(cpu.getReg1() == 0 ? "*" : String.valueOf(cpu.getReg1()));
        regBValue.setText(cpu.getReg2() == 0 ? "*" : String.valueOf(cpu.getReg2()));
        regCValue.setText(cpu.getReg3() == 0 ? "*" : String.valueOf(cpu.getReg3()));
        regDValue.setText(cpu.getReg4() == 0 ? "*" : String.valueOf(cpu.getReg4()));
    }


}

