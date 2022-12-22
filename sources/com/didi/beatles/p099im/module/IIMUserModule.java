package com.didi.beatles.p099im.module;

import com.didi.beatles.p099im.module.entity.IMUser;
import com.didi.beatles.p099im.module.impl.IMGroupUserInfoCallback;
import java.util.List;

/* renamed from: com.didi.beatles.im.module.IIMUserModule */
public interface IIMUserModule {
    void clearHolders();

    void executeUsfulExpression(int i, int i2, String str, IMUsefulExpressionCallback iMUsefulExpressionCallback);

    void executeUsfulExpression(int i, int i2, String str, String str2, IMUsefulExpressionCallback iMUsefulExpressionCallback);

    void getUserInfo(long j, IMGroupUserInfoCallback iMGroupUserInfoCallback, boolean z);

    void getUserInfo(long[] jArr, IMUserInfoCallback iMUserInfoCallback, boolean z);

    IMUser getUserInfoFromCache(long j);

    void insertGroupUserinfo(List<IMUser> list, long j);

    void insertUserinfo(IMUser iMUser);

    void kickGroupUser(long j, long j2);

    void loadUserInfoFromNet(long[] jArr, IMUserInfoCallback iMUserInfoCallback);
}
