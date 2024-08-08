package dev.rellaraffick.consolecentral.services;

import dev.rellaraffick.consolecentral.records.ConsoleCentralRoleMapping;
import dev.rellaraffick.consolecentral.repositories.RoleMappingRepository;

public class RoleMappingService {
    private final RoleMappingRepository roleMappingRepository;

    public RoleMappingService(RoleMappingRepository roleMappingRepository) {
        this.roleMappingRepository = roleMappingRepository;
    }

    public void getRoleMapping() {
        roleMappingRepository.findAll();
    }

    public void getRoleMappingById(Integer id) {
        roleMappingRepository.findById(id);
    }

    public void createRoleMapping(ConsoleCentralRoleMapping roleMapping) {
        roleMappingRepository.save(roleMapping);
    }

    public void updateRoleMapping(Integer id, ConsoleCentralRoleMapping roleMapping) {
        ConsoleCentralRoleMapping existingRoleMapping = roleMappingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Role Mapping not found with id: " + id));
        existingRoleMapping.setUser(roleMapping.getUser());
        existingRoleMapping.setRole(roleMapping.getRole());
        roleMappingRepository.save(existingRoleMapping);
    }

    public void deleteRoleMapping(Integer id) {
        roleMappingRepository.deleteById(id);
    }
}
