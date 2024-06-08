package vod.repository.mem;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import vod.repository.TankerDao;
import vod.model.Tanker;
import vod.model.Tank;

import java.util.List;
import java.util.stream.Collectors;

@Repository("tankerDao")
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

    @Override
    public void addTanker(Tanker tanker) {
        int maxId = SampleData.tankers.stream()
                .sorted((c1, c2) -> c2.getId() - c1.getId())
                        .findFirst()
                        .map(c-> c.getId())
                        .orElse(0);
        tanker.setId(maxId + 1);
        SampleData.tankers.add(tanker);
    }
}