package com.didi.entrega.uni_entrega_business.login;

public interface GLEUniLoginService {

    public interface Result<T> {
        void success(T t);
    }

    void isLogin(Result<Boolean> result);

    void login(long j);

    void logout(String str);
}
