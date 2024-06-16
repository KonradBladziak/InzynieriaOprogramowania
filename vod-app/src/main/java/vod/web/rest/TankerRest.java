package vod.web.rest;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import vod.model.Tanker;
import vod.model.Tank;
import vod.service.TankService;
import vod.service.TankerService;

import java.util.List;
import java.util.Locale;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/webapi")
public class TankerRest {

    private final TankerService tankerService;
    private final TankService tankService;
    private final MessageSource messageSource;
    private final LocaleResolver localeResolver;
    private final TankerValidator tankerValidator;

    @InitBinder
    void initBinder(WebDataBinder binder) {
        //binder.setValidator(tankerValidator);
        binder.addValidators(tankerValidator);
    }

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
    ResponseEntity<?> addTanker(@Validated @RequestBody Tanker tanker, Errors errors, HttpServletRequest request){
        log.info("about to add tanker {}", tanker.getName());

        if(errors.hasErrors()){
            Locale locale = localeResolver.resolveLocale(request);
            String errorMessage = errors.getAllErrors().stream()
                    .map(oe -> messageSource.getMessage(oe.getCode(), new Object[0], locale))
                    .reduce("errors:\n", (accu, oe)->accu+oe + "\n");
            System.out.println(errorMessage);
            return ResponseEntity.badRequest().body(errorMessage);
        }

        this.tankerService.addTanker(tanker);
        log.info("tanker added {}", tanker.getName());
        return ResponseEntity.status(201).body(tanker);
    }

}