package grupo11.imobiliaria.controller;

import grupo11.imobiliaria.ImobiliariaDTO.ComodoDTO;
import grupo11.imobiliaria.entity.Prop;
import grupo11.imobiliaria.services.ImobiliariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class Controller {

    @Autowired
    private ImobiliariaService service;

    @GetMapping("/area/{nomeDaCasa}")
    public Double area(@PathVariable String nomeDaCasa) {
        return service.area(nomeDaCasa);
    }

    @GetMapping("/valor/{nomeDaCasa}")
    public String valor(@PathVariable String nomeDaCasa) {
        return service.valor(nomeDaCasa);
    }

    @GetMapping("/maiorComodo/{nomeDaCasa}")
    public String maiorComodo(@PathVariable String nomeDaCasa) {
        return service.maiorComodo(nomeDaCasa);
    }

    @GetMapping("/areaComodos/{nomeDaCasa}")
    public List<ComodoDTO> areaComodos(@PathVariable String nomeDaCasa) {
        return service.areaComodos(nomeDaCasa);
    }

    @PostMapping("/prop/")
    public Prop newProperties (@Valid @RequestBody Prop property){

        return property;
    }
}
