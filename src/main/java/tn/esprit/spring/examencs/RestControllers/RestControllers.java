package tn.esprit.spring.examencs.RestControllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.spring.examencs.Services.IServices;

@RestController
@AllArgsConstructor
public class RestControllers {
    IServices iServices;
}
