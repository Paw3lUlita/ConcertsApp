package pl.coderslab.concertsapp.service;

import org.springframework.stereotype.Service;
import pl.coderslab.concertsapp.entity.Role;
import pl.coderslab.concertsapp.repository.RoleRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }


    @Override
    @Transactional
    public List<Role> findAllRoles() {
        return roleRepository.findAll();
    }
}
