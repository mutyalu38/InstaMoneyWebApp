package com.gtids.InstaMoney.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gtids.InstaMoney.model.Loans;
import com.gtids.InstaMoney.model.LoansDTO;

@Repository
public interface LoansDTORepository extends CrudRepository<Loans, Long> {
	@Query(nativeQuery = true, value =
			"SELECT NearestAPGVBBank, count(NearestAPGVBBank) as countOfAPGVBBank  FROM  loans GROUP BY NearestAPGVBBank order by countOfAPGVBBank DESC limit 0,7 ")
	List<LoansDTO> findTopSevenNearestAPGVBBank();

	
		@Query(nativeQuery = true, value =
			"SELECT NearestAPGVBBank, count(NearestAPGVBBank) as countOfAPGVBBank  FROM  loans GROUP BY NearestAPGVBBank order by countOfAPGVBBank DESC  ")
	List<LoansDTO> findAllNearestAPGVBBank();
	
	
}