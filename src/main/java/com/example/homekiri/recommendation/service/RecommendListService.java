package com.example.homekiri.recommendation.service;

import com.example.homekiri.config.BaseException;
import com.example.homekiri.config.BaseResponseStatus;
import com.example.homekiri.dashboard.Dto.DessertTrendListResponseDto;
import com.example.homekiri.dashboard.Dto.MediaTrendListResponseDto;
import com.example.homekiri.recommendation.Dto.activity.DessertActivityResponseDto;
import com.example.homekiri.recommendation.Dto.activity.FoodActivityResponseDto;
import com.example.homekiri.recommendation.Dto.activity.MediaActivityResponseDto;
import com.example.homekiri.recommendation.Dto.activity.WorkoutActivityResponseDto;
import com.example.homekiri.recommendation.model.activity.DessertActivity;
import com.example.homekiri.recommendation.model.activity.FoodActivity;
import com.example.homekiri.recommendation.model.activity.Info.DessertImage;
import com.example.homekiri.recommendation.model.activity.Info.Drink;
import com.example.homekiri.recommendation.model.activity.Info.FoodImage;
import com.example.homekiri.recommendation.model.activity.Info.NonDrink;
import com.example.homekiri.recommendation.model.activity.MediaActivity;
import com.example.homekiri.recommendation.model.activity.WorkoutActivity;
import com.example.homekiri.recommendation.model.preferences.DessertPreference;
import com.example.homekiri.recommendation.model.preferences.FoodPreference;
import com.example.homekiri.recommendation.model.preferences.MediaPreference;
import com.example.homekiri.recommendation.model.preferences.WorkoutPreference;
import com.example.homekiri.recommendation.repository.ActivitySpecifics.DessertImageRepository;
import com.example.homekiri.recommendation.repository.ActivitySpecifics.DrinkRepository;
import com.example.homekiri.recommendation.repository.ActivitySpecifics.FoodImgRepository;
import com.example.homekiri.recommendation.repository.ActivitySpecifics.nonDrinkRepository;
import com.example.homekiri.recommendation.repository.DessertRecommendListRepository;
import com.example.homekiri.recommendation.repository.FoodRecommendListRepository;
import com.example.homekiri.recommendation.repository.MediaRecommendListRepository;
import com.example.homekiri.recommendation.repository.WorkoutRecommendListRepository;

import com.example.homekiri.recommendation.repository.preference.DessertPreferenceRepository;
import com.example.homekiri.recommendation.repository.preference.FoodPreferenceRepository;
import com.example.homekiri.recommendation.repository.preference.MediaPreferenceRepository;
import com.example.homekiri.recommendation.repository.preference.WorkoutPreferenceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class RecommendListService {
    //Preference Repo
    private final DessertPreferenceRepository dessertPreferenceRepository;
    private final FoodPreferenceRepository foodPreferenceRepository;
    private final MediaPreferenceRepository mediaPreferenceRepository;
    private final WorkoutPreferenceRepository workoutPreferenceRepository;


    //Activity Info
    private final DessertImageRepository dessertImageRepository;
    private final DrinkRepository drinkRepository;
    private final nonDrinkRepository nonDrinkRepository;
    private final FoodImgRepository foodImgRepository;

    //Activity Repo
    private final DessertRecommendListRepository dessertRecommendListRepository;
    private final FoodRecommendListRepository foodRecommendListRepository;
    private final MediaRecommendListRepository mediaRecommendListRepository;
    private final WorkoutRecommendListRepository workoutRecommendListRepository;


    @Transactional
    public HashMap<String, Object> recommend(Long UserIdx) throws BaseException {
        //UserIdx Preference
        DessertPreference dessertPreference = dessertPreferenceRepository.findById(UserIdx).orElseThrow(()->new BaseException(BaseResponseStatus.INVALID_USER_IDX));
        FoodPreference foodPreference = foodPreferenceRepository.findById(UserIdx).orElseThrow(()->new BaseException(BaseResponseStatus.INVALID_USER_IDX));
        MediaPreference mediaPreference = mediaPreferenceRepository.findById(UserIdx).orElseThrow(()->new BaseException(BaseResponseStatus.INVALID_USER_IDX));
        WorkoutPreference workoutPreference = workoutPreferenceRepository.findById(UserIdx).orElseThrow(()->new BaseException(BaseResponseStatus.INVALID_USER_IDX));


        List<MediaActivityResponseDto> TempMediaList = new ArrayList<>();
        List<FoodActivityResponseDto> TempFoodList = new ArrayList<>();
        List<DessertActivityResponseDto> TempDessertList = new ArrayList<>();
        List<WorkoutActivityResponseDto> TempWorkoutList = new ArrayList<>();

        int RECOMMEND_SIZE = 8;
        int RECOMMEND_SCORE = 70;
        /**
         * Food Preference
         */
        //소고기 선호도
        if(foodPreference.getBeef() >= RECOMMEND_SCORE){
            List<FoodActivity> res = foodRecommendListRepository.findFoodActivitiesByIngredient("소고기");
            for(int i = 0; i <res.size(); ++i){
                FoodActivity res1 = foodRecommendListRepository.findById(res.get(i).getIdx()).orElseThrow(()->new BaseException(BaseResponseStatus.ACTIVITY_IDX_ERROR));
                FoodImage res2 = foodImgRepository.findFoodImageByFoodIdx(res.get(i).getIdx());
                FoodActivityResponseDto temp = new FoodActivityResponseDto(res1, res2);
                TempFoodList.add(temp);
            }
        }
        //치킨 선호도
        if(foodPreference.getChicken()>=RECOMMEND_SCORE){
            List<FoodActivity> res = foodRecommendListRepository.findFoodActivitiesByIngredient("닭고기");
            for(int i = 0; i < res.size(); ++i){
                FoodActivity res1 = foodRecommendListRepository.findById(res.get(i).getIdx()).orElseThrow(()->new BaseException(BaseResponseStatus.ACTIVITY_IDX_ERROR));
                FoodImage res2 = foodImgRepository.findFoodImageByFoodIdx(res.get(i).getIdx());
                FoodActivityResponseDto temp = new FoodActivityResponseDto(res1, res2);
                TempFoodList.add(temp);
            }
        }
        //돼지고기 선호도
        if(foodPreference.getPork()>=RECOMMEND_SCORE){
            List<FoodActivity> res = foodRecommendListRepository.findFoodActivitiesByIngredient("돼지고기");
            for(int i = 0; i < res.size(); ++i){
                FoodActivity res1 = foodRecommendListRepository.findById(res.get(i).getIdx()).orElseThrow(()->new BaseException(BaseResponseStatus.ACTIVITY_IDX_ERROR));
                FoodImage res2 = foodImgRepository.findFoodImageByFoodIdx(res.get(i).getIdx());
                FoodActivityResponseDto temp = new FoodActivityResponseDto(res1, res2);
                TempFoodList.add(temp);
            }
        }
        //돼지고기 선호도
        if(foodPreference.getPork()>=RECOMMEND_SCORE){
            List<FoodActivity> res = foodRecommendListRepository.findFoodActivitiesByIngredient("돼지고기");
            for(int i = 0; i < res.size(); ++i){
                FoodActivity res1 = foodRecommendListRepository.findById(res.get(i).getIdx()).orElseThrow(()->new BaseException(BaseResponseStatus.ACTIVITY_IDX_ERROR));
                FoodImage res2 = foodImgRepository.findFoodImageByFoodIdx(res.get(i).getIdx());
                FoodActivityResponseDto temp = new FoodActivityResponseDto(res1, res2);
                TempFoodList.add(temp);
            }
        }
        //돼지고기 선호도
        if(foodPreference.getPork()>=RECOMMEND_SCORE){
            List<FoodActivity> res = foodRecommendListRepository.findFoodActivitiesByIngredient("돼지고기");
            for(int i = 0; i < res.size(); ++i){
                FoodActivity res1 = foodRecommendListRepository.findById(res.get(i).getIdx()).orElseThrow(()->new BaseException(BaseResponseStatus.ACTIVITY_IDX_ERROR));
                FoodImage res2 = foodImgRepository.findFoodImageByFoodIdx(res.get(i).getIdx());
                FoodActivityResponseDto temp = new FoodActivityResponseDto(res1, res2);
                TempFoodList.add(temp);
            }
        }
        //한국음식 선호도
        if(foodPreference.getKorea()>=RECOMMEND_SCORE){
            List<FoodActivity> res = foodRecommendListRepository.findFoodActivitiesByCountryIdx(1L);
            for(int i = 0; i < res.size(); ++i){
                FoodActivity res1 = foodRecommendListRepository.findById(res.get(i).getIdx()).orElseThrow(()->new BaseException(BaseResponseStatus.ACTIVITY_IDX_ERROR));

            }
        }


        /**
         * Media Preference
         */

        /**
         *Dessert Preference
         */
        //카페인 선호도
        if(dessertPreference.getCoffee() >= RECOMMEND_SCORE) {
            List<Drink> res = drinkRepository.findDrinksByCaffeine("Y");
            for(int i = 0; i < res.size(); ++i){
                DessertActivity res1 = dessertRecommendListRepository.findById( res.get(i).getIdx()).orElseThrow(()->new BaseException(BaseResponseStatus.ACTIVITY_IDX_ERROR));
                DessertImage res2 = dessertImageRepository.findDessertImageByDessertIdx(res.get(i).getIdx());
                DessertActivityResponseDto temp = new DessertActivityResponseDto(res1, res2);
                TempDessertList.add(temp);
                }
        }
        //베이커리 선호도
        if(dessertPreference.getBakery() >= RECOMMEND_SCORE){
            List<NonDrink> res = nonDrinkRepository.findAll();
            for(int i = 0; i <res.size(); ++i){
                DessertActivity res1 = dessertRecommendListRepository.findById(res.get(i).getIdx()).orElseThrow(()->new BaseException(BaseResponseStatus.ACTIVITY_IDX_ERROR));
                DessertImage res2 = dessertImageRepository.findDessertImageByDessertIdx(res.get(i).getIdx());
                DessertActivityResponseDto temp = new DessertActivityResponseDto(res1, res2);
                TempDessertList.add(temp);
            }
        }
        //단거 선호도
        if(dessertPreference.getSweet() >= RECOMMEND_SCORE){
            List<Drink> res = drinkRepository.findDrinksByFlavor("단");
            for(int i = 0; i <Math.min(res.size(), RECOMMEND_SIZE); ++i){
                DessertActivity res1 = dessertRecommendListRepository.findById( res.get(i).getIdx()).orElseThrow(()->new BaseException(BaseResponseStatus.ACTIVITY_IDX_ERROR));
                DessertImage res2 = dessertImageRepository.findDessertImageByDessertIdx(res.get(i).getIdx());
                DessertActivityResponseDto temp = new DessertActivityResponseDto(res1, res2);
                TempDessertList.add(temp);
            }
        }
        //신거 선호도
        if(dessertPreference.getSour() >= RECOMMEND_SCORE){
            List<Drink> res = drinkRepository.findDrinksByFlavor("쓴");
            for(int i = 0; i <Math.min(res.size(), RECOMMEND_SIZE); ++i){
                DessertActivity res1 = dessertRecommendListRepository.findById( res.get(i).getIdx()).orElseThrow(()->new BaseException(BaseResponseStatus.ACTIVITY_IDX_ERROR));
                DessertImage res2 = dessertImageRepository.findDessertImageByDessertIdx(res.get(i).getIdx());
                DessertActivityResponseDto temp = new DessertActivityResponseDto(res1, res2);
                TempDessertList.add(temp);
            }
        }
        //쓴거 선호도
        if(dessertPreference.getBitter() >= RECOMMEND_SCORE){
            List<Drink> res = drinkRepository.findDrinksByFlavor("신");
            for(int i = 0; i <Math.min(res.size(), RECOMMEND_SIZE); ++i){
                DessertActivity res1 = dessertRecommendListRepository.findById( res.get(i).getIdx()).orElseThrow(()->new BaseException(BaseResponseStatus.ACTIVITY_IDX_ERROR));
                DessertImage res2 = dessertImageRepository.findDessertImageByDessertIdx(res.get(i).getIdx());
                DessertActivityResponseDto temp = new DessertActivityResponseDto(res1, res2);
                TempDessertList.add(temp);
            }
        }
        //찬거 선호도
        if(dessertPreference.getCold() >= RECOMMEND_SCORE){
            List<Drink> res = drinkRepository.findDrinksByTemperatureContains("ICE");
            for(int i = 0; i <Math.min(res.size(), RECOMMEND_SIZE); ++i){
                DessertActivity res1 = dessertRecommendListRepository.findById( res.get(i).getIdx()).orElseThrow(()->new BaseException(BaseResponseStatus.ACTIVITY_IDX_ERROR));
                DessertImage res2 = dessertImageRepository.findDessertImageByDessertIdx(res.get(i).getIdx());
                DessertActivityResponseDto temp = new DessertActivityResponseDto(res1, res2);
                TempDessertList.add(temp);
            }
        }
        //뜨거운거 선호도
        if(dessertPreference.getHot() >= RECOMMEND_SCORE){
            List<Drink> res = drinkRepository.findDrinksByTemperatureContains("HOT");
            for(int i = 0; i <Math.min(res.size(), RECOMMEND_SIZE); ++i){
                DessertActivity res1 = dessertRecommendListRepository.findById( res.get(i).getIdx()).orElseThrow(()->new BaseException(BaseResponseStatus.ACTIVITY_IDX_ERROR));
                DessertImage res2 = dessertImageRepository.findDessertImageByDessertIdx(res.get(i).getIdx());
                DessertActivityResponseDto temp = new DessertActivityResponseDto(res1, res2);
                TempDessertList.add(temp);
            }
        }
        //스무디 선호도
        if(dessertPreference.getSmoothie() >= RECOMMEND_SCORE){
            List<Drink> res = drinkRepository.findDrinksByDrinkNameContains("스무디");
            for(int i = 0; i <Math.min(res.size(), RECOMMEND_SIZE); ++i){
                DessertActivity res1 = dessertRecommendListRepository.findById( res.get(i).getIdx()).orElseThrow(()->new BaseException(BaseResponseStatus.ACTIVITY_IDX_ERROR));
                DessertImage res2 = dessertImageRepository.findDessertImageByDessertIdx(res.get(i).getIdx());
                DessertActivityResponseDto temp = new DessertActivityResponseDto(res1, res2);
                TempDessertList.add(temp);
            }
        }
        //티 선호도
        if(dessertPreference.getTea() >= RECOMMEND_SCORE){
            List<Drink> res = drinkRepository.findDrinksByDrinkNameContainsOrDrinkNameContains("차", "티");
            for(int i = 0; i <Math.min(res.size(), RECOMMEND_SIZE); ++i){
                DessertActivity res1 = dessertRecommendListRepository.findById( res.get(i).getIdx()).orElseThrow(()->new BaseException(BaseResponseStatus.ACTIVITY_IDX_ERROR));
                DessertImage res2 = dessertImageRepository.findDessertImageByDessertIdx(res.get(i).getIdx());
                DessertActivityResponseDto temp = new DessertActivityResponseDto(res1, res2);
                TempDessertList.add(temp);
            }
        }
        //과일류 선호도

        /**
         * Workout Preference
         */

        if(TempMediaList.size() < 8  || TempFoodList.size() < 8 || TempDessertList.size() < 8 || TempWorkoutList.size() < 8)
            throw new BaseException(BaseResponseStatus.PREFERENCE_LACK_ERROR);


        Collections.shuffle(TempMediaList);
        Collections.shuffle(TempFoodList);
        Collections.shuffle(TempDessertList);
        Collections.shuffle(TempWorkoutList);


        List<MediaActivityResponseDto> mediaActivities = new ArrayList<>();
        List<FoodActivityResponseDto> foodActivities = new ArrayList<>();
        List<DessertActivityResponseDto> dessertActivities = new ArrayList<>();
        List<WorkoutActivityResponseDto> workoutActivities = new ArrayList<>();


        for(int i = 0; i <RECOMMEND_SIZE; ++i){
            mediaActivities.add(TempMediaList.get(i));
            foodActivities.add(TempFoodList.get(i));
            dessertActivities.add(TempDessertList.get(i));
            workoutActivities.add(TempWorkoutList.get(i));
        }

        HashMap<String, Object> map = new HashMap<String, Object>();

        map.put("media", mediaActivities);
        map.put("food", foodActivities);
        map.put("dessert", dessertActivities);
        map.put("workout", workoutActivities);
        return map;
    }
}
