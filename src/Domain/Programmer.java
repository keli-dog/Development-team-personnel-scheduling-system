package Domain;

import Service.Status;

/**
 * @author gengzeyu
 * @version 1.0
 * @description: TODO
 * @date 2022.07.26 21:36:33
 */

public class Programmer extends Employee {
    private int memberid;//用来记录成员加入开发团队后在团队中的ID
    private Equipment equipment;//使用设备
    private Status status=Status.FREE;

    public Programmer() {
           super();
    }
    public Programmer(int id,String name,int age,double salary,Equipment equipment){
            super(id, name, age, salary);
            this.equipment=equipment;
    }


    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public int getMemberid() {
        return memberid;
    }

    public void setMemberid(int memberid) {
        this.memberid = memberid;
    }
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return getDetail()+"\t程序员\t"+getStatus()+"\t\t\t\t\t\t"+equipment.getDescription();
    }

    public String getteamDetail(){
        return getMemberid()+"/"+getId()+"  \t"+getName()+"  \t"+getAge()+"\t  "+getSalary();
    }
}
