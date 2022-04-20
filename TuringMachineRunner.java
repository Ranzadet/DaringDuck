package DaringDuck;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class TuringMachineRunner{

    private static StateMachine machine;

    private static void build(ArrayList<State> states, List<Character> initial, int size){
        ArrayList<Character> initArr = new ArrayList<>(initial);
        machine = new StateMachine(states, initArr, size);
    }

    public static void main(String[] args) {
        //Begin by constructing the list of states. The first state added should always be halt
        ArrayList<State> states = new ArrayList<>();
        states.add(new State("halt", new Transition[] {}, true));
        Transition zero = new Transition(1, '0', 0, '1', -1);
        Transition right = new Transition(1, '1', 1, '1', 1);
        Transition a = new Transition(1, 'a', 2, '1', -1);

        Transition[] first = {zero,right,a};
        State one = new State("goRight", first, false);
        states.add(one);
        for(int i = 2;i<22;i++){
            int next = i+1;
            if(i == 21){
                next = 1;
            }
            states.add(new State("onePrinter"+i, new Transition[] {new Transition(i,'0',next,'1',-1)}, false));
        }


        //Next, set the initial configuration of the characters on the tape
        List<Character> initial = Collections.nCopies(1000, '0');

        //Finally, specify the size you'd like the tape to start at
        int size = 10000;

        //Only one call should ever be made to build, which will instantiate your turing machine
        build(states, initial, size);

        while (machine.currentState != 0){
            machine.nextState(machine.tape.readTape());
        }
        int ones = machine.tape.numOnes();

        System.out.println("Number of 1's printed: " + ones);
    }
}