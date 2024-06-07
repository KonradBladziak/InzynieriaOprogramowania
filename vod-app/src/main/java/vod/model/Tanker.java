package vod.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public class Tanker {

    private int id;
    private String name;
    private String surname;

    @JsonIgnore
    private List<Tank> tanks = new ArrayList<>();


    public Tanker() { }

    public Tanker(int id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }


    public int getId() { return id; }

    public void setId(int id) { this.id = id; }


    public String getName() { return name; }

    public void setName(String name) { this.name = name; }


    public String getSurname() { return surname; }

    public void setSurname(String surname) { this.surname = surname; }


    public List<Tank> getTanks() { return tanks; }

    public void setTanks(List<Tank> tanks) { this.tanks = tanks; }

    public void addTank(Tank tank) { this.tanks.add(tank); }


    @Override
    public String toString() {
        return "Tanker{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}