package com.didi.beatles.p099im.service;

import com.didi.beatles.p099im.IMContextInfoHelper;
import com.didi.beatles.p099im.module.impl.IMModelProvider;
import com.didi.beatles.p099im.omega.IMTraceError;
import com.didi.beatles.p099im.p100db.dao.DaoMaster;
import com.didi.beatles.p099im.p100db.dao.DaoSession;
import com.didi.beatles.p099im.service.dao.IMDaoCipherInit;
import com.didi.beatles.p099im.service.dao.IMDaoInit;
import com.didi.beatles.p099im.service.dao.IMDaoInitTrace;
import com.didi.beatles.p099im.service.dao.IMDaoOldInit;
import com.didi.beatles.p099im.utils.IMLog;

/* renamed from: com.didi.beatles.im.service.IMDaoManager */
public class IMDaoManager extends IMBaseProvider {
    public static final String TAG = "IMInit";

    /* renamed from: a */
    private boolean f9588a = false;

    /* renamed from: b */
    private DaoSession f9589b;

    /* renamed from: c */
    private DaoMaster.DevOpenHelper f9590c;

    protected IMDaoManager(IMServiceProvider iMServiceProvider) {
        super(iMServiceProvider);
    }

    public void close() {
        DaoSession daoSession = this.f9589b;
        if (daoSession != null) {
            daoSession.clear();
        }
        IMModelProvider.getInstance().destroy();
        DaoMaster.DevOpenHelper devOpenHelper = this.f9590c;
        if (devOpenHelper != null) {
            devOpenHelper.close();
            this.f9590c = null;
        }
    }

    /* access modifiers changed from: protected */
    public void init(long j) {
        IMDaoInit iMDaoInit;
        if (j > 0) {
            IMLog.m6635i("IMInit", "init DB start");
            close();
            IMDaoInitTrace.Builder builder = new IMDaoInitTrace.Builder();
            boolean isMoveCipher = IMContextInfoHelper.isMoveCipher();
            if (isMoveCipher) {
                builder.addApollo(IMDaoInitTrace.APOLLO_ENCRYPT);
                iMDaoInit = new IMDaoCipherInit(this.mContext, builder);
            } else {
                builder.addApollo("txt");
                iMDaoInit = new IMDaoOldInit(this.mContext, builder);
            }
            try {
                iMDaoInit.init(j);
                iMDaoInit.end();
                builder.report();
                IMLog.m6635i("IMInit", "init DB log " + builder.log());
                this.f9590c = iMDaoInit.getOpenHelper();
                this.f9589b = new DaoMaster(iMDaoInit.getInitDatabase()).newSession();
                this.f9588a = true;
                IMLog.m6635i("IMInit", "init DB end");
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("im_dao_init_");
                sb.append(isMoveCipher ? "cipher" : "text");
                IMTraceError.trackError(sb.toString(), e);
                throw new IllegalStateException(e);
            } catch (Throwable th) {
                iMDaoInit.end();
                builder.report();
                throw th;
            }
        } else {
            IMLog.m6632e("IMInit", "loginID is " + j + " init() DB exception!");
            throw new IllegalArgumentException("init() DB exception!,uid = " + j);
        }
    }

    public DaoSession getDaoSession() {
        m6487a();
        return this.f9589b;
    }

    /* renamed from: a */
    private void m6487a() {
        if (!this.f9588a) {
            IMLog.m6632e("IMInit", "isInit not success or start,cause by mOpenHelper is null");
            throw new IllegalArgumentException(" isInit not success or start,cause by mOpenHelper is null");
        }
    }
}
