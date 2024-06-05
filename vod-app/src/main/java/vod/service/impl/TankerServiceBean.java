package vod.service.impl;

import vod.model.Tanker;
import vod.model.Tank;
import vod.repository.TankerDao;
import vod.repository.TankDao;
import vod.service.TankerService;

import java.util.List;
import java.util.logging.Logger;

public class TankerServiceBean implements TankerService {

    private static final Logger log = Logger.getLogger(TankerService.class.getName());

    private TankerDao tankerDao;
    private TankDao tankDao;

    public TankerServiceBean(TankerDao tankerDao, TankDao tankDao) {
        log.info("creating Tanker service bean");
        this.tankerDao = tankerDao;
        this.tankDao = tankDao;
    }

    @Override
    public Tanker getTankerById(int id) {
        log.info("searching tanker by id " + id);
        return tankerDao.findById(id);
    }

    @Override
    public List<Tank> getTankInTanker(Tanker tanker) {
        log.info("searching for tank operated by tanker " + tanker.getId());
        return tankDao.findByTanker(tanker);
    }

    @Override
    public List<Tanker> getAllTankers() {
        log.info("searching all tankers");
        return tankerDao.findAll();
    }

    @Override
    public List<Tanker> getTankersByTank(Tank tank) {
        log.info("searching tankers by tank " + tank.getId());
        return tankerDao.findByTank(tank);
    }
}