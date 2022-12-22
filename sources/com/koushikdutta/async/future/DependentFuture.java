package com.koushikdutta.async.future;

public interface DependentFuture<T> extends DependentCancellable, Future<T> {
}
