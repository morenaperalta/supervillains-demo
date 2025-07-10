package com.example.demo.power;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/power")
public class PowerController {
    private final PowerService POWER_SERVICE;

    public PowerController(PowerService powerService) {
        POWER_SERVICE = powerService;
    }

    @GetMapping("")
    public ResponseEntity<List<PowerResponse>> getAllPowers() {
        List<PowerResponse> powerResponseList = POWER_SERVICE.getAllPowers();
        return new ResponseEntity<>(powerResponseList, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<PowerResponse> createPower(@Valid @RequestBody PowerRequest powerRequest) {
        PowerResponse powerResponse= POWER_SERVICE.savePower(powerRequest);
        return new ResponseEntity<>(powerResponse, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PowerResponse> getPowerById(@PathVariable Long id){
        PowerResponse powerResponse = POWER_SERVICE.getPowerResponseById(id);
        return new ResponseEntity<>(powerResponse, HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<PowerResponse> getPowerByName(@PathVariable String name) {
        Power power = POWER_SERVICE.getPowerByName(name);
        PowerResponse powerResponse = PowerMapper.toDto(power);
        return new ResponseEntity<>(powerResponse, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PowerResponse> updatePower (@PathVariable Long id, @Valid @RequestBody PowerRequest powerRequest) {
        PowerResponse powerResponse= POWER_SERVICE.updatePower(id, powerRequest);
        return new ResponseEntity<>(powerResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePower(@PathVariable Long id) {
        POWER_SERVICE.deletePower(id);
        return new ResponseEntity<>( "Power deleted successfully", HttpStatus.OK);
    }

}
