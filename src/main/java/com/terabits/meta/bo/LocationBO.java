package com.terabits.meta.bo;

/**
 * Created by Administrator on 2017/5/26.
 */
public class LocationBO {
    private String building;
    private String room;

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "LocationBO[" +
                "building='" + building + '\'' +
                ", room='" + room + '\'' +
                ']';
    }
}
