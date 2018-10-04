package com.springsecuritycourse.dao;

import com.springsecuritycourse.domain.VerificationToken;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;

/**
 * Created by Dégi János on 2017.10.08..
 */
@Repository
public class VerificationDao extends AbstractJpaDao<VerificationToken> implements IVerificationDao {

    public VerificationDao() {
        setClazz(VerificationToken.class);
    }


//    public VerificationToken findByToken(String token) {
//
//        Query query = entityManager.createQuery("select vtoken from com.springsecuritycourse.domain.VerificationToken vtoken" +
//                " where vtoken.token = :token");
//        query.setParameter("token", token);
//        VerificationToken vToken = (VerificationToken) query.getSingleResult();
//        return vToken;
//    }


}
