package com.rsvp.services;

import com.rsvp.entities.Role;
import com.rsvp.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * <h1> Role Service </h1>
 * RoleService contains methods to
 * create, update, delete, and retrieve roles:
 */
@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    /**
     * Creates a new role with the given name and saves it to the database.
     * @param name name to new Role
     * @return new Role
     */
    public Role createRole(String name) {
        Role role = new Role(name);
        return roleRepository.save(role);
    }

    /**
     * Updates an existing role in the database
     * @param role to update
     * @return updated role
     */
    public Role updateRole(Role role) {
        return roleRepository.save(role);
    }

    /**
     * Deletes a role by its ID.
     * @param roleId of the role
     */
    public void deleteRole(Long roleId) {
        roleRepository.deleteById(roleId);
    }

    /**
     * Retrieves a role by its ID
     * @param roleId of the tole
     * @return role with roleId
     */
    public Optional<Role> findRoleById(Long roleId) {
        return roleRepository.findById(roleId);
    }

    /**
     * Retrieves a role by its name (assuming role names are unique).
     * @param name of role
     * @return role with name
     */
    public Optional<Role> findRoleByName(String name) {
        return Optional.ofNullable(roleRepository.findByName(name));
    }

    /**
     * Retrieves a list of all roles
     * @return all roles
     */
    public List<Role> findAllRoles() {
        return roleRepository.findAll();
    }

}
