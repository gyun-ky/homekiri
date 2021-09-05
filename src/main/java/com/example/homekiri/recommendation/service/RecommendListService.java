package com.example.homekiri.recommendation.service;

import com.example.homekiri.config.BaseException;
import com.example.homekiri.config.BaseResponseStatus;
import com.example.homekiri.model.Dessert.Drink;
import com.example.homekiri.model.Dessert.NonDrink;
import com.example.homekiri.recommendation.Dto.ActivityRecommendDto.DessertRecommendDto;
import com.example.homekiri.recommendation.Dto.ActivityRecommendDto.FoodRecommendDto;
import com.example.homekiri.recommendation.Dto.ActivityRecommendDto.MediaRecommendDto;
import com.example.homekiri.recommendation.Dto.ActivityRecommendDto.WorkoutRecommendDto;
import com.example.homekiri.model.Food.FoodActivity;
import com.example.homekiri.model.Media.MediaActivity;
import com.example.homekiri.model.Exersice.WorkoutActivity;
import com.example.homekiri.model.preferences.DessertPreference;
import com.example.homekiri.model.preferences.FoodPreference;
import com.example.homekiri.model.preferences.MediaPreference;
import com.example.homekiri.model.preferences.WorkoutPreference;
import com.example.homekiri.recommendation.repository.ActivitySpecifics.*;
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

@RequiredArgsConstructor
@Service
public class RecommendListService {
    //Preference Repo
    private final DessertPreferenceRepository dessertPreferenceRepository;
    private final FoodPreferenceRepository foodPreferenceRepository;
    private final MediaPreferenceRepository mediaPreferenceRepository;
    private final WorkoutPreferenceRepository workoutPreferenceRepository;


    //Activity Info
    private final DrinkRepository drinkRepository;
    private final nonDrinkRepository nonDrinkRepository;


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


        List<Long> TempMediaList = new ArrayList<>();
        List<Long> TempFoodList = new ArrayList<>();
        List<Long> TempDessertList = new ArrayList<>();
        List<Long> TempWorkoutList = new ArrayList<>();

        int RECOMMEND_SIZE = 8;
        int RECOMMEND_SCORE = 70;

        /*
         * Food Preference
         */
        //소고기 선호도
        if(foodPreference.getBeef() >= RECOMMEND_SCORE){
            List<FoodActivity> res = foodRecommendListRepository.findFoodActivitiesByIngredient("소고기");
            for (FoodActivity re : res) {
                Long idx = re.getIdx();
                if (!TempFoodList.contains(idx))
                    TempFoodList.add(idx);
            }
        }
        //닭고기 선호도
        else if(foodPreference.getChicken()>=RECOMMEND_SCORE){
            List<FoodActivity> res = foodRecommendListRepository.findFoodActivitiesByIngredient("닭고기");
            for (FoodActivity re : res) {
                Long idx = re.getIdx();
                if (!TempFoodList.contains(idx))
                    TempFoodList.add(idx);
            }
        }
        //닭고기 선호도
        else if(foodPreference.getPork()>=RECOMMEND_SCORE){
            List<FoodActivity> res = foodRecommendListRepository.findFoodActivitiesByIngredient("돼지고기");
            for (FoodActivity re : res) {
                Long idx = re.getIdx();
                if (!TempFoodList.contains(idx))
                    TempFoodList.add(idx);
            }
        }

        //면 선호도
        if(foodPreference.getNoodle()>=RECOMMEND_SCORE){
            List<FoodActivity> res = foodRecommendListRepository.findFoodActivitiesByIngredient("면");
            for (FoodActivity re : res) {
                Long idx = re.getIdx();
                if (!TempFoodList.contains(idx))
                    TempFoodList.add(idx);
            }
        }
        //밥 선호도
        if(foodPreference.getRice()>=RECOMMEND_SCORE){
            List<FoodActivity> res = foodRecommendListRepository.findFoodActivitiesByIngredient("밥");
            for (FoodActivity re : res) {
                Long idx = re.getIdx();
                if (!TempFoodList.contains(idx))
                    TempFoodList.add(idx);
            }
        }
        //온도 선호도
        if(foodPreference.getTemperature()>=RECOMMEND_SCORE){
            List<FoodActivity> res = foodRecommendListRepository.findFoodActivitiesByTemperature("HOT");
            for (FoodActivity re : res) {
                Long idx = re.getIdx();
                if (!TempFoodList.contains(idx))
                    TempFoodList.add(idx);
            }
        }
        else {
            List<FoodActivity> res = foodRecommendListRepository.findFoodActivitiesByTemperatureOrTemperature("NORMAL", "COLD");
            for (FoodActivity re : res) {
                Long idx = re.getIdx();
                if (!TempFoodList.contains(idx))
                    TempFoodList.add(idx);
            }
        }
        //한국음식 선호도
        if(foodPreference.getKorea()>=RECOMMEND_SCORE){
            List<FoodActivity> res = foodRecommendListRepository.findFoodActivitiesByCountryIdx(1L);
            for (FoodActivity re : res) {
                Long idx = re.getIdx();
                if (!TempFoodList.contains(idx))
                    TempFoodList.add(idx);
            }
        }
        //일국음식 선호도
        if(foodPreference.getJapan()>=RECOMMEND_SCORE){
            List<FoodActivity> res = foodRecommendListRepository.findFoodActivitiesByCountryIdx(2L);
            for (FoodActivity re : res) {
                Long idx = re.getIdx();
                if (!TempFoodList.contains(idx))
                    TempFoodList.add(idx);
            }
        }
        //중국음식 선호도
        if(foodPreference.getChina()>=RECOMMEND_SCORE){
            List<FoodActivity> res = foodRecommendListRepository.findFoodActivitiesByCountryIdx(3L);
            for (FoodActivity re : res) {
                Long idx = re.getIdx();
                if (!TempFoodList.contains(idx))
                    TempFoodList.add(idx);
            }
        }
        //양식 선호도
        if(foodPreference.getWestern()>=RECOMMEND_SCORE){
            List<FoodActivity> res = foodRecommendListRepository.findFoodActivitiesByCountryIdx(4L);
            for (FoodActivity re : res) {
                Long idx = re.getIdx();
                if (!TempFoodList.contains(idx))
                    TempFoodList.add(idx);
            }
        }
        //날것 선호도
        if(foodPreference.getRaw()>=RECOMMEND_SCORE){
            List<FoodActivity> res = foodRecommendListRepository.findFoodActivitiesByCookingStateContains("raw");
            for (FoodActivity re : res) {
                Long idx = re.getIdx();
                if (!TempFoodList.contains(idx))
                    TempFoodList.add(idx);
            }
        }
        //익힌거 선호도
        else if(foodPreference.getRoasted()>=RECOMMEND_SCORE){
            List<FoodActivity> res = foodRecommendListRepository.findFoodActivitiesByCookingStateContains("roasted");
            for (FoodActivity re : res) {
                Long idx = re.getIdx();
                if (!TempFoodList.contains(idx))
                    TempFoodList.add(idx);
            }
        }
        //국물 선호도
        if(foodPreference.getSoup()>=RECOMMEND_SCORE){
            List<FoodActivity> res = foodRecommendListRepository.findFoodActivitiesByCookingStateContains("soup");
            for (FoodActivity re : res) {
                Long idx = re.getIdx();
                if (!TempFoodList.contains(idx))
                    TempFoodList.add(idx);
            }
        }


        /*
         * Media Preference
         */
        //SF 선호도
        if(mediaPreference.getScienceFiction() >= RECOMMEND_SCORE){
            List<MediaActivity> res = mediaRecommendListRepository.findMediaActivitiesByGenreIdx(1L);
            for (MediaActivity re : res) {
                Long idx = re.getIdx();
                if (!TempMediaList.contains(idx))
                    TempMediaList.add(idx);
            }
        }
        //SF 선호도
        if(mediaPreference.getHorror() >= RECOMMEND_SCORE){
            List<MediaActivity> res = mediaRecommendListRepository.findMediaActivitiesByGenreIdx(3L);
            for (MediaActivity re : res) {
                Long idx = re.getIdx();
                if (!TempMediaList.contains(idx))
                    TempMediaList.add(idx);
            }
        }
        //드라마 선호도
        if(mediaPreference.getDrama() >= RECOMMEND_SCORE){
            List<MediaActivity> res = mediaRecommendListRepository.findMediaActivitiesByGenreIdx(3L);
            for (MediaActivity re : res) {
                Long idx = re.getIdx();
                if (!TempMediaList.contains(idx))
                    TempMediaList.add(idx);
            }
        }
        //로맨스 선호도
        if(mediaPreference.getRomance()>= RECOMMEND_SCORE){
            List<MediaActivity> res = mediaRecommendListRepository.findMediaActivitiesByGenreIdx(6L);
            for (MediaActivity re : res) {
                Long idx = re.getIdx();
                if (!TempMediaList.contains(idx))
                    TempMediaList.add(idx);
            }
        }
        //액션 선호도
        if(mediaPreference.getAction() >= RECOMMEND_SCORE){
            List<MediaActivity> res = mediaRecommendListRepository.findMediaActivitiesByGenreIdx(15L);
            for (MediaActivity re : res) {
                Long idx = re.getIdx();
                if (!TempMediaList.contains(idx))
                    TempMediaList.add(idx);
            }
        }
        //코미디 선호도
        if(mediaPreference.getComedy() >= RECOMMEND_SCORE){
            List<MediaActivity> res = mediaRecommendListRepository.findMediaActivitiesByGenreIdx(19L);
            for (MediaActivity re : res) {
                Long idx = re.getIdx();
                if (!TempMediaList.contains(idx))
                    TempMediaList.add(idx);
            }
        }
        //범죄 선호도
        if(mediaPreference.getCrime() >= RECOMMEND_SCORE){
            List<MediaActivity> res = mediaRecommendListRepository.findMediaActivitiesByGenreIdxOrGenreIdx(9L, 12L);
            for (MediaActivity re : res) {
                Long idx = re.getIdx();
                if (!TempMediaList.contains(idx))
                    TempMediaList.add(idx);
            }
        }
        //판타지 선호도
        if(mediaPreference.getFantasy() >= RECOMMEND_SCORE){
            List<MediaActivity> res = mediaRecommendListRepository.findMediaActivitiesByGenreIdx(20L);
            for (MediaActivity re : res) {
                Long idx = re.getIdx();
                if (!TempMediaList.contains(idx))
                    TempMediaList.add(idx);
            }
        }
        //애니 선호도
        if(mediaPreference.getAnimation()>= RECOMMEND_SCORE){
            List<MediaActivity> res = mediaRecommendListRepository.findMediaActivitiesByGenreIdx(14L);
            for (MediaActivity re : res) {
                Long idx = re.getIdx();
                if (!TempMediaList.contains(idx))
                    TempMediaList.add(idx);
            }
        }
        //예능 선호도
        if(mediaPreference.getTvShow()>= RECOMMEND_SCORE){
            List<MediaActivity> res = mediaRecommendListRepository.findMediaActivitiesByGenreIdx(17L);
            for (MediaActivity re : res) {
                Long idx = re.getIdx();
                if (!TempMediaList.contains(idx))
                    TempMediaList.add(idx);
            }
        }
        //고전 선호도
        if(mediaPreference.getClassic()>= RECOMMEND_SCORE){
            List<MediaActivity> res = mediaRecommendListRepository.findMediaActivitiesByGenreIdxOrGenreIdx(10L,11L);
            for (MediaActivity re : res) {
                Long idx = re.getIdx();
                if (!TempMediaList.contains(idx))
                    TempMediaList.add(idx);
            }
        }

//        //넷플릭스 선호도
//        if(mediaPreference.getNetflix()>= RECOMMEND_SCORE){
//            List<MediaActivity> res = mediaRecommendListRepository.findMediaActivitiesByGenreIdx(3L);
//            for(int i = 0; i <res.size(); ++i){
//                MediaActivity res1 = mediaRecommendListRepository.findById(res.get(i).getIdx()).orElseThrow(()->new BaseException(BaseResponseStatus.ACTIVITY_IDX_ERROR));
//                MediaImg res2 = mediaImgRepository.findMediaImgByMediaIdx(res.get(i).getIdx());
//                MediaActivityResponseDto temp = new MediaActivityResponseDto(res1, res2);
//                if(!TempMediaList.contains(temp))
//                    TempMediaList.add(temp);
//            }
//        }
//        //웨이브 선호도
//        if(mediaPreference.getWave()>= RECOMMEND_SCORE){
//            List<MediaActivity> res = mediaRecommendListRepository.findMediaActivitiesByGenreIdx(3L);
//            for(int i = 0; i <res.size(); ++i){
//                MediaActivity res1 = mediaRecommendListRepository.findById(res.get(i).getIdx()).orElseThrow(()->new BaseException(BaseResponseStatus.ACTIVITY_IDX_ERROR));
//                MediaImg res2 = mediaImgRepository.findMediaImgByMediaIdx(res.get(i).getIdx());
//                MediaActivityResponseDto temp = new MediaActivityResponseDto(res1, res2);
//                if(!TempMediaList.contains(temp))
//                    TempMediaList.add(temp);
//            }
//        }
//        //왓챠 선호도
//        if(mediaPreference.getWatcha()>= RECOMMEND_SCORE){
//            List<MediaActivity> res = mediaRecommendListRepository.findMediaActivitiesByGenreIdx(3L);
//            for(int i = 0; i <res.size(); ++i){
//                MediaActivity res1 = mediaRecommendListRepository.findById(res.get(i).getIdx()).orElseThrow(()->new BaseException(BaseResponseStatus.ACTIVITY_IDX_ERROR));
//                MediaImg res2 = mediaImgRepository.findMediaImgByMediaIdx(res.get(i).getIdx());
//                MediaActivityResponseDto temp = new MediaActivityResponseDto(res1, res2);
//                if(!TempMediaList.contains(temp))
//                    TempMediaList.add(temp);
//            }
//        }
//        //티빙 선호도
//        if(mediaPreference.getTving()>= RECOMMEND_SCORE){
//            List<MediaActivity> res = mediaRecommendListRepository.findMediaActivitiesByGenreIdx(3L);
//            for(int i = 0; i <res.size(); ++i){
//                MediaActivity res1 = mediaRecommendListRepository.findById(res.get(i).getIdx()).orElseThrow(()->new BaseException(BaseResponseStatus.ACTIVITY_IDX_ERROR));
//                MediaImg res2 = mediaImgRepository.findMediaImgByMediaIdx(res.get(i).getIdx());
//                MediaActivityResponseDto temp = new MediaActivityResponseDto(res1, res2);
//                if(!TempMediaList.contains(temp))
//                    TempMediaList.add(temp);
//            }
//        }
//        //티비앤 선호도
//        if(mediaPreference.getTvn()>= RECOMMEND_SCORE){
//            List<MediaActivity> res = mediaRecommendListRepository.findMediaActivitiesByGenreIdx(3L);
//            for(int i = 0; i <res.size(); ++i){
//                MediaActivity res1 = mediaRecommendListRepository.findById(res.get(i).getIdx()).orElseThrow(()->new BaseException(BaseResponseStatus.ACTIVITY_IDX_ERROR));
//                MediaImg res2 = mediaImgRepository.findMediaImgByMediaIdx(res.get(i).getIdx());
//                MediaActivityResponseDto temp = new MediaActivityResponseDto(res1, res2);
//                if(!TempMediaList.contains(temp))
//                    TempMediaList.add(temp);
//            }
//        }
//        //Jtbc 선호도
//        if(mediaPreference.getJtbc()>= RECOMMEND_SCORE){
//            List<MediaActivity> res = mediaRecommendListRepository.findMediaActivitiesByGenreIdx(3L);
//            for(int i = 0; i <res.size(); ++i){
//                MediaActivity res1 = mediaRecommendListRepository.findById(res.get(i).getIdx()).orElseThrow(()->new BaseException(BaseResponseStatus.ACTIVITY_IDX_ERROR));
//                MediaImg res2 = mediaImgRepository.findMediaImgByMediaIdx(res.get(i).getIdx());
//                MediaActivityResponseDto temp = new MediaActivityResponseDto(res1, res2);
//                if(!TempMediaList.contains(temp))
//                    TempMediaList.add(temp);
//            }
//        }
//        //mbc 선호도
//        if(mediaPreference.getMbc()>= RECOMMEND_SCORE){
//            List<MediaActivity> res = mediaRecommendListRepository.findMediaActivitiesByGenreIdx(3L);
//            for(int i = 0; i <res.size(); ++i){
//                MediaActivity res1 = mediaRecommendListRepository.findById(res.get(i).getIdx()).orElseThrow(()->new BaseException(BaseResponseStatus.ACTIVITY_IDX_ERROR));
//                MediaImg res2 = mediaImgRepository.findMediaImgByMediaIdx(res.get(i).getIdx());
//                MediaActivityResponseDto temp = new MediaActivityResponseDto(res1, res2);
//                if(!TempMediaList.contains(temp))
//                    TempMediaList.add(temp);
//            }
//        }
//        //sbs 선호도
//        if(mediaPreference.getSbs()>= RECOMMEND_SCORE){
//            List<MediaActivity> res = mediaRecommendListRepository.findMediaActivitiesByGenreIdx(3L);
//            for(int i = 0; i <res.size(); ++i){
//                MediaActivity res1 = mediaRecommendListRepository.findById(res.get(i).getIdx()).orElseThrow(()->new BaseException(BaseResponseStatus.ACTIVITY_IDX_ERROR));
//                MediaImg res2 = mediaImgRepository.findMediaImgByMediaIdx(res.get(i).getIdx());
//                MediaActivityResponseDto temp = new MediaActivityResponseDto(res1, res2);
//                if(!TempMediaList.contains(temp))
//                    TempMediaList.add(temp);
//            }
//        }
//        //kbs 선호도
//        if(mediaPreference.getKbs()>= RECOMMEND_SCORE){
//            List<MediaActivity> res = mediaRecommendListRepository.findMediaActivitiesByGenreIdx(3L);
//            for(int i = 0; i <res.size(); ++i){
//                MediaActivity res1 = mediaRecommendListRepository.findById(res.get(i).getIdx()).orElseThrow(()->new BaseException(BaseResponseStatus.ACTIVITY_IDX_ERROR));
//                MediaImg res2 = mediaImgRepository.findMediaImgByMediaIdx(res.get(i).getIdx());
//                MediaActivityResponseDto temp = new MediaActivityResponseDto(res1, res2);
//                if(!TempMediaList.contains(temp))
//                    TempMediaList.add(temp);
//            }
//        }


        /*
         *Dessert Preference
         */
        //카페인 선호도
        if(dessertPreference.getCoffee() >= RECOMMEND_SCORE) {
            List<Drink> res = drinkRepository.findDrinksByCaffeine("Y");
            for (Drink re : res) {
                Long idx = re.getIdx();
                if (!TempDessertList.contains(idx))
                    TempDessertList.add(idx);
            }
        }
        //베이커리 선호도
        if(dessertPreference.getBakery() >= RECOMMEND_SCORE){
            List<NonDrink> res = nonDrinkRepository.findAll();
            for (NonDrink re : res) {
                Long idx = re.getIdx();
                if (!TempDessertList.contains(idx))
                    TempDessertList.add(idx);
            }
        }
        //단거 선호도
        if(dessertPreference.getSweet() >= RECOMMEND_SCORE){
            List<Drink> res = drinkRepository.findDrinksByFlavor("단");
            for (Drink re : res) {
                Long idx = re.getIdx();
                if (!TempDessertList.contains(idx))
                    TempDessertList.add(idx);
            }
        }
        //신거 선호도
        else if(dessertPreference.getSour() >= RECOMMEND_SCORE){
            List<Drink> res = drinkRepository.findDrinksByFlavor("쓴");
            for (Drink re : res) {
                Long idx = re.getIdx();
                if (!TempDessertList.contains(idx))
                    TempDessertList.add(idx);
            }
        }
        //쓴거 선호도
        else if(dessertPreference.getBitter() >= RECOMMEND_SCORE){
            List<Drink> res = drinkRepository.findDrinksByFlavor("신");
            for (Drink re : res) {
                Long idx = re.getIdx();
                if (!TempDessertList.contains(idx))
                    TempDessertList.add(idx);
            }
        }
        //찬거 선호도
        if(dessertPreference.getCold() >= RECOMMEND_SCORE){
            List<Drink> res = drinkRepository.findDrinksByTemperatureContains("ICE");
            for (Drink re : res) {
                Long idx = re.getIdx();
                if (!TempDessertList.contains(idx))
                    TempDessertList.add(idx);
            }
        }
        //뜨거운거 선호도
        else if(dessertPreference.getHot() >= RECOMMEND_SCORE){
            List<Drink> res = drinkRepository.findDrinksByTemperatureContains("HOT");
            for (Drink re : res) {
                Long idx = re.getIdx();
                if (!TempDessertList.contains(idx))
                    TempDessertList.add(idx);
            }
        }
        
        //스무디 선호도
        if(dessertPreference.getSmoothie() >= RECOMMEND_SCORE){
            List<Drink> res = drinkRepository.findDrinksByDrinkNameContains("스무디");
            for (Drink re : res) {
                Long idx = re.getIdx();
                if (!TempDessertList.contains(idx))
                    TempDessertList.add(idx);
            }
        }
        //티 선호도
        if(dessertPreference.getTea() >= RECOMMEND_SCORE){
            List<Drink> res = drinkRepository.findDrinksByDrinkNameContainsOrDrinkNameContains("차", "티");
            for (Drink re : res) {
                Long idx = re.getIdx();
                if (!TempDessertList.contains(idx))
                    TempDessertList.add(idx);
            }
        }
        //과일류 선호도

        /*
         * Workout Preference
         */
        //난이도별 선호도
        if(workoutPreference.getDifficulty() >= RECOMMEND_SCORE){
            List<WorkoutActivity> res = workoutRecommendListRepository.findWorkoutActivitiesByDifficultyIdxOrDifficultyIdx(2L, 3L);
            for (WorkoutActivity re : res) {
                Long idx = re.getIdx();
                if (!TempWorkoutList.contains(idx))
                    TempWorkoutList.add(idx);
            }
        }
        else{
            List<WorkoutActivity> res = workoutRecommendListRepository.findWorkoutActivitiesByDifficultyIdx(1L);
            for (WorkoutActivity re : res) {
                Long idx = re.getIdx();
                if (!TempWorkoutList.contains(idx))
                    TempWorkoutList.add(idx);
            }
        }
        //요가 선호도
        if(workoutPreference.getHealth() >= RECOMMEND_SCORE){
            List<WorkoutActivity> res = workoutRecommendListRepository.findWorkoutActivitiesByTypeIdx(1L);
            for (WorkoutActivity re : res) {
                Long idx = re.getIdx();
                if (!TempWorkoutList.contains(idx))
                    TempWorkoutList.add(idx);
            }
        }
        //헬스 선호도
        if(workoutPreference.getHealth() >= RECOMMEND_SCORE){
            List<WorkoutActivity> res = workoutRecommendListRepository.findWorkoutActivitiesByTypeIdx(2L);
            for (WorkoutActivity re : res) {
                Long idx = re.getIdx();
                if (!TempWorkoutList.contains(idx))
                    TempWorkoutList.add(idx);
            }
        }


        if(TempMediaList.size() < RECOMMEND_SIZE  || TempFoodList.size() < RECOMMEND_SIZE || TempDessertList.size() < RECOMMEND_SIZE || TempWorkoutList.size() < RECOMMEND_SIZE)
            throw new BaseException(BaseResponseStatus.PREFERENCE_LACK_ERROR);


        Collections.shuffle(TempMediaList);
        Collections.shuffle(TempFoodList);
        Collections.shuffle(TempDessertList);
        Collections.shuffle(TempWorkoutList);


        List<MediaRecommendDto> mediaActivities = new ArrayList<>();
        List<FoodRecommendDto> foodActivities = new ArrayList<>();
        List<DessertRecommendDto> dessertActivities = new ArrayList<>();
        List<WorkoutRecommendDto> workoutActivities = new ArrayList<>();


        for(int i = 0; i <RECOMMEND_SIZE; ++i){
            MediaRecommendDto res1 = new MediaRecommendDto(mediaRecommendListRepository.findById(TempMediaList.get(i)).orElseThrow(()->new BaseException(BaseResponseStatus.ACTIVITY_IDX_ERROR)));
            mediaActivities.add(res1);

            FoodRecommendDto res2 = new FoodRecommendDto(foodRecommendListRepository.findById(TempFoodList.get(i)).orElseThrow(()->new BaseException(BaseResponseStatus.ACTIVITY_IDX_ERROR)));
            foodActivities.add(res2);

            DessertRecommendDto res3 = new DessertRecommendDto(dessertRecommendListRepository.findById(TempDessertList.get(i)).orElseThrow(()->new BaseException(BaseResponseStatus.ACTIVITY_IDX_ERROR)));
            dessertActivities.add(res3);

            WorkoutRecommendDto res4 = new WorkoutRecommendDto(workoutRecommendListRepository.findById(TempWorkoutList.get(i)).orElseThrow(()->new BaseException(BaseResponseStatus.ACTIVITY_IDX_ERROR)));
            workoutActivities.add(res4);

        }

        HashMap<String, Object> map = new HashMap<>();

        map.put("media", mediaActivities);
        map.put("food", foodActivities);
        map.put("dessert", dessertActivities);
        map.put("workout", workoutActivities);


        return map;
    }
}
