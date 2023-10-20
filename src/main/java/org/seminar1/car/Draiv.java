package org.seminar1.car;

import org.seminar1.car.Car;

public class Draiv {

    /**
     * Метод остановки автомобиля
     * @param car автомобиль
     * @return скорость автомобиля
     */
    public static int stopCar(Car car){
        car.setSpeed(0);
        return car.getSpeed();
    }

    /**
     * Метод увеличения скорости автомобиля
     * @param car автомобиль
     * @return  текущая скорость
     */

    public static int carAcceleration(Car car){
        car.setSpeed(car.getSpeed()+10);
        return car.getSpeed();
    }
}
