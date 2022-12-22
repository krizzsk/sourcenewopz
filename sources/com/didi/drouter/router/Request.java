package com.didi.drouter.router;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import androidx.lifecycle.LifecycleOwner;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.api.Extend;
import com.didi.drouter.router.InterceptorHandler;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Request extends C7941a<Request> {

    /* renamed from: i */
    private static final AtomicInteger f19178i = new AtomicInteger(0);

    /* renamed from: a */
    Context f19179a;

    /* renamed from: b */
    LifecycleOwner f19180b;

    /* renamed from: c */
    String f19181c;

    /* renamed from: d */
    int f19182d;

    /* renamed from: e */
    int f19183e;

    /* renamed from: f */
    long f19184f;

    /* renamed from: g */
    String f19185g = String.valueOf(f19178i.getAndIncrement());

    /* renamed from: h */
    IInterceptor f19186h;

    /* renamed from: j */
    private Uri f19187j;

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

    private Request(Uri uri) {
        this.f19187j = uri;
        putExtra(Extend.REQUEST_BUILD_URI, uri.toString());
    }

    public static Request build(String str) {
        return new Request(str == null ? Uri.EMPTY : Uri.parse(str));
    }

    public void rebuild(String str, Bundle... bundleArr) {
        this.f19187j = str == null ? Uri.EMPTY : Uri.parse(str);
        Bundle bundle = new Bundle();
        if (bundleArr != null && bundleArr.length > 0) {
            for (Bundle putAll : bundleArr) {
                bundle.putAll(putAll);
            }
        }
        this.extra.clear();
        this.extra.putAll(bundle);
        this.extra.putString(Extend.REQUEST_BUILD_URI, this.f19187j.toString());
    }

    public void start() {
        start((Context) null, (RouterCallback) null);
    }

    public void start(Context context) {
        start(context, (RouterCallback) null);
    }

    public void start(Context context, RouterCallback routerCallback) {
        if (context == null) {
            context = DRouter.getContext();
        }
        this.f19179a = context;
        RouterLoader.m14358a(this, routerCallback).mo58874a();
    }

    public Context getContext() {
        return this.f19179a;
    }

    public Uri getUri() {
        return this.f19187j;
    }

    public int getRouterType() {
        return this.f19182d;
    }

    public String getNumber() {
        return this.f19185g;
    }

    public Request setHoldTimeout(long j) {
        this.f19184f = j;
        return this;
    }

    public Request setRemoteAuthority(String str) {
        this.f19181c = str;
        return this;
    }

    public Request setRemoteDeadResend(int i) {
        this.f19183e = i;
        return this;
    }

    public Request setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        this.f19180b = lifecycleOwner;
        return this;
    }

    public IInterceptor getInterceptor() {
        IInterceptor iInterceptor = this.f19186h;
        return iInterceptor == null ? new InterceptorHandler.Default() : iInterceptor;
    }
}
