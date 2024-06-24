package vod.web.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

@ControllerAdvice
@RequiredArgsConstructor
public class VodAdvice {
    private final TankerValidator tankerValidator;

    @InitBinder
    void initBinder(WebDataBinder binder) {
        binder.setValidator(tankerValidator);
    }
}
