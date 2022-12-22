package com.datadog.android.log.internal.user;

import com.datadog.android.core.internal.persistence.Serializer;
import com.datadog.android.core.model.UserInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, mo175978d2 = {"Lcom/datadog/android/log/internal/user/UserInfoSerializer;", "Lcom/datadog/android/core/internal/persistence/Serializer;", "Lcom/datadog/android/core/model/UserInfo;", "()V", "serialize", "", "model", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: UserInfoSerializer.kt */
public final class UserInfoSerializer implements Serializer<UserInfo> {
    public String serialize(UserInfo userInfo) {
        Intrinsics.checkNotNullParameter(userInfo, "model");
        String jsonObject = userInfo.toJson().getAsJsonObject().toString();
        Intrinsics.checkNotNullExpressionValue(jsonObject, "model.toJson().asJsonObject.toString()");
        return jsonObject;
    }
}
