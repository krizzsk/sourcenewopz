package com.didi.beatles.p099im.thirty.greenrobot.dao.async;

import com.didi.beatles.p099im.thirty.greenrobot.dao.DaoException;

/* renamed from: com.didi.beatles.im.thirty.greenrobot.dao.async.AsyncDaoException */
public class AsyncDaoException extends DaoException {
    private static final long serialVersionUID = 5872157552005102382L;
    private final AsyncOperation failedOperation;

    public AsyncDaoException(AsyncOperation asyncOperation, Throwable th) {
        super(th);
        this.failedOperation = asyncOperation;
    }

    public AsyncOperation getFailedOperation() {
        return this.failedOperation;
    }
}
