package Controller;

import Controller.Interfaces.iGetController;
import Controller.Interfaces.iGetModel;
import Controller.Interfaces.iGetView;
import Model.Domain.Toy;
import View.ViewClass;

import java.util.ArrayList;
import java.util.Random;

public class ControllerClass implements iGetController {
    private final iGetModel model;
    private final iGetView view = new ViewClass();
    private ArrayList<Toy> prizeList = new ArrayList<>();

    public ControllerClass(iGetModel model) {
            this.model = model;
    }

    @Override
    public void run() {
        view.setController(new ControllerClass(model));
        view.run();
    }

    public Toy dispenseToy() {
        Random rand = new Random();
        double totalProbability = model.getToys().stream().mapToDouble(Toy::getWeight).sum();
        double randomNumber = rand.nextDouble() * totalProbability;

        double currentProbability = 0;
        for (Toy toy : model.getToys()) {
            currentProbability += toy.getWeight();
            if (randomNumber < currentProbability) {
                return toy;
            }
        }
        return null;
    }

    @Override
    public void addPrizeList(Toy toy) {
        prizeList.add(toy);
    }

    @Override
    public ArrayList<Toy> getPrizeList() {
        return prizeList;
    }

}
