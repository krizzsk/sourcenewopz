package com.didi.component.framework.pages.promo.fragment;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.NationComponentDataUtil;
import com.didi.component.common.adapter.CommonRvAdapter;
import com.didi.component.common.util.LocationController;
import com.didi.component.framework.pages.promo.PromoCodePage;
import com.didi.component.framework.pages.promo.helper.MapToSharePlatform;
import com.didi.component.framework.pages.promo.model.PromoData;
import com.didi.component.framework.pages.promo.model.PromoShareBtnModel;
import com.didi.component.framework.pages.promo.model.PromoShareItem;
import com.didi.component.framework.pages.promo.presenter.PromoSharePresenter;
import com.didi.component.framework.pages.promo.view.IPromoShareView;
import com.didi.onekeyshare.callback.ICallback;
import com.didi.onekeyshare.entity.OneKeyShareInfo;
import com.didi.onekeyshare.view.fragment.PlatformClickListener;
import com.didi.onekeyshare.wrapper.ShareWrapper;
import com.didi.sdk.home.BizEntranceFragment;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.webview.WebTitleBar;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 ?2\u00020\u00012\u00020\u0002:\u0001?B\u0005¢\u0006\u0002\u0010\u0003J\u001a\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\bH\u0002J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u0018H\u0002J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\n\u0010\u001d\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u001e\u001a\u00020\u0013H\u0002J\u0016\u0010\u001f\u001a\u00020\u00132\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016J\u0010\u0010!\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020#H\u0016J\u0018\u0010$\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020&H\u0002J&\u0010'\u001a\u0004\u0018\u00010\u000e2\u0006\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u0010\u0010.\u001a\u00020\u00132\u0006\u0010/\u001a\u000200H\u0002J\u0012\u00101\u001a\u00020\u00132\b\u00102\u001a\u0004\u0018\u00010\fH\u0016J(\u00103\u001a\u00020\u00132\u0016\u00104\u001a\u0012\u0012\u0004\u0012\u00020005j\b\u0012\u0004\u0012\u000200`62\u0006\u00107\u001a\u000208H\u0016J\u0016\u00109\u001a\u00020\u00132\f\u0010 \u001a\b\u0012\u0004\u0012\u00020&0\u0007H\u0016J-\u0010:\u001a\u00020\u00132\u0006\u0010;\u001a\u00020\u00052\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010=\u001a\u0004\u0018\u00010#H\u0002¢\u0006\u0002\u0010>R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000¨\u0006@"}, mo175978d2 = {"Lcom/didi/component/framework/pages/promo/fragment/PromoShareFragment;", "Lcom/didi/sdk/home/BizEntranceFragment;", "Lcom/didi/component/framework/pages/promo/view/IPromoShareView;", "()V", "mCountryCode", "", "mList", "", "Lcom/didi/component/framework/pages/promo/model/PromoShareItem;", "mListener", "Lcom/didi/component/framework/pages/promo/fragment/ActionListener;", "mPresenter", "Lcom/didi/component/framework/pages/promo/presenter/PromoSharePresenter;", "mRootView", "Landroid/view/View;", "mTitle", "mTitleBar", "Lcom/didi/sdk/webview/WebTitleBar;", "binDataToView", "", "holder", "Lcom/didi/component/common/adapter/CommonRvVH;", "item", "getAdapter", "Lcom/didi/component/common/adapter/CommonRvAdapter;", "getFallbackView", "getLayoutId", "", "position", "getView", "initBottomViewColor", "initRecyclerView", "list", "isShowShareBottomView", "isShow", "", "loadImageAndText", "shareBtnModel", "Lcom/didi/component/framework/pages/promo/model/PromoShareBtnModel;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "performItemClick", "shareItem", "Lcom/didi/onekeyshare/entity/OneKeyShareInfo;", "setPresenter", "presenter", "showShareDialog", "info", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "callback", "Lcom/didi/onekeyshare/view/fragment/PlatformClickListener;", "showSomeShareChannel", "traceEvent", "event", "channel", "hasBtn", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "Companion", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PromoShareFragment.kt */
public final class PromoShareFragment extends BizEntranceFragment implements IPromoShareView {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: h */
    private static final String f13928h = "countryCode";

    /* renamed from: i */
    private static final String f13929i = "title";

    /* renamed from: a */
    private View f13930a;

    /* renamed from: b */
    private PromoSharePresenter f13931b;

    /* renamed from: c */
    private ActionListener f13932c;

    /* renamed from: d */
    private WebTitleBar f13933d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public List<PromoShareItem> f13934e = new ArrayList();

    /* renamed from: f */
    private String f13935f = "br";

    /* renamed from: g */
    private String f13936g = "";

    public void _$_clearFindViewByIdCache() {
    }

    public void setPresenter(PromoSharePresenter promoSharePresenter) {
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        WebTitleBar webTitleBar;
        ImageButton imageButton;
        String str;
        String string;
        String string2;
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.global_fragment_coupon_share, viewGroup, false);
        this.f13930a = inflate;
        PromoData promoData = null;
        if (inflate == null) {
            webTitleBar = null;
        } else {
            webTitleBar = (WebTitleBar) inflate.findViewById(R.id.center_title_bar);
        }
        this.f13933d = webTitleBar;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        PromoSharePresenter promoSharePresenter = new PromoSharePresenter(requireActivity);
        this.f13931b = promoSharePresenter;
        if (promoSharePresenter != null) {
            promoSharePresenter.setIView(this);
        }
        FragmentActivity activity = getActivity();
        this.f13932c = activity instanceof ActionListener ? (ActionListener) activity : null;
        Bundle arguments = getArguments();
        String str2 = "br";
        if (!(arguments == null || (string2 = arguments.getString("countryCode")) == null)) {
            str2 = string2;
        }
        this.f13935f = str2;
        Bundle arguments2 = getArguments();
        String str3 = "";
        if (!(arguments2 == null || (string = arguments2.getString("title")) == null)) {
            str3 = string;
        }
        this.f13936g = str3;
        WebTitleBar webTitleBar2 = this.f13933d;
        if (webTitleBar2 != null) {
            if (str3.length() > 0) {
                str = this.f13936g;
            } else {
                str = ResourcesHelper.getString(requireActivity(), R.string.global_promo_code_top);
            }
            webTitleBar2.setTitle(str);
        }
        WebTitleBar webTitleBar3 = this.f13933d;
        if (webTitleBar3 != null) {
            webTitleBar3.setCloseBtnVisibility(8);
        }
        WebTitleBar webTitleBar4 = this.f13933d;
        if (webTitleBar4 != null) {
            webTitleBar4.setMoreBtnVisibility(8);
        }
        WebTitleBar webTitleBar5 = this.f13933d;
        if (webTitleBar5 != null) {
            webTitleBar5.setBackBtnVisibility(0);
        }
        WebTitleBar webTitleBar6 = this.f13933d;
        TextView middleTv = webTitleBar6 == null ? null : webTitleBar6.getMiddleTv();
        if (middleTv != null) {
            middleTv.setTypeface(Typeface.DEFAULT_BOLD);
        }
        WebTitleBar webTitleBar7 = this.f13933d;
        TextView middleTv2 = webTitleBar7 == null ? null : webTitleBar7.getMiddleTv();
        if (middleTv2 != null) {
            middleTv2.setTextSize(21.0f);
        }
        WebTitleBar webTitleBar8 = this.f13933d;
        if (webTitleBar8 != null) {
            webTitleBar8.setOnBackClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    PromoShareFragment.m9657a(PromoShareFragment.this, view);
                }
            });
        }
        PromoSharePresenter promoSharePresenter2 = this.f13931b;
        if (promoSharePresenter2 != null) {
            ActionListener actionListener = this.f13932c;
            if (actionListener != null) {
                promoData = actionListener.getRspData();
            }
            promoSharePresenter2.generateRvItemAndOther(promoData);
        }
        View view = this.f13930a;
        if (!(view == null || (imageButton = (ImageButton) view.findViewById(R.id.global_promo_share_rr)) == null)) {
            imageButton.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    PromoShareFragment.m9663b(PromoShareFragment.this, view);
                }
            });
        }
        View view2 = this.f13930a;
        if (view2 != null) {
            view2.post(new Runnable() {
                public final void run() {
                    PromoShareFragment.m9656a(PromoShareFragment.this);
                }
            });
        }
        return this.f13930a;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m9657a(PromoShareFragment promoShareFragment, View view) {
        Intrinsics.checkNotNullParameter(promoShareFragment, "this$0");
        ActionListener actionListener = promoShareFragment.f13932c;
        if (actionListener != null) {
            actionListener.onBackArrowClick(PromoCodePage.PAGE_SHARE);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m9663b(PromoShareFragment promoShareFragment, View view) {
        Intrinsics.checkNotNullParameter(promoShareFragment, "this$0");
        PromoSharePresenter promoSharePresenter = promoShareFragment.f13931b;
        if (promoSharePresenter != null) {
            promoSharePresenter.getShareInfoAll(new PromoShareFragment$onCreateView$2$1(promoShareFragment));
        }
        m9659a(promoShareFragment, MapToSharePlatform.PROMO_MORE_CLICK, "More", (Boolean) null, 4, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m9656a(PromoShareFragment promoShareFragment) {
        Intrinsics.checkNotNullParameter(promoShareFragment, "this$0");
        promoShareFragment.m9662b();
    }

    @Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, mo175978d2 = {"Lcom/didi/component/framework/pages/promo/fragment/PromoShareFragment$Companion;", "", "()V", "COUNTRY_CODE", "", "TITLE", "newInstance", "Lcom/didi/component/framework/pages/promo/fragment/PromoShareFragment;", "countryCode", "title", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PromoShareFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PromoShareFragment newInstance(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "countryCode");
            Intrinsics.checkNotNullParameter(str2, "title");
            PromoShareFragment promoShareFragment = new PromoShareFragment();
            Bundle bundle = new Bundle();
            bundle.putString("countryCode", str);
            bundle.putString("title", str2);
            promoShareFragment.setArguments(bundle);
            return promoShareFragment;
        }
    }

    public WebTitleBar getFallbackView() {
        return this.f13933d;
    }

    public void isShowShareBottomView(boolean z) {
        m9659a(this, MapToSharePlatform.PROMO_SHARE_PAGE, (String) null, Boolean.valueOf(z), 2, (Object) null);
        View view = this.f13930a;
        LinearLayout linearLayout = view == null ? null : (LinearLayout) view.findViewById(R.id.global_promo_bottom_share);
        if (linearLayout != null) {
            linearLayout.setVisibility(z ? 0 : 8);
        }
    }

    public View getView() {
        return this.f13930a;
    }

    public void showShareDialog(ArrayList<OneKeyShareInfo> arrayList, PlatformClickListener platformClickListener) {
        Intrinsics.checkNotNullParameter(arrayList, "info");
        Intrinsics.checkNotNullParameter(platformClickListener, "callback");
        ActionListener actionListener = this.f13932c;
        if (actionListener != null) {
            actionListener.showShareDialog(arrayList, platformClickListener);
        }
    }

    public void showSomeShareChannel(List<PromoShareBtnModel> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        if (list.size() >= 3) {
            m9654a(0, list.get(0));
            m9654a(1, list.get(1));
            m9654a(2, list.get(2));
        }
    }

    /* renamed from: a */
    private final void m9660a(OneKeyShareInfo oneKeyShareInfo) {
        ShareWrapper.shareToPlatform(getActivity(), oneKeyShareInfo, (ICallback.IPlatformShareCallback) null);
        m9659a(this, MapToSharePlatform.PROMO_CHANNEL_CLICK, oneKeyShareInfo.platform.platformName(), (Boolean) null, 4, (Object) null);
    }

    /* renamed from: a */
    private final CommonRvAdapter<PromoShareItem> m9653a() {
        return new PromoShareFragment$getAdapter$1(this, requireActivity());
    }

    /* JADX WARNING: type inference failed for: r6v2, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void initRecyclerView(java.util.List<com.didi.component.framework.pages.promo.model.PromoShareItem> r6) {
        /*
            r5 = this;
            java.lang.String r0 = "list"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            r5.f13934e = r6
            android.view.View r0 = r5.f13930a
            r1 = 0
            r2 = 2131431131(0x7f0b0edb, float:1.8483983E38)
            if (r0 != 0) goto L_0x0011
            r0 = r1
            goto L_0x0017
        L_0x0011:
            android.view.View r0 = r0.findViewById(r2)
            androidx.recyclerview.widget.RecyclerView r0 = (androidx.recyclerview.widget.RecyclerView) r0
        L_0x0017:
            if (r0 != 0) goto L_0x001a
            goto L_0x002a
        L_0x001a:
            androidx.recyclerview.widget.LinearLayoutManager r3 = new androidx.recyclerview.widget.LinearLayoutManager
            androidx.fragment.app.FragmentActivity r4 = r5.requireActivity()
            android.content.Context r4 = (android.content.Context) r4
            r3.<init>(r4)
            androidx.recyclerview.widget.RecyclerView$LayoutManager r3 = (androidx.recyclerview.widget.RecyclerView.LayoutManager) r3
            r0.setLayoutManager(r3)
        L_0x002a:
            com.didi.component.common.adapter.CommonRvAdapter r0 = r5.m9653a()
            r0.setMData(r6)
            android.view.View r6 = r5.f13930a
            if (r6 != 0) goto L_0x0036
            goto L_0x003d
        L_0x0036:
            android.view.View r6 = r6.findViewById(r2)
            r1 = r6
            androidx.recyclerview.widget.RecyclerView r1 = (androidx.recyclerview.widget.RecyclerView) r1
        L_0x003d:
            if (r1 != 0) goto L_0x0040
            goto L_0x0045
        L_0x0040:
            androidx.recyclerview.widget.RecyclerView$Adapter r0 = (androidx.recyclerview.widget.RecyclerView.Adapter) r0
            r1.setAdapter(r0)
        L_0x0045:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.framework.pages.promo.fragment.PromoShareFragment.initRecyclerView(java.util.List):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final int m9652a(int i) {
        Collection collection = this.f13934e;
        if (collection == null || collection.isEmpty()) {
            return 0;
        }
        int type = this.f13934e.get(i).getType();
        if (type != 1) {
            return type != 2 ? R.layout.global_promo_share_coupon_item : R.layout.global_promo_share_text_item;
        }
        return R.layout.global_promo_share_item_img;
    }

    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v1, types: [android.widget.ImageView, java.lang.Object] */
    /* JADX WARNING: type inference failed for: r1v3, types: [android.widget.TextView] */
    /* JADX WARNING: type inference failed for: r1v5, types: [android.widget.TextView] */
    /* JADX WARNING: type inference failed for: r1v8 */
    /* JADX WARNING: type inference failed for: r1v9 */
    /* JADX WARNING: type inference failed for: r1v10 */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m9655a(com.didi.component.common.adapter.CommonRvVH r11, com.didi.component.framework.pages.promo.model.PromoShareItem r12) {
        /*
            r10 = this;
            int r0 = r12.getType()
            r1 = 0
            r2 = 1
            if (r0 == r2) goto L_0x018f
            r3 = 2
            if (r0 == r3) goto L_0x0178
            r4 = 3
            if (r0 == r4) goto L_0x0010
            goto L_0x01af
        L_0x0010:
            if (r11 != 0) goto L_0x0014
            r0 = r1
            goto L_0x001b
        L_0x0014:
            r0 = 2131428379(0x7f0b041b, float:1.84784E38)
            android.widget.TextView r0 = r11.getTextView(r0)
        L_0x001b:
            if (r11 != 0) goto L_0x001f
            r5 = r1
            goto L_0x0026
        L_0x001f:
            r5 = 2131428377(0x7f0b0419, float:1.8478397E38)
            android.widget.TextView r5 = r11.getTextView(r5)
        L_0x0026:
            if (r11 != 0) goto L_0x002a
            r6 = r1
            goto L_0x0031
        L_0x002a:
            r6 = 2131428370(0x7f0b0412, float:1.8478383E38)
            android.widget.TextView r6 = r11.getTextView(r6)
        L_0x0031:
            if (r11 != 0) goto L_0x0035
            r7 = r1
            goto L_0x003c
        L_0x0035:
            r7 = 2131428375(0x7f0b0417, float:1.8478393E38)
            android.widget.TextView r7 = r11.getTextView(r7)
        L_0x003c:
            if (r11 != 0) goto L_0x0040
            r8 = r1
            goto L_0x0047
        L_0x0040:
            r8 = 2131428373(0x7f0b0415, float:1.8478389E38)
            android.widget.TextView r8 = r11.getTextView(r8)
        L_0x0047:
            if (r11 != 0) goto L_0x004a
            goto L_0x0051
        L_0x004a:
            r1 = 2131428376(0x7f0b0418, float:1.8478395E38)
            android.widget.TextView r1 = r11.getTextView(r1)
        L_0x0051:
            if (r11 != 0) goto L_0x0054
            goto L_0x005a
        L_0x0054:
            r9 = 2131428374(0x7f0b0416, float:1.847839E38)
            r11.getTextView(r9)
        L_0x005a:
            if (r0 != 0) goto L_0x005d
            goto L_0x0066
        L_0x005d:
            java.lang.String r11 = r12.getCouponName()
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            r0.setText(r11)
        L_0x0066:
            if (r5 != 0) goto L_0x0069
            goto L_0x0072
        L_0x0069:
            java.lang.String r11 = r12.getCouponExpireTime()
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            r5.setText(r11)
        L_0x0072:
            if (r6 != 0) goto L_0x0075
            goto L_0x007e
        L_0x0075:
            java.lang.String r11 = r12.getRemark()
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            r6.setText(r11)
        L_0x007e:
            boolean r11 = r12.isDiscount()
            r0 = 8
            r5 = 13
            r6 = 0
            if (r11 == 0) goto L_0x00f5
            if (r7 != 0) goto L_0x008c
            goto L_0x008f
        L_0x008c:
            r7.setVisibility(r0)
        L_0x008f:
            android.content.Context r11 = r10.getContext()
            java.lang.String r12 = r12.getDisCount()
            r3 = 2131952661(0x7f130415, float:1.9541771E38)
            java.lang.String r11 = com.didi.sdk.util.ResourcesHelper.getString(r11, r3, r12)
            android.content.Context r12 = r10.getContext()
            java.lang.String r12 = com.didi.sdk.util.ResourcesHelper.getString(r12, r3)
            int r12 = r12.length()
            int r12 = r12 - r4
            android.text.SpannableString r3 = new android.text.SpannableString
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            r3.<init>(r11)
            boolean r11 = com.didichuxing.drtl.tookit.DRtlToolkit.rtl()
            if (r11 == 0) goto L_0x00d3
            android.text.style.AbsoluteSizeSpan r11 = new android.text.style.AbsoluteSizeSpan
            r11.<init>(r5, r2)
            int r12 = r12 - r2
            r3.setSpan(r11, r6, r12, r6)
            android.text.style.AbsoluteSizeSpan r11 = new android.text.style.AbsoluteSizeSpan
            r11.<init>(r5, r2)
            int r12 = r3.length()
            int r12 = r12 - r2
            int r2 = r3.length()
            r3.setSpan(r11, r12, r2, r6)
            goto L_0x00e4
        L_0x00d3:
            android.text.style.AbsoluteSizeSpan r11 = new android.text.style.AbsoluteSizeSpan
            r11.<init>(r5, r2)
            int r2 = r3.length()
            int r2 = r2 - r12
            int r12 = r3.length()
            r3.setSpan(r11, r2, r12, r6)
        L_0x00e4:
            if (r8 != 0) goto L_0x00e7
            goto L_0x00ec
        L_0x00e7:
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r8.setText(r3)
        L_0x00ec:
            if (r1 != 0) goto L_0x00f0
            goto L_0x01af
        L_0x00f0:
            r1.setVisibility(r0)
            goto L_0x01af
        L_0x00f5:
            android.content.Context r11 = r10.getContext()
            java.lang.String r4 = r12.getCouponvalueFormat()
            r9 = 2131952660(0x7f130414, float:1.954177E38)
            java.lang.String r11 = com.didi.sdk.util.ResourcesHelper.getString(r11, r9, r4)
            android.content.Context r4 = r10.getContext()
            java.lang.String r4 = com.didi.sdk.util.ResourcesHelper.getString(r4, r9)
            int r4 = r4.length()
            int r4 = r4 - r3
            android.text.SpannableString r3 = new android.text.SpannableString
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            r3.<init>(r11)
            boolean r11 = com.didichuxing.drtl.tookit.DRtlToolkit.rtl()
            if (r11 == 0) goto L_0x0127
            android.text.style.AbsoluteSizeSpan r11 = new android.text.style.AbsoluteSizeSpan
            r11.<init>(r5, r2)
            r3.setSpan(r11, r6, r4, r6)
            goto L_0x0138
        L_0x0127:
            android.text.style.AbsoluteSizeSpan r11 = new android.text.style.AbsoluteSizeSpan
            r11.<init>(r5, r2)
            int r2 = r3.length()
            int r2 = r2 - r4
            int r4 = r3.length()
            r3.setSpan(r11, r2, r4, r6)
        L_0x0138:
            if (r8 != 0) goto L_0x013b
            goto L_0x0140
        L_0x013b:
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r8.setText(r3)
        L_0x0140:
            boolean r11 = r12.getCurrencyFirst()
            if (r11 != 0) goto L_0x015f
            if (r7 != 0) goto L_0x0149
            goto L_0x014c
        L_0x0149:
            r7.setVisibility(r6)
        L_0x014c:
            if (r1 != 0) goto L_0x014f
            goto L_0x0152
        L_0x014f:
            r1.setVisibility(r0)
        L_0x0152:
            if (r7 != 0) goto L_0x0155
            goto L_0x01af
        L_0x0155:
            java.lang.String r11 = r12.getCurrencySymbol()
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            r7.setText(r11)
            goto L_0x01af
        L_0x015f:
            if (r7 != 0) goto L_0x0162
            goto L_0x0165
        L_0x0162:
            r7.setVisibility(r0)
        L_0x0165:
            if (r1 != 0) goto L_0x0168
            goto L_0x016b
        L_0x0168:
            r1.setVisibility(r6)
        L_0x016b:
            if (r1 != 0) goto L_0x016e
            goto L_0x01af
        L_0x016e:
            java.lang.String r11 = r12.getCurrencySymbol()
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            r1.setText(r11)
            goto L_0x01af
        L_0x0178:
            if (r11 != 0) goto L_0x017b
            goto L_0x0182
        L_0x017b:
            r0 = 2131431132(0x7f0b0edc, float:1.8483985E38)
            android.widget.TextView r1 = r11.getTextView(r0)
        L_0x0182:
            if (r1 != 0) goto L_0x0185
            goto L_0x01af
        L_0x0185:
            java.lang.String r11 = r12.getText()
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            r1.setText(r11)
            goto L_0x01af
        L_0x018f:
            if (r11 != 0) goto L_0x0192
            goto L_0x0199
        L_0x0192:
            r0 = 2131431122(0x7f0b0ed2, float:1.8483964E38)
            android.widget.ImageView r1 = r11.getImageView(r0)
        L_0x0199:
            androidx.fragment.app.FragmentActivity r11 = r10.requireActivity()
            com.bumptech.glide.RequestManager r11 = com.bumptech.glide.Glide.with((androidx.fragment.app.FragmentActivity) r11)
            java.lang.String r12 = r12.getRedeemPageImage()
            com.bumptech.glide.RequestBuilder r11 = r11.load((java.lang.String) r12)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            r11.into((android.widget.ImageView) r1)
        L_0x01af:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.framework.pages.promo.fragment.PromoShareFragment.m9655a(com.didi.component.common.adapter.CommonRvVH, com.didi.component.framework.pages.promo.model.PromoShareItem):void");
    }

    /* JADX WARNING: type inference failed for: r5v7, types: [android.view.View] */
    /* JADX WARNING: type inference failed for: r5v14, types: [android.view.View] */
    /* JADX WARNING: type inference failed for: r5v21, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m9654a(int r4, com.didi.component.framework.pages.promo.model.PromoShareBtnModel r5) {
        /*
            r3 = this;
            com.didi.onekeyshare.entity.OneKeyShareInfo r0 = r5.getShareInfo()
            r1 = 0
            if (r4 == 0) goto L_0x00a2
            r2 = 1
            if (r4 == r2) goto L_0x0059
            r2 = 2
            if (r4 == r2) goto L_0x000f
            goto L_0x00ea
        L_0x000f:
            android.view.View r4 = r3.f13930a
            if (r4 != 0) goto L_0x0015
            r4 = r1
            goto L_0x001e
        L_0x0015:
            r2 = 2131431127(0x7f0b0ed7, float:1.8483974E38)
            android.view.View r4 = r4.findViewById(r2)
            android.widget.ImageButton r4 = (android.widget.ImageButton) r4
        L_0x001e:
            r2 = r3
            androidx.fragment.app.Fragment r2 = (androidx.fragment.app.Fragment) r2
            com.bumptech.glide.RequestManager r2 = com.bumptech.glide.Glide.with((androidx.fragment.app.Fragment) r2)
            java.lang.String r5 = r5.getShareIcon()
            com.bumptech.glide.RequestBuilder r5 = r2.load((java.lang.String) r5)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            r2 = r4
            android.widget.ImageView r2 = (android.widget.ImageView) r2
            r5.into((android.widget.ImageView) r2)
            android.view.View r5 = r3.f13930a
            if (r5 != 0) goto L_0x003b
            goto L_0x0045
        L_0x003b:
            r1 = 2131431128(0x7f0b0ed8, float:1.8483976E38)
            android.view.View r5 = r5.findViewById(r1)
            r1 = r5
            android.widget.TextView r1 = (android.widget.TextView) r1
        L_0x0045:
            if (r1 != 0) goto L_0x0048
            goto L_0x004f
        L_0x0048:
            java.lang.String r5 = r0.customName
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r1.setText(r5)
        L_0x004f:
            com.didi.component.framework.pages.promo.fragment.-$$Lambda$PromoShareFragment$5XXpyQbWMoFDNc-uMcxVIdFm_L4 r5 = new com.didi.component.framework.pages.promo.fragment.-$$Lambda$PromoShareFragment$5XXpyQbWMoFDNc-uMcxVIdFm_L4
            r5.<init>(r0)
            r4.setOnClickListener(r5)
            goto L_0x00ea
        L_0x0059:
            android.view.View r4 = r3.f13930a
            if (r4 != 0) goto L_0x005f
            r4 = r1
            goto L_0x0068
        L_0x005f:
            r2 = 2131431125(0x7f0b0ed5, float:1.848397E38)
            android.view.View r4 = r4.findViewById(r2)
            android.widget.ImageButton r4 = (android.widget.ImageButton) r4
        L_0x0068:
            r2 = r3
            androidx.fragment.app.Fragment r2 = (androidx.fragment.app.Fragment) r2
            com.bumptech.glide.RequestManager r2 = com.bumptech.glide.Glide.with((androidx.fragment.app.Fragment) r2)
            java.lang.String r5 = r5.getShareIcon()
            com.bumptech.glide.RequestBuilder r5 = r2.load((java.lang.String) r5)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            r2 = r4
            android.widget.ImageView r2 = (android.widget.ImageView) r2
            r5.into((android.widget.ImageView) r2)
            android.view.View r5 = r3.f13930a
            if (r5 != 0) goto L_0x0085
            goto L_0x008f
        L_0x0085:
            r1 = 2131431126(0x7f0b0ed6, float:1.8483972E38)
            android.view.View r5 = r5.findViewById(r1)
            r1 = r5
            android.widget.TextView r1 = (android.widget.TextView) r1
        L_0x008f:
            if (r1 != 0) goto L_0x0092
            goto L_0x0099
        L_0x0092:
            java.lang.String r5 = r0.customName
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r1.setText(r5)
        L_0x0099:
            com.didi.component.framework.pages.promo.fragment.-$$Lambda$PromoShareFragment$wgXsvR9Ua5ILAHYifuk0RAyyYx8 r5 = new com.didi.component.framework.pages.promo.fragment.-$$Lambda$PromoShareFragment$wgXsvR9Ua5ILAHYifuk0RAyyYx8
            r5.<init>(r0)
            r4.setOnClickListener(r5)
            goto L_0x00ea
        L_0x00a2:
            android.view.View r4 = r3.f13930a
            if (r4 != 0) goto L_0x00a8
            r4 = r1
            goto L_0x00b1
        L_0x00a8:
            r2 = 2131431123(0x7f0b0ed3, float:1.8483966E38)
            android.view.View r4 = r4.findViewById(r2)
            android.widget.ImageButton r4 = (android.widget.ImageButton) r4
        L_0x00b1:
            r2 = r3
            androidx.fragment.app.Fragment r2 = (androidx.fragment.app.Fragment) r2
            com.bumptech.glide.RequestManager r2 = com.bumptech.glide.Glide.with((androidx.fragment.app.Fragment) r2)
            java.lang.String r5 = r5.getShareIcon()
            com.bumptech.glide.RequestBuilder r5 = r2.load((java.lang.String) r5)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            r2 = r4
            android.widget.ImageView r2 = (android.widget.ImageView) r2
            r5.into((android.widget.ImageView) r2)
            android.view.View r5 = r3.f13930a
            if (r5 != 0) goto L_0x00ce
            goto L_0x00d8
        L_0x00ce:
            r1 = 2131431124(0x7f0b0ed4, float:1.8483968E38)
            android.view.View r5 = r5.findViewById(r1)
            r1 = r5
            android.widget.TextView r1 = (android.widget.TextView) r1
        L_0x00d8:
            if (r1 != 0) goto L_0x00db
            goto L_0x00e2
        L_0x00db:
            java.lang.String r5 = r0.customName
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r1.setText(r5)
        L_0x00e2:
            com.didi.component.framework.pages.promo.fragment.-$$Lambda$PromoShareFragment$-AqNJRIhsCe9xMbCWHmA2BE36dc r5 = new com.didi.component.framework.pages.promo.fragment.-$$Lambda$PromoShareFragment$-AqNJRIhsCe9xMbCWHmA2BE36dc
            r5.<init>(r0)
            r4.setOnClickListener(r5)
        L_0x00ea:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.framework.pages.promo.fragment.PromoShareFragment.m9654a(int, com.didi.component.framework.pages.promo.model.PromoShareBtnModel):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m9658a(PromoShareFragment promoShareFragment, OneKeyShareInfo oneKeyShareInfo, View view) {
        Intrinsics.checkNotNullParameter(promoShareFragment, "this$0");
        Intrinsics.checkNotNullParameter(oneKeyShareInfo, "$info");
        promoShareFragment.m9660a(oneKeyShareInfo);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m9664b(PromoShareFragment promoShareFragment, OneKeyShareInfo oneKeyShareInfo, View view) {
        Intrinsics.checkNotNullParameter(promoShareFragment, "this$0");
        Intrinsics.checkNotNullParameter(oneKeyShareInfo, "$info");
        promoShareFragment.m9660a(oneKeyShareInfo);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static final void m9665c(PromoShareFragment promoShareFragment, OneKeyShareInfo oneKeyShareInfo, View view) {
        Intrinsics.checkNotNullParameter(promoShareFragment, "this$0");
        Intrinsics.checkNotNullParameter(oneKeyShareInfo, "$info");
        promoShareFragment.m9660a(oneKeyShareInfo);
    }

    /* renamed from: a */
    static /* synthetic */ void m9659a(PromoShareFragment promoShareFragment, String str, String str2, Boolean bool, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            bool = null;
        }
        promoShareFragment.m9661a(str, str2, bool);
    }

    /* renamed from: a */
    private final void m9661a(String str, String str2, Boolean bool) {
        Map hashMap = new HashMap();
        hashMap.put("countryCode", this.f13935f);
        hashMap.put("locationA", Double.valueOf(LocationController.getInstance().getLng(requireActivity())));
        hashMap.put("locationB", Double.valueOf(LocationController.getInstance().getLat(requireActivity())));
        PromoSharePresenter promoSharePresenter = this.f13931b;
        hashMap.put("campaignID", promoSharePresenter == null ? null : promoSharePresenter.getCampaignId());
        hashMap.put("userId", Long.valueOf(NationComponentDataUtil.getUid()));
        if (str2 != null) {
            hashMap.put("sharechannel", str2);
        }
        if (bool != null) {
            hashMap.put("hasShareButton", Integer.valueOf(bool.booleanValue() ^ true ? 1 : 0));
        }
        GlobalOmegaUtils.trackEvent(str);
    }

    /* renamed from: b */
    private final void m9662b() {
        int i;
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        View view = this.f13930a;
        RecyclerView recyclerView = null;
        LinearLayout linearLayout = view == null ? null : (LinearLayout) view.findViewById(R.id.global_promo_bottom_share);
        View view2 = this.f13930a;
        if (view2 != null) {
            recyclerView = (RecyclerView) view2.findViewById(R.id.global_promo_share_rv);
        }
        if (recyclerView != null) {
            if (recyclerView.getChildCount() >= 1) {
                View childAt = recyclerView.getChildAt(recyclerView.getChildCount() - 1);
                if (linearLayout != null) {
                    linearLayout.getLocationOnScreen(iArr);
                }
                if (childAt != null) {
                    childAt.getLocationOnScreen(iArr2);
                }
                if (childAt == null) {
                    i = 0;
                } else {
                    i = childAt.getMeasuredHeight();
                }
                if (iArr[1] > iArr2[1] + i) {
                    if (linearLayout != null) {
                        linearLayout.setBackgroundColor(ResourcesHelper.getColor(requireActivity(), R.color.oc_color_F3F4F5));
                    }
                } else if (linearLayout != null) {
                    linearLayout.setBackgroundColor(ResourcesHelper.getColor(requireActivity(), R.color.white));
                }
            } else if (linearLayout != null) {
                linearLayout.setBackgroundColor(ResourcesHelper.getColor(requireActivity(), R.color.oc_color_F3F4F5));
            }
        }
    }
}
