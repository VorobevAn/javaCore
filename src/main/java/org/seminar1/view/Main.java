package org.seminar1.view;

import org.seminar1.cars.Car;
import org.seminar1.cars.Draiv;

public class Main {
    public static void main(String[] args) {
        int speed;
        Car lada = new Car("red","lada",0);
        Draiv.carAcceleration(lada);
        Draiv.carAcceleration(lada);
        Draiv.stopCar(lada);
        speed = lada.getSpeed();
        System.out.println("Скорость машины " + speed);
    }
}