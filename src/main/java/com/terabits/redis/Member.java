package com.terabits.redis;

/**
 * Created by Administrator on 2017/6/15.
 */
public class Member extends BaseModel{

    private static final long serialVersionUID = -1959528436584592183L;
    private String id;
    private String electricity;

    public Member(){}

    public Member(String id, String electricity){
        this.setId(id);
        this.setElectricity(electricity);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getElectricity() {
        return electricity;
    }

    public void setElectricity(String electricity) {
        this.electricity = electricity;
    }

}