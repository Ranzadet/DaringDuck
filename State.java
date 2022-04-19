package DaringDuck;
public class State{

    public String name;
    public Transition[] transitions;
    public boolean isTerminal;

    public State(String name, Transition[] transitions, boolean isTerminal){
        this.name = name;
        this.transitions = transitions;
        this.isTerminal = isTerminal;
    }

    
}