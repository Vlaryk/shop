package Controller.Interfaces;

import Model.Domain.Toy;
import Model.ModelClass;

import java.util.ArrayList;

public interface iGetController {
    public void run();
    public Toy dispenseToy();
    public void addPrizeList(Toy toy);
    public ArrayList<Toy> getPrizeList();
}
