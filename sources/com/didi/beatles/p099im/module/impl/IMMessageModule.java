package com.didi.beatles.p099im.module.impl;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.collection.LongSparseArray;
import com.didi.beatles.p099im.IMContextInfoHelper;
import com.didi.beatles.p099im.access.msg.IMMessageFilter;
import com.didi.beatles.p099im.access.msg.IMRobotPraiseTTSMsg;
import com.didi.beatles.p099im.access.notify.NotificationUtils;
import com.didi.beatles.p099im.access.utils.Parser;
import com.didi.beatles.p099im.api.IMApiConst;
import com.didi.beatles.p099im.api.IMApiParser;
import com.didi.beatles.p099im.api.IMGetParamHelper;
import com.didi.beatles.p099im.api.entity.GiftQueryResponse;
import com.didi.beatles.p099im.api.entity.GiftUploadResponse;
import com.didi.beatles.p099im.api.entity.IMBaseResponseImpl;
import com.didi.beatles.p099im.api.entity.IMConfig;
import com.didi.beatles.p099im.api.entity.IMDetailBody;
import com.didi.beatles.p099im.api.entity.IMExtendSendMessageRequest;
import com.didi.beatles.p099im.api.entity.IMGetReadStatusResponse;
import com.didi.beatles.p099im.api.entity.IMLocationEntity;
import com.didi.beatles.p099im.api.entity.IMMessageAckRequest;
import com.didi.beatles.p099im.api.entity.IMMessageDown;
import com.didi.beatles.p099im.api.entity.IMMessageDownExtend;
import com.didi.beatles.p099im.api.entity.IMPullMessageRequest;
import com.didi.beatles.p099im.api.entity.IMPullMessageResponse;
import com.didi.beatles.p099im.api.entity.IMReadStatusRequest;
import com.didi.beatles.p099im.api.entity.IMRichInfoMsgBody;
import com.didi.beatles.p099im.api.entity.IMSendMessageRequest;
import com.didi.beatles.p099im.api.entity.IMSendMessageResponse;
import com.didi.beatles.p099im.api.entity.IMStreetViewRequest;
import com.didi.beatles.p099im.api.entity.IMTransBody;
import com.didi.beatles.p099im.api.entity.voice.IMVoiceBody;
import com.didi.beatles.p099im.api.url.IMApiUrl;
import com.didi.beatles.p099im.debug.IMMethodTracker;
import com.didi.beatles.p099im.event.IMEventDispatcher;
import com.didi.beatles.p099im.event.IMMessageHandleExpiredPicEvent;
import com.didi.beatles.p099im.manager.IMManager;
import com.didi.beatles.p099im.manager.IMSessionMessageListenerManager;
import com.didi.beatles.p099im.module.IIMGlobalModule;
import com.didi.beatles.p099im.module.IIMMessageModule;
import com.didi.beatles.p099im.module.IIMSessionModule;
import com.didi.beatles.p099im.module.IMBaseModule;
import com.didi.beatles.p099im.module.IMErrorCallback;
import com.didi.beatles.p099im.module.IMMessageCallBackImp;
import com.didi.beatles.p099im.module.IMMessageCallback;
import com.didi.beatles.p099im.module.IMMessagesLoadCallback;
import com.didi.beatles.p099im.module.IMPreSendCallback;
import com.didi.beatles.p099im.module.IMSendMessageCallback;
import com.didi.beatles.p099im.module.entity.IMBusinessParam;
import com.didi.beatles.p099im.module.entity.IMMessage;
import com.didi.beatles.p099im.module.entity.IMSession;
import com.didi.beatles.p099im.module.impl.IMModelHelper;
import com.didi.beatles.p099im.net.IMHttpManager;
import com.didi.beatles.p099im.net.IMNetCallback;
import com.didi.beatles.p099im.net.IMThreadHelper;
import com.didi.beatles.p099im.omega.IMTraceError;
import com.didi.beatles.p099im.omega.IMTraceUtil;
import com.didi.beatles.p099im.p100db.dao.MessageDao;
import com.didi.beatles.p099im.p100db.entity.IMMessageDaoEntity;
import com.didi.beatles.p099im.picture.entity.IMLocalMedia;
import com.didi.beatles.p099im.plugin.IMPluginFactory;
import com.didi.beatles.p099im.pref.IMPreference;
import com.didi.beatles.p099im.protocol.plugin.IMPluginService;
import com.didi.beatles.p099im.resource.IMResource;
import com.didi.beatles.p099im.service.IMFileManager;
import com.didi.beatles.p099im.task.IMTaskJob;
import com.didi.beatles.p099im.task.IMUploadQueue;
import com.didi.beatles.p099im.thirty.greenrobot.dao.query.QueryBuilder;
import com.didi.beatles.p099im.thirty.greenrobot.dao.query.WhereCondition;
import com.didi.beatles.p099im.utils.C4234I;
import com.didi.beatles.p099im.utils.IMIdGenerator;
import com.didi.beatles.p099im.utils.IMJsonUtil;
import com.didi.beatles.p099im.utils.IMLog;
import com.didi.beatles.p099im.utils.IMParseUtil;
import com.didi.beatles.p099im.utils.IMToastHelper;
import com.didi.beatles.p099im.utils.IMVoiceDownloadUtil;
import com.didi.beatles.p099im.utils.UiThreadHandler;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.taxis99.R;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.greenrobot.eventbus.EventBus;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.didi.beatles.im.module.impl.IMMessageModule */
public final class IMMessageModule extends IMBaseModule implements IIMMessageModule {

    /* renamed from: a */
    private static final String f9307a = "IMM";

    /* renamed from: k */
    private static final int f9308k = 1;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public IMFileManager f9309b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public long f9310c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public LongSparseArray<IMMessageCallback> f9311d = new LongSparseArray<>();
    /* access modifiers changed from: private */

    /* renamed from: e */
    public LongSparseArray<IMMessageCallback> f9312e = new LongSparseArray<>();

    /* renamed from: f */
    private IMPreference f9313f = IMPreference.getInstance(getServiceProvider().getContext());

    /* renamed from: g */
    private IMMethodTracker f9314g = IMMethodTracker.newInstance(f9307a);

    /* renamed from: h */
    private boolean f9315h = true;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public Handler f9316i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public LinkedList<Integer> f9317j = new LinkedList<>();

    public void clearHolders() {
        this.f9312e.clear();
    }

    public void onStart() {
        this.f9314g.track();
        this.f9310c = this.f9313f.getMaxSingleId(IMContextInfoHelper.getUid());
    }

    public void onStop() {
        super.onStop();
    }

    public void registerMessageCallback(IMMessageCallback iMMessageCallback, long j) {
        this.f9314g.track();
        try {
            this.f9311d.put(j, iMMessageCallback);
        } catch (Exception e) {
            IMLog.m6632e(f9307a, "[registerMessageCallback]", e);
        }
    }

    public void unregisterMessageCallback(long j) {
        this.f9314g.track();
        this.f9311d.remove(j);
    }

    protected IMMessageModule(IMModelProvider iMModelProvider) {
        super(iMModelProvider);
        this.mDaoSession = this.mServiceProvider.getDaoManager().getDaoSession();
        this.f9309b = this.mServiceProvider.getFileManager();
        this.f9316i = new Handler(Looper.getMainLooper());
    }

    public IMMessage sendAudioMessage(String str, int i, IMBusinessParam iMBusinessParam, IMSession iMSession, IMSendMessageCallback iMSendMessageCallback) {
        this.f9314g.track();
        long uid = IMContextInfoHelper.getUid();
        IMMessage iMMessage = new IMMessage(131072);
        iMMessage.isSend = true;
        iMMessage.setFile_name(str);
        iMMessage.setSid(iMSession.getSessionId());
        iMMessage.setSec(i);
        iMMessage.setStatus(100);
        iMMessage.setCreateTime(System.currentTimeMillis());
        iMMessage.setIsSend(true);
        iMMessage.setSenderUid(uid);
        iMMessage.setoId(iMBusinessParam.getOrderId());
        iMMessage.setRouteId(iMBusinessParam.getRouteId());
        iMMessage.setUniqueId(iMSession.getSessionId(), IMIdGenerator.getInstance().getRandId());
        iMMessage.setBusinessId(iMSession.getBusinessId());
        return sendAudioMessage(iMMessage, iMBusinessParam, iMSession, iMSendMessageCallback);
    }

    public IMMessage sendAudioMessage(IMMessage iMMessage, IMBusinessParam iMBusinessParam, IMSession iMSession, IMSendMessageCallback iMSendMessageCallback) {
        if (iMMessage == null || iMBusinessParam == null) {
            IMLog.m6632e(f9307a, "message and mBusinessParam can't be null while sendAudioMessage");
            return iMMessage;
        }
        this.f9314g.track();
        final IMMessage iMMessage2 = iMMessage;
        final IMSession iMSession2 = iMSession;
        final IMSendMessageCallback iMSendMessageCallback2 = iMSendMessageCallback;
        final IMBusinessParam iMBusinessParam2 = iMBusinessParam;
        IMThreadHelper.getInstance().execute(new Runnable() {
            public void run() {
                try {
                    final MessageDao messageDao = IMMessageModule.this.mDaoSession.getMessageDao(iMMessage2.getSid());
                    messageDao.insertOrReplace(iMMessage2.getDaoEntity());
                    final IMMessageCallback iMMessageCallback = (IMMessageCallback) IMMessageModule.this.f9311d.get(iMSession2.getSessionId());
                    final String string = IMResource.getString(R.string.im_bracket_audio);
                    IMHttpManager.getInstance().upLoadFile(iMMessage2.getFile_name(), new IMNetCallback<GiftUploadResponse>() {
                        public void success(GiftUploadResponse giftUploadResponse) {
                            if (giftUploadResponse == null) {
                                IMMessageModule.this.m6280a(iMMessageCallback, iMMessage2, (IMSendMessageResponse) null, iMSession2, string, iMSendMessageCallback2);
                                return;
                            }
                            iMMessage2.setFid(giftUploadResponse.resource_key);
                            messageDao.update(iMMessage2.getDaoEntity());
                            IMMessageModule.this.m6282a(iMMessage2, iMBusinessParam2, iMSession2, iMSendMessageCallback2);
                        }

                        public void failure(IOException iOException) {
                            IMMessageModule.this.m6280a(iMMessageCallback, iMMessage2, (IMSendMessageResponse) null, iMSession2, string, iMSendMessageCallback2);
                        }
                    });
                } catch (Exception unused) {
                    IMLog.m6632e(IMMessageModule.f9307a, "database error while sendmsg!");
                }
            }
        });
        return iMMessage;
    }

    public void sendImageMessage(List<IMLocalMedia> list, IMBusinessParam iMBusinessParam, IMSession iMSession, IMPreSendCallback iMPreSendCallback) {
        this.f9314g.track();
        final long uid = IMContextInfoHelper.getUid();
        final ArrayList arrayList = new ArrayList();
        final MessageDao messageDao = this.mDaoSession.getMessageDao(iMSession.getSessionId());
        final List<IMLocalMedia> list2 = list;
        final IMSession iMSession2 = iMSession;
        final IMBusinessParam iMBusinessParam2 = iMBusinessParam;
        final IMPreSendCallback iMPreSendCallback2 = iMPreSendCallback;
        IMThreadHelper.getInstance().execute(new Runnable() {
            public void run() {
                List<IMLocalMedia> list = list2;
                if (list != null) {
                    for (IMLocalMedia iMLocalMedia : list) {
                        IMMessage iMMessage = new IMMessage(196608);
                        iMMessage.isSend = true;
                        iMMessage.setFile_name(iMLocalMedia.getCompressPath());
                        iMMessage.setWidth(iMLocalMedia.getWidth());
                        iMMessage.setHeight(iMLocalMedia.getHeight());
                        iMMessage.setSize((int) iMLocalMedia.getSize());
                        iMMessage.setSid(iMSession2.getSessionId());
                        iMMessage.setStatus(100);
                        iMMessage.setCreateTime(System.currentTimeMillis());
                        iMMessage.setIsSend(true);
                        iMMessage.setSenderUid(uid);
                        iMMessage.setoId(iMBusinessParam2.getOrderId());
                        iMMessage.setRouteId(iMBusinessParam2.getRouteId());
                        iMMessage.setUniqueId(iMSession2.getSessionId(), IMIdGenerator.getInstance().getRandId());
                        iMMessage.setBusinessId(iMSession2.getBusinessId());
                        try {
                            messageDao.insertOrReplace(iMMessage.getDaoEntity());
                        } catch (Exception unused) {
                            iMMessage.setStatus(300);
                            IMLog.m6632e(IMMessageModule.f9307a, "database error while send image");
                        }
                        arrayList.add(iMMessage);
                    }
                }
                IMMessageModule.this.f9316i.post(new Runnable() {
                    public void run() {
                        if (iMPreSendCallback2 != null) {
                            iMPreSendCallback2.insertSuccess(arrayList);
                        }
                        for (IMMessage sendImageMessage : arrayList) {
                            IMMessageModule.this.sendImageMessage(sendImageMessage, iMBusinessParam2, iMSession2);
                        }
                    }
                });
            }
        });
    }

    public IMMessage sendImageMessage(IMMessage iMMessage, IMBusinessParam iMBusinessParam, IMSession iMSession) {
        if (iMMessage == null || iMBusinessParam == null) {
            IMLog.m6632e(f9307a, "message and mBusinessParam can't be null while sendAudioMessage");
            return iMMessage;
        }
        this.f9314g.track();
        final IMMessageCallback iMMessageCallback = this.f9311d.get(iMSession.getSessionId());
        final String string = IMResource.getString(R.string.im_bracket_image);
        final IMBusinessParam iMBusinessParam2 = iMBusinessParam;
        final IMSession iMSession2 = iMSession;
        IMUploadQueue.getInstance().offer(iMMessage, new IMUploadQueue.UploadCallback() {
            public void uploadSuccess(GiftUploadResponse giftUploadResponse, IMMessage iMMessage) {
                if (giftUploadResponse == null || !giftUploadResponse.isSuccess()) {
                    uploadFail(iMMessage);
                    return;
                }
                iMMessage.setFid(giftUploadResponse.resource_key);
                iMMessage.setContent(giftUploadResponse.download_url_https);
                IMMessageModule.this.m6282a(iMMessage, iMBusinessParam2, iMSession2, (IMSendMessageCallback) null);
            }

            public void uploadFail(IMMessage iMMessage) {
                IMSendMessageResponse iMSendMessageResponse = new IMSendMessageResponse();
                iMSendMessageResponse.errno = 500;
                iMSendMessageResponse.errmsg = IMResource.getString(R.string.bts_im_no_network);
                IMMessageModule.this.m6280a(iMMessageCallback, iMMessage, iMSendMessageResponse, iMSession2, string, (IMSendMessageCallback) null);
            }
        });
        return iMMessage;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6280a(IMMessageCallback iMMessageCallback, IMMessage iMMessage, IMSendMessageResponse iMSendMessageResponse, IMSession iMSession, String str, IMSendMessageCallback iMSendMessageCallback) {
        IMMessage iMMessage2 = iMMessage;
        IMSendMessageResponse iMSendMessageResponse2 = iMSendMessageResponse;
        IMSession iMSession2 = iMSession;
        String str2 = str;
        IMSendMessageCallback iMSendMessageCallback2 = iMSendMessageCallback;
        if (iMSession2 != null) {
            MessageDao messageDao = this.mDaoSession.getMessageDao(iMSession.getSessionId());
            if (messageDao != null && iMMessage2 != null) {
                if (iMSendMessageResponse2 == null || !iMSendMessageResponse.isSuccess()) {
                    int i = 300;
                    if (iMSendMessageResponse2 != null && iMSendMessageResponse2.errno == 200000010) {
                        i = 500;
                    }
                    iMMessage.setStatus(i);
                    messageDao.insertOrReplace(iMMessage.getDaoEntity());
                } else {
                    long j = iMSendMessageResponse2.body.mids[0];
                    IMSendMessageResponse.RspMsg[] rspMsgArr = iMSendMessageResponse2.body.msgs;
                    if (!(rspMsgArr == null || rspMsgArr.length <= 0 || rspMsgArr[0] == null)) {
                        iMMessage.setCloudUniqueMsgId(rspMsgArr[0].uniq_msg_id);
                    }
                    long uid = IMContextInfoHelper.getUid();
                    iMMessage.setSenderUid(uid);
                    iMMessage.setUniqueId(uid, j);
                    iMMessage.setStatus(200);
                    messageDao.insertOrReplace(iMMessage.getDaoEntity());
                    m6283a(iMMessage, iMSession2, false, str2);
                }
                final IMSendMessageResponse iMSendMessageResponse3 = iMSendMessageResponse;
                final IMMessageCallback iMMessageCallback2 = iMMessageCallback;
                final IMMessage iMMessage3 = iMMessage;
                final IMSendMessageCallback iMSendMessageCallback3 = iMSendMessageCallback;
                final String str3 = str;
                final IMSession iMSession3 = iMSession;
                this.f9316i.post(new Runnable() {
                    public void run() {
                        IMSendMessageResponse iMSendMessageResponse = iMSendMessageResponse3;
                        if (iMSendMessageResponse == null || !iMSendMessageResponse.isSuccess()) {
                            IMMessageCallback iMMessageCallback = iMMessageCallback2;
                            if (iMMessageCallback != null) {
                                iMMessageCallback.onSendStatusChanged(iMMessage3, 202, iMSendMessageResponse3);
                            }
                            IMSendMessageCallback iMSendMessageCallback = iMSendMessageCallback3;
                            if (iMSendMessageCallback != null) {
                                String str = str3;
                                IMSendMessageResponse iMSendMessageResponse2 = iMSendMessageResponse3;
                                int i = iMSendMessageResponse2 != null ? iMSendMessageResponse2.errno : 100;
                                IMSendMessageResponse iMSendMessageResponse3 = iMSendMessageResponse3;
                                iMSendMessageCallback.onError(str, i, iMSendMessageResponse3 != null ? iMSendMessageResponse3.errmsg : null);
                            }
                        } else {
                            IMMessageCallback iMMessageCallback2 = iMMessageCallback2;
                            if (iMMessageCallback2 != null) {
                                iMMessageCallback2.onSendStatusChanged(iMMessage3, 201, iMSendMessageResponse3);
                            }
                            IMSendMessageCallback iMSendMessageCallback2 = iMSendMessageCallback3;
                            if (iMSendMessageCallback2 != null) {
                                iMSendMessageCallback2.onSuccess(iMMessage3);
                            }
                        }
                        IMEventDispatcher.dispatchSendStatusChanged(IMContextInfoHelper.getContext(), iMSession3, iMMessage3);
                    }
                });
            } else if (iMSendMessageCallback2 != null) {
                iMSendMessageCallback2.onError(str2, 100, "NullDaoOrMessage");
            }
        } else if (iMSendMessageCallback2 != null) {
            iMSendMessageCallback2.onError(str2, 100, "NullSession");
        }
    }

    public void loadHistoryMessage(long j, long j2, int i, boolean z) {
        this.f9314g.track();
        final long j3 = j;
        final long j4 = j2;
        final boolean z2 = z;
        final int i2 = i;
        new IMTaskJob<Void, Void, List<IMMessage>>() {
            /* access modifiers changed from: protected */
            public List<IMMessage> doInBackground(Void... voidArr) {
                QueryBuilder queryBuilder;
                MessageDao messageDao = IMMessageModule.this.mDaoSession.getMessageDao(j3);
                long j = j4;
                Integer valueOf = Integer.valueOf(IMApiConst.MsgTypeUnknow);
                if (j == 0) {
                    queryBuilder = messageDao.queryBuilder().where(MessageDao.Properties.Type.not(valueOf), new WhereCondition[0]).orderDesc(MessageDao.Properties.f9175Id).limit(i2);
                } else if (z2) {
                    queryBuilder = messageDao.queryBuilder().where(MessageDao.Properties.f9175Id.mo43481gt(Long.valueOf(j4)), MessageDao.Properties.Type.not(valueOf)).orderDesc(MessageDao.Properties.f9175Id).limit(i2);
                } else {
                    queryBuilder = messageDao.queryBuilder().where(MessageDao.Properties.f9175Id.mo43488lt(Long.valueOf(j4)), MessageDao.Properties.Type.not(valueOf)).orderDesc(MessageDao.Properties.f9175Id).limit(i2);
                }
                List list = queryBuilder.list();
                if (list == null) {
                    return null;
                }
                ArrayList arrayList = new ArrayList(list.size());
                for (int i = 0; i < list.size(); i++) {
                    arrayList.add(new IMMessage((IMMessageDaoEntity) list.get(i)));
                }
                return arrayList;
            }

            /* access modifiers changed from: protected */
            public void onPostExecute(List<IMMessage> list) {
                IMMessageCallback iMMessageCallback = (IMMessageCallback) IMMessageModule.this.f9311d.get(j3);
                if (iMMessageCallback != null) {
                    iMMessageCallback.onHistoryMessageLoad(list, z2);
                }
            }
        }.setErrorCallback(new IMErrorCallback() {
            public void onError(int i, Throwable th) {
                IMTraceError.trackError("im_load_history_error", th);
                IMMessageModule.this.getErrorCallback().onError(i, th);
            }
        }).executeWithDatabase(new Void[0]);
    }

    public void loadPeerHistoryMessage(long j, int i, IMMessagesLoadCallback iMMessagesLoadCallback) {
        this.f9314g.track();
        final long j2 = j;
        final int i2 = i;
        final IMMessagesLoadCallback iMMessagesLoadCallback2 = iMMessagesLoadCallback;
        new IMTaskJob<Void, Void, List<IMMessage>>() {
            /* access modifiers changed from: protected */
            public List<IMMessage> doInBackground(Void... voidArr) {
                MessageDao messageDao = IMMessageModule.this.mDaoSession.getMessageDao(j2);
                if (messageDao == null) {
                    return null;
                }
                List list = messageDao.queryBuilder().where(MessageDao.Properties.Send_uid.notEq(Long.valueOf(IMContextInfoHelper.getUid())), MessageDao.Properties.Type.not(Integer.valueOf(IMApiConst.MsgTypeUnknow))).orderDesc(MessageDao.Properties.f9175Id).limit(i2).list();
                if (list == null) {
                    return null;
                }
                ArrayList arrayList = new ArrayList(list.size());
                for (int i = 0; i < list.size(); i++) {
                    arrayList.add(new IMMessage((IMMessageDaoEntity) list.get(i)));
                }
                return arrayList;
            }

            /* access modifiers changed from: protected */
            public void onPostExecute(List<IMMessage> list) {
                IMMessagesLoadCallback iMMessagesLoadCallback = iMMessagesLoadCallback2;
                if (iMMessagesLoadCallback != null) {
                    iMMessagesLoadCallback.onHistoryMessageLoad(list, false);
                }
            }
        }.setErrorCallback(getErrorCallback()).executeWithDatabase(new Void[0]);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6282a(IMMessage iMMessage, IMBusinessParam iMBusinessParam, IMSession iMSession, IMSendMessageCallback iMSendMessageCallback) {
        IMSendMessageRequest iMSendMessageRequest;
        if (shouldAddUserInfoReqParams(iMBusinessParam)) {
            iMSendMessageRequest = m6274a(iMSession, iMBusinessParam);
        } else {
            long peerUid = iMSession.getPeerUid();
            iMSendMessageRequest = new IMSendMessageRequest(peerUid, IMContextInfoHelper.getBusinessPayload(iMBusinessParam.getBusinessId() + ""), iMSession.getBusinessId());
        }
        iMSendMessageRequest.addMessage(IMApiParser.parseUpMessage(iMMessage, iMMessage.getUniqueId()));
        final IMBusinessParam iMBusinessParam2 = iMBusinessParam;
        final IMMessage iMMessage2 = iMMessage;
        final IMSession iMSession2 = iMSession;
        final IMSendMessageCallback iMSendMessageCallback2 = iMSendMessageCallback;
        IMHttpManager.getInstance().performCommonPost(iMSendMessageRequest, new IMNetCallback<IMSendMessageResponse>() {
            public void success(IMSendMessageResponse iMSendMessageResponse) {
                String content;
                iMBusinessParam2.clearSecret();
                if (iMMessage2.getType() == 327680) {
                    content = IMResource.getString(R.string.im_bracket_expression);
                } else if (iMMessage2.getType() == 131072) {
                    content = IMResource.getString(R.string.im_bracket_audio);
                } else if (iMMessage2.getType() == 196608) {
                    content = IMResource.getString(R.string.im_bracket_image);
                } else if (iMMessage2.getType() == 10486017) {
                    content = IMResource.getString(R.string.im_bracket_location) + ((IMLocationEntity) IMJsonUtil.objectFromJson(iMMessage2.getContent(), IMLocationEntity.class)).displayname;
                } else if (iMMessage2.getType() == 458752) {
                    IMRichInfoMsgBody iMRichInfoMsgBody = (IMRichInfoMsgBody) IMJsonUtil.objectFromJson(iMMessage2.getContent(), IMRichInfoMsgBody.class);
                    content = iMRichInfoMsgBody != null ? iMRichInfoMsgBody.content : "";
                } else if (iMMessage2.getType() == 393223) {
                    IMPluginService plugin = IMPluginFactory.getPlugin(Parser.parsePluginId(iMMessage2, -1));
                    Context context = IMContextInfoHelper.getContext();
                    if (plugin == null || context == null) {
                        content = iMMessage2.getMessageExtendInfo().list_text;
                    } else {
                        content = plugin.getMessageBracket(context) + iMMessage2.getMessageExtendInfo().list_text;
                    }
                } else {
                    content = iMMessage2.getContent();
                }
                String str = content;
                IMMessageModule iMMessageModule = IMMessageModule.this;
                iMMessageModule.m6280a((IMMessageCallback) iMMessageModule.f9311d.get(iMSession2.getSessionId()), iMMessage2, iMSendMessageResponse, iMSession2, str, iMSendMessageCallback2);
            }

            public void failure(IOException iOException) {
                IMMessageModule iMMessageModule = IMMessageModule.this;
                iMMessageModule.m6280a((IMMessageCallback) iMMessageModule.f9311d.get(iMSession2.getSessionId()), iMMessage2, (IMSendMessageResponse) null, iMSession2, (String) null, iMSendMessageCallback2);
            }
        });
    }

    public void sendStreetViewMessage(final int i, IMBusinessParam iMBusinessParam, IMSession iMSession) {
        IMStreetViewRequest iMStreetViewRequest = new IMStreetViewRequest(i, iMBusinessParam.getBusinessId());
        iMStreetViewRequest.setSessionId(iMSession.getSessionId());
        if (i == 338) {
            IMToastHelper.showLongInfo(IMContextInfoHelper.getContext(), IMContextInfoHelper.getContext().getString(R.string.im_plugin_street_getting));
            iMStreetViewRequest.setDriverUid(iMBusinessParam.getPeerUid());
            iMStreetViewRequest.setPassengerUid(iMBusinessParam.getSelfUid());
        } else {
            IMToastHelper.showLongInfo(IMContextInfoHelper.getContext(), IMContextInfoHelper.getContext().getString(R.string.im_plugin_street_sending));
            iMStreetViewRequest.setDriverUid(iMBusinessParam.getSelfUid());
            iMStreetViewRequest.setPassengerUid(iMBusinessParam.getPeerUid());
        }
        IMHttpManager.getInstance().performCommonPost(iMStreetViewRequest, new IMNetCallback<IMBaseResponseImpl>() {
            public void success(IMBaseResponseImpl iMBaseResponseImpl) {
                String str;
                if (iMBaseResponseImpl != null && iMBaseResponseImpl.isSuccess()) {
                    return;
                }
                if (iMBaseResponseImpl != null && iMBaseResponseImpl.errno == 100000105) {
                    IMMessageModule.this.m6292a(TextUtils.isEmpty(iMBaseResponseImpl.errmsg) ? IMContextInfoHelper.getContext().getString(R.string.im_plugin_street_image_stop_use) : iMBaseResponseImpl.errmsg);
                } else if (iMBaseResponseImpl == null || iMBaseResponseImpl.errno != 100000106) {
                    IMMessageModule.this.m6277a(i);
                } else {
                    if (i == 338) {
                        str = IMContextInfoHelper.getContext().getString(R.string.im_plugin_street_image_get_frequently);
                    } else {
                        str = IMContextInfoHelper.getContext().getString(R.string.im_plugin_street_image_send_frequently);
                    }
                    IMMessageModule iMMessageModule = IMMessageModule.this;
                    if (!TextUtils.isEmpty(iMBaseResponseImpl.errmsg)) {
                        str = iMBaseResponseImpl.errmsg;
                    }
                    iMMessageModule.m6292a(str);
                }
            }

            public void failure(IOException iOException) {
                IMMessageModule.this.m6277a(i);
            }
        });
    }

    public void handleUpdateMessage(final long j, final JSONArray jSONArray) {
        this.f9314g.track();
        new IMTaskJob<Void, Void, List<IMMessage>>() {
            /* access modifiers changed from: protected */
            public List<IMMessage> doInBackground(Void... voidArr) {
                MessageDao messageDao = IMMessageModule.this.mDaoSession.getMessageDao(j);
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    try {
                        String optString = jSONArray.getJSONObject(i).optString("msgId");
                        if (TextUtils.equals(jSONArray.getJSONObject(i).optString("msgAction"), IMEventDispatcher.NOTIFY_EXPIRED_PICTURE) && !TextUtils.isEmpty(optString)) {
                            arrayList.add(optString);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                List<IMMessageDaoEntity> list = messageDao.queryBuilder().where(MessageDao.Properties.Message_id.mo43482in((Collection<?>) arrayList), MessageDao.Properties.Type.mo43483in(196608)).orderAsc(MessageDao.Properties.f9175Id).list();
                ArrayList arrayList2 = new ArrayList();
                for (IMMessageDaoEntity iMMessage : list) {
                    IMMessage iMMessage2 = new IMMessage(iMMessage);
                    IMMessageDownExtend messageExtendInfo = iMMessage2.getMessageExtendInfo();
                    messageExtendInfo.setPicIsExpired(1);
                    iMMessage2.setMessageExtendInfo(messageExtendInfo);
                    arrayList2.add(iMMessage2);
                }
                messageDao.updateInTx(list);
                return arrayList2;
            }

            /* access modifiers changed from: protected */
            public void onPostExecute(List<IMMessage> list) {
                EventBus.getDefault().post(new IMMessageHandleExpiredPicEvent(list));
            }
        }.setErrorCallback(getErrorCallback()).executeWithDatabase(new Void[0]);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6292a(final String str) {
        UiThreadHandler.post(new Runnable() {
            public void run() {
                IMToastHelper.showLongError(IMContextInfoHelper.getContext(), str);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6277a(final int i) {
        UiThreadHandler.post(new Runnable() {
            public void run() {
                if (i == 338) {
                    IMToastHelper.showLongError(IMContextInfoHelper.getContext(), IMContextInfoHelper.getContext().getString(R.string.im_plugin_street_get_failed));
                    return;
                }
                IMToastHelper.showLongError(IMContextInfoHelper.getContext(), IMContextInfoHelper.getContext().getString(R.string.im_plugin_street_send_failed));
            }
        });
    }

    /* renamed from: a */
    private void m6283a(IMMessage iMMessage, IMSession iMSession, boolean z, String str) {
        if (iMMessage != null) {
            if (iMMessage.getStatus() != 200) {
                this.mModelProvider.getSessionModule().updateLastSendMessageSync(iMMessage.getSid(), str, iMMessage.getStatus(), iMSession.getUserInfos().get(1).getUid(), iMMessage.getMid(), iMMessage.getBusinessId());
            } else if (iMMessage.getType() == 393223) {
                this.mModelProvider.getSessionModule().updateLastSendMessageSync(iMMessage.getSid(), str, iMMessage.getStatus(), iMSession.getUserInfos().get(1).getUid(), iMMessage.getMid(), iMMessage.getBusinessId());
            } else if ((iMMessage.getType() == 131072 || iMMessage.getType() == 65536 || iMMessage.getType() == 327680 || iMMessage.getType() == 196608 || iMMessage.getType() == 458752) && iMSession.supportMsgReadStatus) {
                String string = IMResource.getString(z ? R.string.im_last_msg_status_has_read : R.string.im_last_msg_status_un_read);
                IIMSessionModule sessionModule = this.mModelProvider.getSessionModule();
                long sid = iMMessage.getSid();
                sessionModule.updateLastSendMessageSync(sid, string + str, iMMessage.getStatus(), iMSession.getUserInfos().get(1).getUid(), iMMessage.getMid(), iMMessage.getBusinessId());
            }
        }
    }

    public IMMessage sendEmojiMessage(String str, String str2, String str3, String str4, IMBusinessParam iMBusinessParam, IMSession iMSession) {
        IMMessage iMMessage = new IMMessage(327680);
        iMMessage.setContent(str2 + ".gif");
        iMMessage.setFid(str3 + str2 + ".gif");
        iMMessage.emojiDesc = Const.jaLeft + str4 + Const.jaRight;
        iMMessage.emojiID = str;
        return sendTextMessage(m6276a(iMMessage, iMBusinessParam, iMSession, (Object) null, 0, 0, (String) null, 0), iMBusinessParam, iMSession, (IMSendMessageCallback) null);
    }

    public IMMessage sendTextMessage(String str, int i, IMBusinessParam iMBusinessParam, IMSession iMSession, Object obj, int i2, IMSendMessageCallback iMSendMessageCallback) {
        int i3;
        IIMGlobalModule globalModel;
        IMConfig.EggsInfo matchBusinessEggsInfo;
        String str2 = str;
        int i4 = i;
        IMMessage iMMessage = new IMMessage(i);
        iMMessage.setContent(str);
        if (i4 != 65536 || (globalModel = IMManager.getInstance().getGlobalModel()) == null || (matchBusinessEggsInfo = globalModel.matchBusinessEggsInfo(iMSession.getBusinessId(), str)) == null) {
            i3 = 0;
        } else {
            int i5 = matchBusinessEggsInfo.f9125id;
            IMLog.m6631d(f9307a, "[sendTextMessage] match eggs id -> " + matchBusinessEggsInfo.f9125id);
            i3 = i5;
        }
        return sendTextMessage(m6276a(iMMessage, iMBusinessParam, iMSession, obj, i3, 0, (String) null, i2), iMBusinessParam, iMSession, iMSendMessageCallback);
    }

    public IMMessage sendPluginMessage(int i, String str, String str2, int i2, IMBusinessParam iMBusinessParam, IMSession iMSession, IMSendMessageCallback iMSendMessageCallback) {
        IMMessage iMMessage = new IMMessage((int) IMApiConst.MsgTypePlugin);
        String str3 = str;
        iMMessage.setContent(str);
        IMMessage a = m6276a(iMMessage, iMBusinessParam, iMSession, (Object) null, i2, i, str2, 0);
        return sendTextMessage(a, iMBusinessParam, iMSession, iMSendMessageCallback);
    }

    /* renamed from: a */
    private IMMessage m6276a(IMMessage iMMessage, IMBusinessParam iMBusinessParam, IMSession iMSession, Object obj, int i, int i2, String str, int i3) {
        IMLog.m6631d("IMHttpManager", "addMessageInfo");
        this.f9314g.track();
        long uid = IMContextInfoHelper.getUid();
        iMMessage.isSend = true;
        iMMessage.setSid(iMSession.getSessionId());
        iMMessage.setCreateTime(System.currentTimeMillis());
        iMMessage.setStatus(100);
        iMMessage.setIsSend(true);
        iMMessage.setSenderUid(uid);
        IMMessageDownExtend iMMessageDownExtend = new IMMessageDownExtend();
        iMMessageDownExtend.setIs_qk(iMBusinessParam.getIsQuick());
        iMMessageDownExtend.setEmoji_desc(iMMessage.emojiDesc);
        iMMessageDownExtend.setEmoji_id(iMMessage.emojiID);
        iMMessageDownExtend.setExt(obj);
        iMMessageDownExtend.setEid(i);
        iMMessageDownExtend.setPluginId(i2);
        iMMessageDownExtend.list_text = str;
        iMMessageDownExtend.setMsgSource(i3);
        iMMessage.setMessageExtendInfo(iMMessageDownExtend);
        iMMessage.setRouteId(iMBusinessParam.getRouteId());
        iMMessage.setoId(iMBusinessParam.getOrderId());
        iMMessage.setUniqueId(iMSession.getSessionId(), IMIdGenerator.getInstance().getRandId());
        iMMessage.setBusinessId(iMSession.getBusinessId());
        return iMMessage;
    }

    public IMMessage sendTextMessage(IMMessage iMMessage, IMBusinessParam iMBusinessParam, IMSession iMSession, IMSendMessageCallback iMSendMessageCallback) {
        this.f9314g.track();
        final IMMessage iMMessage2 = iMMessage;
        final IMSendMessageCallback iMSendMessageCallback2 = iMSendMessageCallback;
        final IMBusinessParam iMBusinessParam2 = iMBusinessParam;
        final IMSession iMSession2 = iMSession;
        IMThreadHelper.getInstance().execute(new Runnable() {
            public void run() {
                try {
                    IMMessageModule.this.mDaoSession.getMessageDao(iMMessage2.getSid()).insertOrReplace(iMMessage2.getDaoEntity());
                    IMMessageModule.this.m6282a(iMMessage2, iMBusinessParam2, iMSession2, iMSendMessageCallback2);
                } catch (Exception unused) {
                    IMSendMessageCallback iMSendMessageCallback = iMSendMessageCallback2;
                    if (iMSendMessageCallback != null) {
                        iMSendMessageCallback.onError(iMMessage2.getContent(), 100, "InsertMessageError");
                    }
                    IMLog.m6632e(IMMessageModule.f9307a, "database error while sendmsg!");
                }
            }
        });
        return iMMessage;
    }

    public void updateMessageAsync(final IMMessage iMMessage) {
        this.f9314g.track();
        new IMTaskJob<Void, Void, Long>() {
            /* access modifiers changed from: protected */
            public Long doInBackground(Void... voidArr) {
                IMMessageModule.this.mDaoSession.getMessageDao(iMMessage.getSid()).update(iMMessage.getDaoEntity());
                return 0L;
            }
        }.setErrorCallback(getErrorCallback()).execute(new Void[0]);
    }

    /* renamed from: a */
    private long m6273a() {
        for (int i = 0; i < this.f9311d.size(); i++) {
            IMMessageCallback valueAt = this.f9311d.valueAt(i);
            if (valueAt instanceof IMMessageCallBackImp) {
                return ((IMMessageCallBackImp) valueAt).getSid();
            }
        }
        return 0;
    }

    public void pullSingleMessageForUploadData(int i, long j) {
        this.f9315h = true;
        this.f9310c = 0;
        pullSingleMessage(i, j, 6);
    }

    public void pullSingleMessage(int i, long j, int i2) {
        this.f9314g.track();
        this.f9317j.add(Integer.valueOf(i2));
        if (this.f9317j.size() > 1) {
            IMLog.m6632e(f9307a, "pull queue not empty,size is " + this.f9317j.size());
            if (this.f9317j.size() > 10) {
                IMTraceUtil.BusinessParam addBusinessEvent = IMTraceUtil.addBusinessEvent("tech_im_pull_msg_queue_too_much");
                IMTraceUtil.BusinessParam add = addBusinessEvent.add("max_id", "" + this.f9310c);
                add.add("queue_size", "" + this.f9317j.size()).report();
                return;
            }
            return;
        }
        if (i2 == 0) {
            IMTraceError.trackError("im_pull_scene_error", new IllegalStateException("request scene is admin"));
        }
        IMPullMessageRequest iMPullMessageRequest = new IMPullMessageRequest(i, i2);
        if (TextUtils.isEmpty(iMPullMessageRequest.token)) {
            this.f9317j.clear();
            IMLog.m6632e(f9307a, "pull queue but request token is empty");
            return;
        }
        if (j >= 0) {
            iMPullMessageRequest.setAckSid(j);
            iMPullMessageRequest.isPollingRequest = false;
        } else {
            iMPullMessageRequest.isPollingRequest = true;
        }
        iMPullMessageRequest.setNotifyAuthority(NotificationUtils.getNotificationEnableStatus());
        if (this.f9315h) {
            iMPullMessageRequest.isSync(1);
            this.f9315h = false;
        } else {
            iMPullMessageRequest.isSync(0);
        }
        iMPullMessageRequest.setSid(m6273a());
        iMPullMessageRequest.singleLastMid(this.f9310c);
        final int i3 = i;
        final long j2 = j;
        final int i4 = i2;
        IMHttpManager.getInstance().pullMessage(iMPullMessageRequest, iMPullMessageRequest.isPollingRequest, new IMNetCallback<IMPullMessageResponse>() {
            /* JADX WARNING: Can't fix incorrect switch cases order */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void success(com.didi.beatles.p099im.api.entity.IMPullMessageResponse r18) {
                /*
                    r17 = this;
                    r1 = r17
                    r2 = r18
                    com.didi.beatles.im.module.impl.IMMessageModule r0 = com.didi.beatles.p099im.module.impl.IMMessageModule.this
                    java.util.LinkedList r3 = r0.f9317j
                    monitor-enter(r3)
                    if (r2 == 0) goto L_0x0284
                    boolean r0 = r18.isSuccess()     // Catch:{ all -> 0x028f }
                    if (r0 == 0) goto L_0x0284
                    com.didi.beatles.im.api.entity.IMPullMessageResponse$Body r0 = r2.body     // Catch:{ all -> 0x028f }
                    if (r0 == 0) goto L_0x0284
                    com.didi.beatles.im.api.entity.IMPullMessageResponse$Body r0 = r2.body     // Catch:{ all -> 0x028f }
                    long r4 = r0.backfill_uid     // Catch:{ all -> 0x028f }
                    long r6 = com.didi.beatles.p099im.IMContextInfoHelper.getUid()     // Catch:{ all -> 0x028f }
                    int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                    if (r0 == 0) goto L_0x0025
                    goto L_0x0284
                L_0x0025:
                    com.didi.beatles.im.api.entity.IMPullMessageResponse$Body r0 = r2.body     // Catch:{ all -> 0x028f }
                    com.didi.beatles.im.api.entity.IMPullMessageResponse$Single r0 = r0.single     // Catch:{ all -> 0x028f }
                    java.util.List<com.didi.beatles.im.api.entity.IMMessageDown> r4 = r0.msgs     // Catch:{ all -> 0x028f }
                    if (r4 == 0) goto L_0x0279
                    boolean r0 = r4.isEmpty()     // Catch:{ all -> 0x028f }
                    if (r0 == 0) goto L_0x0035
                    goto L_0x0279
                L_0x0035:
                    int r0 = r8     // Catch:{ all -> 0x028f }
                    com.didi.beatles.im.api.entity.IMPullMessageResponse$Body r5 = r2.body     // Catch:{ all -> 0x028f }
                    int r5 = r5.pullScene     // Catch:{ all -> 0x028f }
                    if (r0 == r5) goto L_0x0049
                    java.lang.String r0 = "im_pull_scene_error"
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException     // Catch:{ all -> 0x028f }
                    java.lang.String r6 = "response scene is not same"
                    r5.<init>(r6)     // Catch:{ all -> 0x028f }
                    com.didi.beatles.p099im.omega.IMTraceError.trackError(r0, r5)     // Catch:{ all -> 0x028f }
                L_0x0049:
                    int r5 = r4.size()     // Catch:{ all -> 0x028f }
                    java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ all -> 0x028f }
                    r6.<init>()     // Catch:{ all -> 0x028f }
                    r7 = 0
                    r8 = 0
                L_0x0054:
                    if (r8 >= r5) goto L_0x01cf
                    java.lang.Object r0 = r4.get(r8)     // Catch:{ all -> 0x028f }
                    com.didi.beatles.im.api.entity.IMMessageDown r0 = (com.didi.beatles.p099im.api.entity.IMMessageDown) r0     // Catch:{ all -> 0x028f }
                    r9 = 1
                    com.didi.beatles.im.module.entity.IMMessage r10 = com.didi.beatles.p099im.api.IMApiParser.parseDownMessage((com.didi.beatles.p099im.api.entity.IMMessageDown) r0, (int) r9)     // Catch:{ all -> 0x028f }
                    r10.setIsSend(r7)     // Catch:{ all -> 0x028f }
                    r0 = 200(0xc8, float:2.8E-43)
                    r10.setStatus(r0)     // Catch:{ all -> 0x028f }
                    com.didi.beatles.im.api.entity.IMPullMessageResponse$Body r0 = r2.body     // Catch:{ all -> 0x028f }
                    int r0 = r0.pullScene     // Catch:{ all -> 0x028f }
                    r10.pullScene = r0     // Catch:{ all -> 0x028f }
                    int r0 = r10.getType()     // Catch:{ all -> 0x028f }
                    r11 = 589824(0x90000, float:8.2652E-40)
                    switch(r0) {
                        case 65536: goto L_0x00b0;
                        case 65537: goto L_0x00b0;
                        case 131072: goto L_0x00b0;
                        case 196608: goto L_0x00b0;
                        case 327680: goto L_0x00b0;
                        case 393217: goto L_0x00b0;
                        case 393219: goto L_0x00b0;
                        case 393220: goto L_0x00b0;
                        case 393223: goto L_0x00b0;
                        case 393224: goto L_0x00b0;
                        case 458752: goto L_0x00b0;
                        case 524289: goto L_0x007c;
                        case 528385: goto L_0x00b0;
                        case 10485761: goto L_0x00b0;
                        case 10485762: goto L_0x00b0;
                        case 10486017: goto L_0x00b0;
                        default: goto L_0x0078;
                    }     // Catch:{ all -> 0x028f }
                L_0x0078:
                    r10.setType(r11)     // Catch:{ all -> 0x028f }
                    goto L_0x00b0
                L_0x007c:
                    java.lang.String r0 = "im_send_command_msg"
                    com.didi.beatles.im.omega.IMTraceUtil$BusinessParam r0 = com.didi.beatles.p099im.omega.IMTraceUtil.addBusinessEvent(r0)     // Catch:{ all -> 0x028f }
                    java.lang.String r12 = "actionId"
                    java.lang.String r13 = r10.getActionId()     // Catch:{ all -> 0x028f }
                    com.didi.beatles.im.omega.IMTraceUtil$BusinessParam r0 = r0.add(r12, r13)     // Catch:{ all -> 0x028f }
                    java.lang.String r12 = "type"
                    java.lang.String r13 = "get"
                    com.didi.beatles.im.omega.IMTraceUtil$BusinessParam r0 = r0.add(r12, r13)     // Catch:{ all -> 0x028f }
                    r0.report()     // Catch:{ all -> 0x028f }
                    com.didi.beatles.im.module.impl.IMMessageModule r0 = com.didi.beatles.p099im.module.impl.IMMessageModule.this     // Catch:{ all -> 0x028f }
                    com.didi.beatles.im.service.IMServiceProvider r0 = r0.getServiceProvider()     // Catch:{ all -> 0x028f }
                    android.content.Context r0 = r0.getContext()     // Catch:{ all -> 0x028f }
                    boolean r0 = com.didi.beatles.p099im.event.IMEventDispatcher.dispatchIMMessage(r0, r10)     // Catch:{ all -> 0x028f }
                    if (r0 == 0) goto L_0x00b0
                    com.didi.beatles.im.module.impl.IMMessageModule r0 = com.didi.beatles.p099im.module.impl.IMMessageModule.this     // Catch:{ all -> 0x028f }
                    long r12 = r10.getMid()     // Catch:{ all -> 0x028f }
                    r0.m6279a((long) r12)     // Catch:{ all -> 0x028f }
                L_0x00b0:
                    java.lang.String r0 = "ddim_message_arrive_sw"
                    com.didi.beatles.im.omega.IMTraceUtil$BusinessParam r0 = com.didi.beatles.p099im.omega.IMMessageTraceUtil.trackMessageCoreEvent(r0, r10)     // Catch:{ all -> 0x028f }
                    java.lang.String r12 = "notify_authority"
                    boolean r13 = com.didi.beatles.p099im.access.notify.NotificationUtils.getNotificationEnableStatus()     // Catch:{ all -> 0x028f }
                    if (r13 == 0) goto L_0x00c0
                    r13 = 1
                    goto L_0x00c1
                L_0x00c0:
                    r13 = 0
                L_0x00c1:
                    java.lang.Integer r13 = java.lang.Integer.valueOf(r13)     // Catch:{ all -> 0x028f }
                    com.didi.beatles.im.omega.IMTraceUtil$BusinessParam r0 = r0.add(r12, r13)     // Catch:{ all -> 0x028f }
                    r0.report()     // Catch:{ all -> 0x028f }
                    boolean r0 = com.didi.beatles.p099im.access.utils.Parser.parseIsAnonRobotMessage(r10)     // Catch:{ all -> 0x028f }
                    r12 = 2
                    if (r0 == 0) goto L_0x00ff
                    java.lang.String r0 = "IMM"
                    java.lang.String r11 = "[pullSingleMessage] is anon robot message, not need insert message"
                    com.didi.beatles.p099im.utils.IMLog.m6631d(r0, r11)     // Catch:{ all -> 0x028f }
                    int r0 = r10.mact     // Catch:{ all -> 0x028f }
                    if (r0 != r9) goto L_0x00e4
                    com.didi.beatles.im.module.impl.IMMessageModule r0 = com.didi.beatles.p099im.module.impl.IMMessageModule.this     // Catch:{ all -> 0x028f }
                    r0.m6281a((com.didi.beatles.p099im.module.entity.IMMessage) r10)     // Catch:{ all -> 0x028f }
                    goto L_0x00f4
                L_0x00e4:
                    int r0 = r10.mact     // Catch:{ all -> 0x028f }
                    if (r0 != r12) goto L_0x00f4
                    com.didi.beatles.im.module.impl.IMMessageModule r0 = com.didi.beatles.p099im.module.impl.IMMessageModule.this     // Catch:{ all -> 0x028f }
                    r0.m6281a((com.didi.beatles.p099im.module.entity.IMMessage) r10)     // Catch:{ all -> 0x028f }
                    android.content.Context r0 = com.didi.beatles.p099im.IMContextInfoHelper.getContext()     // Catch:{ all -> 0x028f }
                    com.didi.beatles.p099im.event.IMEventDispatcher.sendLocalBroadcast4DMC(r0, r10)     // Catch:{ all -> 0x028f }
                L_0x00f4:
                    com.didi.beatles.im.module.impl.IMMessageModule r0 = com.didi.beatles.p099im.module.impl.IMMessageModule.this     // Catch:{ all -> 0x028f }
                    long r9 = r10.getMid()     // Catch:{ all -> 0x028f }
                    r0.m6279a((long) r9)     // Catch:{ all -> 0x028f }
                    goto L_0x01cb
                L_0x00ff:
                    int r0 = r10.getType()     // Catch:{ all -> 0x028f }
                    r13 = 524289(0x80001, float:7.34685E-40)
                    if (r0 == r13) goto L_0x01cb
                    long r13 = r10.getSenderUid()     // Catch:{ Exception -> 0x0145 }
                    long r15 = com.didi.beatles.p099im.IMContextInfoHelper.getUid()     // Catch:{ Exception -> 0x0145 }
                    int r0 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
                    if (r0 != 0) goto L_0x0125
                    java.lang.String r0 = r10.getContent()     // Catch:{ Exception -> 0x0145 }
                    long r13 = com.didi.beatles.p099im.access.utils.Parser.parsePeerSessionId(r0)     // Catch:{ Exception -> 0x0145 }
                    r15 = 0
                    int r0 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
                    if (r0 <= 0) goto L_0x0125
                    r10.setSid(r13)     // Catch:{ Exception -> 0x0145 }
                L_0x0125:
                    com.didi.beatles.im.module.impl.IMMessageModule r0 = com.didi.beatles.p099im.module.impl.IMMessageModule.this     // Catch:{ Exception -> 0x0145 }
                    com.didi.beatles.im.db.dao.DaoSession r0 = r0.mDaoSession     // Catch:{ Exception -> 0x0145 }
                    long r13 = r10.getSid()     // Catch:{ Exception -> 0x0145 }
                    com.didi.beatles.im.db.dao.MessageDao r0 = r0.getMessageDao(r13)     // Catch:{ Exception -> 0x0145 }
                    com.didi.beatles.im.db.entity.IMMessageDaoEntity r13 = r10.getDaoEntity()     // Catch:{ Exception -> 0x0145 }
                    r0.insert(r13)     // Catch:{ Exception -> 0x0145 }
                    com.didi.beatles.im.module.impl.IMMessageModule r0 = com.didi.beatles.p099im.module.impl.IMMessageModule.this     // Catch:{ Exception -> 0x0145 }
                    long r13 = r10.getMid()     // Catch:{ Exception -> 0x0145 }
                    r0.m6279a((long) r13)     // Catch:{ Exception -> 0x0145 }
                    r0 = 1
                    goto L_0x0177
                L_0x0145:
                    r0 = move-exception
                    java.lang.String r13 = "im_message_pull_insert_error"
                    java.lang.IllegalStateException r14 = new java.lang.IllegalStateException     // Catch:{ all -> 0x028f }
                    r14.<init>(r0)     // Catch:{ all -> 0x028f }
                    com.didi.beatles.p099im.omega.IMTraceError.trackError(r13, r14)     // Catch:{ all -> 0x028f }
                    java.lang.String r0 = "IMM"
                    java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x028f }
                    r13.<init>()     // Catch:{ all -> 0x028f }
                    java.lang.String r14 = "[pullSingleMessage] #insertMessage#  Error message id is "
                    r13.append(r14)     // Catch:{ all -> 0x028f }
                    long r14 = r10.getMid()     // Catch:{ all -> 0x028f }
                    r13.append(r14)     // Catch:{ all -> 0x028f }
                    java.lang.String r14 = " message content is "
                    r13.append(r14)     // Catch:{ all -> 0x028f }
                    java.lang.String r14 = r10.getContent()     // Catch:{ all -> 0x028f }
                    r13.append(r14)     // Catch:{ all -> 0x028f }
                    java.lang.String r13 = r13.toString()     // Catch:{ all -> 0x028f }
                    com.didi.beatles.p099im.utils.IMLog.m6631d(r0, r13)     // Catch:{ all -> 0x028f }
                    r0 = 0
                L_0x0177:
                    if (r0 == 0) goto L_0x01cb
                    int r0 = r10.getType()     // Catch:{ all -> 0x028f }
                    if (r0 == r11) goto L_0x01cb
                    r6.add(r10)     // Catch:{ all -> 0x028f }
                    int r0 = r10.mact     // Catch:{ all -> 0x028f }
                    r11 = 327680(0x50000, float:4.59177E-40)
                    if (r0 != r9) goto L_0x01aa
                    boolean r0 = com.didi.beatles.p099im.access.utils.Parser.parseIsRobotMessage(r10)     // Catch:{ all -> 0x028f }
                    if (r0 == 0) goto L_0x0194
                    com.didi.beatles.im.module.impl.IMMessageModule r0 = com.didi.beatles.p099im.module.impl.IMMessageModule.this     // Catch:{ all -> 0x028f }
                    r0.m6281a((com.didi.beatles.p099im.module.entity.IMMessage) r10)     // Catch:{ all -> 0x028f }
                    goto L_0x01cb
                L_0x0194:
                    int r0 = r10.getType()     // Catch:{ all -> 0x028f }
                    if (r0 != r11) goto L_0x01a0
                    com.didi.beatles.im.module.impl.IMMessageModule r0 = com.didi.beatles.p099im.module.impl.IMMessageModule.this     // Catch:{ all -> 0x028f }
                    r0.m6295b((com.didi.beatles.p099im.module.entity.IMMessage) r10)     // Catch:{ all -> 0x028f }
                    goto L_0x01cb
                L_0x01a0:
                    android.content.Context r0 = com.didi.beatles.p099im.IMContextInfoHelper.getContext()     // Catch:{ all -> 0x028f }
                    java.lang.String r9 = "receive_message_to_tts_action"
                    com.didi.beatles.p099im.event.IMEventDispatcher.sendLocalBroadcast(r0, r9, r10)     // Catch:{ all -> 0x028f }
                    goto L_0x01cb
                L_0x01aa:
                    int r0 = r10.mact     // Catch:{ all -> 0x028f }
                    if (r0 != r12) goto L_0x01cb
                    android.content.Context r0 = com.didi.beatles.p099im.IMContextInfoHelper.getContext()     // Catch:{ all -> 0x028f }
                    com.didi.beatles.p099im.event.IMEventDispatcher.sendLocalBroadcast4DMC(r0, r10)     // Catch:{ all -> 0x028f }
                    boolean r0 = com.didi.beatles.p099im.access.utils.Parser.parseIsRobotMessage(r10)     // Catch:{ all -> 0x028f }
                    if (r0 == 0) goto L_0x01c0
                    com.didi.beatles.im.module.impl.IMMessageModule r0 = com.didi.beatles.p099im.module.impl.IMMessageModule.this     // Catch:{ all -> 0x028f }
                    r0.m6281a((com.didi.beatles.p099im.module.entity.IMMessage) r10)     // Catch:{ all -> 0x028f }
                L_0x01c0:
                    int r0 = r10.getType()     // Catch:{ all -> 0x028f }
                    if (r0 != r11) goto L_0x01cb
                    com.didi.beatles.im.module.impl.IMMessageModule r0 = com.didi.beatles.p099im.module.impl.IMMessageModule.this     // Catch:{ all -> 0x028f }
                    r0.m6295b((com.didi.beatles.p099im.module.entity.IMMessage) r10)     // Catch:{ all -> 0x028f }
                L_0x01cb:
                    int r8 = r8 + 1
                    goto L_0x0054
                L_0x01cf:
                    java.util.HashMap r0 = new java.util.HashMap     // Catch:{ all -> 0x028f }
                    r0.<init>()     // Catch:{ all -> 0x028f }
                    boolean r4 = r6.isEmpty()     // Catch:{ all -> 0x028f }
                    if (r4 != 0) goto L_0x021b
                L_0x01da:
                    int r4 = r6.size()     // Catch:{ all -> 0x028f }
                    if (r7 >= r4) goto L_0x020c
                    java.lang.Object r4 = r6.get(r7)     // Catch:{ all -> 0x028f }
                    com.didi.beatles.im.module.entity.IMMessage r4 = (com.didi.beatles.p099im.module.entity.IMMessage) r4     // Catch:{ all -> 0x028f }
                    long r8 = r4.getSid()     // Catch:{ all -> 0x028f }
                    java.lang.Long r8 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x028f }
                    java.lang.Object r8 = r0.get(r8)     // Catch:{ all -> 0x028f }
                    java.util.ArrayList r8 = (java.util.ArrayList) r8     // Catch:{ all -> 0x028f }
                    if (r8 != 0) goto L_0x0206
                    java.util.ArrayList r8 = new java.util.ArrayList     // Catch:{ all -> 0x028f }
                    r8.<init>()     // Catch:{ all -> 0x028f }
                    long r9 = r4.getSid()     // Catch:{ all -> 0x028f }
                    java.lang.Long r9 = java.lang.Long.valueOf(r9)     // Catch:{ all -> 0x028f }
                    r0.put(r9, r8)     // Catch:{ all -> 0x028f }
                L_0x0206:
                    r8.add(r4)     // Catch:{ all -> 0x028f }
                    int r7 = r7 + 1
                    goto L_0x01da
                L_0x020c:
                    com.didi.beatles.im.module.impl.IMMessageModule r4 = com.didi.beatles.p099im.module.impl.IMMessageModule.this     // Catch:{ all -> 0x028f }
                    com.didi.beatles.im.module.impl.IMModelProvider r4 = r4.mModelProvider     // Catch:{ all -> 0x028f }
                    com.didi.beatles.im.module.IIMSessionModule r4 = r4.getSessionModule()     // Catch:{ all -> 0x028f }
                    if (r4 == 0) goto L_0x021b
                    r4.updateSessionStateByMessageAsync(r0)     // Catch:{ all -> 0x028f }
                L_0x021b:
                    r7 = -1
                    java.lang.Long r4 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x028f }
                    r0.put(r4, r6)     // Catch:{ all -> 0x028f }
                    com.didi.beatles.im.api.entity.IMPullMessageResponse$Body r4 = r2.body     // Catch:{ all -> 0x028f }
                    if (r4 == 0) goto L_0x0260
                    com.didi.beatles.im.api.entity.IMPullMessageResponse$Body r4 = r2.body     // Catch:{ all -> 0x028f }
                    com.didi.beatles.im.api.entity.IMPullMessageResponse$Single r4 = r4.single     // Catch:{ all -> 0x028f }
                    if (r4 == 0) goto L_0x0260
                    int r4 = r6.size()     // Catch:{ all -> 0x028f }
                    if (r5 != r4) goto L_0x0260
                    com.didi.beatles.im.module.impl.IMMessageModule r4 = com.didi.beatles.p099im.module.impl.IMMessageModule.this     // Catch:{ all -> 0x028f }
                    long r4 = r4.f9310c     // Catch:{ all -> 0x028f }
                    com.didi.beatles.im.api.entity.IMPullMessageResponse$Body r6 = r2.body     // Catch:{ all -> 0x028f }
                    com.didi.beatles.im.api.entity.IMPullMessageResponse$Single r6 = r6.single     // Catch:{ all -> 0x028f }
                    long r6 = r6.max_mid     // Catch:{ all -> 0x028f }
                    int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                    if (r8 >= 0) goto L_0x0260
                    com.didi.beatles.im.module.impl.IMMessageModule r4 = com.didi.beatles.p099im.module.impl.IMMessageModule.this     // Catch:{ all -> 0x028f }
                    java.util.LinkedList r4 = r4.f9317j     // Catch:{ all -> 0x028f }
                    if (r4 == 0) goto L_0x0255
                    com.didi.beatles.im.module.impl.IMMessageModule r4 = com.didi.beatles.p099im.module.impl.IMMessageModule.this     // Catch:{ all -> 0x028f }
                    java.util.LinkedList r4 = r4.f9317j     // Catch:{ all -> 0x028f }
                    r4.clear()     // Catch:{ all -> 0x028f }
                L_0x0255:
                    com.didi.beatles.im.module.impl.IMMessageModule r4 = com.didi.beatles.p099im.module.impl.IMMessageModule.this     // Catch:{ all -> 0x028f }
                    int r5 = r5     // Catch:{ all -> 0x028f }
                    long r6 = r6     // Catch:{ all -> 0x028f }
                    int r8 = r8     // Catch:{ all -> 0x028f }
                    r4.pullSingleMessage(r5, r6, r8)     // Catch:{ all -> 0x028f }
                L_0x0260:
                    com.didi.beatles.im.module.impl.IMMessageModule r4 = com.didi.beatles.p099im.module.impl.IMMessageModule.this     // Catch:{ all -> 0x028f }
                    int r5 = r5     // Catch:{ all -> 0x028f }
                    long r6 = r6     // Catch:{ all -> 0x028f }
                    r4.m6278a((int) r5, (long) r6)     // Catch:{ all -> 0x028f }
                    com.didi.beatles.im.module.impl.IMMessageModule r4 = com.didi.beatles.p099im.module.impl.IMMessageModule.this     // Catch:{ all -> 0x028f }
                    android.os.Handler r4 = r4.f9316i     // Catch:{ all -> 0x028f }
                    com.didi.beatles.im.module.impl.IMMessageModule$15$1 r5 = new com.didi.beatles.im.module.impl.IMMessageModule$15$1     // Catch:{ all -> 0x028f }
                    r5.<init>(r0, r2)     // Catch:{ all -> 0x028f }
                    r4.post(r5)     // Catch:{ all -> 0x028f }
                    monitor-exit(r3)     // Catch:{ all -> 0x028f }
                    return
                L_0x0279:
                    com.didi.beatles.im.module.impl.IMMessageModule r0 = com.didi.beatles.p099im.module.impl.IMMessageModule.this     // Catch:{ all -> 0x028f }
                    int r2 = r5     // Catch:{ all -> 0x028f }
                    long r4 = r6     // Catch:{ all -> 0x028f }
                    r0.m6278a((int) r2, (long) r4)     // Catch:{ all -> 0x028f }
                    monitor-exit(r3)     // Catch:{ all -> 0x028f }
                    return
                L_0x0284:
                    com.didi.beatles.im.module.impl.IMMessageModule r0 = com.didi.beatles.p099im.module.impl.IMMessageModule.this     // Catch:{ all -> 0x028f }
                    int r2 = r5     // Catch:{ all -> 0x028f }
                    long r4 = r6     // Catch:{ all -> 0x028f }
                    r0.m6278a((int) r2, (long) r4)     // Catch:{ all -> 0x028f }
                    monitor-exit(r3)     // Catch:{ all -> 0x028f }
                    return
                L_0x028f:
                    r0 = move-exception
                    monitor-exit(r3)     // Catch:{ all -> 0x028f }
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.didi.beatles.p099im.module.impl.IMMessageModule.C404815.success(com.didi.beatles.im.api.entity.IMPullMessageResponse):void");
            }

            public void failure(IOException iOException) {
                IMMessageModule.this.m6278a(i3, j2);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6278a(final int i, final long j) {
        this.f9316i.post(new Runnable() {
            public void run() {
                if (IMMessageModule.this.f9317j == null) {
                    return;
                }
                if (IMMessageModule.this.f9317j.size() > 1) {
                    Integer num = null;
                    try {
                        num = (Integer) IMMessageModule.this.f9317j.getLast();
                    } catch (Exception e) {
                        IMLog.m6633e(e);
                    }
                    IMMessageModule.this.f9317j.clear();
                    if (num != null) {
                        IMMessageModule.this.pullSingleMessage(i, j, num.intValue());
                        return;
                    }
                    return;
                }
                IMMessageModule.this.f9317j.clear();
            }
        });
    }

    public void loadAudioMessage(IMMessage iMMessage, long j, IMMessageCallback iMMessageCallback) {
        this.f9314g.track();
        if (iMMessage != null) {
            final String fid = iMMessage.getFid();
            IMHttpManager instance = IMHttpManager.getInstance();
            final long j2 = j;
            final IMMessage iMMessage2 = iMMessage;
            final IMMessageCallback iMMessageCallback2 = iMMessageCallback;
            instance.getDownloadFileInfo(IMApiUrl.getCommonHostOnline() + IMApiUrl.IM_DOWNLOAD_VOICE_PATH + fid, new IMNetCallback<GiftQueryResponse>() {
                public void success(GiftQueryResponse giftQueryResponse) {
                    if (giftQueryResponse != null) {
                        final String str = IMMessageModule.this.f9309b.getTmpPath() + fid;
                        IMHttpManager.getInstance().downloadFile(giftQueryResponse.download_url_https, str, new IMNetCallback<Boolean>() {
                            public void success(Boolean bool) {
                                if (bool.booleanValue()) {
                                    String saveFile = IMMessageModule.this.f9309b.saveFile(new File(str), j2, fid, 101);
                                    if (saveFile != null) {
                                        iMMessage2.setFile_name(saveFile);
                                        iMMessage2.setStatus(200);
                                        IMMessageModule.this.mDaoSession.getMessageDao(j2).update(iMMessage2.getDaoEntity());
                                    } else {
                                        iMMessage2.setStatus(300);
                                    }
                                    IMMessageModule.this.f9316i.post(new Runnable() {
                                        public void run() {
                                            if (iMMessageCallback2 != null) {
                                                iMMessageCallback2.onSendStatusChanged(iMMessage2, 301, (IMSendMessageResponse) null);
                                            }
                                        }
                                    });
                                }
                            }

                            public void failure(IOException iOException) {
                                IMMessageModule.this.f9316i.post(new Runnable() {
                                    public void run() {
                                        if (iMMessageCallback2 != null) {
                                            iMMessageCallback2.onSendStatusChanged(iMMessage2, 302, (IMSendMessageResponse) null);
                                        }
                                    }
                                });
                            }
                        });
                    }
                }

                public void failure(IOException iOException) {
                    IMMessageModule.this.f9316i.post(new Runnable() {
                        public void run() {
                            if (iMMessageCallback2 != null) {
                                iMMessageCallback2.onSendStatusChanged(iMMessage2, 302, (IMSendMessageResponse) null);
                            }
                        }
                    });
                }
            });
        }
    }

    public void insertMessage(final IMMessage iMMessage) {
        this.f9314g.track();
        new IMTaskJob<Void, Void, Long>() {
            /* access modifiers changed from: protected */
            public Long doInBackground(Void... voidArr) {
                try {
                    return Long.valueOf(IMMessageModule.this.mDaoSession.getMessageDao(iMMessage.getDaoEntity().getSession_id()).insert(iMMessage.getDaoEntity()));
                } catch (Exception e) {
                    IMLog.m6631d(IMMessageModule.f9307a, "插入失败  Error" + e.getMessage());
                    return -1L;
                }
            }

            /* access modifiers changed from: protected */
            public void onPostExecute(Long l) {
                super.onPostExecute(l);
            }
        }.setErrorCallback(getErrorCallback()).execute(new Void[0]);
    }

    public void deleteMessage(final IMMessage iMMessage, IMMessageCallback iMMessageCallback) {
        this.f9314g.track();
        if (iMMessage != null) {
            IMLog.m6635i("deleteMessage " + iMMessage.getUniqueId(), new Object[0]);
            this.f9312e.put(iMMessage.getUniqueId(), iMMessageCallback);
            new IMTaskJob<Void, Void, Long>() {
                /* access modifiers changed from: protected */
                public Long doInBackground(Void... voidArr) {
                    try {
                        long session_id = iMMessage.getDaoEntity().getSession_id();
                        IMMessageModule.this.mDaoSession.getMessageDao(session_id).delete(iMMessage.getDaoEntity());
                        IIMSessionModule sessionModule = IMMessageModule.this.mModelProvider.getSessionModule();
                        if (sessionModule != null) {
                            sessionModule.updateRecentMessages(session_id);
                        }
                        return 0L;
                    } catch (Exception e) {
                        IMLog.m6631d(IMMessageModule.f9307a, "删除 Error" + e.getMessage());
                        return -1L;
                    }
                }

                /* access modifiers changed from: protected */
                public void onPostExecute(Long l) {
                    IMMessageCallback iMMessageCallback = (IMMessageCallback) IMMessageModule.this.f9312e.get(iMMessage.getUniqueId());
                    if (iMMessageCallback == null) {
                        return;
                    }
                    if (l.longValue() == 0) {
                        iMMessageCallback.onSendStatusChanged(iMMessage, 401, (IMSendMessageResponse) null);
                    } else {
                        iMMessageCallback.onSendStatusChanged(iMMessage, 402, (IMSendMessageResponse) null);
                    }
                }
            }.setErrorCallback(getErrorCallback()).executeWithDatabase(new Void[0]);
        }
    }

    public void queryMessage(final Collection<IMMessageFilter> collection, final IMMessageCallback iMMessageCallback) {
        this.f9314g.track();
        boolean z = false;
        if (collection == null || collection.size() == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("queryMessage Error messageIds size 0 when null ");
            if (collection == null) {
                z = true;
            }
            sb.append(String.valueOf(z));
            IMLog.m6631d(f9307a, sb.toString());
            return;
        }
        new IMTaskJob<Void, Void, Collection<IMMessage>>() {
            /* access modifiers changed from: protected */
            public Collection<IMMessage> doInBackground(Void... voidArr) {
                Map classifyCollection = IMModelHelper.classifyCollection(collection, new IMModelHelper.ClassifyValue<Long, IMMessageFilter>() {
                    public Long getKey(IMMessageFilter iMMessageFilter) {
                        return Long.valueOf(iMMessageFilter == null ? 0 : IMParseUtil.parseLong(iMMessageFilter.sessionId));
                    }
                });
                Map wrapperCollectionMap = IMModelHelper.wrapperCollectionMap(IMModelHelper.filterCollection(classifyCollection.keySet(), new IMModelHelper.FilterValue<Long>() {
                    public boolean isFilter(Long l) {
                        return IMMessageModule.this.mDaoSession.containsMessageDao(l.longValue());
                    }
                }), new IMModelHelper.WrapperValue<Long, MessageDao>() {
                    public MessageDao wrapper(Long l) {
                        return IMMessageModule.this.mDaoSession.getMessageDao(l.longValue());
                    }
                });
                if (wrapperCollectionMap.size() == 0) {
                    return null;
                }
                LinkedList linkedList = new LinkedList();
                for (Long l : wrapperCollectionMap.keySet()) {
                    MessageDao messageDao = (MessageDao) wrapperCollectionMap.get(l);
                    Map classifyCollection2 = IMModelHelper.classifyCollection((Collection) classifyCollection.get(l), new IMModelHelper.ClassifyValue<Long, IMMessageFilter>() {
                        public Long getKey(IMMessageFilter iMMessageFilter) {
                            return Long.valueOf(iMMessageFilter == null ? 0 : IMParseUtil.parseLong(iMMessageFilter.userId));
                        }
                    });
                    for (Long l2 : classifyCollection2.keySet()) {
                        Collection wrapperCollection = IMModelHelper.wrapperCollection((Collection) classifyCollection2.get(l2), new IMModelHelper.WrapperValue<IMMessageFilter, Long>() {
                            public Long wrapper(IMMessageFilter iMMessageFilter) {
                                return Long.valueOf(iMMessageFilter == null ? 0 : Long.parseLong(iMMessageFilter.messageId));
                            }
                        });
                        linkedList.addAll(messageDao.queryBuilder().where(MessageDao.Properties.Send_uid.mo43479eq(l2), MessageDao.Properties.Message_id.mo43482in((Collection<?>) wrapperCollection)).build().list());
                    }
                }
                return IMModelHelper.wrapperCollection(linkedList, new IMModelHelper.WrapperValue<IMMessageDaoEntity, IMMessage>() {
                    public IMMessage wrapper(IMMessageDaoEntity iMMessageDaoEntity) {
                        return new IMMessage(iMMessageDaoEntity);
                    }
                });
            }

            /* access modifiers changed from: protected */
            public void onPostExecute(Collection<IMMessage> collection) {
                IMMessageCallback iMMessageCallback = iMMessageCallback;
                if (iMMessageCallback == null) {
                    return;
                }
                if (collection instanceof List) {
                    iMMessageCallback.onReceive((List) collection);
                } else if (collection != null) {
                    iMMessageCallback.onReceive(new ArrayList(collection));
                } else {
                    iMMessageCallback.onReceive(new ArrayList());
                }
            }
        }.setErrorCallback(getErrorCallback()).executeWithDatabase(new Void[0]);
    }

    public void updateMessage(final Collection<IMMessage> collection, final IMMessageCallback iMMessageCallback) {
        this.f9314g.track();
        boolean z = false;
        if (collection == null || collection.size() == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("updateMessage Error messageIds size 0 when null ");
            if (collection == null) {
                z = true;
            }
            sb.append(String.valueOf(z));
            IMLog.m6631d(f9307a, sb.toString());
            return;
        }
        new IMTaskJob<Void, Void, Boolean>() {
            /* access modifiers changed from: protected */
            public Boolean doInBackground(Void... voidArr) {
                Map classifyCollection = IMModelHelper.classifyCollection(collection, new IMModelHelper.ClassifyValue<Long, IMMessage>() {
                    public Long getKey(IMMessage iMMessage) {
                        return Long.valueOf(iMMessage.getSid());
                    }
                });
                if (IMModelHelper.wrapperCollectionMap(IMModelHelper.filterCollection(classifyCollection.keySet(), new IMModelHelper.FilterValue<Long>() {
                    public boolean isFilter(Long l) {
                        return IMMessageModule.this.mDaoSession.containsMessageDao(l.longValue());
                    }
                }), new IMModelHelper.WrapperValue<Long, MessageDao>() {
                    public MessageDao wrapper(Long l) {
                        return IMMessageModule.this.mDaoSession.getMessageDao(l.longValue());
                    }
                }).size() == 0) {
                    return null;
                }
                for (Long l : classifyCollection.keySet()) {
                    try {
                        IMMessageModule.this.mDaoSession.getMessageDao(l.longValue()).updateInTx(IMModelHelper.wrapperCollection((Collection) classifyCollection.get(l), new IMModelHelper.WrapperValue<IMMessage, IMMessageDaoEntity>() {
                            public IMMessageDaoEntity wrapper(IMMessage iMMessage) {
                                return iMMessage.getDaoEntity();
                            }
                        }));
                    } catch (Exception e) {
                        e.printStackTrace();
                        return false;
                    }
                }
                return true;
            }

            /* access modifiers changed from: protected */
            public void onPostExecute(Boolean bool) {
                if (iMMessageCallback != null) {
                    if (bool.booleanValue()) {
                        iMMessageCallback.onSendStatusChanged((IMMessage) null, 501, (IMSendMessageResponse) null);
                    } else {
                        iMMessageCallback.onSendStatusChanged((IMMessage) null, 502, (IMSendMessageResponse) null);
                    }
                }
            }
        }.setErrorCallback(getErrorCallback()).executeWithDatabase(new Void[0]);
    }

    public void sendMsgAck(Long l, Long l2) {
        sendAck(l.longValue(), l2.longValue());
    }

    public IMMessage sendLocationMessage(IMLocationEntity iMLocationEntity, int i, IMBusinessParam iMBusinessParam, IMSession iMSession) {
        String str;
        this.f9314g.track();
        try {
            str = IMJsonUtil.jsonFromObject(iMLocationEntity);
        } catch (Exception unused) {
            str = "";
        }
        String str2 = str;
        if (!TextUtils.isEmpty(str2)) {
            return sendTextMessage(str2, i, iMBusinessParam, iMSession, (Object) null, 0, (IMSendMessageCallback) null);
        }
        return null;
    }

    public void sendAck(long j, long j2) {
        this.f9314g.track();
        final long j3 = j;
        final long j4 = j2;
        IMThreadHelper.getInstance().execute(new Runnable() {
            public void run() {
                IMSession sessionFromLocal;
                IIMSessionModule sessionModel = IMManager.getInstance().getSessionModel();
                long j = 0;
                if (!(sessionModel == null || (sessionFromLocal = sessionModel.getSessionFromLocal(j3)) == null)) {
                    j = sessionFromLocal.getPeerUid();
                }
                IMHttpManager.getInstance().performCommonPost(new IMMessageAckRequest(j3, j4, j), (IMNetCallback<?>) null);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6279a(long j) {
        this.f9314g.track(Long.valueOf(j));
        synchronized (this) {
            if (j > this.f9310c) {
                this.f9313f.saveMaxSingleId(IMContextInfoHelper.getUid(), j);
                this.f9310c = j;
            }
        }
    }

    public void extendSendMessage(int i, int i2, int i3, String str, int i4, IMDetailBody iMDetailBody, int i5, IMBusinessParam iMBusinessParam, IMMessageCallback iMMessageCallback) {
        IMDetailBody iMDetailBody2 = iMDetailBody;
        this.f9314g.track();
        long uid = IMContextInfoHelper.getUid();
        final IMMessage iMMessage = new IMMessage(i5);
        iMMessage.isSend = true;
        iMMessage.setSid(iMBusinessParam.getSessionId());
        iMMessage.setCreateTime(System.currentTimeMillis());
        iMMessage.setContent(iMDetailBody2.cont);
        IMMessageDownExtend iMMessageDownExtend = new IMMessageDownExtend();
        iMMessageDownExtend.setIs_qk(iMBusinessParam.getIsQuick());
        iMMessage.setMessageExtendInfo(iMMessageDownExtend);
        iMMessage.setSenderUid(uid);
        iMMessage.setUniqueId(iMBusinessParam.getSessionId(), IMIdGenerator.getInstance().getRandId());
        IMExtendSendMessageRequest iMExtendSendMessageRequest = new IMExtendSendMessageRequest(i, i2, i3, str, i4, iMBusinessParam.getSecret(), iMBusinessParam.getSelfUserName(), iMBusinessParam.getSelfUserAvatar(), iMBusinessParam.getPeerUid(), iMBusinessParam.getPeerUserName(), iMBusinessParam.getPeerUserAvatar(), iMBusinessParam.getProductId(), iMBusinessParam.getsOrderId(), iMBusinessParam.getCityID());
        iMExtendSendMessageRequest.addMessage(IMApiParser.parseUpMessage(iMMessage, iMDetailBody2, iMMessage.getUniqueId()));
        final IMBusinessParam iMBusinessParam2 = iMBusinessParam;
        final IMMessageCallback iMMessageCallback2 = iMMessageCallback;
        IMHttpManager.getInstance().performCommonPost(iMExtendSendMessageRequest, new IMNetCallback<IMSendMessageResponse>() {
            public void success(IMSendMessageResponse iMSendMessageResponse) {
                if (iMMessageCallback2 != null && iMSendMessageResponse != null && iMSendMessageResponse.isSuccess()) {
                    iMBusinessParam2.clearSecret();
                    iMMessageCallback2.onSendStatusChanged(iMMessage, 201, iMSendMessageResponse);
                }
            }

            public void failure(IOException iOException) {
                IMMessageCallback iMMessageCallback = iMMessageCallback2;
                if (iMMessageCallback != null) {
                    iMMessageCallback.onSendStatusChanged(iMMessage, 202, (IMSendMessageResponse) null);
                }
            }
        });
    }

    public void updateReadStatus(long j, boolean z, List<Long> list, boolean z2) {
        this.f9314g.track();
        if (list != null && list.size() != 0) {
            final IMMessageCallback iMMessageCallback = this.f9311d.get(j);
            final long j2 = j;
            final boolean z3 = z;
            final List<Long> list2 = list;
            final boolean z4 = z2;
            new IMTaskJob<Void, Void, List<IMMessage>>() {
                /* access modifiers changed from: protected */
                public List<IMMessage> doInBackground(Void... voidArr) {
                    QueryBuilder queryBuilder;
                    MessageDao messageDao = IMMessageModule.this.mDaoSession.getMessageDao(j2);
                    if (z3) {
                        queryBuilder = messageDao.queryBuilder().where(MessageDao.Properties.Send_uid.mo43479eq(Long.valueOf(IMContextInfoHelper.getUid())), MessageDao.Properties.Message_id.mo43482in((Collection<?>) list2)).orderAsc(MessageDao.Properties.f9175Id);
                    } else {
                        queryBuilder = messageDao.queryBuilder().where(MessageDao.Properties.Send_uid.notEq(Long.valueOf(IMContextInfoHelper.getUid())), MessageDao.Properties.Message_id.mo43482in((Collection<?>) list2)).orderAsc(MessageDao.Properties.f9175Id);
                    }
                    List<IMMessageDaoEntity> list = queryBuilder.list();
                    ArrayList arrayList = new ArrayList();
                    for (IMMessageDaoEntity iMMessageDaoEntity : list) {
                        iMMessageDaoEntity.setIsRead(Boolean.valueOf(z4));
                        arrayList.add(new IMMessage(iMMessageDaoEntity));
                    }
                    messageDao.updateInTx(list);
                    if (z3) {
                        IMSession sessionFromLocal = IMMessageModule.this.mModelProvider.getSessionModule().getSessionFromLocal(j2);
                        if (sessionFromLocal == null) {
                            IMLog.m6631d(IMMessageModule.f9307a, "update read status failed while mSession is null and sid is " + j2);
                            return arrayList;
                        } else if (list2.contains(Long.valueOf(Long.parseLong(sessionFromLocal.getLastMessageId())))) {
                            IMMessageModule.this.mModelProvider.getSessionModule().updateLastSendMsgReadStatus(j2);
                        }
                    }
                    return arrayList;
                }

                /* access modifiers changed from: protected */
                public void onPostExecute(List<IMMessage> list) {
                    IMMessageCallback iMMessageCallback = iMMessageCallback;
                    if (iMMessageCallback != null) {
                        iMMessageCallback.onReadStatusChange(list, z3);
                    }
                }
            }.setErrorCallback(getErrorCallback()).executeWithDatabase(new Void[0]);
        }
    }

    public void handleExpiredPicture(final long j) {
        this.f9314g.track();
        new IMTaskJob<Void, Void, List<IMMessage>>() {
            /* access modifiers changed from: protected */
            public List<IMMessage> doInBackground(Void... voidArr) {
                MessageDao messageDao = IMMessageModule.this.mDaoSession.getMessageDao(j);
                List<IMMessageDaoEntity> list = messageDao.queryBuilder().where(MessageDao.Properties.Type.mo43483in(196608, Integer.valueOf(IMApiConst.MsgTypeOderStatusChange)), new WhereCondition[0]).orderAsc(MessageDao.Properties.f9175Id).list();
                ArrayList arrayList = new ArrayList();
                for (IMMessageDaoEntity iMMessage : list) {
                    IMMessage iMMessage2 = new IMMessage(iMMessage);
                    IMMessageDownExtend messageExtendInfo = iMMessage2.getMessageExtendInfo();
                    messageExtendInfo.setPicIsExpired(1);
                    iMMessage2.setMessageExtendInfo(messageExtendInfo);
                    arrayList.add(iMMessage2);
                }
                messageDao.updateInTx(list);
                return arrayList;
            }

            /* access modifiers changed from: protected */
            public void onPostExecute(List<IMMessage> list) {
                EventBus.getDefault().post(new IMMessageHandleExpiredPicEvent(list));
            }
        }.setErrorCallback(getErrorCallback()).executeWithDatabase(new Void[0]);
    }

    public void getMessageReadStatus(final long j, final List<Long> list) {
        this.f9314g.track();
        if (list != null && list.size() != 0) {
            IMThreadHelper.getInstance().execute(new Runnable() {
                public void run() {
                    IMSession sessionFromLocal;
                    IIMSessionModule sessionModel = IMManager.getInstance().getSessionModel();
                    long j = 0;
                    if (!(sessionModel == null || (sessionFromLocal = sessionModel.getSessionFromLocal(j)) == null)) {
                        j = sessionFromLocal.getPeerUid();
                    }
                    IMHttpManager.getInstance().performCommonPost(new IMReadStatusRequest(18, j, j, list), new IMNetCallback<IMGetReadStatusResponse>() {
                        public void failure(IOException iOException) {
                        }

                        public void success(IMGetReadStatusResponse iMGetReadStatusResponse) {
                            if (iMGetReadStatusResponse != null && iMGetReadStatusResponse.isSuccess() && iMGetReadStatusResponse.body != null) {
                                IMMessageModule.this.updateReadStatus(j, true, iMGetReadStatusResponse.body.mids, true);
                            }
                        }
                    });
                }
            });
        }
    }

    public void pushMessageReadStatus(final long j, final List<Long> list) {
        this.f9314g.track();
        IMThreadHelper.getInstance().execute(new Runnable() {
            public void run() {
                IMSession sessionFromLocal;
                IIMSessionModule sessionModel = IMManager.getInstance().getSessionModel();
                long j = 0;
                if (!(sessionModel == null || (sessionFromLocal = sessionModel.getSessionFromLocal(j)) == null)) {
                    j = sessionFromLocal.getPeerUid();
                }
                IMHttpManager.getInstance().performCommonPost(new IMReadStatusRequest(17, j, j, list), new IMNetCallback<IMBaseResponseImpl>() {
                    public void failure(IOException iOException) {
                    }

                    public void success(IMBaseResponseImpl iMBaseResponseImpl) {
                        if (iMBaseResponseImpl != null && iMBaseResponseImpl.isSuccess()) {
                            IMMessageModule.this.updateReadStatus(j, false, list, true);
                        }
                    }
                });
            }
        });
    }

    public void translateByHand(String str, long j, long j2, IMMessageCallBackImp iMMessageCallBackImp) {
        if (!TextUtils.isEmpty(str)) {
            String str2 = IMApiUrl.getCommonHost() + IMApiUrl.IM_TRANSLATE_PATH;
            HashMap hashMap = new HashMap();
            hashMap.put("token", Uri.encode(IMContextInfoHelper.getToken()));
            Locale locale = IMContextInfoHelper.getContext().getResources().getConfiguration().locale;
            if (locale != null) {
                hashMap.put("srclag", locale.getLanguage() + "-" + locale.getCountry());
            }
            hashMap.put("text", Uri.encode(str));
            hashMap.put("sid", j + "");
            final long j3 = j;
            final long j4 = j2;
            final IMMessageCallBackImp iMMessageCallBackImp2 = iMMessageCallBackImp;
            IMHttpManager.getInstance().performCommonGet(str2 + IMGetParamHelper.generateGetUrl(hashMap), new IMNetCallback<IMTransBody>() {
                public void success(final IMTransBody iMTransBody) {
                    if (iMTransBody != null && iMTransBody.errno == 0 && !TextUtils.isEmpty(iMTransBody.text)) {
                        MessageDao messageDao = IMMessageModule.this.mDaoSession.getMessageDao(j3);
                        List list = messageDao.queryBuilder().where(MessageDao.Properties.Message_id.mo43479eq(Long.valueOf(j4)), new WhereCondition[0]).orderAsc(MessageDao.Properties.f9175Id).list();
                        if (list != null && list.size() > 0) {
                            IMMessageDaoEntity iMMessageDaoEntity = (IMMessageDaoEntity) list.get(0);
                            IMMessageDownExtend iMMessageDownExtend = (IMMessageDownExtend) IMJsonUtil.objectFromJson(iMMessageDaoEntity.getReserveStr3(), IMMessageDownExtend.class);
                            iMMessageDownExtend.trans = iMTransBody;
                            iMMessageDaoEntity.setReserveStr3(IMJsonUtil.jsonFromObject(iMMessageDownExtend));
                            messageDao.update(iMMessageDaoEntity);
                        }
                        IMMessageModule.this.f9316i.post(new Runnable() {
                            public void run() {
                                iMMessageCallBackImp2.onTranslateSucceed(iMTransBody);
                            }
                        });
                    }
                }

                public void failure(IOException iOException) {
                    IMMessageModule.this.f9316i.post(new Runnable() {
                        public void run() {
                            iMMessageCallBackImp2.onTranslateSucceed((IMTransBody) null);
                        }
                    });
                }
            });
        }
    }

    /* renamed from: a */
    private IMSendMessageRequest m6274a(IMSession iMSession, IMBusinessParam iMBusinessParam) {
        return new IMSendMessageRequest(iMBusinessParam.getSecret(), iMSession.getSelfUser().getNickName(), iMSession.getSelfUser().getAvatarUrl(), iMSession.getPeerUid(), iMSession.getPeerUser().getNickName(), iMSession.getPeerUser().getAvatarUrl(), iMBusinessParam.getProductId(), iMBusinessParam.getsOrderId(), iMBusinessParam.getCityID(), IMContextInfoHelper.getBusinessPayload(iMBusinessParam.getBusinessId() + ""));
    }

    public void insertMessagesFromClient(final List<IMMessageDown> list) {
        if (list == null || list.size() == 0) {
            IMLog.m6632e("insertMessagesFromClient failed,msgs can't be null", new Object[0]);
        } else {
            IMThreadHelper.getInstance().execute(new Runnable() {
                public void run() {
                    boolean z;
                    int size = list.size();
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < size; i++) {
                        IMMessage parseDownMessage = IMApiParser.parseDownMessage((IMMessageDown) list.get(i), 1);
                        parseDownMessage.setIsSend(false);
                        parseDownMessage.setStatus(200);
                        switch (parseDownMessage.getType()) {
                            case 65536:
                            case 65537:
                            case 131072:
                            case 196608:
                            case 327680:
                            case IMApiConst.MsgTypeSystem:
                            case IMApiConst.MsgTypeOderStatusChange:
                            case IMApiConst.MsgTypeHelper:
                            case IMApiConst.MsgTypePlugin:
                            case IMApiConst.MsgTypeSystemAudio:
                            case 458752:
                            case 528385:
                            case IMApiConst.MsgTypeShareLocation:
                            case IMApiConst.MsgTypeCloseShareLocation:
                            case IMApiConst.MsgTypeSendLocation:
                                break;
                            case 524289:
                                IMTraceUtil.addBusinessEvent("im_send_command_msg").add("actionId", parseDownMessage.getActionId()).add("type", "get").report();
                                if (IMEventDispatcher.dispatchIMMessage(IMMessageModule.this.getServiceProvider().getContext(), parseDownMessage)) {
                                    IMMessageModule.this.m6279a(parseDownMessage.getMid());
                                    break;
                                }
                                break;
                            default:
                                parseDownMessage.setType(IMApiConst.MsgTypeUnknow);
                                break;
                        }
                        if (Parser.parseIsAnonRobotMessage(parseDownMessage)) {
                            IMLog.m6631d(IMMessageModule.f9307a, "[insertMessagesFromClient] is anon robot message, not need insert message");
                            if (parseDownMessage.mact == 1) {
                                IMMessageModule.this.m6281a(parseDownMessage);
                            } else if (parseDownMessage.mact == 2) {
                                IMMessageModule.this.m6281a(parseDownMessage);
                                IMEventDispatcher.sendLocalBroadcast4DMC(IMContextInfoHelper.getContext(), parseDownMessage);
                            }
                        } else if (parseDownMessage.getType() != 524289) {
                            try {
                                IMMessageModule.this.mDaoSession.getMessageDao(parseDownMessage.getSid()).insert(parseDownMessage.getDaoEntity());
                                z = true;
                            } catch (Exception e) {
                                IMTraceError.trackError("im_message_insert_error", new IllegalStateException(e));
                                IMLog.m6631d(IMMessageModule.f9307a, "[insertMessagesFromClient] #insertMessage#  Error message id is " + parseDownMessage.getMid() + " message content is " + parseDownMessage.getContent());
                                z = false;
                            }
                            if (z && parseDownMessage.getType() != 589824) {
                                arrayList.add(parseDownMessage);
                                if (parseDownMessage.mact == 1) {
                                    if (Parser.parseIsRobotMessage(parseDownMessage)) {
                                        IMMessageModule.this.m6281a(parseDownMessage);
                                    } else if (parseDownMessage.getType() == 327680) {
                                        IMMessageModule.this.m6295b(parseDownMessage);
                                    } else {
                                        IMEventDispatcher.sendLocalBroadcast(IMContextInfoHelper.getContext(), IMEventDispatcher.RECEIVE_MESSAGE_TO_TTS_ACTION, parseDownMessage);
                                    }
                                } else if (parseDownMessage.mact == 2) {
                                    IMEventDispatcher.sendLocalBroadcast4DMC(IMContextInfoHelper.getContext(), parseDownMessage);
                                    if (Parser.parseIsRobotMessage(parseDownMessage)) {
                                        IMMessageModule.this.m6281a(parseDownMessage);
                                    }
                                    if (parseDownMessage.getType() == 327680) {
                                        IMMessageModule.this.m6295b(parseDownMessage);
                                    }
                                }
                            }
                        }
                    }
                    HashMap hashMap = new HashMap();
                    if (!arrayList.isEmpty()) {
                        for (int i2 = 0; i2 < arrayList.size(); i2++) {
                            IMMessage iMMessage = (IMMessage) arrayList.get(i2);
                            ArrayList arrayList2 = (ArrayList) hashMap.get(Long.valueOf(iMMessage.getSid()));
                            if (arrayList2 == null) {
                                arrayList2 = new ArrayList();
                                hashMap.put(Long.valueOf(iMMessage.getSid()), arrayList2);
                            }
                            arrayList2.add(iMMessage);
                        }
                        IIMSessionModule sessionModule = IMMessageModule.this.mModelProvider.getSessionModule();
                        if (sessionModule != null) {
                            sessionModule.updateSessionStateByMessageAsync(hashMap);
                        }
                        final Set<Long> generateSessionIdSet = IMSessionMessageListenerManager.generateSessionIdSet(arrayList);
                        IMMessageModule.this.f9316i.post(new Runnable() {
                            public void run() {
                                IMSessionMessageListenerManager.getInstance().notifyListeners(generateSessionIdSet);
                            }
                        });
                    }
                }
            });
        }
    }

    public void updateSyncInfo() {
        this.f9315h = true;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6281a(IMMessage iMMessage) {
        if (iMMessage == null) {
            IMLog.m6632e(f9307a, "[sendRobotPraiseTTSBroadcast] with Null message");
        } else if (!Parser.parseIsRobotMessage(iMMessage)) {
            IMLog.m6632e(f9307a, "[sendRobotPraiseTTSBroadcast] not robot message");
        } else {
            try {
                JSONObject jSONObject = new JSONObject(iMMessage.getContent());
                final String optString = jSONObject.optString("praise_id", "");
                final String optString2 = jSONObject.optString("order_id", "");
                String optString3 = jSONObject.optString("on_trip_voice", "");
                String optString4 = jSONObject.optString("after_trip_voice", "");
                if (!TextUtils.isEmpty(optString3) || !TextUtils.isEmpty(optString4)) {
                    final String str = optString3;
                    final String str2 = optString4;
                    final IMMessage iMMessage2 = iMMessage;
                    m6293a(optString3, optString4, 0, (IMVoiceDownloadUtil.UrlCallback) new IMVoiceDownloadUtil.UrlCallback() {
                        public void onUrlCallback(List<IMVoiceBody> list) {
                            if (list == null || list.size() == 0) {
                                IMLog.m6632e(IMMessageModule.f9307a, "[sendRobotPraiseTTSBroadcast] #VoiceDownloadUrl# null list");
                                return;
                            }
                            String str = null;
                            String str2 = null;
                            for (IMVoiceBody next : list) {
                                if (TextUtils.equals(str, next.key)) {
                                    str = next.url;
                                }
                                if (TextUtils.equals(str2, next.key)) {
                                    str2 = next.url;
                                }
                            }
                            IMLog.m6631d(IMMessageModule.f9307a, C4234I.m6591t("[sendRobotPraiseTTSBroadcast] #VoiceDownloadUrl# onTripVoiceFid=", str, " |onTripVoiceUrl=", str, " |afterTripVoiceFid=", str2, " |afterTripVoiceUrl=", str2));
                            IMEventDispatcher.sendLocalBroadcast(IMContextInfoHelper.getContext(), new IMRobotPraiseTTSMsg(iMMessage2.getMid(), optString, str, str2, optString2));
                        }
                    });
                    return;
                }
                IMLog.m6632e(f9307a, "[sendRobotPraiseTTSBroadcast] all fid is null");
            } catch (Exception e) {
                IMLog.m6632e(f9307a, "[formatRobotPraiseTTSMessage]", e);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m6295b(IMMessage iMMessage) {
        if (iMMessage == null) {
            IMLog.m6632e(f9307a, "[sendEmojiPraiseTTSBroadcast] with Null message");
        } else if (iMMessage.getType() != 327680) {
            IMLog.m6632e(f9307a, "[sendEmojiPraiseTTSBroadcast] not emoji message");
        } else {
            try {
                String fid = iMMessage.getFid();
                String file_name = iMMessage.getFile_name();
                String file_name2 = iMMessage.getFile_name();
                if (!TextUtils.isEmpty(file_name) || !TextUtils.isEmpty(file_name2)) {
                    IMLog.m6631d(f9307a, C4234I.m6591t("[sendEmojiPraiseTTSBroadcast] #VoiceDownloadUrl# onTripVoiceFid=", file_name, " |onTripVoiceUrl=", file_name, " |afterTripVoiceFid=", file_name2, " |afterTripVoiceUrl=", file_name2));
                    IMEventDispatcher.sendLocalBroadcast(IMContextInfoHelper.getContext(), new IMRobotPraiseTTSMsg(iMMessage.getMid(), fid, file_name, file_name2, ""));
                    return;
                }
                IMLog.m6632e(f9307a, "[sendEmojiPraiseTTSBroadcast] all fid is null");
            } catch (Exception e) {
                IMLog.m6632e(f9307a, "[sendEmojiPraiseTTSBroadcast]", e);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6293a(String str, String str2, int i, IMVoiceDownloadUtil.UrlCallback urlCallback) {
        if (i > 1) {
            IMLog.m6632e(f9307a, C4234I.m6591t("[formatRobotPraiseTTSMessage] #NULL TTS INFO# retryCount=", Integer.valueOf(i)));
            urlCallback.onUrlCallback((List<IMVoiceBody>) null);
            return;
        }
        IMLog.m6631d(f9307a, C4234I.m6591t("[formatRobotPraiseTTSMessage] #downloadVoiceUrl# retryCount=", Integer.valueOf(i)));
        final String str3 = str;
        final String str4 = str2;
        final int i2 = i;
        final IMVoiceDownloadUtil.UrlCallback urlCallback2 = urlCallback;
        IMVoiceDownloadUtil.downloadVoiceUrl(new IMVoiceDownloadUtil.UrlCallback() {
            public void onUrlCallback(List<IMVoiceBody> list) {
                if (list == null || list.size() == 0) {
                    UiThreadHandler.postDelayed(new Runnable() {
                        public void run() {
                            IMMessageModule.this.m6293a(str3, str4, i2 + 1, urlCallback2);
                        }
                    }, 3000);
                } else {
                    urlCallback2.onUrlCallback(list);
                }
            }
        }, str, str2);
    }
}
