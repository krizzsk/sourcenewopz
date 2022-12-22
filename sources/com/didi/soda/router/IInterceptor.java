package com.didi.soda.router;

public interface IInterceptor {
    boolean intercept(Request request, Response response);
}
