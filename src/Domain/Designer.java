package Domain;

/**
 * @author gengzeyu
 * @version 1.0
 * @description: TODO
 * @date 2022.07.26 22:16:18
 */

public class Designer extends Programmer{
    private double bonus;//奖金
    public Designer() {
        super();
    }

    public Designer(int id, String name, int age, double salary, Equipment equipment, double bonus) {
        super(id, name, age, salary, equipment);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return getDetail()+"\t设计师\t"+getStatus()+"\t"+getBonus()+"\t\t\t\t"+getEquipment().getDescription();
    }
    @Override
    public String getteamDetail(){
        return getMemberid()+"/"+getId()+"  \t"+getName()+"  \t"+getAge()+"\t  "+getSalary() + "      设计师\t"+getBonus();
    }
}
