package vod.web.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import vod.model.Tanker;
import vod.service.TankerService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class TankerRest {

    private final TankerService tankerService;

    @GetMapping("/tankers")
    List<Tanker> getTankers(){
        log.info("about to retrieve tankers list");
        List<Tanker> tankers = tankerService.getAllTankers();
        log.info("{} tankers found", tankers.size());
        return tankers;
    }
}