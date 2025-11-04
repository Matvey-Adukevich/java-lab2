package org.example.cpu;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ProgramAnalyzer {

    public static String MostPopularInstruction(Program prog){

        Map<String, Long> mapOfPopularity =  prog.stream()
                .map(Command::getName)
                .collect(Collectors.groupingBy(name ->name, Collectors.counting()));
        return "Самая частая команда: "+mapOfPopularity.entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse("No commands");
    }
    public static String RangeOfMemAddresses(Program prog){
        List<Integer> addresses = prog.stream()
                .filter(command -> (command.getName().equals("init"))||(command.getName().equals("ld"))||(command.getName().equals("st")))
                .map(command -> {

                    if (command.getName().equals("init")) {
                        return Integer.parseInt(command.getArg1());
                    } else {
                        return Integer.parseInt(command.getArg2());
                    }

                })
                .collect(Collectors.toList());

        if(addresses.isEmpty()){
            return "Память не использована";
        }
        int min = Collections.min(addresses);
        int max = Collections.max(addresses);

        return "Память: от "+min+" до "+max;
    }
    public static Map<String, Long> getInstructionListOfPopularity(Program prog){
        Map<String, Long> mapOfPopularity= prog.stream()
                .map(Command::getName)
                .collect(Collectors.groupingBy(name -> name, Collectors.counting()));
        return mapOfPopularity.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
        ));

    }
}
