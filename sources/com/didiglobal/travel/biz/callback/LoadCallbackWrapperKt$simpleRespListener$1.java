package com.didiglobal.travel.biz.callback;

import com.didi.raven.config.RavenKey;
import com.didi.travel.psnger.common.net.base.ResponseListener;
import com.didiglobal.travel.biz.net.ApiCallException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0017\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010\u0005J\u0017\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010\u0005J\u0017\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010\u0005J\u0015\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0005¨\u0006\t"}, mo175978d2 = {"com/didiglobal/travel/biz/callback/LoadCallbackWrapperKt$simpleRespListener$1", "Lcom/didi/travel/psnger/common/net/base/ResponseListener;", "onError", "", "t", "(Lcom/didi/travel/psnger/common/net/base/BaseObject;)V", "onFail", "onFinish", "onSuccess", "common_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: LoadCallbackWrapper.kt */
public final class LoadCallbackWrapperKt$simpleRespListener$1 extends ResponseListener<T> {
    final /* synthetic */ LoadCallbackWrapper<T> $this_simpleRespListener;

    LoadCallbackWrapperKt$simpleRespListener$1(LoadCallbackWrapper<T> loadCallbackWrapper) {
        this.$this_simpleRespListener = loadCallbackWrapper;
    }

    public void onSuccess(T t) {
        Intrinsics.checkNotNullParameter(t, RavenKey.TYPE);
        super.onSuccess(t);
        Function1<T, Unit> onSuccessAction = this.$this_simpleRespListener.getOnSuccessAction();
        if (onSuccessAction != null) {
            onSuccessAction.invoke(t);
        }
    }

    public void onError(T t) {
        super.onError(t);
        Function2<T, Throwable, Unit> onErrorAction = this.$this_simpleRespListener.getOnErrorAction();
        if (onErrorAction != null) {
            int errorCode = t == null ? -800 : t.getErrorCode();
            Throwable th = null;
            String errorMsg = t == null ? null : t.getErrorMsg();
            if (errorMsg == null) {
                errorMsg = "";
            }
            if (t != null) {
                th = t.getThrowable();
            }
            onErrorAction.invoke(t, new ApiCallException(errorCode, errorMsg, th));
        }
    }

    public void onFail(T t) {
        super.onFail(t);
        Function2<T, Throwable, Unit> onErrorAction = this.$this_simpleRespListener.getOnErrorAction();
        if (onErrorAction != null) {
            int errorCode = t == null ? -900 : t.getErrorCode();
            Throwable th = null;
            String errorMsg = t == null ? null : t.getErrorMsg();
            if (errorMsg == null) {
                errorMsg = "";
            }
            if (t != null) {
                th = t.getThrowable();
            }
            onErrorAction.invoke(t, new ApiCallException(errorCode, errorMsg, th));
        }
    }

    public void onFinish(T t) {
        super.onFinish(t);
        Function0<Unit> onFinishAction = this.$this_simpleRespListener.getOnFinishAction();
        if (onFinishAction != null) {
            onFinishAction.invoke();
        }
    }
}
