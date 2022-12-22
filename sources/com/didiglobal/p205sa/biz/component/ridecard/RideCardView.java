package com.didiglobal.p205sa.biz.component.ridecard;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.Glide;
import com.didi.common.map.model.Padding;
import com.didi.component.never.core.ComponentPresenter;
import com.didi.component.never.core.IComponent;
import com.didi.component.never.core.IView;
import com.didi.component.never.core.IViewContainer;
import com.didi.drouter.api.DRouter;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.nation.NationTypeUtil;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.didiglobal.p205sa.biz.component.ComponentType;
import com.didiglobal.p205sa.biz.component.interactivedialog.InteractiveDialogUtils;
import com.didiglobal.p205sa.biz.component.ridecard.model.RideCardModel;
import com.didiglobal.p205sa.biz.component.ridecard.widget.MapMaskView;
import com.didiglobal.p205sa.biz.component.sapanel.PanelAnimatorMgr;
import com.didiglobal.p205sa.biz.component.sapanel.interfaces.IRideView;
import com.didiglobal.p205sa.biz.component.sapanel.model.AnimationModel;
import com.didiglobal.p205sa.biz.util.UiUtils;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(mo175977d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020\u000fH\u0002J\u0010\u0010E\u001a\u00020C2\u0006\u0010F\u001a\u00020GH\u0002J\u0010\u0010H\u001a\u00020C2\u0006\u0010D\u001a\u00020\u000fH\u0002J\b\u0010I\u001a\u00020\u000fH\u0016J\b\u0010J\u001a\u00020KH\u0002J\u0014\u0010L\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00010>H\u0016J\u0006\u0010M\u001a\u00020NJ\b\u0010O\u001a\u00020:H\u0016J&\u0010P\u001a\b\u0012\u0002\b\u0003\u0018\u00010>2\u0006\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020VH\u0002J\b\u0010W\u001a\u00020\u000fH\u0002J\u0010\u0010X\u001a\u00020C2\u0006\u0010Y\u001a\u00020RH\u0002J\u0006\u0010Z\u001a\u00020CJ\u000e\u0010[\u001a\u00020C2\u0006\u0010\\\u001a\u00020\u000fJ\u0006\u0010]\u001a\u00020CJ\u0006\u0010^\u001a\u00020CJ\u0006\u0010_\u001a\u00020CJ\u0006\u0010`\u001a\u00020CJ\u0006\u0010a\u001a\u00020CJ\u0012\u0010b\u001a\u00020C2\b\u0010c\u001a\u0004\u0018\u00010\u001eH\u0016J\u0010\u0010d\u001a\u00020C2\b\u0010F\u001a\u0004\u0018\u00010\u000bJ\u0012\u0010e\u001a\u00020C2\b\u0010.\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010f\u001a\u00020C2\u0006\u0010Y\u001a\u00020RH\u0002J\b\u0010g\u001a\u00020CH\u0002R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001a\u001a\n \u001c*\u0004\u0018\u00010\u001b0\u001bX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u000e\u0010#\u001a\u00020$X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020,X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010\u0002X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010/\u001a\u000200X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u000e\u00105\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u001a\u00106\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0017\"\u0004\b8\u0010\u0019R\u000e\u00109\u001a\u00020:X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020*X\u0004¢\u0006\u0002\n\u0000R$\u0010<\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0001\u0012\b\u0012\u0006\u0012\u0002\b\u00030>\u0018\u00010=X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010?\u001a\b\u0012\u0002\b\u0003\u0018\u00010>X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020(X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000¨\u0006h"}, mo175978d2 = {"Lcom/didiglobal/sa/biz/component/ridecard/RideCardView;", "Lcom/didi/component/never/core/IView;", "Lcom/didiglobal/sa/biz/component/ridecard/RideCardPresenter;", "Lcom/didi/component/never/core/IViewContainer;", "Lcom/didiglobal/sa/biz/component/sapanel/interfaces/IRideView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "animationListener", "Lcom/didiglobal/sa/biz/component/sapanel/PanelAnimatorMgr$AnimationListener;", "data", "Lcom/didiglobal/sa/biz/component/ridecard/model/RideCardModel;", "destination_ll", "Landroid/widget/LinearLayout;", "isAnimation", "", "()Z", "setAnimation", "(Z)V", "isactive", "location", "", "getLocation", "()[I", "setLocation", "([I)V", "logger", "Lcom/didi/sdk/logging/Logger;", "kotlin.jvm.PlatformType", "mComponentCreator", "Lcom/didi/component/never/core/IViewContainer$IComponentCreator;", "getMComponentCreator", "()Lcom/didi/component/never/core/IViewContainer$IComponentCreator;", "setMComponentCreator", "(Lcom/didi/component/never/core/IViewContainer$IComponentCreator;)V", "map_maskView", "Lcom/didiglobal/sa/biz/component/ridecard/widget/MapMaskView;", "map_rl", "Landroid/widget/RelativeLayout;", "message_ll", "Landroid/widget/FrameLayout;", "msg_tv", "Landroid/widget/TextView;", "msgbg_iv", "Landroid/widget/ImageView;", "msgicon_iv", "presenter", "rect", "Landroid/graphics/Rect;", "getRect", "()Landroid/graphics/Rect;", "setRect", "(Landroid/graphics/Rect;)V", "ride_ll", "ride_location", "getRide_location", "setRide_location", "rootView", "Landroid/view/View;", "sa_destination_tv", "safeComponent", "Lcom/didi/component/never/core/IComponent;", "Lcom/didi/component/never/core/ComponentPresenter;", "saftPresenter", "safttool_fl", "where_to_ll_b", "addDestinationTrack", "", "isClick", "addMessageTrack", "model", "Lcom/didiglobal/sa/biz/component/ridecard/model/RideCardModel$MessageBar;", "addWhereToGoTrack", "containMap", "getCurrentPadding", "Lcom/didi/common/map/model/Padding;", "getHostPresenter", "getStartAddress", "Lcom/didi/sdk/address/address/entity/Address;", "getView", "inflateComponent", "type", "", "container", "Landroid/view/ViewGroup;", "bundle", "Landroid/os/Bundle;", "isLoginNow", "log", "msg", "onAdd", "onPageHiddenChanged", "hidden", "onPagePause", "onPageResume", "onPageStart", "onPageStop", "onRemove", "setComponentCreator", "componentCreator", "setDate", "setPresenter", "tips", "updataBaseView", "biz-library_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didiglobal.sa.biz.component.ridecard.RideCardView */
/* compiled from: RideCardView.kt */
public final class RideCardView implements IView<RideCardPresenter>, IViewContainer, IRideView {

    /* renamed from: a */
    private IComponent<IView<?>, ComponentPresenter<?>> f51054a;

    /* renamed from: b */
    private View f51055b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public RideCardPresenter f51056c;

    /* renamed from: d */
    private final Logger f51057d = LoggerFactory.getLogger("dongxt-RideCardView");

    /* renamed from: e */
    private final FrameLayout f51058e;

    /* renamed from: f */
    private ComponentPresenter<?> f51059f;

    /* renamed from: g */
    private final MapMaskView f51060g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final RelativeLayout f51061h;

    /* renamed from: i */
    private final FrameLayout f51062i;

    /* renamed from: j */
    private final LinearLayout f51063j;

    /* renamed from: k */
    private final LinearLayout f51064k;

    /* renamed from: l */
    private final LinearLayout f51065l;

    /* renamed from: m */
    private final TextView f51066m;

    /* renamed from: n */
    private final TextView f51067n;

    /* renamed from: o */
    private final ImageView f51068o;

    /* renamed from: p */
    private final ImageView f51069p;

    /* renamed from: q */
    private RideCardModel f51070q;

    /* renamed from: r */
    private boolean f51071r = true;

    /* renamed from: s */
    private int[] f51072s;

    /* renamed from: t */
    private int[] f51073t;

    /* renamed from: u */
    private Rect f51074u;

    /* renamed from: v */
    private boolean f51075v;

    /* renamed from: w */
    private final PanelAnimatorMgr.AnimationListener f51076w;

    /* renamed from: x */
    private IViewContainer.IComponentCreator f51077x;

    public RideCardView(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        View inflate = LayoutInflater.from(context).inflate(R.layout.component_sa_ride, (ViewGroup) null, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(R.…ent_sa_ride, null, false)");
        this.f51055b = inflate;
        View findViewById = inflate.findViewById(R.id.safttool_fl);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.safttool_fl)");
        this.f51058e = (FrameLayout) findViewById;
        View findViewById2 = this.f51055b.findViewById(R.id.map_mask);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.map_mask)");
        this.f51060g = (MapMaskView) findViewById2;
        View findViewById3 = this.f51055b.findViewById(R.id.map_rl);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.map_rl)");
        this.f51061h = (RelativeLayout) findViewById3;
        View findViewById4 = this.f51055b.findViewById(R.id.message_ll);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.id.message_ll)");
        this.f51062i = (FrameLayout) findViewById4;
        View findViewById5 = this.f51055b.findViewById(R.id.ride_ll);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.id.ride_ll)");
        this.f51063j = (LinearLayout) findViewById5;
        View findViewById6 = this.f51055b.findViewById(R.id.where_to_ll_b);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "rootView.findViewById(R.id.where_to_ll_b)");
        this.f51064k = (LinearLayout) findViewById6;
        View findViewById7 = this.f51055b.findViewById(R.id.destination_ll);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "rootView.findViewById(R.id.destination_ll)");
        this.f51065l = (LinearLayout) findViewById7;
        View findViewById8 = this.f51055b.findViewById(R.id.msg_tv);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "rootView.findViewById(R.id.msg_tv)");
        this.f51066m = (TextView) findViewById8;
        View findViewById9 = this.f51055b.findViewById(R.id.sa_destination_tv);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "rootView.findViewById(R.id.sa_destination_tv)");
        this.f51067n = (TextView) findViewById9;
        View findViewById10 = this.f51055b.findViewById(R.id.msgbg_iv);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "rootView.findViewById(R.id.msgbg_iv)");
        this.f51068o = (ImageView) findViewById10;
        View findViewById11 = this.f51055b.findViewById(R.id.msg_iv);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "rootView.findViewById(R.id.msg_iv)");
        this.f51069p = (ImageView) findViewById11;
        this.f51062i.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                RideCardView.m36581a(RideCardView.this, view);
            }
        });
        this.f51067n.setOnClickListener(new View.OnClickListener(context) {
            public final /* synthetic */ Context f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                RideCardView.m36580a(RideCardView.this, this.f$1, view);
            }
        });
        this.f51064k.setOnClickListener(new View.OnClickListener(context) {
            public final /* synthetic */ Context f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                RideCardView.m36587b(RideCardView.this, this.f$1, view);
            }
        });
        this.f51060g.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            public final void onScrollChanged() {
                RideCardView.m36579a(RideCardView.this);
            }
        });
        this.f51072s = new int[2];
        this.f51073t = new int[2];
        this.f51074u = new Rect();
        this.f51076w = new PanelAnimatorMgr.AnimationListener() {
            public final void onAnimationProcess(AnimationModel animationModel) {
                RideCardView.m36582a(RideCardView.this, animationModel);
            }
        };
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m36584a(String str) {
        this.f51057d.info(str, new Object[0]);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m36581a(RideCardView rideCardView, View view) {
        RideCardModel.MessageBar messageBar;
        RideCardModel.MessageBar messageBar2;
        Intrinsics.checkNotNullParameter(rideCardView, "this$0");
        RideCardModel rideCardModel = rideCardView.f51070q;
        if (rideCardModel != null) {
            String str = null;
            if ((rideCardModel == null ? null : rideCardModel.messagebar) != null) {
                RideCardModel rideCardModel2 = rideCardView.f51070q;
                if (((rideCardModel2 == null || (messageBar2 = rideCardModel2.messagebar) == null) ? null : messageBar2.link) != null) {
                    RideCardModel rideCardModel3 = rideCardView.f51070q;
                    if (!(rideCardModel3 == null || (messageBar = rideCardModel3.messagebar) == null)) {
                        str = messageBar.link;
                    }
                    DRouter.build(str).start();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0015, code lost:
        r0 = r0.intercept;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m36580a(com.didiglobal.p205sa.biz.component.ridecard.RideCardView r5, android.content.Context r6, android.view.View r7) {
        /*
            java.lang.String r7 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r7)
            java.lang.String r7 = "$context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r7)
            r7 = 1
            r5.m36589b((boolean) r7)
            com.didiglobal.sa.biz.component.ridecard.model.RideCardModel r0 = r5.f51070q
            r1 = 0
            if (r0 != 0) goto L_0x0015
        L_0x0013:
            r0 = 0
            goto L_0x001f
        L_0x0015:
            com.didiglobal.sa.biz.component.ridecard.model.RideCardModel$SugIntercept r0 = r0.intercept
            if (r0 != 0) goto L_0x001a
            goto L_0x0013
        L_0x001a:
            int r0 = r0.is_intercept
            if (r0 != r7) goto L_0x0013
            r0 = 1
        L_0x001f:
            r2 = 0
            if (r0 == 0) goto L_0x0042
            com.didiglobal.sa.biz.component.interactivedialog.InteractiveDialogUtils r7 = com.didiglobal.p205sa.biz.component.interactivedialog.InteractiveDialogUtils.INSTANCE
            androidx.fragment.app.FragmentActivity r6 = (androidx.fragment.app.FragmentActivity) r6
            org.json.JSONObject r0 = new org.json.JSONObject
            com.didiglobal.sa.biz.component.ridecard.model.RideCardModel r5 = r5.f51070q
            if (r5 != 0) goto L_0x002d
            goto L_0x0034
        L_0x002d:
            com.didiglobal.sa.biz.component.ridecard.model.RideCardModel$SugIntercept r5 = r5.intercept
            if (r5 != 0) goto L_0x0032
            goto L_0x0034
        L_0x0032:
            com.google.gson.JsonObject r2 = r5.intercept_data
        L_0x0034:
            java.lang.String r5 = java.lang.String.valueOf(r2)
            r0.<init>(r5)
            java.lang.String r5 = "passenger_newSheet"
            r7.show(r6, r0, r5)
            goto L_0x0112
        L_0x0042:
            boolean r6 = r5.m36590c()
            if (r6 != 0) goto L_0x0054
            com.didi.sdk.nation.NationComponentData r5 = com.didi.sdk.nation.NationTypeUtil.getNationComponentData()
            com.didi.sdk.nation.NationComponentData$LoginAction r5 = r5.getLoginAction()
            r5.go2Login()
            return
        L_0x0054:
            com.sdk.poibase.model.RpcPoi r6 = new com.sdk.poibase.model.RpcPoi
            r6.<init>()
            com.didiglobal.sa.biz.component.ridecard.model.RideCardModel r0 = r5.f51070q
            if (r0 != 0) goto L_0x005f
        L_0x005d:
            r0 = r2
            goto L_0x0074
        L_0x005f:
            com.didiglobal.sa.biz.component.ridecard.model.RideCardModel$RecommendDest r0 = r0.recommendDest
            if (r0 != 0) goto L_0x0064
            goto L_0x005d
        L_0x0064:
            java.util.List<com.didiglobal.sa.biz.component.ridecard.model.RideCardModel$Destination> r0 = r0.destinationList
            if (r0 != 0) goto L_0x0069
            goto L_0x005d
        L_0x0069:
            java.lang.Object r0 = r0.get(r1)
            com.didiglobal.sa.biz.component.ridecard.model.RideCardModel$Destination r0 = (com.didiglobal.p205sa.biz.component.ridecard.model.RideCardModel.Destination) r0
            if (r0 != 0) goto L_0x0072
            goto L_0x005d
        L_0x0072:
            com.sdk.poibase.model.RpcPoiBaseInfo r0 = r0.base_info
        L_0x0074:
            r6.base_info = r0
            com.didi.sdk.address.address.entity.Address r0 = new com.didi.sdk.address.address.entity.Address
            r0.<init>()
            com.didiglobal.sa.biz.component.ridecard.RideCardPresenter r0 = r5.f51056c
            if (r0 != 0) goto L_0x0081
            r0 = r2
            goto L_0x0089
        L_0x0081:
            java.lang.String r3 = "component_sa_xpanel"
            java.lang.String r4 = "sender_start_address_data"
            com.didi.component.never.core.sender.DataSender r0 = r0.getDataSender(r3, r4)
        L_0x0089:
            if (r0 != 0) goto L_0x008c
            goto L_0x0095
        L_0x008c:
            com.didi.component.never.core.sender.NullData r2 = new com.didi.component.never.core.sender.NullData
            r2.<init>()
            java.lang.Object r2 = r0.getData(r2)
        L_0x0095:
            if (r2 == 0) goto L_0x00bc
            com.didi.component.never.core.sender.NullData r2 = new com.didi.component.never.core.sender.NullData
            r2.<init>()
            java.lang.Object r0 = r0.getData(r2)
            if (r0 == 0) goto L_0x00b4
            com.didi.sdk.address.address.entity.Address r0 = (com.didi.sdk.address.address.entity.Address) r0
            com.didi.sdk.logging.Logger r5 = r5.f51057d
            java.lang.String r2 = r0.displayName
            java.lang.String r3 = "sender"
            java.lang.String r2 = kotlin.jvm.internal.Intrinsics.stringPlus(r2, r3)
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r5.info((java.lang.String) r2, (java.lang.Object[]) r1)
            goto L_0x00cf
        L_0x00b4:
            java.lang.NullPointerException r5 = new java.lang.NullPointerException
            java.lang.String r6 = "null cannot be cast to non-null type com.didi.sdk.address.address.entity.Address"
            r5.<init>(r6)
            throw r5
        L_0x00bc:
            com.didi.sdk.address.address.entity.Address r0 = r5.getStartAddress()
            com.didi.sdk.logging.Logger r5 = r5.f51057d
            java.lang.String r2 = r0.displayName
            java.lang.String r3 = "111"
            java.lang.String r2 = kotlin.jvm.internal.Intrinsics.stringPlus(r2, r3)
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r5.info((java.lang.String) r2, (java.lang.Object[]) r1)
        L_0x00cf:
            com.didi.sdk.address.address.entity.Address r5 = com.sdk.poibase.ModelConverter.convertToAddress(r6)
            com.didiglobal.sa.biz.estimate.EstimateParams r6 = new com.didiglobal.sa.biz.estimate.EstimateParams
            r6.<init>()
            r6.setEndAddress(r5)
            r6.setStartAddress(r0)
            r6.setGuessDestination(r7)
            android.os.Bundle r5 = new android.os.Bundle
            r5.<init>()
            java.lang.String r0 = "back_visibility"
            r5.putBoolean(r0, r7)
            java.io.Serializable r6 = (java.io.Serializable) r6
            java.lang.String r7 = "estimateParams"
            r5.putSerializable(r7, r6)
            java.lang.String r6 = "page_source"
            java.lang.String r7 = "page_home_destination"
            r5.putString(r6, r7)
            com.didi.sdk.app.business.SaBusinessManager$Companion r6 = com.didi.sdk.app.business.SaBusinessManager.Companion
            com.didi.sdk.app.business.SaBusinessManager r6 = r6.getIns()
            com.didi.sdk.nation.NationComponentData r7 = com.didi.sdk.nation.NationTypeUtil.getNationComponentData()
            java.lang.String r7 = r7.getProductPreFix()
            java.lang.String r0 = "OneTravel://ride/sa_eyeball_estimate"
            java.lang.String r7 = kotlin.jvm.internal.Intrinsics.stringPlus(r7, r0)
            java.lang.String r0 = "ride"
            r6.switchBusiness(r0, r7, r5)
        L_0x0112:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.p205sa.biz.component.ridecard.RideCardView.m36580a(com.didiglobal.sa.biz.component.ridecard.RideCardView, android.content.Context, android.view.View):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m36587b(RideCardView rideCardView, Context context, View view) {
        RideCardModel.SugIntercept sugIntercept;
        RideCardModel.SugIntercept sugIntercept2;
        Intrinsics.checkNotNullParameter(rideCardView, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        boolean z = true;
        rideCardView.m36585a(true);
        RideCardModel rideCardModel = rideCardView.f51070q;
        if (rideCardModel == null || (sugIntercept2 = rideCardModel.intercept) == null || sugIntercept2.is_intercept != 1) {
            z = false;
        }
        if (z) {
            InteractiveDialogUtils interactiveDialogUtils = InteractiveDialogUtils.INSTANCE;
            FragmentActivity fragmentActivity = (FragmentActivity) context;
            RideCardModel rideCardModel2 = rideCardView.f51070q;
            JsonObject jsonObject = null;
            if (!(rideCardModel2 == null || (sugIntercept = rideCardModel2.intercept) == null)) {
                jsonObject = sugIntercept.intercept_data;
            }
            interactiveDialogUtils.show(fragmentActivity, new JSONObject(String.valueOf(jsonObject)), "passenger_newSheet");
        } else if (!rideCardView.m36590c()) {
            NationTypeUtil.getNationComponentData().getLoginAction().go2Login();
        } else {
            RideCardPresenter rideCardPresenter = rideCardView.f51056c;
            if (rideCardPresenter != null) {
                rideCardPresenter.doPublish("event_show_new_sug_page", 2);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m36579a(RideCardView rideCardView) {
        Intrinsics.checkNotNullParameter(rideCardView, "this$0");
        rideCardView.m36584a(Intrinsics.stringPlus("mapmask scroollchanged isactive=", Boolean.valueOf(rideCardView.f51071r)));
        if (rideCardView.f51071r) {
            Padding a = rideCardView.m36577a();
            if (a.left > 0) {
                PanelAnimatorMgr.onScrollChanged(a);
            }
        }
    }

    /* renamed from: a */
    private final void m36585a(boolean z) {
        HashMap hashMap = new HashMap();
        if (z) {
            OmegaSDKAdapter.trackEvent("pas_destinationbox_ck", (Map<String, Object>) hashMap);
        } else {
            OmegaSDKAdapter.trackEvent("ibt_gp_destinationbox_sw", (Map<String, Object>) hashMap);
        }
    }

    /* renamed from: b */
    private final void m36589b(boolean z) {
        HashMap hashMap = new HashMap();
        if (z) {
            OmegaSDKAdapter.trackEvent("requireDlg_guessDestination_ck", (Map<String, Object>) hashMap);
        } else {
            OmegaSDKAdapter.trackEvent("ibt_gp_guessDestination_sw", (Map<String, Object>) hashMap);
        }
    }

    /* renamed from: a */
    private final void m36583a(RideCardModel.MessageBar messageBar) {
        HashMap hashMap = new HashMap();
        try {
            HashMap hashMap2 = (HashMap) new Gson().fromJson((JsonElement) messageBar.log_data, new RideCardView$addMessageTrack$messageParams$1().getType());
            if (hashMap2 != null) {
                hashMap.putAll(hashMap2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        OmegaSDKAdapter.trackEvent("ibt_gp_discount_helper_sw", (Map<String, Object>) hashMap);
    }

    /* renamed from: a */
    private final ComponentPresenter<?> m36578a(String str, ViewGroup viewGroup, Bundle bundle) {
        IView<?> iView;
        ViewGroup.LayoutParams layoutParams;
        IView<?> view;
        IView<?> view2;
        View view3;
        IView<?> view4;
        View view5;
        IView<?> view6;
        IComponent<IView<?>, ComponentPresenter<?>> iComponent = this.f51054a;
        if (iComponent == null) {
            IViewContainer.IComponentCreator iComponentCreator = this.f51077x;
            IComponent<IView<?>, ComponentPresenter<?>> newComponent = iComponentCreator == null ? null : iComponentCreator.newComponent(this.f51056c, str, viewGroup, bundle);
            this.f51054a = newComponent;
            if (newComponent == null) {
                return null;
            }
            if (newComponent == null) {
                iView = null;
            } else {
                iView = newComponent.getView();
            }
            if (iView == null) {
                return null;
            }
            IComponent<IView<?>, ComponentPresenter<?>> iComponent2 = this.f51054a;
            if (((iComponent2 == null || (view6 = iComponent2.getView()) == null) ? null : view6.getView()) == null) {
                return null;
            }
            IComponent<IView<?>, ComponentPresenter<?>> iComponent3 = this.f51054a;
            if (((iComponent3 == null || (view4 = iComponent3.getView()) == null || (view5 = view4.getView()) == null) ? null : view5.getLayoutParams()) != null) {
                IComponent<IView<?>, ComponentPresenter<?>> iComponent4 = this.f51054a;
                layoutParams = (iComponent4 == null || (view2 = iComponent4.getView()) == null || (view3 = view2.getView()) == null) ? null : view3.getLayoutParams();
                if (layoutParams == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
                }
            } else {
                layoutParams = null;
            }
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(-2, -2);
            }
            viewGroup.removeAllViews();
            IComponent<IView<?>, ComponentPresenter<?>> iComponent5 = this.f51054a;
            viewGroup.addView((iComponent5 == null || (view = iComponent5.getView()) == null) ? null : view.getView(), layoutParams);
            IComponent<IView<?>, ComponentPresenter<?>> iComponent6 = this.f51054a;
            if (iComponent6 == null) {
                return null;
            }
            return iComponent6.getPresenter();
        } else if (iComponent == null) {
            return null;
        } else {
            return iComponent.getPresenter();
        }
    }

    public final int[] getLocation() {
        return this.f51072s;
    }

    public final void setLocation(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<set-?>");
        this.f51072s = iArr;
    }

    public final int[] getRide_location() {
        return this.f51073t;
    }

    public final void setRide_location(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<set-?>");
        this.f51073t = iArr;
    }

    public final Rect getRect() {
        return this.f51074u;
    }

    public final void setRect(Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "<set-?>");
        this.f51074u = rect;
    }

    public final void onAdd() {
        PanelAnimatorMgr.addAnimationListener(this.f51076w);
        m36586b();
    }

    public final boolean isAnimation() {
        return this.f51075v;
    }

    public final void setAnimation(boolean z) {
        this.f51075v = z;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m36582a(RideCardView rideCardView, AnimationModel animationModel) {
        Intrinsics.checkNotNullParameter(rideCardView, "this$0");
        rideCardView.m36584a(" animationListener ---mode.fraction = " + animationModel.getFraction() + ",   mode.isExpand= " + animationModel.isExpand());
        boolean z = true;
        rideCardView.f51071r = animationModel.getFraction() == 1.0f;
        if (animationModel.getFraction() != 1.0f) {
            z = false;
        }
        if (z) {
            rideCardView.setAnimation(animationModel.isExpand());
            if (!rideCardView.isAnimation()) {
                rideCardView.m36586b();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final Padding m36577a() {
        this.f51061h.getGlobalVisibleRect(this.f51074u);
        this.f51061h.getLocationInWindow(this.f51072s);
        this.f51063j.getLocationInWindow(this.f51073t);
        UiUtils uiUtils = UiUtils.INSTANCE;
        Context context = this.f51061h.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "map_rl.context");
        int navigationBarHeight = uiUtils.getNavigationBarHeight(context);
        UiUtils uiUtils2 = UiUtils.INSTANCE;
        Context context2 = this.f51061h.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "map_rl.context");
        int screenHeight = uiUtils2.getScreenHeight(context2) - this.f51073t[1];
        Padding padding = new Padding(this.f51074u.left, this.f51072s[1], this.f51074u.left, screenHeight - navigationBarHeight);
        StringBuilder sb = new StringBuilder();
        sb.append("layout====== padding  left=");
        sb.append(this.f51074u.left);
        sb.append(" , top=");
        sb.append(this.f51072s[1]);
        sb.append(", right=");
        sb.append(this.f51074u.right);
        sb.append(",bottom=");
        sb.append(this.f51073t[1]);
        sb.append(" , padding=");
        sb.append(padding);
        sb.append("， sh=");
        UiUtils uiUtils3 = UiUtils.INSTANCE;
        Context context3 = this.f51061h.getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "map_rl.context");
        sb.append(uiUtils3.getScreenHeight(context3));
        sb.append(", bottom=");
        sb.append(screenHeight);
        sb.append(", nah =");
        sb.append(navigationBarHeight);
        m36584a(sb.toString());
        m36584a("layout====== top " + this.f51061h.getTop() + "  x =" + this.f51061h.getX() + " , y= " + this.f51061h.getY() + ",h=  " + this.f51061h.getHeight() + ", w =" + this.f51061h.getWidth() + " , py=" + this.f51061h.getPivotY() + ", bottom= " + this.f51061h.getBottom());
        return padding;
    }

    /* renamed from: b */
    private final void m36586b() {
        this.f51061h.getViewTreeObserver().addOnGlobalLayoutListener(new RideCardView$updataBaseView$1(this));
    }

    public final void onRemove() {
        ComponentPresenter<?> componentPresenter = this.f51059f;
        if (componentPresenter != null) {
            componentPresenter.onRemove();
        }
        PanelAnimatorMgr.removeListener(this.f51076w);
    }

    public final void onPagePause() {
        this.f51071r = false;
        ComponentPresenter<?> componentPresenter = this.f51059f;
        if (componentPresenter != null) {
            componentPresenter.onPagePause();
        }
    }

    public final void onPageResume() {
        ComponentPresenter<?> componentPresenter = this.f51059f;
        if (componentPresenter != null) {
            componentPresenter.onPageResume();
        }
        this.f51071r = true;
        m36584a(Intrinsics.stringPlus("onPageResume isAnimation=", Boolean.valueOf(this.f51075v)));
        if (!this.f51075v) {
            m36586b();
        }
    }

    public final void onPageStop() {
        ComponentPresenter<?> componentPresenter = this.f51059f;
        if (componentPresenter != null) {
            componentPresenter.onPageStop();
        }
    }

    public final void onPageStart() {
        ComponentPresenter<?> componentPresenter = this.f51059f;
        if (componentPresenter != null) {
            componentPresenter.onPageStart();
        }
    }

    public final void onPageHiddenChanged(boolean z) {
        ComponentPresenter<?> componentPresenter = this.f51059f;
        if (componentPresenter != null) {
            componentPresenter.onPageHiddenChanged(z);
        }
        boolean z2 = !z;
        this.f51071r = z2;
        m36584a(Intrinsics.stringPlus(" onPageHiddenChanged isactive= ", Boolean.valueOf(z2)));
        if (!z && !this.f51075v) {
            m36584a(" onPageHiddenChanged");
            m36586b();
        }
    }

    /* renamed from: b */
    private final void m36588b(String str) {
        SystemUtils.showToast(Toast.makeText(this.f51055b.getContext(), str, 0));
    }

    public View getView() {
        return this.f51055b;
    }

    public void setPresenter(RideCardPresenter rideCardPresenter) {
        this.f51056c = rideCardPresenter;
    }

    public final void setDate(RideCardModel rideCardModel) {
        if (rideCardModel != null) {
            this.f51070q = rideCardModel;
            if (rideCardModel.config != null) {
                if (rideCardModel.config.enableSafeTool == 1) {
                    this.f51058e.setVisibility(0);
                    this.f51059f = m36578a(ComponentType.COMPONENT_SA_SAFE_JARVIS, (ViewGroup) this.f51058e, new Bundle());
                } else {
                    this.f51058e.setVisibility(4);
                    this.f51054a = null;
                    this.f51059f = null;
                }
                if (rideCardModel.config.enableShowMap == 1) {
                    this.f51061h.setVisibility(0);
                } else {
                    this.f51061h.setVisibility(8);
                }
            }
            if (rideCardModel.messagebar == null || rideCardModel.messagebar.message == null) {
                this.f51062i.setVisibility(8);
            } else {
                this.f51062i.setVisibility(0);
                rideCardModel.messagebar.message.bindTextView(this.f51066m);
                if (!TextUtils.isEmpty(rideCardModel.messagebar.icon)) {
                    Glide.with(this.f51055b.getContext()).load(rideCardModel.messagebar.icon).into(this.f51069p);
                }
                UiUtils uiUtils = UiUtils.INSTANCE;
                Context context = this.f51055b.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
                String str = rideCardModel.messagebar.color_bg_start;
                Intrinsics.checkNotNullExpressionValue(str, "model.messagebar.color_bg_start");
                String str2 = rideCardModel.messagebar.color_bg_end;
                Intrinsics.checkNotNullExpressionValue(str2, "model.messagebar.color_bg_end");
                GradientDrawable backgroundDrawable = uiUtils.getBackgroundDrawable(context, str, str2);
                if (backgroundDrawable != null) {
                    this.f51068o.setBackground(backgroundDrawable);
                }
                RideCardModel.MessageBar messageBar = rideCardModel.messagebar;
                Intrinsics.checkNotNullExpressionValue(messageBar, "model.messagebar");
                m36583a(messageBar);
            }
            if (rideCardModel.recommendDest == null || rideCardModel.recommendDest.destinationList == null || rideCardModel.recommendDest.destinationList.size() <= 0 || rideCardModel.recommendDest.destinationList.get(0).base_info == null) {
                this.f51065l.setVisibility(8);
            } else {
                this.f51065l.setVisibility(0);
                this.f51067n.setText(rideCardModel.recommendDest.destinationList.get(0).base_info.displayname);
                m36589b(false);
            }
            m36585a(false);
            m36586b();
        }
    }

    public final IViewContainer.IComponentCreator getMComponentCreator() {
        return this.f51077x;
    }

    public final void setMComponentCreator(IViewContainer.IComponentCreator iComponentCreator) {
        this.f51077x = iComponentCreator;
    }

    public void setComponentCreator(IViewContainer.IComponentCreator iComponentCreator) {
        this.f51077x = iComponentCreator;
    }

    public ComponentPresenter<? extends IView<?>> getHostPresenter() {
        RideCardPresenter rideCardPresenter = this.f51056c;
        Intrinsics.checkNotNull(rideCardPresenter);
        return rideCardPresenter;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0008, code lost:
        r0 = r0.config;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean containMap() {
        /*
            r3 = this;
            com.didiglobal.sa.biz.component.ridecard.model.RideCardModel r0 = r3.f51070q
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x0008
        L_0x0006:
            r1 = 0
            goto L_0x0011
        L_0x0008:
            com.didiglobal.sa.biz.component.ridecard.model.RideCardModel$Config r0 = r0.config
            if (r0 != 0) goto L_0x000d
            goto L_0x0006
        L_0x000d:
            int r0 = r0.enableShowMap
            if (r0 != r1) goto L_0x0006
        L_0x0011:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.p205sa.biz.component.ridecard.RideCardView.containMap():boolean");
    }

    public final Address getStartAddress() {
        DIDILocation didiLocation = NationTypeUtil.getNationComponentData().getDidiLocation();
        if (didiLocation == null) {
            return new Address();
        }
        Address address = new Address();
        address.setLatitude(didiLocation.getLatitude());
        address.setLongitude(didiLocation.getLongitude());
        try {
            address.setCityId(Integer.parseInt(NationTypeUtil.getNationComponentData().getCityId()));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        address.setCityName(NationTypeUtil.getNationComponentData().getCityName());
        return address;
    }

    /* renamed from: c */
    private final boolean m36590c() {
        return NationTypeUtil.getNationComponentData().getLoginInfo().isLoginNow();
    }
}
