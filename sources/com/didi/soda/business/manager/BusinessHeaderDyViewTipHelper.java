package com.didi.soda.business.manager;

import android.text.TextUtils;
import com.didi.soda.business.widget.BusinessDyHomeHeaderView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0012\u001a\u00020\u0013J\u0010\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u0010\u0010\u0017\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u000e\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001a"}, mo175978d2 = {"Lcom/didi/soda/business/manager/BusinessHeaderDyViewTipHelper;", "", "businessHomeHeaderView", "Lcom/didi/soda/business/widget/BusinessDyHomeHeaderView;", "(Lcom/didi/soda/business/widget/BusinessDyHomeHeaderView;)V", "getBusinessHomeHeaderView", "()Lcom/didi/soda/business/widget/BusinessDyHomeHeaderView;", "isTouchNow", "", "()Z", "setTouchNow", "(Z)V", "visable", "", "getVisable", "()I", "setVisable", "(I)V", "hideHeadTip", "", "setCurrentTipVisable", "content", "", "showCurrentTipNotNullOrEmpty", "showHeadTip", "txt", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BusinessHeaderDyViewTipHelper.kt */
public final class BusinessHeaderDyViewTipHelper {

    /* renamed from: a */
    private final BusinessDyHomeHeaderView f39687a;

    /* renamed from: b */
    private int f39688b = 4;

    /* renamed from: c */
    private boolean f39689c;

    public final void hideHeadTip() {
    }

    public final void showHeadTip(String str) {
        Intrinsics.checkNotNullParameter(str, "txt");
    }

    public BusinessHeaderDyViewTipHelper(BusinessDyHomeHeaderView businessDyHomeHeaderView) {
        Intrinsics.checkNotNullParameter(businessDyHomeHeaderView, "businessHomeHeaderView");
        this.f39687a = businessDyHomeHeaderView;
    }

    public final BusinessDyHomeHeaderView getBusinessHomeHeaderView() {
        return this.f39687a;
    }

    public final int getVisable() {
        return this.f39688b;
    }

    public final void setVisable(int i) {
        this.f39688b = i;
    }

    public final boolean isTouchNow() {
        return this.f39689c;
    }

    public final void setTouchNow(boolean z) {
        this.f39689c = z;
    }

    public final void setCurrentTipVisable(String str) {
        CharSequence charSequence = str;
        int i = 0;
        if (charSequence == null || charSequence.length() == 0) {
            i = 4;
        }
        this.f39688b = i;
        if (!this.f39689c) {
            showCurrentTipNotNullOrEmpty(str);
        }
    }

    public final void showCurrentTipNotNullOrEmpty(String str) {
        if (this.f39688b == 4 || TextUtils.isEmpty(str)) {
            hideHeadTip();
            return;
        }
        if (str == null) {
            str = "";
        }
        showHeadTip(str);
    }
}
