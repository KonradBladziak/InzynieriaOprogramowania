package vod.repository;

import vod.model.Tanker;
import vod.model.Tank;

import java.util.List;

public interface TankerDao {

    List<Tanker> findAll();

    Tanker findById(int id);

    List<Tanker> findByTank(Tank tank);
}