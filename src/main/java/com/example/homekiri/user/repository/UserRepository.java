package com.example.homekiri.user.repository;

import com.example.homekiri.user.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.Member;

@Repository
public class UserRepository{

    @PersistenceContext
    private EntityManager em;

    public void save(User user){
        em.persist(user);
    }

    public Member findUser(Long userIdx){
        return em.find(Member.class, userIdx);
    }


}
