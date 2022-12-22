package com.didi.drouter.utils;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ConvertUtils {
    public static Bundle map2Bundle(Map<String, Object> map) {
        Bundle bundle = new Bundle();
        if (map == null) {
            return bundle;
        }
        for (Map.Entry next : map.entrySet()) {
            putObject(bundle, (String) next.getKey(), next.getValue());
        }
        return bundle;
    }

    public static Map<String, Object> bundle2map(Bundle bundle) {
        HashMap hashMap = new HashMap();
        if (bundle == null) {
            return hashMap;
        }
        for (String str : bundle.keySet()) {
            hashMap.put(str, bundle.get(str));
        }
        return hashMap;
    }

    public static void putObject(Bundle bundle, String str, Object obj) {
        if (obj == null) {
            bundle.putString(str, (String) null);
        } else if (obj instanceof Bundle) {
            bundle.putBundle(str, (Bundle) obj);
        } else if (obj instanceof Boolean) {
            bundle.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof Integer) {
            bundle.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof Long) {
            bundle.putLong(str, ((Long) obj).longValue());
        } else if (obj instanceof Double) {
            bundle.putDouble(str, ((Double) obj).doubleValue());
        } else if (obj instanceof String) {
            bundle.putString(str, (String) obj);
        } else if (obj instanceof Byte) {
            bundle.putByte(str, ((Byte) obj).byteValue());
        } else if (obj instanceof Character) {
            bundle.putChar(str, ((Character) obj).charValue());
        } else if (obj instanceof Short) {
            bundle.putShort(str, ((Short) obj).shortValue());
        } else if (obj instanceof Float) {
            bundle.putFloat(str, ((Float) obj).floatValue());
        } else if (obj instanceof CharSequence) {
            bundle.putCharSequence(str, (CharSequence) obj);
        } else if (obj instanceof boolean[]) {
            bundle.putBooleanArray(str, (boolean[]) obj);
        } else if (obj instanceof int[]) {
            bundle.putIntArray(str, (int[]) obj);
        } else if (obj instanceof long[]) {
            bundle.putLongArray(str, (long[]) obj);
        } else if (obj instanceof double[]) {
            bundle.putDoubleArray(str, (double[]) obj);
        } else if (obj instanceof byte[]) {
            bundle.putByteArray(str, (byte[]) obj);
        } else if (obj instanceof short[]) {
            bundle.putShortArray(str, (short[]) obj);
        } else if (obj instanceof char[]) {
            bundle.putCharArray(str, (char[]) obj);
        } else if (obj instanceof float[]) {
            bundle.putFloatArray(str, (float[]) obj);
        } else if (obj instanceof String[]) {
            bundle.putStringArray(str, (String[]) obj);
        } else if (obj instanceof CharSequence[]) {
            bundle.putCharSequenceArray(str, (CharSequence[]) obj);
        } else if (obj instanceof Parcelable) {
            bundle.putParcelable(str, (Parcelable) obj);
        } else if (obj instanceof Parcelable[]) {
            bundle.putParcelableArray(str, (Parcelable[]) obj);
        } else if (obj instanceof ArrayList) {
            bundle.putParcelableArrayList(str, (ArrayList) obj);
        } else if (obj instanceof SparseArray) {
            bundle.putSparseParcelableArray(str, (SparseArray) obj);
        } else if (obj instanceof Serializable) {
            bundle.putSerializable(str, (Serializable) obj);
        }
    }
}
