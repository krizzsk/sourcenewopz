package com.didi.soda.customer.widget.abnormal;

import android.view.View;
import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u0000 (2\u00020\u0001:\u0002'(B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\r\"\u0004\b\u001e\u0010\u000fR\u001a\u0010\u001f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010$\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\r\"\u0004\b&\u0010\u000f¨\u0006)"}, mo175978d2 = {"Lcom/didi/soda/customer/widget/abnormal/ActivityAbnormalViewModel;", "Lcom/didi/app/nova/support/view/recyclerview/binder/RecyclerModel;", "()V", "actStatus", "", "getActStatus", "()Ljava/lang/Integer;", "setActStatus", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "bgColor", "", "getBgColor", "()Ljava/lang/String;", "setBgColor", "(Ljava/lang/String;)V", "button", "getButton", "setButton", "clickListener", "Landroid/view/View$OnClickListener;", "getClickListener", "()Landroid/view/View$OnClickListener;", "setClickListener", "(Landroid/view/View$OnClickListener;)V", "desc", "getDesc", "setDesc", "detail", "getDetail", "setDetail", "height", "getHeight", "()I", "setHeight", "(I)V", "imageUrl", "getImageUrl", "setImageUrl", "Builder", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ActivityAbnormalViewModel.kt */
public final class ActivityAbnormalViewModel implements RecyclerModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private String f41618a;

    /* renamed from: b */
    private Integer f41619b;

    /* renamed from: c */
    private String f41620c;

    /* renamed from: d */
    private String f41621d;

    /* renamed from: e */
    private View.OnClickListener f41622e;

    /* renamed from: f */
    private String f41623f;

    /* renamed from: g */
    private int f41624g;

    /* renamed from: h */
    private String f41625h;

    public /* synthetic */ ActivityAbnormalViewModel(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private ActivityAbnormalViewModel() {
    }

    public final String getDesc() {
        return this.f41618a;
    }

    public final void setDesc(String str) {
        this.f41618a = str;
    }

    public final Integer getActStatus() {
        return this.f41619b;
    }

    public final void setActStatus(Integer num) {
        this.f41619b = num;
    }

    public final String getImageUrl() {
        return this.f41620c;
    }

    public final void setImageUrl(String str) {
        this.f41620c = str;
    }

    public final String getButton() {
        return this.f41621d;
    }

    public final void setButton(String str) {
        this.f41621d = str;
    }

    public final View.OnClickListener getClickListener() {
        return this.f41622e;
    }

    public final void setClickListener(View.OnClickListener onClickListener) {
        this.f41622e = onClickListener;
    }

    public final String getBgColor() {
        return this.f41623f;
    }

    public final void setBgColor(String str) {
        this.f41623f = str;
    }

    public final int getHeight() {
        return this.f41624g;
    }

    public final void setHeight(int i) {
        this.f41624g = i;
    }

    public final String getDetail() {
        return this.f41625h;
    }

    public final void setDetail(String str) {
        this.f41625h = str;
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/customer/widget/abnormal/ActivityAbnormalViewModel$Companion;", "", "()V", "builder", "Lcom/didi/soda/customer/widget/abnormal/ActivityAbnormalViewModel$Builder;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ActivityAbnormalViewModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Builder builder() {
            return new Builder();
        }
    }

    @Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0015\u0010\u0006\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0010\u0010\n\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u0010\u0010\r\u001a\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\fJ\u0010\u0010\u000f\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u0010\u0010\u0012\u001a\u00020\u00002\b\u0010\u0013\u001a\u0004\u0018\u00010\fJ\u0010\u0010\u0014\u001a\u00020\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\fJ\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\bJ\u0010\u0010\u0018\u001a\u00020\u00002\b\u0010\u0019\u001a\u0004\u0018\u00010\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, mo175978d2 = {"Lcom/didi/soda/customer/widget/abnormal/ActivityAbnormalViewModel$Builder;", "", "()V", "t", "Lcom/didi/soda/customer/widget/abnormal/ActivityAbnormalViewModel;", "build", "setActStatus", "actStatus", "", "(Ljava/lang/Integer;)Lcom/didi/soda/customer/widget/abnormal/ActivityAbnormalViewModel$Builder;", "setBackgroundColor", "bgColor", "", "setButton", "button", "setClickListener", "clickListener", "Landroid/view/View$OnClickListener;", "setDesc", "desc", "setDetail", "detail", "setHeight", "height", "setImageUrl", "url", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ActivityAbnormalViewModel.kt */
    public static final class Builder {

        /* renamed from: t */
        private final ActivityAbnormalViewModel f41626t = new ActivityAbnormalViewModel((DefaultConstructorMarker) null);

        public final ActivityAbnormalViewModel build() {
            return this.f41626t;
        }

        public final Builder setClickListener(View.OnClickListener onClickListener) {
            this.f41626t.setClickListener(onClickListener);
            return this;
        }

        public final Builder setImageUrl(String str) {
            this.f41626t.setImageUrl(str);
            return this;
        }

        public final Builder setActStatus(Integer num) {
            this.f41626t.setActStatus(num);
            return this;
        }

        public final Builder setDesc(String str) {
            this.f41626t.setDesc(str);
            return this;
        }

        public final Builder setButton(String str) {
            this.f41626t.setButton(str);
            return this;
        }

        public final Builder setBackgroundColor(String str) {
            this.f41626t.setBgColor(str);
            return this;
        }

        public final Builder setDetail(String str) {
            this.f41626t.setDetail(str);
            return this;
        }

        public final Builder setHeight(int i) {
            this.f41626t.setHeight(i);
            return this;
        }
    }
}
