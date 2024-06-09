package vod.repository.mem;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import vod.repository.TankDao;
import vod.model.Tanker;
import vod.model.Platoon;
import vod.model.Tank;

import java.util.List;
import java.util.stream.Collectors;

@Repository("tankDao")
public class MemTankDao implements TankDao {

    @Override
    public List<Tank> findAll() {
        return SampleData.tanks;
    }


    @Override
    public Tank findById(int id) {
        return SampleData.tanks.stream().filter(m -> m.getId() == id).findFirst().orElse(null);
    }


    @Override
    public List<Tank> findByPlatoon(Platoon platoon) {
       return SampleData.tanks.stream().filter(m -> m.getPlatoon() == platoon).collect(Collectors.toList());
    }


    @Override
    public List<Tank> findByTanker(Tanker tanker) {
        return SampleData.tanks.stream().filter(m -> m.getTankers().contains(tanker)).collect(Collectors.toList());
    }


    @Override
    public Tank add(Tank tank) {
        int max = SampleData.tanks.stream().max((m1, m2) -> m1.getId() - m2.getId()).get().getId();
        tank.setId(max++);
        SampleData.tanks.add(tank);
        return tank;
    }
}