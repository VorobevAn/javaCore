package org.seminar3;

public class Freelancer extends Employees {

    public Freelancer(String name, int age, int salaryRate) {
        super(name, age, salaryRate);

    }

    /**
     * расчет зароботной платы с учетом почасовой оплаты.
     * @return
     */
    @Override
    public int wage() {
        int averegeSelary = (int) (20.8 * 8 * salaryRate);
        return averegeSelary;

    }
}
