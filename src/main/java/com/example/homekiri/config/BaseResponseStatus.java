package com.example.homekiri.config;

import lombok.Getter;

@Getter
public enum BaseResponseStatus {
    /**
     * 요청 성공
     */
    SUCCESS(true,"요청 성공"),


    /**
     * User 관련 status
     */
    // Common
    REQUEST_ERROR(false,"입력값을 확인해주세요."),
    EMPTY_JWT(false,"JWT를 입력해주세요."),
    INVALID_JWT(false, "유효하지 않은 JWT입니다."),
    INVALID_USER_JWT(false,"권한이 없는 유저의 접근입니다."),

    /**
     * Stroy 관련 status
     */

    /**
     * Database, Server 관련 status
     */
    DATABASE_ERROR(false, "데이터베이스 연결에 실패하였습니다."),
    SERVER_ERROR(false, "서버와의 연결에 실패하였습니다."),


    PASSWORD_ENCRYPTION_ERROR(false, "비밀번호 암호화에 실패하였습니다."),
    PASSWORD_DECRYPTION_ERROR(false, "비밀번호 복호화에 실패하였습니다.");



    private final boolean isSuccess;
    private final String message;

    private BaseResponseStatus(boolean isSuccess, String message) {
        this.isSuccess = isSuccess;
        this.message = message;
    }
}
