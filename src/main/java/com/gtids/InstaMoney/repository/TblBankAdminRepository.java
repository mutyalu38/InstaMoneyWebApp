package com.gtids.InstaMoney.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gtids.InstaMoney.model.TblBankAdmin;

@Repository
public interface TblBankAdminRepository extends JpaRepository<TblBankAdmin, Integer> {

	/*
	 * @Query("SELECT t.title FROM Todo t where t.id = :id") String
	 * findTitleById(@Param("id") Long id);
	 */

	@Query(value = "SELECT * from tblbankadmin where UserName=?1 ", nativeQuery = true)
	TblBankAdmin findUserByName(String userName);

	/*
	 * @Query(value =
	 * "SELECT * from tblbankadmin where UserName=?1 and password =?2", nativeQuery
	 * = true) TblBankAdmin findUserByNameAndPwd(String userName, String password);
	 */

}
