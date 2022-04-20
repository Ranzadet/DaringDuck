package DaringDuck;
import java.util.ArrayList;
public class StateMachine{

    public ArrayList<State> states = new ArrayList<>();
    public int currentState = 1;
    public Tape tape;

        public StateMachine(ArrayList<State> states, ArrayList<Character> initial, int size){
            this.states = states;
            tape = new Tape(initial,size);
        }

        public void nextState(Character input){
            State curr = states.get(currentState);
            for(Transition t : curr.transitions){
                if (t.input == input){
                    currentState = t.result;
                    tape.writeTape(t.write, t.direction);
                    return;
                }
            }
            //if no transition is found, go to garbage state
            currentState = 0;
        }

}