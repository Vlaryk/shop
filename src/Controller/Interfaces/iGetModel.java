package Controller.Interfaces;

import Model.Domain.Toy;

import java.util.ArrayList;

public interface iGetModel {
    public ArrayList<Toy> getToys ();
    public void deleteToy (int id);
}
