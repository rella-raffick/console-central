package dev.rellaraffick.consolecentral.services;

import dev.rellaraffick.consolecentral.records.ConsoleCentralRoles;
import dev.rellaraffick.consolecentral.repositories.RolesRepository;

public class RolesService {
    private final RolesRepository rolesRepository;

    public RolesService(RolesRepository rolesRepository) {
        this.rolesRepository = rolesRepository;
    }

    public void getRoles() {
        rolesRepository.findAll();
    }

    public void getRoleById(Integer roleId) {
        rolesRepository.findById(roleId);
    }

    public void createRole(ConsoleCentralRoles role) {
        rolesRepository.save(role);
    }

    public void updateRole(Integer roleId, ConsoleCentralRoles roleDetails) {
        ConsoleCentralRoles existingRole = rolesRepository.findById(roleId)
                .orElseThrow(() -> new RuntimeException("Role not found with id: " + roleId));
        existingRole.setRoleName(roleDetails.getRoleName());
        rolesRepository.save(existingRole);
    }

    public void deleteRole(Integer roleId) {
        rolesRepository.deleteById(roleId);
    }
}
