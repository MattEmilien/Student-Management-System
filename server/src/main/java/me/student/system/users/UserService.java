package me.student.system.users;

import me.student.system.exception.DuplicateEntryException;
import me.student.system.exception.NoSuchUserException;
import me.student.system.security.role.UserRole;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import javax.validation.Valid;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public void add(@Valid User user) {
        if (repository.existsByEmail(user.getEmail())) {
            throw new DuplicateEntryException("Email " + user.getEmail() + " is already taken");
        }
        user.setRole(UserRole.STUDENT);
        repository.save(user);
    }

    public void remove(@Valid Integer id) {
        if (!repository.existsById(id)) {
            throw new NoSuchUserException("User with ID " + id + " not found");
        }

        repository.deleteById(id);
    }

    public double[] getGrades(Integer id) {
        var user = repository.findById(id).
          orElseThrow(() -> new NoSuchUserException("User by the ID of " + id + " was not found!"));
        return user.getGrades();
    }


    public Page<UserDTO> findAll(Pageable pageable) {
        Page<User> users = repository.findAll(pageable);

        return users.map(UserDTO::new);
    }

    public User findByFirstName(String name) {
        return repository.findByFirstName(name).
          orElseThrow(() -> new NoSuchUserException("User by the first name of " + name + " was not found!"));
    }

    public User findByLastName(String name) {
        return repository.findByLastName(name).
          orElseThrow(() -> new NoSuchUserException("User by the last name of " + name + " was not found!"));
    }

    public UserDTO findByID(Integer id) {
        return repository.findById(id).map(UserDTO::new).
          orElseThrow(() -> new NoSuchUserException("User by the ID of " + id + " was not found!"));
    }

    public void update(Integer id, @Valid User updatedUser) {
        User existingUser = repository.findById(id)
          .orElseThrow(() -> new NoSuchUserException("User with ID " + id + " not found"));

        // Copy props from updatedUser to existingUser
        BeanUtils.copyProperties(updatedUser, existingUser, "id");

        repository.save(existingUser);
    }

}
