package com.example.homekiri.user.repository;

import com.example.homekiri.user.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.transaction.TransactionManager;
import java.lang.reflect.Member;
import java.util.List;

@Repository
public class UserRepository{

    @PersistenceContext
    private EntityManager em;

//    private EntityTransaction tx = em.getTransaction();

    public Long save(User user){
        em.persist(user);
        em.flush();
        return user.getIdx();
    }

    public User findUserByIdx(Long userIdx){
        return em.find(User.class, userIdx);
    }

    public User findSingleUserByEmail(String email){
        User result = em.createQuery("select u from User u where u.email = :email", User.class)
                .setParameter("email", email).getSingleResult();
        System.out.println("[JPA] findUserByEmail complete");
        return result;
    }

    public List<User> findByEmail(String email){
        List<User> result = em.createQuery("select u from User u where u.email = :email", User.class)
                .setParameter("email", email).getResultList();
        System.out.println("[JPA] findByEmail complete");
        return result;
    }

    public List<User> findByNickname(String nickname){
        List<User> result = em.createQuery("select u from User u where u.nickName = :nickname", User.class)
                .setParameter("nickname", nickname).getResultList();
        System.out.println("[JPA] findByNickname complete");
        return result;
    }

}
