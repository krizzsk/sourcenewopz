package com.didi.beatles.p099im.manager;

import android.content.Context;
import com.didi.beatles.p099im.access.IMContext;
import com.didi.beatles.p099im.access.callback.IMAccessSendMessageCallback;
import com.didi.beatles.p099im.access.core.IMMessageListener;
import com.didi.beatles.p099im.access.msg.IMMessageFilter;
import com.didi.beatles.p099im.module.IIMGlobalModule;
import com.didi.beatles.p099im.module.IIMMessageModule;
import com.didi.beatles.p099im.module.IIMSessionModule;
import com.didi.beatles.p099im.module.IIMUserModule;
import com.didi.beatles.p099im.module.IMMessageCallback;
import com.didi.beatles.p099im.module.IMSessionUnreadCallback;
import com.didi.beatles.p099im.module.IMSessionUnreadSysChatMsgCallback;
import com.didi.beatles.p099im.module.entity.IMBusinessParam;
import com.didi.beatles.p099im.module.entity.IMMessage;
import java.util.Collection;
import java.util.List;

/* renamed from: com.didi.beatles.im.manager.IMBaseManager */
public abstract class IMBaseManager {
    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract void mo42381a(String str);

    public abstract void ackHasReadMessage(long j, List<Long> list, IMSessionUnreadCallback iMSessionUnreadCallback);

    public abstract void addMessageListener(IMMessageListener iMMessageListener);

    /* access modifiers changed from: package-private */
    public abstract void closeSession(long j);

    /* access modifiers changed from: package-private */
    public abstract void deleteMessage(IMMessage iMMessage, IMMessageCallback iMMessageCallback);

    /* access modifiers changed from: package-private */
    public abstract void destroyIM();

    public abstract void forwardRobotMessage(IMBusinessParam iMBusinessParam, String str, IMAccessSendMessageCallback iMAccessSendMessageCallback);

    /* access modifiers changed from: package-private */
    public abstract void getAllUnreadMessageCount(IMSessionUnreadCallback iMSessionUnreadCallback);

    /* access modifiers changed from: package-private */
    public abstract void getAllUnreadRedCount(IMSessionUnreadCallback iMSessionUnreadCallback);

    /* access modifiers changed from: package-private */
    public abstract IIMGlobalModule getGlobalModel();

    /* access modifiers changed from: package-private */
    public abstract IIMMessageModule getMessageModel();

    /* access modifiers changed from: package-private */
    public abstract IIMSessionModule getSessionModel();

    /* access modifiers changed from: package-private */
    public abstract void getUnreadMessageCount(long j, IMSessionUnreadCallback iMSessionUnreadCallback);

    /* access modifiers changed from: package-private */
    public abstract void getUnreadMessageCount(List<Long> list, IMSessionUnreadCallback iMSessionUnreadCallback);

    /* access modifiers changed from: package-private */
    public abstract void getUnreadSysChatMessageCount(List<Long> list, IMSessionUnreadSysChatMsgCallback iMSessionUnreadSysChatMsgCallback);

    /* access modifiers changed from: package-private */
    public abstract IIMUserModule getUserModel();

    /* access modifiers changed from: package-private */
    public abstract boolean initIM(Context context, IMContext iMContext);

    /* access modifiers changed from: package-private */
    public abstract void insertMessagesFromClient(String str);

    /* access modifiers changed from: package-private */
    public abstract void pullMessage(int i, long j, int i2);

    /* access modifiers changed from: package-private */
    public abstract void queryMessage(Collection<IMMessageFilter> collection, IMMessageCallback iMMessageCallback);

    /* access modifiers changed from: package-private */
    public abstract void reInitIM(int i);

    public abstract void removeMessageListener(IMMessageListener iMMessageListener);

    public abstract void sendAudioMessage(IMBusinessParam iMBusinessParam, String str, int i, IMAccessSendMessageCallback iMAccessSendMessageCallback);

    public abstract void sendTextMessage(IMBusinessParam iMBusinessParam, String str, int i, IMAccessSendMessageCallback iMAccessSendMessageCallback);

    /* access modifiers changed from: package-private */
    public abstract void startPollService();

    /* access modifiers changed from: package-private */
    public abstract void stopPollService();

    /* access modifiers changed from: package-private */
    public abstract void updateMessage(IMMessage iMMessage);

    /* access modifiers changed from: package-private */
    public abstract void updateMessage(Collection<IMMessage> collection, IMMessageCallback iMMessageCallback);

    /* access modifiers changed from: package-private */
    public abstract void updateSession(IMMessage iMMessage);
}
