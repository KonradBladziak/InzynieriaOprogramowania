package vod.service;

import vod.repository.TankerDao;
import vod.repository.TankDao;
import vod.repository.mem.MemTankerDao;
import vod.repository.mem.MemTankDao;
import vod.model.Tanker;
import vod.service.impl.TankerServiceBean;

import java.util.List;

public class VodServiceMain {

    public static void main(String[] args) {
        System.out.println("Let's find tankers!");

        TankerDao tankerDao = new MemTankerDao();
        TankDao tankDao = new MemTankDao();
        
        TankerService service = new TankerServiceBean(tankerDao, tankDao);

        List<Tanker> tankers = service.getAllTankers();
        System.out.println(tankers.size() + " cinemas found:");
        tankers.forEach(System.out::println);
    }
}
