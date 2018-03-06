package pl.dirtbikeparking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import pl.dirtbikeparking.entity.Notice;



	public interface NoticeRepository extends JpaRepository<Notice, Integer> {
		
		@Query(value = "SELECT * FROM notice WHERE brand=?1", nativeQuery = true)
		public List<Notice> findBrand(String brand);

	
	}

