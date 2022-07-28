package Domain;

/**
 * @author gengzeyu
 * @version 1.0
 * @description: TODO
 * @date 2022.07.26 21:12:53
 */

public class PC implements Equipment {
    private String display;//显示器名称
    private String model;//机器型号
    public PC() {

    }
    public PC(String model,String display){
        this.display = display;
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    @Override
    public String getDescription() {
        return model+"("+display+")";
    }
}
