import Controller.ControllerClass;
import Model.Domain.Toy;
import Model.ModelClass;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Toy toy1 = new Toy(1,"bear",2,15);
        Toy toy2 = new Toy(2,"lion",2,35);
        Toy toy3 = new Toy(3,"car",1,10);
        Toy toy4 = new Toy(4,"doll",4,40);

        ArrayList<Toy> toyList = new ArrayList<>();
        toyList.add(toy1);
        toyList.add(toy2);
        toyList.add(toy3);
        toyList.add(toy4);

        ModelClass model = new ModelClass(toyList);
        ControllerClass controller = new ControllerClass(model);

    }
}