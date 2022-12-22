package com.didichuxing.apollo.sdk.dataprovider;

import com.didichuxing.apollo.sdk.net.RequestHandler;

public interface IDataProvider<T> {

    public interface IGetCallback<T> {
        void onFail();

        void onGetData(T t);
    }

    public interface IUpdateCallback<T> {
        void onFail();

        void onNoChange();

        void onUpdate(T t);
    }

    void getData(IGetCallback<T> iGetCallback);

    String getFullAppVersionWhenCached();

    void setmRequestHandler(RequestHandler requestHandler);

    void update(IUpdateCallback<T> iUpdateCallback);
}
