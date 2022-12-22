package com.didi.beatles.p099im.module;

import com.didi.beatles.p099im.access.msg.IMMessageFilter;
import com.didi.beatles.p099im.api.entity.IMDetailBody;
import com.didi.beatles.p099im.api.entity.IMLocationEntity;
import com.didi.beatles.p099im.api.entity.IMMessageDown;
import com.didi.beatles.p099im.module.entity.IMBusinessParam;
import com.didi.beatles.p099im.module.entity.IMMessage;
import com.didi.beatles.p099im.module.entity.IMSession;
import com.didi.beatles.p099im.picture.entity.IMLocalMedia;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;

/* renamed from: com.didi.beatles.im.module.IIMMessageModule */
public interface IIMMessageModule {
    void clearHolders();

    void deleteMessage(IMMessage iMMessage, IMMessageCallback iMMessageCallback);

    void extendSendMessage(int i, int i2, int i3, String str, int i4, IMDetailBody iMDetailBody, int i5, IMBusinessParam iMBusinessParam, IMMessageCallback iMMessageCallback);

    void getMessageReadStatus(long j, List<Long> list);

    void handleExpiredPicture(long j);

    void handleUpdateMessage(long j, JSONArray jSONArray);

    void insertMessage(IMMessage iMMessage);

    void insertMessagesFromClient(List<IMMessageDown> list);

    void loadAudioMessage(IMMessage iMMessage, long j, IMMessageCallback iMMessageCallback);

    void loadHistoryMessage(long j, long j2, int i, boolean z);

    void loadPeerHistoryMessage(long j, int i, IMMessagesLoadCallback iMMessagesLoadCallback);

    void pullSingleMessage(int i, long j, int i2);

    void pullSingleMessageForUploadData(int i, long j);

    void pushMessageReadStatus(long j, List<Long> list);

    void queryMessage(Collection<IMMessageFilter> collection, IMMessageCallback iMMessageCallback);

    void registerMessageCallback(IMMessageCallback iMMessageCallback, long j);

    IMMessage sendAudioMessage(IMMessage iMMessage, IMBusinessParam iMBusinessParam, IMSession iMSession, IMSendMessageCallback iMSendMessageCallback);

    IMMessage sendAudioMessage(String str, int i, IMBusinessParam iMBusinessParam, IMSession iMSession, IMSendMessageCallback iMSendMessageCallback);

    IMMessage sendEmojiMessage(String str, String str2, String str3, String str4, IMBusinessParam iMBusinessParam, IMSession iMSession);

    IMMessage sendImageMessage(IMMessage iMMessage, IMBusinessParam iMBusinessParam, IMSession iMSession);

    void sendImageMessage(List<IMLocalMedia> list, IMBusinessParam iMBusinessParam, IMSession iMSession, IMPreSendCallback iMPreSendCallback);

    IMMessage sendLocationMessage(IMLocationEntity iMLocationEntity, int i, IMBusinessParam iMBusinessParam, IMSession iMSession);

    void sendMsgAck(Long l, Long l2);

    IMMessage sendPluginMessage(int i, String str, String str2, int i2, IMBusinessParam iMBusinessParam, IMSession iMSession, IMSendMessageCallback iMSendMessageCallback);

    void sendStreetViewMessage(int i, IMBusinessParam iMBusinessParam, IMSession iMSession);

    IMMessage sendTextMessage(IMMessage iMMessage, IMBusinessParam iMBusinessParam, IMSession iMSession, IMSendMessageCallback iMSendMessageCallback);

    IMMessage sendTextMessage(String str, int i, IMBusinessParam iMBusinessParam, IMSession iMSession, Object obj, int i2, IMSendMessageCallback iMSendMessageCallback);

    void translateByHand(String str, long j, long j2, IMMessageCallBackImp iMMessageCallBackImp);

    void unregisterMessageCallback(long j);

    void updateMessage(Collection<IMMessage> collection, IMMessageCallback iMMessageCallback);

    void updateMessageAsync(IMMessage iMMessage);

    void updateReadStatus(long j, boolean z, List<Long> list, boolean z2);

    void updateSyncInfo();
}
