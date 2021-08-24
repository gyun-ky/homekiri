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
import com.example.homekiri.recommendation.model.activity.Info.*;
import com.example.homekiri.recommendation.model.activity.MediaActivity;
import com.example.homekiri.recommendation.model.activity.WorkoutActivity;
import com.example.homekiri.recommendation.model.preferences.DessertPreference;
import com.example.homekiri.recommendation.model.preferences.FoodPreference;
import com.example.homekiri.recommendation.model.preferences.MediaPreference;
import com.example.homekiri.recommendation.model.preferences.WorkoutPreference;
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
    private final MediaImgRepository mediaImgRepository;
    private final FoodImgRepository foodImgRepository;
    private final WorkoutImgRepository workoutImgRepository;
    private final WorkoutVideoRepository workoutVideoRepository;

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

        /*
         * Food Preference
         */
        //소고기 선호도
        if(foodPreference.getBeef() >= RECOMMEND_SCORE){
            List<FoodActivity> res = foodRecommendListRepository.findFoodActivitiesByIngredient("소고기");
            for(int i = 0; i <res.size(); ++i){
                FoodActivity res1 = foodRecommendListRepository.findById(res.get(i).getIdx()).orElseThrow(()->new BaseException(BaseResponseStatus.ACTIVITY_IDX_ERROR));
                FoodImage res2 = foodImgRepository.findFoodImageByFoodIdx(res.get(i).getIdx());
                FoodActivityResponseDto temp = new FoodActivityResponseDto(res1, res2);
                if(!TempFoodList.contains(temp))
                    TempFoodList.add(temp);
            }
        }
        //닭고기 선호도
        if(foodPreference.getChicken()>=RECOMMEND_SCORE){
            List<FoodActivity> res = foodRecommendListRepository.findFoodActivitiesByIngredient("닭고기");
            for(int i = 0; i < res.size(); ++i){
                FoodActivity res1 = foodRecommendListRepository.findById(res.get(i).getIdx()).orElseThrow(()->new BaseException(BaseResponseStatus.ACTIVITY_IDX_ERROR));
                FoodImage res2 = foodImgRepository.findFoodImageByFoodIdx(res.get(i).getIdx());
                FoodActivityResponseDto temp = new FoodActivityResponseDto(res1, res2);
                if(!TempFoodList.contains(temp))
                    TempFoodList.add(temp);
            }
        }
        //면 선호도
        if(foodPreference.getNoodle()>=RECOMMEND_SCORE){
            List<FoodActivity> res = foodRecommendListRepository.findFoodActivitiesByIngredient("면");
            for(int i = 0; i < res.size(); ++i){
                FoodActivity res1 = foodRecommendListRepository.findById(res.get(i).getIdx()).orElseThrow(()->new BaseException(BaseResponseStatus.ACTIVITY_IDX_ERROR));
                FoodImage res2 = foodImgRepository.findFoodImageByFoodIdx(res.get(i).getIdx());
                FoodActivityResponseDto temp = new FoodActivityResponseDto(res1, res2);
                if(!TempFoodList.contains(temp))
                    TempFoodList.add(temp);
            }
        }
        //밥 선호도
        if(foodPreference.getRice()>=RECOMMEND_SCORE){
            List<FoodActivity> res = foodRecommendListRepository.findFoodActivitiesByIngredient("밥");
            for(int i = 0; i < res.size(); ++i){
                FoodActivity res1 = foodRecommendListRepository.findById(res.get(i).getIdx()).orElseThrow(()->new BaseException(BaseResponseStatus.ACTIVITY_IDX_ERROR));
                FoodImage res2 = foodImgRepository.findFoodImageByFoodIdx(res.get(i).getIdx());
                FoodActivityResponseDto temp = new FoodActivityResponseDto(res1, res2);
                if(!TempFoodList.contains(temp))
                    TempFoodList.add(temp);
            }
        }
        //온도 선호도
        if(foodPreference.getTemperature()>=RECOMMEND_SCORE){
            List<FoodActivity> res = foodRecommendListRepository.findFoodActivitiesByTemperature("HOT");
            for(int i = 0; i < res.size(); ++i){
                FoodActivity res1 = foodRecommendListRepository.findById(res.get(i).getIdx()).orElseThrow(()->new BaseException(BaseResponseStatus.ACTIVITY_IDX_ERROR));
                FoodImage res2 = foodImgRepository.findFoodImageByFoodIdx(res.get(i).getIdx());
                FoodActivityResponseDto temp = new FoodActivityResponseDto(res1, res2);
                if(!TempFoodList.contains(temp))
                    TempFoodList.add(temp);
            }
        }
        else {
            List<FoodActivity> res = foodRecommendListRepository.findFoodActivitiesByTemperatureOrTemperature("NORMAL", "COLD");
            for(int i = 0; i < res.size(); ++i){
                FoodActivity res1 = foodRecommendListRepository.findById(res.get(i).getIdx()).orElseThrow(()->new BaseException(BaseResponseStatus.ACTIVITY_IDX_ERROR));
                FoodImage res2 = foodImgRepository.findFoodImageByFoodIdx(res.get(i).getIdx());
                FoodActivityResponseDto temp = new FoodActivityResponseDto(res1, res2);
                if(!TempFoodList.contains(temp))
                    TempFoodList.add(temp);
            }
        }
        //한국음식 선호도
        if(foodPreference.getKorea()>=RECOMMEND_SCORE){
            List<FoodActivity> res = foodRecommendListRepository.findFoodActivitiesByCountryIdx(1L);
            for(int i = 0; i < res.size(); ++i){
                FoodActivity res1 = foodRecommendListRepository.findById(res.get(i).getIdx()).orElseThrow(()->new BaseException(BaseResponseStatus.ACTIVITY_IDX_ERROR));
                FoodImage res2 = foodImgRepository.findFoodImageByFoodIdx(res.get(i).getIdx());
                FoodActivityResponseDto temp = new FoodActivityResponseDto(res1, res2);
                if(!TempFoodList.contains(temp))
                    TempFoodList.add(temp);
            }
        }
        //일국음식 선호도
        if(foodPreference.getJapan()>=RECOMMEND_SCORE){
            List<FoodActivity> res = foodRecommendListRepository.findFoodActivitiesByCountryIdx(2L);
            for(int i = 0; i < res.size(); ++i){
                FoodActivity res1 = foodRecommendListRepository.findById(res.get(i).getIdx()).orElseThrow(()->new BaseException(BaseResponseStatus.ACTIVITY_IDX_ERROR));
                FoodImage res2 = foodImgRepository.findFoodImageByFoodIdx(res.get(i).getIdx());
                FoodActivityResponseDto temp = new FoodActivityResponseDto(res1, res2);
                if(!TempFoodList.contains(temp))
                    TempFoodList.add(temp);
            }
        }
        //중국음식 선호도
        if(foodPreference.getChina()>=RECOMMEND_SCORE){
            List<FoodActivity> res = foodRecommendListRepository.findFoodActivitiesByCountryIdx(3L);
            for(int i = 0; i < res.size(); ++i){
                FoodActivity res1 = foodRecommendListRepository.findById(res.get(i).getIdx()).orElseThrow(()->new BaseException(BaseResponseStatus.ACTIVITY_IDX_ERROR));
                FoodImage res2 = foodImgRepository.findFoodImageByFoodIdx(res.get(i).getIdx());
                FoodActivityResponseDto temp = new FoodActivityResponseDto(res1, res2);
                if(!TempFoodList.contains(temp))
                    TempFoodList.add(temp);
            }
        }
        //양식 선호도
        if(foodPreference.getWestern()>=RECOMMEND_SCORE){
            List<FoodActivity> res = foodRecommendListRepository.findFoodActivitiesByCountryIdx(4L);
            for(int i = 0; i < res.size(); ++i){
                FoodActivity res1 = foodRecommendListRepository.findById(res.get(i).getIdx()).orElseThrow(()->new BaseException(BaseResponseStatus.ACTIVITY_IDX_ERROR));
                FoodImage res2 = foodImgRepository.findFoodImageByFoodIdx(res.get(i).getIdx());
                FoodActivityResponseDto temp = new FoodActivityResponseDto(res1, res2);
                if(!TempFoodList.contains(temp))
                    TempFoodList.add(temp);
            }
        }
        //날것 선호도
        if(foodPreference.getRaw()>=RECOMMEND_SCORE){
            List<FoodActivity> res = foodRecommendListRepository.findFoodActivitiesByCookingStateContains("raw");
            for(int i = 0; i < res.size(); ++i){
                FoodActivity res1 = foodRecommendListRepository.findById(res.get(i).getIdx()).orElseThrow(()->new BaseException(BaseResponseStatus.ACTIVITY_IDX_ERROR));
                FoodImage res2 = foodImgRepository.findFoodImageByFoodIdx(res.get(i).getIdx());
                FoodActivityResponseDto temp = new FoodActivityResponseDto(res1, res2);
                if(!TempFoodList.contains(temp))
                    TempFoodList.add(temp);
            }
        }
        //국물 선호도
        if(foodPreference.getSoup()>=RECOMMEND_SCORE){
            List<FoodActivity> res = foodRecommendListRepository.findFoodActivitiesByCookingStateContains("soup");
            for(int i = 0; i < res.size(); ++i){
                FoodActivity res1 = foodRecommendListRepository.findById(res.get(i).getIdx()).orElseThrow(()->new BaseException(BaseResponseStatus.ACTIVITY_IDX_ERROR));
                FoodImage res2 = foodImgRepository.findFoodImageByFoodIdx(res.get(i).getIdx());
                FoodActivityResponseDto temp = new FoodActivityResponseDto(res1, res2);
                if(!TempFoodList.contains(temp))
                    TempFoodList.add(temp);
            }
        }
        //익힌거 선호도
        if(foodPreference.getRoasted()>=RECOMMEND_SCORE){
            List<FoodActivity> res = foodRecommendListRepository.findFoodActivitiesByCookingStateContains("roasted");
            for(int i = 0; i < res.size(); ++i){
                FoodActivity res1 = foodRecommendListRepository.findById(res.get(i).getIdx()).orElseThrow(()->new BaseException(BaseResponseStatus.ACTIVITY_IDX_ERROR));
                FoodImage res2 = foodImgRepository.findFoodImageByFoodIdx(res.get(i).getIdx());
                FoodActivityResponseDto temp = new FoodActivityResponseDto(res1, res2);
                if(!TempFoodList.contains(temp))
                    TempFoodList.add(temp);
            }
        }

        /*
         * Media Preference
         */
        //SF 선호도
        if(mediaPreference.getScienceFiction() >= RECOMMEND_SCORE){
            List<MediaActivity> res = mediaRecommendListRepository.findMediaActivitiesByGenreIdx(1L);
            for(int i = 0; i <res.size(); ++i){
                MediaActivity res1 = mediaRecommendListRepository.findById(res.get(i).getIdx()).orElseThrow(()->new BaseException(BaseResponseStatus.ACTIVITY_IDX_ERROR));
                MediaImg res2 = mediaImgRepository.findMediaImgByMediaIdx(res.get(i).getIdx());
                MediaActivityResponseDto temp = new MediaActivityResponseDto(res1, res2);
                if(!TempMediaList.contains(temp))
                    TempMediaList.add(temp);
            }
        }
        //SF 선호도
        if(mediaPreference.getHorror() >= RECOMMEND_SCORE){
            List<MediaActivity> res = mediaRecommendListRepository.findMediaActivitiesByGenreIdx(3L);
            for(int i = 0; i <res.size(); ++i){
                MediaActivity res1 = mediaRecommendListRepository.findById(res.get(i).getIdx()).orElseThrow(()->new BaseException(BaseResponseStatus.ACTIVITY_IDX_ERROR));
                MediaImg res2 = mediaImgRepository.findMediaImgByMediaIdx(res.get(i).getIdx());
                MediaActivityResponseDto temp = new MediaActivityResponseDto(res1, res2);
                if(!TempMediaList.contains(temp))
                    TempMediaList.add(temp);
            }
        }
        //드라마 선호도
        if(mediaPreference.getDrama() >= RECOMMEND_SCORE){
            List<MediaActivity> res = mediaRecommendListRepository.findMediaActivitiesByGenreIdx(3L);
            for(int i = 0; i <res.size(); ++i){
                MediaActivity res1 = mediaRecommendListRepository.findById(res.get(i).getIdx()).orElseThrow(()->new BaseException(BaseResponseStatus.ACTIVITY_IDX_ERROR));
                MediaImg res2 = mediaImgRepository.findMediaImgByMediaIdx(res.get(i).getIdx());
                MediaActivityResponseDto temp = new MediaActivityResponseDto(res1, res2);
                if(!TempMediaList.contains(temp))
                    TempMediaList.add(temp);
            }
        }
        //로맨스 선호도
        if(mediaPreference.getRomance()>= RECOMMEND_SCORE){
            List<MediaActivity> res = mediaRecommendListRepository.findMediaActivitiesByGenreIdx(6L);
            for(int i = 0; i <res.size(); ++i){
                MediaActivity res1 = mediaRecommendListRepository.findById(res.get(i).getIdx()).orElseThrow(()->new BaseException(BaseResponseStatus.ACTIVITY_IDX_ERROR));
                MediaImg res2 = mediaImgRepository.findMediaImgByMediaIdx(res.get(i).getIdx());
                MediaActivityResponseDto temp = new MediaActivityResponseDto(res1, res2);
                if(!TempMediaList.contains(temp))
                    TempMediaList.add(temp);
            }
        }
        //액션 선호도
        if(mediaPreference.getAction() >= RECOMMEND_SCORE){
            List<MediaActivity> res = mediaRecommendListRepository.findMediaActivitiesByGenreIdx(15L);
            for(int i = 0; i <res.size(); ++i){
                MediaActivity res1 = mediaRecommendListRepository.findById(res.get(i).getIdx()).orElseThrow(()->new BaseException(BaseResponseStatus.ACTIVITY_IDX_ERROR));
                MediaImg res2 = mediaImgRepository.findMediaImgByMediaIdx(res.get(i).getIdx());
                MediaActivityResponseDto temp = new MediaActivityResponseDto(res1, res2);
                if(!TempMediaList.contains(temp))
                    TempMediaList.add(temp);
            }
        }
        //코미디 선호도
        if(mediaPreference.getComedy() >= RECOMMEND_SCORE){
            List<MediaActivity> res = mediaRecommendListRepository.findMediaActivitiesByGenreIdx(19L);
            for(int i = 0; i <res.size(); ++i){
                MediaActivity res1 = mediaRecommendListRepository.findById(res.get(i).getIdx()).orElseThrow(()->new BaseException(BaseResponseStatus.ACTIVITY_IDX_ERROR));
                MediaImg res2 = mediaImgRepository.findMediaImgByMediaIdx(res.get(i).getIdx());
                MediaActivityResponseDto temp = new MediaActivityResponseDto(res1, res2);
                if(!TempMediaList.contains(temp))
                    TempMediaList.add(temp);
            }
        }
        //범죄 선호도
        if(mediaPreference.getCrime() >= RECOMMEND_SCORE){
            List<MediaActivity> res = mediaRecommendListRepository.findMediaActivitiesByGenreIdxOrGenreIdx(9L, 12L);
            for(int i = 0; i <res.size(); ++i){
                MediaActivity res1 = mediaRecommendListRepository.findById(res.get(i).getIdx()).orElseThrow(()->new BaseException(BaseResponseStatus.ACTIVITY_IDX_ERROR));
                MediaImg res2 = mediaImgRepository.findMediaImgByMediaIdx(res.get(i).getIdx());
                MediaActivityResponseDto temp = new MediaActivityResponseDto(res1, res2);
                if(!TempMediaList.contains(temp))
                    TempMediaList.add(temp);
            }
        }
        //판타지 선호도
        if(mediaPreference.getFantasy() >= RECOMMEND_SCORE){
            List<MediaActivity> res = mediaRecommendListRepository.findMediaActivitiesByGenreIdx(20L);
            for(int i = 0; i <res.size(); ++i){
                MediaActivity res1 = mediaRecommendListRepository.findById(res.get(i).getIdx()).orElseThrow(()->new BaseException(BaseResponseStatus.ACTIVITY_IDX_ERROR));
                MediaImg res2 = mediaImgRepository.findMediaImgByMediaIdx(res.get(i).getIdx());
                MediaActivityResponseDto temp = new MediaActivityResponseDto(res1, res2);
                if(!TempMediaList.contains(temp))
                    TempMediaList.add(temp);
            }
        }
        //애니 선호도
        if(mediaPreference.getAnimation()>= RECOMMEND_SCORE){
            List<MediaActivity> res = mediaRecommendListRepository.findMediaActivitiesByGenreIdx(14L);
            for(int i = 0; i <res.size(); ++i){
                MediaActivity res1 = mediaRecommendListRepository.findById(res.get(i).getIdx()).orElseThrow(()->new BaseException(BaseResponseStatus.ACTIVITY_IDX_ERROR));
                MediaImg res2 = mediaImgRepository.findMediaImgByMediaIdx(res.get(i).getIdx());
                MediaActivityResponseDto temp = new MediaActivityResponseDto(res1, res2);
                if(!TempMediaList.contains(temp))
                    TempMediaList.add(temp);
            }
        }
        //예능 선호도
        if(mediaPreference.getTvShow()>= RECOMMEND_SCORE){
            List<MediaActivity> res = mediaRecommendListRepository.findMediaActivitiesByGenreIdx(17L);
            for(int i = 0; i <res.size(); ++i){
                MediaActivity res1 = mediaRecommendListRepository.findById(res.get(i).getIdx()).orElseThrow(()->new BaseException(BaseResponseStatus.ACTIVITY_IDX_ERROR));
                MediaImg res2 = mediaImgRepository.findMediaImgByMediaIdx(res.get(i).getIdx());
                MediaActivityResponseDto temp = new MediaActivityResponseDto(res1, res2);
                if(!TempMediaList.contains(temp))
                    TempMediaList.add(temp);
            }
        }
        //고전 선호도
        if(mediaPreference.getClassic()>= RECOMMEND_SCORE){
            List<MediaActivity> res = mediaRecommendListRepository.findMediaActivitiesByGenreIdxOrGenreIdx(10L,11L);
            for(int i = 0; i <res.size(); ++i){
                MediaActivity res1 = mediaRecommendListRepository.findById(res.get(i).getIdx()).orElseThrow(()->new BaseException(BaseResponseStatus.ACTIVITY_IDX_ERROR));
                MediaImg res2 = mediaImgRepository.findMediaImgByMediaIdx(res.get(i).getIdx());
                MediaActivityResponseDto temp = new MediaActivityResponseDto(res1, res2);
                if(!TempMediaList.contains(temp))
                    TempMediaList.add(temp);
            }
        }
//
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
            for(int i = 0; i < res.size(); ++i){
                DessertActivity res1 = dessertRecommendListRepository.findById( res.get(i).getIdx()).orElseThrow(()->new BaseException(BaseResponseStatus.ACTIVITY_IDX_ERROR));
                DessertImage res2 = dessertImageRepository.findDessertImageByDessertIdx(res.get(i).getIdx());
                DessertActivityResponseDto temp = new DessertActivityResponseDto(res1, res2);
                if(!TempDessertList.contains(temp))
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
                if(!TempDessertList.contains(temp))
                    TempDessertList.add(temp);
            }
        }
        //단거 선호도
        if(dessertPreference.getSweet() >= RECOMMEND_SCORE){
            List<Drink> res = drinkRepository.findDrinksByFlavor("단");
            for(int i = 0; i <res.size(); ++i){
                DessertActivity res1 = dessertRecommendListRepository.findById( res.get(i).getIdx()).orElseThrow(()->new BaseException(BaseResponseStatus.ACTIVITY_IDX_ERROR));
                DessertImage res2 = dessertImageRepository.findDessertImageByDessertIdx(res.get(i).getIdx());
                DessertActivityResponseDto temp = new DessertActivityResponseDto(res1, res2);
                if(!TempDessertList.contains(temp))
                    TempDessertList.add(temp);
            }
        }
        //신거 선호도
        if(dessertPreference.getSour() >= RECOMMEND_SCORE){
            List<Drink> res = drinkRepository.findDrinksByFlavor("쓴");
            for(int i = 0; i <res.size(); ++i){
                DessertActivity res1 = dessertRecommendListRepository.findById( res.get(i).getIdx()).orElseThrow(()->new BaseException(BaseResponseStatus.ACTIVITY_IDX_ERROR));
                DessertImage res2 = dessertImageRepository.findDessertImageByDessertIdx(res.get(i).getIdx());
                DessertActivityResponseDto temp = new DessertActivityResponseDto(res1, res2);
                if(!TempDessertList.contains(temp))
                    TempDessertList.add(temp);
            }
        }
        //쓴거 선호도
        if(dessertPreference.getBitter() >= RECOMMEND_SCORE){
            List<Drink> res = drinkRepository.findDrinksByFlavor("신");
            for(int i = 0; i <res.size(); ++i){
                DessertActivity res1 = dessertRecommendListRepository.findById( res.get(i).getIdx()).orElseThrow(()->new BaseException(BaseResponseStatus.ACTIVITY_IDX_ERROR));
                DessertImage res2 = dessertImageRepository.findDessertImageByDessertIdx(res.get(i).getIdx());
                DessertActivityResponseDto temp = new DessertActivityResponseDto(res1, res2);
                if(!TempDessertList.contains(temp))
                    TempDessertList.add(temp);
            }
        }
        //찬거 선호도
        if(dessertPreference.getCold() >= RECOMMEND_SCORE){
            List<Drink> res = drinkRepository.findDrinksByTemperatureContains("ICE");
            for(int i = 0; i <res.size(); ++i){
                DessertActivity res1 = dessertRecommendListRepository.findById( res.get(i).getIdx()).orElseThrow(()->new BaseException(BaseResponseStatus.ACTIVITY_IDX_ERROR));
                DessertImage res2 = dessertImageRepository.findDessertImageByDessertIdx(res.get(i).getIdx());
                DessertActivityResponseDto temp = new DessertActivityResponseDto(res1, res2);
                if(!TempDessertList.contains(temp))
                    TempDessertList.add(temp);
            }
        }
        //뜨거운거 선호도
        if(dessertPreference.getHot() >= RECOMMEND_SCORE){
            List<Drink> res = drinkRepository.findDrinksByTemperatureContains("HOT");
            for(int i = 0; i <res.size(); ++i){
                DessertActivity res1 = dessertRecommendListRepository.findById( res.get(i).getIdx()).orElseThrow(()->new BaseException(BaseResponseStatus.ACTIVITY_IDX_ERROR));
                DessertImage res2 = dessertImageRepository.findDessertImageByDessertIdx(res.get(i).getIdx());
                DessertActivityResponseDto temp = new DessertActivityResponseDto(res1, res2);
                if(!TempDessertList.contains(temp))
                    TempDessertList.add(temp);
            }
        }
        //스무디 선호도
        if(dessertPreference.getSmoothie() >= RECOMMEND_SCORE){
            List<Drink> res = drinkRepository.findDrinksByDrinkNameContains("스무디");
            for(int i = 0; i <res.size(); ++i){
                DessertActivity res1 = dessertRecommendListRepository.findById( res.get(i).getIdx()).orElseThrow(()->new BaseException(BaseResponseStatus.ACTIVITY_IDX_ERROR));
                DessertImage res2 = dessertImageRepository.findDessertImageByDessertIdx(res.get(i).getIdx());
                DessertActivityResponseDto temp = new DessertActivityResponseDto(res1, res2);
                if(!TempDessertList.contains(temp))
                    TempDessertList.add(temp);
            }
        }
        //티 선호도
        if(dessertPreference.getTea() >= RECOMMEND_SCORE){
            List<Drink> res = drinkRepository.findDrinksByDrinkNameContainsOrDrinkNameContains("차", "티");
            for(int i = 0; i <res.size(); ++i){
                DessertActivity res1 = dessertRecommendListRepository.findById( res.get(i).getIdx()).orElseThrow(()->new BaseException(BaseResponseStatus.ACTIVITY_IDX_ERROR));
                DessertImage res2 = dessertImageRepository.findDessertImageByDessertIdx(res.get(i).getIdx());
                DessertActivityResponseDto temp = new DessertActivityResponseDto(res1, res2);
                if(!TempDessertList.contains(temp))
                    TempDessertList.add(temp);
            }
        }
        //과일류 선호도

        /*
         * Workout Preference
         */
        //난이도별 선호도
        if(workoutPreference.getDifficulty() >= RECOMMEND_SCORE){
            List<WorkoutActivity> res = workoutRecommendListRepository.findWorkoutActivitiesByDifficultyIdxOrDifficultyIdx(2L, 3L);
            for(int i = 0; i <res.size(); ++i){
                WorkoutActivity res1 = workoutRecommendListRepository.findById( res.get(i).getIdx()).orElseThrow(()->new BaseException(BaseResponseStatus.ACTIVITY_IDX_ERROR));
                WorkoutImg res2 = workoutImgRepository.findById( res.get(i).getIdx()).orElseThrow(()->new BaseException(BaseResponseStatus.ACTIVITY_IDX_ERROR));
                WorkoutVideo res3 = workoutVideoRepository.findById( res.get(i).getIdx()).orElseThrow(()->new BaseException(BaseResponseStatus.ACTIVITY_IDX_ERROR));
                WorkoutActivityResponseDto temp = new WorkoutActivityResponseDto(res1, res2, res3);
                if(!TempWorkoutList.contains(temp))
                    TempWorkoutList.add(temp);
            }
        }
        else{
            List<WorkoutActivity> res = workoutRecommendListRepository.findWorkoutActivitiesByDifficultyIdx(1L);
            for(int i = 0; i <res.size(); ++i){
                WorkoutActivity res1 = workoutRecommendListRepository.findById( res.get(i).getIdx()).orElseThrow(()->new BaseException(BaseResponseStatus.ACTIVITY_IDX_ERROR));
                WorkoutImg res2 = workoutImgRepository.findById( res.get(i).getIdx()).orElseThrow(()->new BaseException(BaseResponseStatus.ACTIVITY_IDX_ERROR));
                WorkoutVideo res3 = workoutVideoRepository.findById( res.get(i).getIdx()).orElseThrow(()->new BaseException(BaseResponseStatus.ACTIVITY_IDX_ERROR));
                WorkoutActivityResponseDto temp = new WorkoutActivityResponseDto(res1, res2, res3);
                if(!TempWorkoutList.contains(temp))
                    TempWorkoutList.add(temp);
            }
        }
        //요가 선호도
        if(workoutPreference.getHealth() >= RECOMMEND_SCORE){
            List<WorkoutActivity> res = workoutRecommendListRepository.findWorkoutActivitiesByTypeIdx(1L);
            for(int i = 0; i <res.size(); ++i){
                WorkoutActivity res1 = workoutRecommendListRepository.findById( res.get(i).getIdx()).orElseThrow(()->new BaseException(BaseResponseStatus.ACTIVITY_IDX_ERROR));
                WorkoutImg res2 = workoutImgRepository.findById( res.get(i).getIdx()).orElseThrow(()->new BaseException(BaseResponseStatus.ACTIVITY_IDX_ERROR));
                WorkoutVideo res3 = workoutVideoRepository.findById( res.get(i).getIdx()).orElseThrow(()->new BaseException(BaseResponseStatus.ACTIVITY_IDX_ERROR));
                WorkoutActivityResponseDto temp = new WorkoutActivityResponseDto(res1, res2, res3);
                if(!TempWorkoutList.contains(temp))
                    TempWorkoutList.add(temp);
            }
        }
        //헬스 선호도
        if(workoutPreference.getHealth() >= RECOMMEND_SCORE){
            List<WorkoutActivity> res = workoutRecommendListRepository.findWorkoutActivitiesByTypeIdx(2L);
            for(int i = 0; i <res.size(); ++i){
                WorkoutActivity res1 = workoutRecommendListRepository.findById( res.get(i).getIdx()).orElseThrow(()->new BaseException(BaseResponseStatus.ACTIVITY_IDX_ERROR));
                WorkoutImg res2 = workoutImgRepository.findById( res.get(i).getIdx()).orElseThrow(()->new BaseException(BaseResponseStatus.ACTIVITY_IDX_ERROR));
                WorkoutVideo res3 = workoutVideoRepository.findById( res.get(i).getIdx()).orElseThrow(()->new BaseException(BaseResponseStatus.ACTIVITY_IDX_ERROR));
                WorkoutActivityResponseDto temp = new WorkoutActivityResponseDto(res1, res2, res3);
                if(!TempWorkoutList.contains(temp))
                    TempWorkoutList.add(temp);
            }
        }


        if(TempMediaList.size() < RECOMMEND_SIZE  || TempFoodList.size() < RECOMMEND_SIZE || TempDessertList.size() < RECOMMEND_SIZE || TempWorkoutList.size() < RECOMMEND_SIZE)
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
