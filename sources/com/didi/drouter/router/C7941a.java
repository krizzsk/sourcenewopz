package com.didi.drouter.router;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import androidx.collection.ArrayMap;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

/* renamed from: com.didi.drouter.router.a */
/* compiled from: DataExtras */
class C7941a<T> {

    /* renamed from: a */
    private final T f19197a = this;
    public Map<String, Object> addition = new ArrayMap();
    public Bundle extra = new Bundle();

    public Bundle getExtra() {
        return this.extra;
    }

    public Map<String, Object> getAddition() {
        return this.addition;
    }

    public T putExtra(String str, String str2) {
        this.extra.putString(str, str2);
        return this.f19197a;
    }

    public T putExtra(String str, boolean z) {
        this.extra.putBoolean(str, z);
        return this.f19197a;
    }

    public T putExtra(String str, byte b) {
        this.extra.putByte(str, b);
        return this.f19197a;
    }

    public T putExtra(String str, char c) {
        this.extra.putChar(str, c);
        return this.f19197a;
    }

    public T putExtra(String str, short s) {
        this.extra.putShort(str, s);
        return this.f19197a;
    }

    public T putExtra(String str, int i) {
        this.extra.putInt(str, i);
        return this.f19197a;
    }

    public T putExtra(String str, long j) {
        this.extra.putLong(str, j);
        return this.f19197a;
    }

    public T putExtra(String str, float f) {
        this.extra.putFloat(str, f);
        return this.f19197a;
    }

    public T putExtra(String str, double d) {
        this.extra.putDouble(str, d);
        return this.f19197a;
    }

    public T putExtra(String str, CharSequence charSequence) {
        this.extra.putCharSequence(str, charSequence);
        return this.f19197a;
    }

    public T putExtra(String str, Parcelable parcelable) {
        this.extra.putParcelable(str, parcelable);
        return this.f19197a;
    }

    public T putExtra(String str, Serializable serializable) {
        this.extra.putSerializable(str, serializable);
        return this.f19197a;
    }

    public T putExtra(String str, String[] strArr) {
        this.extra.putStringArray(str, strArr);
        return this.f19197a;
    }

    public T putExtra(String str, boolean[] zArr) {
        this.extra.putBooleanArray(str, zArr);
        return this.f19197a;
    }

    public T putExtra(String str, byte[] bArr) {
        this.extra.putByteArray(str, bArr);
        return this.f19197a;
    }

    public T putExtra(String str, char[] cArr) {
        this.extra.putCharArray(str, cArr);
        return this.f19197a;
    }

    public T putExtra(String str, short[] sArr) {
        this.extra.putShortArray(str, sArr);
        return this.f19197a;
    }

    public T putExtra(String str, int[] iArr) {
        this.extra.putIntArray(str, iArr);
        return this.f19197a;
    }

    public T putExtra(String str, long[] jArr) {
        this.extra.putLongArray(str, jArr);
        return this.f19197a;
    }

    public T putExtra(String str, float[] fArr) {
        this.extra.putFloatArray(str, fArr);
        return this.f19197a;
    }

    public T putExtra(String str, double[] dArr) {
        this.extra.putDoubleArray(str, dArr);
        return this.f19197a;
    }

    public T putExtra(String str, CharSequence[] charSequenceArr) {
        this.extra.putCharSequenceArray(str, charSequenceArr);
        return this.f19197a;
    }

    public T putExtra(String str, Parcelable[] parcelableArr) {
        this.extra.putParcelableArray(str, parcelableArr);
        return this.f19197a;
    }

    public T putExtra(String str, Bundle bundle) {
        this.extra.putBundle(str, bundle);
        return this.f19197a;
    }

    public T putParcelableArrayList(String str, ArrayList<? extends Parcelable> arrayList) {
        this.extra.putParcelableArrayList(str, arrayList);
        return this.f19197a;
    }

    public T putIntegerArrayList(String str, ArrayList<Integer> arrayList) {
        this.extra.putIntegerArrayList(str, arrayList);
        return this.f19197a;
    }

    public T putStringArrayList(String str, ArrayList<String> arrayList) {
        this.extra.putStringArrayList(str, arrayList);
        return this.f19197a;
    }

    public T putCharSequenceArrayList(String str, ArrayList<CharSequence> arrayList) {
        this.extra.putCharSequenceArrayList(str, arrayList);
        return this.f19197a;
    }

    public T putParcelableSparseArray(String str, SparseArray<? extends Parcelable> sparseArray) {
        this.extra.putSparseParcelableArray(str, sparseArray);
        return this.f19197a;
    }

    public T putExtras(Bundle bundle) {
        this.extra.putAll(bundle);
        return this.f19197a;
    }

    public boolean getBoolean(String str) {
        return this.extra.getBoolean(str);
    }

    public Byte getByte(String str) {
        return Byte.valueOf(this.extra.getByte(str));
    }

    public char getChar(String str) {
        return this.extra.getChar(str);
    }

    public short getShort(String str) {
        return this.extra.getShort(str);
    }

    public int getInt(String str) {
        return this.extra.getInt(str);
    }

    public long getLong(String str) {
        return this.extra.getLong(str);
    }

    public float getFloat(String str) {
        return this.extra.getFloat(str);
    }

    public double getDouble(String str) {
        return this.extra.getDouble(str);
    }

    public String getString(String str) {
        return this.extra.getString(str);
    }

    public Bundle getBundle(String str) {
        return this.extra.getBundle(str);
    }

    public CharSequence getCharSequence(String str) {
        return this.extra.getCharSequence(str);
    }

    public <M extends Parcelable> M getParcelable(String str) {
        return this.extra.getParcelable(str);
    }

    public Serializable getSerializable(String str) {
        return this.extra.getSerializable(str);
    }

    public String[] getStringArray(String str) {
        return this.extra.getStringArray(str);
    }

    public boolean[] getBooleanArray(String str) {
        return this.extra.getBooleanArray(str);
    }

    public short[] getShortArray(String str) {
        return this.extra.getShortArray(str);
    }

    public int[] getIntArray(String str) {
        return this.extra.getIntArray(str);
    }

    public long[] getLongArray(String str) {
        return this.extra.getLongArray(str);
    }

    public byte[] getByteArray(String str) {
        return this.extra.getByteArray(str);
    }

    public char[] getCharArray(String str) {
        return this.extra.getCharArray(str);
    }

    public float[] getFloatArray(String str) {
        return this.extra.getFloatArray(str);
    }

    public double[] getDoubleArray(String str) {
        return this.extra.getDoubleArray(str);
    }

    public CharSequence[] getCharSequenceArray(String str) {
        return this.extra.getCharSequenceArray(str);
    }

    public Parcelable[] getParcelableArray(String str) {
        return this.extra.getParcelableArray(str);
    }

    public <M extends Parcelable> ArrayList<M> getParcelableArrayList(String str) {
        return this.extra.getParcelableArrayList(str);
    }

    public ArrayList<Integer> getIntegerArrayList(String str) {
        return this.extra.getIntegerArrayList(str);
    }

    public ArrayList<String> getStringArrayList(String str) {
        return this.extra.getStringArrayList(str);
    }

    public ArrayList<CharSequence> getCharSequenceArrayList(String str) {
        return this.extra.getCharSequenceArrayList(str);
    }

    public <M extends Parcelable> SparseArray<M> getSparseParcelableArray(String str) {
        return this.extra.getSparseParcelableArray(str);
    }

    public T putAddition(String str, Object obj) {
        this.addition.put(str, obj);
        return this.f19197a;
    }

    public Object getAddition(String str) {
        return this.addition.get(str);
    }
}
