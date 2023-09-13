package me.student.system.users;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Integer> {


  Optional<User> findById(Integer integer);

  Optional<User> findByFirstName(String firstName);

  Optional<User> findByLastName(String lastName);

  boolean existsByEmail(String email);
}
