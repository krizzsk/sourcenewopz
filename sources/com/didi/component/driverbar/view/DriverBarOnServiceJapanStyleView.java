package com.didi.component.driverbar.view;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.BaseRequestOptions;
import com.didi.component.business.util.Utils;
import com.didi.component.common.model.DataFieldWrapper;
import com.didi.component.driverbar.impl.DriverBarFieldBase;
import com.didi.component.driverbar.impl.DriverBarFieldViewKt;
import com.didi.component.driverbar.model.DriverBarCardInfo;
import com.didi.component.driverbar.model.DriverBarFieldInfo;
import com.didi.component.driverbar.model.DriverBarNormalData;
import com.didi.component.driverbar.model.DriverCarInfo2;
import com.didi.component.driverbar.model.DriverPersonalInfo;
import com.didi.component.driverbar.util.DriverBarInfoDisplayUtilsKt;
import com.didi.global.globaluikit.richinfo.LEGORichInfo;
import com.didiglobal.travel.biz.util.TraceUtilsKt;
import com.didiglobal.travel.infra.view.ViewKt;
import com.didiglobal.travel.infra.widget.TextViewKt;
import com.didiglobal.travel.util.view.ViewEx;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u001a\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0014J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001bH\u0016R\u000e\u0010\u0007\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\u0004\u0018\u00010\u000b8BX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000f8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u000f8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u000f8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0011¨\u0006\u001c"}, mo175978d2 = {"Lcom/didi/component/driverbar/view/DriverBarOnServiceJapanStyleView;", "Lcom/didi/component/driverbar/impl/DriverBarFieldBase;", "context", "Landroid/content/Context;", "container", "Landroid/view/ViewGroup;", "(Landroid/content/Context;Landroid/view/ViewGroup;)V", "_context", "driverHelper", "Lcom/didi/component/driverbar/view/DriverViewAccessHelper;", "ivDriverAvatar", "Landroid/widget/ImageView;", "getIvDriverAvatar", "()Landroid/widget/ImageView;", "tvCarPlateInfo", "Landroid/widget/TextView;", "getTvCarPlateInfo", "()Landroid/widget/TextView;", "tvCarTypeInfo", "getTvCarTypeInfo", "tvDriverName", "getTvDriverName", "inflateView", "", "onDriverAvatarClick", "setData", "info", "Lcom/didi/component/driverbar/model/DriverBarCardInfo;", "comp-driverbar_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: DriverBarOnServiceJapanStyleView.kt */
public final class DriverBarOnServiceJapanStyleView extends DriverBarFieldBase {

    /* renamed from: a */
    private final Context f13019a;

    /* renamed from: b */
    private final DriverViewAccessHelper f13020b = new DriverViewAccessHelper();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DriverBarOnServiceJapanStyleView(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
        Intrinsics.checkNotNullParameter(context, "context");
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
        this.f13019a = applicationContext;
    }

    /* renamed from: a */
    private final ImageView m8824a() {
        return (ImageView) DriverBarFieldViewKt.childViewOf(this, R.id.civ_driver_avatar);
    }

    /* renamed from: b */
    private final TextView m8826b() {
        return (TextView) DriverBarFieldViewKt.childViewOf(this, R.id.tv_driver_name);
    }

    /* renamed from: c */
    private final TextView m8827c() {
        return (TextView) DriverBarFieldViewKt.childViewOf(this, R.id.tv_car_plate_info);
    }

    /* renamed from: d */
    private final TextView m8828d() {
        return (TextView) DriverBarFieldViewKt.childViewOf(this, R.id.tv_car_type_info);
    }

    /* access modifiers changed from: protected */
    public void inflateView(Context context, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(context, "context");
        View inflateViewAsync = ViewEx.inflateViewAsync(context, (int) R.layout.global_driver_bar_on_service_jp_style_view, viewGroup, false);
        ViewKt.requireViewByIdCompat(inflateViewAsync, R.id.v_driver_info_mask).setOnClickListener(new C5436x87ead6f0(this));
        ViewKt.requireViewByIdCompat(inflateViewAsync, R.id.civ_driver_avatar).setOnClickListener(new C5437x87ead6f1(this));
        Unit unit = Unit.INSTANCE;
        this.mContainerView = inflateViewAsync;
    }

    public void setData(DriverBarCardInfo driverBarCardInfo) {
        DriverBarFieldInfo driverBarFieldInfo;
        DriverBarFieldInfo driverBarFieldInfo2;
        DriverCarInfo2 carInfo;
        SpannableString spannableString;
        SpannableString parseRichInfo;
        SpannableString spannableString2;
        SpannableString parseRichInfo2;
        SpannableString spannableString3;
        SpannableString parseRichInfo3;
        DriverPersonalInfo driverInfo;
        RequestManager with;
        Intrinsics.checkNotNullParameter(driverBarCardInfo, "info");
        super.setData(driverBarCardInfo);
        this.f13020b.setDriverInfo(driverBarCardInfo);
        DataFieldWrapper<DriverBarNormalData> normal = driverBarCardInfo.getNormal();
        String str = null;
        DriverBarNormalData data = normal == null ? null : normal.getData();
        if (data == null) {
            driverBarFieldInfo = null;
        } else {
            driverBarFieldInfo = data.getFarInfo();
        }
        String str2 = "";
        boolean z = true;
        if (!(driverBarFieldInfo == null || (driverInfo = driverBarFieldInfo.getDriverInfo()) == null)) {
            String avatar = driverInfo.getAvatar();
            if (avatar == null) {
                avatar = str2;
            }
            this.f13020b.bindDriverName(m8826b(), driverInfo.getName());
            ImageView a = m8824a();
            if (a != null) {
                Context context = a.getContext();
                if (!(!Utils.isDestroy(context))) {
                    context = null;
                }
                if (!(context == null || (with = Glide.with(context)) == null)) {
                    BaseRequestOptions fallback = ((RequestBuilder) with.load(avatar).placeholder((int) R.drawable.driver_card_default_avatar_v2)).fallback((int) R.drawable.driver_card_default_avatar_v2);
                    Intrinsics.checkNotNullExpressionValue(fallback, "load(avatarUrl)\n        …r_card_default_avatar_v2)");
                    ((RequestBuilder) fallback).into(a);
                }
                Unit unit = Unit.INSTANCE;
            }
            Unit unit2 = Unit.INSTANCE;
        }
        DataFieldWrapper<DriverBarNormalData> normal2 = driverBarCardInfo.getNormal();
        DriverBarNormalData data2 = normal2 == null ? null : normal2.getData();
        if (data2 == null) {
            driverBarFieldInfo2 = null;
        } else {
            driverBarFieldInfo2 = data2.getFarInfo();
        }
        if (!(driverBarFieldInfo2 == null || (carInfo = driverBarFieldInfo2.getCarInfo()) == null)) {
            TextView c = m8827c();
            if (c != null) {
                LEGORichInfo licenseNum = carInfo.getLicenseNum();
                if (licenseNum != null) {
                    Context context2 = this.f13019a;
                    CharSequence content = licenseNum.getContent();
                    if (!(!(content == null || content.length() == 0))) {
                        licenseNum = null;
                    }
                    if (!(licenseNum == null || (parseRichInfo3 = licenseNum.parseRichInfo(context2)) == null)) {
                        CharSequence charSequence = parseRichInfo3;
                        if (!(charSequence.length() > 0)) {
                            charSequence = null;
                        }
                        spannableString3 = (SpannableString) charSequence;
                        if (spannableString3 != null) {
                            TextViewKt.setTextWithVisible$default(c, spannableString3, false, 2, (Object) null);
                            CharSequence charSequence2 = spannableString3;
                        }
                    }
                    spannableString3 = null;
                    CharSequence charSequence22 = spannableString3;
                }
                Unit unit3 = Unit.INSTANCE;
            }
            TextView d = m8828d();
            if (d != null) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                LEGORichInfo carColorInfo = carInfo.getCarColorInfo();
                if (carColorInfo != null) {
                    Context context3 = this.f13019a;
                    CharSequence content2 = carColorInfo.getContent();
                    if (!(!(content2 == null || content2.length() == 0))) {
                        carColorInfo = null;
                    }
                    if (!(carColorInfo == null || (parseRichInfo2 = carColorInfo.parseRichInfo(context3)) == null)) {
                        CharSequence charSequence3 = parseRichInfo2;
                        if (!(charSequence3.length() > 0)) {
                            charSequence3 = null;
                        }
                        spannableString2 = (SpannableString) charSequence3;
                        if (spannableString2 != null) {
                            spannableStringBuilder.append(spannableString2);
                            CharSequence charSequence4 = spannableString2;
                        }
                    }
                    spannableString2 = null;
                    CharSequence charSequence42 = spannableString2;
                }
                LEGORichInfo carTypeInfo = carInfo.getCarTypeInfo();
                if (carTypeInfo != null) {
                    Context context4 = this.f13019a;
                    CharSequence content3 = carTypeInfo.getContent();
                    if (!(!(content3 == null || content3.length() == 0))) {
                        carTypeInfo = null;
                    }
                    if (!(carTypeInfo == null || (parseRichInfo = carTypeInfo.parseRichInfo(context4)) == null)) {
                        CharSequence charSequence5 = parseRichInfo;
                        if (!(charSequence5.length() > 0)) {
                            charSequence5 = null;
                        }
                        spannableString = (SpannableString) charSequence5;
                        if (spannableString != null) {
                            DriverBarInfoDisplayUtilsKt.appendWithPreDelimiter(spannableStringBuilder, spannableString, " ");
                            CharSequence charSequence6 = spannableString;
                        }
                    }
                    spannableString = null;
                    CharSequence charSequence62 = spannableString;
                }
                Unit unit4 = Unit.INSTANCE;
                TextViewKt.setTextWithVisible$default(d, spannableStringBuilder, false, 2, (Object) null);
                Unit unit5 = Unit.INSTANCE;
            }
            Unit unit6 = Unit.INSTANCE;
        }
        View view = this.mContainerView;
        Intrinsics.checkNotNullExpressionValue(view, "mContainerView");
        View requireViewByIdCompat = ViewKt.requireViewByIdCompat(view, R.id.v_driver_info_mask);
        DataFieldWrapper<DriverBarNormalData> normal3 = driverBarCardInfo.getNormal();
        DriverBarNormalData data3 = normal3 == null ? null : normal3.getData();
        if (data3 != null) {
            str = data3.getDriverProfileUrl();
        }
        if (str != null) {
            str2 = str;
        }
        if (str2.length() <= 0) {
            z = false;
        }
        requireViewByIdCompat.setEnabled(z);
        Unit unit7 = Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m8825a(Context context) {
        TraceUtilsKt.omega(DriverBarOnServiceJapanStyleView$onDriverAvatarClick$1.INSTANCE);
        this.f13020b.popupAvatarEnlarge(context);
    }
}
