package com.example.homekiri.user;

import com.example.homekiri.config.BaseException;
import com.example.homekiri.config.BaseResponseStatus;
import com.example.homekiri.config.secret.Secret;
import com.example.homekiri.library.AES128;
import com.example.homekiri.user.model.User;
import com.example.homekiri.user.repository.UserRepository;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /*
      Password encode
      @param String password
      @return String
    */
    public String encodePassWord(String password) throws BaseException{
        AES128 aes128 = new AES128(Secret.USER_INFO_PASSWORD_KEY);
        try {
            String result = aes128.encrypt(password);
            System.out.println("[Service] password encode complete");
            return result;
        }catch(Exception e){
            throw new BaseException(BaseResponseStatus.PASSWORD_ENCRYPTION_ERROR);
        }
    }

    /*
    validateEmail service
    @param String password
    @return boolean
     */
    public boolean validateEmail(String email){

    }


    /*
    SignIn service
    @param String password
    @return String
     */
    public int signIn(User user){
        //validate userEmail

        //validate nickName

    }
}
