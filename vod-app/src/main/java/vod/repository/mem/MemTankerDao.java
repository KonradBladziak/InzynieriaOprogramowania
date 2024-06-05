package vod.repository.mem;

import vod.repository.TankerDao;
import vod.model.Tanker;
import vod.model.Tank;

import java.util.List;
import java.util.stream.Collectors;


public class MemTankerDao implements TankerDao {

    @Override
    public List<Tanker> findAll() {
        return SampleData.tankers;
    }


    @Override
    public Tanker findById(int id) {
        return SampleData.tankers.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }


    @Override
    public List<Tanker> findByTank(Tank tank) {
        return SampleData.tankers.stream().filter(c -> c.getTanks().contains(tank)).collect(Collectors.toList());
    }
}