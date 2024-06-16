package vod.web.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import vod.model.Tank;
import vod.model.Tanker;
import vod.service.TankService;
import vod.service.TankerService;
import vod.web.rest.dto.TankDTO;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/webapi")
public class TankRest {
    private final TankerService tankerService;
    private final TankService tankService;
    private final MessageSource messageSource;
    private final LocaleResolver localeResolver;

    @GetMapping("/tanks")
    List<Tank> getTanks(){
        log.info("about to retrieve tanks list");
        List<Tank>tanks = tankService.getAllTanks();
        log.info("{} tanks found", tanks.size());
        return tanks;
    }

    @GetMapping("/tanks/{id}")
    ResponseEntity<Tank>getTank(@PathVariable int id){
        log.info("about to retrieve tank with id {}", id);
        Tank tank = tankService.getTankById(id);
        log.info("{} tank found", tank);
        if(tank == null){
            return  ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(tank);
    }

    @GetMapping("/tankers/{id}/tanks")
    ResponseEntity<List<Tank>> getThanksUsedByTanker(@PathVariable int id){
        log.info("about to retrieve tanks used by Tanker");
        Tanker tanker = tankerService.getTankerById(id);
        if(tanker == null){
            return  ResponseEntity.notFound().build();
        }
        List<Tank>tanks = tankService.getTanksOfTanker(tanker);
        log.info("{} tanks found", tanks.size());
        return ResponseEntity.ok().body(tanks);
    }

    @PostMapping("/tanks/create-tank")
    ResponseEntity<?>addTank(@RequestBody TankDTO tankDTO){
        log.info("about to add tank {}", tankDTO);
        Tank tank = new Tank();
        tank.setTankers(tankDTO.getTankers());
        tank.setPlatoon(tankDTO.getPlatoon());
        tank.setName(tankDTO.getName());
        tank = tankService.addTank(tank);
        log.info("{} tank added", tank);
        return ResponseEntity
                .created(
                        ServletUriComponentsBuilder
                                .fromCurrentRequestUri()
                                .path("/" + tank.getId())
                                .build()
                                .toUri()
                ).body(tank);
    }
}
