package ua.kpi.task_1;

public class MushroomGlade implements State {

    @Override
    public void doAction(ManInAction manInAction) {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Mushroomer";
    }
}