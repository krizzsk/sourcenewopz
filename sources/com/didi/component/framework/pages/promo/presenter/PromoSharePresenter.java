package com.didi.component.framework.pages.promo.presenter;

import android.content.Context;
import com.didi.component.core.IPresenter;
import com.didi.component.framework.pages.promo.model.PromoShareBtnModel;
import com.didi.component.framework.pages.promo.model.PromoShareInfo;
import com.didi.component.framework.pages.promo.view.IPromoShareView;
import com.didi.onekeyshare.entity.OneKeyShareInfo;
import com.didi.onekeyshare.view.fragment.PlatformClickListener;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo175977d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0011\u001a\u00020\u00122\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014H\u0002J\u0010\u0010\u0016\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J\u001e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00142\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014H\u0002J\u000e\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u001dJ\u0010\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\bH\u0002J\u0012\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\nH\u0002J\u0012\u0010#\u001a\u00020\b2\b\u0010$\u001a\u0004\u0018\u00010\u0015H\u0002R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006%"}, mo175978d2 = {"Lcom/didi/component/framework/pages/promo/presenter/PromoSharePresenter;", "Lcom/didi/component/core/IPresenter;", "Lcom/didi/component/framework/pages/promo/view/IPromoShareView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "allElements", "Ljava/util/ArrayList;", "Lcom/didi/onekeyshare/entity/OneKeyShareInfo;", "campaignId", "", "getCampaignId", "()Ljava/lang/String;", "setCampaignId", "(Ljava/lang/String;)V", "getContext", "()Landroid/content/Context;", "generateAllChannel", "", "list", "", "Lcom/didi/component/framework/pages/promo/model/PromoShareInfo;", "generateRvItemAndOther", "rspData", "Lcom/didi/component/framework/pages/promo/model/PromoData;", "generateShareBtnModelList", "Lcom/didi/component/framework/pages/promo/model/PromoShareBtnModel;", "getShareInfoAll", "callback", "Lcom/didi/onekeyshare/view/fragment/PlatformClickListener;", "initInfoSmsMsg", "shareInfo", "isDiscountType", "", "type", "mapPromoInfo2ShareInfo", "promoShareInfo", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PromoSharePresenter.kt */
public final class PromoSharePresenter extends IPresenter<IPromoShareView> {

    /* renamed from: a */
    private final Context f13949a;

    /* renamed from: b */
    private ArrayList<OneKeyShareInfo> f13950b = new ArrayList<>();

    /* renamed from: c */
    private String f13951c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PromoSharePresenter(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f13949a = context;
    }

    public final Context getContext() {
        return this.f13949a;
    }

    public final String getCampaignId() {
        return this.f13951c;
    }

    public final void setCampaignId(String str) {
        this.f13951c = str;
    }

    public final void getShareInfoAll(PlatformClickListener platformClickListener) {
        Intrinsics.checkNotNullParameter(platformClickListener, "callback");
        IPromoShareView iPromoShareView = (IPromoShareView) this.mView;
        if (iPromoShareView != null) {
            iPromoShareView.showShareDialog(this.f13950b, platformClickListener);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0184, code lost:
        if ((r2 == null || r2.isEmpty()) == false) goto L_0x0188;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void generateRvItemAndOther(com.didi.component.framework.pages.promo.model.PromoData r29) {
        /*
            r28 = this;
            r0 = r28
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.List r1 = (java.util.List) r1
            if (r29 != 0) goto L_0x000d
            goto L_0x0192
        L_0x000d:
            com.didi.component.framework.pages.promo.model.ShareBannerInfo r2 = r29.getShareBannerInfo()
            if (r2 != 0) goto L_0x0015
            r2 = 0
            goto L_0x0019
        L_0x0015:
            java.lang.String r2 = r2.getRedeemPageImage()
        L_0x0019:
            r5 = r2
            if (r5 == 0) goto L_0x0041
            com.didi.component.framework.pages.promo.model.PromoShareItem r2 = new com.didi.component.framework.pages.promo.model.PromoShareItem
            r3 = r2
            r4 = 1
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 262140(0x3fffc, float:3.67336E-40)
            r23 = 0
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            r1.add(r2)
        L_0x0041:
            java.lang.String r2 = r29.getActivityId()
            r0.setCampaignId(r2)
            java.lang.String r2 = r29.getPromoType()
            java.lang.String r3 = "promocode"
            r4 = 1
            boolean r2 = kotlin.text.StringsKt.equals(r2, r3, r4)
            if (r2 == 0) goto L_0x005a
            java.util.List r2 = r29.getCouponInfoList()
            goto L_0x005e
        L_0x005a:
            java.util.List r2 = r29.getTuiCouponInfoList()
        L_0x005e:
            r3 = 0
            if (r2 != 0) goto L_0x0063
            goto L_0x0136
        L_0x0063:
            boolean r5 = r2.isEmpty()
            if (r5 == 0) goto L_0x006a
            return
        L_0x006a:
            int r5 = r2.size()
            if (r5 != r4) goto L_0x007c
            android.content.Context r5 = r28.getContext()
            r6 = 2131955277(0x7f130e4d, float:1.9547077E38)
            java.lang.String r5 = com.didi.sdk.util.ResourcesHelper.getString(r5, r6)
            goto L_0x0087
        L_0x007c:
            android.content.Context r5 = r28.getContext()
            r6 = 2131955276(0x7f130e4c, float:1.9547075E38)
            java.lang.String r5 = com.didi.sdk.util.ResourcesHelper.getString(r5, r6)
        L_0x0087:
            int r6 = r2.size()
            if (r6 == r4) goto L_0x00ad
            kotlin.jvm.internal.StringCompanionObject r6 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r6 = "couponText"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            java.lang.Object[] r6 = new java.lang.Object[r4]
            int r7 = r2.size()
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r6[r3] = r7
            java.lang.Object[] r6 = java.util.Arrays.copyOf(r6, r4)
            java.lang.String r5 = java.lang.String.format(r5, r6)
            java.lang.String r6 = "format(format, *args)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
        L_0x00ad:
            r10 = r5
            com.didi.component.framework.pages.promo.model.PromoShareItem r5 = new com.didi.component.framework.pages.promo.model.PromoShareItem
            r7 = r5
            r8 = 2
            r9 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 262138(0x3fffa, float:3.67334E-40)
            r27 = 0
            r7.<init>(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
            r1.add(r5)
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Iterator r2 = r2.iterator()
        L_0x00dd:
            boolean r5 = r2.hasNext()
            if (r5 == 0) goto L_0x0136
            java.lang.Object r5 = r2.next()
            com.didi.component.framework.pages.promo.model.CouponInfo r5 = (com.didi.component.framework.pages.promo.model.CouponInfo) r5
            java.lang.String r6 = r5.getCouponType()
            boolean r25 = r0.m9672a((java.lang.String) r6)
            java.lang.String r11 = r5.getCouponName()
            java.lang.Boolean r6 = r5.getCurrencyFirst()
            if (r6 != 0) goto L_0x00fd
            r13 = 0
            goto L_0x0102
        L_0x00fd:
            boolean r6 = r6.booleanValue()
            r13 = r6
        L_0x0102:
            java.lang.String r12 = r5.getDisCount()
            java.lang.String r14 = r5.getCurrencySymbol()
            java.lang.String r15 = r5.getCouponExpireTime()
            java.lang.String r16 = r5.getRemark()
            java.lang.String r19 = r5.getCouponValueFormat()
            com.didi.component.framework.pages.promo.model.PromoShareItem r5 = new com.didi.component.framework.pages.promo.model.PromoShareItem
            r7 = r5
            r8 = 3
            r9 = 0
            r10 = 0
            r17 = 0
            r18 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r26 = 128518(0x1f606, float:1.80092E-40)
            r27 = 0
            r7.<init>(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
            r1.add(r5)
            goto L_0x00dd
        L_0x0136:
            com.didi.component.core.IView r2 = r0.mView
            com.didi.component.framework.pages.promo.view.IPromoShareView r2 = (com.didi.component.framework.pages.promo.view.IPromoShareView) r2
            if (r2 != 0) goto L_0x013d
            goto L_0x0140
        L_0x013d:
            r2.initRecyclerView(r1)
        L_0x0140:
            com.didi.component.core.IView r1 = r0.mView
            com.didi.component.framework.pages.promo.view.IPromoShareView r1 = (com.didi.component.framework.pages.promo.view.IPromoShareView) r1
            if (r1 != 0) goto L_0x0147
            goto L_0x0152
        L_0x0147:
            java.util.List r2 = r29.getShareInfo()
            java.util.List r2 = r0.m9670a((java.util.List<com.didi.component.framework.pages.promo.model.PromoShareInfo>) r2)
            r1.showSomeShareChannel(r2)
        L_0x0152:
            com.didi.component.framework.pages.promo.model.ShareBannerInfo r1 = r29.getShareBannerInfo()
            java.lang.String r2 = "1"
            if (r1 != 0) goto L_0x015b
            goto L_0x0163
        L_0x015b:
            java.lang.String r1 = r1.getShareButton()
            if (r1 != 0) goto L_0x0162
            goto L_0x0163
        L_0x0162:
            r2 = r1
        L_0x0163:
            com.didi.component.core.IView r1 = r0.mView
            com.didi.component.framework.pages.promo.view.IPromoShareView r1 = (com.didi.component.framework.pages.promo.view.IPromoShareView) r1
            if (r1 != 0) goto L_0x016a
            goto L_0x018b
        L_0x016a:
            java.lang.String r5 = "0"
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r5)
            if (r2 == 0) goto L_0x0187
            java.util.List r2 = r29.getShareInfo()
            java.util.Collection r2 = (java.util.Collection) r2
            if (r2 == 0) goto L_0x0183
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x0181
            goto L_0x0183
        L_0x0181:
            r2 = 0
            goto L_0x0184
        L_0x0183:
            r2 = 1
        L_0x0184:
            if (r2 != 0) goto L_0x0187
            goto L_0x0188
        L_0x0187:
            r4 = 0
        L_0x0188:
            r1.isShowShareBottomView(r4)
        L_0x018b:
            java.util.List r1 = r29.getShareInfo()
            r0.m9673b(r1)
        L_0x0192:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.framework.pages.promo.presenter.PromoSharePresenter.generateRvItemAndOther(com.didi.component.framework.pages.promo.model.PromoData):void");
    }

    /* renamed from: a */
    private final boolean m9672a(String str) {
        return Intrinsics.areEqual((Object) str, (Object) "0") || Intrinsics.areEqual((Object) str, (Object) "100");
    }

    /* renamed from: a */
    private final List<PromoShareBtnModel> m9670a(List<PromoShareInfo> list) {
        List<PromoShareBtnModel> arrayList = new ArrayList<>();
        if (list != null) {
            int i = 0;
            for (Object next : list) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                PromoShareInfo promoShareInfo = (PromoShareInfo) next;
                if (i < 3) {
                    arrayList.add(new PromoShareBtnModel(promoShareInfo.getShareIcon(), m9669a(promoShareInfo)));
                }
                i = i2;
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    private final void m9673b(List<PromoShareInfo> list) {
        if (list != null) {
            for (PromoShareInfo a : list) {
                this.f13950b.add(m9669a(a));
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0007, code lost:
        r2 = r5.getChannel();
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.didi.onekeyshare.entity.OneKeyShareInfo m9669a(com.didi.component.framework.pages.promo.model.PromoShareInfo r5) {
        /*
            r4 = this;
            com.didi.component.framework.pages.promo.helper.MapToSharePlatform$Companion r0 = com.didi.component.framework.pages.promo.helper.MapToSharePlatform.Companion
            r1 = 0
            if (r5 != 0) goto L_0x0007
        L_0x0005:
            r2 = r1
            goto L_0x0016
        L_0x0007:
            java.lang.String r2 = r5.getChannel()
            if (r2 != 0) goto L_0x000e
            goto L_0x0005
        L_0x000e:
            int r2 = java.lang.Integer.parseInt(r2)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
        L_0x0016:
            com.didi.onekeyshare.entity.SharePlatform r0 = r0.getMapPlatform(r2)
            com.didi.onekeyshare.entity.OneKeyShareInfo r2 = new com.didi.onekeyshare.entity.OneKeyShareInfo
            r2.<init>()
            r2.platform = r0
            if (r5 != 0) goto L_0x0025
            r3 = r1
            goto L_0x0029
        L_0x0025:
            java.lang.String r3 = r5.getShareHeadImg()
        L_0x0029:
            r2.imageUrl = r3
            if (r5 != 0) goto L_0x002f
            r3 = r1
            goto L_0x0033
        L_0x002f:
            java.lang.String r3 = r5.getName()
        L_0x0033:
            r2.customName = r3
            if (r5 != 0) goto L_0x0039
            r3 = r1
            goto L_0x003d
        L_0x0039:
            java.lang.String r3 = r5.getShareUrl()
        L_0x003d:
            r2.url = r3
            if (r5 != 0) goto L_0x0043
            r3 = r1
            goto L_0x0047
        L_0x0043:
            java.lang.String r3 = r5.getShareTitle()
        L_0x0047:
            r2.title = r3
            if (r5 != 0) goto L_0x004c
            goto L_0x0050
        L_0x004c:
            java.lang.String r1 = r5.getShareSubTitle()
        L_0x0050:
            r2.content = r1
            com.didi.onekeyshare.entity.SharePlatform r5 = com.didi.onekeyshare.entity.SharePlatform.COPY_LINK_PLATFORM
            if (r0 == r5) goto L_0x005a
            com.didi.onekeyshare.entity.SharePlatform r5 = com.didi.onekeyshare.entity.SharePlatform.SYSTEM_MESSAGE
            if (r0 != r5) goto L_0x005d
        L_0x005a:
            r4.m9671a((com.didi.onekeyshare.entity.OneKeyShareInfo) r2)
        L_0x005d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.framework.pages.promo.presenter.PromoSharePresenter.m9669a(com.didi.component.framework.pages.promo.model.PromoShareInfo):com.didi.onekeyshare.entity.OneKeyShareInfo");
    }

    /* renamed from: a */
    private final void m9671a(OneKeyShareInfo oneKeyShareInfo) {
        if (!(oneKeyShareInfo.title == null || oneKeyShareInfo.content == null)) {
            String str = oneKeyShareInfo.content;
            Intrinsics.checkNotNullExpressionValue(str, "shareInfo.content");
            String str2 = oneKeyShareInfo.title;
            Intrinsics.checkNotNullExpressionValue(str2, "shareInfo.title");
            if (!StringsKt.startsWith$default(str, str2, false, 2, (Object) null)) {
                oneKeyShareInfo.content = oneKeyShareInfo.title + ' ' + oneKeyShareInfo.content;
            }
        }
        if (!(oneKeyShareInfo.content == null || oneKeyShareInfo.url == null)) {
            String str3 = oneKeyShareInfo.content;
            Intrinsics.checkNotNullExpressionValue(str3, "shareInfo.content");
            String str4 = oneKeyShareInfo.url;
            Intrinsics.checkNotNullExpressionValue(str4, "shareInfo.url");
            if (!StringsKt.endsWith$default(str3, str4, false, 2, (Object) null)) {
                oneKeyShareInfo.content += ' ' + oneKeyShareInfo.url;
            }
        }
        oneKeyShareInfo.smsMessage = oneKeyShareInfo.content;
    }
}
