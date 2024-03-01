package View;

import Controller.Interfaces.iGetController;
import Controller.Interfaces.iGetView;
import java.io.FileWriter;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Scanner;

public class ViewClass implements iGetView {
    private iGetController controller;

    public void run () {
        while (true) {
           String command =  prompt("Введите команду");
           if (Objects.equals(command, "add prize")) {
               controller.addPrizeList(controller.dispenseToy());
               System.out.println("Приз " + controller.getPrizeList().getLast() + " добавлен");
           } else if (Objects.equals(command, "r list")){
               System.out.println(controller.getPrizeList());
           } else if (Objects.equals(command, "give prize")) {
               while (true) {
                   try {
                       if (controller.getPrizeList().getFirst().getQuantity() > 0) {
                           controller.getPrizeList().getFirst().setQuantity(controller.getPrizeList().getFirst().getQuantity() - 1);
                           String str = String.valueOf(controller.getPrizeList().get(0));
                           System.out.println("приз " + controller.getPrizeList().remove(0)  + " выдан");
                           try (FileWriter writer = new FileWriter("Prizes.txt", true)){
                               writer.write(str + ", ");
                           } catch (IOException e) {
                               System.err.println("Ошибка при записи в файл: " + e.getMessage());
                           }
                           break;
                       } else {
                           controller.getPrizeList().remove(0);
//                           System.out.println(" ");
                       }
                   }
                   catch (NoSuchElementException e) {
                       System.out.println("Список выдачи призов пуст");
                       break;
                   }
               }
           } else {
               System.out.println("Некорректная команда");
               break;
           }
        }


    }

    public String prompt(String msg) {
        Scanner in = new Scanner(System.in);
        System.out.println(msg);
        return in.nextLine();
    }

    public void setController (iGetController controller) {
        this.controller = controller;
    }
}
