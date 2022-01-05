package grupo11.imobiliaria.controller;

import grupo11.imobiliaria.DTO.RoomDTO;
import grupo11.imobiliaria.entity.Property;
import grupo11.imobiliaria.services.PropertiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class Controller {

    @Autowired
    private PropertiesService service;

    @GetMapping("/area/{nomeDaCasa}")
    public Double area(@PathVariable String nomeDaCasa) {
        return service.area(nomeDaCasa);
    }

    @GetMapping("/valor/{nomeDaCasa}")
    public String value(@PathVariable String nomeDaCasa) {
        return service.value(nomeDaCasa);
    }

    @GetMapping("/maiorComodo/{nomeDaCasa}")
    public String biggestRoom(@PathVariable String nomeDaCasa) {
        return service.biggestRoom(nomeDaCasa);
    }

    @GetMapping("/areaComodos/{nomeDaCasa}")
    public List<RoomDTO> roomAreas(@PathVariable String nomeDaCasa) {
        return service.roomAreas(nomeDaCasa);
    }

    @PostMapping("/prop/")
    public Property newProperties (@Valid @RequestBody Property property){
        service.newProperty(property);
        return property;
    }
}
