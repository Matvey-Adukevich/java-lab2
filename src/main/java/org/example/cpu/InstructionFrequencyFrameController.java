package org.example.cpu;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import java.util.Map;

public class InstructionFrequencyFrameController {

    @FXML
    private VBox frequencyList;


    public void updateFrequency(Program program) {
        frequencyList.getChildren().clear();


        Map<String, Long> frequency = ProgramAnalyzer.getInstructionListOfPopularity(program);

        for (Map.Entry<String, Long> entry : frequency.entrySet()) {
            Label label = new Label(entry.getKey() + " : " + entry.getValue());
            frequencyList.getChildren().add(label);
        }
    }

}