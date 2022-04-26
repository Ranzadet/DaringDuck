package DaringDuck;
public class Transition{
    
    public int from;
    public int result;
    public byte input;
    public int direction; //Although an int, direction will be either -1 (left) or 1 (right), to indicate movement along the tape 
    public byte write;

    public Transition(int from, byte input, int result, byte write, int direction){
        this.from = from;
        this.input = input;
        this.result = result;
        this.write = write;
        this.direction = direction;
    }

    public String toString(){
        return String.format("(%s, %s, %s, %s, %s)", from, input, result, write, direction);
    }

}