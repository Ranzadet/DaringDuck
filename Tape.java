package DaringDuck;
// import java.util.ArrayList;
// import java.util.Collections;
public class Tape{

    //private static ArrayList<Character> tape;
    private static byte[] tape;
    public int pointer;
    //                 byte[] initial
    public Tape(byte[] initial, int size, int pointTo){
        //tape = new ArrayList<>(Collections.nCopies(size, '0')); //if size greater rhan 100 mil, split into multiple lists
        tape = initial;
        pointer = (pointTo != -1) ? pointTo : initial.length/2 + initial.length/3 + initial.length/8;
        System.out.println(pointer);
        // tape.ensureCapacity(size + initial.size() + 1);
        // tape.addAll(size/2, initial);
        // if (pointTo != -1){
        //     pointer = pointTo;
        // }
        // else{
        //     pointer = tape.size()/2 + tape.size()/4;
        // }
        //System.out.println(tape.get(pointer));
    }

    ///*
    public int size(){
        return tape.length;
    }
    //*/

    //NEW
    ///*
    public int Expand(boolean norm){
        int index = tape.length;
        if(!norm){
            byte[] newTape = new byte[tape.length*2];
            for(int i = tape.length; i<newTape.length; i++){
                newTape[i] = tape[i-tape.length];
            }
            tape = newTape;
            index -= 1;
        }
        else{
            byte[] newTape = new byte[tape.length*2];
            for(int i = 0;i<tape.length;i++){
                newTape[i] = tape[i];
            }
            tape = newTape;
        }
        pointer = index;
        System.out.println("Expanding in "+((norm) ? "right direction, " : "left direction, ")+"current ones: "+numOnes());
        return index;
    }
    //*/

    //Expands the tape to the left if norm is false, and to the right if true
    // public int Expand(boolean norm){
    //     int index = tape.size();
    //     tape.ensureCapacity(tape.size()*2 + 1);
    //     if(norm){
    //         tape.addAll(Collections.nCopies(tape.size(), '0'));
    //     }
    //     else{
    //         ArrayList<Character> left = new ArrayList<Character>(Collections.nCopies(tape.size(), '0'));
    //         left.addAll(tape);
    //         tape = left;
    //         index -= 1;
    //     }
    //     pointer = index;
    //     System.out.println("Expanding in "+((norm) ? "right direction, " : "left direction, ")+"current ones: "+numOnes());
    //     System.out.println("Pointer: "+pointer+"; Index of 1: "+tape.indexOf('1'));
    //     return index;
    // }

    // public Character readTape(){
    //     return tape.get(pointer);
    // }

    // /*
    public byte readTape(){
        return tape[pointer];
    }
    // */

    // public void writeTape(Character c, int direction){
    //     tape.set(pointer, c);
    //     pointer += direction;
    //     if (pointer < 0){
    //         Expand(false);
    //     }
    //     else if (pointer >= tape.size()){
    //         Expand(true);
    //     }
    // }


    // /*
    public void writeTape(byte b, int direction){
        tape[pointer] = b;
        pointer += direction;
        if(pointer < 0){
            Expand(false);
        }
        else if (pointer >= tape.length){
            Expand(true);
        }
    }
    // */


    public int numOnes(){
        //return Collections.frequency(tape, '1');
        return Count((byte)1);
    }

    public String toString(){
        return tape.toString();
    }

    public int Count(byte p){
        int count = 0;
        for(int i = 0; i<tape.length;i++){
            if(tape[i] == p){
                count++;
            }
        }
        return count;
    }

    public int eCount(int fVal){
        return Count((byte)6) + fVal* Count((byte)7);
    }


}