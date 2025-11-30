package org.example.cpu;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class MemoryFrameController {

    @FXML
    private GridPane memoryGrid;

    private Label[][] memoryCells = new Label[4][10];

    @FXML
    void initialize() {
        for (int col = 0; col < 10; col++) {
            Label header = new Label(String.valueOf(col + 1));
            memoryGrid.add(header, col + 1, 0);
        }
        for (int row = 0; row < 4; row++) {
            Label header = new Label(String.valueOf(row * 10));
            memoryGrid.add(header, 0, row + 1);
        }
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 10; col++) {
                Label cell = new Label("0");
                memoryCells[row][col] = cell;
                memoryGrid.add(cell, col + 1, row + 1);
            }
        }
    }

    public void updateMemory(Memory memory) {
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 10; col++) {
                int value = memory.read(row * 10 + col + 1);
                memoryCells[row][col].setText(String.valueOf(value));
            }
        }
    }

    public void resetMemory() {
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 10; col++) {
                memoryCells[row][col].setText("*");
            }
        }
    }
}