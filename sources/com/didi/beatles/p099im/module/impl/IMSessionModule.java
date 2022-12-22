package com.didi.beatles.p099im.module.impl;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.collection.LongSparseArray;
import com.didi.beatles.p099im.IMContextInfoHelper;
import com.didi.beatles.p099im.access.utils.Parser;
import com.didi.beatles.p099im.api.IMApiConst;
import com.didi.beatles.p099im.api.IMApiParser;
import com.didi.beatles.p099im.api.entity.IMBaseResponse;
import com.didi.beatles.p099im.api.entity.IMCheckSessionEnableRequest;
import com.didi.beatles.p099im.api.entity.IMCheckSessionEnableResponse;
import com.didi.beatles.p099im.api.entity.IMCloseSessionRequest;
import com.didi.beatles.p099im.api.entity.IMCreateSessionRequest;
import com.didi.beatles.p099im.api.entity.IMCreateSessionResponse;
import com.didi.beatles.p099im.api.entity.IMGetSessionInfoRequest;
import com.didi.beatles.p099im.api.entity.IMGetSessionInfoResponse;
import com.didi.beatles.p099im.api.entity.IMLocationEntity;
import com.didi.beatles.p099im.api.entity.IMModifyForbidRequest;
import com.didi.beatles.p099im.api.entity.IMRichInfoMsgBody;
import com.didi.beatles.p099im.api.entity.IMSendActionTipRequest;
import com.didi.beatles.p099im.api.entity.IMSessionClientExtendInfo;
import com.didi.beatles.p099im.api.entity.IMSessionExtendInfo;
import com.didi.beatles.p099im.api.entity.IMSessionInfo;
import com.didi.beatles.p099im.api.entity.IMShareLocationBody;
import com.didi.beatles.p099im.api.entity.IMSyncSessionStatusRequest;
import com.didi.beatles.p099im.debug.IMMethodTracker;
import com.didi.beatles.p099im.event.IMSessionInfoUpdateErrorEvent;
import com.didi.beatles.p099im.module.IIMSessionModule;
import com.didi.beatles.p099im.module.IMBaseModule;
import com.didi.beatles.p099im.module.IMClearSessionUnreadCountCallback;
import com.didi.beatles.p099im.module.IMFeedSessionCallback;
import com.didi.beatles.p099im.module.IMModifyGroupForbidCallback;
import com.didi.beatles.p099im.module.IMModifyHelperForbidCallback;
import com.didi.beatles.p099im.module.IMSendActionTipCallback;
import com.didi.beatles.p099im.module.IMSessionCallback;
import com.didi.beatles.p099im.module.IMSessionUnreadCallback;
import com.didi.beatles.p099im.module.IMSessionUnreadInfoCallback;
import com.didi.beatles.p099im.module.IMSessionUnreadSysChatMsgCallback;
import com.didi.beatles.p099im.module.IMSucceedCallback;
import com.didi.beatles.p099im.module.entity.IMBusinessParam;
import com.didi.beatles.p099im.module.entity.IMMessage;
import com.didi.beatles.p099im.module.entity.IMSession;
import com.didi.beatles.p099im.module.entity.IMSysChatUnreadCount;
import com.didi.beatles.p099im.module.entity.IMUser;
import com.didi.beatles.p099im.net.IMHttpManager;
import com.didi.beatles.p099im.net.IMNetCallback;
import com.didi.beatles.p099im.net.IMThreadHelper;
import com.didi.beatles.p099im.omega.IMTraceError;
import com.didi.beatles.p099im.omega.IMTraceUtil;
import com.didi.beatles.p099im.p100db.dao.DaoSession;
import com.didi.beatles.p099im.p100db.dao.MessageDao;
import com.didi.beatles.p099im.p100db.dao.SessionDao;
import com.didi.beatles.p099im.p100db.dao.UserDao;
import com.didi.beatles.p099im.p100db.entity.IMMessageDaoEntity;
import com.didi.beatles.p099im.p100db.entity.IMSessionDaoEntity;
import com.didi.beatles.p099im.plugin.IMPluginFactory;
import com.didi.beatles.p099im.pref.IMPreference;
import com.didi.beatles.p099im.protocol.plugin.IMPluginService;
import com.didi.beatles.p099im.resource.IMResource;
import com.didi.beatles.p099im.service.IMConfigManager;
import com.didi.beatles.p099im.task.IMTaskJob;
import com.didi.beatles.p099im.thirty.greenrobot.dao.query.WhereCondition;
import com.didi.beatles.p099im.utils.IMCommandUtils;
import com.didi.beatles.p099im.utils.IMJsonUtil;
import com.didi.beatles.p099im.utils.IMLog;
import com.taxis99.R;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import org.greenrobot.eventbus.EventBus;

/* renamed from: com.didi.beatles.im.module.impl.IMSessionModule */
public final class IMSessionModule extends IMBaseModule implements IIMSessionModule {
    public static final int SESSION_UPDATE_DEL_ERROR_CODE = 111;
    public static final String TAG = "IMSessionModule";
    public boolean IS_CHECK = true;

    /* renamed from: a */
    IMConfigManager f9324a = this.mServiceProvider.getConfigManager();

    /* renamed from: b */
    DaoSession f9325b = this.mServiceProvider.getDaoManager().getDaoSession();

    /* renamed from: c */
    Set<IMSessionCallback> f9326c = Collections.synchronizedSet(new HashSet());

    /* renamed from: d */
    Map<Long, IMSession> f9327d = Collections.synchronizedMap(new HashMap());
    /* access modifiers changed from: private */

    /* renamed from: e */
    public LongSparseArray<IMSucceedCallback> f9328e = new LongSparseArray<>();
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Handler f9329f = new Handler(Looper.getMainLooper());

    /* renamed from: g */
    private IMMethodTracker f9330g = IMMethodTracker.newInstance("IMS");

    public void clearHolders() {
        this.f9328e.clear();
    }

    public boolean isHaveOverDueMessage(int i) {
        this.f9330g.track();
        synchronized (this.f9327d) {
            for (IMSession next : this.f9327d.values()) {
                if (!TextUtils.isEmpty(next.getLastMessage()) && !next.getSessionEnable()) {
                    return true;
                }
            }
            return false;
        }
    }

    protected IMSessionModule(IMModelProvider iMModelProvider) {
        super(iMModelProvider);
    }

    public void onStart() {
        m6323a();
    }

    public void registerSessionCallback(IMSessionCallback iMSessionCallback) {
        this.f9330g.track(iMSessionCallback);
        if (iMSessionCallback != null) {
            this.f9326c.add(iMSessionCallback);
        }
    }

    public void unregisterSessionCallback(IMSessionCallback iMSessionCallback) {
        this.f9330g.track(iMSessionCallback);
        if (iMSessionCallback != null) {
            this.f9326c.remove(iMSessionCallback);
        }
    }

    public void createSession(final long[] jArr, int i, final IMSessionCallback iMSessionCallback) {
        this.f9330g.track(jArr, Integer.valueOf(i));
        IMCreateSessionRequest iMCreateSessionRequest = new IMCreateSessionRequest();
        iMCreateSessionRequest.multiChat(i, jArr);
        IMHttpManager.getInstance().performCommonPost(iMCreateSessionRequest, new IMNetCallback<IMCreateSessionResponse>() {
            public void success(IMCreateSessionResponse iMCreateSessionResponse) {
                IMSession iMSession = null;
                if (iMCreateSessionResponse == null || !iMCreateSessionResponse.isSuccess()) {
                    IMSessionModule.this.m6324a(iMSessionCallback, (IMSession) null, 1, 2);
                    return;
                }
                IMSession iMSession2 = new IMSession();
                iMSession2.setDaoEntity(new IMSessionDaoEntity());
                iMSession2.setUsers(jArr);
                iMSession2.setLastModifyTime(System.currentTimeMillis());
                long j = iMCreateSessionResponse.body.sid;
                iMSession2.setSessionId(j);
                if ((j & LockFreeTaskQueueCore.CLOSED_MASK) == 0) {
                    iMSession2.setType(1);
                } else {
                    iMSession2.setType(2);
                }
                try {
                    if (!IMSessionModule.this.f9327d.containsKey(Long.valueOf(iMSession2.getSessionId()))) {
                        IMSessionModule.this.f9325b.getSessionDao().insert(iMSession2.getDaoEntity());
                        IMSessionModule.this.f9327d.put(Long.valueOf(iMSession2.getSessionId()), iMSession2);
                    }
                    iMSession = iMSession2;
                } catch (Exception unused) {
                }
                IMSessionModule.this.m6324a(iMSessionCallback, iMSession, 1, 2);
            }

            public void failure(IOException iOException) {
                IMSessionModule.this.m6324a(iMSessionCallback, (IMSession) null, 1, 2);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6324a(IMSessionCallback iMSessionCallback, IMSession iMSession, int i, int i2) {
        if (iMSessionCallback != null) {
            final IMSession iMSession2 = iMSession;
            final IMSessionCallback iMSessionCallback2 = iMSessionCallback;
            final int i3 = i;
            final int i4 = i2;
            this.f9329f.post(new Runnable() {
                public void run() {
                    if (iMSession2 != null) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(iMSession2);
                        iMSessionCallback2.onSessionOptionResult(arrayList, i3);
                        return;
                    }
                    iMSessionCallback2.onSessionOptionResult((List<IMSession>) null, i4);
                }
            });
        }
    }

    public void deleteSession(final IMSession iMSession) {
        this.f9330g.track(iMSession);
        new IMTaskJob<Void, Void, Boolean>() {
            /* access modifiers changed from: protected */
            public Boolean doInBackground(Void... voidArr) {
                long sessionId = iMSession.getSessionId();
                MessageDao messageDao = IMSessionModule.this.f9325b.getMessageDao(sessionId);
                messageDao.dropTable(IMSessionModule.this.f9325b.getDatabase(), true);
                IMSessionModule.this.f9325b.removeMessageDao(messageDao.mTableName);
                UserDao userDao = IMSessionModule.this.f9325b.getUserDao(sessionId);
                if (userDao != null) {
                    userDao.dropTableDynamic(IMSessionModule.this.f9325b.getDatabase(), true);
                    IMSessionModule.this.f9325b.removeUserDao(userDao.getTablename());
                }
                IMSessionModule.this.f9325b.getSessionDao().delete(iMSession.getDaoEntity());
                IMSessionModule.this.mServiceProvider.getFileManager().removeSession(sessionId);
                IMSessionModule.this.f9327d.remove(Long.valueOf(sessionId));
                return true;
            }

            /* access modifiers changed from: protected */
            public void onPostExecute(Boolean bool) {
                if (bool != null) {
                    for (IMSessionCallback a : IMSessionModule.this.f9326c) {
                        IMSessionModule.this.m6324a(a, iMSession, 3, 4);
                    }
                }
            }
        }.setErrorCallback(getErrorCallback()).executeWithDatabase(new Void[0]);
    }

    public void deleteSession(final List<IMSession> list) {
        this.f9330g.track(list);
        if (list != null && list.size() != 0) {
            new IMTaskJob<Void, Void, Boolean>() {
                /* access modifiers changed from: protected */
                public Boolean doInBackground(Void... voidArr) {
                    ArrayList arrayList = new ArrayList();
                    for (IMSession iMSession : list) {
                        long sessionId = iMSession.getSessionId();
                        MessageDao messageDao = IMSessionModule.this.f9325b.getMessageDao(sessionId);
                        messageDao.dropTable(IMSessionModule.this.f9325b.getDatabase(), true);
                        IMSessionModule.this.f9325b.removeMessageDao(messageDao.mTableName);
                        arrayList.add(iMSession.getDaoEntity());
                        UserDao userDao = IMSessionModule.this.f9325b.getUserDao(sessionId);
                        if (userDao != null) {
                            userDao.dropTableDynamic(IMSessionModule.this.f9325b.getDatabase(), true);
                            IMSessionModule.this.f9325b.removeUserDao(userDao.getTablename());
                        }
                        IMSessionModule.this.mServiceProvider.getFileManager().removeSession(sessionId);
                        IMSessionModule.this.f9327d.remove(Long.valueOf(sessionId));
                    }
                    IMSessionModule.this.f9325b.getSessionDao().deleteInTx(arrayList);
                    return true;
                }

                /* access modifiers changed from: protected */
                public void onPostExecute(Boolean bool) {
                    if (bool != null) {
                        for (IMSessionCallback next : IMSessionModule.this.f9326c) {
                            if (next != null) {
                                if (bool.booleanValue()) {
                                    next.onSessionOptionResult(list, 3);
                                } else {
                                    next.onSessionOptionResult(list, 4);
                                }
                            }
                        }
                    }
                }
            }.setErrorCallback(getErrorCallback()).executeWithDatabase(new Void[0]);
        }
    }

    /* renamed from: a */
    private void m6323a() {
        this.f9330g.track();
        new IMTaskJob<Void, Void, Boolean>() {
            /* access modifiers changed from: protected */
            public Boolean doInBackground(Void... voidArr) {
                if (IMSessionModule.this.f9327d != null) {
                    IMSessionModule.this.f9327d.clear();
                }
                if (IMSessionModule.this.f9327d.isEmpty()) {
                    List<IMSessionDaoEntity> list = IMSessionModule.this.f9325b.getSessionDao().queryBuilder().whereOr(SessionDao.Properties.Last_message.isNotNull(), SessionDao.Properties.Last_message.notEq(""), new WhereCondition[0]).orderDesc(SessionDao.Properties.Last_modify_time).list();
                    ArrayList arrayList = new ArrayList(list.size());
                    for (IMSessionDaoEntity daoEntity : list) {
                        IMSession iMSession = new IMSession();
                        iMSession.setDaoEntity(daoEntity);
                        arrayList.add(iMSession);
                        IMSessionModule.this.f9327d.put(Long.valueOf(iMSession.getSessionId()), iMSession);
                    }
                }
                return true;
            }

            /* access modifiers changed from: protected */
            public void onPostExecute(Boolean bool) {
                if (IMSessionModule.this.IS_CHECK) {
                    IMSessionModule.this.IS_CHECK = false;
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                        public void run() {
                            IMSessionModule.this.m6334b();
                        }
                    }, 10000);
                }
            }
        }.setErrorCallback(getErrorCallback()).execute(new Void[0]);
    }

    public void loadSessionAsync() {
        this.f9330g.track();
        new IMTaskJob<Void, Void, List<IMSession>>() {
            /* access modifiers changed from: protected */
            public List<IMSession> doInBackground(Void... voidArr) {
                if (!IMSessionModule.this.f9327d.isEmpty()) {
                    ArrayList arrayList = new ArrayList();
                    for (IMSession next : IMSessionModule.this.f9327d.values()) {
                        if (!TextUtils.isEmpty(next.getLastMessage())) {
                            arrayList.add(next);
                        }
                    }
                    return arrayList;
                }
                List<IMSessionDaoEntity> list = IMSessionModule.this.f9325b.getSessionDao().queryBuilder().whereOr(SessionDao.Properties.Last_message.isNotNull(), SessionDao.Properties.Last_message.notEq(""), new WhereCondition[0]).orderDesc(SessionDao.Properties.Last_modify_time).list();
                ArrayList arrayList2 = new ArrayList(list.size());
                for (IMSessionDaoEntity daoEntity : list) {
                    IMSession iMSession = new IMSession();
                    iMSession.setDaoEntity(daoEntity);
                    arrayList2.add(iMSession);
                    IMSessionModule.this.f9327d.put(Long.valueOf(iMSession.getSessionId()), iMSession);
                }
                return arrayList2;
            }

            /* access modifiers changed from: protected */
            public void onPostExecute(List<IMSession> list) {
                for (IMSessionCallback next : IMSessionModule.this.f9326c) {
                    if (next != null) {
                        next.onSessionLoad(list);
                    }
                }
            }
        }.setErrorCallback(getErrorCallback()).executeWithDatabase(new Void[0]);
    }

    public void loadSessionAsync(final boolean z, final int i) {
        this.f9330g.track();
        new IMTaskJob<Void, Void, List<IMSession>>() {
            /* access modifiers changed from: protected */
            public List<IMSession> doInBackground(Void... voidArr) {
                List<IMSessionDaoEntity> list;
                if (!IMSessionModule.this.f9327d.isEmpty()) {
                    ArrayList arrayList = new ArrayList();
                    for (IMSession next : IMSessionModule.this.f9327d.values()) {
                        if (!TextUtils.isEmpty(next.getLastMessage())) {
                            if (z) {
                                if (next.getSessionEnable() && (next.getType() & i) != 0) {
                                    arrayList.add(next);
                                }
                            } else if (!next.getSessionEnable() && (next.getType() & i) != 0) {
                                arrayList.add(next);
                            }
                        }
                    }
                    return arrayList;
                }
                if (z) {
                    list = IMSessionModule.this.f9325b.getSessionDao().queryBuilder().whereOr(SessionDao.Properties.Last_message.isNotNull(), SessionDao.Properties.Last_message.notEq(""), new WhereCondition[0]).where(SessionDao.Properties.Is_info_loaded.mo43479eq(true), new WhereCondition[0]).orderDesc(SessionDao.Properties.Last_modify_time).list();
                } else {
                    list = IMSessionModule.this.f9325b.getSessionDao().queryBuilder().whereOr(SessionDao.Properties.Last_message.isNotNull(), SessionDao.Properties.Last_message.notEq(""), new WhereCondition[0]).where(SessionDao.Properties.Is_info_loaded.mo43479eq(false), new WhereCondition[0]).orderDesc(SessionDao.Properties.Last_modify_time).list();
                }
                ArrayList arrayList2 = new ArrayList(list.size());
                for (IMSessionDaoEntity daoEntity : list) {
                    IMSession iMSession = new IMSession();
                    iMSession.setDaoEntity(daoEntity);
                    if ((iMSession.getType() & i) != 0) {
                        IMSessionModule.this.f9327d.put(Long.valueOf(iMSession.getSessionId()), iMSession);
                        arrayList2.add(iMSession);
                    }
                }
                return arrayList2;
            }

            /* access modifiers changed from: protected */
            public void onPostExecute(List<IMSession> list) {
                for (IMSessionCallback next : IMSessionModule.this.f9326c) {
                    if (next != null) {
                        next.onSessionLoad(list);
                    }
                }
            }
        }.setErrorCallback(getErrorCallback()).executeWithDatabase(new Void[0]);
    }

    public void loadSessionAsync(int i, int i2, Comparator<? super IMSession> comparator, IMFeedSessionCallback iMFeedSessionCallback) {
        this.f9330g.track();
        final int i3 = i;
        final int i4 = i2;
        final Comparator<? super IMSession> comparator2 = comparator;
        final IMFeedSessionCallback iMFeedSessionCallback2 = iMFeedSessionCallback;
        new IMTaskJob<Void, Void, List<IMSession>>() {
            /* access modifiers changed from: protected */
            public List<IMSession> doInBackground(Void... voidArr) {
                boolean z = (i3 & 1) != 0;
                boolean z2 = (i3 & 2) != 0;
                if (!IMSessionModule.this.f9327d.isEmpty()) {
                    ArrayList arrayList = new ArrayList();
                    for (IMSession next : IMSessionModule.this.f9327d.values()) {
                        if (!TextUtils.isEmpty(next.getLastMessage())) {
                            if (z && next.getSessionEnable() && (next.getType() & i4) != 0) {
                                arrayList.add(next);
                            }
                            if (z2 && !next.getSessionEnable() && (next.getType() & i4) != 0) {
                                arrayList.add(next);
                            }
                        }
                    }
                    Collections.sort(arrayList, comparator2);
                    return arrayList;
                }
                ArrayList arrayList2 = new ArrayList();
                if (z) {
                    for (IMSessionDaoEntity daoEntity : IMSessionModule.this.f9325b.getSessionDao().queryBuilder().whereOr(SessionDao.Properties.Last_message.isNotNull(), SessionDao.Properties.Last_message.notEq(""), new WhereCondition[0]).where(SessionDao.Properties.Is_info_loaded.mo43479eq(true), new WhereCondition[0]).orderDesc(SessionDao.Properties.Last_modify_time).list()) {
                        IMSession iMSession = new IMSession();
                        iMSession.setDaoEntity(daoEntity);
                        if ((iMSession.getType() & i4) != 0) {
                            IMSessionModule.this.f9327d.put(Long.valueOf(iMSession.getSessionId()), iMSession);
                            if (!TextUtils.isEmpty(iMSession.getLastMessage())) {
                                arrayList2.add(iMSession);
                            }
                        }
                    }
                }
                if (z2) {
                    for (IMSessionDaoEntity daoEntity2 : IMSessionModule.this.f9325b.getSessionDao().queryBuilder().whereOr(SessionDao.Properties.Last_message.isNotNull(), SessionDao.Properties.Last_message.notEq(""), new WhereCondition[0]).where(SessionDao.Properties.Is_info_loaded.mo43479eq(false), new WhereCondition[0]).orderDesc(SessionDao.Properties.Last_modify_time).list()) {
                        IMSession iMSession2 = new IMSession();
                        iMSession2.setDaoEntity(daoEntity2);
                        if ((iMSession2.getType() & i4) != 0) {
                            IMSessionModule.this.f9327d.put(Long.valueOf(iMSession2.getSessionId()), iMSession2);
                            if (!TextUtils.isEmpty(iMSession2.getLastMessage())) {
                                arrayList2.add(iMSession2);
                            }
                        }
                    }
                }
                Collections.sort(arrayList2, comparator2);
                return arrayList2;
            }

            /* access modifiers changed from: protected */
            public void onPostExecute(List<IMSession> list) {
                IMFeedSessionCallback iMFeedSessionCallback = iMFeedSessionCallback2;
                if (iMFeedSessionCallback != null) {
                    iMFeedSessionCallback.onFeedSessionsLoad(list, i3, i4);
                }
            }
        }.setErrorCallback(getErrorCallback()).executeWithDatabase(new Void[0]);
    }

    public void updateSessionEnableStatus(long j, boolean z, int i) {
        updateSessionEnableStatus(j, z, i, (String) null);
    }

    public IMSession updateSessionEnableStatus(long j, boolean z, int i, String str) {
        return updateSessionStatusAndSize(j, z, i, str, 0);
    }

    public IMSession updateSessionStatusAndSize(long j, boolean z, int i, String str, int i2) {
        IMSession iMSession = this.f9327d.get(Long.valueOf(j));
        if (iMSession != null) {
            iMSession.setSessionEnable(z);
            if (!z) {
                iMSession.setUnreadCount(0);
                iMSession.setRedDotCount(0);
                m6339c(iMSession);
            }
            IMSessionExtendInfo extendSessionInfo = iMSession.getExtendSessionInfo();
            if (extendSessionInfo != null) {
                extendSessionInfo.input = i;
                if (!TextUtils.isEmpty(str)) {
                    extendSessionInfo.na_txt = str;
                }
                iMSession.setExtendSessionInfo(extendSessionInfo);
                if (i2 != 0) {
                    iMSession.setGroupNum(iMSession.getGroupNum() + i2);
                }
                this.f9327d.put(Long.valueOf(j), iMSession);
                m6326a(iMSession, false);
            }
        }
        return iMSession;
    }

    public void clearUnreadCount(final long j) {
        this.f9330g.track(Long.valueOf(j));
        new IMTaskJob<Void, Void, IMSession>() {
            /* access modifiers changed from: protected */
            public IMSession doInBackground(Void... voidArr) {
                IMSession iMSession = IMSessionModule.this.f9327d.get(Long.valueOf(j));
                if (iMSession == null) {
                    return null;
                }
                iMSession.setUnreadCount(0);
                iMSession.setRedDotCount(0);
                IMSessionModule.this.m6339c(iMSession);
                IMSessionModule.this.f9325b.getSessionDao().insertOrReplace(iMSession.getDaoEntity());
                return iMSession;
            }

            /* access modifiers changed from: protected */
            public void onPostExecute(IMSession iMSession) {
                if (iMSession != null) {
                    for (IMSessionCallback onSessionStatusUpdate : IMSessionModule.this.f9326c) {
                        onSessionStatusUpdate.onSessionStatusUpdate(Arrays.asList(new IMSession[]{iMSession}));
                    }
                }
            }
        }.setErrorCallback(getErrorCallback()).executeWithDatabase(new Void[0]);
    }

    public void setUnreadCount(final long j, final int i) {
        this.f9330g.track(Long.valueOf(j));
        new IMTaskJob<Void, Void, IMSession>() {
            /* access modifiers changed from: protected */
            public IMSession doInBackground(Void... voidArr) {
                IMSession iMSession = IMSessionModule.this.f9327d.get(Long.valueOf(j));
                if (iMSession == null) {
                    return null;
                }
                iMSession.setUnreadCount(Math.max(0, i));
                IMSessionModule.this.f9325b.getSessionDao().insertOrReplace(iMSession.getDaoEntity());
                return iMSession;
            }

            /* access modifiers changed from: protected */
            public void onPostExecute(IMSession iMSession) {
                if (iMSession != null) {
                    for (IMSessionCallback onSessionStatusUpdate : IMSessionModule.this.f9326c) {
                        onSessionStatusUpdate.onSessionStatusUpdate(Arrays.asList(new IMSession[]{iMSession}));
                    }
                }
            }
        }.setErrorCallback(getErrorCallback()).executeWithDatabase(new Void[0]);
    }

    public void clearSessionsUnreadCount(final int i, final IMClearSessionUnreadCountCallback iMClearSessionUnreadCountCallback) {
        this.f9330g.track(Integer.valueOf(i));
        new IMTaskJob<Void, Void, List<IMSession>>() {
            /* access modifiers changed from: protected */
            public List<IMSession> doInBackground(Void... voidArr) {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                for (IMSession next : IMSessionModule.this.f9327d.values()) {
                    if (!((next.getType() & i) == 0 || (next.getUnreadCount() == 0 && next.getRedDotCount() == 0))) {
                        next.setUnreadCount(0);
                        next.setRedDotCount(0);
                        IMSessionModule.this.m6339c(next);
                        arrayList.add(next.getDaoEntity());
                        arrayList2.add(next);
                    }
                }
                try {
                    IMSessionModule.this.f9325b.getSessionDao().insertOrReplaceInTx(arrayList);
                    return arrayList2;
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }

            /* access modifiers changed from: protected */
            public void onPostExecute(List<IMSession> list) {
                IMClearSessionUnreadCountCallback iMClearSessionUnreadCountCallback = iMClearSessionUnreadCountCallback;
                if (iMClearSessionUnreadCountCallback != null) {
                    iMClearSessionUnreadCountCallback.onSessionUnreadCountCleared(list != null);
                }
            }
        }.setErrorCallback(getErrorCallback()).executeWithDatabase(new Void[0]);
    }

    public void clearSessionsUnreadCount(long[] jArr) {
        this.f9330g.track(jArr);
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        for (long valueOf : jArr) {
            IMSession iMSession = this.f9327d.get(Long.valueOf(valueOf));
            if (!(iMSession == null || (iMSession.getUnreadCount() == 0 && iMSession.getRedDotCount() == 0))) {
                iMSession.setUnreadCount(0);
                iMSession.setRedDotCount(0);
                m6339c(iMSession);
                arrayList.add(iMSession.getDaoEntity());
                arrayList2.add(iMSession);
            }
        }
        if (!arrayList.isEmpty()) {
            new IMTaskJob<Void, Void, List<IMSession>>() {
                /* access modifiers changed from: protected */
                public List<IMSession> doInBackground(Void... voidArr) {
                    try {
                        IMSessionModule.this.f9325b.getSessionDao().insertOrReplaceInTx(arrayList);
                        return arrayList2;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return null;
                    }
                }

                /* access modifiers changed from: protected */
                public void onPostExecute(List<IMSession> list) {
                    if (list != null) {
                        for (IMSessionCallback onSessionStatusUpdate : IMSessionModule.this.f9326c) {
                            onSessionStatusUpdate.onSessionStatusUpdate(list);
                        }
                    }
                }
            }.setErrorCallback(getErrorCallback()).executeWithDatabase(new Void[0]);
        }
    }

    public void findSessionUnreadCount(final List<Long> list, final IMSessionUnreadCallback iMSessionUnreadCallback) {
        this.f9330g.track(list);
        new IMTaskJob<Void, Void, Integer>() {
            /* access modifiers changed from: protected */
            public Integer doInBackground(Void... voidArr) {
                int i = 0;
                List<IMSessionDaoEntity> list = IMSessionModule.this.f9325b.getSessionDao().queryBuilder().where(SessionDao.Properties.Session_id.mo43482in((Collection<?>) list), SessionDao.Properties.Unread_count.mo43481gt(0)).list();
                if (list == null || list.size() <= 0) {
                    return 0;
                }
                for (IMSessionDaoEntity unread_count : list) {
                    i += unread_count.getUnread_count();
                }
                IMLog.m6631d(IMSessionModule.TAG, "[findSessionUnreadCount] sidsSize=" + list.size() + " |querySize=" + list.size() + " |totalUnreadCount=" + i);
                return Integer.valueOf(i);
            }

            /* access modifiers changed from: protected */
            public void onPostExecute(Integer num) {
                super.onPostExecute(num);
                if (iMSessionUnreadCallback != null) {
                    if (num == null) {
                        num = 0;
                    }
                    iMSessionUnreadCallback.unReadCount(num.intValue());
                }
            }
        }.executeWithDatabase(new Void[0]);
    }

    public void findSessionUnreadCount(final List<Long> list, final IMSessionUnreadSysChatMsgCallback iMSessionUnreadSysChatMsgCallback) {
        this.f9330g.track(list);
        new IMTaskJob<Void, Void, IMSysChatUnreadCount>() {
            /* access modifiers changed from: protected */
            public IMSysChatUnreadCount doInBackground(Void... voidArr) {
                IMSysChatUnreadCount iMSysChatUnreadCount = new IMSysChatUnreadCount();
                int i = 0;
                List<IMSessionDaoEntity> list = IMSessionModule.this.f9325b.getSessionDao().queryBuilder().where(SessionDao.Properties.Session_id.mo43482in((Collection<?>) list), SessionDao.Properties.Unread_count.mo43481gt(0)).list();
                if (list != null && list.size() > 0) {
                    for (IMSessionDaoEntity daoEntity : list) {
                        IMSession iMSession = new IMSession();
                        iMSession.setDaoEntity(daoEntity);
                        if (iMSession.getClientExtendSessionInfo() != null) {
                            iMSysChatUnreadCount.chatMsgUnreadCount += iMSession.getClientExtendSessionInfo().chatMsgUnreadCount;
                            iMSysChatUnreadCount.sysMsgUnreadCount += iMSession.getClientExtendSessionInfo().sysMsgUnreadCount;
                        }
                    }
                    for (IMSessionDaoEntity iMSessionDaoEntity : list) {
                        i += iMSessionDaoEntity.getUnread_count();
                        IMSession iMSession2 = new IMSession();
                        iMSession2.setDaoEntity(iMSessionDaoEntity);
                        if (iMSession2.getClientExtendSessionInfo() == null) {
                            iMSession2.setClientExtendInfo(new IMSessionClientExtendInfo());
                        }
                    }
                    IMLog.m6631d(IMSessionModule.TAG, "[findSessionUnreadCount] sidsSize=" + list.size() + " |querySize=" + list.size() + " |totalUnreadCount=" + i);
                }
                return iMSysChatUnreadCount;
            }

            /* access modifiers changed from: protected */
            public void onPostExecute(IMSysChatUnreadCount iMSysChatUnreadCount) {
                super.onPostExecute(iMSysChatUnreadCount);
                if (iMSessionUnreadSysChatMsgCallback != null) {
                    if (iMSysChatUnreadCount == null) {
                        iMSysChatUnreadCount = new IMSysChatUnreadCount();
                    }
                    iMSessionUnreadSysChatMsgCallback.unreadSysChatMsg(iMSysChatUnreadCount);
                }
            }
        }.executeWithDatabase(new Void[0]);
    }

    public void findSessionRedDotCount(final long j, IMSessionUnreadCallback iMSessionUnreadCallback) {
        final int i;
        this.f9330g.track(Long.valueOf(j), Long.valueOf(j));
        if (iMSessionUnreadCallback != null) {
            i = iMSessionUnreadCallback.hashCode();
            this.f9328e.put((long) i, iMSessionUnreadCallback);
        } else {
            i = 0;
        }
        new IMTaskJob<Void, Void, Integer>() {
            /* access modifiers changed from: protected */
            public Integer doInBackground(Void... voidArr) {
                List list = IMSessionModule.this.f9325b.getSessionDao().queryBuilder().where(SessionDao.Properties.Session_id.mo43479eq(Long.valueOf(j)), new WhereCondition[0]).list();
                if (list == null || list.size() <= 0) {
                    return 0;
                }
                return Integer.valueOf(((IMSessionDaoEntity) list.get(0)).getReserveInt2());
            }

            /* access modifiers changed from: protected */
            public void onPostExecute(Integer num) {
                super.onPostExecute(num);
                if (num != null && IMSessionModule.this.f9328e.get((long) i) != null && (IMSessionModule.this.f9328e.get((long) i) instanceof IMSessionUnreadCallback)) {
                    ((IMSessionUnreadCallback) IMSessionModule.this.f9328e.get((long) i)).unReadCount(num.intValue());
                }
            }
        }.executeWithDatabase(new Void[0]);
    }

    public void clearRedDotCount(final long j) {
        this.f9330g.track(Long.valueOf(j));
        new IMTaskJob<Void, Void, IMSession>() {
            /* access modifiers changed from: protected */
            public IMSession doInBackground(Void... voidArr) {
                IMSession iMSession = IMSessionModule.this.f9327d.get(Long.valueOf(j));
                if (iMSession == null) {
                    return null;
                }
                iMSession.setRedDotCount(0);
                IMSessionModule.this.f9325b.getSessionDao().insertOrReplace(iMSession.getDaoEntity());
                return iMSession;
            }

            /* access modifiers changed from: protected */
            public void onPostExecute(IMSession iMSession) {
                if (iMSession != null) {
                    for (IMSessionCallback onSessionStatusUpdate : IMSessionModule.this.f9326c) {
                        onSessionStatusUpdate.onSessionStatusUpdate(Arrays.asList(new IMSession[]{iMSession}));
                    }
                }
            }
        }.setErrorCallback(getErrorCallback()).executeWithDatabase(new Void[0]);
    }

    /* renamed from: a */
    private void m6325a(IMSession iMSession) {
        if (iMSession != null) {
            if (iMSession.getType() == 2) {
                IMModelProvider.getInstance().getUserModule().insertGroupUserinfo(iMSession.getUserInfos(), iMSession.getSessionId());
                return;
            }
            List<IMUser> userInfos = iMSession.getUserInfos();
            if (userInfos != null) {
                for (IMUser next : userInfos) {
                    if (IMModelProvider.getInstance().getUserModule() != null) {
                        IMModelProvider.getInstance().getUserModule().insertUserinfo(next);
                    }
                }
            }
        }
    }

    public void getSessionInfoFormNet(final long[] jArr, long[] jArr2, int i, final IMSessionCallback iMSessionCallback) {
        this.f9330g.track();
        final ArrayList arrayList = new ArrayList();
        IMGetSessionInfoRequest iMGetSessionInfoRequest = new IMGetSessionInfoRequest(i);
        iMGetSessionInfoRequest.setSids(jArr);
        IMHttpManager.getInstance().performCommonPost(iMGetSessionInfoRequest, new IMNetCallback<IMGetSessionInfoResponse>() {
            public void failure(IOException iOException) {
            }

            public void success(final IMGetSessionInfoResponse iMGetSessionInfoResponse) {
                if (iMGetSessionInfoResponse != null && iMGetSessionInfoResponse.isSuccess()) {
                    List<IMSessionInfo> list = iMGetSessionInfoResponse.body.infos;
                    for (int i = 0; i < list.size(); i++) {
                        IMSession parseIMSession = IMApiParser.parseIMSession(list.get(i));
                        if (IMSessionModule.this.m6337b(parseIMSession)) {
                            arrayList.add(parseIMSession);
                        }
                    }
                } else if (iMGetSessionInfoResponse != null && iMGetSessionInfoResponse.errno == 111) {
                    IMSessionModule.this.updateSessionEnableStatus(jArr[0], false, 0);
                }
                IMSessionModule.this.f9329f.post(new Runnable() {
                    public void run() {
                        if (iMGetSessionInfoResponse != null && iMSessionCallback != null) {
                            if (iMGetSessionInfoResponse.isSuccess()) {
                                iMSessionCallback.onSessionLoad(arrayList);
                            } else {
                                iMSessionCallback.onSessionOptionResult((List<IMSession>) null, iMGetSessionInfoResponse.errno);
                            }
                        }
                    }
                });
            }
        });
    }

    public IMSession getSessionFromLocal(long j) {
        IMSession iMSession;
        this.f9330g.track();
        if (!this.f9327d.isEmpty() && (iMSession = this.f9327d.get(Long.valueOf(j))) != null) {
            return iMSession;
        }
        try {
            List list = this.f9325b.getSessionDao().queryBuilder().where(SessionDao.Properties.Session_id.mo43479eq(Long.valueOf(j)), new WhereCondition[0]).list();
            if (list == null || list.size() <= 0) {
                return null;
            }
            IMSession iMSession2 = new IMSession();
            iMSession2.setDaoEntity((IMSessionDaoEntity) list.get(0));
            this.f9327d.put(Long.valueOf(j), iMSession2);
            return iMSession2;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void getSessionFromLocal(final long j, final IMSessionCallback iMSessionCallback) {
        IMSession iMSession;
        if (iMSessionCallback != null) {
            if (this.f9327d.isEmpty() || (iMSession = this.f9327d.get(Long.valueOf(j))) == null) {
                IMThreadHelper.getInstance().execute(new Runnable() {
                    public void run() {
                        final List list = IMSessionModule.this.f9325b.getSessionDao().queryBuilder().where(SessionDao.Properties.Session_id.mo43479eq(Long.valueOf(j)), new WhereCondition[0]).list();
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            public void run() {
                                List list = list;
                                if (list != null && list.size() > 0) {
                                    IMSession iMSession = new IMSession();
                                    iMSession.setDaoEntity((IMSessionDaoEntity) list.get(0));
                                    IMSessionModule.this.f9327d.put(Long.valueOf(j), iMSession);
                                    iMSessionCallback.onSessionLoad(Collections.singletonList(iMSession));
                                }
                            }
                        });
                    }
                });
            } else {
                iMSessionCallback.onSessionLoad(Collections.singletonList(iMSession));
            }
        }
    }

    public void syncSessionStatus(int i, int i2, IMBusinessParam iMBusinessParam, IMSession iMSession, IMSessionCallback iMSessionCallback) {
        IMSyncSessionStatusRequest iMSyncSessionStatusRequest;
        this.f9330g.track();
        final ArrayList arrayList = new ArrayList();
        if (shouldAddUserInfoReqParams(iMBusinessParam)) {
            long sessionId = iMSession.getSessionId();
            long orderId = iMBusinessParam.getOrderId();
            long routeId = iMBusinessParam.getRouteId();
            int sourceId = iMBusinessParam.getSourceId();
            String secret = iMBusinessParam.getSecret();
            String nickName = iMSession.getSelfUser().getNickName();
            String avatarUrl = iMSession.getSelfUser().getAvatarUrl();
            long peerUid = iMSession.getPeerUid();
            String nickName2 = iMSession.getPeerUser().getNickName();
            String avatarUrl2 = iMSession.getPeerUser().getAvatarUrl();
            int productId = iMBusinessParam.getProductId();
            String str = iMBusinessParam.getsOrderId();
            String cityID = iMBusinessParam.getCityID();
            String selfEngNickName = iMBusinessParam.getSelfEngNickName();
            String peerEngNickName = iMBusinessParam.getPeerEngNickName();
            iMSyncSessionStatusRequest = new IMSyncSessionStatusRequest(sessionId, orderId, routeId, i, sourceId, secret, nickName, avatarUrl, peerUid, nickName2, avatarUrl2, productId, str, cityID, selfEngNickName, peerEngNickName, IMContextInfoHelper.getBusinessPayload(iMBusinessParam.getBusinessId() + ""), iMSession.getLastFlushTime(), iMBusinessParam.getExtraInfo());
        } else {
            long sessionId2 = iMSession.getSessionId();
            long peerUid2 = iMSession.getPeerUid();
            long orderId2 = iMBusinessParam.getOrderId();
            long routeId2 = iMBusinessParam.getRouteId();
            int sourceId2 = iMBusinessParam.getSourceId();
            int productId2 = iMBusinessParam.getProductId();
            iMSyncSessionStatusRequest = new IMSyncSessionStatusRequest(sessionId2, peerUid2, orderId2, routeId2, i, sourceId2, productId2, IMContextInfoHelper.getBusinessPayload(iMBusinessParam.getBusinessId() + ""), iMSession.getLastFlushTime(), iMBusinessParam.getExtraInfo());
        }
        iMSyncSessionStatusRequest.setRobotGuideId(iMBusinessParam.getRobotGuideId());
        final IMSessionCallback iMSessionCallback2 = iMSessionCallback;
        IMHttpManager.getInstance().performCommonPost(iMSyncSessionStatusRequest, new IMNetCallback<IMGetSessionInfoResponse>() {
            public void success(final IMGetSessionInfoResponse iMGetSessionInfoResponse) {
                if (iMGetSessionInfoResponse == null || iMGetSessionInfoResponse.body == null || !iMGetSessionInfoResponse.isSuccess()) {
                    if (iMGetSessionInfoResponse != null && iMGetSessionInfoResponse.errno == 111) {
                        EventBus.getDefault().post(new IMSessionInfoUpdateErrorEvent(111));
                    }
                    IMSessionModule.this.f9329f.post(new Runnable() {
                        public void run() {
                            if (iMSessionCallback2 != null) {
                                IMSessionCallback iMSessionCallback = iMSessionCallback2;
                                IMGetSessionInfoResponse iMGetSessionInfoResponse = iMGetSessionInfoResponse;
                                iMSessionCallback.onSessionOptionResult((List<IMSession>) null, iMGetSessionInfoResponse != null ? iMGetSessionInfoResponse.errno : -1);
                            }
                        }
                    });
                    return;
                }
                List<IMSessionInfo> list = iMGetSessionInfoResponse.body.infos;
                for (int i = 0; i < list.size(); i++) {
                    IMSession parseIMSession = IMApiParser.parseIMSession(list.get(i));
                    parseIMSession.recommendString = iMGetSessionInfoResponse.body.recom;
                    if (IMSessionModule.this.m6337b(parseIMSession)) {
                        arrayList.add(parseIMSession);
                    }
                }
                IMSessionModule.this.f9329f.post(new Runnable() {
                    public void run() {
                        if (iMSessionCallback2 != null) {
                            iMSessionCallback2.onSessionLoad(arrayList);
                        }
                    }
                });
            }

            public void failure(IOException iOException) {
                IMSessionModule.this.f9329f.post(new Runnable() {
                    public void run() {
                        if (iMSessionCallback2 != null) {
                            iMSessionCallback2.onSessionOptionResult((List<IMSession>) null, -1);
                        }
                    }
                });
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public boolean m6337b(IMSession iMSession) {
        IMSession iMSession2 = this.f9327d.get(Long.valueOf(iMSession.getSessionId()));
        if (iMSession2 != null) {
            iMSession.setUnreadCount(iMSession2.getUnreadCount());
            iMSession.setRedDotCount(iMSession2.getRedDotCount());
            iMSession.setLastMessage(iMSession2.getLastMessage());
            iMSession.setRecentMessages(iMSession2.getRecentMessages());
            iMSession.setClientExtendInfo(iMSession2.getClientExtendSessionInfo());
            iMSession.setServiceExtendInfo(iMSession2.getServiceExtendSessionInfo());
            iMSession.setLastModifyTime(iMSession2.getLastModifyTime());
            iMSession.setLastMsgStatus(iMSession2.getLastMsgStatus());
            iMSession.setLastMessageId(iMSession2.getLastMessageId());
            iMSession.setGroupNum(iMSession2.getGroupNum());
            if (TextUtils.isEmpty(iMSession.getSessionName())) {
                iMSession.setSessionName(iMSession2.getSessionName());
            }
            if (TextUtils.isEmpty(iMSession.getSessionImg())) {
                iMSession.setSessionImg(iMSession2.getSessionImg());
            }
            if (TextUtils.isEmpty(iMSession.getTag())) {
                iMSession.setTag(iMSession2.getTag());
            }
            this.f9327d.put(Long.valueOf(iMSession.getSessionId()), iMSession);
        }
        if (iMSession.getType() == 2 && iMSession.getUserInfos() != null && iMSession.getUserInfos().size() > 0) {
            iMSession.setGroupNum(iMSession.getUserInfos().size());
        }
        try {
            m6325a(iMSession);
            this.f9325b.insertOrReplace(iMSession.getDaoEntity());
            this.f9327d.put(Long.valueOf(iMSession.getSessionId()), iMSession);
            return true;
        } catch (Exception e) {
            IMLog.m6632e(TAG, "fillAndSaveSession failed! exception = " + e.toString());
            e.printStackTrace();
            return false;
        }
    }

    public void closeSession(final long j) {
        this.f9330g.track(Long.valueOf(j));
        IMThreadHelper.getInstance().execute(new Runnable() {
            public void run() {
                IMSession sessionFromLocal = IMSessionModule.this.getSessionFromLocal(j);
                IMHttpManager.getInstance().performCommonPost(new IMCloseSessionRequest(j, sessionFromLocal != null ? sessionFromLocal.getPeerUid() : 0), (IMNetCallback<?>) null);
            }
        });
    }

    public void getInvalidSessionUnreadCount(final IMSessionUnreadCallback iMSessionUnreadCallback) {
        this.f9330g.track();
        new IMTaskJob<Void, Void, Integer>() {
            /* JADX WARNING: type inference failed for: r0v0, types: [java.lang.String[], android.database.Cursor] */
            /* JADX WARNING: type inference failed for: r0v1, types: [android.database.Cursor] */
            /* JADX WARNING: type inference failed for: r0v2, types: [android.database.Cursor] */
            /* access modifiers changed from: protected */
            /* JADX WARNING: Code restructure failed: missing block: B:14:0x002e, code lost:
                if (r0 == 0) goto L_0x0031;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:16:0x0035, code lost:
                return java.lang.Integer.valueOf(r4);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:7:0x0020, code lost:
                if (r0 != 0) goto L_0x0022;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:8:0x0022, code lost:
                r0.close();
             */
            /* JADX WARNING: Failed to insert additional move for type inference */
            /* JADX WARNING: Multi-variable type inference failed */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.lang.Integer doInBackground(java.lang.Void... r4) {
                /*
                    r3 = this;
                    r4 = 0
                    r0 = 0
                    com.didi.beatles.im.module.impl.IMSessionModule r1 = com.didi.beatles.p099im.module.impl.IMSessionModule.this     // Catch:{ Exception -> 0x002d, all -> 0x0026 }
                    com.didi.beatles.im.db.dao.DaoSession r1 = r1.f9325b     // Catch:{ Exception -> 0x002d, all -> 0x0026 }
                    com.didi.beatles.im.db.dao.SessionDao r1 = r1.getSessionDao()     // Catch:{ Exception -> 0x002d, all -> 0x0026 }
                    com.didi.beatles.im.thirty.greenrobot.dao.database.Database r1 = r1.getDatabase()     // Catch:{ Exception -> 0x002d, all -> 0x0026 }
                    java.lang.String r2 = "select sum(UNREAD_COUNT) from im_session_table_new WHERE IS_INFO_LOADED = 1"
                    android.database.Cursor r0 = r1.rawQuery(r2, r0)     // Catch:{ Exception -> 0x002d, all -> 0x0026 }
                    if (r0 == 0) goto L_0x0020
                    boolean r1 = r0.moveToNext()     // Catch:{ Exception -> 0x002d, all -> 0x0026 }
                    if (r1 == 0) goto L_0x0020
                    int r4 = r0.getInt(r4)     // Catch:{ Exception -> 0x002d, all -> 0x0026 }
                L_0x0020:
                    if (r0 == 0) goto L_0x0031
                L_0x0022:
                    r0.close()
                    goto L_0x0031
                L_0x0026:
                    r4 = move-exception
                    if (r0 == 0) goto L_0x002c
                    r0.close()
                L_0x002c:
                    throw r4
                L_0x002d:
                    if (r0 == 0) goto L_0x0031
                    goto L_0x0022
                L_0x0031:
                    java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
                    return r4
                */
                throw new UnsupportedOperationException("Method not decompiled: com.didi.beatles.p099im.module.impl.IMSessionModule.C411421.doInBackground(java.lang.Void[]):java.lang.Integer");
            }

            /* access modifiers changed from: protected */
            public void onPostExecute(Integer num) {
                super.onPostExecute(num);
                IMSessionUnreadCallback iMSessionUnreadCallback = iMSessionUnreadCallback;
                if (iMSessionUnreadCallback != null) {
                    iMSessionUnreadCallback.unReadCount(num.intValue());
                }
            }
        }.executeWithDatabase(new Void[0]);
    }

    public void getAllUnreadCount(final IMSessionUnreadCallback iMSessionUnreadCallback) {
        this.f9330g.track();
        new IMTaskJob<Void, Void, Integer>() {
            /* JADX WARNING: type inference failed for: r0v0, types: [java.lang.String[], android.database.Cursor] */
            /* JADX WARNING: type inference failed for: r0v1, types: [android.database.Cursor] */
            /* JADX WARNING: type inference failed for: r0v2, types: [android.database.Cursor] */
            /* access modifiers changed from: protected */
            /* JADX WARNING: Code restructure failed: missing block: B:14:0x002e, code lost:
                if (r0 == 0) goto L_0x0031;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:16:0x0035, code lost:
                return java.lang.Integer.valueOf(r4);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:7:0x0020, code lost:
                if (r0 != 0) goto L_0x0022;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:8:0x0022, code lost:
                r0.close();
             */
            /* JADX WARNING: Failed to insert additional move for type inference */
            /* JADX WARNING: Multi-variable type inference failed */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.lang.Integer doInBackground(java.lang.Void... r4) {
                /*
                    r3 = this;
                    r4 = 0
                    r0 = 0
                    com.didi.beatles.im.module.impl.IMSessionModule r1 = com.didi.beatles.p099im.module.impl.IMSessionModule.this     // Catch:{ Exception -> 0x0028 }
                    com.didi.beatles.im.db.dao.DaoSession r1 = r1.f9325b     // Catch:{ Exception -> 0x0028 }
                    com.didi.beatles.im.db.dao.SessionDao r1 = r1.getSessionDao()     // Catch:{ Exception -> 0x0028 }
                    com.didi.beatles.im.thirty.greenrobot.dao.database.Database r1 = r1.getDatabase()     // Catch:{ Exception -> 0x0028 }
                    java.lang.String r2 = "select sum(UNREAD_COUNT) from im_session_table_new"
                    android.database.Cursor r0 = r1.rawQuery(r2, r0)     // Catch:{ Exception -> 0x0028 }
                    if (r0 == 0) goto L_0x0020
                    boolean r1 = r0.moveToNext()     // Catch:{ Exception -> 0x0028 }
                    if (r1 == 0) goto L_0x0020
                    int r4 = r0.getInt(r4)     // Catch:{ Exception -> 0x0028 }
                L_0x0020:
                    if (r0 == 0) goto L_0x0031
                L_0x0022:
                    r0.close()
                    goto L_0x0031
                L_0x0026:
                    r4 = move-exception
                    goto L_0x0036
                L_0x0028:
                    r1 = move-exception
                    java.lang.String r2 = "im_unread_error"
                    com.didi.beatles.p099im.omega.IMTraceError.trackError(r2, r1)     // Catch:{ all -> 0x0026 }
                    if (r0 == 0) goto L_0x0031
                    goto L_0x0022
                L_0x0031:
                    java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
                    return r4
                L_0x0036:
                    if (r0 == 0) goto L_0x003b
                    r0.close()
                L_0x003b:
                    throw r4
                */
                throw new UnsupportedOperationException("Method not decompiled: com.didi.beatles.p099im.module.impl.IMSessionModule.C411522.doInBackground(java.lang.Void[]):java.lang.Integer");
            }

            /* access modifiers changed from: protected */
            public void onPostExecute(Integer num) {
                super.onPostExecute(num);
                IMSessionUnreadCallback iMSessionUnreadCallback = iMSessionUnreadCallback;
                if (iMSessionUnreadCallback != null) {
                    iMSessionUnreadCallback.unReadCount(num.intValue());
                }
            }
        }.executeWithDatabase(new Void[0]);
    }

    public void getAllRedDotCount(final IMSessionUnreadCallback iMSessionUnreadCallback) {
        this.f9330g.track();
        new IMTaskJob<Void, Void, Integer>() {
            /* JADX WARNING: type inference failed for: r0v0, types: [java.lang.String[], android.database.Cursor] */
            /* JADX WARNING: type inference failed for: r0v1, types: [android.database.Cursor] */
            /* JADX WARNING: type inference failed for: r0v2, types: [android.database.Cursor] */
            /* access modifiers changed from: protected */
            /* JADX WARNING: Code restructure failed: missing block: B:14:0x0031, code lost:
                if (r0 == 0) goto L_0x0034;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:16:0x0038, code lost:
                return java.lang.Integer.valueOf(r4);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:7:0x0020, code lost:
                if (r0 != 0) goto L_0x0022;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:8:0x0022, code lost:
                r0.close();
             */
            /* JADX WARNING: Failed to insert additional move for type inference */
            /* JADX WARNING: Multi-variable type inference failed */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.lang.Integer doInBackground(java.lang.Void... r4) {
                /*
                    r3 = this;
                    r4 = 0
                    r0 = 0
                    com.didi.beatles.im.module.impl.IMSessionModule r1 = com.didi.beatles.p099im.module.impl.IMSessionModule.this     // Catch:{ Exception -> 0x0028 }
                    com.didi.beatles.im.db.dao.DaoSession r1 = r1.f9325b     // Catch:{ Exception -> 0x0028 }
                    com.didi.beatles.im.db.dao.SessionDao r1 = r1.getSessionDao()     // Catch:{ Exception -> 0x0028 }
                    com.didi.beatles.im.thirty.greenrobot.dao.database.Database r1 = r1.getDatabase()     // Catch:{ Exception -> 0x0028 }
                    java.lang.String r2 = "select sum(RESERVE_INT2) from im_session_table_new WHERE IS_INFO_LOADED = 1"
                    android.database.Cursor r0 = r1.rawQuery(r2, r0)     // Catch:{ Exception -> 0x0028 }
                    if (r0 == 0) goto L_0x0020
                    boolean r1 = r0.moveToNext()     // Catch:{ Exception -> 0x0028 }
                    if (r1 == 0) goto L_0x0020
                    int r4 = r0.getInt(r4)     // Catch:{ Exception -> 0x0028 }
                L_0x0020:
                    if (r0 == 0) goto L_0x0034
                L_0x0022:
                    r0.close()
                    goto L_0x0034
                L_0x0026:
                    r4 = move-exception
                    goto L_0x0039
                L_0x0028:
                    r1 = move-exception
                    java.lang.String r2 = "im_red_dot_error"
                    com.didi.beatles.p099im.omega.IMTraceError.trackError(r2, r1)     // Catch:{ all -> 0x0026 }
                    com.didi.beatles.p099im.utils.IMLog.m6633e(r1)     // Catch:{ all -> 0x0026 }
                    if (r0 == 0) goto L_0x0034
                    goto L_0x0022
                L_0x0034:
                    java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
                    return r4
                L_0x0039:
                    if (r0 == 0) goto L_0x003e
                    r0.close()
                L_0x003e:
                    throw r4
                */
                throw new UnsupportedOperationException("Method not decompiled: com.didi.beatles.p099im.module.impl.IMSessionModule.C411623.doInBackground(java.lang.Void[]):java.lang.Integer");
            }

            /* access modifiers changed from: protected */
            public void onPostExecute(Integer num) {
                super.onPostExecute(num);
                IMSessionUnreadCallback iMSessionUnreadCallback = iMSessionUnreadCallback;
                if (iMSessionUnreadCallback != null) {
                    iMSessionUnreadCallback.unReadCount(num.intValue());
                }
            }
        }.executeWithDatabase(new Void[0]);
    }

    public void getSessionUnreadInfo(final long j, final IMSessionUnreadInfoCallback iMSessionUnreadInfoCallback) {
        this.f9330g.track(Long.valueOf(j), Long.valueOf(j));
        new IMTaskJob<Void, Void, Integer[]>() {
            /* access modifiers changed from: protected */
            public Integer[] doInBackground(Void... voidArr) {
                IMSessionDaoEntity iMSessionDaoEntity;
                List list = IMSessionModule.this.f9325b.getSessionDao().queryBuilder().where(SessionDao.Properties.Session_id.mo43479eq(Long.valueOf(j)), new WhereCondition[0]).list();
                if (list == null || list.size() <= 0 || (iMSessionDaoEntity = (IMSessionDaoEntity) list.get(0)) == null) {
                    return new Integer[]{0, 0};
                }
                return new Integer[]{Integer.valueOf(iMSessionDaoEntity.getUnread_count()), Integer.valueOf(iMSessionDaoEntity.getReserveInt2())};
            }

            /* access modifiers changed from: protected */
            public void onPostExecute(Integer[] numArr) {
                int i;
                if (iMSessionUnreadInfoCallback != null) {
                    int i2 = 0;
                    if (numArr == null || numArr.length != 2) {
                        i = 0;
                    } else {
                        i2 = numArr[0].intValue();
                        i = numArr[1].intValue();
                    }
                    iMSessionUnreadInfoCallback.onUnreadInfo(i2, i);
                }
            }
        }.executeWithDatabase(new Void[0]);
    }

    public void updateLastSendMessageSync(long j, String str, int i, long j2, long j3, int i2) {
        int i3 = i2;
        this.f9330g.track(Long.valueOf(j), str);
        IMSession iMSession = this.f9327d.get(Long.valueOf(j));
        if (iMSession == null) {
            iMSession = new IMSession();
            long j4 = j;
            iMSession.setSessionId(j);
            iMSession.setBusinessId(i3);
            iMSession.setUsers(new long[]{IMContextInfoHelper.getUid(), j2});
            this.f9327d.put(Long.valueOf(j), iMSession);
        }
        if (iMSession != null) {
            if (!TextUtils.isEmpty(str)) {
                iMSession.setLastMessage(str);
            }
            iMSession.setBusinessId(i3);
            iMSession.setLastMsgStatus(i);
            iMSession.setLastMessageId(j3 + "");
            iMSession.setLastModifyTime(System.currentTimeMillis());
            m6326a(iMSession, true);
        }
    }

    public void updateLastSendMsgReadStatus(long j) {
        IMSession iMSession = this.f9327d.get(Long.valueOf(j));
        if (iMSession == null) {
            IMLog.m6632e(TAG, "updateLastSendMsgReadStatus exec failed while mSession is null sid is " + j);
            return;
        }
        String lastMessage = iMSession.getLastMessage();
        if (lastMessage == null) {
            IMLog.m6632e(TAG, "updateLastSendMsgReadStatus exec failed while lastmsg is null sid is " + j);
            return;
        }
        if (lastMessage.startsWith(IMResource.getString(R.string.im_last_msg_status_un_read))) {
            lastMessage = lastMessage.replace(IMResource.getString(R.string.im_last_msg_status_un_read), IMResource.getString(R.string.im_last_msg_status_has_read));
        } else if (!lastMessage.startsWith(IMResource.getString(R.string.im_last_msg_status_has_read))) {
            lastMessage = IMResource.getString(R.string.im_last_msg_status_has_read) + lastMessage;
        }
        iMSession.setLastMessage(lastMessage);
        m6326a(iMSession, true);
    }

    public void updateSessionSync(IMMessage iMMessage) {
        IMSession iMSession = this.f9327d.get(Long.valueOf(iMMessage.getSid()));
        if (iMSession != null) {
            iMSession.setDraft(iMMessage.lastMessage);
            iMSession.setLastMsgStatus(iMMessage.getStatus());
            iMSession.setLastModifyTime(System.currentTimeMillis());
            m6326a(iMSession, false);
        }
    }

    public void updateLastMessageSync(IMMessage iMMessage) {
        IMSession iMSession;
        this.f9330g.track();
        if (iMMessage != null && (iMSession = this.f9327d.get(Long.valueOf(iMMessage.getSid()))) != null) {
            if (TextUtils.isEmpty(iMMessage.lastMessage)) {
                iMSession.setDraft("");
            } else {
                iMSession.setDraft(iMMessage.lastMessage);
            }
            iMSession.setLastMsgStatus(iMMessage.getStatus());
            m6326a(m6321a(iMMessage, iMSession), false);
        }
    }

    /* renamed from: a */
    private boolean m6332a(Map<Long, ArrayList<IMMessage>> map) {
        boolean z;
        Iterator<Long> it;
        int i;
        int i2;
        long j;
        Map<Long, ArrayList<IMMessage>> map2 = map;
        int i3 = 1;
        int i4 = 0;
        this.f9330g.track(map2);
        if (map2 == null || map.isEmpty()) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<Long> it2 = map.keySet().iterator();
        int i5 = 0;
        while (it2.hasNext()) {
            long longValue = it2.next().longValue();
            if (longValue != -1) {
                ArrayList arrayList2 = map2.get(Long.valueOf(longValue));
                IMSession iMSession = this.f9327d.get(Long.valueOf(longValue));
                if (iMSession == null) {
                    iMSession = new IMSession();
                    iMSession.setDaoEntity(new IMSessionDaoEntity());
                    iMSession.setSessionId(longValue);
                    this.f9327d.put(Long.valueOf(longValue), iMSession);
                }
                iMSession.setType(((IMMessage) arrayList2.get(i4)).getSidType());
                iMSession.setBusinessId(((IMMessage) arrayList2.get(i4)).getBusinessId());
                long j2 = 0;
                if (((IMMessage) arrayList2.get(i4)).getSenderUid() != IMContextInfoHelper.getUid()) {
                    iMSession.setUid_list(IMContextInfoHelper.getUid() + "_" + ((IMMessage) arrayList2.get(i4)).getSenderUid());
                } else if (((IMMessage) arrayList2.get(i4)).getFakeUid() != 0) {
                    iMSession.setUid_list(IMContextInfoHelper.getUid() + "_" + ((IMMessage) arrayList2.get(i4)).getFakeUid());
                }
                iMSession.addRecentMessages(arrayList2);
                if (arrayList2.size() >= i3) {
                    IMMessage iMMessage = (IMMessage) arrayList2.get(arrayList2.size() - i3);
                    int unreadCount = iMSession.getUnreadCount();
                    if (iMSession.getClientExtendSessionInfo() != null) {
                        i2 = iMSession.getClientExtendSessionInfo().sysMsgUnreadCount;
                        i = iMSession.getClientExtendSessionInfo().chatMsgUnreadCount;
                    } else {
                        i2 = 0;
                        i = 0;
                    }
                    int redDotCount = iMSession.getRedDotCount();
                    int size = arrayList2.size();
                    Iterator it3 = arrayList2.iterator();
                    while (it3.hasNext()) {
                        IMMessage iMMessage2 = (IMMessage) it3.next();
                        if ((iMMessage2.getMattr() & 1) == j2) {
                            size--;
                        } else if (IMCommandUtils.isSysMessageInUnreadCount(iMMessage2)) {
                            i2++;
                        } else {
                            i++;
                        }
                        if ((iMMessage2.getMattr() & 2) != j2) {
                            m6321a(iMMessage2, iMSession);
                        }
                        if ((iMMessage2.getMattr() & 8) != j2) {
                            redDotCount++;
                            i5++;
                        }
                        Iterator<Long> it4 = it2;
                        if (iMSession.getType() == 4) {
                            if ((iMMessage2.getMattr() & 1) != 0) {
                                IMTraceUtil.addBusinessEvent("im_session_error").add("type", "helper mattr error").add("mid", Long.valueOf(iMMessage2.getMid())).add("sId", Long.valueOf(iMSession.getSessionId())).report();
                            }
                            j = 0;
                        } else {
                            j = 0;
                            if ((iMMessage2.getMattr() & 8) != 0) {
                                IMTraceUtil.addBusinessEvent("im_session_error").add("type", "chat mattr error").add("mid", Long.valueOf(iMMessage2.getMid())).add("sId", Long.valueOf(iMSession.getSessionId())).report();
                            }
                        }
                        Map<Long, ArrayList<IMMessage>> map3 = map;
                        j2 = j;
                        it2 = it4;
                    }
                    it = it2;
                    iMSession.setUnreadCount(unreadCount + size);
                    IMSessionClientExtendInfo iMSessionClientExtendInfo = new IMSessionClientExtendInfo();
                    iMSessionClientExtendInfo.chatMsgUnreadCount = i;
                    iMSessionClientExtendInfo.sysMsgUnreadCount = i2;
                    iMSession.setClientExtendInfo(iMSessionClientExtendInfo);
                    iMSession.setRedDotCount(redDotCount);
                    iMSession.setLastMessageId(iMMessage.getMid() + "");
                } else {
                    it = it2;
                }
                arrayList.add(iMSession);
            } else {
                it = it2;
            }
            map2 = map;
            it2 = it;
            i3 = 1;
            i4 = 0;
        }
        if (i5 > 0) {
            z = true;
            IMPreference.getInstance(getServiceProvider().getContext()).setIsHaveRedDot(true);
        } else {
            z = true;
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        m6331a((List<IMSession>) arrayList);
        return z;
    }

    /* renamed from: a */
    private IMSession m6321a(IMMessage iMMessage, IMSession iMSession) {
        String str;
        String str2;
        if (iMSession == null) {
            return null;
        }
        IMLog.m6631d("im-sdk", "formatMsgStatus name = " + iMMessage.getNickName() + " content = " + iMMessage.getContent() + " ");
        if (iMMessage.getType() == 131072) {
            iMSession.setLastMessage(IMResource.getString(R.string.im_bracket_audio));
            iMSession.setLastModifyTime(iMMessage.getCreateTime());
        } else if (iMMessage.getType() == 327680) {
            iMSession.setLastMessage(IMResource.getString(R.string.im_bracket_expression));
            iMSession.setLastModifyTime(iMMessage.getCreateTime());
        } else if (iMMessage.getType() == 196608) {
            iMSession.setLastMessage(IMResource.getString(R.string.im_bracket_image));
            iMSession.setLastModifyTime(iMMessage.getCreateTime());
        } else if (iMMessage.getType() == 458752) {
            IMRichInfoMsgBody iMRichInfoMsgBody = (IMRichInfoMsgBody) IMJsonUtil.objectFromJson(iMMessage.getContent(), IMRichInfoMsgBody.class);
            if (iMRichInfoMsgBody != null) {
                iMSession.setLastMessage(iMRichInfoMsgBody.content);
                iMSession.setLastModifyTime(iMMessage.getCreateTime());
            }
        } else if (iMMessage.getType() == 393223) {
            IMPluginService plugin = IMPluginFactory.getPlugin(Parser.parsePluginId(iMMessage, -1));
            Context context = IMContextInfoHelper.getContext();
            if (plugin == null || context == null) {
                str2 = iMMessage.getMessageExtendInfo().list_text;
            } else {
                str2 = plugin.getMessageBracket(context) + iMMessage.getMessageExtendInfo().list_text;
            }
            iMSession.setLastMessage(str2);
            iMSession.setLastModifyTime(iMMessage.getCreateTime());
        } else if (iMMessage.getType() == 10486017) {
            IMLocationEntity iMLocationEntity = (IMLocationEntity) IMJsonUtil.objectFromJson(iMMessage.getContent(), IMLocationEntity.class);
            if (iMLocationEntity != null) {
                iMSession.setLastMessage(IMResource.getString(R.string.im_bracket_location) + iMLocationEntity.displayname);
                iMSession.setLastModifyTime(iMMessage.getCreateTime());
            }
        } else if (iMMessage.getType() == 65536 || iMMessage.getType() == 393220 || iMMessage.getType() == 393217 || iMMessage.getType() == 393219 || iMMessage.getType() == 65537) {
            iMSession.setLastMessage(iMMessage.getContent());
            iMSession.setLastModifyTime(iMMessage.getCreateTime());
        } else if (iMMessage.getType() == 393224) {
            iMSession.setLastMessage(iMMessage.getMessageExtendInfo().list_text);
            iMSession.setLastModifyTime(iMMessage.getCreateTime());
        } else if (iMMessage.getType() == 10485761) {
            IMShareLocationBody iMShareLocationBody = (IMShareLocationBody) IMJsonUtil.objectFromJson(iMMessage.getContent(), IMShareLocationBody.class);
            if (iMShareLocationBody != null) {
                iMSession.setLastMessage("[共享位置]" + iMShareLocationBody.text);
                iMSession.setLastModifyTime(iMMessage.getCreateTime());
            }
        } else if (iMMessage.getType() == 528385) {
            iMSession.setLastMessage(iMMessage.getMessageExtendInfo().list_text);
            iMSession.setLastModifyTime(iMMessage.getCreateTime());
        }
        if (iMMessage.getSidType() == 2 && iMMessage.getSenderUid() != IMContextInfoHelper.getUid() && !TextUtils.isEmpty(iMSession.getLastMessage())) {
            iMSession.setLastMessage(iMMessage.getNickName() + ":" + iMSession.getLastMessage());
        }
        if (iMMessage.isSupportReadStatus() && iMMessage.getSenderUid() == IMContextInfoHelper.getUid() && iMSession.supportMsgReadStatus && iMMessage.getStatus() == 200 && iMSession.getLastMessage() != null && !iMSession.getLastMessage().contains(IMResource.getString(R.string.im_last_msg_status_has_read))) {
            if (iMMessage.isRead()) {
                str = IMResource.getString(R.string.im_last_msg_status_has_read);
            } else {
                str = IMResource.getString(R.string.im_last_msg_status_un_read);
            }
            iMSession.setLastMessage(str + iMSession.getLastMessage());
        }
        iMSession.setLastMsgStatus(iMMessage.getStatus());
        iMSession.setLastMessageId(iMMessage.getMid() + "");
        return iMSession;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6331a(List<IMSession> list) {
        this.f9330g.track(list);
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(list.get(i).getDaoEntity());
            if (TextUtils.isEmpty(list.get(i).getSessionName())) {
                long[] jArr = {list.get(i).getSessionId()};
                long[] jArr2 = new long[1];
                IMSession sessionFromLocal = getSessionFromLocal(jArr[0]);
                if (sessionFromLocal != null) {
                    jArr2[0] = sessionFromLocal.getPeerUid();
                }
                getSessionInfoFormNet(jArr, jArr2, list.get(i).getBusinessId(), new IMSessionCallback() {
                    public void onSessionOptionResult(List<IMSession> list, int i) {
                    }

                    public void onSessionStatusUpdate(List<IMSession> list) {
                    }

                    public void onSessionLoad(List<IMSession> list) {
                        IMSessionModule.this.m6336b(list);
                    }
                });
            }
        }
        try {
            this.f9325b.getSessionDao().insertOrReplaceInTx(arrayList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        m6336b(list);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m6336b(final List<IMSession> list) {
        new IMTaskJob<Void, Void, Void>() {
            /* access modifiers changed from: protected */
            public Void doInBackground(Void... voidArr) {
                return null;
            }

            /* access modifiers changed from: protected */
            public void onPostExecute(Void voidR) {
                for (IMSessionCallback onSessionStatusUpdate : IMSessionModule.this.f9326c) {
                    onSessionStatusUpdate.onSessionStatusUpdate(list);
                }
            }
        }.execute(new Void[0]);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6326a(final IMSession iMSession, final boolean z) {
        this.f9330g.track(iMSession);
        new IMTaskJob<Void, Void, Void>() {
            /* access modifiers changed from: protected */
            public Void doInBackground(Void... voidArr) {
                try {
                    IMSessionModule.this.f9325b.getSessionDao().insertOrReplace(iMSession.getDaoEntity());
                    return null;
                } catch (Exception e) {
                    IMTraceError.trackError("im_session_sync_error", e);
                    IMTraceUtil.addBusinessEvent("im_db_error").add("module", "session#update").add("errmsg", e.getMessage()).report();
                    return null;
                }
            }

            /* access modifiers changed from: protected */
            public void onPostExecute(Void voidR) {
                if (z) {
                    for (IMSessionCallback onSessionStatusUpdate : IMSessionModule.this.f9326c) {
                        onSessionStatusUpdate.onSessionStatusUpdate(Arrays.asList(new IMSession[]{iMSession}));
                    }
                }
            }
        }.execute(new Void[0]);
    }

    public void updateSessionStateByMessageAsync(Map<Long, ArrayList<IMMessage>> map) {
        this.f9330g.track(map);
        m6332a(map);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m6334b() {
        this.f9330g.track();
        IMThreadHelper.getInstance().execute(new Runnable() {
            public void run() {
                List list;
                try {
                    list = IMSessionModule.this.f9325b.getSessionDao().queryBuilder().whereOr(SessionDao.Properties.Last_message.isNotNull(), SessionDao.Properties.Last_message.notEq(""), new WhereCondition[0]).where(SessionDao.Properties.Is_info_loaded.mo43479eq(true), new WhereCondition[0]).where(SessionDao.Properties.Type.notEq(4), new WhereCondition[0]).orderDesc(SessionDao.Properties.Last_modify_time).limit(20).list();
                } catch (Exception e) {
                    e.printStackTrace();
                    list = null;
                }
                if (list != null && list.size() != 0) {
                    long[] jArr = new long[list.size()];
                    for (int i = 0; i < list.size(); i++) {
                        jArr[i] = ((IMSessionDaoEntity) list.get(i)).getSession_id();
                    }
                    IMCheckSessionEnableRequest iMCheckSessionEnableRequest = new IMCheckSessionEnableRequest();
                    iMCheckSessionEnableRequest.setSids(jArr);
                    IMHttpManager.getInstance().performCommonPost(iMCheckSessionEnableRequest, new IMNetCallback<IMCheckSessionEnableResponse>() {
                        public void failure(IOException iOException) {
                        }

                        public void success(IMCheckSessionEnableResponse iMCheckSessionEnableResponse) {
                            IMCheckSessionEnableResponse.SessionEnableInfo[] sessionEnableInfoArr;
                            if (iMCheckSessionEnableResponse != null && iMCheckSessionEnableResponse.isSuccess() && (sessionEnableInfoArr = iMCheckSessionEnableResponse.body.info) != null) {
                                ArrayList arrayList = new ArrayList();
                                for (int i = 0; i < sessionEnableInfoArr.length; i++) {
                                    IMSession iMSession = IMSessionModule.this.f9327d.get(Long.valueOf(sessionEnableInfoArr[i].sid));
                                    if (iMSession != null) {
                                        IMLog.m6631d("check", "updata sid is " + sessionEnableInfoArr[i].sid + " ebable is " + sessionEnableInfoArr[i].enable);
                                        iMSession.setSessionEnable(sessionEnableInfoArr[i].enable != 0);
                                        arrayList.add(iMSession.getDaoEntity());
                                    } else {
                                        IMLog.m6631d("check", "cache not have " + sessionEnableInfoArr[i].sid);
                                    }
                                }
                                try {
                                    IMSessionModule.this.f9325b.getSessionDao().insertOrReplaceInTx(arrayList);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    });
                }
            }
        });
    }

    public void modifyGroupForbidState(long j, boolean z, IMModifyGroupForbidCallback iMModifyGroupForbidCallback) {
        if (j != 0) {
            final long j2 = j;
            final boolean z2 = z;
            final IMModifyGroupForbidCallback iMModifyGroupForbidCallback2 = iMModifyGroupForbidCallback;
            IMHttpManager.getInstance().performCommonPost(IMModifyForbidRequest.newForbidGroupRequest(j, z ? 1 : 0), new IMNetCallback<IMBaseResponse>() {
                public void failure(IOException iOException) {
                }

                public void success(final IMBaseResponse iMBaseResponse) {
                    if (iMBaseResponse != null && iMBaseResponse.isSuccess()) {
                        IMSession iMSession = IMSessionModule.this.f9327d.get(Long.valueOf(j2));
                        if (iMSession != null) {
                            iMSession.setLastModifyTime(System.currentTimeMillis());
                            iMSession.setIsfForbid(z2);
                            IMSessionModule.this.m6326a(iMSession, false);
                        }
                        IMSessionModule.this.f9329f.post(new Runnable() {
                            public void run() {
                                if (iMModifyGroupForbidCallback2 != null) {
                                    iMModifyGroupForbidCallback2.onSucceed();
                                }
                            }
                        });
                    } else if (iMBaseResponse != null && !iMBaseResponse.isSuccess()) {
                        IMSessionModule.this.f9329f.post(new Runnable() {
                            public void run() {
                                if (iMModifyGroupForbidCallback2 != null) {
                                    iMModifyGroupForbidCallback2.onFailed(iMBaseResponse.errmsg);
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    public void modifyHelperForbidState(long j, boolean z, IMModifyHelperForbidCallback iMModifyHelperForbidCallback) {
        IMSession iMSession;
        if (j != 0 && (iMSession = this.f9327d.get(Long.valueOf(j))) != null) {
            long peerUid = iMSession.getPeerUid();
            if (iMSession.getType() == 4 && peerUid != 0) {
                final long j2 = j;
                final boolean z2 = z;
                final IMModifyHelperForbidCallback iMModifyHelperForbidCallback2 = iMModifyHelperForbidCallback;
                IMHttpManager.getInstance().performCommonPost(IMModifyForbidRequest.newForbidHelperRequest(peerUid, z ? 1 : 0), new IMNetCallback<IMBaseResponse>() {
                    public void failure(IOException iOException) {
                    }

                    public void success(final IMBaseResponse iMBaseResponse) {
                        if (iMBaseResponse != null && iMBaseResponse.isSuccess()) {
                            IMSession iMSession = IMSessionModule.this.f9327d.get(Long.valueOf(j2));
                            if (iMSession != null) {
                                iMSession.setHelperForbid(z2);
                                IMSessionModule.this.m6326a(iMSession, false);
                            }
                            IMSessionModule.this.f9329f.post(new Runnable() {
                                public void run() {
                                    if (iMModifyHelperForbidCallback2 != null) {
                                        iMModifyHelperForbidCallback2.onSucceed();
                                    }
                                }
                            });
                        } else if (iMBaseResponse != null && !iMBaseResponse.isSuccess()) {
                            IMSessionModule.this.f9329f.post(new Runnable() {
                                public void run() {
                                    if (iMModifyHelperForbidCallback2 != null) {
                                        iMModifyHelperForbidCallback2.onFailed(iMBaseResponse.errmsg);
                                    }
                                }
                            });
                        }
                    }
                });
            }
        }
    }

    public void updateRecentMessages(final long j) {
        this.f9330g.track();
        if (j != 0) {
            new IMTaskJob<Void, Void, IMSession>() {
                /* access modifiers changed from: protected */
                public void onPostExecute(IMSession iMSession) {
                }

                /* access modifiers changed from: protected */
                public IMSession doInBackground(Void... voidArr) {
                    IMSession iMSession = IMSessionModule.this.f9327d.get(Long.valueOf(j));
                    if (iMSession == null || iMSession.getType() != 4) {
                        return null;
                    }
                    List<IMMessageDaoEntity> list = IMSessionModule.this.f9325b.getMessageDao(j).queryBuilder().where(MessageDao.Properties.Type.not(Integer.valueOf(IMApiConst.MsgTypeUnknow)), new WhereCondition[0]).orderDesc(MessageDao.Properties.f9175Id).limit(IMContextInfoHelper.getRecentMessagesCount4Feed(j)).list();
                    if (list == null) {
                        return null;
                    }
                    ArrayList arrayList = new ArrayList(list.size());
                    for (IMMessageDaoEntity iMMessage : list) {
                        arrayList.add(new IMMessage(iMMessage));
                    }
                    iMSession.setRecentMessages(arrayList);
                    IMSessionModule.this.m6331a((List<IMSession>) Arrays.asList(new IMSession[]{iMSession}));
                    return iMSession;
                }
            }.setErrorCallback(getErrorCallback()).executeWithDatabase(new Void[0]);
        }
    }

    public void sendActionTipRequest(int i, long j, long j2, String str, int i2, IMSendActionTipCallback iMSendActionTipCallback) {
        if (j == 0 || TextUtils.isEmpty(str)) {
            return;
        }
        final IMSendActionTipCallback iMSendActionTipCallback2 = iMSendActionTipCallback;
        IMHttpManager.getInstance().performCommonPost(new IMSendActionTipRequest(i, j, j2, str, i2), new IMNetCallback<IMBaseResponse>() {
            public void success(IMBaseResponse iMBaseResponse) {
                if (iMBaseResponse == null || !iMBaseResponse.isSuccess()) {
                    IMSessionModule.this.f9329f.post(new Runnable() {
                        public void run() {
                            if (iMSendActionTipCallback2 != null) {
                                iMSendActionTipCallback2.onFailed();
                            }
                        }
                    });
                } else {
                    IMSessionModule.this.f9329f.post(new Runnable() {
                        public void run() {
                            if (iMSendActionTipCallback2 != null) {
                                iMSendActionTipCallback2.onSucceed();
                            }
                        }
                    });
                }
            }

            public void failure(IOException iOException) {
                IMSessionModule.this.f9329f.post(new Runnable() {
                    public void run() {
                        if (iMSendActionTipCallback2 != null) {
                            iMSendActionTipCallback2.onFailed();
                        }
                    }
                });
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m6339c(IMSession iMSession) {
        IMSessionClientExtendInfo clientExtendSessionInfo;
        if (iMSession != null && (clientExtendSessionInfo = iMSession.getClientExtendSessionInfo()) != null) {
            clientExtendSessionInfo.chatMsgUnreadCount = 0;
            clientExtendSessionInfo.sysMsgUnreadCount = 0;
            iMSession.setClientExtendInfo(clientExtendSessionInfo);
        }
    }
}
