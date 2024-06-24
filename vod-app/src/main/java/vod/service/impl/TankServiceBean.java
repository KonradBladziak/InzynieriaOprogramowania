package vod.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vod.repository.TankerDao;
import vod.repository.PlatoonDao;
import vod.repository.TankDao;
import vod.model.Tanker;
import vod.model.Platoon;
import vod.model.Tank;
import vod.service.TankService;

import java.util.List;
import java.util.logging.Logger;

@Service
public class TankServiceBean implements TankService {

    private static final Logger log = Logger.getLogger(TankService.class.getName());

    private PlatoonDao platoonDao;
    private TankerDao tankerDao;
    private TankDao tankDao;

    public TankServiceBean(PlatoonDao platoonDao, TankerDao tankerDao, TankDao tankDao) {
        log.info("creating tank service bean");
        this.platoonDao = platoonDao;
        this.tankerDao = tankerDao;
        this.tankDao = tankDao;
    }

    @Autowired
    public void setPlatoonDao(PlatoonDao platoonDao) {
        this.platoonDao = platoonDao;
    }


    public List<Tank> getAllTanks() {
        log.info("searching all tanks...");
        return tankDao.findAll();
    }

    public List<Tank> getTanksByPlatoon(Platoon platoon) {
        log.info("serching tank by platoon " + platoon.getId());
        return tankDao.findByPlatoon(platoon);
    }

    public List<Tank> getMoviesInCinema(Tanker tanker) {
        log.info("searching for tank operated by tanker " + tanker.getId());
        return tankDao.findByTanker(tanker);
    }

    public Tank getTankById(int id) {
        log.info("searching tank by id " + id);
        return tankDao.findById(id);
    }

    public List<Tanker> getAllTankers() {
        log.info("searching all tankers");
        return tankerDao.findAll();
    }

    public List<Tanker> getCinemasByMovie(Tank tank) {
        log.info("searching tankers by tank " + tank.getId());
        return tankerDao.findByTank(tank);
    }

    public Tanker getTankerById(int id) {
        log.info("searching tanker by id " + id);
        return tankerDao.findById(id);
    }

    public List<Platoon> getAllPlatoons() {
        log.info("searching all platoons");
        return platoonDao.findAll();
    }

    public Platoon getPlatoonById(int id) {
        log.info("searching platoon by id " + id);
        return platoonDao.findById(id);
    }

    @Override
    public Tank addTank(Tank tank) {
        log.info("about to add tank " + tank);
        return tankDao.add(tank);
    }

    @Override
    public Platoon addPlatoon(Platoon platoon) {
        log.info("about to add platoon " + platoon);
        return platoonDao.add(platoon);
    }

    @Override
    public List<Tank> getTanksOfTanker(Tanker tanker) {
        Tanker tanker1 = tankerDao.findById(tanker.getId());
        if(tanker1 == null) {
            return null;
        }
        List<Tank> tanks = tanker1.getTanks();
        if(tanks == null) {
            return null;
        }
        return tanks;
    }
}