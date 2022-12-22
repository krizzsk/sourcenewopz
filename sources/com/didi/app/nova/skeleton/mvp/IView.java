package com.didi.app.nova.skeleton.mvp;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.app.nova.skeleton.RestrictContext;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.mvp.IPresenter;
import com.didi.soda.nova.skeleton.dsl.DslIView;

public abstract class IView<P extends IPresenter> implements RestrictContext, DslIView {
    private Context mContext;
    private P mPresenter;
    View mView;

    /* access modifiers changed from: protected */
    public View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return null;
    }

    /* access modifiers changed from: protected */
    public void onCreate() {
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
    }

    /* access modifiers changed from: protected */
    public void onPause() {
    }

    /* access modifiers changed from: protected */
    public void onResume() {
    }

    /* access modifiers changed from: protected */
    public void onStart() {
    }

    /* access modifiers changed from: protected */
    public void onStop() {
    }

    /* access modifiers changed from: package-private */
    public final void attachPresenter(P p) {
        this.mPresenter = p;
    }

    /* access modifiers changed from: package-private */
    public final void attachContext(Context context) {
        this.mContext = context;
    }

    public final Context getContext() {
        return this.mContext;
    }

    /* access modifiers changed from: protected */
    public final ScopeContext getScopeContext() {
        P p = this.mPresenter;
        if (p != null) {
            return p.getScopeContext();
        }
        throw new IllegalStateException("Presenter not attach to this view of " + getClass().getName());
    }

    public final P getPresenter() {
        return this.mPresenter;
    }

    /* access modifiers changed from: protected */
    public final View getView() {
        return this.mView;
    }

    public Resources getResources() {
        return this.mContext.getResources();
    }

    public AssetManager getAssets() {
        return this.mContext.getAssets();
    }

    public Resources.Theme getTheme() {
        return this.mContext.getTheme();
    }

    public final CharSequence getText(int i) {
        return getResources().getText(i);
    }

    public final String getString(int i) {
        return getResources().getString(i);
    }

    public final String getString(int i, Object... objArr) {
        return getResources().getString(i, objArr);
    }

    public final int getColor(int i) {
        return getResources().getColor(i);
    }

    public final Drawable getDrawable(int i) {
        return getResources().getDrawable(i);
    }
}
