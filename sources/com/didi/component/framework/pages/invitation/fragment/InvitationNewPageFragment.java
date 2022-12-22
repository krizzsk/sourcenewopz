package com.didi.component.framework.pages.invitation.fragment;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.util.NationComponentDataUtil;
import com.didi.component.business.util.UiUtils;
import com.didi.component.common.widget.CircleImageView;
import com.didi.component.framework.pages.invitation.InvitationPageActivity;
import com.didi.component.framework.pages.invitation.helper.ToastHelperKt;
import com.didi.component.framework.pages.invitation.helper.TrackEvent;
import com.didi.component.framework.pages.invitation.item.SwiperItem;
import com.didi.component.framework.pages.invitation.model.InviteCode;
import com.didi.component.framework.pages.invitation.model.InviteTheme;
import com.didi.component.framework.pages.invitation.model.LunBoConfig;
import com.didi.component.framework.pages.invitation.model.LunBoItemInfo;
import com.didi.component.framework.pages.invitation.model.PageData;
import com.didi.component.framework.pages.invitation.model.Recommend;
import com.didi.component.framework.pages.invitation.model.RedirectModel;
import com.didi.component.framework.pages.invitation.model.RewardModel;
import com.didi.component.framework.pages.invitation.model.ShareChannelVo;
import com.didi.component.framework.pages.invitation.model.SharePage;
import com.didi.component.framework.pages.invitation.model.ShareUrlModel;
import com.didi.component.framework.pages.invitation.model.Swiper;
import com.didi.component.framework.pages.invitation.presenter.InvitationHomePresenter;
import com.didi.component.framework.pages.invitation.view.IInvitationNewHomeView;
import com.didi.component.framework.pages.promo.helper.MapToSharePlatform;
import com.didi.dcrypto.util.ColorUtils;
import com.didi.global.ninja.Ninja;
import com.didi.onekeyshare.ShareBuilder;
import com.didi.onekeyshare.callback.ICallback;
import com.didi.onekeyshare.callback.intercept.IShareDialogIntercept;
import com.didi.onekeyshare.entity.ShareInfo;
import com.didi.onekeyshare.entity.SharePlatform;
import com.didi.sdk.home.BizEntranceFragment;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sharesdk.OneKeyShareModel;
import com.didi.sharesdk.ShareApi;
import com.didiglobal.font.GlobalPassangerTextView;
import com.taxis99.R;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import rui.config.RConfigConstants;

@Metadata(mo175977d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 P2\u00020\u00012\u00020\u0002:\u0001PB\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0002J\u0010\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\bH\u0002J\u0018\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\n2\u0006\u0010/\u001a\u00020\nH\u0002J\b\u00100\u001a\u00020\nH\u0016J\b\u00101\u001a\u00020\nH\u0016J\b\u00102\u001a\u00020\nH\u0016J\b\u00103\u001a\u00020&H\u0016J\b\u00104\u001a\u00020&H\u0016J\b\u00105\u001a\u00020&H\u0016J\b\u00106\u001a\u00020&H\u0016J\b\u00107\u001a\u00020&H\u0016J\b\u00108\u001a\u00020&H\u0016J\b\u00109\u001a\u00020&H\u0002J\u0012\u0010:\u001a\u00020&2\b\u0010;\u001a\u0004\u0018\u00010\u001bH\u0016J&\u0010<\u001a\u0004\u0018\u00010\u001b2\u0006\u0010=\u001a\u00020>2\b\u0010?\u001a\u0004\u0018\u00010@2\b\u0010A\u001a\u0004\u0018\u00010BH\u0016J\b\u0010C\u001a\u00020&H\u0016J\u0010\u0010D\u001a\u00020&2\b\u0010E\u001a\u0004\u0018\u00010FJ\u0012\u0010G\u001a\u00020&2\b\u0010H\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010I\u001a\u00020&H\u0016J\u0012\u0010J\u001a\u00020&2\b\u0010K\u001a\u0004\u0018\u00010FH\u0002J-\u0010L\u001a\u00020&2\u0006\u0010M\u001a\u00020\n2\n\b\u0002\u0010N\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0002\u0010OR\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R.\u0010\u0012\u001a\"\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013j\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0014\u0018\u0001`\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010!\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\"\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000¨\u0006Q"}, mo175978d2 = {"Lcom/didi/component/framework/pages/invitation/fragment/InvitationNewPageFragment;", "Lcom/didi/sdk/home/BizEntranceFragment;", "Lcom/didi/component/framework/pages/invitation/view/IInvitationNewHomeView;", "()V", "activityId", "", "Ljava/lang/Long;", "channel", "", "cityName", "", "country", "handler", "Landroid/os/Handler;", "isFirst", "", "isLunbo", "isShareContact", "logParams", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "mListener", "Lcom/didi/component/framework/pages/invitation/fragment/IInvitationListener;", "mPresenter", "Lcom/didi/component/framework/pages/invitation/presenter/InvitationHomePresenter;", "mRootView", "Landroid/view/View;", "mWidth", "pageInfo", "Lcom/didi/component/framework/pages/invitation/model/PageData;", "refereeMoney", "refererMoney", "resourceId", "symbol", "themeData", "Lcom/didi/component/framework/pages/invitation/model/InviteTheme;", "copyText", "", "inviteCode", "Lcom/didi/component/framework/pages/invitation/model/InviteCode;", "createBannerBg", "Landroid/graphics/drawable/Drawable;", "color", "createBannerText", "Landroid/text/SpannableString;", "text", "money", "gotPromoCode", "gotRefereeMoney", "gotRefererMoney", "initBanner", "initHeadView", "initIntroductionView", "initRewardView", "initShareView", "initTermsView", "initView", "onClick", "v", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "performShareChannelClick", "shareInfo", "Lcom/didi/sharesdk/OneKeyShareModel;", "setPresenter", "p0", "showCopyToastView", "showShareDialog", "smsChannel", "traceOmegaEvent", "event", "shareChannel", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;)V", "Companion", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: InvitationNewPageFragment.kt */
public final class InvitationNewPageFragment extends BizEntranceFragment implements IInvitationNewHomeView {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: t */
    public static final String f13812t = "{{referrer_name}}";
    /* access modifiers changed from: private */

    /* renamed from: u */
    public static final String f13813u = "{{referrer_reward}}";

    /* renamed from: a */
    private View f13814a;

    /* renamed from: b */
    private int f13815b;

    /* renamed from: c */
    private InvitationHomePresenter f13816c;

    /* renamed from: d */
    private IInvitationListener f13817d;

    /* renamed from: e */
    private String f13818e = "";

    /* renamed from: f */
    private Long f13819f = 0L;

    /* renamed from: g */
    private Long f13820g = 0L;

    /* renamed from: h */
    private int f13821h = 2;

    /* renamed from: i */
    private String f13822i = "";

    /* renamed from: j */
    private HashMap<String, Object> f13823j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public PageData f13824k;

    /* renamed from: l */
    private InviteTheme f13825l;

    /* renamed from: m */
    private String f13826m = "";

    /* renamed from: n */
    private String f13827n = "";
    /* access modifiers changed from: private */

    /* renamed from: o */
    public Handler f13828o;

    /* renamed from: p */
    private boolean f13829p;

    /* renamed from: q */
    private boolean f13830q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public boolean f13831r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public String f13832s = "";

    public void _$_clearFindViewByIdCache() {
    }

    public void setPresenter(InvitationHomePresenter invitationHomePresenter) {
    }

    public void initBottomView() {
        IInvitationNewHomeView.DefaultImpls.initBottomView(this);
    }

    public void initInviteCodeView() {
        IInvitationNewHomeView.DefaultImpls.initInviteCodeView(this);
    }

    public void initRecyclerView(List<SwiperItem> list) {
        IInvitationNewHomeView.DefaultImpls.initRecyclerView(this, list);
    }

    public void initTitleView() {
        IInvitationNewHomeView.DefaultImpls.initTitleView(this);
    }

    @Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fR\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\r"}, mo175978d2 = {"Lcom/didi/component/framework/pages/invitation/fragment/InvitationNewPageFragment$Companion;", "", "()V", "REFERRER_NAME", "", "getREFERRER_NAME", "()Ljava/lang/String;", "REFERRER_REWARD", "getREFERRER_REWARD", "newInstance", "Landroidx/fragment/app/Fragment;", "bundle", "Landroid/os/Bundle;", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: InvitationNewPageFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getREFERRER_NAME() {
            return InvitationNewPageFragment.f13812t;
        }

        public final String getREFERRER_REWARD() {
            return InvitationNewPageFragment.f13813u;
        }

        public final Fragment newInstance(Bundle bundle) {
            InvitationNewPageFragment invitationNewPageFragment = new InvitationNewPageFragment();
            invitationNewPageFragment.setArguments(bundle);
            return invitationNewPageFragment;
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        this.f13814a = layoutInflater.inflate(R.layout.global_fragment_invite_new_page, viewGroup, false);
        m9592a();
        m9593a(this, TrackEvent.REFERHOME_SW, (Integer) null, this.f13820g, 2, (Object) null);
        return this.f13814a;
    }

    public void onDestroy() {
        super.onDestroy();
        Handler handler = this.f13828o;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
    }

    public void onClick(View view) {
        InvitationHomePresenter invitationHomePresenter;
        AutoTrackHelper.trackViewOnClick(view);
        InviteCode inviteCode = null;
        Integer valueOf = view == null ? null : Integer.valueOf(view.getId());
        if (valueOf != null && valueOf.intValue() == R.id.invite_share_module_copy_btn) {
            PageData pageData = this.f13824k;
            if (pageData != null) {
                inviteCode = pageData.getInviteCode();
            }
            m9595a(inviteCode);
        } else if (valueOf != null && valueOf.intValue() == R.id.invite_reward_module_see_details) {
            IInvitationListener iInvitationListener = this.f13817d;
            if (iInvitationListener != null) {
                iInvitationListener.switchToTargetPage(InvitationPageActivity.TRACK);
            }
            m9593a(this, TrackEvent.REFERHOME_TRACK_CK, (Integer) null, this.f13820g, 2, (Object) null);
        } else if (valueOf != null && valueOf.intValue() == R.id.invite_terms_module_use && (invitationHomePresenter = this.f13816c) != null) {
            invitationHomePresenter.goToTargetWeb(this.f13819f);
        }
    }

    /* renamed from: a */
    private final void m9592a() {
        String str;
        String str2;
        String str3;
        RedirectModel redirectModel;
        String rebateAmountFormat;
        RedirectModel redirectModel2;
        RedirectModel redirectModel3;
        Boolean currencyFirst;
        RedirectModel redirectModel4;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        InvitationHomePresenter invitationHomePresenter = new InvitationHomePresenter(requireActivity);
        this.f13816c = invitationHomePresenter;
        if (invitationHomePresenter != null) {
            invitationHomePresenter.setIView(this);
        }
        this.f13817d = (IInvitationListener) requireActivity();
        this.f13815b = UiUtils.getWindowWidth(requireActivity());
        Bundle arguments = getArguments();
        InviteTheme inviteTheme = null;
        this.f13818e = arguments == null ? null : arguments.getString("country");
        Bundle arguments2 = getArguments();
        this.f13819f = arguments2 == null ? null : Long.valueOf(arguments2.getLong("activityId"));
        Bundle arguments3 = getArguments();
        this.f13820g = arguments3 == null ? null : Long.valueOf(arguments3.getLong(InvitationPageActivity.RESOURCE_ID));
        Bundle arguments4 = getArguments();
        this.f13821h = arguments4 == null ? 2 : arguments4.getInt("channel");
        Bundle arguments5 = getArguments();
        String str4 = "";
        if (arguments5 == null || (str = arguments5.getString(InvitationPageActivity.CITY_NAME)) == null) {
            str = str4;
        }
        this.f13822i = str;
        Bundle arguments6 = getArguments();
        boolean z = false;
        this.f13829p = arguments6 == null ? false : arguments6.getBoolean(InvitationPageActivity.SHOW_BANNER, false);
        Bundle arguments7 = getArguments();
        this.f13830q = arguments7 == null ? false : arguments7.getBoolean(InvitationPageActivity.SHOW_CONTACTS, false);
        Bundle arguments8 = getArguments();
        this.f13823j = (HashMap) (arguments8 == null ? null : arguments8.getSerializable(InvitationPageActivity.LOG_PARAMS));
        IInvitationListener iInvitationListener = this.f13817d;
        this.f13824k = iInvitationListener == null ? null : iInvitationListener.getPageInfo();
        IInvitationListener iInvitationListener2 = this.f13817d;
        if (iInvitationListener2 != null) {
            inviteTheme = iInvitationListener2.getThemeInfo();
        }
        this.f13825l = inviteTheme;
        PageData pageData = this.f13824k;
        if (pageData == null || (redirectModel4 = pageData.getRedirectModel()) == null || (str2 = redirectModel4.getCurrencySymbol()) == null) {
            str2 = str4;
        }
        this.f13832s = str2;
        PageData pageData2 = this.f13824k;
        if (!(pageData2 == null || (redirectModel3 = pageData2.getRedirectModel()) == null || (currencyFirst = redirectModel3.getCurrencyFirst()) == null)) {
            z = currencyFirst.booleanValue();
        }
        this.f13831r = z;
        PageData pageData3 = this.f13824k;
        if (pageData3 == null || (redirectModel2 = pageData3.getRedirectModel()) == null || (str3 = redirectModel2.getRewardAmountFormat()) == null) {
            str3 = str4;
        }
        PageData pageData4 = this.f13824k;
        if (!(pageData4 == null || (redirectModel = pageData4.getRedirectModel()) == null || (rebateAmountFormat = redirectModel.getRebateAmountFormat()) == null)) {
            str4 = rebateAmountFormat;
        }
        this.f13826m = !this.f13831r ? Intrinsics.stringPlus(this.f13832s, str3) : Intrinsics.stringPlus(str3, this.f13832s);
        this.f13827n = !this.f13831r ? Intrinsics.stringPlus(this.f13832s, str4) : Intrinsics.stringPlus(str4, this.f13832s);
        initHeadView();
        initBanner();
        initRewardView();
        initIntroductionView();
        initShareView();
        initTermsView();
    }

    public void initHeadView() {
        String str;
        String str2;
        Recommend recommend;
        SharePage sharePage;
        String referSubtitle;
        String replace$default;
        Recommend recommend2;
        SharePage sharePage2;
        String referTitle;
        String replace$default2;
        View view = this.f13814a;
        if (view != null) {
            view.findViewById(R.id.invite_head_module_layout);
        }
        View view2 = this.f13814a;
        String str3 = null;
        TextView textView = view2 == null ? null : (TextView) view2.findViewById(R.id.invite_head_module_title);
        View view3 = this.f13814a;
        TextView textView2 = view3 == null ? null : (TextView) view3.findViewById(R.id.invite_head_module_subtitle);
        View view4 = this.f13814a;
        ImageView imageView = view4 == null ? null : (ImageView) view4.findViewById(R.id.invite_head_module_img);
        InviteTheme inviteTheme = this.f13825l;
        if (inviteTheme == null || (recommend2 = inviteTheme.getRecommend()) == null || (sharePage2 = recommend2.getSharePage()) == null || (referTitle = sharePage2.getReferTitle()) == null || (replace$default2 = StringsKt.replace$default(referTitle, (String) InvitationPageFragment.REFEREE_MONEY, this.f13826m, false, 4, (Object) null)) == null) {
            str = null;
        } else {
            str = StringsKt.replace$default(replace$default2, InvitationPageFragment.REFERER_MONEY, this.f13827n, false, 4, (Object) null);
        }
        InviteTheme inviteTheme2 = this.f13825l;
        if (inviteTheme2 == null || (recommend = inviteTheme2.getRecommend()) == null || (sharePage = recommend.getSharePage()) == null || (referSubtitle = sharePage.getReferSubtitle()) == null || (replace$default = StringsKt.replace$default(referSubtitle, (String) InvitationPageFragment.REFERER_MONEY, this.f13827n, false, 4, (Object) null)) == null) {
            str2 = null;
        } else {
            str2 = StringsKt.replace$default(replace$default, InvitationPageFragment.REFEREE_MONEY, this.f13826m, false, 4, (Object) null);
        }
        if (textView != null) {
            textView.setText(str);
        }
        if (textView2 != null) {
            textView2.setText(str2);
        }
        RequestManager with = Glide.with((Fragment) this);
        PageData pageData = this.f13824k;
        if (pageData != null) {
            str3 = pageData.getBannerPic();
        }
        Intrinsics.checkNotNull(imageView);
        ((RequestBuilder) with.load(str3).placeholder((Drawable) new ColorDrawable(Color.parseColor(ColorUtils.DIDI_GREY)))).into(imageView);
    }

    public void initBanner() {
        LunBoConfig lunboConfig;
        String bgColor;
        LunBoConfig lunboConfig2;
        Long configTime;
        LunBoConfig lunboConfig3;
        Ref.IntRef intRef = new Ref.IntRef();
        View view = this.f13814a;
        ViewSwitcher viewSwitcher = null;
        LinearLayout linearLayout = view == null ? null : (LinearLayout) view.findViewById(R.id.invite_banner_module);
        PageData pageData = this.f13824k;
        List<LunBoItemInfo> lunboUserList = (pageData == null || (lunboConfig3 = pageData.getLunboConfig()) == null) ? null : lunboConfig3.getLunboUserList();
        if (lunboUserList != null && lunboUserList.size() != 0 && this.f13829p) {
            PageData pageData2 = this.f13824k;
            long j = 1;
            if (!(pageData2 == null || (lunboConfig2 = pageData2.getLunboConfig()) == null || (configTime = lunboConfig2.getConfigTime()) == null)) {
                j = configTime.longValue();
            }
            PageData pageData3 = this.f13824k;
            String str = "007A40";
            if (!(pageData3 == null || (lunboConfig = pageData3.getLunboConfig()) == null || (bgColor = lunboConfig.getBgColor()) == null)) {
                str = bgColor;
            }
            if (linearLayout != null) {
                linearLayout.setBackground(m9589a(Color.parseColor(Intrinsics.stringPlus(RConfigConstants.KEYWORD_COLOR_SIGN, str))));
            }
            View view2 = this.f13814a;
            if (view2 != null) {
                viewSwitcher = (ViewSwitcher) view2.findViewById(R.id.invite_banner_module_switcher);
            }
            if (viewSwitcher != null) {
                viewSwitcher.setInAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.global_invite_banner_in_anim));
            }
            if (viewSwitcher != null) {
                viewSwitcher.setOutAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.global_invite_banner_out_anim));
            }
            if (viewSwitcher != null) {
                viewSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
                    public final View makeView() {
                        return InvitationNewPageFragment.m9591a(InvitationNewPageFragment.this);
                    }
                });
            }
            this.f13828o = new Handler(Looper.getMainLooper());
            InvitationNewPageFragment$initBanner$runnable$1 invitationNewPageFragment$initBanner$runnable$1 = new InvitationNewPageFragment$initBanner$runnable$1(viewSwitcher, intRef, lunboUserList, this, j);
            Handler handler = this.f13828o;
            if (handler != null) {
                handler.post(invitationNewPageFragment$initBanner$runnable$1);
            }
        } else if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final View m9591a(InvitationNewPageFragment invitationNewPageFragment) {
        Intrinsics.checkNotNullParameter(invitationNewPageFragment, "this$0");
        GlobalPassangerTextView globalPassangerTextView = new GlobalPassangerTextView(invitationNewPageFragment.getContext());
        globalPassangerTextView.setGravity(16);
        globalPassangerTextView.setLayoutParams(new FrameLayout.LayoutParams(-1, UiUtils.dip2px(invitationNewPageFragment.getContext(), 28.0f)));
        globalPassangerTextView.setTextSize(12.0f);
        globalPassangerTextView.setTextColor(Color.parseColor("#FFFFFFFF"));
        return globalPassangerTextView;
    }

    public void initShareView() {
        String str;
        ShareChannelVo shareChannelVo;
        List<OneKeyShareModel> list;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        Object obj;
        boolean z;
        PageData pageInfo;
        View view = this.f13814a;
        if (view != null) {
            view.findViewById(R.id.invite_share_module_layout);
        }
        View view2 = this.f13814a;
        AppCompatTextView appCompatTextView = view2 == null ? null : (AppCompatTextView) view2.findViewById(R.id.invite_share_module_invite_code);
        View view3 = this.f13814a;
        AppCompatTextView appCompatTextView2 = view3 == null ? null : (AppCompatTextView) view3.findViewById(R.id.invite_share_module_copy_btn);
        View view4 = this.f13814a;
        CircleImageView circleImageView = view4 == null ? null : (CircleImageView) view4.findViewById(R.id.invite_share_module_ll_img);
        View view5 = this.f13814a;
        TextView textView = view5 == null ? null : (TextView) view5.findViewById(R.id.invite_share_module_ll_tv);
        View view6 = this.f13814a;
        CircleImageView circleImageView2 = view6 == null ? null : (CircleImageView) view6.findViewById(R.id.invite_share_module_lm_img);
        View view7 = this.f13814a;
        TextView textView2 = view7 == null ? null : (TextView) view7.findViewById(R.id.invite_share_module_lm_tv);
        View view8 = this.f13814a;
        CircleImageView circleImageView3 = view8 == null ? null : (CircleImageView) view8.findViewById(R.id.invite_share_module_mr_img);
        View view9 = this.f13814a;
        TextView textView3 = view9 == null ? null : (TextView) view9.findViewById(R.id.invite_share_module_mr_tv);
        View view10 = this.f13814a;
        CircleImageView circleImageView4 = view10 == null ? null : (CircleImageView) view10.findViewById(R.id.invite_share_module_rr_img);
        View view11 = this.f13814a;
        if (view11 != null) {
            TextView textView4 = (TextView) view11.findViewById(R.id.invite_share_module_rr_tv);
        }
        ViewExKt.text(appCompatTextView, gotPromoCode());
        if (appCompatTextView2 != null) {
            appCompatTextView2.setOnClickListener(this);
        }
        IInvitationListener iInvitationListener = this.f13817d;
        ShareUrlModel shareUrlModel = (iInvitationListener == null || (pageInfo = iInvitationListener.getPageInfo()) == null) ? null : pageInfo.getShareUrlModel();
        TextView textView5 = appCompatTextView2;
        ViewExKt.text(textView5, shareUrlModel == null ? null : shareUrlModel.getShareText());
        if (shareUrlModel == null) {
            str = null;
        } else {
            str = shareUrlModel.getShareTextColor();
        }
        ViewExKt.textColor(textView5, str);
        PageData pageData = this.f13824k;
        List<ShareChannelVo> shareChannelVoList = pageData == null ? null : pageData.getShareChannelVoList();
        if (shareChannelVoList == null) {
            shareChannelVo = null;
        } else {
            Iterator it = shareChannelVoList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                MapToSharePlatform.Companion companion = MapToSharePlatform.Companion;
                String shareChannel = ((ShareChannelVo) obj).getShareChannel();
                if (companion.getMapPlatform(shareChannel == null ? null : Integer.valueOf(Integer.parseInt(shareChannel))) == SharePlatform.FACEBOOK_PLATFORM) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    break;
                }
            }
            shareChannelVo = (ShareChannelVo) obj;
        }
        if (!(shareChannelVo == null || !Ninja.getInstance(getContext()).isHit("FACEBOOK_SHARE") || shareChannelVoList == null)) {
            shareChannelVoList.remove(shareChannelVo);
        }
        InvitationHomePresenter invitationHomePresenter = this.f13816c;
        if (invitationHomePresenter == null) {
            list = null;
        } else {
            PageData pageData2 = this.f13824k;
            ShareUrlModel shareUrlModel2 = pageData2 == null ? null : pageData2.getShareUrlModel();
            PageData pageData3 = this.f13824k;
            list = invitationHomePresenter.generateKeyShareInfoList(shareChannelVoList, shareUrlModel2, pageData3 == null ? null : pageData3.getInviteCode());
        }
        if (shareChannelVoList != null && list != null && list.size() >= 3) {
            ImageView imageView = circleImageView;
            HashMap<String, String> hashMap = list.get(0).extra;
            if (hashMap == null || (str2 = hashMap.get("shareIconRound")) == null) {
                str2 = "";
            }
            ViewExKt.loadImage(imageView, str2);
            View view12 = this.f13814a;
            ImageView imageView2 = view12 == null ? null : (ImageView) view12.findViewById(R.id.invite_share_right_angle_ll_img);
            HashMap<String, String> hashMap2 = list.get(0).extra;
            if (hashMap2 == null || (str3 = hashMap2.get("shareIconMark")) == null) {
                str3 = "";
            }
            ViewExKt.loadImage(imageView2, str3);
            if (circleImageView != null) {
                circleImageView.setOnClickListener(new View.OnClickListener(list) {
                    public final /* synthetic */ List f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onClick(View view) {
                        InvitationNewPageFragment.m9594a(InvitationNewPageFragment.this, this.f$1, view);
                    }
                });
            }
            ViewExKt.text(textView, shareChannelVoList.get(0).getShareName());
            if (circleImageView != null) {
                circleImageView.setContentDescription(shareChannelVoList.get(0).getShareName());
            }
            ImageView imageView3 = circleImageView2;
            HashMap<String, String> hashMap3 = list.get(1).extra;
            if (hashMap3 == null || (str4 = hashMap3.get("shareIconRound")) == null) {
                str4 = "";
            }
            ViewExKt.loadImage(imageView3, str4);
            View view13 = this.f13814a;
            ImageView imageView4 = view13 == null ? null : (ImageView) view13.findViewById(R.id.invite_share_right_angle_lm_img);
            HashMap<String, String> hashMap4 = list.get(1).extra;
            if (hashMap4 == null || (str5 = hashMap4.get("shareIconMark")) == null) {
                str5 = "";
            }
            ViewExKt.loadImage(imageView4, str5);
            if (circleImageView2 != null) {
                circleImageView2.setOnClickListener(new View.OnClickListener(list) {
                    public final /* synthetic */ List f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onClick(View view) {
                        InvitationNewPageFragment.m9599b(InvitationNewPageFragment.this, this.f$1, view);
                    }
                });
            }
            ViewExKt.text(textView2, shareChannelVoList.get(1).getShareName());
            if (circleImageView2 != null) {
                circleImageView2.setContentDescription(shareChannelVoList.get(1).getShareName());
            }
            ImageView imageView5 = circleImageView3;
            HashMap<String, String> hashMap5 = list.get(2).extra;
            if (hashMap5 == null || (str6 = hashMap5.get("shareIconRound")) == null) {
                str6 = "";
            }
            ViewExKt.loadImage(imageView5, str6);
            View view14 = this.f13814a;
            ImageView imageView6 = view14 == null ? null : (ImageView) view14.findViewById(R.id.invite_share_right_angle_mr_img);
            HashMap<String, String> hashMap6 = list.get(2).extra;
            if (hashMap6 == null || (str7 = hashMap6.get("shareIconMark")) == null) {
                str7 = "";
            }
            ViewExKt.loadImage(imageView6, str7);
            if (circleImageView3 != null) {
                circleImageView3.setOnClickListener(new View.OnClickListener(list) {
                    public final /* synthetic */ List f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onClick(View view) {
                        InvitationNewPageFragment.m9600c(InvitationNewPageFragment.this, this.f$1, view);
                    }
                });
            }
            ViewExKt.text(textView3, shareChannelVoList.get(2).getShareName());
            if (circleImageView3 != null) {
                circleImageView3.setContentDescription(shareChannelVoList.get(2).getShareName());
            }
            if (circleImageView4 != null) {
                circleImageView4.setImageResource(R.drawable.global_invite_more_channel);
            }
            if (circleImageView4 != null) {
                circleImageView4.setOnClickListener(new View.OnClickListener(list, this) {
                    public final /* synthetic */ List f$0;
                    public final /* synthetic */ InvitationNewPageFragment f$1;

                    {
                        this.f$0 = r1;
                        this.f$1 = r2;
                    }

                    public final void onClick(View view) {
                        InvitationNewPageFragment.m9598a(this.f$0, this.f$1, view);
                    }
                });
            }
            if (circleImageView4 != null) {
                circleImageView4.setContentDescription(getString(R.string.Global_Rider_MgM_new_campaign_page_More_lhEw));
            }
            IInvitationListener iInvitationListener2 = this.f13817d;
            if (iInvitationListener2 != null) {
                iInvitationListener2.setSystemShareInfo(list.size() >= 4 ? list.get(3) : null);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m9594a(InvitationNewPageFragment invitationNewPageFragment, List list, View view) {
        Intrinsics.checkNotNullParameter(invitationNewPageFragment, "this$0");
        invitationNewPageFragment.performShareChannelClick((OneKeyShareModel) list.get(0));
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m9599b(InvitationNewPageFragment invitationNewPageFragment, List list, View view) {
        Intrinsics.checkNotNullParameter(invitationNewPageFragment, "this$0");
        invitationNewPageFragment.performShareChannelClick((OneKeyShareModel) list.get(1));
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static final void m9600c(InvitationNewPageFragment invitationNewPageFragment, List list, View view) {
        Intrinsics.checkNotNullParameter(invitationNewPageFragment, "this$0");
        invitationNewPageFragment.performShareChannelClick((OneKeyShareModel) list.get(2));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m9598a(List list, InvitationNewPageFragment invitationNewPageFragment, View view) {
        Intrinsics.checkNotNullParameter(invitationNewPageFragment, "this$0");
        invitationNewPageFragment.m9596a(list.size() >= 4 ? (OneKeyShareModel) list.get(3) : null);
        invitationNewPageFragment.m9597a(TrackEvent.REFERHOME_SHAREBR_CK, (Integer) 7, invitationNewPageFragment.f13820g);
    }

    /* renamed from: a */
    private final Drawable m9589a(int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i);
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius((float) UiUtils.dip2px(getContext(), 21.0f));
        return gradientDrawable;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final SpannableString m9590a(String str, String str2) {
        CharSequence charSequence = str;
        SpannableString spannableString = new SpannableString(charSequence);
        int indexOf$default = StringsKt.indexOf$default(charSequence, str2, 0, false, 6, (Object) null);
        if (indexOf$default == -1) {
            return spannableString;
        }
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#FFFFCD5F")), indexOf$default, str2.length() + indexOf$default, 34);
        return spannableString;
    }

    /* renamed from: a */
    private final void m9596a(OneKeyShareModel oneKeyShareModel) {
        String str;
        String str2;
        String str3;
        ShareInfo shareInfo = new ShareInfo();
        if (oneKeyShareModel == null) {
            str = null;
        } else {
            str = oneKeyShareModel.title;
        }
        shareInfo.title = str;
        if (oneKeyShareModel == null) {
            str2 = null;
        } else {
            str2 = oneKeyShareModel.content;
        }
        shareInfo.content = str2;
        shareInfo.type = IShareDialogIntercept.SYSTEM_SHARE_DIALOG;
        if (oneKeyShareModel == null) {
            str3 = null;
        } else {
            str3 = oneKeyShareModel.url;
        }
        shareInfo.url = str3;
        shareInfo.platforms = CollectionsKt.mutableListOf(SharePlatform.SYSTEM_MESSAGE);
        ShareBuilder.buildShare(requireActivity(), shareInfo, (ICallback.IPlatformShareCallback) null);
    }

    public void initRewardView() {
        RewardModel rewardModel;
        RewardModel rewardModel2;
        RewardModel rewardModel3;
        RewardModel rewardModel4;
        Boolean currencyFirst;
        View view = this.f13814a;
        if (view != null) {
            view.findViewById(R.id.invite_reward_module_layout);
        }
        View view2 = this.f13814a;
        String str = null;
        AppCompatTextView appCompatTextView = view2 == null ? null : (AppCompatTextView) view2.findViewById(R.id.invite_reward_module_title);
        if (appCompatTextView != null) {
            appCompatTextView.setText(ResourcesHelper.getString(getContext(), R.string.Global_Rider_MgM_new_campaign_page_Reward_XtSH));
        }
        View view3 = this.f13814a;
        AppCompatTextView appCompatTextView2 = view3 == null ? null : (AppCompatTextView) view3.findViewById(R.id.invite_reward_module_see_details);
        View view4 = this.f13814a;
        AppCompatTextView appCompatTextView3 = view4 == null ? null : (AppCompatTextView) view4.findViewById(R.id.invite_reward_module_cur_money);
        View view5 = this.f13814a;
        AppCompatTextView appCompatTextView4 = view5 == null ? null : (AppCompatTextView) view5.findViewById(R.id.invite_reward_module_cur_money_symbol_f);
        View view6 = this.f13814a;
        AppCompatTextView appCompatTextView5 = view6 == null ? null : (AppCompatTextView) view6.findViewById(R.id.invite_reward_module_cur_money_symbol_b);
        View view7 = this.f13814a;
        AppCompatTextView appCompatTextView6 = view7 == null ? null : (AppCompatTextView) view7.findViewById(R.id.invite_reward_module_pending_money);
        View view8 = this.f13814a;
        AppCompatTextView appCompatTextView7 = view8 == null ? null : (AppCompatTextView) view8.findViewById(R.id.invite_reward_module_pending_money_symbol_f);
        View view9 = this.f13814a;
        AppCompatTextView appCompatTextView8 = view9 == null ? null : (AppCompatTextView) view9.findViewById(R.id.invite_reward_module_pending_money_symbol_b);
        if (appCompatTextView2 != null) {
            appCompatTextView2.setOnClickListener(this);
        }
        PageData pageData = this.f13824k;
        boolean z = false;
        if (!(pageData == null || (rewardModel4 = pageData.getRewardModel()) == null || (currencyFirst = rewardModel4.getCurrencyFirst()) == null)) {
            z = currencyFirst.booleanValue();
        }
        PageData pageData2 = this.f13824k;
        String currencySymbol = (pageData2 == null || (rewardModel3 = pageData2.getRewardModel()) == null) ? null : rewardModel3.getCurrencySymbol();
        if (z) {
            if (appCompatTextView4 != null) {
                appCompatTextView4.setVisibility(8);
            }
            if (appCompatTextView7 != null) {
                appCompatTextView7.setVisibility(8);
            }
            if (appCompatTextView5 != null) {
                appCompatTextView5.setText(currencySymbol);
            }
            if (appCompatTextView8 != null) {
                appCompatTextView8.setText(currencySymbol);
            }
        } else {
            if (appCompatTextView5 != null) {
                appCompatTextView5.setVisibility(8);
            }
            if (appCompatTextView8 != null) {
                appCompatTextView8.setVisibility(8);
            }
            if (appCompatTextView4 != null) {
                appCompatTextView4.setText(currencySymbol);
            }
            if (appCompatTextView7 != null) {
                appCompatTextView7.setText(currencySymbol);
            }
        }
        if (appCompatTextView3 != null) {
            PageData pageData3 = this.f13824k;
            appCompatTextView3.setText((pageData3 == null || (rewardModel2 = pageData3.getRewardModel()) == null) ? null : rewardModel2.getReceivedAmountFormat());
        }
        if (appCompatTextView6 != null) {
            PageData pageData4 = this.f13824k;
            if (!(pageData4 == null || (rewardModel = pageData4.getRewardModel()) == null)) {
                str = rewardModel.getRestAmountFormat();
            }
            appCompatTextView6.setText(str);
        }
    }

    public void initIntroductionView() {
        Recommend recommend;
        SharePage sharePage;
        View view = this.f13814a;
        if (view != null) {
            view.findViewById(R.id.invite_introduction_module_layout);
        }
        View view2 = this.f13814a;
        List<Swiper> list = null;
        RecyclerView recyclerView = view2 == null ? null : (RecyclerView) view2.findViewById(R.id.invite_introduction_module_rec);
        InviteTheme inviteTheme = this.f13825l;
        if (!(inviteTheme == null || (recommend = inviteTheme.getRecommend()) == null || (sharePage = recommend.getSharePage()) == null)) {
            list = sharePage.getSwiper();
        }
        Collection collection = list;
        if (!(collection == null || collection.isEmpty())) {
            InvitationNewPageFragment$initIntroductionView$adapter$1 invitationNewPageFragment$initIntroductionView$adapter$1 = new InvitationNewPageFragment$initIntroductionView$adapter$1(list, requireActivity());
            invitationNewPageFragment$initIntroductionView$adapter$1.setMData(list);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
            if (recyclerView != null) {
                recyclerView.setAdapter(invitationNewPageFragment$initIntroductionView$adapter$1);
            }
            if (recyclerView != null) {
                recyclerView.setLayoutManager(linearLayoutManager);
            }
        }
    }

    public void initTermsView() {
        View view = this.f13814a;
        TextView textView = view == null ? null : (TextView) view.findViewById(R.id.invite_terms_module_use);
        if (textView != null) {
            textView.setOnClickListener(this);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: android.content.ClipboardManager} */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0082, code lost:
        r3 = r3.getPageInfo();
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00e8  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m9595a(com.didi.component.framework.pages.invitation.model.InviteCode r20) {
        /*
            r19 = this;
            r6 = r19
            com.didi.component.framework.pages.invitation.fragment.IInvitationListener r0 = r6.f13817d
            java.lang.String r1 = ""
            if (r0 != 0) goto L_0x0009
            goto L_0x001f
        L_0x0009:
            com.didi.component.framework.pages.invitation.model.PageData r0 = r0.getPageInfo()
            if (r0 != 0) goto L_0x0010
            goto L_0x001f
        L_0x0010:
            com.didi.component.framework.pages.invitation.model.ShareUrlModel r0 = r0.getShareUrlModel()
            if (r0 != 0) goto L_0x0017
            goto L_0x001f
        L_0x0017:
            java.lang.String r0 = r0.getUserName()
            if (r0 != 0) goto L_0x001e
            goto L_0x001f
        L_0x001e:
            r1 = r0
        L_0x001f:
            r0 = 0
            if (r20 != 0) goto L_0x0024
        L_0x0022:
            r2 = r0
            goto L_0x0046
        L_0x0024:
            java.lang.String r7 = r20.getTitle()
            if (r7 != 0) goto L_0x002b
            goto L_0x0022
        L_0x002b:
            r10 = 0
            r11 = 4
            r12 = 0
            java.lang.String r8 = "[referer.name]"
            r9 = r1
            java.lang.String r13 = kotlin.text.StringsKt.replace$default((java.lang.String) r7, (java.lang.String) r8, (java.lang.String) r9, (boolean) r10, (int) r11, (java.lang.Object) r12)
            if (r13 != 0) goto L_0x0038
            goto L_0x0022
        L_0x0038:
            java.lang.String r15 = r6.f13826m
            r16 = 0
            r17 = 4
            r18 = 0
            java.lang.String r14 = "[referree.money]"
            java.lang.String r2 = kotlin.text.StringsKt.replace$default((java.lang.String) r13, (java.lang.String) r14, (java.lang.String) r15, (boolean) r16, (int) r17, (java.lang.Object) r18)
        L_0x0046:
            if (r20 != 0) goto L_0x004a
        L_0x0048:
            r1 = r0
            goto L_0x007c
        L_0x004a:
            java.lang.String r7 = r20.getContent()
            if (r7 != 0) goto L_0x0051
            goto L_0x0048
        L_0x0051:
            r10 = 0
            r11 = 4
            r12 = 0
            java.lang.String r8 = "[referer.name]"
            r9 = r1
            java.lang.String r13 = kotlin.text.StringsKt.replace$default((java.lang.String) r7, (java.lang.String) r8, (java.lang.String) r9, (boolean) r10, (int) r11, (java.lang.Object) r12)
            if (r13 != 0) goto L_0x005e
            goto L_0x0048
        L_0x005e:
            java.lang.String r15 = r6.f13826m
            r16 = 0
            r17 = 4
            r18 = 0
            java.lang.String r14 = "[referree.money]"
            java.lang.String r7 = kotlin.text.StringsKt.replace$default((java.lang.String) r13, (java.lang.String) r14, (java.lang.String) r15, (boolean) r16, (int) r17, (java.lang.Object) r18)
            if (r7 != 0) goto L_0x006f
            goto L_0x0048
        L_0x006f:
            java.lang.String r9 = r19.gotPromoCode()
            r10 = 0
            r11 = 4
            r12 = 0
            java.lang.String r8 = "[promo code]"
            java.lang.String r1 = kotlin.text.StringsKt.replace$default((java.lang.String) r7, (java.lang.String) r8, (java.lang.String) r9, (boolean) r10, (int) r11, (java.lang.Object) r12)
        L_0x007c:
            com.didi.component.framework.pages.invitation.fragment.IInvitationListener r3 = r6.f13817d
            if (r3 != 0) goto L_0x0082
        L_0x0080:
            r3 = r0
            goto L_0x008d
        L_0x0082:
            com.didi.component.framework.pages.invitation.model.PageData r3 = r3.getPageInfo()
            if (r3 != 0) goto L_0x0089
            goto L_0x0080
        L_0x0089:
            com.didi.component.framework.pages.invitation.model.ShareUrlModel r3 = r3.getShareUrlModel()
        L_0x008d:
            java.lang.String r4 = "?shareChannel=inviteCode"
            if (r20 != 0) goto L_0x0093
            r5 = r0
            goto L_0x0097
        L_0x0093:
            java.lang.String r5 = r20.getLinkType()
        L_0x0097:
            java.lang.String r7 = "1"
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r7)
            if (r5 == 0) goto L_0x00a7
            if (r3 != 0) goto L_0x00a2
            goto L_0x00a9
        L_0x00a2:
            java.lang.String r3 = r3.getShareUrl()
            goto L_0x00af
        L_0x00a7:
            if (r3 != 0) goto L_0x00ab
        L_0x00a9:
            r3 = r0
            goto L_0x00af
        L_0x00ab:
            java.lang.String r3 = r3.getDownloadUrl()
        L_0x00af:
            java.lang.String r3 = kotlin.jvm.internal.Intrinsics.stringPlus(r3, r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r2)
            r4.append(r1)
            r4.append(r3)
            java.lang.String r1 = r4.toString()
            androidx.fragment.app.FragmentActivity r2 = r19.requireActivity()
            java.lang.String r3 = "clipboard"
            java.lang.Object r2 = r2.getSystemService(r3)
            boolean r3 = r2 instanceof android.content.ClipboardManager
            if (r3 == 0) goto L_0x00d6
            r0 = r2
            android.content.ClipboardManager r0 = (android.content.ClipboardManager) r0
        L_0x00d6:
            java.lang.String r2 = "copy"
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            android.content.ClipData r2 = android.content.ClipData.newPlainText(r2, r1)
            if (r0 != 0) goto L_0x00e3
            goto L_0x00e6
        L_0x00e3:
            r0.setPrimaryClip(r2)
        L_0x00e6:
            if (r0 == 0) goto L_0x00fc
            int r1 = r1.length()
            if (r1 <= 0) goto L_0x00f0
            r1 = 1
            goto L_0x00f1
        L_0x00f0:
            r1 = 0
        L_0x00f1:
            if (r1 == 0) goto L_0x00fc
            boolean r0 = r0.hasPrimaryClip()
            if (r0 == 0) goto L_0x00fc
            r19.showCopyToastView()
        L_0x00fc:
            r2 = 0
            java.lang.Long r3 = r6.f13820g
            r4 = 2
            r5 = 0
            java.lang.String r1 = "PasMark_RefererHome_ReferBt_ck"
            r0 = r19
            m9593a(r0, r1, r2, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.framework.pages.invitation.fragment.InvitationNewPageFragment.m9595a(com.didi.component.framework.pages.invitation.model.InviteCode):void");
    }

    public void showCopyToastView() {
        ToastHelperKt.toast(this, ResourcesHelper.getString(requireActivity(), R.string.Global_Rider_MgM_new_campaign_page_Invitation_code_LBfQ), Integer.valueOf(R.drawable.global_invite_complete_icon));
    }

    public final void performShareChannelClick(OneKeyShareModel oneKeyShareModel) {
        if (oneKeyShareModel != null) {
            Integer num = null;
            ShareApi.show((Activity) requireActivity(), oneKeyShareModel, (ICallback.IPlatformShareCallback) null);
            InvitationHomePresenter invitationHomePresenter = this.f13816c;
            if (invitationHomePresenter != null) {
                num = Integer.valueOf(invitationHomePresenter.convertToShareChannel(oneKeyShareModel));
            }
            m9597a(TrackEvent.REFERHOME_SHAREBR_CK, num, this.f13820g);
        }
    }

    public String gotRefererMoney() {
        return this.f13827n;
    }

    public String gotRefereeMoney() {
        return this.f13826m;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0015, code lost:
        r0 = (r0 = (r0 = r0.getPageInfo()).getRewardModel()).getReferrerCode();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String gotPromoCode() {
        /*
            r2 = this;
            com.didi.component.framework.pages.invitation.fragment.IInvitationListener r0 = r2.f13817d
            java.lang.String r1 = ""
            if (r0 != 0) goto L_0x0007
            goto L_0x001d
        L_0x0007:
            com.didi.component.framework.pages.invitation.model.PageData r0 = r0.getPageInfo()
            if (r0 != 0) goto L_0x000e
            goto L_0x001d
        L_0x000e:
            com.didi.component.framework.pages.invitation.model.RewardModel r0 = r0.getRewardModel()
            if (r0 != 0) goto L_0x0015
            goto L_0x001d
        L_0x0015:
            java.lang.String r0 = r0.getReferrerCode()
            if (r0 != 0) goto L_0x001c
            goto L_0x001d
        L_0x001c:
            r1 = r0
        L_0x001d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.framework.pages.invitation.fragment.InvitationNewPageFragment.gotPromoCode():java.lang.String");
    }

    /* renamed from: a */
    static /* synthetic */ void m9593a(InvitationNewPageFragment invitationNewPageFragment, String str, Integer num, Long l, int i, Object obj) {
        if ((i & 2) != 0) {
            num = null;
        }
        if ((i & 4) != 0) {
            l = null;
        }
        invitationNewPageFragment.m9597a(str, num, l);
    }

    /* renamed from: a */
    private final void m9597a(String str, Integer num, Long l) {
        InvitationHomePresenter invitationHomePresenter = this.f13816c;
        if (invitationHomePresenter != null) {
            invitationHomePresenter.traceEvent(str, NationComponentDataUtil.getToken(), Integer.valueOf(this.f13821h), this.f13818e, this.f13822i, this.f13819f, num, l, this.f13823j);
        }
    }
}
