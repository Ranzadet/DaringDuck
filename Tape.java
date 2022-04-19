package DaringDuck;
import java.util.ArrayList;
public class Tape{

    public static ArrayList<Character> tape = new ArrayList<>();
    public long oneCount;

    public Tape(char[] initial){
        tape.ensureCapacity(100);
    }

    //This method should be called 
    public void quickExpand(){
        tape.ensureCapacity(tape.size()*tape.size());
    }
}