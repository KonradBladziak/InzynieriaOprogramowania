package vod.service;

import vod.model.Platoon;
import vod.model.Tank;

import java.util.List;

public interface TankService {

    List<Tank> getAllTanks();

    List<Tank> getTanksByPlatoon(Platoon platoon);

    Tank getTankById(int id);

    Tank addTank(Tank tank);

    List<Platoon> getAllPlatoons();

    Platoon getPlatoonById(int id);

    Platoon addPlatoon(Platoon platoon);
}
