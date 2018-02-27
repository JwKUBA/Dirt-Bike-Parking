package pl.dirtbikeparking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.dirtbikeparking.entity.User;


public interface UserRepository extends JpaRepository<User, Integer> {

	User findOneByEmail(String email);

	User findById(int id);
	
}