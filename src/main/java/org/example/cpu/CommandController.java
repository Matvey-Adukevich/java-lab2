package org.example.cpu;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class CommandController {
    @FXML Label commandTypeLabel;
    @FXML Label param1Label;
    @FXML Label param2Label;
    @FXML Button upButton;
    @FXML Button downButton;

    private Command command;
    private int index;
    private Program program;

    public void setCommand(Command command, int index, Program program) {
        this.command = command;
        this.index = index;
        this.program = program;

        commandTypeLabel.setText(command.getName());
        param1Label.setText(command.getArg1() != null ? command.getArg1() : "");
        param2Label.setText(command.getArg2() != null ? command.getArg2() : "");

        upButton.setDisable(index == 0);
        downButton.setDisable(index == program.size() - 1);
    }

    @FXML
    void removeCommand() {
        program.remove(index);
    }

    @FXML
    void moveUp() {
        program.swap(index, index - 1);
    }

    @FXML
    void moveDown() {
        program.swap(index, index + 1);
    }
}