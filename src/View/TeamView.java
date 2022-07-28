package View;

import Domain.Employee;
import Domain.Programmer;
import Service.NameListService;
import Service.TeamException;
import Service.TeamService;

import static View.TSUtility.*;

/**
 * @author gengzeyu
 * @version 1.0
 * @description: TODO
 * @date 2022.07.27 12:44:02
 */

public class TeamView {
           NameListService listSvc=new NameListService();
           TeamService teamSvc=new TeamService();
          public TeamView() {
              enterMainMenu();
          }
           /**
           * @description 入口菜单
           * @author gengzeyu
           * @date  2022.07.27
           */
           public  void enterMainMenu(){
               boolean flag=true;
               char key='0';
               while (flag) {
                   if(key!='1')listAllEmployees();

                   System.out.print("1-团队列表 2-添加团队成员 3-删除团队成员 4-退出 请选择(1-4):");
                   key=readMenuSelection();
                   switch (key) {
                       case '1':
                           getTeam();
                           break;
                       case '2':
                           addMember();
                           break;
                       case '3':
                           deleteMember();
                           break;
                       case '4':
                           System.out.println("是否要退出(Y/N)");
                           char ifExit=readConfirmSelection();
                           if(ifExit=='Y')flag=false;
                           break;
                   }
               }
           }

           /**
           * @description 显示所有员工信息
           * @author gengzeyu
           * @date  2022.07.27
           */
           public void listAllEmployees() {
               System.out.println("-------------------------------------开发团队调度软件----------" +
                       "----------------------------\n");
               System.out.println("ID   姓名    年龄    工资    职位    状态      奖金       股票     领用设备");
               Employee[] employees = listSvc.getAllEmployee();
               for(int i = 0; i < employees.length; i++){
                   System.out.println(employees[i]);
               }
               System.out.println("-------------------------------------------------------------" +
                       "-----------------------------");
           }

          /**
           * @description 显示所有团队成员信息
           * @author gengzeyu
           * @date  2022.07.27
           */
           public void getTeam(){
               System.out.println("--------------------团队成员列表---------------------\n");
               System.out.println("TDI/ID  姓名    年龄      工资       职位      奖金        股票");
               Programmer[] team =teamSvc.getTeam();
              if (team == null||team.length == 0) {
                  System.out.println("没有团队成员");
              }else{
                  for (int i = 0; i < team.length; i++) {
                      System.out.println(team[i].getteamDetail());
                  }
              }
               System.out.println("-----------------------------------------------------");
           }

           /**
           * @description 增加团队成员
           * @author gengzeyu
           * @date  2022.07.27
           */
           private void addMember(){
               System.out.println("---------------------添加成员---------------------\n");
               System.out.print("请输入要添加的员工id：");
               int id=readInt();
               try {
                   Employee employee = listSvc.getEmployee(id);
                   teamSvc.addMember(employee);
                   System.out.println("添加成功");
               }catch (TeamException e) {
                   System.out.println("添加失败，原因："+e.getMessage());
               }
               // 按回车键继续...
               readReturn();
           }

           /**
           * @description 删除团队成员
           * @author gengzeyu
           * @date  2022.07.27
           */
           private void deleteMember() {
               System.out.println("---------------------删除成员---------------------");
               System.out.print("请输入要删除员工的TID：");
               int id = TSUtility.readInt();
               System.out.print("确认是否删除(Y/N)：");
               char yn = TSUtility.readConfirmSelection();
               if (yn == 'N')
                   return;

               try {
                   teamSvc.removeMember(id);
                   System.out.println("删除成功");
               } catch (TeamException e) {
                   System.out.println("删除失败，原因：" + e.getMessage());
               }
               // 按回车键继续...
               readReturn();
           }

    public static void main(String[] args) {
        //TeamView teamView = new TeamView();
        //teamView.enterMainMenu();
        new TeamView();
    }
}
