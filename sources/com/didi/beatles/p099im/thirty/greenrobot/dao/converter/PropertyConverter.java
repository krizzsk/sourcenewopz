package com.didi.beatles.p099im.thirty.greenrobot.dao.converter;

/* renamed from: com.didi.beatles.im.thirty.greenrobot.dao.converter.PropertyConverter */
public interface PropertyConverter<P, D> {
    D convertToDatabaseValue(P p);

    P convertToEntityProperty(D d);
}
