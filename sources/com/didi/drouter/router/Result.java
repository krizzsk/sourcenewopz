package com.didi.drouter.router;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.didi.drouter.store.RouterMeta;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

public class Result extends C7941a<Result> {

    /* renamed from: a */
    C7943c f19188a;

    /* renamed from: b */
    Class<?> f19189b;

    /* renamed from: c */
    boolean f19190c;

    /* renamed from: d */
    Fragment f19191d;

    /* renamed from: e */
    View f19192e;

    /* renamed from: f */
    private final int f19193f;

    public /* bridge */ /* synthetic */ Object getAddition(String str) {
        return super.getAddition(str);
    }

    public /* bridge */ /* synthetic */ Map getAddition() {
        return super.getAddition();
    }

    public /* bridge */ /* synthetic */ boolean getBoolean(String str) {
        return super.getBoolean(str);
    }

    public /* bridge */ /* synthetic */ boolean[] getBooleanArray(String str) {
        return super.getBooleanArray(str);
    }

    public /* bridge */ /* synthetic */ Bundle getBundle(String str) {
        return super.getBundle(str);
    }

    public /* bridge */ /* synthetic */ Byte getByte(String str) {
        return super.getByte(str);
    }

    public /* bridge */ /* synthetic */ byte[] getByteArray(String str) {
        return super.getByteArray(str);
    }

    public /* bridge */ /* synthetic */ char getChar(String str) {
        return super.getChar(str);
    }

    public /* bridge */ /* synthetic */ char[] getCharArray(String str) {
        return super.getCharArray(str);
    }

    public /* bridge */ /* synthetic */ CharSequence getCharSequence(String str) {
        return super.getCharSequence(str);
    }

    public /* bridge */ /* synthetic */ CharSequence[] getCharSequenceArray(String str) {
        return super.getCharSequenceArray(str);
    }

    public /* bridge */ /* synthetic */ ArrayList getCharSequenceArrayList(String str) {
        return super.getCharSequenceArrayList(str);
    }

    public /* bridge */ /* synthetic */ double getDouble(String str) {
        return super.getDouble(str);
    }

    public /* bridge */ /* synthetic */ double[] getDoubleArray(String str) {
        return super.getDoubleArray(str);
    }

    public /* bridge */ /* synthetic */ Bundle getExtra() {
        return super.getExtra();
    }

    public /* bridge */ /* synthetic */ float getFloat(String str) {
        return super.getFloat(str);
    }

    public /* bridge */ /* synthetic */ float[] getFloatArray(String str) {
        return super.getFloatArray(str);
    }

    public /* bridge */ /* synthetic */ int getInt(String str) {
        return super.getInt(str);
    }

    public /* bridge */ /* synthetic */ int[] getIntArray(String str) {
        return super.getIntArray(str);
    }

    public /* bridge */ /* synthetic */ ArrayList getIntegerArrayList(String str) {
        return super.getIntegerArrayList(str);
    }

    public /* bridge */ /* synthetic */ long getLong(String str) {
        return super.getLong(str);
    }

    public /* bridge */ /* synthetic */ long[] getLongArray(String str) {
        return super.getLongArray(str);
    }

    public /* bridge */ /* synthetic */ Parcelable getParcelable(String str) {
        return super.getParcelable(str);
    }

    public /* bridge */ /* synthetic */ Parcelable[] getParcelableArray(String str) {
        return super.getParcelableArray(str);
    }

    public /* bridge */ /* synthetic */ ArrayList getParcelableArrayList(String str) {
        return super.getParcelableArrayList(str);
    }

    public /* bridge */ /* synthetic */ Serializable getSerializable(String str) {
        return super.getSerializable(str);
    }

    public /* bridge */ /* synthetic */ short getShort(String str) {
        return super.getShort(str);
    }

    public /* bridge */ /* synthetic */ short[] getShortArray(String str) {
        return super.getShortArray(str);
    }

    public /* bridge */ /* synthetic */ SparseArray getSparseParcelableArray(String str) {
        return super.getSparseParcelableArray(str);
    }

    public /* bridge */ /* synthetic */ String getString(String str) {
        return super.getString(str);
    }

    public /* bridge */ /* synthetic */ String[] getStringArray(String str) {
        return super.getStringArray(str);
    }

    public /* bridge */ /* synthetic */ ArrayList getStringArrayList(String str) {
        return super.getStringArrayList(str);
    }

    Result(Request request, Map<Request, RouterMeta> map, RouterCallback routerCallback) {
        this.f19188a = new C7943c(request, map, this, routerCallback);
        this.f19193f = map != null ? map.size() : 0;
    }

    public Request getRequest() {
        return this.f19188a.f19210k;
    }

    public Class<?> getTargetClass() {
        return this.f19189b;
    }

    public boolean isActivityStarted() {
        return this.f19190c;
    }

    public Fragment getFragment() {
        return this.f19191d;
    }

    public void setFragment(Fragment fragment) {
        this.f19191d = fragment;
    }

    public View getView() {
        return this.f19192e;
    }

    public void setView(View view) {
        this.f19192e = view;
    }

    public int getRouterSize() {
        return this.f19193f;
    }
}
