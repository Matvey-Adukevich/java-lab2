package org.example.cpu;

import jakarta.persistence.*;

@Entity
@Table(name = "commands")
public class Command {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    String name;

    @Column(name = "arg1")
    String arg1;

    @Column(name = "arg2")
    String arg2;

    @Column(name = "order_index")
    private int orderIndex;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "program_id")
    private Program program;

    public Command() {}

    public Command(String command){
        String[] g = command.split(" ");
        if(g.length == 3){
            this.name = g[0];
            this.arg1 = g[1];
            this.arg2 = g[2];
        }
        if(g.length == 1){
            this.name = g[0];
            this.arg1 = null;
            this.arg2 = null;
        }
    }

    public Command(String name, String arg1, String arg2) {
        this.name = name;
        this.arg1 = arg1;
        this.arg2 = arg2;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getArg1() { return arg1; }
    public void setArg1(String arg1) { this.arg1 = arg1; }

    public String getArg2() { return arg2; }
    public void setArg2(String arg2) { this.arg2 = arg2; }

    public int getOrderIndex() { return orderIndex; }
    public void setOrderIndex(int orderIndex) { this.orderIndex = orderIndex; }

    public Program getProgram() { return program; }
    public void setProgram(Program program) { this.program = program; }
}