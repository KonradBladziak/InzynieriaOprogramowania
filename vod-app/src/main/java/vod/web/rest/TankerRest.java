package vod.web.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vod.model.Tanker;
import vod.model.Tank;
import vod.service.TankService;
import vod.service.TankerService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/webapi")
public class TankerRest {

    private final TankerService tankerService;
    private final TankService tankService;

    @GetMapping("/tankers")
    List<Tanker> getTankers(@RequestParam(value = "phrase") String phrase,
                            @RequestHeader(value = "custom-header", required = false)String customHeader){
        log.info("about to retrieve tankers list");
        log.info("phrase param: {}", phrase);
        List<Tanker> tankers = tankerService.getAllTankers();
        log.info("{} tankers found", tankers.size());
        return tankers;
    }

    @GetMapping("/tankers/{id}")
    ResponseEntity<Tanker> getTanker(@PathVariable int id){
        log.info("about to retrieve tanker with id {}", id);
        Tanker tanker = tankerService.getTankerById(id);
        log.info("tanker found: {}", tanker);
        if(tanker != null){
            return ResponseEntity.status(200).body(tanker);
        } else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/tanks/{id}/tankers")
    ResponseEntity<List<Tanker>>getTankersByTank(@PathVariable int id){
        log.info("about to retrieve tanks with id {}", id);
        Tank tank = tankService.getTankById(id);
        if(tank == null){
            return ResponseEntity.notFound().build();
        } else{
            List<Tanker>tankers = this.tankerService.getTankersByTank(tank);
            log.info("There is {} tankers in tank {}", tankers.size(), tank.getName());
            return ResponseEntity.ok(tankers);

        }
    }


    @PostMapping("/tankers/create-tanker")
    ResponseEntity<Tanker> addTanker(@RequestBody Tanker tanker){
        log.info("about to add tanker {}", tanker.getName());
        this.tankerService.addTanker(tanker);
        log.info("tanker added {}", tanker.getName());
        return ResponseEntity.status(201).body(tanker);
    }

}