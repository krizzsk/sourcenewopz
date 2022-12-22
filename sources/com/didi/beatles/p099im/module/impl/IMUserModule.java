package com.didi.beatles.p099im.module.impl;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.collection.LongSparseArray;
import androidx.collection.LruCache;
import com.didi.beatles.p099im.IMContextInfoHelper;
import com.didi.beatles.p099im.api.IMApiParser;
import com.didi.beatles.p099im.api.entity.IMGetUserInfoRequest;
import com.didi.beatles.p099im.api.entity.IMGetUserInfoResponse;
import com.didi.beatles.p099im.api.entity.IMUsefulExpressionsRequest;
import com.didi.beatles.p099im.api.entity.IMUsefulExpressionsResponse;
import com.didi.beatles.p099im.debug.IMMethodTracker;
import com.didi.beatles.p099im.module.IIMUserModule;
import com.didi.beatles.p099im.module.IMBaseModule;
import com.didi.beatles.p099im.module.IMSucceedCallback;
import com.didi.beatles.p099im.module.IMUsefulExpressionCallback;
import com.didi.beatles.p099im.module.IMUserInfoCallback;
import com.didi.beatles.p099im.module.entity.IMUser;
import com.didi.beatles.p099im.net.IMHttpManager;
import com.didi.beatles.p099im.net.IMNetCallback;
import com.didi.beatles.p099im.p100db.dao.DaoSession;
import com.didi.beatles.p099im.p100db.dao.UserDao;
import com.didi.beatles.p099im.p100db.entity.IMUserDaoEntity;
import com.didi.beatles.p099im.pref.IMPreference;
import com.didi.beatles.p099im.resource.IMResource;
import com.didi.beatles.p099im.task.IMTaskJob;
import com.didi.beatles.p099im.thirty.greenrobot.dao.query.WhereCondition;
import com.didi.beatles.p099im.utils.IMField;
import com.didi.beatles.p099im.utils.IMJsonUtil;
import com.didi.beatles.p099im.utils.IMLog;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.taxis99.R;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/* renamed from: com.didi.beatles.im.module.impl.IMUserModule */
public class IMUserModule extends IMBaseModule implements IIMUserModule {
    public static final int ADD_USEFUL_EXPRESSION = 1;
    public static final int DELETE_USEFUL_EXPRESSION = 2;
    public static final int Edit_USEFUL_EXPRESSION = 4;
    public static final int GET_USEFUL_EXPRESSION = 3;

    /* renamed from: a */
    private static final String f9331a = "IMUserModule";

    /* renamed from: b */
    private static final int f9332b = 1000;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public DaoSession f9333c = this.mServiceProvider.getDaoManager().getDaoSession();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public LruCache<Long, IMUser> f9334d = new LruCache<>(1000);
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Handler f9335e = new Handler(Looper.getMainLooper());

    /* renamed from: f */
    private IMMethodTracker f9336f = IMMethodTracker.newInstance("IMS");
    /* access modifiers changed from: private */

    /* renamed from: g */
    public LongSparseArray<IMSucceedCallback> f9337g = new LongSparseArray<>();

    public void clearHolders() {
        this.f9337g.clear();
    }

    public void executeUsfulExpression(int i, int i2, String str, IMUsefulExpressionCallback iMUsefulExpressionCallback) {
        executeUsfulExpression(i, i2, str, (String) null, iMUsefulExpressionCallback);
    }

    public void executeUsfulExpression(int i, int i2, String str, String str2, final IMUsefulExpressionCallback iMUsefulExpressionCallback) {
        IMHttpManager.getInstance().performCommonPost(new IMUsefulExpressionsRequest(i, i2, str, str2), new IMNetCallback<IMUsefulExpressionsResponse>() {
            public void success(IMUsefulExpressionsResponse iMUsefulExpressionsResponse) {
                if (!(iMUsefulExpressionsResponse == null || !iMUsefulExpressionsResponse.isSuccess() || iMUsefulExpressionsResponse.body == null)) {
                    IMPreference.getInstance(IMContextInfoHelper.getContext()).saveStringValue(IMPreference.USER_CUSTOM_USEFUL_EXPRESSION, IMJsonUtil.jsonFromObject(iMUsefulExpressionsResponse.body));
                }
                IMUserModule.this.m6344a(iMUsefulExpressionCallback, iMUsefulExpressionsResponse);
            }

            public void failure(IOException iOException) {
                IMUserModule.this.m6344a(iMUsefulExpressionCallback, (IMUsefulExpressionsResponse) null);
            }
        });
    }

    public void kickGroupUser(long j, long j2) {
        IMUserDaoEntity iMUserDaoEntity;
        UserDao userDao = this.f9333c.getUserDao(j);
        if (userDao.count() != 0 && (iMUserDaoEntity = (IMUserDaoEntity) userDao.queryBuilder().where(UserDao.Properties.User_id.mo43479eq(Long.valueOf(j2)), new WhereCondition[0]).unique()) != null) {
            IMUser iMUser = new IMUser(iMUserDaoEntity);
            iMUser.setStatus(1);
            userDao.insertOrReplace(iMUser.getEntity());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6344a(final IMUsefulExpressionCallback iMUsefulExpressionCallback, final IMUsefulExpressionsResponse iMUsefulExpressionsResponse) {
        Handler handler;
        if (iMUsefulExpressionCallback != null && (handler = this.f9335e) != null) {
            handler.post(new Runnable() {
                public void run() {
                    IMUsefulExpressionsResponse iMUsefulExpressionsResponse = iMUsefulExpressionsResponse;
                    if (iMUsefulExpressionsResponse == null) {
                        iMUsefulExpressionCallback.onResponse(-1, IMResource.getString(R.string.bts_im_no_network));
                    } else {
                        iMUsefulExpressionCallback.onResponse(iMUsefulExpressionsResponse.errno, iMUsefulExpressionsResponse.errmsg);
                    }
                }
            });
        }
    }

    public IMUserModule(IMModelProvider iMModelProvider) {
        super(iMModelProvider);
    }

    public void loadUserInfoFromNet(final long[] jArr, final IMUserInfoCallback iMUserInfoCallback) {
        this.f9336f.track(jArr);
        IMGetUserInfoRequest iMGetUserInfoRequest = new IMGetUserInfoRequest();
        iMGetUserInfoRequest.setUids(jArr);
        IMHttpManager.getInstance().performCommonPost(iMGetUserInfoRequest, new IMNetCallback<IMGetUserInfoResponse>() {
            public void failure(IOException iOException) {
            }

            public void success(IMGetUserInfoResponse iMGetUserInfoResponse) {
                List<IMUser> list;
                if (iMGetUserInfoResponse == null || !iMGetUserInfoResponse.isSuccess()) {
                    list = null;
                } else {
                    list = IMApiParser.parseIMUser(iMGetUserInfoResponse.body.infos);
                    for (IMUser next : list) {
                        IMLog.m6631d("sfw", "loadUserInfoFromNet name is " + next.getNickName());
                        if (IMUserModule.this.m6346a(next)) {
                            IMUser iMUser = (IMUser) IMUserModule.this.f9334d.get(Long.valueOf(next.getUid()));
                            if (iMUser != null && TextUtils.isEmpty(next.getAvatarUrl())) {
                                next.setAvatarUrl(iMUser.getAvatarUrl());
                            }
                            IMUserModule.this.f9334d.put(Long.valueOf(next.getUid()), next);
                            IMUserModule.this.f9333c.insertOrReplace(next.getEntity());
                        }
                    }
                }
                if (list != null && list.size() == jArr.length) {
                    final HashMap hashMap = new HashMap();
                    for (IMUser next2 : list) {
                        hashMap.put(Long.valueOf(next2.getUid()), next2);
                    }
                    if (iMUserInfoCallback != null && IMUserModule.this.f9335e != null) {
                        IMUserModule.this.f9335e.post(new Runnable() {
                            public void run() {
                                iMUserInfoCallback.onUserInfoLoaded(hashMap, jArr);
                            }
                        });
                    }
                }
            }
        });
    }

    public void insertUserinfo(IMUser iMUser) {
        if (m6346a(iMUser)) {
            IMUser iMUser2 = this.f9334d.get(Long.valueOf(iMUser.getUid()));
            if (iMUser2 != null && TextUtils.isEmpty(iMUser.getAvatarUrl())) {
                iMUser.setAvatarUrl(iMUser2.getAvatarUrl());
            }
            this.f9334d.put(Long.valueOf(iMUser.getUid()), iMUser);
            try {
                this.f9333c.insertOrReplace(iMUser.getEntity());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void insertGroupUserinfo(List<IMUser> list, long j) {
        if (list != null && list.size() != 0) {
            UserDao userDao = this.f9333c.getUserDao(j);
            long count = userDao.count();
            int i = 0;
            if (count == 0) {
                while (i < list.size()) {
                    userDao.insertOrReplace(list.get(i).getEntity());
                    i++;
                }
                return;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap((int) (((double) count) * 1.5d));
            List loadAll = userDao.loadAll();
            for (int i2 = 0; i2 < loadAll.size(); i2++) {
                IMUser iMUser = new IMUser((IMUserDaoEntity) loadAll.get(i2));
                iMUser.setStatus(1);
                linkedHashMap.put(Long.valueOf(iMUser.getUid()), iMUser);
            }
            while (i < list.size()) {
                IMUser iMUser2 = list.get(i);
                linkedHashMap.put(Long.valueOf(iMUser2.getUid()), iMUser2);
                i++;
            }
            for (IMUser entity : linkedHashMap.values()) {
                userDao.insertOrReplace(entity.getEntity());
            }
        }
    }

    public IMUser getUserInfoFromCache(long j) {
        LruCache<Long, IMUser> lruCache = this.f9334d;
        if (lruCache != null) {
            return lruCache.get(Long.valueOf(j));
        }
        return null;
    }

    public void getUserInfo(final long[] jArr, IMUserInfoCallback iMUserInfoCallback, final boolean z) {
        final int i;
        this.f9336f.track(jArr, iMUserInfoCallback, Boolean.valueOf(z));
        if (iMUserInfoCallback != null) {
            i = iMUserInfoCallback.hashCode();
            this.f9337g.put((long) i, iMUserInfoCallback);
        } else {
            i = 0;
        }
        HashMap hashMap = new HashMap();
        for (long valueOf : jArr) {
            IMUser iMUser = this.f9334d.get(Long.valueOf(valueOf));
            if (iMUser != null && m6346a(iMUser)) {
                hashMap.put(Long.valueOf(iMUser.getUid()), iMUser);
            }
        }
        if (hashMap.size() == jArr.length) {
            if (iMUserInfoCallback != null) {
                iMUserInfoCallback.onUserInfoLoaded(hashMap, jArr);
            }
            if (z) {
                loadUserInfoFromNet(jArr, iMUserInfoCallback);
                return;
            }
            return;
        }
        new IMTaskJob<Void, Void, HashMap<Long, IMUser>>() {
            private boolean isLocalHave = false;

            /* access modifiers changed from: protected */
            public HashMap<Long, IMUser> doInBackground(Void... voidArr) {
                HashMap<Long, IMUser> hashMap = new HashMap<>();
                for (long valueOf : jArr) {
                    IMUserDaoEntity iMUserDaoEntity = (IMUserDaoEntity) IMUserModule.this.f9333c.getUserDao().queryBuilder().where(UserDao.Properties.User_id.mo43479eq(Long.valueOf(valueOf)), new WhereCondition[0]).limit(1).unique();
                    if (iMUserDaoEntity != null) {
                        IMUser iMUser = new IMUser(iMUserDaoEntity);
                        if (IMUserModule.this.m6346a(iMUser)) {
                            IMUser iMUser2 = (IMUser) IMUserModule.this.f9334d.get(Long.valueOf(iMUser.getUid()));
                            if (iMUser2 != null && TextUtils.isEmpty(iMUser.getAvatarUrl())) {
                                iMUser.setAvatarUrl(iMUser2.getAvatarUrl());
                            }
                            hashMap.put(Long.valueOf(iMUser.getUid()), iMUser);
                            IMUserModule.this.f9334d.put(Long.valueOf(iMUser.getUid()), iMUser);
                        }
                    }
                }
                if (!hashMap.isEmpty() && hashMap.size() == jArr.length) {
                    this.isLocalHave = true;
                    return hashMap;
                } else if (!hashMap.isEmpty()) {
                    return hashMap;
                } else {
                    return null;
                }
            }

            /* access modifiers changed from: protected */
            public void onPostExecute(HashMap<Long, IMUser> hashMap) {
                String tag = IMField.getTag(IMUserModule.f9331a);
                StringBuilder sb = new StringBuilder();
                sb.append("onPostExecute: callback from LOCAL [");
                sb.append(hashMap == null ? "null" : hashMap);
                sb.append(Const.jaRight);
                IMLog.m6631d(tag, sb.toString());
                if (IMUserModule.this.f9337g.get((long) i) != null) {
                    ((IMUserInfoCallback) IMUserModule.this.f9337g.get((long) i)).onUserInfoLoaded(hashMap, jArr);
                }
                boolean z = z;
            }
        }.setErrorCallback(getErrorCallback()).execute(new Void[0]);
    }

    public void getUserInfo(long j, IMGroupUserInfoCallback iMGroupUserInfoCallback, boolean z) {
        final long j2 = j;
        final boolean z2 = z;
        final IMGroupUserInfoCallback iMGroupUserInfoCallback2 = iMGroupUserInfoCallback;
        new IMTaskJob<Void, Void, List<IMUser>>() {
            /* access modifiers changed from: protected */
            public List<IMUser> doInBackground(Void... voidArr) {
                List<IMUserDaoEntity> loadAll;
                ArrayList arrayList = new ArrayList();
                UserDao userDao = IMUserModule.this.f9333c.getUserDao(j2);
                if (userDao == null || (loadAll = userDao.loadAll()) == null || loadAll.size() == 0) {
                    return null;
                }
                for (IMUserDaoEntity iMUserDaoEntity : loadAll) {
                    IMUser iMUser = new IMUser(iMUserDaoEntity);
                    if (!z2) {
                        arrayList.add(new IMUser(iMUserDaoEntity));
                    } else if (iMUser.isInGroup()) {
                        IMUser iMUser2 = new IMUser(iMUserDaoEntity);
                        if (!TextUtils.isEmpty(iMUser2.getUserTag())) {
                            arrayList.add(0, iMUser2);
                        } else {
                            arrayList.add(new IMUser(iMUserDaoEntity));
                        }
                    }
                }
                return arrayList;
            }

            /* access modifiers changed from: protected */
            public void onPostExecute(List<IMUser> list) {
                iMGroupUserInfoCallback2.onUserInfoLoaded(list);
            }
        }.execute(new Void[0]);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m6346a(IMUser iMUser) {
        return !TextUtils.isEmpty(iMUser.getNickName());
    }
}
