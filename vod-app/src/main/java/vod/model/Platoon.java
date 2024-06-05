package vod.model;

import java.util.ArrayList;
import java.util.List;

public class Platoon {

    private int id;
    private String name;
    private List<Tank> tanks = new ArrayList<>();


    public Platoon() { }

    public Platoon(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<Tank> getTanks() {
        return tanks;
    }

    public void setTanks(List<Tank> tanks) {
        this.tanks = tanks;
    }

    public void addTanks(Tank tanks) {
        this.tanks.add(tanks);
    }


    @Override
    public String toString() {
        return "Director{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
