package org.seminar3;

import java.util.ArrayList;

public class Programm {
    public static void main(String[] args) {

//        создаём двух рабочих и добавляем их в массив.
        Worker worker = new Worker("Vasiliy", 35, 32000);
        Freelancer freelancer = new Freelancer("Oleg", 30, 358);
        ArrayList<Employees> listEmliyees = new ArrayList<>();
        listEmliyees.add(worker);
        listEmliyees.add(freelancer);

//        Вывод списка рабочих.
        for (Employees employ : listEmliyees) {
            System.out.println(employ);
        }
        System.out.println("Зарплата " + worker.getName() + "=" + worker.wage());
        System.out.println("Зарплата " + freelancer.getName() + "=" + freelancer.wage());
    }
}
