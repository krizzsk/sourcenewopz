package com.didi.rlab.uni_foundation.passport;

public interface PassportService {
    void deleteAccount();

    PassportInfo getPassportInfo();

    void login();

    void logout();

    void resetEmail();

    void resetPassword();

    void resetPhoneNumber();

    void syncPassportInfo(PassportInfo passportInfo);
}
