package grupo11.imobiliaria.controller;

import grupo11.imobiliaria.DTO.RoomDTO;
import grupo11.imobiliaria.entity.Property;
import grupo11.imobiliaria.services.PropertiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class Controller {

    @Autowired
    private PropertiesService service;

    @GetMapping("/area/{nomeDaCasa}")
    public ResponseEntity<Double> area(@PathVariable String nomeDaCasa) {
        return ResponseEntity.status(200).body(service.area(nomeDaCasa));
    }

    @GetMapping("/valor/{nomeDaCasa}")
    public ResponseEntity<String> value(@PathVariable String nomeDaCasa) {
        
        return ResponseEntity.status(200).body(service.value(nomeDaCasa));
    }

    @GetMapping("/maiorComodo/{nomeDaCasa}")
    public ResponseEntity<String> biggestRoom(@PathVariable String nomeDaCasa) {
        return ResponseEntity.status(200).body(service.biggestRoom(nomeDaCasa));
    }

    @GetMapping("/areaComodos/{nomeDaCasa}")
    public ResponseEntity<List<RoomDTO>> roomAreas(@PathVariable String nomeDaCasa) {
        return ResponseEntity.status(200).body(service.roomAreas(nomeDaCasa));
    }

    @PostMapping("/imovel")
    public ResponseEntity<Property> newProperties (@Valid @RequestBody Property property){
        //System.out.println(property);
        service.newProperty(property);
        return ResponseEntity.status(201).body(property);
    }
}
