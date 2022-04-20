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
        /* TODO: Make an automated, more optimal (less tedious) way of creating transitions. Set States, Transitions, 
        and list size to 100 for a score of 3,333 */

        //Begin by constructing the list of states. The first state added should always be halt
        ArrayList<State> states = new ArrayList<>();
        states.add(new State("halt", new Transition[] {}, true));
        Transition zero = new Transition(1, '0', 0, '1', -1);
        Transition right = new Transition(1, '1', 1, '1', 1);
        Transition a = new Transition(1, 'a', 2, '1', -1);
        Transition b = new Transition(1, 'b', 2, 'a', -1);
        Transition c = new Transition(1, 'c', 2, 'b', -1);
        Transition d = new Transition(1, 'd', 2, 'c', -1);
        Transition e = new Transition(1, 'e', 2, 'd', -1);
        Transition f = new Transition(1, 'f', 2, 'e', -1);
        Transition g = new Transition(1, 'g', 2, 'f', -1);
        Transition h = new Transition(1, 'h', 2, 'g', -1);
        Transition i = new Transition(1, 'i', 2, 'h', -1);
        Transition j = new Transition(1, 'j', 2, 'i', -1);
        Transition k = new Transition(1, 'k', 2, 'j', -1);
        Transition l = new Transition(1, 'l', 2, 'k', -1);
        Transition m = new Transition(1, 'm', 2, 'l', -1);
        Transition n = new Transition(1, 'n', 2, 'm', -1);
        Transition o = new Transition(1, 'o', 2, 'n', -1);
        Transition p = new Transition(1, 'p', 2, 'o', -1);
        Transition q = new Transition(1, 'q', 2, 'p', -1);
        Transition r = new Transition(1, 'r', 2, 'q', -1);
        Transition s = new Transition(1, 's', 2, 'r', -1);
        Transition t = new Transition(1, 't', 2, 's', -1);
        Transition u = new Transition(1, 'u', 2, 't', -1);
        Transition v = new Transition(1, 'v', 2, 'u', -1);
        Transition w = new Transition(1, 'w', 2, 'v', -1);
        Transition x = new Transition(1, 'x', 2, 'w', -1);
        Transition y = new Transition(1, 'y', 2, 'x', -1);
        Transition z = new Transition(1, 'z', 2, 'y', -1);


        Transition[] first = {zero,right,a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z};
        State one = new State("goRight", first, false);
        states.add(one);

        int NUM_PRINTERS = 23;
        for(int inc = 2;inc<2+NUM_PRINTERS;inc++){
            int next = inc+1;
            int direction = -1;
            if(inc == NUM_PRINTERS+1){
                next = 1;
                direction = 1;
            }
            if(inc == 2){
                states.add(new State("onePrinter"+i, new Transition[] {new Transition(inc, '1', inc, '1', direction), new Transition(inc,'0',next,'1',direction)}, false));
            }
            else{
                states.add(new State("onePrinter"+i, new Transition[] {new Transition(inc,'0',next,'1',direction)}, false));
            }
        }


        //Next, set the initial configuration of the characters on the tape
        List<Character> initial = Collections.nCopies(500, 'z');

        //Finally, specify the size you'd like the tape to start at
        int size = 5000;

        //Only one call should ever be made to build, which will instantiate your turing machine
        build(states, initial, size);

        long start = System.currentTimeMillis();
        int count = 0;
        while (machine.currentState != 0){
            //System.out.print("Current: " + machine.currentState);
            //System.out.print("  | with input "+machine.tape.readTape()+" | ");
            if (count % 500000 == 0){
                System.out.println("Seconds Elapsed at "+machine.tape.numOnes()+" 1's: "+(System.currentTimeMillis() - start)/1000);
            }
            machine.nextState(machine.tape.readTape());
            //System.out.println(" -> "+machine.currentState);
            count++;
        }
        int ones = machine.tape.numOnes();

        System.out.println("Number of 1's printed: " + ones);
        
        //System.out.println(machine.tape);
        //System.out.println(machine.states.get(2).transitions[0].result);
    }
}