package vod.repository.mem;

import vod.repository.PlatoonDao;
import vod.model.Platoon;

import java.util.List;

public class MemPlatoonDao implements PlatoonDao {

    @Override
    public List<Platoon> findAll() {
        return SampleData.platoons;
    }


    @Override
    public Platoon findById(int id) {
        return SampleData.platoons.stream().filter(d -> d.getId() == id).findFirst().orElse(null);
    }


    @Override
    public Platoon add(Platoon platoon) {
        int max = SampleData.platoons.stream().max((d1, d2) -> d1.getId() - d2.getId()).get().getId();
        platoon.setId(max++);
        SampleData.platoons.add(platoon);
        return platoon;
    }
}
