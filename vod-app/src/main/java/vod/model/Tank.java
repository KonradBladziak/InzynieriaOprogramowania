package vod.model;

import java.util.ArrayList;
import java.util.List;

public class Tank {

    private int id;
    private String name;
    private Platoon platoon;
    private List<Tanker> tankers = new ArrayList<>();


    public Tank() {}

    public Tank(int id, String name, Platoon platoon) {
        this.id = id;
        this.name = name;
        this.platoon = platoon;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public Platoon getPlatoon() {
        return platoon;
    }

    public void setPlatoon(Platoon platoon) {
        this.platoon = platoon;
    }


    public List<Tanker> getTankers() {
        return tankers;
    }

    public void setTankers(List<Tanker> tankers) {
        this.tankers = tankers;
    }

    public void addTanker(Tanker tanker) {
        this.tankers.add(tanker);
    }


    @Override
    public String toString() {
        return "Tank{" +
                "name='" + name + '\'' +
                ", platoon=" + platoon +
                '}';
    }
}