package com.didi.soda.customer.service;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;
import com.didi.soda.customer.foundation.rpc.entity.UserInfoEntity;

public interface IToolsService extends IService {

    public enum FontType {
        NORMAL,
        MEDIUM,
        BOLD,
        LIGHT
    }

    void fetchAppInstanceID();

    void fetchSideBarByRpc(boolean z);

    String getAppInstanceID();

    Typeface getFontTypeFace(FontType fontType);

    Typeface getFontTypeFaceForRF(int i);

    UserInfoEntity getUserInfoEntity();

    void initFirebaseRemote();

    void setTypeface(TextView textView, FontType fontType);

    void setTypefaceForRF(TextView textView, int i);

    void trackFirebaseEvent(Context context, String str, Bundle bundle);
}
