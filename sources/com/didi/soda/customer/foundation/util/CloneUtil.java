package com.didi.soda.customer.foundation.util;

import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.tracker.error.ErrorConst;
import com.didi.soda.customer.foundation.tracker.error.ErrorTracker;
import com.didichuxing.foundation.util.TypeResolver;
import com.google.gson.JsonParseException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public final class CloneUtil {
    private CloneUtil() {
    }

    public static <T> T newInstance(T t) {
        if (t == null) {
            return t;
        }
        try {
            return GsonUtil.fromJson(GsonUtil.toJson(t), TypeResolver.getSuperclassTypeParameter(t.getClass()));
        } catch (JsonParseException e) {
            ErrorTracker.create(ErrorConst.ErrorName.PARSE_EXCEPTIONS).addModuleName("clone").addErrorType(ErrorTracker.getErrorType(e)).addErrorMsg(ErrorTracker.getExceptionMsg(e)).build().trackError();
            e.printStackTrace();
            return t;
        } catch (IllegalArgumentException unused) {
            return GsonUtil.fromJson(GsonUtil.toJson(t), t.getClass());
        }
    }

    public static Object deepClone(Object obj) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            new ObjectOutputStream(byteArrayOutputStream).writeObject(obj);
            return new ObjectInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray())).readObject();
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("deepClone error: ");
            sb.append(obj == null ? "null" : obj.toString());
            LogUtil.m29100d("CloneUtil", sb.toString());
            e.printStackTrace();
            return null;
        }
    }
}
