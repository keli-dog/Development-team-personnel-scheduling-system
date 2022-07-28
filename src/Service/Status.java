package Service;

/**
 * @author gengzeyu
 * @version 1.0
 * @description: 表示员工状态
 * @date 2022.07.26 21:41:33
 */

public class Status {
    private final String NAME;
    public static final Status FREE=new Status("FREE");//空闲
    public static final Status BUSY=new Status("BUSY");//已经加入开发团队
    public static final Status VACATION=new Status("VACATION");//正在休假

    private Status(String name) {
        this.NAME = name;
    }
    public String getNAME() {
        return NAME;
    }

    @Override
    public String toString() {
        return NAME;
    }
}
