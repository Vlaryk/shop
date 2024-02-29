package Controller;

import Controller.Interfaces.iGetController;
import Controller.Interfaces.iGetModel;
import Model.ModelClass;

public class ControllerClass implements iGetController {
    private iGetModel model;

    public ControllerClass(iGetModel model) {
            this.model = model;
    }

    @Override
    public void run() {

    }
}
