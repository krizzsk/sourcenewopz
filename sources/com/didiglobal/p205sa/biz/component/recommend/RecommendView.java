package com.didiglobal.p205sa.biz.component.recommend;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.component.never.core.IView;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.router.Request;
import com.didi.sdk.app.sapanel.ICardVisibleListener;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didiglobal.enginecore.component.XEComponent;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.didiglobal.p205sa.biz.component.recommend.model.RecommendModel;
import com.didiglobal.p205sa.biz.component.sapanel.interfaces.ICardPosition;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\u0012\u0010\u001e\u001a\u00020\u00162\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010!\u001a\u00020\u0016H\u0016J\u001c\u0010\"\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020$2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\n0&J\u0012\u0010'\u001a\u00020\u001d2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0016R\u001e\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0002X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000¨\u0006("}, mo175978d2 = {"Lcom/didiglobal/sa/biz/component/recommend/RecommendView;", "Lcom/didi/component/never/core/IView;", "Lcom/didiglobal/sa/biz/component/recommend/RecommendPresenter;", "Lcom/didiglobal/sa/biz/component/sapanel/interfaces/ICardPosition;", "Lcom/didi/sdk/app/sapanel/ICardVisibleListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "children", "Ljava/util/ArrayList;", "Lcom/didiglobal/enginecore/component/XEComponent;", "Lkotlin/collections/ArrayList;", "contentArea", "Landroid/widget/FrameLayout;", "logger", "Lcom/didi/sdk/logging/Logger;", "kotlin.jvm.PlatformType", "mContext", "presenter", "rightImgView", "Landroid/widget/ImageView;", "rootView", "Landroid/view/View;", "subtitleTv", "Landroid/widget/TextView;", "titleArea", "Landroidx/constraintlayout/widget/ConstraintLayout;", "titleTv", "cardWillDisplay", "", "getCardPosition", "type", "", "getView", "refreshDataModel", "model", "Lcom/didiglobal/sa/biz/component/recommend/model/RecommendModel;", "list", "", "setPresenter", "biz-library_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didiglobal.sa.biz.component.recommend.RecommendView */
/* compiled from: RecommendView.kt */
public final class RecommendView implements IView<RecommendPresenter>, ICardVisibleListener, ICardPosition {

    /* renamed from: a */
    private final Logger f51040a = LoggerFactory.getLogger(getClass().getName());

    /* renamed from: b */
    private final Context f51041b;

    /* renamed from: c */
    private View f51042c;

    /* renamed from: d */
    private TextView f51043d;

    /* renamed from: e */
    private TextView f51044e;

    /* renamed from: f */
    private ImageView f51045f;

    /* renamed from: g */
    private ConstraintLayout f51046g;

    /* renamed from: h */
    private FrameLayout f51047h;

    /* renamed from: i */
    private ArrayList<XEComponent> f51048i = new ArrayList<>();

    /* renamed from: j */
    private RecommendPresenter f51049j;

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m36574a(View view) {
    }

    public RecommendView(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f51041b = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.sa_component_recommend, (ViewGroup) null, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(R.…t_recommend, null, false)");
        this.f51042c = inflate;
        View findViewById = inflate.findViewById(R.id.title_area);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.title_area)");
        this.f51046g = (ConstraintLayout) findViewById;
        View findViewById2 = this.f51042c.findViewById(R.id.content_area);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.content_area)");
        this.f51047h = (FrameLayout) findViewById2;
        View findViewById3 = this.f51042c.findViewById(R.id.tv_title);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.tv_title)");
        this.f51043d = (TextView) findViewById3;
        View findViewById4 = this.f51042c.findViewById(R.id.tv_subtitle);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.id.tv_subtitle)");
        this.f51044e = (TextView) findViewById4;
        View findViewById5 = this.f51042c.findViewById(R.id.right_imageview);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.id.right_imageview)");
        this.f51045f = (ImageView) findViewById5;
    }

    public View getView() {
        return this.f51042c;
    }

    public void setPresenter(RecommendPresenter recommendPresenter) {
        this.f51049j = recommendPresenter;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x011b  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0152  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void refreshDataModel(com.didiglobal.p205sa.biz.component.recommend.model.RecommendModel r8, java.util.List<? extends com.didiglobal.enginecore.component.XEComponent> r9) {
        /*
            r7 = this;
            java.lang.String r0 = "model"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "list"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            com.didi.sdk.logging.Logger r0 = r7.f51040a
            java.lang.String r1 = "dispatch recommd_msg view "
            java.lang.String r1 = kotlin.jvm.internal.Intrinsics.stringPlus(r1, r8)
            r2 = 0
            java.lang.Object[] r3 = new java.lang.Object[r2]
            r0.debug((java.lang.String) r1, (java.lang.Object[]) r3)
            com.didi.global.globaluikit.richinfo.LEGORichInfo r0 = r8.getTitle()
            java.lang.String r1 = "type"
            r3 = 0
            java.lang.String r4 = ""
            r5 = 8
            if (r0 == 0) goto L_0x0052
            android.widget.TextView r0 = r7.f51043d
            r0.setVisibility(r2)
            com.didi.global.globaluikit.richinfo.LEGORichInfo r0 = r8.getTitle()
            if (r0 != 0) goto L_0x0031
            goto L_0x0036
        L_0x0031:
            android.widget.TextView r6 = r7.f51043d
            r0.bindTextView(r6)
        L_0x0036:
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.util.Map r0 = (java.util.Map) r0
            com.didi.global.globaluikit.richinfo.LEGORichInfo r6 = r8.getTitle()
            if (r6 != 0) goto L_0x0045
            r6 = r3
            goto L_0x0049
        L_0x0045:
            java.lang.String r6 = r6.getContent()
        L_0x0049:
            r0.put(r1, r6)
            java.lang.String r6 = "ibt_gp_sa_panel_recommend_title_sw"
            com.didiglobal.omegasdkadapter.OmegaSDKAdapter.trackEvent((java.lang.String) r6, (java.util.Map<java.lang.String, java.lang.Object>) r0)
            goto L_0x005f
        L_0x0052:
            android.widget.TextView r0 = r7.f51043d
            r0.setVisibility(r5)
            android.widget.TextView r0 = r7.f51043d
            r6 = r4
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r0.setText(r6)
        L_0x005f:
            com.didi.global.globaluikit.richinfo.LEGORichInfo r0 = r8.getSubtitle()
            if (r0 == 0) goto L_0x00a5
            com.didi.global.globaluikit.richinfo.LEGORichInfo r0 = r8.getSubtitle()
            if (r0 != 0) goto L_0x006d
            r0 = r3
            goto L_0x0071
        L_0x006d:
            java.lang.String r0 = r0.getContent()
        L_0x0071:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x00a5
            android.widget.TextView r0 = r7.f51044e
            r0.setVisibility(r2)
            com.didi.global.globaluikit.richinfo.LEGORichInfo r0 = r8.getSubtitle()
            if (r0 != 0) goto L_0x0085
            goto L_0x008a
        L_0x0085:
            android.widget.TextView r6 = r7.f51044e
            r0.bindTextView(r6)
        L_0x008a:
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.util.Map r0 = (java.util.Map) r0
            com.didi.global.globaluikit.richinfo.LEGORichInfo r6 = r8.getSubtitle()
            if (r6 != 0) goto L_0x0098
            goto L_0x009c
        L_0x0098:
            java.lang.String r3 = r6.getContent()
        L_0x009c:
            r0.put(r1, r3)
            java.lang.String r1 = "ibt_gp_sa_panel_recommend_subtitle_sw"
            com.didiglobal.omegasdkadapter.OmegaSDKAdapter.trackEvent((java.lang.String) r1, (java.util.Map<java.lang.String, java.lang.Object>) r0)
            goto L_0x00b2
        L_0x00a5:
            android.widget.TextView r0 = r7.f51044e
            r0.setVisibility(r5)
            android.widget.TextView r0 = r7.f51044e
            r1 = r4
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
        L_0x00b2:
            java.lang.String r0 = r8.getIcon()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x00da
            android.content.Context r8 = r7.f51041b
            com.bumptech.glide.RequestManager r8 = com.bumptech.glide.Glide.with((android.content.Context) r8)
            com.bumptech.glide.RequestBuilder r8 = r8.load((java.lang.String) r4)
            android.widget.ImageView r0 = r7.f51045f
            r8.into((android.widget.ImageView) r0)
            androidx.constraintlayout.widget.ConstraintLayout r8 = r7.f51046g
            com.didiglobal.sa.biz.component.recommend.-$$Lambda$RecommendView$EvAu_VVcQWdCDE2Rib--0vFPjwU r0 = com.didiglobal.p205sa.biz.component.recommend.$$Lambda$RecommendView$EvAu_VVcQWdCDE2Rib0vFPjwU.INSTANCE
            r8.setOnClickListener(r0)
            android.widget.ImageView r8 = r7.f51045f
            r8.setVisibility(r5)
            goto L_0x0101
        L_0x00da:
            android.widget.ImageView r0 = r7.f51045f
            r0.setVisibility(r2)
            java.lang.String r0 = "ibt_gp_sa_more_recommend_btn_sw"
            com.didiglobal.omegasdkadapter.OmegaSDKAdapter.trackEvent((java.lang.String) r0)
            android.content.Context r0 = r7.f51041b
            com.bumptech.glide.RequestManager r0 = com.bumptech.glide.Glide.with((android.content.Context) r0)
            java.lang.String r1 = r8.getIcon()
            com.bumptech.glide.RequestBuilder r0 = r0.load((java.lang.String) r1)
            android.widget.ImageView r1 = r7.f51045f
            r0.into((android.widget.ImageView) r1)
            androidx.constraintlayout.widget.ConstraintLayout r0 = r7.f51046g
            com.didiglobal.sa.biz.component.recommend.-$$Lambda$RecommendView$VdhUPtlJhiI1LIvfQQvUFvShmTM r1 = new com.didiglobal.sa.biz.component.recommend.-$$Lambda$RecommendView$VdhUPtlJhiI1LIvfQQvUFvShmTM
            r1.<init>(r8)
            r0.setOnClickListener(r1)
        L_0x0101:
            android.widget.FrameLayout r8 = r7.f51047h
            r8.removeAllViews()
            java.util.ArrayList<com.didiglobal.enginecore.component.XEComponent> r8 = r7.f51048i
            r8.clear()
            java.util.ArrayList<com.didiglobal.enginecore.component.XEComponent> r8 = r7.f51048i
            r0 = r9
            java.util.Collection r0 = (java.util.Collection) r0
            r8.addAll(r0)
            boolean r8 = r0.isEmpty()
            r8 = r8 ^ 1
            if (r8 == 0) goto L_0x0152
            android.widget.FrameLayout r8 = r7.f51047h
            r8.setVisibility(r2)
            java.util.Iterator r8 = r9.iterator()
        L_0x0124:
            boolean r9 = r8.hasNext()
            if (r9 == 0) goto L_0x0157
            java.lang.Object r9 = r8.next()
            com.didiglobal.enginecore.component.XEComponent r9 = (com.didiglobal.enginecore.component.XEComponent) r9
            android.view.View r9 = r9.getView()
            if (r9 != 0) goto L_0x0137
            goto L_0x0124
        L_0x0137:
            int r0 = r9.getPaddingLeft()
            android.content.Context r1 = r7.f51041b
            r3 = 1092616192(0x41200000, float:10.0)
            int r1 = com.didi.component.common.util.UIUtils.dip2pxInt(r1, r3)
            android.content.Context r4 = r7.f51041b
            int r3 = com.didi.component.common.util.UIUtils.dip2pxInt(r4, r3)
            r9.setPadding(r0, r1, r2, r3)
            android.widget.FrameLayout r0 = r7.f51047h
            r0.addView(r9)
            goto L_0x0124
        L_0x0152:
            android.widget.FrameLayout r8 = r7.f51047h
            r8.setVisibility(r5)
        L_0x0157:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.p205sa.biz.component.recommend.RecommendView.refreshDataModel(com.didiglobal.sa.biz.component.recommend.model.RecommendModel, java.util.List):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m36575a(RecommendView recommendView, RecommendModel recommendModel, View view) {
        Intrinsics.checkNotNullParameter(recommendView, "this$0");
        Intrinsics.checkNotNullParameter(recommendModel, "$model");
        OmegaSDKAdapter.trackEvent("ibt_gp_sa_more_recommend_btn_ck");
        Logger logger = recommendView.f51040a;
        logger.debug("dispatch recommd_msg click " + recommendModel + ".link", new Object[0]);
        if (!TextUtils.isEmpty(recommendModel.getLink())) {
            ((Request) DRouter.build(recommendModel.getLink()).putExtra("action_type", "support")).start();
        }
    }

    public View getCardPosition(String str) {
        return this.f51047h;
    }

    public void cardWillDisplay() {
        Iterator<XEComponent> it = this.f51048i.iterator();
        while (it.hasNext()) {
            XEComponent next = it.next();
            if (next.getView() != null && (next.getView() instanceof ICardVisibleListener)) {
                View view = next.getView();
                if (view != null) {
                    ((ICardVisibleListener) view).cardWillDisplay();
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type com.didi.sdk.app.sapanel.ICardVisibleListener");
                }
            }
        }
    }
}
