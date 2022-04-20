package DaringDuck;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
public class Tape{

    private static ArrayList<Character> tape;
    public long oneCount;

    public Tape(char[] initial){
        tape.ensureCapacity(100);
        tape = new ArrayList<>(Collections.nCopies(100, '0'));
    }

    //This method should be called when the pointer attempts to move off the left side of the tape
    public void Expand(){
        tape.ensureCapacity(tape.size()*tape.size());
    }

    public Character readTape(int index){
        return tape.get(index);
    }

    public void writeTape(Character c, int index){
        tape.set(index, c);
    }


}