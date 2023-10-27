package org.seminar3;


public abstract class Employees {
    protected  String name;
    protected int age;
    protected int salaryRate;


    public Employees(String name, int age, int salaryRate) {
        this.name = name;
        this.age = age;
        this.salaryRate = salaryRate;
    }

// Абстрактный метод для начисления зарплаты
    public abstract int wage();

// геторы для обращения к данным
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getSalaryRate() {
        return salaryRate;
    }
// переопределение метода вывода


    @Override
    public String toString() {
        return "Employees{" +
                "name='" + name + '\'' +
                ", age=" + age +'}';
    }
}

