package com.didi.beatles.p099im.module;

import com.didi.beatles.p099im.module.entity.IMBusinessParam;
import com.didi.beatles.p099im.module.entity.IMMessage;
import com.didi.beatles.p099im.module.entity.IMSession;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/* renamed from: com.didi.beatles.im.module.IIMSessionModule */
public interface IIMSessionModule {
    void clearHolders();

    void clearRedDotCount(long j);

    void clearSessionsUnreadCount(int i, IMClearSessionUnreadCountCallback iMClearSessionUnreadCountCallback);

    void clearSessionsUnreadCount(long[] jArr);

    void clearUnreadCount(long j);

    void closeSession(long j);

    void createSession(long[] jArr, int i, IMSessionCallback iMSessionCallback);

    void deleteSession(IMSession iMSession);

    void deleteSession(List<IMSession> list);

    void findSessionRedDotCount(long j, IMSessionUnreadCallback iMSessionUnreadCallback);

    void findSessionUnreadCount(List<Long> list, IMSessionUnreadCallback iMSessionUnreadCallback);

    void findSessionUnreadCount(List<Long> list, IMSessionUnreadSysChatMsgCallback iMSessionUnreadSysChatMsgCallback);

    void getAllRedDotCount(IMSessionUnreadCallback iMSessionUnreadCallback);

    void getAllUnreadCount(IMSessionUnreadCallback iMSessionUnreadCallback);

    void getInvalidSessionUnreadCount(IMSessionUnreadCallback iMSessionUnreadCallback);

    IMSession getSessionFromLocal(long j);

    void getSessionFromLocal(long j, IMSessionCallback iMSessionCallback);

    void getSessionInfoFormNet(long[] jArr, long[] jArr2, int i, IMSessionCallback iMSessionCallback);

    void getSessionUnreadInfo(long j, IMSessionUnreadInfoCallback iMSessionUnreadInfoCallback);

    boolean isHaveOverDueMessage(int i);

    void loadSessionAsync();

    void loadSessionAsync(int i, int i2, Comparator<? super IMSession> comparator, IMFeedSessionCallback iMFeedSessionCallback);

    void loadSessionAsync(boolean z, int i);

    void modifyGroupForbidState(long j, boolean z, IMModifyGroupForbidCallback iMModifyGroupForbidCallback);

    void modifyHelperForbidState(long j, boolean z, IMModifyHelperForbidCallback iMModifyHelperForbidCallback);

    void registerSessionCallback(IMSessionCallback iMSessionCallback);

    void sendActionTipRequest(int i, long j, long j2, String str, int i2, IMSendActionTipCallback iMSendActionTipCallback);

    void setUnreadCount(long j, int i);

    void syncSessionStatus(int i, int i2, IMBusinessParam iMBusinessParam, IMSession iMSession, IMSessionCallback iMSessionCallback);

    void unregisterSessionCallback(IMSessionCallback iMSessionCallback);

    void updateLastMessageSync(IMMessage iMMessage);

    void updateLastSendMessageSync(long j, String str, int i, long j2, long j3, int i2);

    void updateLastSendMsgReadStatus(long j);

    void updateRecentMessages(long j);

    IMSession updateSessionEnableStatus(long j, boolean z, int i, String str);

    void updateSessionEnableStatus(long j, boolean z, int i);

    void updateSessionStateByMessageAsync(Map<Long, ArrayList<IMMessage>> map);

    IMSession updateSessionStatusAndSize(long j, boolean z, int i, String str, int i2);

    void updateSessionSync(IMMessage iMMessage);
}
