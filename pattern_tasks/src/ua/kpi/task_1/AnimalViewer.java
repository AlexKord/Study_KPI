package ua.kpi.task_1;

public class AnimalViewer implements State {

    @Override
    public void doAction(ManInAction man) {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Hunter";
    }
}
