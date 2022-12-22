package com.didi.entrega.router;

public interface IInterceptor {
    boolean intercept(Request request, Response response);
}
