package DaringDuck;
public class Transition{
    
    public State from;
    public State result;
    public Character input;
    public int direction; //Although an int, direction will be either -1 (left) or 1 (right), to indicate movement along the tape 
    public Character write;

    public Transition(State from, Character input, State result, Character write, int direction){
        this.from = from;
        this.input = input;
        this.result = result;
        this.write = write;
        this.direction = direction;
    }

}