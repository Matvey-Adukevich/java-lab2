package org.example.cpu;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import org.example.Executer;

import java.io.IOException;

public class MainFrameController implements IObserver {
    Program program = new Program();
    Cpu cpu = (Cpu) BCpu.build();
    Executer executer = new Executer(cpu);


    @FXML TextField commandInputField;
    @FXML VBox allCommands;

    @FXML RegisterFrameController registerFrameController;
    @FXML MemoryFrameController memoryFrameController;
    @FXML InstructionFrequencyFrameController frequencyFrameController;

    @FXML
    void initialize() {
        program.AddObserver(this);
        cpu.AddObserver(this);
        frequencyFrameController.updateFrequency(program);
    }

    @FXML
    void addCommand() {
        program.add(new Command(commandInputField.getText()));
        commandInputField.clear();
        frequencyFrameController.updateFrequency(program);
    }

    @Override
    public void event() {
        updateRegistersDisplay();
        updateMemoryDisplay();
        frequencyFrameController.updateFrequency(program);
        allCommands.getChildren().clear();

        int index = 0;
        for (Command cmd : program) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CommandFrame.fxml"));
                Pane pane = fxmlLoader.load();

                CommandController controller = fxmlLoader.getController();
                controller.setCommand(cmd, index, program);

                if (index == program.getCurrentExecutionIndex()) {
                    pane.setStyle("-fx-background-color: #ffcccc;");
                }

                allCommands.getChildren().add(pane);
                index++;

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @FXML
    void resetExecution() {
        program.resetExecution();
        cpu.resetRegisters();
        memoryFrameController.resetMemory();
        cpu.mem.reset();
        frequencyFrameController.updateFrequency(program);
    }

    @FXML
    void executeNextInstruction() throws CpuException {
        executer.run(program.getNextCommand());
        event();
    }

    private RegisterFrameController registerController;

    private void updateRegistersDisplay() {
        if (registerFrameController != null && cpu != null) {
            registerFrameController.updateRegisters(cpu);
        }
    }

    private void updateMemoryDisplay() {
        if (memoryFrameController != null && cpu != null) {
            memoryFrameController.updateMemory(cpu.mem);
        }
    }
}