package Model;

import Controller.Interfaces.iGetModel;
import Model.Domain.Toy;

import java.util.ArrayList;

public class ModelClass implements iGetModel {

    private ArrayList<Toy> toys;
    public ModelClass (ArrayList<Toy> toyList) {
        this.toys = toyList;
    }

    @Override
    public ArrayList<Toy> getToys() {
        return toys;
    }

    @Override
    public void deleteToy(int id) {
        for (int i = 0; i < toys.size(); i++) {
            if (toys.get(i).getId() == id) {
                Toy toy = toys.remove(i);
                System.out.println("Игрушка " + toy + "удалена");
            }
        }
    }
}
