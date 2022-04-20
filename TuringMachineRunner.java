package DaringDuck;
import java.util.Arrays;
import java.util.ArrayList;
public class TuringMachineRunner{

    private static StateMachine machine;

    private static void build(ArrayList<State> states, Character[] initial, int size){
        ArrayList<Character> initArr = new ArrayList<>(Arrays.asList(initial));
        machine = new StateMachine(states, initArr, size);
    }

    public static void main(String[] args) {
        //Begin by constructing the list of states. The first state added should always be halt
        ArrayList<State> states = new ArrayList<>();
        states.add(new State("halt", new Transition[] {}, true));


        //Next, set the initial configuration of the characters on the tape
        Character[] initial = {'1','0','0','0','1','0','1'};

        //Finally, specify the size you'd like the tape to start at, and call build()
        int size = 100;

        build(states, initial, size);


        System.out.println("Hello world!");
    }
}