package com.example.homekiri.like.repository;

import com.example.homekiri.food.model.Country;
import com.example.homekiri.food.model.FoodActivity;
import com.example.homekiri.food.model.FoodImage;
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
        List<Object[]> queryResult = em.createQuery("SELECT l.food, l.food.country, l.user, MAX(fImg.imgUrl) FROM LikeFood l JOIN FETCH l.food.foodImages fImg WHERE l.user.idx = :userIdx order by l.createdAt DESC")
                .setParameter("userIdx", userIdx).getResultList();

        System.out.println("[REPO] findLikeFoodByUserIdx queryResult complete");

        List<LikeFoodDto> result = new ArrayList<>();
        for(Object[] row : queryResult){
            result.add(new LikeFoodDto((FoodActivity) row[0], (Country)row[1]));
        }

        System.out.println("[REPO] findLikeFoodByUserIdx LikeFoodDto convert complete");
        return result;
    }
}
