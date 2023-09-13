package me.student.system.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@Validated
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAuthority('user:write')")
    public void add(@RequestBody User user) {
        service.add(user);
    }


    @DeleteMapping("/remove")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('user:write')")
    public void remove(@RequestParam(value = "id") Integer id) {
        service.remove(id);
    }


    @GetMapping("/grades")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('user:write')")
    public double[] getGrades(@RequestParam(value = "id") Integer id) {
        return service.getGrades(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('user:read')")

    public Page<UserDTO> findAll(
      @RequestParam(name = "page", defaultValue = "0") int page,
      @RequestParam(name = "size", defaultValue = "10") int size,
      @RequestParam(name = "sort", defaultValue = "id") String sort) {

        PageRequest pageable = PageRequest.of(page, size, Sort.by(sort));
        return service.findAll(pageable);
    }

    @GetMapping("/id")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('user:read')")
    public UserDTO getUser(@RequestParam("id") int id) {
        return service.findByID(id);
    }


}
