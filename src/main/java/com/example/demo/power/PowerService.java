package com.example.demo.power;

import com.example.demo.exception.EntityAlreadyExistsException;
import com.example.demo.exception.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PowerService {
    private final PowerRepository POWER_REPOSITORY;

    public PowerService(PowerRepository powerRepository) {
        POWER_REPOSITORY = powerRepository;
    }

    public List<PowerResponse> getAllPowers() {
        return listToDto(POWER_REPOSITORY.findAll());
    }

    public Power getPowerById(Long id) {
        return POWER_REPOSITORY.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Power.class.getSimpleName(), "id", id.toString()));
    }

    public PowerResponse getPowerResponseById(Long id){
        Power power = getPowerById(id);
        return PowerMapper.toDto(power);
    }

    public Power getPowerByName(String name) {
        return POWER_REPOSITORY.findPowerByNameIgnoreCase(name)
                .orElseThrow(() -> new EntityNotFoundException(Power.class.getSimpleName(), "name", name));
    }

    public PowerResponse savePower(PowerRequest powerRequest) {
        if (POWER_REPOSITORY.existsByNameIgnoreCase(powerRequest.name())) {
            throw new EntityAlreadyExistsException(Power.class.getSimpleName(), "name", powerRequest.name());
        }
        Power power = PowerMapper.toEntity(powerRequest);
        return PowerMapper.toDto(POWER_REPOSITORY.save(power));
    }

    public PowerResponse updatePower(Long id, PowerRequest powerRequest) {
        Power power = getPowerById(id);
        String newName = powerRequest.name().trim();
        String newDescription = powerRequest.description().trim();
        if (!power.getName().equalsIgnoreCase(newName) && !newName.isEmpty()) {
            if (POWER_REPOSITORY.existsByNameIgnoreCase(newName)) {
                throw new EntityAlreadyExistsException(Power.class.getSimpleName(), "name", newName);
            }
        }
        power.setName(newName);
        power.setDescription(newDescription);
        return PowerMapper.toDto(POWER_REPOSITORY.save(power));
    }

    public void deletePower(Long id) {
        getPowerById(id);
        POWER_REPOSITORY.deleteById(id);
    }

    /**
     * Converts a list of Power entities to a list of PowerResponse DTOs.
     * @param powers the list of Power entities
     * @return a list of PowerResponse DTOs
     */
    private List<PowerResponse> listToDto(List<Power> powers) {
        return powers.stream()
                .map( PowerMapper::toDto)
                .toList();
    }

}
