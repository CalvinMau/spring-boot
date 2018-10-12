package com.auth.security.dao;

import com.auth.security.bean.PersonnelBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * The interface User dao.
 *
 * @ClassName UserDao
 * @Description TODO
 * @Author Calvin
 * @Date 10 /12/18
 * @Version 1.0
 */
@Repository
@Transactional(rollbackFor = Exception.class)
public interface PersonnelDao extends JpaRepository <PersonnelBean,Integer>{

    /**
     * Find one by uname user do.
     *
     * @param username the username
     * @return the user do
     */
//    @Query("FROM PersonnelBean U  WHERE U.username = :username")
//    PersonnelBean findOneByUsernamesername(@Param("username") String username);
    PersonnelBean findOneByUsername(String username);
}
