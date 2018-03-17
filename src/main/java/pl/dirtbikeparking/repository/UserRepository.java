package pl.dirtbikeparking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pl.dirtbikeparking.entity.Notice;
import pl.dirtbikeparking.entity.User;


public interface UserRepository extends JpaRepository<User, Integer> {

	User findOneByEmail(String email);

	User findById(int id);
	
}


