package pl.dirtbikeparking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import pl.dirtbikeparking.entity.Notice;
import pl.dirtbikeparking.entity.ToObserve;
import pl.dirtbikeparking.entity.User;


	public interface ToObserveRepository extends JpaRepository<ToObserve, Integer> {
		
		
		List<ToObserve> findAllBytoObserve(User toObserve);
		
		ToObserve  findByNotice(Notice notice); 

	}