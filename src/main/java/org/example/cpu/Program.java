package org.example.cpu;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@Entity
@Table(name = "programs")
public class Program implements Iterable<Command> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "current_execution_index")
    private int currentExecutionIndex = -1;

    @OneToMany(mappedBy = "program", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("orderIndex ASC")
    List<Command> commands = new ArrayList<>();

    @Transient//не сохраняется в БД
    ArrayList<IObserver> observers = new ArrayList<>();

    @Transient
    ProgramDAO programDAO = new ProgramDAO_Hibernate();

//    private boolean loadedFromDB = false;

    public Program() {
    }

//    private void loadFromDatabase() {
//        if(!loadedFromDB) {
//            loadedFromDB = true;
//            Program savedProgram = programDAO.getProgram();
//            if (savedProgram != null && savedProgram.commands != null) {
//                this.commands = new ArrayList<>(savedProgram.commands);
//                this.currentExecutionIndex = savedProgram.currentExecutionIndex;
//
//                for (Command cmd : this.commands) {
//                    cmd.setProgram(this);
//                }
//            }
//        }
//    }


    private void saveToDatabase() {
        programDAO.save(this);
    }

    public void add(Command command){
        command.setProgram(this);
        command.setOrderIndex(commands.size());
        commands.add(command);
        event();
        saveToDatabase();
    }

    public void remove(int index) {
        if (index >= 0 && index < commands.size()) {
            commands.remove(index);
            event();
            saveToDatabase();
        }
    }

    public void swap(int index1, int index2) {
        if (index1 >= 0 && index1 < commands.size() &&
                index2 >= 0 && index2 < commands.size() && index1 != index2) {
            Command temp = commands.get(index1);
            commands.set(index1, commands.get(index2));
            commands.set(index2, temp);
            event();
            saveToDatabase();
        }
    }

    public void event() {
        observers.forEach(action -> action.event());
    }

    public void AddObserver(IObserver o){
        observers.add(o);
        event();
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
        return ProgramAnalyzer.getInstructionListOfPopularity(this);
    }

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
            saveToDatabase();
            return commands.get(currentExecutionIndex);
        }
        return null;
    }

    public void resetExecution() {
        currentExecutionIndex = -1;
        event();
        saveToDatabase();
    }

    public int getCurrentExecutionIndex() {
        return currentExecutionIndex;
    }


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public void setCurrentExecutionIndex(int currentExecutionIndex) {
        this.currentExecutionIndex = currentExecutionIndex;
    }

    public List<Command> getCommands() { return commands; }
    public void setCommands(List<Command> commands) { this.commands = commands; }
    public void setObservers(ArrayList<IObserver> observers) { this.observers = observers; }
    public void setProgramDAO(ProgramDAO programDAO) { this.programDAO = programDAO; }

    private ArrayList<IObserver> getObservers() {
        if (observers == null) {
            observers = new ArrayList<>();
        }
        return observers;
    }

    private ProgramDAO getProgramDAO() {
        if (programDAO == null) {
            programDAO = new ProgramDAO_Hibernate();
        }
        return programDAO;
    }
}