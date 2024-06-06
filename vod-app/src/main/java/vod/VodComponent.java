package vod;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import vod.model.Tanker;
import vod.service.TankerService;

import java.util.Arrays;
import java.util.List;

@Component
@Slf4j
public class VodComponent implements CommandLineRunner, ApplicationListener<ContextRefreshedEvent> {

    private final TankerService tankerService;

    public VodComponent(TankerService tankerService){
        this.tankerService = tankerService;
    }

    @PostConstruct
    void init(){
        log.info("in post construct.");
    }


    @Override
    public void run(String... args) throws Exception {
        log.info("programs arguments: {}", Arrays.toString(args));
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info("on context refreshed");
        List<Tanker> tankers = tankerService.getAllTankers();
        log.info("{} tankers found.", tankers.size());
        tankers.forEach(tanker -> log.info("{}", tanker));
    }
}
