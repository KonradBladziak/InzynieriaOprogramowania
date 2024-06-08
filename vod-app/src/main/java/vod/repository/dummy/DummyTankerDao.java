package vod.repository.dummy;

import org.springframework.stereotype.Component;
import vod.model.Tank;
import vod.model.Tanker;
import vod.repository.TankerDao;

import java.util.List;

@Component
public class DummyTankerDao implements TankerDao {

    @Override
    public List<Tanker> findAll() {
        return List.of();
    }

    @Override
    public Tanker findById(int id) {
        return null;
    }

    @Override
    public List<Tanker> findByTank(Tank tank) {
        return List.of();
    }

    @Override
    public void addTanker(Tanker tanker) {
        return;
    }
}
