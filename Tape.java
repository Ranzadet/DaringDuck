package DaringDuck;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
public class Tape{

    private static ArrayList<Character> tape;
    public int oneCount;
    public int pointer;

    public Tape(char[] initial){
        tape.ensureCapacity(100);
        tape = new ArrayList<>(Collections.nCopies(100, '0'));
    }

    //This method should be called when the pointer attempts to move off either side of the tape
    public int Expand(){
        tape.ensureCapacity(tape.size()*3 + 1);
        ArrayList<Character> left = new ArrayList<Character>(Collections.nCopies(tape.size(), '0'));
        left.addAll(tape);
        int index = left.size() - 1;
        left.addAll(Collections.nCopies(tape.size(), '0'));
        tape = left;
        return index;
    }

    //to be called for increased effeciency, when the side of expansion is given
    public int Expand(boolean norm){
        int index = tape.size();
        tape.ensureCapacity(tape.size()*2 + 1);
        if(norm){
            tape.addAll(Collections.nCopies(tape.size(), '0'));
        }
        else{
            ArrayList<Character> left = new ArrayList<Character>(Collections.nCopies(tape.size(), '0'));
            left.addAll(tape);
            tape = left;
        }
        return index;
    }

    public Character readTape(int index){
        return tape.get(index);
    }

    public void writeTape(Character c, int index){
        tape.set(index, c);
    }


}