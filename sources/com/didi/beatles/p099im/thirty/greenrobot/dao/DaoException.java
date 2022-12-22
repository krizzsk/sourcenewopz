package com.didi.beatles.p099im.thirty.greenrobot.dao;

import android.database.SQLException;

/* renamed from: com.didi.beatles.im.thirty.greenrobot.dao.DaoException */
public class DaoException extends SQLException {
    private static final long serialVersionUID = -5877937327907457779L;

    public DaoException() {
    }

    public DaoException(String str) {
        super(str);
    }

    public DaoException(String str, Throwable th) {
        super(str);
        safeInitCause(th);
    }

    public DaoException(Throwable th) {
        safeInitCause(th);
    }

    /* access modifiers changed from: protected */
    public void safeInitCause(Throwable th) {
        try {
            initCause(th);
        } catch (Throwable th2) {
            DaoLog.m6527e("Could not set initial cause", th2);
            DaoLog.m6527e("Initial cause is:", th);
        }
    }
}
