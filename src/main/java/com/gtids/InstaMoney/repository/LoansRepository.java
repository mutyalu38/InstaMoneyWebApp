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

	@Query(value = "SELECT * from loans where date(PostingDate)> date(NOW() - INTERVAL 7 DAY) and date(PostingDate) <= CURDATE() ", nativeQuery = true)
	List<Loans> findSevenDaysLoanApp();

	@Query(value = "SELECT count(*) from loans where date(PostingDate) = CURDATE() ", nativeQuery = true)
	int findCurrentDateLoanAppCount();

	@Query(value = "SELECT count(*) from loans where date(PostingDate)> date(NOW() - INTERVAL 7 DAY) and date(PostingDate) <= CURDATE() ", nativeQuery = true)
	int findSevenDaysLoanAppCount();

	@Query(value = "SELECT  NearestAPGVBBank, count(NearestAPGVBBank) as countOfAPGVBBank FROM loans   GROUP BY NearestAPGVBBank order by countOfAPGVBBank DESC limit 7 ", nativeQuery = true)
	List<Loans> findTopSevenNearestAPGVBBank();

	@Query(value = "SELECT  NearestAPGVBBank, count(NearestAPGVBBank) as countOfAPGVBBank FROM loans   GROUP BY NearestAPGVBBank order by countOfAPGVBBank DESC ", nativeQuery = true)
	List<Loans> findAllNearestAPGVBBank();

	@Query(value = "SELECT beneficiary_lineofactivity, count(beneficiary_lineofactivity) as countOfBeneficiary_lineofactivity FROM loans GROUP BY beneficiary_lineofactivity order by countOfBeneficiary_lineofactivity desc limit 7 ", nativeQuery = true)
	List<Loans> findTopSevenCustomerOccupation();

	@Query(value = "SELECT beneficiary_lineofactivity, count(beneficiary_lineofactivity) as countOfBeneficiary_lineofactivity FROM loans GROUP BY beneficiary_lineofactivity order by countOfBeneficiary_lineofactivity desc ", nativeQuery = true)
	List<Loans> findAllCustomerOccupation();

}
