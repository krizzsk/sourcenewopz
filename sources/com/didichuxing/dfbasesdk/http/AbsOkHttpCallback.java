package com.didichuxing.dfbasesdk.http;

import com.didichuxing.dfbasesdk.data.BaseInnerResult;
import com.didichuxing.dfbasesdk.data.NewBaseResult;
import com.didichuxing.dfbasesdk.utils.GsonUtils;
import com.didichuxing.dfbasesdk.utils.UIHandler;
import didihttp.Call;
import didihttp.Callback;
import didihttp.Response;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class AbsOkHttpCallback<T extends BaseInnerResult> implements Callback {
    private static final int CODE_BIZ_SUCCESS = 100000;
    private static final int CODE_GATEWAY_SUCCESS = 200;

    public abstract void onFailed(int i, String str);

    public abstract void onSuccess(T t);

    public void onFailure(Call call, final IOException iOException) {
        UIHandler.post(new Runnable() {
            public void run() {
                AbsOkHttpCallback.this.onFailed(1, iOException.getMessage());
            }
        });
    }

    public void onBizFailed(int i, String str) {
        onFailed(i, str);
    }

    public Type getResultType() {
        return ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public void onResponse(Call call, Response response) throws IOException {
        if (response.isSuccessful()) {
            final NewBaseResult newBaseResult = (NewBaseResult) GsonUtils.parseSafely(response.body().string(), getRealType(NewBaseResult.class, getResultType()));
            UIHandler.post(new Runnable() {
                public void run() {
                    NewBaseResult newBaseResult = newBaseResult;
                    if (newBaseResult == null || newBaseResult.apiCode != 200 || newBaseResult.data == null) {
                        AbsOkHttpCallback.this.onFailed(newBaseResult == null ? 4 : 2, "server error");
                    } else if (newBaseResult.data.code == 100000) {
                        AbsOkHttpCallback.this.onSuccess((BaseInnerResult) newBaseResult.data.result);
                    } else {
                        AbsOkHttpCallback.this.onBizFailed(newBaseResult.data.code, newBaseResult.data.message);
                    }
                }
            });
            return;
        }
        UIHandler.post(new Runnable() {
            public void run() {
                AbsOkHttpCallback.this.onFailed(2, "server error");
            }
        });
    }

    private Type getRealType(final Class<?> cls, final Type type) {
        return new ParameterizedType() {
            public Type getOwnerType() {
                return null;
            }

            public Type[] getActualTypeArguments() {
                return new Type[]{type};
            }

            public Type getRawType() {
                return cls;
            }
        };
    }
}
