package org.example.cpu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Program implements Iterable<Command>{
    private List<Command> commands = new ArrayList<>();


    public void add(Command command){
        commands.add(command);
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

//    @Override
//    public void forEach(Consumer<? super Command> action) {
//        Iterable.super.forEach(action);
//    }
}
