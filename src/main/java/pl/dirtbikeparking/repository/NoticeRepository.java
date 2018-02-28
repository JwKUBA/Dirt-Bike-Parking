package pl.dirtbikeparking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.dirtbikeparking.entity.Notice;



	public interface NoticeRepository extends JpaRepository<Notice, Integer> {

	
	}

