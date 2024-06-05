package vod.repository;

import vod.model.Platoon;

import java.util.List;

public interface PlatoonDao {

    List<Platoon> findAll();

    Platoon findById(int id);

    Platoon add(Platoon platoon);
}