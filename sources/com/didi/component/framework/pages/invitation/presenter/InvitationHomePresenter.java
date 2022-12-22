package com.didi.component.framework.pages.invitation.presenter;

import android.content.Context;
import android.content.Intent;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.UiUtils;
import com.didi.component.business.web.GlobalWebUrl;
import com.didi.component.common.GlobalWebActivity;
import com.didi.component.core.IPresenter;
import com.didi.component.framework.pages.invitation.helper.InvitePageController;
import com.didi.component.framework.pages.invitation.item.SwiperItem;
import com.didi.component.framework.pages.invitation.model.InviteCode;
import com.didi.component.framework.pages.invitation.model.RewardModel;
import com.didi.component.framework.pages.invitation.model.ShareChannelVo;
import com.didi.component.framework.pages.invitation.model.ShareUrlModel;
import com.didi.component.framework.pages.invitation.model.Swiper;
import com.didi.component.framework.pages.invitation.view.IInvitationHomeView;
import com.didi.onekeyshare.entity.SharePlatform;
import com.didi.sdk.app.BaseBusinessContext;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.app.BusinessContextManager;
import com.didi.sdk.misconfig.model.CountryInfo;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.util.GlobalCountryCode;
import com.didi.sharesdk.OneKeyShareModel;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo175977d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012J\u0010\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J0\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00192\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fJ(\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010\u00192\u0006\u0010&\u001a\u00020'J\u0015\u0010(\u001a\u00020!2\b\u0010)\u001a\u0004\u0018\u00010*¢\u0006\u0002\u0010+J\u0010\u0010,\u001a\u00020!2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J&\u0010-\u001a\u00020\u00172\b\u0010.\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0002J\u0001\u0010/\u001a\u00020!2\u0006\u00100\u001a\u00020\t2\b\u00101\u001a\u0004\u0018\u00010\t2\b\u00102\u001a\u0004\u0018\u00010\u00152\b\u00103\u001a\u0004\u0018\u00010\t2\b\u00104\u001a\u0004\u0018\u00010\t2\b\u0010)\u001a\u0004\u0018\u00010*2\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u00106\u001a\u0004\u0018\u00010*2(\b\u0002\u00107\u001a\"\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u000209\u0018\u000108j\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u000209\u0018\u0001`:¢\u0006\u0002\u0010;R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\r¨\u0006<"}, mo175978d2 = {"Lcom/didi/component/framework/pages/invitation/presenter/InvitationHomePresenter;", "Lcom/didi/component/core/IPresenter;", "Lcom/didi/component/framework/pages/invitation/view/IInvitationHomeView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "subTitle", "", "getSubTitle", "()Ljava/lang/String;", "setSubTitle", "(Ljava/lang/String;)V", "title", "getTitle", "setTitle", "calculateFinalHeight", "", "otherHeight", "convertToShareChannel", "", "shareInfo", "Lcom/didi/sharesdk/OneKeyShareModel;", "generateKeyShareInfoList", "", "list", "Lcom/didi/component/framework/pages/invitation/model/ShareChannelVo;", "urlModel", "Lcom/didi/component/framework/pages/invitation/model/ShareUrlModel;", "inviteCode", "Lcom/didi/component/framework/pages/invitation/model/InviteCode;", "generateRvItemAndInit", "", "rewardModel", "Lcom/didi/component/framework/pages/invitation/model/RewardModel;", "swiperList", "Lcom/didi/component/framework/pages/invitation/model/Swiper;", "isSingle", "", "goToTargetWeb", "activityId", "", "(Ljava/lang/Long;)V", "initInfoCopyLinkMsg", "mapPromoInfo2ShareInfo", "shareVo", "traceEvent", "event", "ticket", "channel", "country", "city", "shareChannel", "resourceId", "logParams", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Long;Ljava/util/HashMap;)V", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: InvitationHomePresenter.kt */
public final class InvitationHomePresenter extends IPresenter<IInvitationHomeView> {

    /* renamed from: a */
    private final Context f13920a;

    /* renamed from: b */
    private String f13921b = "";

    /* renamed from: c */
    private String f13922c = "";

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InvitationHomePresenter(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f13920a = context;
    }

    public final Context getContext() {
        return this.f13920a;
    }

    public final String getTitle() {
        return this.f13921b;
    }

    public final void setTitle(String str) {
        this.f13921b = str;
    }

    public final String getSubTitle() {
        return this.f13922c;
    }

    public final void setSubTitle(String str) {
        this.f13922c = str;
    }

    public final void generateRvItemAndInit(RewardModel rewardModel, List<Swiper> list, boolean z) {
        Boolean bool;
        String str;
        String str2;
        IInvitationHomeView iInvitationHomeView = (IInvitationHomeView) this.mView;
        if (iInvitationHomeView != null) {
            iInvitationHomeView.initTitleView();
        }
        List arrayList = new ArrayList();
        if (z) {
            String str3 = null;
            if (rewardModel == null) {
                bool = null;
            } else {
                bool = rewardModel.getCurrencyFirst();
            }
            if (rewardModel == null) {
                str = null;
            } else {
                str = rewardModel.getCurrencySymbol();
            }
            if (rewardModel == null) {
                str2 = null;
            } else {
                str2 = rewardModel.getRestAmountFormat();
            }
            if (rewardModel != null) {
                str3 = rewardModel.getReceivedAmountFormat();
            }
            arrayList.add(new SwiperItem((String) null, (String) null, (String) null, bool, str, str3, str2, 8, 7, (DefaultConstructorMarker) null));
        } else if (list != null) {
            for (Swiper swiper : list) {
                String swiperTitle = swiper.getSwiperTitle();
                int i = -1;
                int length = swiperTitle == null ? -1 : swiperTitle.length();
                String swiperContent = swiper.getSwiperContent();
                if (swiperContent != null) {
                    i = swiperContent.length();
                }
                String title = getTitle();
                Intrinsics.checkNotNull(title);
                if (length > title.length()) {
                    setTitle(swiper.getSwiperTitle());
                }
                String subTitle = getSubTitle();
                Intrinsics.checkNotNull(subTitle);
                if (i > subTitle.length()) {
                    setSubTitle(swiper.getSwiperContent());
                }
                arrayList.add(new SwiperItem(swiper.getSwiperCard(), swiper.getSwiperContent(), swiper.getSwiperTitle(), (Boolean) null, (String) null, (String) null, (String) null, 7, 120, (DefaultConstructorMarker) null));
            }
        }
        IInvitationHomeView iInvitationHomeView2 = (IInvitationHomeView) this.mView;
        if (iInvitationHomeView2 != null) {
            iInvitationHomeView2.initRecyclerView(arrayList);
        }
        IInvitationHomeView iInvitationHomeView3 = (IInvitationHomeView) this.mView;
        if (iInvitationHomeView3 != null) {
            iInvitationHomeView3.initInviteCodeView();
        }
        IInvitationHomeView iInvitationHomeView4 = (IInvitationHomeView) this.mView;
        if (iInvitationHomeView4 != null) {
            iInvitationHomeView4.initBottomView();
        }
    }

    public final void goToTargetWeb(Long l) {
        CountryInfo countryInfo;
        String countryIsoCode;
        BaseBusinessContext curBusinessContext = BusinessContextManager.getInstance().getCurBusinessContext();
        String str = "BR";
        if (!(curBusinessContext == null || !(curBusinessContext instanceof BusinessContext) || (countryInfo = ((BusinessContext) curBusinessContext).getCountryInfo()) == null || (countryIsoCode = countryInfo.getCountryIsoCode()) == null)) {
            str = countryIsoCode;
        }
        Locale locale = Locale.US;
        Intrinsics.checkNotNullExpressionValue(locale, GlobalCountryCode.AMERICA);
        Intrinsics.checkNotNullExpressionValue(str.toLowerCase(locale), "this as java.lang.String).toLowerCase(locale)");
        String str2 = "https://page.didiglobal.com/global/hulk/mgm/rule/index.html?activityId=" + l + "&activityLang=" + NationTypeUtil.getNationComponentData().getGLang() + "&countryCode=" + str;
        Intent intent = new Intent(this.f13920a, GlobalWebActivity.class);
        intent.putExtra("web_view_model", GlobalWebUrl.buildWebViewModel(str2));
        this.f13920a.startActivity(intent);
    }

    public final List<OneKeyShareModel> generateKeyShareInfoList(List<ShareChannelVo> list, ShareUrlModel shareUrlModel, InviteCode inviteCode) {
        List<OneKeyShareModel> arrayList = new ArrayList<>();
        if (list != null) {
            int i = 0;
            for (Object next : list) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                ShareChannelVo shareChannelVo = (ShareChannelVo) next;
                if (i >= 3) {
                    String shareChannel = shareChannelVo.getShareChannel();
                    if (!(shareChannel != null && Integer.parseInt(shareChannel) == 6)) {
                        i = i2;
                    }
                }
                arrayList.add(m9647a(shareChannelVo, shareUrlModel, inviteCode));
                i = i2;
            }
        }
        return arrayList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:106:0x017a, code lost:
        if (r3 == null) goto L_0x0120;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000b, code lost:
        r4 = r20.getShareChannel();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0119, code lost:
        if (r3 == null) goto L_0x00dc;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.didi.sharesdk.OneKeyShareModel m9647a(com.didi.component.framework.pages.invitation.model.ShareChannelVo r20, com.didi.component.framework.pages.invitation.model.ShareUrlModel r21, com.didi.component.framework.pages.invitation.model.InviteCode r22) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            com.didi.component.framework.pages.promo.helper.MapToSharePlatform$Companion r2 = com.didi.component.framework.pages.promo.helper.MapToSharePlatform.Companion
            r3 = 0
            if (r1 != 0) goto L_0x000b
        L_0x0009:
            r4 = r3
            goto L_0x001a
        L_0x000b:
            java.lang.String r4 = r20.getShareChannel()
            if (r4 != 0) goto L_0x0012
            goto L_0x0009
        L_0x0012:
            int r4 = java.lang.Integer.parseInt(r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
        L_0x001a:
            com.didi.onekeyshare.entity.SharePlatform r2 = r2.getMapPlatform(r4)
            com.didi.sharesdk.OneKeyShareModel r4 = new com.didi.sharesdk.OneKeyShareModel
            java.lang.String r5 = r2.platformName()
            r4.<init>(r5)
            r5 = 1
            r6 = 0
            if (r1 != 0) goto L_0x002d
        L_0x002b:
            r7 = 0
            goto L_0x003c
        L_0x002d:
            java.lang.String r7 = r20.getShareChannel()
            if (r7 != 0) goto L_0x0034
            goto L_0x002b
        L_0x0034:
            int r7 = java.lang.Integer.parseInt(r7)
            r8 = 6
            if (r7 != r8) goto L_0x002b
            r7 = 1
        L_0x003c:
            if (r7 == 0) goto L_0x007c
            java.lang.String r7 = r20.getContent()
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            if (r7 == 0) goto L_0x004e
            int r7 = r7.length()
            if (r7 != 0) goto L_0x004d
            goto L_0x004e
        L_0x004d:
            r5 = 0
        L_0x004e:
            if (r5 == 0) goto L_0x007c
            if (r22 != 0) goto L_0x0054
            r5 = r3
            goto L_0x0058
        L_0x0054:
            java.lang.String r5 = r22.getTitle()
        L_0x0058:
            r1.setTitle(r5)
            if (r22 != 0) goto L_0x005f
            r5 = r3
            goto L_0x0063
        L_0x005f:
            java.lang.String r5 = r22.getContent()
        L_0x0063:
            r1.setContent(r5)
            if (r22 != 0) goto L_0x006a
            r5 = r3
            goto L_0x006e
        L_0x006a:
            java.lang.String r5 = r22.getLinkType()
        L_0x006e:
            r1.setLinkType(r5)
            if (r22 != 0) goto L_0x0075
            r5 = r3
            goto L_0x0079
        L_0x0075:
            java.lang.String r5 = r22.getIcon()
        L_0x0079:
            r1.setIcon(r5)
        L_0x007c:
            if (r1 != 0) goto L_0x0080
            r5 = r3
            goto L_0x0084
        L_0x0080:
            java.lang.String r5 = r20.getShareName()
        L_0x0084:
            java.lang.String r6 = "&share_media="
            java.lang.String r5 = kotlin.jvm.internal.Intrinsics.stringPlus(r6, r5)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "?shareChannel="
            r6.append(r7)
            if (r1 != 0) goto L_0x0098
            r7 = r3
            goto L_0x009c
        L_0x0098:
            java.lang.String r7 = r20.getShareName()
        L_0x009c:
            r6.append(r7)
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            java.lang.String r6 = ""
            if (r1 != 0) goto L_0x00ac
        L_0x00aa:
            r7 = r6
            goto L_0x00b3
        L_0x00ac:
            java.lang.String r7 = r20.getIcon()
            if (r7 != 0) goto L_0x00b3
            goto L_0x00aa
        L_0x00b3:
            r4.imgUrl = r7
            if (r1 != 0) goto L_0x00b9
            r7 = r3
            goto L_0x00bd
        L_0x00b9:
            java.lang.String r7 = r20.getLinkType()
        L_0x00bd:
            java.lang.String r8 = "1"
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r8)
            if (r7 == 0) goto L_0x00cd
            if (r21 != 0) goto L_0x00c8
            goto L_0x00d4
        L_0x00c8:
            java.lang.String r3 = r21.getShareUrl()
            goto L_0x00d4
        L_0x00cd:
            if (r21 != 0) goto L_0x00d0
            goto L_0x00d4
        L_0x00d0:
            java.lang.String r3 = r21.getDownloadUrl()
        L_0x00d4:
            java.lang.String r3 = kotlin.jvm.internal.Intrinsics.stringPlus(r3, r5)
            r4.url = r3
            if (r1 != 0) goto L_0x00de
        L_0x00dc:
            r3 = r6
            goto L_0x011c
        L_0x00de:
            java.lang.String r7 = r20.getTitle()
            if (r7 != 0) goto L_0x00e5
            goto L_0x00dc
        L_0x00e5:
            if (r21 != 0) goto L_0x00e9
        L_0x00e7:
            r9 = r6
            goto L_0x00f1
        L_0x00e9:
            java.lang.String r3 = r21.getUserName()
            if (r3 != 0) goto L_0x00f0
            goto L_0x00e7
        L_0x00f0:
            r9 = r3
        L_0x00f1:
            r10 = 0
            r11 = 4
            r12 = 0
            java.lang.String r8 = "[referer.name]"
            java.lang.String r13 = kotlin.text.StringsKt.replace$default((java.lang.String) r7, (java.lang.String) r8, (java.lang.String) r9, (boolean) r10, (int) r11, (java.lang.Object) r12)
            if (r13 != 0) goto L_0x00fd
            goto L_0x00dc
        L_0x00fd:
            com.didi.component.core.IView r3 = r0.mView
            com.didi.component.framework.pages.invitation.view.IInvitationHomeView r3 = (com.didi.component.framework.pages.invitation.view.IInvitationHomeView) r3
            if (r3 != 0) goto L_0x0105
        L_0x0103:
            r15 = r6
            goto L_0x010d
        L_0x0105:
            java.lang.String r3 = r3.gotRefereeMoney()
            if (r3 != 0) goto L_0x010c
            goto L_0x0103
        L_0x010c:
            r15 = r3
        L_0x010d:
            r16 = 0
            r17 = 4
            r18 = 0
            java.lang.String r14 = "[referree.money]"
            java.lang.String r3 = kotlin.text.StringsKt.replace$default((java.lang.String) r13, (java.lang.String) r14, (java.lang.String) r15, (boolean) r16, (int) r17, (java.lang.Object) r18)
            if (r3 != 0) goto L_0x011c
            goto L_0x00dc
        L_0x011c:
            r4.title = r3
            if (r1 != 0) goto L_0x0123
        L_0x0120:
            r3 = r6
            goto L_0x017d
        L_0x0123:
            java.lang.String r7 = r20.getContent()
            if (r7 != 0) goto L_0x012a
            goto L_0x0120
        L_0x012a:
            if (r21 != 0) goto L_0x012e
        L_0x012c:
            r9 = r6
            goto L_0x0136
        L_0x012e:
            java.lang.String r3 = r21.getUserName()
            if (r3 != 0) goto L_0x0135
            goto L_0x012c
        L_0x0135:
            r9 = r3
        L_0x0136:
            r10 = 0
            r11 = 4
            r12 = 0
            java.lang.String r8 = "[referer.name]"
            java.lang.String r13 = kotlin.text.StringsKt.replace$default((java.lang.String) r7, (java.lang.String) r8, (java.lang.String) r9, (boolean) r10, (int) r11, (java.lang.Object) r12)
            if (r13 != 0) goto L_0x0142
            goto L_0x0120
        L_0x0142:
            com.didi.component.core.IView r3 = r0.mView
            com.didi.component.framework.pages.invitation.view.IInvitationHomeView r3 = (com.didi.component.framework.pages.invitation.view.IInvitationHomeView) r3
            if (r3 != 0) goto L_0x014a
        L_0x0148:
            r15 = r6
            goto L_0x0152
        L_0x014a:
            java.lang.String r3 = r3.gotRefereeMoney()
            if (r3 != 0) goto L_0x0151
            goto L_0x0148
        L_0x0151:
            r15 = r3
        L_0x0152:
            r16 = 0
            r17 = 4
            r18 = 0
            java.lang.String r14 = "[referree.money]"
            java.lang.String r7 = kotlin.text.StringsKt.replace$default((java.lang.String) r13, (java.lang.String) r14, (java.lang.String) r15, (boolean) r16, (int) r17, (java.lang.Object) r18)
            if (r7 != 0) goto L_0x0161
            goto L_0x0120
        L_0x0161:
            com.didi.component.core.IView r3 = r0.mView
            com.didi.component.framework.pages.invitation.view.IInvitationHomeView r3 = (com.didi.component.framework.pages.invitation.view.IInvitationHomeView) r3
            if (r3 != 0) goto L_0x0169
        L_0x0167:
            r9 = r6
            goto L_0x0171
        L_0x0169:
            java.lang.String r3 = r3.gotPromoCode()
            if (r3 != 0) goto L_0x0170
            goto L_0x0167
        L_0x0170:
            r9 = r3
        L_0x0171:
            r10 = 0
            r11 = 4
            r12 = 0
            java.lang.String r8 = "[promo code]"
            java.lang.String r3 = kotlin.text.StringsKt.replace$default((java.lang.String) r7, (java.lang.String) r8, (java.lang.String) r9, (boolean) r10, (int) r11, (java.lang.Object) r12)
            if (r3 != 0) goto L_0x017d
            goto L_0x0120
        L_0x017d:
            r4.content = r3
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            r5 = r3
            java.util.Map r5 = (java.util.Map) r5
            if (r1 != 0) goto L_0x018b
        L_0x0189:
            r7 = r6
            goto L_0x0192
        L_0x018b:
            java.lang.String r7 = r20.getShareIcon()
            if (r7 != 0) goto L_0x0192
            goto L_0x0189
        L_0x0192:
            java.lang.String r8 = "shareIcon"
            r5.put(r8, r7)
            if (r1 != 0) goto L_0x019b
        L_0x0199:
            r7 = r6
            goto L_0x01a2
        L_0x019b:
            java.lang.String r7 = r20.getRoundShareIcon()
            if (r7 != 0) goto L_0x01a2
            goto L_0x0199
        L_0x01a2:
            java.lang.String r8 = "shareIconRound"
            r5.put(r8, r7)
            if (r1 != 0) goto L_0x01aa
            goto L_0x01b2
        L_0x01aa:
            java.lang.String r1 = r20.getShareIconMark()
            if (r1 != 0) goto L_0x01b1
            goto L_0x01b2
        L_0x01b1:
            r6 = r1
        L_0x01b2:
            java.lang.String r1 = "shareIconMark"
            r5.put(r1, r6)
            r4.extra = r3
            com.didi.onekeyshare.entity.SharePlatform r1 = com.didi.onekeyshare.entity.SharePlatform.COPY_LINK_PLATFORM
            if (r2 != r1) goto L_0x01c0
            r0.m9648a(r4)
        L_0x01c0:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.framework.pages.invitation.presenter.InvitationHomePresenter.m9647a(com.didi.component.framework.pages.invitation.model.ShareChannelVo, com.didi.component.framework.pages.invitation.model.ShareUrlModel, com.didi.component.framework.pages.invitation.model.InviteCode):com.didi.sharesdk.OneKeyShareModel");
    }

    public final float calculateFinalHeight(float f) {
        int dip2px = UiUtils.dip2px(this.f13920a, 28.0f);
        int dip2px2 = UiUtils.dip2px(this.f13920a, 14.0f);
        InvitePageController.Companion companion = InvitePageController.Companion;
        String str = this.f13921b;
        Intrinsics.checkNotNull(str);
        float computeHeight = companion.computeHeight(dip2px, dip2px2, str, (float) UiUtils.dip2px(this.f13920a, 280.0f));
        InvitePageController.Companion companion2 = InvitePageController.Companion;
        String str2 = this.f13922c;
        Intrinsics.checkNotNull(str2);
        return f + companion2.computeHeight(0, dip2px2, str2, (float) UiUtils.dip2px(this.f13920a, 280.0f)) + computeHeight;
    }

    public final int convertToShareChannel(OneKeyShareModel oneKeyShareModel) {
        String platform = oneKeyShareModel == null ? null : oneKeyShareModel.getPlatform();
        if (Intrinsics.areEqual((Object) platform, (Object) SharePlatform.WHATSAPP_PLATFORM.platformName())) {
            return 1;
        }
        if (Intrinsics.areEqual((Object) platform, (Object) SharePlatform.FACEBOOK_PLATFORM.platformName())) {
            return 2;
        }
        if (Intrinsics.areEqual((Object) platform, (Object) SharePlatform.TWITTER_PLATFORM.platformName())) {
            return 3;
        }
        if (Intrinsics.areEqual((Object) platform, (Object) SharePlatform.COPY_LINK_PLATFORM.platformName())) {
            return 4;
        }
        if (Intrinsics.areEqual((Object) platform, (Object) SharePlatform.LINE_PLATFORM.platformName())) {
            return 5;
        }
        if (Intrinsics.areEqual((Object) platform, (Object) SharePlatform.MESSENGER_PLATFORM.platformName())) {
            return 6;
        }
        if (Intrinsics.areEqual((Object) platform, (Object) SharePlatform.EMAIL_PLATFORM.platformName())) {
            return 8;
        }
        if (Intrinsics.areEqual((Object) platform, (Object) SharePlatform.SYSTEM_MESSAGE.platformName())) {
            return 9;
        }
        return Intrinsics.areEqual((Object) platform, (Object) SharePlatform.VK_PLATFORM.platformName()) ? 10 : 7;
    }

    public static /* synthetic */ void traceEvent$default(InvitationHomePresenter invitationHomePresenter, String str, String str2, Integer num, String str3, String str4, Long l, Integer num2, Long l2, HashMap hashMap, int i, Object obj) {
        int i2 = i;
        invitationHomePresenter.traceEvent(str, str2, num, str3, str4, l, (i2 & 64) != 0 ? null : num2, (i2 & 128) != 0 ? null : l2, (i2 & 256) != 0 ? null : hashMap);
    }

    public final void traceEvent(String str, String str2, Integer num, String str3, String str4, Long l, Integer num2, Long l2, HashMap<String, Object> hashMap) {
        Intrinsics.checkNotNullParameter(str, "event");
        HashMap hashMap2 = new HashMap();
        Map map = hashMap2;
        map.put("ticket", str2);
        map.put("channel", num);
        map.put("location_country", str3);
        map.put("location_city", str4);
        map.put("activity_id", l);
        if (l2 != null) {
            map.put("resource_id", l2);
        }
        if (num2 != null) {
            map.put(ParamConst.PARAM_SHARE_CHANNEL, num2);
        }
        if (hashMap != null) {
            Map map2 = hashMap;
            if (!map2.isEmpty()) {
                hashMap2.putAll(map2);
            }
        }
        GlobalOmegaUtils.trackEvent(str, (Map<String, Object>) map);
    }

    /* renamed from: a */
    private final void m9648a(OneKeyShareModel oneKeyShareModel) {
        if (!(oneKeyShareModel.title == null || oneKeyShareModel.content == null)) {
            String str = oneKeyShareModel.content;
            Intrinsics.checkNotNullExpressionValue(str, "shareInfo.content");
            String str2 = oneKeyShareModel.title;
            Intrinsics.checkNotNullExpressionValue(str2, "shareInfo.title");
            if (!StringsKt.startsWith$default(str, str2, false, 2, (Object) null)) {
                oneKeyShareModel.content = oneKeyShareModel.title + ' ' + oneKeyShareModel.content;
            }
        }
        if (!(oneKeyShareModel.content == null || oneKeyShareModel.url == null)) {
            String str3 = oneKeyShareModel.content;
            Intrinsics.checkNotNullExpressionValue(str3, "shareInfo.content");
            String str4 = oneKeyShareModel.url;
            Intrinsics.checkNotNullExpressionValue(str4, "shareInfo.url");
            if (!StringsKt.endsWith$default(str3, str4, false, 2, (Object) null)) {
                oneKeyShareModel.content += ' ' + oneKeyShareModel.url;
            }
        }
        oneKeyShareModel.smsMessage = oneKeyShareModel.content;
    }
}
