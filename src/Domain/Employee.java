package Domain;

/**
 * @author gengzeyu
 * @version 1.0
 * @description: TODO
 * @date 2022.07.26 21:29:55
 */

public class Employee {
    private int id;
    private double salary;
    private String name;
    private int age;
    public Employee(){

    }
    public Employee(int id,String name,int age,double salary){
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getDetail(){
        return id+"\t"+name+"  \t"+age+"\t"+salary;
    }

    @Override
    public String toString() {
        return getDetail();
    }
}
