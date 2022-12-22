package com.didi.beatles.p099im.module;

import com.didi.beatles.p099im.module.entity.IMUser;
import java.util.HashMap;

/* renamed from: com.didi.beatles.im.module.IMUserInfoCallback */
public interface IMUserInfoCallback extends IMSucceedCallback {
    void onUserInfoLoaded(HashMap<Long, IMUser> hashMap, long[] jArr);
}
