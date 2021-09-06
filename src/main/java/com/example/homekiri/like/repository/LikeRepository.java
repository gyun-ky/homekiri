package com.example.homekiri.like.repository;

import com.example.homekiri.like.dto.LikeFoodDto;
import com.example.homekiri.like.model.LikeFood;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class LikeRepository {
    @PersistenceContext
    private EntityManager em;

    public Long saveLikeFood(LikeFood likeFood){
        em.persist(likeFood);
        em.flush();
        return likeFood.getIdx();
    }

    /**
     마이페이지 - 좋아한 Food List
     @param Long userIdx
     @return List<LikeFoodDto>
     */
    public List<LikeFoodDto> findLikeFoodByUserIdx(Long userIdx){
        List<Object[]> queryResult = em.createQuery("SELECT l.food.idx, l.food.foodName, l.food.country.countryName, MAX(l.food.foodImages) FROM LikeFood l WHERE l.user.idx = :userIdx order by l.createdAt DESC")
                .setParameter("userIdx", userIdx).getResultList();

        List<LikeFoodDto> result = new ArrayList<>();
        for(Object[] row : queryResult){
            result.add(new LikeFoodDto((Long)row[0], (String)row[1], (String)row[2], (String)row[3]));
        }
        return result;
    }
}
