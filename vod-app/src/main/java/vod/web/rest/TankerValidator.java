package vod.web.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import vod.model.Tanker;
import vod.service.TankerService;

@Component
@RequiredArgsConstructor
public class TankerValidator implements Validator{

    private final TankerService tankerService;

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(Tanker.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Tanker validatedTanker = (Tanker) target;
        boolean duplicated = tankerService.getAllTankers().stream()
                .anyMatch(tanker -> tanker.getName().equalsIgnoreCase(validatedTanker.getName()));
        if (duplicated) {
            errors.rejectValue("name", "tanker.name.duplicated");
        }
    }
}
