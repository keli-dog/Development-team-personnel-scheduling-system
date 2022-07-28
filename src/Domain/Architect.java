package Domain;

/**
 * @author gengzeyu
 * @version 1.0
 * @description: TODO
 * @date 2022.07.26 22:21:13
 */

public class Architect extends Designer{
    private  int stock;//表示公司奖励的股票数量

    public Architect() {
        super();
    }

    public Architect(int id, String name, int age, double salary, Equipment equipment, double bonus, int stock) {
        super(id, name, age, salary, equipment, bonus);
        this.stock = stock;
    }
    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    @Override
    public String toString() {
        return getDetail()+"\t架构师\t"+getStatus()+"\t"+getBonus()+"  \t"+getStock()+"\t"+getEquipment().getDescription();
    }
    @Override
    public String getteamDetail(){
        return getMemberid()+"/"+getId()+"  \t"+getName()+"  \t"+getAge()+"\t  "+getSalary() + "      架构师\t"+getBonus()+"\t\t"+getStock();
    }
}
