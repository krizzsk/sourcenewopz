package com.didi.entrega.uni_entrega_business.home;

public interface GLEUniHomePageService {

    public interface Result<T> {
        void success(T t);
    }

    void closeSkeletonPage();

    void contactByCall(String str, String str2);

    void getOrderDataByLocal(String str, String str2, Result<String> result);

    void openSkeletonPage();
}
