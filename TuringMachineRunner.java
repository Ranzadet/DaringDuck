package DaringDuck;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;
public class TuringMachineRunner{

    private static StateMachine machine;

    private static void build(ArrayList<State> states, byte[] initial, int size, int state, int pointTo){
        machine = new StateMachine(states, initial, size, state, pointTo);
    }

    public static void main(String[] args) {
        /* TODO: Make an automated, more optimal (less tedious) way of creating transitions. Set States, Transitions, 
        and list size to 100 for a score of 3,333 */

        //Begin by constructing the list of states. The first state added should always be halt
        ArrayList<State> states = new ArrayList<>();
        states.add(new State("halt", new Transition[] {}, true));
        // Transition zero = new Transition(1, '0', 0, '1', -1);
        // Transition right = new Transition(1, '1', 1, '1', 1);

        /*
        MACHINE 1: I FORGOT WHAT THIS WAS CALLED
        //2 has an ascii value of 50. Do not go lower than this for alphabet1
        char alphabet1 = (char)50;
        char alphabetLast = (char)54;
        Transition[] first = new Transition[alphabetLast-alphabet1+3];
        first[0] = zero;
        first[1] = right;
        int num = 3;
        first[2] = new Transition(1, alphabet1, 2, '1', -1);
        for(char c = (char)(alphabet1 + 1); c<alphabetLast; c++){
            first[num] = new Transition(1, c, 2, (char)(c-1), -1);
            num++;
        }
        first[alphabetLast-alphabet1+2] = new Transition(1, alphabetLast, 2, (char)(alphabetLast-1), -1);
        State one = new State("goRight", first, false);
        states.add(one);
        */
        



        /*
        MACHINE 2: TRUE BUSY BEAVER
        Note: With this machine, machine.currentState must start at 1
        WARNING: The followning algorithm is effectively infinite in length for any alphabet size greater than 5. 

        char alphabet1 = (char)50;
        char alphabetLast = (char)53;
        Transition[] first = new Transition[alphabetLast-alphabet1+3];
        first[0] = zero;
        first[1] = right;
        int num = 3;
        first[2] = new Transition(1, alphabet1, 2, '1', -1);
        for(char c = (char)(alphabet1 + 1); c<alphabetLast; c++){
            first[num] = new Transition(1, c, num, (char)(c-1), -1);
            num++;
        }
        first[alphabetLast-alphabet1+2] = new Transition(1, alphabetLast, num, (char)(alphabetLast-1), -1);
        State one = new State("goRight", first, false);
        states.add(one);

        State two = new State("alphFirst", new Transition[] {new Transition(2, '1', 2, '1', -1), new Transition(2, '0', 1,'1', 1)}, false);
        states.add(two);
        int statenum = 3;
        for (char ch = (char)(alphabet1 + 1); ch < alphabetLast; ch++){
            states.add(new State("reduciton", new Transition[] {new Transition(statenum, '1', statenum, (char)(ch-1), -1), new Transition(statenum, '0', 1, '1', 1)}, false));
            statenum++;
        }
        states.add(new State("alphLast", new Transition[] {new Transition(statenum, '1', statenum, (char)(alphabetLast-1), -1), new Transition(statenum, '0', 1, '1', 1)}, false));
        */

        
        //MACHINE 3: OPTIMIZED E PRINTER
        //NOTE: WITH THIS MACHINE, machine.currentState must start at 10
        //Define the number of f's, and "money printers" you'd like to have.
        //Alphabet size for this machine is 8 {0,1,a,b,c,d,e,f}
         /*
        int currState = 10;
        int alphabetSize = 8;
        int startSize = 3;
        int p = startSize;
        int i = startSize;
        List<Character> startingArray = Collections.nCopies(i, 'f');
        Transition[] first = new Transition[4];
        first[0] = zero;
        first[1] = right;
        first[2] = new Transition(1, 'f', 9, '1', -1);
        first[3] = new Transition(1, 'e', 11+p, 'd', -1);
        State one = new State("CarryOut", first, false);
        states.add(one);

        Transition[] cr2 = new Transition[8];
        cr2[0] = new Transition(2, '1', 2, '1', 1);
        cr2[1] = new Transition(2, 'a', 3, '1', -1);
        cr2[2] = new Transition(2, 'b', 4, 'a', -1);
        cr2[3] = new Transition(2, 'c', 5, 'b', -1);
        cr2[4] = new Transition(2, 'd', 6, 'c', -1);
        cr2[5] = new Transition(2, 'e', 7, '1', -1);
        cr2[6] = new Transition(2, '0', 0, '1', -1);
        //cr2[7] = new Transition(2, 'f', 9, '1', -1);  //Optimization 2
        cr2[7] = new Transition(2, 'f', 12+p, '1', -1);  //Optimization 3
        State carryout2 = new State("CarryOut2", cr2, false);
        states.add(carryout2);

        State a = new State("a", new Transition[] {new Transition(3, '0', 2, '1', 1), new Transition(3, '1', 3, '1', -1)}, false);
        State b = new State("b", new Transition[] {new Transition(4, '0', 2, '1', 1), new Transition(4, '1', 4, 'a', -1)}, false);
        State c = new State("c", new Transition[] {new Transition(5, '0', 2, '1', 1), new Transition(5, '1', 5, 'b', -1)}, false);
        State d = new State("d", new Transition[] {new Transition(6, '0', 2, '1', 1), new Transition(6, '1', 6, 'c', -1)}, false);
        states.add(a);
        states.add(b);
        states.add(c);
        states.add(d);

        State L2 = new State("L2", new Transition[] {new Transition(7, '1', 7, '1', -1), new Transition(7, '0', 8, 'e', -1)}, false);
        states.add(L2);

        State RES = new State("Reset", new Transition[] {new Transition(8, '0', 1, '0', 1)}, false);
        states.add(RES);

        //State f2 = new State("f2", new Transition[] {new Transition(9, '1', 9, '1', -1), new Transition(9, '0', 10, 'f', -1)}, false);  //Optimization 2
        State f2 = new State("f2", new Transition[] {new Transition(9, '1', 9, '1', -1), new Transition(9, '0', 10, '0', 1), new Transition(9, 'f', 9, 'f', -1)}, false);  //Optimization 3
        states.add(f2);
        

        State f1 = new State("f1", new Transition[] {new Transition(10, '0', 10, '0', 1), new Transition(10, 'f', 11, 'e', -1)}, false);
        states.add(f1);

        int E_PRINTERS = p-1;
        for(int inc = 11;inc<11+E_PRINTERS;inc++){
            int next = inc+1;
            int direction = -1;
            states.add(new State("EPrinter"+(inc-10), new Transition[] {new Transition(inc,'0',next,'e',direction)}, false));
        }

        State L1 = new State("L1", new Transition[] {new Transition(10+p, '0', 1, '0', 1)}, false);
        states.add(L1);

        State RES2 = new State("RES2", new Transition[] {new Transition(11+p, '0', 2, '1', 1)}, false);
        states.add(RES2);

        //  OPTIMIZATION 3
        State L3 = new State("L3", new Transition[] {new Transition(12+p, '1', 12+p, '1', -1), new Transition(12+p, 'f', 12+p, 'f', -1), new Transition(12+p, '0', 13+p, 'f', 1)}, false);
        states.add(L3);

        State CR3 = new State("CarryOut3", new Transition[] {new Transition(13+p, '1', 13+p, '1', 1), new Transition(13+p, 'f', 13+p, 'f', 1), new Transition(13+p, '0', 14+p, '0', -1)}, false);
        states.add(CR3);

        State T1 = new State("Transition1", new Transition[] {new Transition(14+p, 'f', 12+p, '0', -1), new Transition(14+p, '1', 9, '1', -1)}, false);
        states.add(T1);                                                                                        //1
        // */


        //MACHINE 3: Optimization 4 (increased printer effeciency)
        //With this machine, starting state is 1
        // 0:0 1:1 a:2 b:3 c:4 d:5 e:6 f:7 g:8 h:9
        // /*
        
        int currState = 1;
        int alphabetSize = 10;
        int ePrinters = 4; 
        //int fPrinters =  4;
        //int gPrinters =  3;
        //int numH = 1;  
        int fValue = ePrinters * 8;
        int numEs = 25344; //H * gprinters * 8 * f printers * h * e printers * 8

        int startSize = 2000000000;
        byte[] startingArray = new byte[startSize];
 
        Transition[] tH = new Transition[10];
        Transition[] tG = new Transition[10];
        Transition[] tF = new Transition[10];
       
        tH[0] = new Transition(1, (byte)0, 2, (byte)9, -1);
        tH[1] = new Transition(1, (byte)9, 2, (byte)7, -1);
        tH[2] = new Transition(1, (byte)7, 2, (byte)6, -1);
        tH[3] = new Transition(1, (byte)6, 2, (byte)5, -1);
        tH[4] = new Transition(1, (byte)5, 2, (byte)4, -1);
        tH[5] = new Transition(1, (byte)4, 2, (byte)3, -1);
        tH[6] = new Transition(1, (byte)3, 2, (byte)2, -1);
        tH[7] = new Transition(1, (byte)2, 2, (byte)1, -1);
        tH[8] = new Transition(1, (byte)1, 5, (byte)0, -1);
        tH[9] = new Transition(1, (byte)8, 1, (byte)8, 1);
 
        State H = new State("H", tH, false);
        states.add(H);
        State pH1 = new State("pH1", new Transition[] {new Transition(2, (byte)8, 2, (byte)8, -1), new Transition(2, (byte)0, 3, (byte)8, -1)}, false);
        State pH2 = new State("pH2", new Transition[] {new Transition(3, (byte)0, 4, (byte)8, -1)}, false);
        State pH3 = new State("pH3", new Transition[] {new Transition(4, (byte)0, 1, (byte)8, 1)}, false);
        states.add(pH1);
        states.add(pH2);
        states.add(pH3);
 
        tG[0] = new Transition(5, (byte)8, 6, (byte)9, -1);
        tG[1] = new Transition(5, (byte)9, 6, (byte)6, -1);
        tG[2] = new Transition(5, (byte)6, 6, (byte)5, -1);
        tG[3] = new Transition(5, (byte)5, 6, (byte)4, -1);
        tG[4] = new Transition(5, (byte)4, 6, (byte)3, -1);
        tG[5] = new Transition(5, (byte)3, 6, (byte)2, -1);
        tG[6] = new Transition(5, (byte)2, 6, (byte)1, -1);
        tG[7] = new Transition(5, (byte)1, 6, (byte)7, -1);
        tG[8] = new Transition(5, (byte)7, 5, (byte)7, 1);
        tG[9] = new Transition(5, (byte)0, 10, (byte)0, -1);
 
        State G = new State("G", tG, false);
        states.add(G);
        State pG1 = new State("pG1", new Transition[] {new Transition(6, (byte)0, 7, (byte)7, -1), new Transition(6, (byte)8, 6, (byte)8, -1), new Transition(6, (byte)7, 6, (byte)7, -1)}, false);
        State pG2 = new State("pG2", new Transition[] {new Transition(7, (byte)0, 8, (byte)7, -1)}, false);
        State pG3 = new State("pG3", new Transition[] {new Transition(8, (byte)0, 9, (byte)7, -1)}, false);
        State pG4 = new State("pG4", new Transition[] {new Transition(9, (byte)0, 5, (byte)7, 1)}, false);
        states.add(pG1);
        states.add(pG2);
        states.add(pG3);
        states.add(pG4);
 
        State GF = new State("GF", new Transition[] {new Transition(10, (byte)7, 10, (byte)7, -1), new Transition(10, (byte)0, 11, (byte)0, 1)}, false);
        states.add(GF);
 
        tF[0] = new Transition(11, (byte)7, 12, (byte)9, -1);
        tF[1] = new Transition(11, (byte)9, 12, (byte)8, -1);
        tF[2] = new Transition(11, (byte)8, 12, (byte)5, -1);
        tF[3] = new Transition(11, (byte)5, 12, (byte)4, -1);
        tF[4] = new Transition(11, (byte)4, 12, (byte)3, -1);
        tF[5] = new Transition(11, (byte)3, 12, (byte)2, -1);
        tF[6] = new Transition(11, (byte)2, 12, (byte)1, -1);
        tF[7] = new Transition(11, (byte)1, 12, (byte)0, -1);
        tF[8] = new Transition(11, (byte)0, 16, (byte)6, -1);
        tF[9] = new Transition(11, (byte)6, 11, (byte)6, 1);
 
        State F = new State("F", tF, false);
        states.add(F);
        State pF1 = new State("pF1", new Transition[] {new Transition(12, (byte)0, 13, (byte)6, -1), new Transition(12, (byte)7, 12, (byte)7, -1), new Transition(12, (byte)6, 12, (byte)6, -1)}, false);
        State pF2 = new State("pF2", new Transition[] {new Transition(13, (byte)0, 14, (byte)6, -1)}, false);
        State pF3 = new State("pF3", new Transition[] {new Transition(14, (byte)0, 15, (byte)6, -1)}, false);
        State pF4 = new State("pF4", new Transition[] {new Transition(15, (byte)0, 11, (byte)6, 1)}, false);
        states.add(pF1);
        states.add(pF2);
        states.add(pF3);
        states.add(pF4);
 
        State eL = new State("eL", new Transition[] {new Transition(16, (byte)6, 16, (byte)6, -1), new Transition(16, (byte)0, 17, (byte)0, 1)}, false);
        states.add(eL);
 
        State ed = new State("ed", new Transition[] {new Transition(17, (byte)6, 18, (byte)5, -1)}, false);
        states.add(ed);
 
        State RES = new State("RES", new Transition[] {new Transition(18, (byte)0, 19, (byte)1, 1)}, false);
        states.add(RES);
 
 
 
        //NOT YET WRITTEN
        Transition[] cr = new Transition[8];
        cr[0] = new Transition(19, (byte)1, 19, (byte)1, 1);
        cr[1] = new Transition(19, (byte)2, 20, (byte)1, -1);
        cr[2] = new Transition(19, (byte)3, 21, (byte)2, -1);
        cr[3] = new Transition(19, (byte)4, 22, (byte)3, -1);
        cr[4] = new Transition(19, (byte)5, 23, (byte)4, -1);
        cr[5] = new Transition(19, (byte)6, 24, (byte)1, -1); //L1
        cr[6] = new Transition(19, (byte)0, 0, (byte)1, -1);
        cr[7] = new Transition(19, (byte)7, 26, (byte)1, -1);  //f triangle left shift
        State carryout = new State("CarryOut", cr, false);
        states.add(carryout);
 
        State a = new State("a", new Transition[] {new Transition(20, (byte)0, 19, (byte)1, 1), new Transition(20, (byte)1, 20, (byte)1, -1)}, false);
        State b = new State("b", new Transition[] {new Transition(21, (byte)0, 19, (byte)1, 1), new Transition(21, (byte)1, 21, (byte)2, -1)}, false);
        State c = new State("c", new Transition[] {new Transition(22, (byte)0, 19, (byte)1, 1), new Transition(22, (byte)1, 22, (byte)3, -1)}, false);
        State d = new State("d", new Transition[] {new Transition(23, (byte)0, 19, (byte)1, 1), new Transition(23, (byte)1, 23, (byte)4, -1)}, false);
        states.add(a);
        states.add(b);
        states.add(c);
        states.add(d);
 
        State L1 = new State("L1", new Transition[] {new Transition(24, (byte)1, 24, (byte)1, -1), new Transition(24, (byte)0, 25, (byte)6, -1)}, false);
        states.add(L1);
 
        State RES2 = new State("RES2", new Transition[] {new Transition(25, (byte)0, 17, (byte)0, 1)}, false);
        states.add(RES2);
 
        State L2 = new State("L2", new Transition[] {new Transition(26, (byte)1, 26, (byte)1, -1), new Transition(26, (byte)0, 27, (byte)7, 1), new Transition(26, (byte)7, 26, (byte)7, -1)}, false);
        states.add(L2);
 
        State CR2 = new State("CR2", new Transition[] {new Transition(27, (byte)1, 27, (byte)1, 1), new Transition(27, (byte)7, 27, (byte)7, 1), new Transition(27, (byte)0, 28, (byte)0, -1)}, false);
        states.add(CR2);
 
        State T1 = new State("T1", new Transition[] {new Transition(28, (byte)7, 26, (byte)0, -1), new Transition(28, (byte)1, 29, (byte)1, -1)}, false);
        states.add(T1);
 
        State T2 = new State("T2", new Transition[] {new Transition(29, (byte)7, 29, (byte)7, -1), new Transition(29, (byte)1, 29, (byte)1, -1), new Transition(29, (byte)0, 11, (byte)0, 1)}, false);
        states.add(T2);


        //*/




        ///MACHINE 4, OPTIMIZATION 0
        /*
        //With this machine, machine.currentstate must start at 1

        int magnitude = 2;

        State start = new State("start", new Transition[] {new Transition(1, 'e', 2, 'd', -1)}, false);
        states.add(start);

        State res1 = new State("res1", new Transition[] {new Transition(2, '0', 3, '1', 1)}, false);
        states.add(res1);


        Transition[] first = new Transition[7];
        first[0] = zero;
        first[1] = new Transition(3, '1', 3, '1', 1);
        first[2] = new Transition(3, 'd', 7, 'c', -1);
        first[3] = new Transition(3, 'c', 6, 'b', -1);
        first[4] = new Transition(3, 'b', 5, 'a', -1);
        first[5] = new Transition(3, 'a', 4, '1', -1);
        first[6] = new Transition(3, 'e', 8, 'a', -1);



        State mainloop = new State("mainloop", first, false);
        states.add(mainloop);




        State a = new State("a", new Transition[] {new Transition(4, '0', 3, '1', 1), new Transition(4, '1', 4, '1', -1)}, false);
        State b = new State("b", new Transition[] {new Transition(5, '0', 3, '1', 1), new Transition(5, '1', 5, 'a', -1)}, false);
        State c = new State("c", new Transition[] {new Transition(6, '0', 3, '1', 1), new Transition(6, '1', 6, 'b', -1)}, false);
        State d = new State("d", new Transition[] {new Transition(7, '0', 3, '1', 1), new Transition(7, '1', 7, 'c', -1)}, false);
        states.add(a);
        states.add(b);
        states.add(c);
        states.add(d);


        State transformer = new State("transformer", new Transition[] {new Transition(8, '1', 8, 'a', -1), new Transition(8, '0', 9, '1', 1)}, false);
        states.add(transformer);

        State expand1 = new State("expand1", new Transition[] {new Transition(9, '1', 9, '1', 1), new Transition(9, 'a', 10, '1', -1), new Transition(9, '0', 0, '1', -1), new Transition(9, 'e', 8, 'a', -1)}, false);
        states.add(expand1);

        State expand2 = new State("expand2", new Transition[] {new Transition(10, '1', 10, '1', -1), new Transition(10, '0', 9, '1', 1)}, false);
        states.add(expand2);
        //*/




        /*
        PART OF MACHINE 1
        int NUM_PRINTERS = 1;
        for(int inc = 2;inc<2+NUM_PRINTERS;inc++){
            int next = inc+1;
            int direction = -1;
            if(inc == NUM_PRINTERS+1){
                next = 1;
                direction = 1;
            }
            if(inc == 2){
                states.add(new State("onePrinter"+inc, new Transition[] {new Transition(inc, '1', inc, '1', direction), new Transition(inc,'0',next,'1',direction)}, false));
            }
            else{
                states.add(new State("onePrinter"+inc, new Transition[] {new Transition(inc,'0',next,'1',direction)}, false));
            }
        }
        */


        //Next, set the initial configuration of the characters on the tape. This should be startSize many alphabetLast
        byte[] initial =  startingArray;   //FOR MACHINE 4: Collections.nCopies(magnitude, 'e'); 
        //byte[] initial = startingArray;
        //   

        //Finally, specify the size you'd like the tape to start at
        int size = 2000000000;

        //Only one call should ever be made to build, which will instantiate your turing machine
        build(states, initial, size, currState, -1);
        //System.out.println(machine.states.size());

        long starttime = System.currentTimeMillis();
        long lastTime = starttime;
        long count = 0;
        long nextMark = 500000000l;
        long numstates = 0;
        
        while (machine.currentState != 0){
            
            // int st = machine.currentState;
            // char chr = machine.tape.readTape();
            // if(machine.currentState == 13){
            //     System.out.println("On 14 with "+machine.tape.eCount()+" e's.");
            // }
            //System.out.print("Current: " + machine.currentState);
            //System.out.print("  | with input "+machine.tape.readTape()+" | ");
             if (count > nextMark){
                if (System.currentTimeMillis() - lastTime > 600000){
                    double timeRunning = ((System.currentTimeMillis() - starttime)/1000.0);
                    System.out.println("\nTotal time elapsed: "+ (int)(timeRunning/60.00) + ":" + (int)(timeRunning%60) + ".");
                    System.out.println("1's Printed: "+machine.tape.numOnes());
                    int e = machine.tape.eCount(fValue);
                    System.out.println("E's remaining: "+e + " / " + numEs + "; Seconds per e: " + timeRunning/(numEs - e));
                    lastTime = System.currentTimeMillis();  
                }
                nextMark += 5000000000l;
             }
            count++;
            //String s = "Current State: "+ machine.currentState + " on input " + machine.tape.readTape() + " yields state ";
            // if(lastTime > start){
            //     s = "Current State: "+ machine.currentState + " on input " + machine.tape.readTape() + " yields state ";
            // }
            

            //System.out.print("Current State: "+ machine.currentState + " on input " + machine.tape.readTape() + " yields state ");

            //THIS RUNS THE LOOP. IT IS NOT PART OF THE SURROUNDING TESTS. DO NOT COMMENT OUT.
            machine.nextState(machine.tape.readTape()); 

            // if (machine.currentState == 0){
            //     System.out.println(s+machine.currentState);
            // }
            //System.out.println(machine.currentState);
            //System.out.println("1's Printed: "+machine.tape.numOnes());
            // if(numstates > 153650){
            //     System.out.println("Current State: "+ machine.currentState + " on input " + machine.tape.readTape() + " yields state ");
            // }
            numstates++;
            // if(machine.currentState == 0){
            //     System.out.println("state "+st+" on input "+chr);
            // }
        }

        int ones = machine.tape.numOnes();
        double time = (System.currentTimeMillis() - starttime)/1000.0;
        int score = machine.calculateScore(alphabetSize, startSize);

        System.out.println("Number of 1's printed: " + ones);
        System.out.println("Score: "+score);
        System.out.println("Finished in: "+ (int)((((System.currentTimeMillis() - starttime)/1000.0)/60.00)/60.00)+"h : "+(int)((((System.currentTimeMillis() - starttime)/1000.0)/60.00)%60) + "m : " + (int)(((System.currentTimeMillis() - starttime)/1000.0)%60) + "s.");
        System.out.println("Score per second: "+(score/time));
        System.out.println("Average seconds per E: "+(time / (numEs)));
        System.out.println("Number of states: "+numstates+";  States per second: "+(int)(numstates/time));
        
        //System.out.println(machine.states.get(1).transitions[25]);
        //System.out.println(machine.tape.readTape());
    }
}  
      // Transition a = new Transition(1, 'a', 2, '1', -1);
        // Transition b = new Transition(1, 'b', 2, 'a', -1);
        // Transition c = new Transition(1, 'c', 2, 'b', -1);
        // Transition d = new Transition(1, 'd', 2, 'c', -1);
        // Transition e = new Transition(1, 'e', 2, 'd', -1);
        // Transition f = new Transition(1, 'f', 2, 'e', -1);
        // Transition g = new Transition(1, 'g', 2, 'f', -1);
        // Transition h = new Transition(1, 'h', 2, 'g', -1);
        // Transition i = new Transition(1, 'i', 2, 'h', -1);
        // Transition j = new Transition(1, 'j', 2, 'i', -1);
        // Transition k = new Transition(1, 'k', 2, 'j', -1);
        // Transition l = new Transition(1, 'l', 2, 'k', -1);
        // Transition m = new Transition(1, 'm', 2, 'l', -1);
        // Transition n = new Transition(1, 'n', 2, 'm', -1);
        // Transition o = new Transition(1, 'o', 2, 'n', -1);
        // Transition p = new Transition(1, 'p', 2, 'o', -1);
        // Transition q = new Transition(1, 'q', 2, 'p', -1);
        // Transition r = new Transition(1, 'r', 2, 'q', -1);
        // Transition s = new Transition(1, 's', 2, 'r', -1);
        // Transition t = new Transition(1, 't', 2, 's', -1);
        // Transition u = new Transition(1, 'u', 2, 't', -1);
        // Transition v = new Transition(1, 'v', 2, 'u', -1);
        // Transition w = new Transition(1, 'w', 2, 'v', -1);
        // Transition x = new Transition(1, 'x', 2, 'w', -1);
        // Transition y = new Transition(1, 'y', 2, 'x', -1);
        // Transition z = new Transition(1, (char)122, 2, 'y', -1);
        //Transition[] first = {zero,right,a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z};