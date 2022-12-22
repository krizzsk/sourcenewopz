package com.jumio.core.model;

public interface SubscriberWithUpdate<Update, Result> extends Subscriber<Result> {
    /* synthetic */ void onError(Throwable th);

    /* synthetic */ void onResult(Result result);

    void onUpdate(Update update);
}
