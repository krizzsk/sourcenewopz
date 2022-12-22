package com.didi.component.framework.pages.invitation.fragment;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.didi.component.business.util.NationComponentDataUtil;
import com.didi.component.business.util.UiUtils;
import com.didi.component.common.adapter.CommonRvAdapter;
import com.didi.component.common.performance.pkgsize.RideOnlineImageCacheRegister;
import com.didi.component.framework.pages.invitation.InvitationPageActivity;
import com.didi.component.framework.pages.invitation.helper.ToastHelperKt;
import com.didi.component.framework.pages.invitation.helper.TrackEvent;
import com.didi.component.framework.pages.invitation.item.SwiperItem;
import com.didi.component.framework.pages.invitation.model.AreaVo;
import com.didi.component.framework.pages.invitation.model.InviteTheme;
import com.didi.component.framework.pages.invitation.model.PageData;
import com.didi.component.framework.pages.invitation.model.Recommend;
import com.didi.component.framework.pages.invitation.model.RedirectModel;
import com.didi.component.framework.pages.invitation.model.RewardModel;
import com.didi.component.framework.pages.invitation.model.SharePage;
import com.didi.component.framework.pages.invitation.model.Swiper;
import com.didi.component.framework.pages.invitation.presenter.InvitationHomePresenter;
import com.didi.component.framework.pages.invitation.view.IInvitationHomeView;
import com.didi.onekeyshare.ShareBuilder;
import com.didi.onekeyshare.callback.ICallback;
import com.didi.onekeyshare.callback.intercept.IShareDialogIntercept;
import com.didi.onekeyshare.entity.ShareInfo;
import com.didi.onekeyshare.entity.SharePlatform;
import com.didi.sdk.home.BizEntranceFragment;
import com.didi.sdk.resource.warehouse.image.ICacheProvider;
import com.didi.sdk.resource.warehouse.image.OnlineImageCacheManager;
import com.didi.sdk.resource.warehouse.tools.LogUtil;
import com.didi.sdk.resource.warehouse.tools.OmegaUtil;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sharesdk.OneKeyShareModel;
import com.didi.sharesdk.ShareApi;
import com.taxis99.R;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo175977d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 U2\u00020\u00012\u00020\u0002:\u0001UB\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0002J\u001a\u0010\"\u001a\u00020\u001f2\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020&H\u0002J\u001a\u0010'\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010(\u001a\u00020\u0017H\u0002J\u0012\u0010)\u001a\u00020\u001f2\b\u0010*\u001a\u0004\u0018\u00010+H\u0002J\u001e\u0010,\u001a\u00020\b2\u0006\u0010%\u001a\u00020&2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020&0.H\u0002J\n\u0010/\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u00100\u001a\u00020\nH\u0016J\b\u00101\u001a\u00020\nH\u0016J\b\u00102\u001a\u00020\nH\u0016J\b\u00103\u001a\u00020\u001fH\u0016J\b\u00104\u001a\u00020\u001fH\u0016J\u0016\u00105\u001a\u00020\u001f2\f\u00106\u001a\b\u0012\u0004\u0012\u00020&07H\u0016J\b\u00108\u001a\u00020\u001fH\u0016J\b\u00109\u001a\u00020\u001fH\u0002J\u0012\u0010:\u001a\u00020\u001f2\b\u0010;\u001a\u0004\u0018\u00010\u0017H\u0016J&\u0010<\u001a\u0004\u0018\u00010\u00172\u0006\u0010=\u001a\u00020>2\b\u0010?\u001a\u0004\u0018\u00010@2\b\u0010A\u001a\u0004\u0018\u00010BH\u0016J\u0012\u0010C\u001a\u00020\u001f2\b\u0010D\u001a\u0004\u0018\u00010EH\u0002J\u001a\u0010F\u001a\u00020\u001f2\b\u0010G\u001a\u0004\u0018\u00010H2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0012\u0010I\u001a\u00020\u001f2\b\u0010J\u001a\u0004\u0018\u00010\u0015H\u0016J\u001a\u0010K\u001a\u00020\u001f2\b\u0010L\u001a\u0004\u0018\u00010M2\u0006\u0010\f\u001a\u00020\rH\u0002J\b\u0010N\u001a\u00020\u001fH\u0016J\u0012\u0010O\u001a\u00020\u001f2\b\u0010P\u001a\u0004\u0018\u00010EH\u0002J-\u0010Q\u001a\u00020\u001f2\u0006\u0010R\u001a\u00020\n2\n\b\u0002\u0010S\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0002\u0010TR\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R.\u0010\u000e\u001a\"\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fj\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0010\u0018\u0001`\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000¨\u0006V"}, mo175978d2 = {"Lcom/didi/component/framework/pages/invitation/fragment/InvitationPageFragment;", "Lcom/didi/sdk/home/BizEntranceFragment;", "Lcom/didi/component/framework/pages/invitation/view/IInvitationHomeView;", "()V", "activityId", "", "Ljava/lang/Long;", "channel", "", "cityName", "", "country", "isGlobal", "", "logParams", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "mListener", "Lcom/didi/component/framework/pages/invitation/fragment/IInvitationListener;", "mPresenter", "Lcom/didi/component/framework/pages/invitation/presenter/InvitationHomePresenter;", "mRootView", "Landroid/view/View;", "mWidth", "refereeMoney", "refererMoney", "resourceId", "varHeight", "", "addStartChildMargin", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "bindDataToView", "holder", "Lcom/didi/component/common/adapter/CommonRvVH;", "item", "Lcom/didi/component/framework/pages/invitation/item/SwiperItem;", "calculateAndAddMargin", "targetView", "copyText", "inviteCode", "Lcom/didi/component/framework/pages/invitation/model/InviteCode;", "generateItemLayout", "adapter", "Lcom/didi/component/common/adapter/CommonRvAdapter;", "getView", "gotPromoCode", "gotRefereeMoney", "gotRefererMoney", "initBottomView", "initInviteCodeView", "initRecyclerView", "list", "", "initTitleView", "initView", "onClick", "v", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "performClick", "shareInfo", "Lcom/didi/sharesdk/OneKeyShareModel;", "setArrowView", "imageView", "Landroid/widget/ImageView;", "setPresenter", "presenter", "setTextColor", "tv", "Landroid/widget/TextView;", "showCopyToastView", "showShareDialog", "smsChannel", "traceOmegaEvent", "event", "shareChannel", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;)V", "Companion", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: InvitationPageFragment.kt */
public final class InvitationPageFragment extends BizEntranceFragment implements IInvitationHomeView {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String PROMO_CODE = "[promo code]";
    public static final String REFEREE_MONEY = "[referree.money]";
    public static final String REFERER_MONEY = "[referer.money]";
    public static final String REFERER_NAME = "[referer.name]";

    /* renamed from: a */
    private int f13840a;

    /* renamed from: b */
    private View f13841b;

    /* renamed from: c */
    private InvitationHomePresenter f13842c;

    /* renamed from: d */
    private IInvitationListener f13843d;

    /* renamed from: e */
    private boolean f13844e;

    /* renamed from: f */
    private float f13845f;

    /* renamed from: g */
    private String f13846g = "";

    /* renamed from: h */
    private String f13847h = "";

    /* renamed from: i */
    private String f13848i = "";

    /* renamed from: j */
    private Long f13849j = 0L;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public Long f13850k = 0L;

    /* renamed from: l */
    private int f13851l = 2;

    /* renamed from: m */
    private String f13852m = "";

    /* renamed from: n */
    private HashMap<String, Object> f13853n;

    public void _$_clearFindViewByIdCache() {
    }

    public void setPresenter(InvitationHomePresenter invitationHomePresenter) {
    }

    @Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, mo175978d2 = {"Lcom/didi/component/framework/pages/invitation/fragment/InvitationPageFragment$Companion;", "", "()V", "PROMO_CODE", "", "REFEREE_MONEY", "REFERER_MONEY", "REFERER_NAME", "newInstance", "Landroidx/fragment/app/Fragment;", "bundle", "Landroid/os/Bundle;", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: InvitationPageFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Fragment newInstance(Bundle bundle) {
            InvitationPageFragment invitationPageFragment = new InvitationPageFragment();
            invitationPageFragment.setArguments(bundle);
            return invitationPageFragment;
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        this.f13841b = layoutInflater.inflate(R.layout.global_fragment_invite_page, viewGroup, false);
        m9606a();
        return this.f13841b;
    }

    /* renamed from: a */
    private final void m9606a() {
        boolean z;
        InviteTheme themeInfo;
        Recommend recommend;
        SharePage sharePage;
        PageData pageInfo;
        String string;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        InvitationHomePresenter invitationHomePresenter = new InvitationHomePresenter(requireActivity);
        this.f13842c = invitationHomePresenter;
        if (invitationHomePresenter != null) {
            invitationHomePresenter.setIView(this);
        }
        IInvitationListener iInvitationListener = (IInvitationListener) requireActivity();
        this.f13843d = iInvitationListener;
        if (iInvitationListener == null) {
            z = false;
        } else {
            z = iInvitationListener.isGlobal();
        }
        this.f13844e = z;
        this.f13840a = UiUtils.getWindowWidth(requireActivity());
        IInvitationListener iInvitationListener2 = this.f13843d;
        boolean hasRewards = iInvitationListener2 == null ? true : iInvitationListener2.hasRewards();
        Bundle arguments = getArguments();
        List<Swiper> list = null;
        this.f13848i = arguments == null ? null : arguments.getString("country");
        Bundle arguments2 = getArguments();
        this.f13849j = arguments2 == null ? null : Long.valueOf(arguments2.getLong("activityId"));
        Bundle arguments3 = getArguments();
        this.f13850k = arguments3 == null ? null : Long.valueOf(arguments3.getLong(InvitationPageActivity.RESOURCE_ID));
        Bundle arguments4 = getArguments();
        this.f13851l = arguments4 == null ? 2 : arguments4.getInt("channel");
        Bundle arguments5 = getArguments();
        String str = "";
        if (!(arguments5 == null || (string = arguments5.getString(InvitationPageActivity.CITY_NAME)) == null)) {
            str = string;
        }
        this.f13852m = str;
        Bundle arguments6 = getArguments();
        this.f13853n = (HashMap) (arguments6 == null ? null : arguments6.getSerializable(InvitationPageActivity.LOG_PARAMS));
        InvitationHomePresenter invitationHomePresenter2 = this.f13842c;
        if (invitationHomePresenter2 != null) {
            IInvitationListener iInvitationListener3 = this.f13843d;
            RewardModel rewardModel = (iInvitationListener3 == null || (pageInfo = iInvitationListener3.getPageInfo()) == null) ? null : pageInfo.getRewardModel();
            IInvitationListener iInvitationListener4 = this.f13843d;
            if (!(iInvitationListener4 == null || (themeInfo = iInvitationListener4.getThemeInfo()) == null || (recommend = themeInfo.getRecommend()) == null || (sharePage = recommend.getSharePage()) == null)) {
                list = sharePage.getSwiper();
            }
            invitationHomePresenter2.generateRvItemAndInit(rewardModel, list, hasRewards);
        }
        m9613a(this, TrackEvent.REFERHOME_SW, (Integer) null, this.f13850k, 2, (Object) null);
    }

    public void initTitleView() {
        String str;
        String str2;
        String str3;
        boolean z;
        String str4;
        String str5;
        int i;
        boolean z2;
        RedirectModel redirectModel;
        AreaVo areaVo;
        String cityName;
        RedirectModel redirectModel2;
        Boolean experiment;
        RedirectModel redirectModel3;
        RedirectModel redirectModel4;
        RedirectModel redirectModel5;
        Boolean currencyFirst;
        RedirectModel redirectModel6;
        Recommend recommend;
        SharePage sharePage;
        Recommend recommend2;
        SharePage sharePage2;
        String referTitle;
        View view = this.f13841b;
        TextView textView = view == null ? null : (TextView) view.findViewById(R.id.invite_center_title);
        View view2 = this.f13841b;
        TextView textView2 = view2 == null ? null : (TextView) view2.findViewById(R.id.invite_center_subtitle);
        IInvitationListener iInvitationListener = this.f13843d;
        InviteTheme themeInfo = iInvitationListener == null ? null : iInvitationListener.getThemeInfo();
        IInvitationListener iInvitationListener2 = this.f13843d;
        PageData pageInfo = iInvitationListener2 == null ? null : iInvitationListener2.getPageInfo();
        String str6 = "";
        if (themeInfo == null || (recommend2 = themeInfo.getRecommend()) == null || (sharePage2 = recommend2.getSharePage()) == null || (referTitle = sharePage2.getReferTitle()) == null) {
            str = str6;
        } else {
            str = referTitle;
        }
        if (themeInfo == null || (recommend = themeInfo.getRecommend()) == null || (sharePage = recommend.getSharePage()) == null || (str2 = sharePage.getReferSubtitle()) == null) {
            str2 = str6;
        }
        if (pageInfo == null || (redirectModel6 = pageInfo.getRedirectModel()) == null || (str3 = redirectModel6.getCurrencySymbol()) == null) {
            str3 = str6;
        }
        if (pageInfo == null || (redirectModel5 = pageInfo.getRedirectModel()) == null || (currencyFirst = redirectModel5.getCurrencyFirst()) == null) {
            z = false;
        } else {
            z = currencyFirst.booleanValue();
        }
        if (pageInfo == null || (redirectModel4 = pageInfo.getRedirectModel()) == null || (str4 = redirectModel4.getRewardAmountFormat()) == null) {
            str4 = str6;
        }
        if (pageInfo == null || (redirectModel3 = pageInfo.getRedirectModel()) == null || (str5 = redirectModel3.getRebateAmountFormat()) == null) {
            str5 = str6;
        }
        this.f13846g = !z ? Intrinsics.stringPlus(str3, str4) : Intrinsics.stringPlus(str4, str3);
        this.f13847h = !z ? Intrinsics.stringPlus(str3, str5) : Intrinsics.stringPlus(str5, str3);
        String replace$default = StringsKt.replace$default(str, REFEREE_MONEY, this.f13846g, false, 4, (Object) null);
        String replace$default2 = StringsKt.replace$default(str2, REFERER_MONEY, this.f13847h, false, 4, (Object) null);
        int color = ResourcesHelper.getColor(requireActivity(), R.color.g_color_2CBE6A);
        CharSequence charSequence = replace$default;
        if (!StringsKt.contains$default(charSequence, (CharSequence) this.f13846g, false, 2, (Object) null)) {
            if (textView != null) {
                textView.setText(charSequence);
            }
            i = 33;
        } else {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append(charSequence);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(color);
            i = 33;
            int indexOf$default = StringsKt.indexOf$default(charSequence, this.f13846g, 0, false, 6, (Object) null);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf$default, this.f13846g.length() + indexOf$default, 33);
            if (textView != null) {
                textView.setText(spannableStringBuilder);
            }
        }
        CharSequence charSequence2 = replace$default2;
        if (StringsKt.contains$default(charSequence2, (CharSequence) this.f13847h, false, 2, (Object) null)) {
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
            spannableStringBuilder2.append(charSequence2);
            ForegroundColorSpan foregroundColorSpan2 = new ForegroundColorSpan(color);
            int indexOf$default2 = StringsKt.indexOf$default(charSequence2, this.f13847h, 0, false, 6, (Object) null);
            spannableStringBuilder2.setSpan(foregroundColorSpan2, indexOf$default2, this.f13847h.length() + indexOf$default2, i);
            if (textView2 != null) {
                textView2.setText(spannableStringBuilder2);
            }
        } else if (textView2 != null) {
            textView2.setText(charSequence2);
        }
        if (pageInfo == null || (redirectModel2 = pageInfo.getRedirectModel()) == null || (experiment = redirectModel2.getExperiment()) == null) {
            z2 = false;
        } else {
            z2 = experiment.booleanValue();
        }
        if (!(pageInfo == null || (redirectModel = pageInfo.getRedirectModel()) == null || (areaVo = redirectModel.getAreaVo()) == null || (cityName = areaVo.getCityName()) == null)) {
            str6 = cityName;
        }
        String string = ResourcesHelper.getString(requireActivity(), R.string.global_invite_code_experiment, str6);
        View view3 = this.f13841b;
        TextView textView3 = view3 == null ? null : (TextView) view3.findViewById(R.id.invite_page_experiment);
        if (textView3 != null) {
            textView3.setText(string);
        }
        View view4 = this.f13841b;
        TextView textView4 = view4 == null ? null : (TextView) view4.findViewById(R.id.invite_page_experiment);
        if (textView4 != null) {
            textView4.setVisibility(z2 ? 0 : 8);
        }
    }

    /* JADX WARNING: type inference failed for: r6v6, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void initRecyclerView(java.util.List<com.didi.component.framework.pages.invitation.item.SwiperItem> r6) {
        /*
            r5 = this;
            java.lang.String r0 = "list"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            androidx.fragment.app.FragmentActivity r0 = r5.requireActivity()
            com.didi.component.framework.pages.invitation.fragment.InvitationPageFragment$initRecyclerView$adapter$1 r1 = new com.didi.component.framework.pages.invitation.fragment.InvitationPageFragment$initRecyclerView$adapter$1
            r1.<init>(r6, r5, r0)
            com.didi.component.framework.pages.invitation.presenter.InvitationHomePresenter r0 = r5.f13842c
            r2 = 0
            if (r0 != 0) goto L_0x0015
            r0 = r2
            goto L_0x002a
        L_0x0015:
            androidx.fragment.app.FragmentActivity r3 = r5.requireActivity()
            android.content.Context r3 = (android.content.Context) r3
            r4 = 1122500608(0x42e80000, float:116.0)
            int r3 = com.didi.component.business.util.UiUtils.dip2px(r3, r4)
            float r3 = (float) r3
            float r0 = r0.calculateFinalHeight(r3)
            java.lang.Float r0 = java.lang.Float.valueOf(r0)
        L_0x002a:
            if (r0 != 0) goto L_0x003a
            androidx.fragment.app.FragmentActivity r0 = r5.requireActivity()
            android.content.Context r0 = (android.content.Context) r0
            r3 = 1133248512(0x438c0000, float:280.0)
            int r0 = com.didi.component.business.util.UiUtils.dip2px(r0, r3)
            float r0 = (float) r0
            goto L_0x003e
        L_0x003a:
            float r0 = r0.floatValue()
        L_0x003e:
            r5.f13845f = r0
            r1.setMData(r6)
            android.view.View r6 = r5.f13841b
            if (r6 != 0) goto L_0x0048
            goto L_0x0052
        L_0x0048:
            r0 = 2131431615(0x7f0b10bf, float:1.8484964E38)
            android.view.View r6 = r6.findViewById(r0)
            r2 = r6
            androidx.recyclerview.widget.RecyclerView r2 = (androidx.recyclerview.widget.RecyclerView) r2
        L_0x0052:
            if (r2 != 0) goto L_0x0055
            goto L_0x0066
        L_0x0055:
            androidx.recyclerview.widget.LinearLayoutManager r6 = new androidx.recyclerview.widget.LinearLayoutManager
            androidx.fragment.app.FragmentActivity r0 = r5.requireActivity()
            android.content.Context r0 = (android.content.Context) r0
            r3 = 0
            r6.<init>(r0, r3, r3)
            androidx.recyclerview.widget.RecyclerView$LayoutManager r6 = (androidx.recyclerview.widget.RecyclerView.LayoutManager) r6
            r2.setLayoutManager(r6)
        L_0x0066:
            if (r2 != 0) goto L_0x0069
            goto L_0x006e
        L_0x0069:
            androidx.recyclerview.widget.RecyclerView$Adapter r1 = (androidx.recyclerview.widget.RecyclerView.Adapter) r1
            r2.setAdapter(r1)
        L_0x006e:
            com.didi.component.framework.pages.invitation.helper.CustomPagerSnapHelper r6 = new com.didi.component.framework.pages.invitation.helper.CustomPagerSnapHelper
            int r0 = r5.f13840a
            r6.<init>(r0)
            r6.attachToRecyclerView(r2)
            com.didi.component.framework.pages.invitation.fragment.InvitationPageFragment$initRecyclerView$1 r0 = new com.didi.component.framework.pages.invitation.fragment.InvitationPageFragment$initRecyclerView$1
            r0.<init>(r5)
            com.didi.component.framework.pages.invitation.helper.CustomPagerSnapHelper$TrackEventListener r0 = (com.didi.component.framework.pages.invitation.helper.CustomPagerSnapHelper.TrackEventListener) r0
            r6.addTrackEventListener(r0)
            if (r2 != 0) goto L_0x0085
            goto L_0x008d
        L_0x0085:
            com.didi.component.framework.pages.invitation.fragment.-$$Lambda$InvitationPageFragment$9natSSVybZKd81Bjmd11iPIx4fc r6 = new com.didi.component.framework.pages.invitation.fragment.-$$Lambda$InvitationPageFragment$9natSSVybZKd81Bjmd11iPIx4fc
            r6.<init>(r2)
            r2.post(r6)
        L_0x008d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.framework.pages.invitation.fragment.InvitationPageFragment.initRecyclerView(java.util.List):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m9612a(InvitationPageFragment invitationPageFragment, RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(invitationPageFragment, "this$0");
        invitationPageFragment.m9609a(recyclerView);
    }

    /* renamed from: a */
    private final void m9609a(RecyclerView recyclerView) {
        if (recyclerView != null && recyclerView.getChildCount() >= 1) {
            View childAt = recyclerView.getChildAt(0);
            Intrinsics.checkNotNullExpressionValue(childAt, "childStart");
            m9610a(recyclerView, childAt);
        }
    }

    /* renamed from: a */
    private final void m9610a(RecyclerView recyclerView, View view) {
        int width = (this.f13840a - view.getWidth()) / 2;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) layoutParams;
            layoutParams2.leftMargin = width;
            view.setLayoutParams(layoutParams2);
            if (recyclerView != null) {
                recyclerView.smoothScrollBy(-width, 0);
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final int m9605a(SwiperItem swiperItem, CommonRvAdapter<SwiperItem> commonRvAdapter) {
        if (swiperItem.getType() != 7) {
            return R.layout.global_invite_card_item_with_money;
        }
        commonRvAdapter.setMHeight((int) this.f13845f);
        return R.layout.global_invite_card_item_no_money;
    }

    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v1, types: [android.widget.ImageView] */
    /* JADX WARNING: type inference failed for: r1v5, types: [android.widget.TextView] */
    /* JADX WARNING: type inference failed for: r1v7 */
    /* JADX WARNING: type inference failed for: r1v8 */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m9611a(com.didi.component.common.adapter.CommonRvVH r9, com.didi.component.framework.pages.invitation.item.SwiperItem r10) {
        /*
            r8 = this;
            int r0 = r10.getType()
            r1 = 0
            r2 = 7
            if (r0 != r2) goto L_0x0058
            r0 = r8
            androidx.fragment.app.Fragment r0 = (androidx.fragment.app.Fragment) r0
            com.bumptech.glide.RequestManager r0 = com.bumptech.glide.Glide.with((androidx.fragment.app.Fragment) r0)
            java.lang.String r2 = r10.getSwiperCard()
            com.bumptech.glide.RequestBuilder r0 = r0.load((java.lang.String) r2)
            if (r9 != 0) goto L_0x001b
            r2 = r1
            goto L_0x0022
        L_0x001b:
            r2 = 2131431563(0x7f0b108b, float:1.8484859E38)
            android.widget.ImageView r2 = r9.getImageView(r2)
        L_0x0022:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            r0.into((android.widget.ImageView) r2)
            if (r9 != 0) goto L_0x002c
            r0 = r1
            goto L_0x0033
        L_0x002c:
            r0 = 2131431565(0x7f0b108d, float:1.8484863E38)
            android.widget.TextView r0 = r9.getTextView(r0)
        L_0x0033:
            if (r0 != 0) goto L_0x0036
            goto L_0x003f
        L_0x0036:
            java.lang.String r2 = r10.getSwiperTitle()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r0.setText(r2)
        L_0x003f:
            if (r9 != 0) goto L_0x0042
            goto L_0x0049
        L_0x0042:
            r0 = 2131431564(0x7f0b108c, float:1.848486E38)
            android.widget.TextView r1 = r9.getTextView(r0)
        L_0x0049:
            if (r1 != 0) goto L_0x004d
            goto L_0x0168
        L_0x004d:
            java.lang.String r9 = r10.getSwiperContent()
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            r1.setText(r9)
            goto L_0x0168
        L_0x0058:
            if (r9 != 0) goto L_0x005c
            r0 = r1
            goto L_0x0065
        L_0x005c:
            r0 = 2131431668(0x7f0b10f4, float:1.8485072E38)
            android.view.View r0 = r9.getTargetView(r0)
            android.widget.RelativeLayout r0 = (android.widget.RelativeLayout) r0
        L_0x0065:
            if (r0 != 0) goto L_0x0068
            goto L_0x006e
        L_0x0068:
            r2 = r8
            android.view.View$OnClickListener r2 = (android.view.View.OnClickListener) r2
            r0.setOnClickListener(r2)
        L_0x006e:
            if (r9 != 0) goto L_0x0072
            r0 = r1
            goto L_0x0079
        L_0x0072:
            r0 = 2131431660(0x7f0b10ec, float:1.8485055E38)
            android.widget.TextView r0 = r9.getTextView(r0)
        L_0x0079:
            if (r9 != 0) goto L_0x007d
            r2 = r1
            goto L_0x0084
        L_0x007d:
            r2 = 2131431661(0x7f0b10ed, float:1.8485058E38)
            android.widget.TextView r2 = r9.getTextView(r2)
        L_0x0084:
            if (r9 != 0) goto L_0x0088
            r3 = r1
            goto L_0x008f
        L_0x0088:
            r3 = 2131431656(0x7f0b10e8, float:1.8485047E38)
            android.widget.TextView r3 = r9.getTextView(r3)
        L_0x008f:
            if (r9 != 0) goto L_0x0093
            r4 = r1
            goto L_0x009a
        L_0x0093:
            r4 = 2131431662(0x7f0b10ee, float:1.848506E38)
            android.widget.TextView r4 = r9.getTextView(r4)
        L_0x009a:
            if (r9 != 0) goto L_0x009e
            r5 = r1
            goto L_0x00a5
        L_0x009e:
            r5 = 2131431663(0x7f0b10ef, float:1.8485062E38)
            android.widget.TextView r5 = r9.getTextView(r5)
        L_0x00a5:
            if (r9 != 0) goto L_0x00a9
            r6 = r1
            goto L_0x00b0
        L_0x00a9:
            r6 = 2131431657(0x7f0b10e9, float:1.848505E38)
            android.widget.TextView r6 = r9.getTextView(r6)
        L_0x00b0:
            if (r9 != 0) goto L_0x00b4
            r7 = r1
            goto L_0x00bb
        L_0x00b4:
            r7 = 2131431664(0x7f0b10f0, float:1.8485064E38)
            android.widget.TextView r7 = r9.getTextView(r7)
        L_0x00bb:
            if (r9 != 0) goto L_0x00be
            goto L_0x00c5
        L_0x00be:
            r1 = 2131431669(0x7f0b10f5, float:1.8485074E38)
            android.widget.ImageView r1 = r9.getImageView(r1)
        L_0x00c5:
            boolean r9 = r8.f13844e
            r8.m9607a((android.widget.ImageView) r1, (boolean) r9)
            if (r0 != 0) goto L_0x00cd
            goto L_0x00d6
        L_0x00cd:
            java.lang.String r9 = r10.getSymbol()
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            r0.setText(r9)
        L_0x00d6:
            if (r3 != 0) goto L_0x00d9
            goto L_0x00e2
        L_0x00d9:
            java.lang.String r9 = r10.getReceivedMoney()
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            r3.setText(r9)
        L_0x00e2:
            if (r2 != 0) goto L_0x00e5
            goto L_0x00ee
        L_0x00e5:
            java.lang.String r9 = r10.getSymbol()
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            r2.setText(r9)
        L_0x00ee:
            if (r4 != 0) goto L_0x00f1
            goto L_0x00fa
        L_0x00f1:
            java.lang.String r9 = r10.getSymbol()
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            r4.setText(r9)
        L_0x00fa:
            if (r6 != 0) goto L_0x00fd
            goto L_0x0106
        L_0x00fd:
            java.lang.String r9 = r10.getRestMoney()
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            r6.setText(r9)
        L_0x0106:
            if (r5 != 0) goto L_0x0109
            goto L_0x0112
        L_0x0109:
            java.lang.String r9 = r10.getSymbol()
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            r5.setText(r9)
        L_0x0112:
            boolean r9 = r8.f13844e
            r8.m9608a((android.widget.TextView) r0, (boolean) r9)
            boolean r9 = r8.f13844e
            r8.m9608a((android.widget.TextView) r2, (boolean) r9)
            boolean r9 = r8.f13844e
            r8.m9608a((android.widget.TextView) r3, (boolean) r9)
            boolean r9 = r8.f13844e
            r8.m9608a((android.widget.TextView) r7, (boolean) r9)
            java.lang.Boolean r9 = r10.isFirst()
            r10 = 0
            if (r9 != 0) goto L_0x012f
            r9 = 0
            goto L_0x0133
        L_0x012f:
            boolean r9 = r9.booleanValue()
        L_0x0133:
            r1 = 8
            if (r9 != 0) goto L_0x0150
            if (r0 != 0) goto L_0x013a
            goto L_0x013d
        L_0x013a:
            r0.setVisibility(r10)
        L_0x013d:
            if (r2 != 0) goto L_0x0140
            goto L_0x0143
        L_0x0140:
            r2.setVisibility(r1)
        L_0x0143:
            if (r4 != 0) goto L_0x0146
            goto L_0x0149
        L_0x0146:
            r4.setVisibility(r10)
        L_0x0149:
            if (r5 != 0) goto L_0x014c
            goto L_0x0168
        L_0x014c:
            r5.setVisibility(r1)
            goto L_0x0168
        L_0x0150:
            if (r0 != 0) goto L_0x0153
            goto L_0x0156
        L_0x0153:
            r0.setVisibility(r1)
        L_0x0156:
            if (r2 != 0) goto L_0x0159
            goto L_0x015c
        L_0x0159:
            r2.setVisibility(r10)
        L_0x015c:
            if (r4 != 0) goto L_0x015f
            goto L_0x0162
        L_0x015f:
            r4.setVisibility(r1)
        L_0x0162:
            if (r5 != 0) goto L_0x0165
            goto L_0x0168
        L_0x0165:
            r5.setVisibility(r10)
        L_0x0168:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.framework.pages.invitation.fragment.InvitationPageFragment.m9611a(com.didi.component.common.adapter.CommonRvVH, com.didi.component.framework.pages.invitation.item.SwiperItem):void");
    }

    public void initInviteCodeView() {
        PageData pageInfo;
        RewardModel rewardModel;
        TextView textView;
        View view = this.f13841b;
        LinearLayout linearLayout = null;
        RelativeLayout relativeLayout = view == null ? null : (RelativeLayout) view.findViewById(R.id.invite_code_image);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        String str = this.f13844e ? RideOnlineImageCacheRegister.URL_INVITE_CODE_BG_GLOBAL : RideOnlineImageCacheRegister.URL_INVITE_CODE_BG_BRAZIL;
        boolean hasCache = OnlineImageCacheManager.getInstance(getContext()).hasCache(str, ICacheProvider.PROVIDER_KEY_GLIDE);
        String simpleName = InvitationPageFragment.class.getSimpleName();
        LogUtil.m26314i(simpleName, "initInviteCodeView:url = " + str + ", hasCache = " + hasCache);
        OmegaUtil.loadUrlEvent(str, hasCache);
        if (relativeLayout != null) {
            Glide.with(relativeLayout.getContext()).load(str).into(new InvitationPageFragment$initInviteCodeView$1(relativeLayout, str, hasCache, elapsedRealtime));
        }
        int i = !this.f13844e ? -16777216 : -1;
        View view2 = this.f13841b;
        if (!(view2 == null || (textView = (TextView) view2.findViewById(R.id.invite_code_title)) == null)) {
            textView.setTextColor(i);
        }
        View view3 = this.f13841b;
        AppCompatTextView appCompatTextView = view3 == null ? null : (AppCompatTextView) view3.findViewById(R.id.invite_code_number);
        if (appCompatTextView != null) {
            IInvitationListener iInvitationListener = this.f13843d;
            appCompatTextView.setText((iInvitationListener == null || (pageInfo = iInvitationListener.getPageInfo()) == null || (rewardModel = pageInfo.getRewardModel()) == null) ? null : rewardModel.getReferrerCode());
        }
        View view4 = this.f13841b;
        TextView textView2 = view4 == null ? null : (TextView) view4.findViewById(R.id.invite_code_copy_btn);
        View view5 = this.f13841b;
        if (view5 != null) {
            linearLayout = (LinearLayout) view5.findViewById(R.id.invite_code_copy_layout);
        }
        m9608a(textView2, this.f13844e);
        if (linearLayout != null) {
            linearLayout.setOnClickListener(this);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v12, resolved type: android.widget.ImageButton} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v19, resolved type: android.widget.ImageButton} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v6, resolved type: android.widget.ImageButton} */
    /* JADX WARNING: type inference failed for: r0v8, types: [android.view.View] */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0007, code lost:
        r0 = r0.getPageInfo();
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void initBottomView() {
        /*
            r12 = this;
            com.didi.component.framework.pages.invitation.fragment.IInvitationListener r0 = r12.f13843d
            r1 = 0
            if (r0 != 0) goto L_0x0007
        L_0x0005:
            r0 = r1
            goto L_0x0012
        L_0x0007:
            com.didi.component.framework.pages.invitation.model.PageData r0 = r0.getPageInfo()
            if (r0 != 0) goto L_0x000e
            goto L_0x0005
        L_0x000e:
            java.util.List r0 = r0.getShareChannelVoList()
        L_0x0012:
            r2 = 1
            r3 = 0
            if (r0 != 0) goto L_0x0018
            r5 = r1
            goto L_0x004f
        L_0x0018:
            r4 = r0
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.Iterator r4 = r4.iterator()
        L_0x001f:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x004c
            java.lang.Object r5 = r4.next()
            r6 = r5
            com.didi.component.framework.pages.invitation.model.ShareChannelVo r6 = (com.didi.component.framework.pages.invitation.model.ShareChannelVo) r6
            com.didi.component.framework.pages.promo.helper.MapToSharePlatform$Companion r7 = com.didi.component.framework.pages.promo.helper.MapToSharePlatform.Companion
            java.lang.String r6 = r6.getShareChannel()
            if (r6 != 0) goto L_0x0036
            r6 = r1
            goto L_0x003e
        L_0x0036:
            int r6 = java.lang.Integer.parseInt(r6)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
        L_0x003e:
            com.didi.onekeyshare.entity.SharePlatform r6 = r7.getMapPlatform(r6)
            com.didi.onekeyshare.entity.SharePlatform r7 = com.didi.onekeyshare.entity.SharePlatform.FACEBOOK_PLATFORM
            if (r6 != r7) goto L_0x0048
            r6 = 1
            goto L_0x0049
        L_0x0048:
            r6 = 0
        L_0x0049:
            if (r6 == 0) goto L_0x001f
            goto L_0x004d
        L_0x004c:
            r5 = r1
        L_0x004d:
            com.didi.component.framework.pages.invitation.model.ShareChannelVo r5 = (com.didi.component.framework.pages.invitation.model.ShareChannelVo) r5
        L_0x004f:
            if (r5 != 0) goto L_0x0052
            goto L_0x0068
        L_0x0052:
            android.content.Context r4 = r12.getContext()
            com.didi.global.ninja.Ninja r4 = com.didi.global.ninja.Ninja.getInstance(r4)
            java.lang.String r6 = "FACEBOOK_SHARE"
            boolean r4 = r4.isHit(r6)
            if (r4 == 0) goto L_0x0068
            if (r0 != 0) goto L_0x0065
            goto L_0x0068
        L_0x0065:
            r0.remove(r5)
        L_0x0068:
            com.didi.component.framework.pages.invitation.presenter.InvitationHomePresenter r4 = r12.f13842c
            if (r4 != 0) goto L_0x006e
            r4 = r1
            goto L_0x0094
        L_0x006e:
            com.didi.component.framework.pages.invitation.fragment.IInvitationListener r5 = r12.f13843d
            if (r5 != 0) goto L_0x0074
        L_0x0072:
            r5 = r1
            goto L_0x007f
        L_0x0074:
            com.didi.component.framework.pages.invitation.model.PageData r5 = r5.getPageInfo()
            if (r5 != 0) goto L_0x007b
            goto L_0x0072
        L_0x007b:
            com.didi.component.framework.pages.invitation.model.ShareUrlModel r5 = r5.getShareUrlModel()
        L_0x007f:
            com.didi.component.framework.pages.invitation.fragment.IInvitationListener r6 = r12.f13843d
            if (r6 != 0) goto L_0x0085
        L_0x0083:
            r6 = r1
            goto L_0x0090
        L_0x0085:
            com.didi.component.framework.pages.invitation.model.PageData r6 = r6.getPageInfo()
            if (r6 != 0) goto L_0x008c
            goto L_0x0083
        L_0x008c:
            com.didi.component.framework.pages.invitation.model.InviteCode r6 = r6.getInviteCode()
        L_0x0090:
            java.util.List r4 = r4.generateKeyShareInfoList(r0, r5, r6)
        L_0x0094:
            if (r0 != 0) goto L_0x0097
            return
        L_0x0097:
            if (r4 != 0) goto L_0x009a
            return
        L_0x009a:
            int r5 = r4.size()
            r6 = 3
            if (r5 < r6) goto L_0x0211
            r5 = r12
            androidx.fragment.app.Fragment r5 = (androidx.fragment.app.Fragment) r5
            com.bumptech.glide.RequestManager r6 = com.bumptech.glide.Glide.with((androidx.fragment.app.Fragment) r5)
            java.lang.Object r7 = r4.get(r3)
            com.didi.sharesdk.OneKeyShareModel r7 = (com.didi.sharesdk.OneKeyShareModel) r7
            java.util.HashMap<java.lang.String, java.lang.String> r7 = r7.extra
            java.lang.String r8 = "shareIcon"
            java.lang.String r9 = ""
            if (r7 != 0) goto L_0x00b8
        L_0x00b6:
            r7 = r9
            goto L_0x00c1
        L_0x00b8:
            java.lang.Object r7 = r7.get(r8)
            java.lang.String r7 = (java.lang.String) r7
            if (r7 != 0) goto L_0x00c1
            goto L_0x00b6
        L_0x00c1:
            com.bumptech.glide.RequestBuilder r6 = r6.load((java.lang.String) r7)
            r7 = 2131233461(0x7f080ab5, float:1.808306E38)
            com.bumptech.glide.request.BaseRequestOptions r6 = r6.placeholder((int) r7)
            com.bumptech.glide.RequestBuilder r6 = (com.bumptech.glide.RequestBuilder) r6
            com.bumptech.glide.request.BaseRequestOptions r6 = r6.error((int) r7)
            com.bumptech.glide.RequestBuilder r6 = (com.bumptech.glide.RequestBuilder) r6
            android.view.View r10 = r12.f13841b
            r11 = 2131431571(0x7f0b1093, float:1.8484875E38)
            if (r10 != 0) goto L_0x00dd
            r10 = r1
            goto L_0x00e3
        L_0x00dd:
            android.view.View r10 = r10.findViewById(r11)
            android.widget.ImageButton r10 = (android.widget.ImageButton) r10
        L_0x00e3:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)
            android.widget.ImageView r10 = (android.widget.ImageView) r10
            r6.into((android.widget.ImageView) r10)
            android.view.View r6 = r12.f13841b
            if (r6 != 0) goto L_0x00f1
            r6 = r1
            goto L_0x00fa
        L_0x00f1:
            r10 = 2131431572(0x7f0b1094, float:1.8484877E38)
            android.view.View r6 = r6.findViewById(r10)
            android.widget.TextView r6 = (android.widget.TextView) r6
        L_0x00fa:
            if (r6 != 0) goto L_0x00fd
            goto L_0x010c
        L_0x00fd:
            java.lang.Object r3 = r0.get(r3)
            com.didi.component.framework.pages.invitation.model.ShareChannelVo r3 = (com.didi.component.framework.pages.invitation.model.ShareChannelVo) r3
            java.lang.String r3 = r3.getShareName()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r6.setText(r3)
        L_0x010c:
            com.bumptech.glide.RequestManager r3 = com.bumptech.glide.Glide.with((androidx.fragment.app.Fragment) r5)
            java.lang.Object r6 = r4.get(r2)
            com.didi.sharesdk.OneKeyShareModel r6 = (com.didi.sharesdk.OneKeyShareModel) r6
            java.util.HashMap<java.lang.String, java.lang.String> r6 = r6.extra
            if (r6 != 0) goto L_0x011c
        L_0x011a:
            r6 = r9
            goto L_0x0125
        L_0x011c:
            java.lang.Object r6 = r6.get(r8)
            java.lang.String r6 = (java.lang.String) r6
            if (r6 != 0) goto L_0x0125
            goto L_0x011a
        L_0x0125:
            com.bumptech.glide.RequestBuilder r3 = r3.load((java.lang.String) r6)
            com.bumptech.glide.request.BaseRequestOptions r3 = r3.placeholder((int) r7)
            com.bumptech.glide.RequestBuilder r3 = (com.bumptech.glide.RequestBuilder) r3
            com.bumptech.glide.request.BaseRequestOptions r3 = r3.error((int) r7)
            com.bumptech.glide.RequestBuilder r3 = (com.bumptech.glide.RequestBuilder) r3
            android.view.View r6 = r12.f13841b
            r10 = 2131431573(0x7f0b1095, float:1.848488E38)
            if (r6 != 0) goto L_0x013e
            r6 = r1
            goto L_0x0144
        L_0x013e:
            android.view.View r6 = r6.findViewById(r10)
            android.widget.ImageButton r6 = (android.widget.ImageButton) r6
        L_0x0144:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            r3.into((android.widget.ImageView) r6)
            android.view.View r3 = r12.f13841b
            if (r3 != 0) goto L_0x0152
            r3 = r1
            goto L_0x015b
        L_0x0152:
            r6 = 2131431574(0x7f0b1096, float:1.8484881E38)
            android.view.View r3 = r3.findViewById(r6)
            android.widget.TextView r3 = (android.widget.TextView) r3
        L_0x015b:
            if (r3 != 0) goto L_0x015e
            goto L_0x016d
        L_0x015e:
            java.lang.Object r2 = r0.get(r2)
            com.didi.component.framework.pages.invitation.model.ShareChannelVo r2 = (com.didi.component.framework.pages.invitation.model.ShareChannelVo) r2
            java.lang.String r2 = r2.getShareName()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r3.setText(r2)
        L_0x016d:
            com.bumptech.glide.RequestManager r2 = com.bumptech.glide.Glide.with((androidx.fragment.app.Fragment) r5)
            r3 = 2
            java.lang.Object r5 = r4.get(r3)
            com.didi.sharesdk.OneKeyShareModel r5 = (com.didi.sharesdk.OneKeyShareModel) r5
            java.util.HashMap<java.lang.String, java.lang.String> r5 = r5.extra
            if (r5 != 0) goto L_0x017d
            goto L_0x0187
        L_0x017d:
            java.lang.Object r5 = r5.get(r8)
            java.lang.String r5 = (java.lang.String) r5
            if (r5 != 0) goto L_0x0186
            goto L_0x0187
        L_0x0186:
            r9 = r5
        L_0x0187:
            com.bumptech.glide.RequestBuilder r2 = r2.load((java.lang.String) r9)
            com.bumptech.glide.request.BaseRequestOptions r2 = r2.placeholder((int) r7)
            com.bumptech.glide.RequestBuilder r2 = (com.bumptech.glide.RequestBuilder) r2
            com.bumptech.glide.request.BaseRequestOptions r2 = r2.error((int) r7)
            com.bumptech.glide.RequestBuilder r2 = (com.bumptech.glide.RequestBuilder) r2
            android.view.View r5 = r12.f13841b
            r6 = 2131431575(0x7f0b1097, float:1.8484883E38)
            if (r5 != 0) goto L_0x01a0
            r5 = r1
            goto L_0x01a6
        L_0x01a0:
            android.view.View r5 = r5.findViewById(r6)
            android.widget.ImageButton r5 = (android.widget.ImageButton) r5
        L_0x01a6:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            r2.into((android.widget.ImageView) r5)
            android.view.View r2 = r12.f13841b
            if (r2 != 0) goto L_0x01b4
            r2 = r1
            goto L_0x01bd
        L_0x01b4:
            r5 = 2131431576(0x7f0b1098, float:1.8484885E38)
            android.view.View r2 = r2.findViewById(r5)
            android.widget.TextView r2 = (android.widget.TextView) r2
        L_0x01bd:
            if (r2 != 0) goto L_0x01c0
            goto L_0x01cf
        L_0x01c0:
            java.lang.Object r0 = r0.get(r3)
            com.didi.component.framework.pages.invitation.model.ShareChannelVo r0 = (com.didi.component.framework.pages.invitation.model.ShareChannelVo) r0
            java.lang.String r0 = r0.getShareName()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r2.setText(r0)
        L_0x01cf:
            android.view.View r0 = r12.f13841b
            if (r0 != 0) goto L_0x01d4
            goto L_0x01e5
        L_0x01d4:
            android.view.View r0 = r0.findViewById(r11)
            android.widget.ImageButton r0 = (android.widget.ImageButton) r0
            if (r0 != 0) goto L_0x01dd
            goto L_0x01e5
        L_0x01dd:
            com.didi.component.framework.pages.invitation.fragment.-$$Lambda$InvitationPageFragment$Es7D4pVJzkaKGDLHVgvSUJgLv0s r2 = new com.didi.component.framework.pages.invitation.fragment.-$$Lambda$InvitationPageFragment$Es7D4pVJzkaKGDLHVgvSUJgLv0s
            r2.<init>(r4)
            r0.setOnClickListener(r2)
        L_0x01e5:
            android.view.View r0 = r12.f13841b
            if (r0 != 0) goto L_0x01ea
            goto L_0x01fb
        L_0x01ea:
            android.view.View r0 = r0.findViewById(r10)
            android.widget.ImageButton r0 = (android.widget.ImageButton) r0
            if (r0 != 0) goto L_0x01f3
            goto L_0x01fb
        L_0x01f3:
            com.didi.component.framework.pages.invitation.fragment.-$$Lambda$InvitationPageFragment$GHm2Sytu15UOMU8LKX9tSLP06Ps r2 = new com.didi.component.framework.pages.invitation.fragment.-$$Lambda$InvitationPageFragment$GHm2Sytu15UOMU8LKX9tSLP06Ps
            r2.<init>(r4)
            r0.setOnClickListener(r2)
        L_0x01fb:
            android.view.View r0 = r12.f13841b
            if (r0 != 0) goto L_0x0200
            goto L_0x0211
        L_0x0200:
            android.view.View r0 = r0.findViewById(r6)
            android.widget.ImageButton r0 = (android.widget.ImageButton) r0
            if (r0 != 0) goto L_0x0209
            goto L_0x0211
        L_0x0209:
            com.didi.component.framework.pages.invitation.fragment.-$$Lambda$InvitationPageFragment$o_o_VZsqcrTrKiQM-ebEUJGmucM r2 = new com.didi.component.framework.pages.invitation.fragment.-$$Lambda$InvitationPageFragment$o_o_VZsqcrTrKiQM-ebEUJGmucM
            r2.<init>(r4)
            r0.setOnClickListener(r2)
        L_0x0211:
            android.view.View r0 = r12.f13841b
            if (r0 != 0) goto L_0x0216
            goto L_0x022a
        L_0x0216:
            r2 = 2131431578(0x7f0b109a, float:1.848489E38)
            android.view.View r0 = r0.findViewById(r2)
            android.widget.ImageButton r0 = (android.widget.ImageButton) r0
            if (r0 != 0) goto L_0x0222
            goto L_0x022a
        L_0x0222:
            com.didi.component.framework.pages.invitation.fragment.-$$Lambda$InvitationPageFragment$zFb_L25T4LY0PGtybtLmeJb8WkM r2 = new com.didi.component.framework.pages.invitation.fragment.-$$Lambda$InvitationPageFragment$zFb_L25T4LY0PGtybtLmeJb8WkM
            r2.<init>(r4, r12)
            r0.setOnClickListener(r2)
        L_0x022a:
            android.view.View r0 = r12.f13841b
            r2 = 2131431583(0x7f0b109f, float:1.84849E38)
            if (r0 != 0) goto L_0x0232
            goto L_0x0241
        L_0x0232:
            android.view.View r0 = r0.findViewById(r2)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 != 0) goto L_0x023b
            goto L_0x0241
        L_0x023b:
            r3 = r12
            android.view.View$OnClickListener r3 = (android.view.View.OnClickListener) r3
            r0.setOnClickListener(r3)
        L_0x0241:
            android.view.View r0 = r12.f13841b
            if (r0 != 0) goto L_0x0247
            r0 = r1
            goto L_0x024d
        L_0x0247:
            android.view.View r0 = r0.findViewById(r2)
            android.widget.TextView r0 = (android.widget.TextView) r0
        L_0x024d:
            boolean r2 = r12.f13844e
            r12.m9608a((android.widget.TextView) r0, (boolean) r2)
            android.view.View r0 = r12.f13841b
            if (r0 != 0) goto L_0x0257
            goto L_0x0261
        L_0x0257:
            r1 = 2131431582(0x7f0b109e, float:1.8484897E38)
            android.view.View r0 = r0.findViewById(r1)
            r1 = r0
            android.widget.ImageView r1 = (android.widget.ImageView) r1
        L_0x0261:
            boolean r0 = r12.f13844e
            r12.m9607a((android.widget.ImageView) r1, (boolean) r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.framework.pages.invitation.fragment.InvitationPageFragment.initBottomView():void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m9614a(InvitationPageFragment invitationPageFragment, List list, View view) {
        Intrinsics.checkNotNullParameter(invitationPageFragment, "this$0");
        invitationPageFragment.m9616a((OneKeyShareModel) list.get(0));
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m9619b(InvitationPageFragment invitationPageFragment, List list, View view) {
        Intrinsics.checkNotNullParameter(invitationPageFragment, "this$0");
        invitationPageFragment.m9616a((OneKeyShareModel) list.get(1));
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static final void m9621c(InvitationPageFragment invitationPageFragment, List list, View view) {
        Intrinsics.checkNotNullParameter(invitationPageFragment, "this$0");
        invitationPageFragment.m9616a((OneKeyShareModel) list.get(2));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m9618a(List list, InvitationPageFragment invitationPageFragment, View view) {
        OneKeyShareModel oneKeyShareModel;
        Object obj;
        Intrinsics.checkNotNullParameter(invitationPageFragment, "this$0");
        if (list.size() >= 4) {
            obj = list.get(3);
        } else if (list.size() == 3) {
            obj = list.get(2);
        } else {
            oneKeyShareModel = null;
            invitationPageFragment.m9620b(oneKeyShareModel);
            invitationPageFragment.m9617a(TrackEvent.REFERHOME_SHAREBR_CK, (Integer) 7, invitationPageFragment.f13850k);
        }
        oneKeyShareModel = (OneKeyShareModel) obj;
        invitationPageFragment.m9620b(oneKeyShareModel);
        invitationPageFragment.m9617a(TrackEvent.REFERHOME_SHAREBR_CK, (Integer) 7, invitationPageFragment.f13850k);
    }

    /* renamed from: a */
    private final void m9608a(TextView textView, boolean z) {
        int color = ResourcesHelper.getColor(getContext(), R.color.pe_color_fe7f3f);
        if (!z) {
            color = ResourcesHelper.getColor(getContext(), R.color.pe_color_fea330);
        }
        if (textView != null) {
            textView.setTextColor(color);
        }
    }

    /* renamed from: a */
    private final void m9607a(ImageView imageView, boolean z) {
        Drawable drawable = ResourcesHelper.getDrawable(requireActivity(), z ? R.drawable.global_invite_code_use_arrow_global : R.drawable.global_invite_code_use_arrow_99);
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
        }
    }

    public void showCopyToastView() {
        ToastHelperKt.toast(this, ResourcesHelper.getString(requireActivity(), R.string.global_invite_copy_toast));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.lang.Long} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: com.didi.component.framework.pages.invitation.model.InviteCode} */
    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v5 */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onClick(android.view.View r8) {
        /*
            r7 = this;
            com.didi.autotracker.AutoTrackHelper.trackViewOnClick(r8)
            r0 = 0
            if (r8 != 0) goto L_0x0008
            r8 = r0
            goto L_0x0010
        L_0x0008:
            int r8 = r8.getId()
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
        L_0x0010:
            r1 = 2131431668(0x7f0b10f4, float:1.8485072E38)
            if (r8 != 0) goto L_0x0016
            goto L_0x0032
        L_0x0016:
            int r2 = r8.intValue()
            if (r2 != r1) goto L_0x0032
            com.didi.component.framework.pages.invitation.fragment.IInvitationListener r8 = r7.f13843d
            if (r8 != 0) goto L_0x0021
            goto L_0x0026
        L_0x0021:
            java.lang.String r0 = "track"
            r8.switchToTargetPage(r0)
        L_0x0026:
            r3 = 0
            java.lang.Long r4 = r7.f13850k
            r5 = 2
            r6 = 0
            java.lang.String r2 = "PasMark_RefererHome_Track_ck"
            r1 = r7
            m9613a(r1, r2, r3, r4, r5, r6)
            goto L_0x007d
        L_0x0032:
            r1 = 2131431569(0x7f0b1091, float:1.848487E38)
            if (r8 != 0) goto L_0x0038
            goto L_0x0052
        L_0x0038:
            int r2 = r8.intValue()
            if (r2 != r1) goto L_0x0052
            com.didi.component.framework.pages.invitation.fragment.IInvitationListener r8 = r7.f13843d
            if (r8 != 0) goto L_0x0043
            goto L_0x004e
        L_0x0043:
            com.didi.component.framework.pages.invitation.model.PageData r8 = r8.getPageInfo()
            if (r8 != 0) goto L_0x004a
            goto L_0x004e
        L_0x004a:
            com.didi.component.framework.pages.invitation.model.InviteCode r0 = r8.getInviteCode()
        L_0x004e:
            r7.m9615a((com.didi.component.framework.pages.invitation.model.InviteCode) r0)
            goto L_0x007d
        L_0x0052:
            r1 = 2131431583(0x7f0b109f, float:1.84849E38)
            if (r8 != 0) goto L_0x0058
            goto L_0x007d
        L_0x0058:
            int r8 = r8.intValue()
            if (r8 != r1) goto L_0x007d
            com.didi.component.framework.pages.invitation.presenter.InvitationHomePresenter r8 = r7.f13842c
            if (r8 != 0) goto L_0x0063
            goto L_0x007d
        L_0x0063:
            com.didi.component.framework.pages.invitation.fragment.IInvitationListener r1 = r7.f13843d
            if (r1 != 0) goto L_0x0068
            goto L_0x007a
        L_0x0068:
            com.didi.component.framework.pages.invitation.model.PageData r1 = r1.getPageInfo()
            if (r1 != 0) goto L_0x006f
            goto L_0x007a
        L_0x006f:
            com.didi.component.framework.pages.invitation.model.RedirectModel r1 = r1.getRedirectModel()
            if (r1 != 0) goto L_0x0076
            goto L_0x007a
        L_0x0076:
            java.lang.Long r0 = r1.getActivityId()
        L_0x007a:
            r8.goToTargetWeb(r0)
        L_0x007d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.framework.pages.invitation.fragment.InvitationPageFragment.onClick(android.view.View):void");
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
    private final void m9615a(com.didi.component.framework.pages.invitation.model.InviteCode r20) {
        /*
            r19 = this;
            r6 = r19
            com.didi.component.framework.pages.invitation.fragment.IInvitationListener r0 = r6.f13843d
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
            java.lang.String r15 = r6.f13846g
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
            java.lang.String r15 = r6.f13846g
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
            com.didi.component.framework.pages.invitation.fragment.IInvitationListener r3 = r6.f13843d
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
            java.lang.Long r3 = r6.f13850k
            r4 = 2
            r5 = 0
            java.lang.String r1 = "PasMark_RefererHome_ReferBt_ck"
            r0 = r19
            m9613a(r0, r1, r2, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.framework.pages.invitation.fragment.InvitationPageFragment.m9615a(com.didi.component.framework.pages.invitation.model.InviteCode):void");
    }

    /* renamed from: a */
    private final void m9616a(OneKeyShareModel oneKeyShareModel) {
        if (oneKeyShareModel != null) {
            Integer num = null;
            ShareApi.show((Activity) requireActivity(), oneKeyShareModel, (ICallback.IPlatformShareCallback) null);
            InvitationHomePresenter invitationHomePresenter = this.f13842c;
            if (invitationHomePresenter != null) {
                num = Integer.valueOf(invitationHomePresenter.convertToShareChannel(oneKeyShareModel));
            }
            m9617a(TrackEvent.REFERHOME_SHAREBR_CK, num, this.f13850k);
        }
    }

    /* renamed from: b */
    private final void m9620b(OneKeyShareModel oneKeyShareModel) {
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

    /* renamed from: a */
    static /* synthetic */ void m9613a(InvitationPageFragment invitationPageFragment, String str, Integer num, Long l, int i, Object obj) {
        if ((i & 2) != 0) {
            num = null;
        }
        if ((i & 4) != 0) {
            l = null;
        }
        invitationPageFragment.m9617a(str, num, l);
    }

    /* renamed from: a */
    private final void m9617a(String str, Integer num, Long l) {
        InvitationHomePresenter invitationHomePresenter = this.f13842c;
        if (invitationHomePresenter != null) {
            invitationHomePresenter.traceEvent(str, NationComponentDataUtil.getToken(), Integer.valueOf(this.f13851l), this.f13848i, this.f13852m, this.f13849j, num, l, this.f13853n);
        }
    }

    public String gotRefereeMoney() {
        return this.f13846g;
    }

    public String gotRefererMoney() {
        return this.f13847h;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0015, code lost:
        r0 = (r0 = (r0 = r0.getPageInfo()).getRewardModel()).getReferrerCode();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String gotPromoCode() {
        /*
            r2 = this;
            com.didi.component.framework.pages.invitation.fragment.IInvitationListener r0 = r2.f13843d
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
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.framework.pages.invitation.fragment.InvitationPageFragment.gotPromoCode():java.lang.String");
    }

    public View getView() {
        return this.f13841b;
    }
}
