package DaringDuck;
import java.util.ArrayList;
public class StateMachine{

    public ArrayList<State> states = new ArrayList<>();
    public int currentState = 10;
    public Tape tape;

        public StateMachine(ArrayList<State> states, byte[] initial, int size, int currentState, int pointTo){
            this.states = states;
            this.currentState = currentState;
            tape = new Tape(initial,size, pointTo);
        }

        public void nextState(byte input){
            State curr = states.get(currentState);
            for(Transition t : curr.transitions){
                if (t.input == input){
                    if(t.result == 0){
                        System.out.println("\n---Halting on Current state "+currentState+"---\n");
                    }
                    currentState = t.result;
                    tape.writeTape(t.write, t.direction);
                    return;
                }
            }
            //if no transition is found, go to garbage state
            currentState = 0;
        }

        public int calculateScore(int a, int i){
            return tape.numOnes() / (states.size() + a + i);
        }

}