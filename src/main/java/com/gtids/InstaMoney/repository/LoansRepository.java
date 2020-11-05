package com.gtids.InstaMoney.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gtids.InstaMoney.model.Loans;

@Repository
public interface LoansRepository extends JpaRepository<Loans, Integer> {

	@Query(value = "SELECT * from loans where date(PostingDate) = CURDATE() ", nativeQuery = true)
	List<Loans> findCurrentDateLoanApp();
	
	@Query(value = "SELECT * from loans where NearestAPGVBBank!='hjhjh' AND date(PostingDate)!=CURDATE() ", nativeQuery = true)
	List<Loans> findCurrentDateWithBranchLoanApps();
	
	

	@Query(value = "SELECT * from loans where date(PostingDate)> date(NOW() - INTERVAL 7 DAY) and date(PostingDate) <= CURDATE() ", nativeQuery = true)
	List<Loans> findSevenDaysLoanApp();

	@Query(value = "SELECT count(*) from loans where date(PostingDate) = CURDATE() ", nativeQuery = true)
	int findCurrentDateLoanAppCount();

	@Query(value = "SELECT count(*) from loans where date(PostingDate)> date(NOW() - INTERVAL 7 DAY) and date(PostingDate) <= CURDATE() ", nativeQuery = true)
	int findSevenDaysLoanAppCount();
//	@Query(nativeQuery = true, value="select * from loans  where date(PostingDate) between :fromDate and :toDate")
//	
//	List<Loans> getData_between(@Param("fromDate") LocalDateTime fromDate, @Param("toDate") LocalDateTime toDate);
	//List<Loans> getData_between(LocalDate fromDate, LocalDate toDate);



}
