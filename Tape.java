package DaringDuck;
import java.util.ArrayList;
import java.util.Collections;
public class Tape{

    private static ArrayList<Character> tape;
    public int pointer;

    public Tape(ArrayList<Character> initial, int size){
        tape = new ArrayList<>(Collections.nCopies(size, '0'));
        tape.ensureCapacity(size + initial.size() + 1);
        tape.addAll(size/2, initial);
        pointer = size / 2;
        //System.out.println(tape.get(pointer));
    }

    //OLD
    /*
    public int Expand(){
        tape.ensureCapacity(tape.size()*3 + 1);
        ArrayList<Character> left = new ArrayList<Character>(Collections.nCopies(tape.size(), '0'));
        left.addAll(tape);
        int index = left.size() - 1;
        left.addAll(Collections.nCopies(tape.size(), '0'));
        tape = left;
        return index;
    }
    */

    //Expands the tape to the left if norm is false, and to the right if true
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
            index -= 1;
        }
        pointer = index;
        System.out.println("Expanding in "+((norm) ? "right direction, " : "left direction, ")+"current ones: "+numOnes());
        System.out.println("Pointer: "+pointer+"; Index of 1: "+tape.indexOf('1'));
        return index;
    }

    public Character readTape(){
        return tape.get(pointer);
    }

    public void writeTape(Character c, int direction){
        tape.set(pointer, c);
        pointer += direction;
        if (pointer < 0){
            Expand(false);
        }
        else if (pointer >= tape.size()){
            Expand(true);
        }
    }

    public int numOnes(){
        return Collections.frequency(tape, '1');
    }

    public String toString(){
        return tape.toString();
    }

    public int eCount(int p){
        int f = Collections.frequency(tape, 'f');
        int e = Collections.frequency(tape, 'e');
        return e + f*p;
    }


}