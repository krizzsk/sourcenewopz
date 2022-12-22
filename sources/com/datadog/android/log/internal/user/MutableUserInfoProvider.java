package com.datadog.android.log.internal.user;

import com.datadog.android.core.model.UserInfo;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\ba\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, mo175978d2 = {"Lcom/datadog/android/log/internal/user/MutableUserInfoProvider;", "Lcom/datadog/android/log/internal/user/UserInfoProvider;", "setUserInfo", "", "userInfo", "Lcom/datadog/android/core/model/UserInfo;", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: MutableUserInfoProvider.kt */
public interface MutableUserInfoProvider extends UserInfoProvider {
    void setUserInfo(UserInfo userInfo);
}
