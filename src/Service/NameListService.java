package Service;

import Domain.*;

import static Service.Data.*;

/**
 * @author gengzeyu
 * @version 1.0
 * @description: TODO
 * @date 2022.07.26 22:29:26
 */

public class NameListService {
    private final Employee[] employees;

    public NameListService() {
        employees = new Employee[EMPLOYEES.length];
        for (int i = 0; i < EMPLOYEES.length; i++) {//循环给每一个员工初始化信息
            int key = Integer.parseInt(EMPLOYEES[i][0]);

            Equipment equipment;
            int bonus;
            int stock;

            //四个共有信息
            int id = Integer.parseInt(EMPLOYEES[i][1]);
            String name = EMPLOYEES[i][2];
            int age = Integer.parseInt(EMPLOYEES[i][3]);
            double salary = Double.parseDouble(EMPLOYEES[i][4]);

            switch (key) {
                case EMPLOYEE://10
                    employees[i] = new Employee(id, name, age, salary);
                    break;
                case PROGRAMMER://11
                    equipment = CreatEquipment(i);
                    employees[i] = new Programmer(id, name, age, salary,
                            equipment);
                    break;
                case DESIGNER://12
                    equipment = CreatEquipment(i);
                    bonus = Integer.parseInt(EMPLOYEES[i][5]);
                    employees[i] = new Designer(id, name, age, salary,
                            equipment, bonus);
                    break;
                case ARCHITECT://13
                    equipment = CreatEquipment(i);
                    bonus = Integer.parseInt(EMPLOYEES[i][5]);
                    stock = Integer.parseInt(EMPLOYEES[i][6]);
                    employees[i] = new Architect(id, name, age, salary,
                            equipment, bonus, stock);
                    break;
            }
        }
    }

    /**
     * @description:获取index位置上员工设备
     * @author gengzeyu
     * @date 2022.07.26
     * @version 1.0
     */
    private Equipment CreatEquipment(int index) {
        int key = Integer.parseInt(EQUIPMENTS[index][0]);
        String modelName = EQUIPMENTS[index][1];
        switch (key) {
            case PC://21
                String display = EQUIPMENTS[index][2];
                return new PC(modelName,
                        display);
            case NOTEBOOK://22
                double price = Double.parseDouble(EQUIPMENTS[index][2]);
                return new NoteBook(modelName,
                        price);
            case PRINTER://23
                String type = EQUIPMENTS[index][2];
                return new Printer(modelName,
                        type);
        }
        return null;
    }

    /**
     * @description: 获取全部员工信息
     * @author gengzeyu
     * @date 2022.07.26
     * @version 1.0
     */
    public Employee[] getAllEmployee() {
        return employees;
    }

    /**
    * @description: 获取指定ID的员工对象
    * @author gengzeyu
    * @date 2022.07.26
    * @version 1.0
    */
    public Employee getEmployee(int id) throws TeamException {
        for (int i = 0; i <employees.length; i++ ) {
             if (employees[i].getId()==id) {
                 return employees[i];
             }
        }
        throw new TeamException("找不到指定的员工!\n");
    }
}
