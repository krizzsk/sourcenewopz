package com.didi.usercenter.store;

import android.content.Context;
import android.os.Parcelable;
import com.didi.sdk.store.BaseStore;
import com.didi.sdk.store.util.ParcelableUtil;
import com.didi.usercenter.entity.UserInfo;

public class UserCenterStore extends BaseStore {

    /* renamed from: a */
    private static String f45134a = "UserInfo";

    /* renamed from: b */
    private static UserCenterStore f45135b;

    /* renamed from: c */
    private UserInfo f45136c;

    /* renamed from: d */
    private com.didi.one.login.model.UserInfo f45137d;

    UserCenterStore() {
        super("com.didi.sdk.login.c.j");
    }

    public static UserCenterStore getIns() {
        if (f45135b == null) {
            synchronized (UserCenterStore.class) {
                if (f45135b == null) {
                    f45135b = new UserCenterStore();
                }
            }
        }
        return f45135b;
    }

    public void setUserInfo(Context context, UserInfo userInfo) {
        this.f45136c = userInfo;
        this.f45137d = com.didi.one.login.model.UserInfo.getUserInfo(userInfo);
        putAndSave(context, f45134a, (Parcelable) userInfo);
    }

    public UserInfo getUserInfo(Context context) {
        if (this.f45136c == null) {
            try {
                Object inner = getInner(context, f45134a);
                if (inner instanceof byte[]) {
                    inner = ParcelableUtil.unmarshall((byte[]) inner, UserInfo.CREATOR);
                }
                this.f45136c = (UserInfo) inner;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this.f45136c;
    }

    public com.didi.one.login.model.UserInfo getOldUserInfo(Context context) {
        if (this.f45137d == null) {
            this.f45137d = com.didi.one.login.model.UserInfo.getUserInfo(getUserInfo(context));
        }
        return this.f45137d;
    }

    public void clearUserInfo(Context context) {
        this.f45136c = null;
        this.f45137d = null;
        clearAll(f45134a);
    }
}
