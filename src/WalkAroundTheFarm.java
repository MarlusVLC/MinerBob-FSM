public class WalkAroundTheFarm implements State <Billy> {

    //SINGLETON start
    private static WalkAroundTheFarm INSTANCE = null;

    private WalkAroundTheFarm(){}

    public static WalkAroundTheFarm getInstance(){
        if (INSTANCE == null){
            INSTANCE = new WalkAroundTheFarm();
        }
        return INSTANCE;
    }
    //SINGLETON end

    @Override
    public void enter(Billy farmer) {

    }

    @Override
    public void execute(Billy farmer) {
        System.out.println("Billy's walking through the farm... That's what he does");

        if (farmer.wantsToDoNothing()){
            farmer.changeStates(LookAtTheWeather.getInstance());
        }
    }

    @Override
    public void exit(Billy farmer) {

    }
}
