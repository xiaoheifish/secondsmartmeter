package com.terabits.meta.bo;

/**
 * Created by Administrator on 2017/6/13.
 */
public class ItemBO {
    private String value;//模板显示值
    private String color;//模板显示颜色
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "ItemBO{" +
                "value='" + value + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
