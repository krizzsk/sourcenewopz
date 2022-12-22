package com.didi.entrega.uni_entrega_business.privacy;

public interface GLEUniPrivcyService {

    public interface Result<T> {
        void success(T t);
    }

    void isGpsPrivacyEnabled(Result<Boolean> result);

    void isLocalPrivacyEnable(Result<Boolean> result);

    void setPrivacy(long j, long j2, Result<Boolean> result);
}
