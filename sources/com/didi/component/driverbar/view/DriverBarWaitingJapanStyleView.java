package com.didi.component.driverbar.view;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
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
import com.didi.component.driverbar.model.CompanyTagInfo;
import com.didi.component.driverbar.model.CompanyTagsData;
import com.didi.component.driverbar.model.DriverBarCardInfo;
import com.didi.component.driverbar.model.DriverBarFieldInfo;
import com.didi.component.driverbar.model.DriverBarNormalData;
import com.didi.component.driverbar.model.DriverCarInfo2;
import com.didi.component.driverbar.model.DriverPersonalInfo;
import com.didi.component.driverbar.util.DriverBarInfoDisplayUtilsKt;
import com.didi.global.globaluikit.richinfo.LEGORichInfo;
import com.didiglobal.travel.biz.util.TraceUtilsKt;
import com.didiglobal.travel.infra.content.ContextKt;
import com.didiglobal.travel.infra.value.Color;
import com.didiglobal.travel.infra.view.ViewKt;
import com.didiglobal.travel.infra.widget.TextViewKt;
import com.didiglobal.travel.util.view.ViewEx;
import com.taxis99.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J,\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u0001022\b\b\u0001\u00103\u001a\u000204H\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b5\u00106J\b\u00107\u001a\u000208H\u0016J\u001a\u00109\u001a\u0002082\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0014J\b\u0010:\u001a\u00020;H\u0016J\u0010\u0010<\u001a\u0002082\u0006\u0010=\u001a\u00020;H\u0016J\u0010\u0010>\u001a\u0002082\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010?\u001a\u0002082\u0006\u0010@\u001a\u00020\tH\u0016J0\u0010A\u001a\u0002082\b\u0010B\u001a\u0004\u0018\u0001022\b\u0010C\u001a\u0004\u0018\u0001022\b\u0010D\u001a\u0004\u0018\u0001022\b\u0010E\u001a\u0004\u0018\u000102H\u0016J\f\u0010F\u001a\u000208*\u00020\tH\u0002J\u0016\u0010G\u001a\u000208*\u00020\u00192\b\u0010H\u001a\u0004\u0018\u00010IH\u0002J\f\u0010J\u001a\u000208*\u00020KH\u0002R\u000e\u0010\u0007\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\u0004\u0018\u00010\r8BX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\r8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0012\u001a\u0004\u0018\u00010\r8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000fR\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00158BX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u00198BX\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u00198BX\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001bR\u0016\u0010\u001e\u001a\u0004\u0018\u00010\u00198BX\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001bR\u0016\u0010 \u001a\u0004\u0018\u00010\u00198BX\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u001bR\u0016\u0010\"\u001a\u0004\u0018\u00010\u00198BX\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u001bR\u0016\u0010$\u001a\u0004\u0018\u00010\u00198BX\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u001bR\u0016\u0010&\u001a\u0004\u0018\u00010\u00058BX\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0016\u0010)\u001a\u0004\u0018\u00010\u00158BX\u0004¢\u0006\u0006\u001a\u0004\b*\u0010\u0017R\u0016\u0010+\u001a\u0004\u0018\u00010,8BX\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006L"}, mo175978d2 = {"Lcom/didi/component/driverbar/view/DriverBarWaitingJapanStyleView;", "Lcom/didi/component/driverbar/impl/DriverBarFieldBase;", "context", "Landroid/content/Context;", "container", "Landroid/view/ViewGroup;", "(Landroid/content/Context;Landroid/view/ViewGroup;)V", "_context", "contentModel", "Lcom/didi/component/driverbar/model/DriverBarCardInfo;", "driverHelper", "Lcom/didi/component/driverbar/view/DriverViewAccessHelper;", "ivCompanyLogo", "Landroid/widget/ImageView;", "getIvCompanyLogo", "()Landroid/widget/ImageView;", "ivDriverAvatar", "getIvDriverAvatar", "ivDriverUpgradeTips", "getIvDriverUpgradeTips", "spaceMsgBubblePlaceholder", "Landroid/view/View;", "getSpaceMsgBubblePlaceholder", "()Landroid/view/View;", "tvCarPlate", "Landroid/widget/TextView;", "getTvCarPlate", "()Landroid/widget/TextView;", "tvCarPlateTop", "getTvCarPlateTop", "tvCarTypeInfo", "getTvCarTypeInfo", "tvCompanyStatement", "getTvCompanyStatement", "tvDriverName", "getTvDriverName", "tvDriverUpgradeTips", "getTvDriverUpgradeTips", "vCompanyTagsInflated", "getVCompanyTagsInflated", "()Landroid/view/ViewGroup;", "vDriverInfoDivider", "getVDriverInfoDivider", "vsCompanyTags", "Landroid/view/ViewStub;", "getVsCompanyTags", "()Landroid/view/ViewStub;", "getColor", "Lcom/didiglobal/travel/infra/value/Color;", "colorText", "", "defaultColorId", "", "getColor-0AtSKxA", "(Ljava/lang/String;I)J", "hideCarUpdateInfo", "", "inflateView", "isPhoneVisible", "", "newMessageBubbleShow", "isShow", "onDriverAvatarClick", "setData", "info", "showCarUpdateInfo", "icon", "desc", "colorFrom", "colorTo", "bindToView", "inflateCompanyTag", "tag", "Lcom/didi/component/driverbar/model/CompanyTagInfo;", "inflateCompanyTags", "Lcom/didi/component/driverbar/model/CompanyTagsData;", "comp-driverbar_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: DriverBarWaitingJapanStyleView.kt */
public final class DriverBarWaitingJapanStyleView extends DriverBarFieldBase {

    /* renamed from: a */
    private final Context f13021a;

    /* renamed from: b */
    private DriverBarCardInfo f13022b;

    /* renamed from: c */
    private final DriverViewAccessHelper f13023c = new DriverViewAccessHelper();

    public boolean isPhoneVisible() {
        return true;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DriverBarWaitingJapanStyleView(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
        Intrinsics.checkNotNullParameter(context, "context");
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
        this.f13021a = applicationContext;
    }

    /* renamed from: a */
    private final TextView m8830a() {
        return (TextView) DriverBarFieldViewKt.childViewOf(this, R.id.tv_car_plate_top);
    }

    /* renamed from: b */
    private final TextView m8835b() {
        return (TextView) DriverBarFieldViewKt.childViewOf(this, R.id.tv_car_plate);
    }

    /* renamed from: c */
    private final TextView m8836c() {
        return (TextView) DriverBarFieldViewKt.childViewOf(this, R.id.tv_car_type_info);
    }

    /* renamed from: d */
    private final TextView m8837d() {
        return (TextView) DriverBarFieldViewKt.childViewOf(this, R.id.tv_company_statement);
    }

    /* renamed from: e */
    private final ImageView m8838e() {
        return (ImageView) DriverBarFieldViewKt.childViewOf(this, R.id.iv_company_logo);
    }

    /* renamed from: f */
    private final ViewStub m8839f() {
        return (ViewStub) DriverBarFieldViewKt.childViewOf(this, R.id.vs_company_tags);
    }

    /* renamed from: g */
    private final ViewGroup m8840g() {
        return (ViewGroup) DriverBarFieldViewKt.childViewOf(this, R.id.v_company_tags_inflated);
    }

    /* renamed from: h */
    private final ImageView m8841h() {
        return (ImageView) DriverBarFieldViewKt.childViewOf(this, R.id.civ_driver_avatar);
    }

    /* renamed from: i */
    private final TextView m8842i() {
        return (TextView) DriverBarFieldViewKt.childViewOf(this, R.id.tv_driver_name);
    }

    /* renamed from: j */
    private final TextView m8843j() {
        return (TextView) DriverBarFieldViewKt.childViewOf(this, R.id.tv_driver_upgrade_tips);
    }

    /* renamed from: k */
    private final ImageView m8844k() {
        return (ImageView) DriverBarFieldViewKt.childViewOf(this, R.id.iv_driver_upgrade_icon);
    }

    /* renamed from: l */
    private final View m8845l() {
        return DriverBarFieldViewKt.childViewOf(this, R.id.space_msg_bubble_placeholder);
    }

    /* renamed from: m */
    private final View m8846m() {
        return DriverBarFieldViewKt.childViewOf(this, R.id.v_driver_info_divider);
    }

    /* access modifiers changed from: protected */
    public void inflateView(Context context, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(context, "context");
        View inflateViewAsync = ViewEx.inflateViewAsync(context, (int) R.layout.global_driver_bar_waiting_jp_style_view, viewGroup, false);
        ViewKt.requireViewByIdCompat(inflateViewAsync, R.id.v_driver_info_mask).setOnClickListener(new C5438x9444b767(this));
        ViewKt.requireViewByIdCompat(inflateViewAsync, R.id.civ_driver_avatar).setOnClickListener(new C5439x9444b768(this));
        Unit unit = Unit.INSTANCE;
        this.mContainerView = inflateViewAsync;
    }

    public void setData(DriverBarCardInfo driverBarCardInfo) {
        Intrinsics.checkNotNullParameter(driverBarCardInfo, "info");
        super.setData(driverBarCardInfo);
        this.f13022b = driverBarCardInfo;
        this.f13023c.setDriverInfo(driverBarCardInfo);
        m8834a(driverBarCardInfo);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v1, resolved type: android.content.Context} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v2, resolved type: android.content.Context} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v3, resolved type: android.content.Context} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v4, resolved type: android.content.Context} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v8, resolved type: android.content.Context} */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0053, code lost:
        if ((r8.length() > 0) != false) goto L_0x0057;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void showCarUpdateInfo(java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.String r11) {
        /*
            r7 = this;
            super.showCarUpdateInfo(r8, r9, r10, r11)
            android.widget.TextView r11 = r7.m8843j()
            r0 = 1
            r1 = 0
            if (r11 != 0) goto L_0x000c
            goto L_0x003e
        L_0x000c:
            if (r9 != 0) goto L_0x0010
            java.lang.String r9 = ""
        L_0x0010:
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            r11.setText(r9)
            r9 = 2131100641(0x7f0603e1, float:1.781367E38)
            long r2 = r7.m8829a((java.lang.String) r10, (int) r9)
            r9 = 2131100642(0x7f0603e2, float:1.7813671E38)
            long r9 = r7.m8829a((java.lang.String) r10, (int) r9)
            android.graphics.drawable.GradientDrawable r4 = new android.graphics.drawable.GradientDrawable
            android.graphics.drawable.GradientDrawable$Orientation r5 = android.graphics.drawable.GradientDrawable.Orientation.LEFT_RIGHT
            r6 = 2
            int[] r6 = new int[r6]
            int r2 = com.didiglobal.travel.infra.value.Color.m47236getColorIntimpl(r2)
            r6[r1] = r2
            int r9 = com.didiglobal.travel.infra.value.Color.m47236getColorIntimpl(r9)
            r6[r0] = r9
            r4.<init>(r5, r6)
            android.graphics.drawable.Drawable r4 = (android.graphics.drawable.Drawable) r4
            r11.setBackground(r4)
        L_0x003e:
            android.widget.ImageView r9 = r7.m8844k()
            if (r9 != 0) goto L_0x0045
            goto L_0x008d
        L_0x0045:
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r10 = 0
            if (r8 == 0) goto L_0x0056
            int r11 = r8.length()
            if (r11 <= 0) goto L_0x0052
            r11 = 1
            goto L_0x0053
        L_0x0052:
            r11 = 0
        L_0x0053:
            if (r11 == 0) goto L_0x0056
            goto L_0x0057
        L_0x0056:
            r8 = r10
        L_0x0057:
            java.lang.String r8 = (java.lang.String) r8
            if (r8 != 0) goto L_0x005c
            goto L_0x0084
        L_0x005c:
            r11 = r9
            android.view.View r11 = (android.view.View) r11
            r11.setVisibility(r1)
            android.content.Context r11 = r11.getContext()
            boolean r1 = com.didi.component.business.util.Utils.isDestroy(r11)
            r0 = r0 ^ r1
            if (r0 == 0) goto L_0x006e
            r10 = r11
        L_0x006e:
            if (r10 != 0) goto L_0x0071
            goto L_0x0083
        L_0x0071:
            com.bumptech.glide.RequestManager r10 = com.bumptech.glide.Glide.with((android.content.Context) r10)
            if (r10 != 0) goto L_0x0078
            goto L_0x0083
        L_0x0078:
            com.bumptech.glide.RequestBuilder r10 = r10.asBitmap()
            com.bumptech.glide.RequestBuilder r10 = r10.load((java.lang.String) r8)
            r10.into((android.widget.ImageView) r9)
        L_0x0083:
            r10 = r8
        L_0x0084:
            if (r10 != 0) goto L_0x008d
            android.view.View r9 = (android.view.View) r9
            r8 = 8
            r9.setVisibility(r8)
        L_0x008d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.driverbar.view.DriverBarWaitingJapanStyleView.showCarUpdateInfo(java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
    }

    public void hideCarUpdateInfo() {
        super.hideCarUpdateInfo();
        TextView j = m8843j();
        if (j != null) {
            j.setVisibility(8);
        }
        ImageView k = m8844k();
        if (k != null) {
            k.setVisibility(8);
        }
    }

    public void newMessageBubbleShow(boolean z) {
        super.newMessageBubbleShow(z);
        View l = m8845l();
        int i = 0;
        if (l != null) {
            if (z) {
                l.setVisibility(0);
            } else {
                l.setVisibility(8);
            }
        }
        View m = m8846m();
        if (m != null) {
            if (!(!z)) {
                i = 4;
            }
            m.setVisibility(i);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m8831a(Context context) {
        TraceUtilsKt.omega(DriverBarWaitingJapanStyleView$onDriverAvatarClick$1.INSTANCE);
        this.f13023c.popupAvatarEnlarge(context);
    }

    /* renamed from: a */
    private final void m8833a(CompanyTagsData companyTagsData) {
        TextView textView;
        TextView textView2;
        ViewGroup g = m8840g();
        if (g == null) {
            ViewStub f = m8839f();
            if (f != null) {
                f.inflate();
            }
        } else {
            View view = g;
        }
        TextView d = m8837d();
        if (d != null) {
            TextViewKt.setTextWithVisible(d, companyTagsData.getCompanyStatement(), true);
        }
        List<CompanyTagInfo> list = companyTagsData.getList();
        if (list != null) {
            if (!(!list.isEmpty())) {
                list = null;
            }
            if (list != null) {
                View view2 = this.mContainerView;
                if (!(view2 == null || (textView2 = (TextView) view2.findViewById(R.id.tv_driver_bar_tag1)) == null)) {
                    m8832a(textView2, (CompanyTagInfo) CollectionsKt.getOrNull(list, 0));
                }
                View view3 = this.mContainerView;
                if (view3 != null && (textView = (TextView) view3.findViewById(R.id.tv_driver_bar_tag2)) != null) {
                    m8832a(textView, (CompanyTagInfo) CollectionsKt.getOrNull(list, 1));
                }
            }
        }
    }

    /* renamed from: a */
    private final long m8829a(String str, int i) {
        Color r3 = str == null ? null : Color.m47226boximpl(Color.Companion.of-Ba4jWBc(str));
        if (r3 != null) {
            return r3.m47245unboximpl();
        }
        Color.Companion companion = Color.Companion;
        Context context = this.mContext;
        Intrinsics.checkNotNullExpressionValue(context, "mContext");
        return companion.of-Ba4jWBc(ContextKt.colorOf(context, i));
    }

    /* renamed from: a */
    private final void m8834a(DriverBarCardInfo driverBarCardInfo) {
        DriverBarFieldInfo driverBarFieldInfo;
        DriverBarFieldInfo driverBarFieldInfo2;
        CompanyTagsData companyTagsData;
        RequestManager with;
        String str;
        DriverPersonalInfo driverInfo;
        RequestManager with2;
        DriverCarInfo2 carInfo;
        SpannableString spannableString;
        SpannableString parseRichInfo;
        SpannableString spannableString2;
        SpannableString parseRichInfo2;
        SpannableString spannableString3;
        SpannableString parseRichInfo3;
        SpannableString spannableString4;
        SpannableString parseRichInfo4;
        DataFieldWrapper<DriverBarNormalData> normal = driverBarCardInfo.getNormal();
        String str2 = null;
        DriverBarNormalData data = normal == null ? null : normal.getData();
        if (data == null) {
            driverBarFieldInfo = null;
        } else {
            driverBarFieldInfo = data.getFarInfo();
        }
        boolean z = false;
        if (!(driverBarFieldInfo == null || (carInfo = driverBarFieldInfo.getCarInfo()) == null)) {
            LEGORichInfo licenseNumExt = carInfo.getLicenseNumExt();
            if (licenseNumExt != null) {
                Context context = this.f13021a;
                CharSequence content = licenseNumExt.getContent();
                if (!(!(content == null || content.length() == 0))) {
                    licenseNumExt = null;
                }
                if (!(licenseNumExt == null || (parseRichInfo4 = licenseNumExt.parseRichInfo(context)) == null)) {
                    CharSequence charSequence = parseRichInfo4;
                    if (!(charSequence.length() > 0)) {
                        charSequence = null;
                    }
                    spannableString4 = (SpannableString) charSequence;
                    if (spannableString4 != null) {
                        CharSequence charSequence2 = spannableString4;
                        TextView a = m8830a();
                        if (a != null) {
                            TextViewKt.setTextWithVisible(a, charSequence2, true);
                            Unit unit = Unit.INSTANCE;
                        }
                        CharSequence charSequence3 = spannableString4;
                    }
                }
                spannableString4 = null;
                CharSequence charSequence32 = spannableString4;
            }
            LEGORichInfo licenseNum = carInfo.getLicenseNum();
            if (licenseNum != null) {
                Context context2 = this.f13021a;
                CharSequence content2 = licenseNum.getContent();
                if (!(!(content2 == null || content2.length() == 0))) {
                    licenseNum = null;
                }
                if (!(licenseNum == null || (parseRichInfo3 = licenseNum.parseRichInfo(context2)) == null)) {
                    CharSequence charSequence4 = parseRichInfo3;
                    if (!(charSequence4.length() > 0)) {
                        charSequence4 = null;
                    }
                    spannableString3 = (SpannableString) charSequence4;
                    if (spannableString3 != null) {
                        CharSequence charSequence5 = spannableString3;
                        if (charSequence5 instanceof SpannableString) {
                            ((SpannableString) charSequence5).setSpan(new CustomVerticalCenterSpan(this.f13021a, 16), 0, 1, 17);
                        }
                        TextView b = m8835b();
                        if (b != null) {
                            TextViewKt.setTextWithVisible(b, charSequence5, true);
                            Unit unit2 = Unit.INSTANCE;
                        }
                        CharSequence charSequence6 = spannableString3;
                    }
                }
                spannableString3 = null;
                CharSequence charSequence62 = spannableString3;
            }
            TextView c = m8836c();
            if (c != null) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                LEGORichInfo carColorInfo = carInfo.getCarColorInfo();
                if (carColorInfo != null) {
                    Context context3 = this.f13021a;
                    CharSequence content3 = carColorInfo.getContent();
                    if (!(!(content3 == null || content3.length() == 0))) {
                        carColorInfo = null;
                    }
                    if (!(carColorInfo == null || (parseRichInfo2 = carColorInfo.parseRichInfo(context3)) == null)) {
                        CharSequence charSequence7 = parseRichInfo2;
                        if (!(charSequence7.length() > 0)) {
                            charSequence7 = null;
                        }
                        spannableString2 = (SpannableString) charSequence7;
                        if (spannableString2 != null) {
                            spannableStringBuilder.append(spannableString2);
                            CharSequence charSequence8 = spannableString2;
                        }
                    }
                    spannableString2 = null;
                    CharSequence charSequence82 = spannableString2;
                }
                LEGORichInfo carTypeInfo = carInfo.getCarTypeInfo();
                if (carTypeInfo != null) {
                    Context context4 = this.f13021a;
                    CharSequence content4 = carTypeInfo.getContent();
                    if (!(!(content4 == null || content4.length() == 0))) {
                        carTypeInfo = null;
                    }
                    if (!(carTypeInfo == null || (parseRichInfo = carTypeInfo.parseRichInfo(context4)) == null)) {
                        CharSequence charSequence9 = parseRichInfo;
                        if (!(charSequence9.length() > 0)) {
                            charSequence9 = null;
                        }
                        spannableString = (SpannableString) charSequence9;
                        if (spannableString != null) {
                            DriverBarInfoDisplayUtilsKt.appendWithPreDelimiter(spannableStringBuilder, spannableString, " · ");
                            CharSequence charSequence10 = spannableString;
                        }
                    }
                    spannableString = null;
                    CharSequence charSequence102 = spannableString;
                }
                Unit unit3 = Unit.INSTANCE;
                c.setText(spannableStringBuilder);
            }
            Unit unit4 = Unit.INSTANCE;
        }
        DataFieldWrapper<DriverBarNormalData> normal2 = driverBarCardInfo.getNormal();
        DriverBarNormalData data2 = normal2 == null ? null : normal2.getData();
        if (data2 == null) {
            driverBarFieldInfo2 = null;
        } else {
            driverBarFieldInfo2 = data2.getFarInfo();
        }
        String str3 = "";
        if (!(driverBarFieldInfo2 == null || (driverInfo = driverBarFieldInfo2.getDriverInfo()) == null)) {
            String avatar = driverInfo.getAvatar();
            if (avatar == null) {
                avatar = str3;
            }
            this.f13023c.bindDriverName(m8842i(), driverInfo.getName());
            ImageView h = m8841h();
            if (h != null) {
                Context context5 = h.getContext();
                if (!(!Utils.isDestroy(context5))) {
                    context5 = null;
                }
                if (!(context5 == null || (with2 = Glide.with(context5)) == null)) {
                    BaseRequestOptions fallback = ((RequestBuilder) with2.load(avatar).placeholder((int) R.drawable.driver_card_default_avatar_v2)).fallback((int) R.drawable.driver_card_default_avatar_v2);
                    Intrinsics.checkNotNullExpressionValue(fallback, "load(avatarUrl)\n        …r_card_default_avatar_v2)");
                    ((RequestBuilder) fallback).into(h);
                }
                Unit unit5 = Unit.INSTANCE;
            }
            Unit unit6 = Unit.INSTANCE;
        }
        ImageView e = m8838e();
        if (e != null) {
            Context context6 = e.getContext();
            if (!(!Utils.isDestroy(context6))) {
                context6 = null;
            }
            if (!(context6 == null || (with = Glide.with(context6)) == null)) {
                DataFieldWrapper<DriverBarNormalData> normal3 = driverBarCardInfo.getNormal();
                DriverBarNormalData data3 = normal3 == null ? null : normal3.getData();
                if (data3 == null) {
                    str = null;
                } else {
                    str = data3.getCompanyLogoUrl();
                }
                if (str == null) {
                    str = str3;
                }
                CharSequence charSequence11 = str;
                if (!(charSequence11.length() > 0)) {
                    charSequence11 = null;
                }
                String str4 = (String) charSequence11;
                if (str4 == null) {
                    str4 = null;
                } else {
                    e.setVisibility(0);
                    with.load(str4).into(e);
                    Unit unit7 = Unit.INSTANCE;
                }
                if (str4 == null) {
                    e.setVisibility(8);
                    Unit unit8 = Unit.INSTANCE;
                }
            }
            Unit unit9 = Unit.INSTANCE;
        }
        DataFieldWrapper<DriverBarNormalData> normal4 = driverBarCardInfo.getNormal();
        DriverBarNormalData data4 = normal4 == null ? null : normal4.getData();
        if (data4 == null) {
            companyTagsData = null;
        } else {
            companyTagsData = data4.getCompanyTags();
        }
        if (companyTagsData != null) {
            m8833a(companyTagsData);
            Unit unit10 = Unit.INSTANCE;
        }
        View view = this.mContainerView;
        Intrinsics.checkNotNullExpressionValue(view, "mContainerView");
        View requireViewByIdCompat = ViewKt.requireViewByIdCompat(view, R.id.v_driver_info_mask);
        DataFieldWrapper<DriverBarNormalData> normal5 = driverBarCardInfo.getNormal();
        DriverBarNormalData data5 = normal5 == null ? null : normal5.getData();
        if (data5 != null) {
            str2 = data5.getDriverProfileUrl();
        }
        if (str2 != null) {
            str3 = str2;
        }
        if (str3.length() > 0) {
            z = true;
        }
        requireViewByIdCompat.setEnabled(z);
    }

    /* JADX WARNING: type inference failed for: r0v3, types: [kotlin.Unit] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m8832a(android.widget.TextView r5, com.didi.component.driverbar.model.CompanyTagInfo r6) {
        /*
            r4 = this;
            r0 = 0
            if (r6 != 0) goto L_0x0004
            goto L_0x0048
        L_0x0004:
            java.lang.String r1 = r6.getText()
            java.lang.String r2 = ""
            if (r1 != 0) goto L_0x000d
            r1 = r2
        L_0x000d:
            java.lang.String r6 = r6.getImageUrl()
            if (r6 != 0) goto L_0x0014
            goto L_0x0015
        L_0x0014:
            r2 = r6
        L_0x0015:
            r6 = r5
            android.view.View r6 = (android.view.View) r6
            r3 = 0
            r6.setVisibility(r3)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r5.setText(r1)
            android.content.Context r6 = r6.getContext()
            boolean r1 = com.didi.component.business.util.Utils.isDestroy(r6)
            r1 = r1 ^ 1
            if (r1 == 0) goto L_0x002e
            r0 = r6
        L_0x002e:
            if (r0 != 0) goto L_0x0031
            goto L_0x0046
        L_0x0031:
            com.bumptech.glide.RequestManager r6 = com.bumptech.glide.Glide.with((android.content.Context) r0)
            if (r6 != 0) goto L_0x0038
            goto L_0x0046
        L_0x0038:
            com.bumptech.glide.RequestBuilder r6 = r6.load((java.lang.String) r2)
            com.didi.component.driverbar.view.DriverBarWaitingJapanStyleView$inflateCompanyTag$1$1$1 r0 = new com.didi.component.driverbar.view.DriverBarWaitingJapanStyleView$inflateCompanyTag$1$1$1
            r0.<init>(r5)
            com.bumptech.glide.request.target.Target r0 = (com.bumptech.glide.request.target.Target) r0
            r6.into(r0)
        L_0x0046:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
        L_0x0048:
            if (r0 != 0) goto L_0x0051
            android.view.View r5 = (android.view.View) r5
            r6 = 8
            r5.setVisibility(r6)
        L_0x0051:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.driverbar.view.DriverBarWaitingJapanStyleView.m8832a(android.widget.TextView, com.didi.component.driverbar.model.CompanyTagInfo):void");
    }
}
