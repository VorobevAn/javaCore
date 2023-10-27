package org.seminar3;

public class Worker extends Employees{
    public Worker(String name, int age, int salaryRate) {
        super(name, age, salaryRate);

    }
// расчет заплаты с фиксированной оплатой
    @Override
    public int wage() {
        return salaryRate;
    }
}
