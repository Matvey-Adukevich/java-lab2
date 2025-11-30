package org.example.cpu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Program implements Iterable<Command>{//Model
    List<Command> commands = new ArrayList<>();
    ArrayList<IObserver> observers = new ArrayList<>();


    public void add(Command command){
        commands.add(command);
        event();
    }
    
    public void remove(int index) {
        if (index >= 0 && index < commands.size()) {
            commands.remove(index);
            event();
        }
    }
    
    public void swap(int index1, int index2) {
        if (index1 >= 0 && index1 < commands.size() && 
            index2 >= 0 && index2 < commands.size() && index1 != index2) {
            Command temp = commands.get(index1);
            commands.set(index1, commands.get(index2));
            commands.set(index2, temp);
            event();
        }
    }

    public void event() {
        observers.forEach(action -> action.event());
    }

    public void AddObserver(IObserver o){
        observers.add(o);
    }

    @Override
    public Iterator<Command> iterator() {
        return commands.iterator();
    }

    public Stream<Command> stream(){
        return commands.stream();
    }

    public String MostPopularInstruction(){
        return ProgramAnalyzer.MostPopularInstruction(this);
    }
    public String RangeOfMemAddresses(){
        return ProgramAnalyzer.RangeOfMemAddresses(this);
    }
    public Map<String, Long> getInstructionListOfPopularity(){
        System.out.print("Инструкции по частоте применения: ");
        return ProgramAnalyzer.getInstructionListOfPopularity(this);
    }


    private int currentExecutionIndex = -1;


    public int size() {
        return commands.size();
    }

    public Command get(int index) {
        return commands.get(index);
    }

    public boolean hasNextCommand() {
        return currentExecutionIndex < commands.size() - 1;
    }

    public Command getNextCommand() {
        if (hasNextCommand()) {
            currentExecutionIndex++;
            event();
            return commands.get(currentExecutionIndex);
        }
        return null;
    }

    public void resetExecution() {
        currentExecutionIndex = -1;
        event();
    }

    public int getCurrentExecutionIndex() {
        return currentExecutionIndex;
    }

//    public boolean isExecuting() {
//        return currentExecutionIndex >= 0;
//    }

}
