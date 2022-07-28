package Domain;

import org.bouncycastle.asn1.eac.EACObjectIdentifiers;

/**
 * @author gengzeyu
 * @version 1.0
 * @description: TODO
 * @date 2022.07.26 21:22:11
 */

public class Printer implements Equipment {
    private String name;//机器名字
    private String type;//机器类型
    public Printer(){

    }
    public Printer(String name,String type){
        this.name = name;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getDescription() {
        return name+"("+type+")";
    }
}
