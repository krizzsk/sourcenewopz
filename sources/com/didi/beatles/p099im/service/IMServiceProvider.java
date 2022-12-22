package com.didi.beatles.p099im.service;

import android.content.Context;
import com.didi.beatles.p099im.IMContextInfoHelper;

/* renamed from: com.didi.beatles.im.service.IMServiceProvider */
public class IMServiceProvider {

    /* renamed from: f */
    private static IMServiceProvider f9594f;

    /* renamed from: a */
    private IMDownloadManager f9595a;

    /* renamed from: b */
    private IMConfigManager f9596b;

    /* renamed from: c */
    private IMFileManager f9597c;

    /* renamed from: d */
    private IMDaoManager f9598d;

    /* renamed from: e */
    private Context f9599e;

    public static IMServiceProvider getInstance() {
        if (f9594f == null) {
            f9594f = new IMServiceProvider();
        }
        return f9594f;
    }

    public IMServiceProvider init() {
        this.f9599e = IMContextInfoHelper.getContext();
        this.f9597c = new IMFileManager(this);
        this.f9595a = new IMDownloadManager(this);
        if (this.f9598d == null) {
            this.f9598d = new IMDaoManager(this);
        }
        if (this.f9596b == null) {
            this.f9596b = new IMConfigManager(this);
        }
        this.f9596b.init(IMContextInfoHelper.getInfoProvider());
        return this;
    }

    public void destroy() {
        IMDaoManager iMDaoManager = this.f9598d;
        if (iMDaoManager != null) {
            iMDaoManager.close();
            this.f9598d = null;
        }
        if (this.f9596b != null) {
            this.f9596b = null;
        }
    }

    private IMServiceProvider() {
    }

    public Context getContext() {
        return this.f9599e;
    }

    public IMDownloadManager getDownloadManager() {
        return this.f9595a;
    }

    public IMConfigManager getConfigManager() {
        return this.f9596b;
    }

    public IMFileManager getFileManager() {
        return this.f9597c;
    }

    public IMDaoManager getDaoManager() {
        return this.f9598d;
    }
}
