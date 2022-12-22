package com.koushikdutta.async.future;

public interface TypeConverter<T, F> {
    Future<T> convert(F f, String str) throws Exception;
}
