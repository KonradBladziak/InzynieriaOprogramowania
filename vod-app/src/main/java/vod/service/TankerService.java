package vod.service;

import vod.model.Tanker;
import vod.model.Tank;

import java.util.List;

public interface TankerService {

    Tanker getTankerById(int id);

    List<Tanker> getAllTankers();

    List<Tanker> getTankersByTank(Tank tank);

    List<Tank> getTankInTanker(Tanker tanker);
}