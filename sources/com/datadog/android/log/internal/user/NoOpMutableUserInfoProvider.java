package com.datadog.android.log.internal.user;

import com.datadog.android.core.model.UserInfo;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¨\u0006\b"}, mo175978d2 = {"Lcom/datadog/android/log/internal/user/NoOpMutableUserInfoProvider;", "Lcom/datadog/android/log/internal/user/MutableUserInfoProvider;", "()V", "getUserInfo", "Lcom/datadog/android/core/model/UserInfo;", "setUserInfo", "", "userInfo", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: NoOpMutableUserInfoProvider.kt */
public final class NoOpMutableUserInfoProvider implements MutableUserInfoProvider {
    public void setUserInfo(UserInfo userInfo) {
        Intrinsics.checkNotNullParameter(userInfo, "userInfo");
    }

    public UserInfo getUserInfo() {
        return new UserInfo((String) null, (String) null, (String) null, (Map) null, 15, (DefaultConstructorMarker) null);
    }
}
