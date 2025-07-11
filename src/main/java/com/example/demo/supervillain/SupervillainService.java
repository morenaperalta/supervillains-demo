package com.example.demo.supervillain;

import com.example.demo.exception.EntityAlreadyExistsException;
import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.power.Power;
import com.example.demo.power.PowerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class SupervillainService {

    private final SupervillainRepository SUPER_VILLAIN_REPOSITORY;
    private final PowerService POWER_SERVICE;

    public SupervillainService(SupervillainRepository supervillainRepository, PowerService powerService) {
        this.SUPER_VILLAIN_REPOSITORY = supervillainRepository;
        this.POWER_SERVICE = powerService;
    }

    public List<SupervillainResponse> getAllSupervillains() {
        return SUPER_VILLAIN_REPOSITORY.findAll()
                .stream()
                .map(SupervillainMapper::toDto)
                .toList();
    }

    public Supervillain getSupervillainById(Long id) {
        return SUPER_VILLAIN_REPOSITORY.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Supervillain.class.getSimpleName(), "id", id.toString()));
    }

    public SupervillainResponse getSupervillainResponseById(Long id) {
        Supervillain supervillain = getSupervillainById(id);
        return SupervillainMapper.toDto(supervillain);
    }

    // private void checkForDuplicateName(String name, Long id) {
    //     if (SUPER_VILLAIN_REPOSITORY.existsByNameIgnoreCaseAndIdNot(name, id)) {
    //         throw new EntityAlreadyExistsException(Supervillain.class.getSimpleName(), "name", name);
    //     }
    // }

    // private void checkForDuplicateAlias(String alias, Long id) {
    //     if (SUPER_VILLAIN_REPOSITORY.existsByAliasIgnoreCaseAndIdNot(alias, id)) {
    //         throw new EntityAlreadyExistsException(Supervillain.class.getSimpleName(), "alias", alias);
    //     }
    // }

    public Supervillain getSupervillainByName(String name) {
        return SUPER_VILLAIN_REPOSITORY.findSupervillainByNameIgnoreCase(name)
                .orElseThrow(() -> new EntityNotFoundException(Supervillain.class.getSimpleName(), "name", name));
    }

    public Supervillain getSupervillainByAlias(String alias) {
        return SUPER_VILLAIN_REPOSITORY.findSupervillainByAliasIgnoreCase(alias)
                .orElseThrow(() -> new EntityNotFoundException(Supervillain.class.getSimpleName(), "alias", alias));
    }

    public SupervillainResponse saveSupervillain(SupervillainRequest supervillainRequest) {
        // validateRequest(supervillainRequest);

        // String name = trimAndValidate(supervillainRequest.name(), "name");
        // String alias = trimAndValidate(supervillainRequest.alias(), "alias");

        // checkForDuplicateName(name);
        // checkForDuplicateAlias(alias);

        List<Power> powers = resolvePowers(supervillainRequest.powersNames());
        Supervillain supervillain = SupervillainMapper.toEntity(supervillainRequest, powers);

        return SupervillainMapper.toDto(SUPER_VILLAIN_REPOSITORY.save(supervillain));
    }

    public SupervillainResponse updateSupervillain(Long id, SupervillainRequest supervillainRequest) {
        Supervillain supervillain = getSupervillainById(id);

        // String newName = trimAndValidate(supervillainRequest.name(), "name");
        // String newAlias = trimAndValidate(supervillainRequest.alias(), "alias");

        // if (!supervillain.getName().equalsIgnoreCase(newName) && !newName.isEmpty()) {
        //     checkForDuplicateName(newName, id);
        // }
        // if (!supervillain.getAlias().equalsIgnoreCase(newAlias) && !newAlias.isEmpty()) {
        //     checkForDuplicateAlias(newAlias, id);
        // }

        supervillain.setName(supervillainRequest.name());
        supervillain.setAlias(supervillainRequest.alias());

        return SupervillainMapper.toDto(SUPER_VILLAIN_REPOSITORY.save(supervillain));
    }

    public void deleteSupervillain(Long id) {
        getSupervillainById(id);
        SUPER_VILLAIN_REPOSITORY.deleteById(id);
    }

    // private void validateRequest(SupervillainRequest supervillainRequest) {
    //     if (supervillainRequest == null) {
    //         throw new IllegalArgumentException("Supervillain request cannot be null");
    //     }
    // }

    // private String trimAndValidate(String value, String fieldName) {
    //     if (value == null || value.trim().isEmpty()) {
    //         throw new IllegalArgumentException(fieldName + " cannot be null or empty");
    //     }
    //     return value.trim();
    // }

    // private void checkForDuplicateName(String name) {
    //     if (SUPER_VILLAIN_REPOSITORY.existsByNameIgnoreCase(name)) {
    //         throw new EntityAlreadyExistsException(Supervillain.class.getSimpleName(), "name", name);
    //     }
    // }

    // private void checkForDuplicateAlias(String alias) {
    //     if (SUPER_VILLAIN_REPOSITORY.existsByAliasIgnoreCase(alias)) {
    //         throw new EntityAlreadyExistsException(Supervillain.class.getSimpleName(), "alias", alias);
    //     }
    // }

    private List<Power> resolvePowers(List<String> names) {
        if (names == null || names.isEmpty()) return List.of();

        return names.stream()
                .filter(Objects::nonNull)
                .map(String::trim)
                .filter(n -> !n.isEmpty())
                .map(POWER_SERVICE::getPowerByName)
                .toList();
    }
}
