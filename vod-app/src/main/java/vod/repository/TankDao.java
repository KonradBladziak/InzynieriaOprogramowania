package vod.repository;

import vod.model.Tanker;
import vod.model.Platoon;
import vod.model.Tank;

import java.util.List;

public interface TankDao {

    List<Tank> findAll();

    Tank findById(int id);

    List<Tank> findByPlatoon(Platoon platoon);

    List<Tank> findByTanker(Tanker tanker);

    Tank add(Tank tank);
}