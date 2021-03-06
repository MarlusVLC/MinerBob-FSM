package States.BobStates;

import Communication.Message;
import Entidades.Bob;
import Entidades.Location;
import States.State;

import java.util.Random;

public class EnterMineAndDigForNugget implements State<Bob> {

    //SINGLETON IMPLEMENTATION start
    private static EnterMineAndDigForNugget INSTANCE = null;

    private EnterMineAndDigForNugget(){}

    public static EnterMineAndDigForNugget getInstance(){
        if(INSTANCE == null){
            INSTANCE = new EnterMineAndDigForNugget();
        }
        return INSTANCE;
    }
    //SINGLETON IMPLEMENTATION end






    @Override
    public void enter(Bob bob) {
        if (bob.getLocation() != Location.MINE){
            bob.setLocation(Location.MINE);
        }
    }

    @Override
    public void execute(Bob bob) {
        System.out.println("Working... Alot... Mining...");

        //faz um rand para verificiar se ele conseguiu ou não achar uma pepita de ouro
        Random r = new Random();
        int rand = r.nextInt(2);
        if (rand==1) {
            bob.addGoldNugget();
            System.out.println("Lucky! A Gold Nugget!");
        } else {
            System.out.println("These Gold Nuggets are hard to find!");
        }

        //Indiferente de achar uma pepita de ouro, ele ganha fadiga
        bob.increaseFatigue(2);

        //e sede
        bob.increaseThirsty(1);

        //Verifica se atingiu alguma das condições p/ troca de estado:
        if(bob.pocketsFull()){
            bob.getStateMachine().changeState(VisitBankAndDepositGold.getInstance());
        }

        if(bob.isThirsty()){
            bob.getStateMachine().changeState(QuenchyThirst.getInstance());
        }
    }

    @Override
    public void exit(Bob bob) {

    }

    @Override
    public boolean onMessage(Bob bob, Message msg) {
        return false;
    }
}
