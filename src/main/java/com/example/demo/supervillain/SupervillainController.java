package com.example.demo.supervillain;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/supervillain")
public class SupervillainController {
    private final SupervillainService SUPERVILLAIN_SERVICE;

    public SupervillainController(SupervillainService supervillainService) {
        SUPERVILLAIN_SERVICE = supervillainService;
    }

    @GetMapping("")
    public ResponseEntity<List<SupervillainResponse>> getAllSupervillains() {
        List<SupervillainResponse> supervillainResponseList = SUPERVILLAIN_SERVICE.getAllSupervillains();
        return new ResponseEntity<>(supervillainResponseList, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<SupervillainResponse> createSupervillain(@Valid @RequestBody SupervillainRequest supervillainRequest) {
        SupervillainResponse supervillainResponse = SUPERVILLAIN_SERVICE.saveSupervillain(supervillainRequest);
        return new ResponseEntity<>(supervillainResponse, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SupervillainResponse> getSupervillainById(@PathVariable Long id) {
        SupervillainResponse supervillainResponse = SUPERVILLAIN_SERVICE.getSupervillainResponseById(id);
        return new ResponseEntity<>(supervillainResponse, HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<SupervillainResponse> getSupervillainByName(@PathVariable String name) {
        Supervillain supervillain = SUPERVILLAIN_SERVICE.getSupervillainByName(name);
        SupervillainResponse supervillainResponse = SupervillainMapper.toDto(supervillain);
        return new ResponseEntity<>(supervillainResponse, HttpStatus.OK);
    }

    @GetMapping("/alias/{alias}")
    public ResponseEntity<SupervillainResponse> getSupervillainByAlias(@PathVariable String alias) {
        Supervillain supervillain = SUPERVILLAIN_SERVICE.getSupervillainByAlias(alias);
        SupervillainResponse supervillainResponse = SupervillainMapper.toDto(supervillain);
        return new ResponseEntity<>(supervillainResponse, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SupervillainResponse> updateSupervillain(
            @PathVariable Long id,
            @Valid @RequestBody SupervillainRequest supervillainRequest) {
        SupervillainResponse supervillainResponse = SUPERVILLAIN_SERVICE.updateSupervillain(id, supervillainRequest);
        return new ResponseEntity<>(supervillainResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSupervillain(@PathVariable Long id) {
        SUPERVILLAIN_SERVICE.deleteSupervillain(id);
        return new ResponseEntity<>("Supervillain deleted successfully", HttpStatus.OK);
    }
}