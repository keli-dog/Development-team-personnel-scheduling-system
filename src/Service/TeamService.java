package Service;

import Domain.Architect;
import Domain.Designer;
import Domain.Employee;
import Domain.Programmer;
import Service.TeamException;

import static Service.Data.*;
import static Service.Data.EMPLOYEES;
import static Service.Status.*;

/**
 * @author gengzeyu
 * @version 1.0
 * @description: TODO
 * @date 2022.07.27 10:11:01
 */

public class TeamService {
    //用来为开发团队新增成员自动生成团队中的唯一ID，即memberId。（提示：应使用增1的方式）
    private static int counter = 1;
    private static int total = 0;//记录团队成员的实际人数
    private final int MAX_MEMBER = 5;//表示开发团队最大成员数
    Programmer[] team = new Programmer[MAX_MEMBER];//用来保存当前团队中的各成员对象

    /**
     * @description 获取该团队所有成员
     * @author gengzeyu
     * @date 2022/07/278
     */
    public Programmer[] getTeam() {
        Programmer[] team = new Programmer[total];
        for (int i = 0; i < team.length; i++) {
            team[i] = this.team[i];
        }
        return team;
    }

    /**
     * @description 判断该成员是否已经在开发团队中
     * @author gengzeyu
     * @date 2022/07/278
     */
    private boolean isExist(Employee e) {
        for (int i = 0; i < total; i++) {
            if (team[i].getId() == e.getId()) {
                return true;
            }
        }
        return false;
    }

    /**
     * @description 在团队中添加新成员
     * @author gengzeyu
     * @date 2022/07/278
     */
    public void addMember(Employee e) throws TeamException {
        if (total >= MAX_MEMBER)
            throw new TeamException("成员已满，无法添加！");
        if (!(e instanceof Programmer))
            throw new TeamException("该成员不是开发人员，无法添加!");
        if (isExist(e))
            throw new TeamException("该员工已在本开发团队中");
        if (((Programmer) e).getStatus() == BUSY)
            throw new TeamException("该员工已是某团队成员");
        else if (((Programmer) e).getStatus() == VACATION)
            throw new TeamException("该员工已在开发团队中");
        int numofProgrammer = 0, numofDesigner = 0, numofArchitect = 0;//获取各类型成员数量
        for (int i = 0; i < total; i++) {
            if (team[i] instanceof Architect) {
                numofArchitect++;
            } else if (team[i] instanceof Designer) {
                numofDesigner++;
            } else {
                numofProgrammer++;
            }
        }
        if (e instanceof Architect) {
            if (numofArchitect >= 1)
                throw new TeamException("团队中至多只能有一名架构师");
        } else if (e instanceof Designer) {
            if (numofDesigner >= 2)
                throw new TeamException("团队中至多只能有俩名设计师");
        } else {
            if (numofProgrammer >= 3)
                throw new TeamException("团队中至多只能有三名程序员");
        }

        Programmer p = (Programmer) e;
        p.setStatus(BUSY);
        p.setMemberid(counter++);
        team[total++] = p;
    }

    /**
     * @description 在团队中删除成员
     * @author gengzeyu
     * @date 2022/07/278
     */
    public void removeMember(int memberId) throws TeamException {
        int i = 0;
        for (; i < total; i++) {
            if(team[i].getMemberid() == memberId){
            team[i].setStatus(FREE);
            team[i].setMemberid(0);
            break;
            }
        }
        //未找到指定Memberid的团队成员
        if(i==total)
            throw new TeamException("找不到指定memberId的员工，删除失败!");
        //删除指定Memberid的团队成员
        for (int j = i; j < total-1; j++) {
            team[j]=team[j+1];
        }
        team[--total]=null;
    }
}
