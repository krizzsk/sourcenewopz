package com.didiglobal.p205sa.biz.component.bizcard;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.didi.drouter.api.DRouter;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.didiglobal.p205sa.biz.component.bizcard.model.BizCardItemModel;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ,\u0010\t\u001a\u00020\u00062\u001a\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\fH\u0002¨\u0006\u0011"}, mo175978d2 = {"Lcom/didiglobal/sa/biz/component/bizcard/BizCardItemViewGroup;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "bindData", "", "model", "Lcom/didiglobal/sa/biz/component/bizcard/BizCardTempModel;", "bindRealData", "modelList", "Ljava/util/ArrayList;", "Lcom/didiglobal/sa/biz/component/bizcard/model/BizCardItemModel;", "Lkotlin/collections/ArrayList;", "cardTitle", "Lcom/didi/global/globaluikit/richinfo/LEGORichInfo;", "track", "biz-library_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didiglobal.sa.biz.component.bizcard.BizCardItemViewGroup */
/* compiled from: BizCardItemViewGroup.kt */
public final class BizCardItemViewGroup extends FrameLayout {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BizCardItemViewGroup(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000c, code lost:
        r1 = (r1 = r3.getNormal()).getData();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void bindData(com.didiglobal.p205sa.biz.component.bizcard.BizCardTempModel r3) {
        /*
            r2 = this;
            r0 = 0
            if (r3 != 0) goto L_0x0005
        L_0x0003:
            r1 = r0
            goto L_0x0017
        L_0x0005:
            com.didiglobal.sa.biz.component.bizcard.BizCardTempModel$BizCardTemplateNormal r1 = r3.getNormal()
            if (r1 != 0) goto L_0x000c
            goto L_0x0003
        L_0x000c:
            com.didiglobal.sa.biz.component.bizcard.BizCardTempModel$BizCardTemplateData r1 = r1.getData()
            if (r1 != 0) goto L_0x0013
            goto L_0x0003
        L_0x0013:
            java.util.ArrayList r1 = r1.getCardInfos()
        L_0x0017:
            if (r3 != 0) goto L_0x001a
            goto L_0x002c
        L_0x001a:
            com.didiglobal.sa.biz.component.bizcard.BizCardTempModel$BizCardTemplateNormal r3 = r3.getNormal()
            if (r3 != 0) goto L_0x0021
            goto L_0x002c
        L_0x0021:
            com.didiglobal.sa.biz.component.bizcard.BizCardTempModel$BizCardTemplateData r3 = r3.getData()
            if (r3 != 0) goto L_0x0028
            goto L_0x002c
        L_0x0028:
            com.didi.global.globaluikit.richinfo.LEGORichInfo r0 = r3.getCardTitle()
        L_0x002c:
            if (r1 == 0) goto L_0x0035
            if (r0 != 0) goto L_0x0031
            goto L_0x0035
        L_0x0031:
            r2.m36469a(r1, r0)
            goto L_0x0038
        L_0x0035:
            r2.removeAllViews()
        L_0x0038:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.p205sa.biz.component.bizcard.BizCardItemViewGroup.bindData(com.didiglobal.sa.biz.component.bizcard.BizCardTempModel):void");
    }

    /* JADX WARNING: type inference failed for: r8v8, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m36469a(java.util.ArrayList<com.didiglobal.p205sa.biz.component.bizcard.model.BizCardItemModel> r7, com.didi.global.globaluikit.richinfo.LEGORichInfo r8) {
        /*
            r6 = this;
            r6.removeAllViews()
            r0 = 1
            r1 = 0
            if (r7 != 0) goto L_0x0009
        L_0x0007:
            r2 = 0
            goto L_0x0010
        L_0x0009:
            boolean r2 = r7.isEmpty()
            if (r2 != r0) goto L_0x0007
            r2 = 1
        L_0x0010:
            if (r2 != 0) goto L_0x0113
            if (r8 != 0) goto L_0x0016
            goto L_0x0113
        L_0x0016:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)
            java.lang.Object r7 = r7.get(r1)
            java.lang.String r2 = "modelList!![0]"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r2)
            com.didiglobal.sa.biz.component.bizcard.model.BizCardItemModel r7 = (com.didiglobal.p205sa.biz.component.bizcard.model.BizCardItemModel) r7
            android.content.Context r2 = r6.getContext()
            android.view.LayoutInflater r2 = android.view.LayoutInflater.from(r2)
            r3 = 2131624279(0x7f0e0157, float:1.8875733E38)
            r4 = 0
            android.view.View r2 = r2.inflate(r3, r4)
            if (r2 != 0) goto L_0x0038
            r3 = r4
            goto L_0x0041
        L_0x0038:
            r3 = 2131428079(0x7f0b02ef, float:1.8477792E38)
            android.view.View r3 = r2.findViewById(r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
        L_0x0041:
            r8.bindTextView(r3)
            com.didi.global.globaluikit.richinfo.LEGORichInfo r8 = r7.getTitle()
            if (r8 != 0) goto L_0x004b
            goto L_0x005b
        L_0x004b:
            if (r2 != 0) goto L_0x004f
            r3 = r4
            goto L_0x0058
        L_0x004f:
            r3 = 2131434585(0x7f0b1c59, float:1.8490988E38)
            android.view.View r3 = r2.findViewById(r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
        L_0x0058:
            r8.bindTextView(r3)
        L_0x005b:
            com.didi.global.globaluikit.richinfo.LEGORichInfo r8 = r7.getSubTitle()
            if (r8 != 0) goto L_0x0062
            goto L_0x0072
        L_0x0062:
            if (r2 != 0) goto L_0x0066
            r3 = r4
            goto L_0x006f
        L_0x0066:
            r3 = 2131434325(0x7f0b1b55, float:1.849046E38)
            android.view.View r3 = r2.findViewById(r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
        L_0x006f:
            r8.bindTextView(r3)
        L_0x0072:
            if (r2 != 0) goto L_0x0076
            r8 = r4
            goto L_0x007f
        L_0x0076:
            r8 = 2131433009(0x7f0b1631, float:1.8487792E38)
            android.view.View r8 = r2.findViewById(r8)
            android.widget.TextView r8 = (android.widget.TextView) r8
        L_0x007f:
            if (r8 != 0) goto L_0x0082
            goto L_0x008b
        L_0x0082:
            java.lang.String r3 = r7.getButtonTitle()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r8.setText(r3)
        L_0x008b:
            if (r2 != 0) goto L_0x008e
            goto L_0x00a2
        L_0x008e:
            r8 = 2131428082(0x7f0b02f2, float:1.8477798E38)
            android.view.View r8 = r2.findViewById(r8)
            android.view.ViewGroup r8 = (android.view.ViewGroup) r8
            if (r8 != 0) goto L_0x009a
            goto L_0x00a2
        L_0x009a:
            com.didiglobal.sa.biz.component.bizcard.-$$Lambda$BizCardItemViewGroup$ZWpNTxwVlBV59ht6XrnT5FTXyj0 r3 = new com.didiglobal.sa.biz.component.bizcard.-$$Lambda$BizCardItemViewGroup$ZWpNTxwVlBV59ht6XrnT5FTXyj0
            r3.<init>(r7)
            r8.setOnClickListener(r3)
        L_0x00a2:
            if (r2 != 0) goto L_0x00a6
            r8 = r4
            goto L_0x00af
        L_0x00a6:
            r8 = 2131431294(0x7f0b0f7e, float:1.8484313E38)
            android.view.View r8 = r2.findViewById(r8)
            android.widget.ImageView r8 = (android.widget.ImageView) r8
        L_0x00af:
            android.content.Context r3 = r6.getContext()
            android.content.Context r3 = r3.getApplicationContext()
            com.bumptech.glide.RequestManager r3 = com.bumptech.glide.Glide.with((android.content.Context) r3)
            java.lang.String r5 = r7.getIcon()
            com.bumptech.glide.RequestBuilder r3 = r3.load((java.lang.String) r5)
            r5 = 2131235322(0x7f0811fa, float:1.8086835E38)
            com.bumptech.glide.request.BaseRequestOptions r3 = r3.placeholder((int) r5)
            com.bumptech.glide.RequestBuilder r3 = (com.bumptech.glide.RequestBuilder) r3
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
            r3.into((android.widget.ImageView) r8)
            java.lang.String r8 = r7.getStartColor()     // Catch:{ Exception -> 0x00e3 }
            int r8 = android.graphics.Color.parseColor(r8)     // Catch:{ Exception -> 0x00e3 }
            java.lang.String r7 = r7.getEndColor()     // Catch:{ Exception -> 0x00e3 }
            int r7 = android.graphics.Color.parseColor(r7)     // Catch:{ Exception -> 0x00e3 }
            goto L_0x00ed
        L_0x00e3:
            java.lang.String r7 = "#FFFFFF"
            int r8 = android.graphics.Color.parseColor(r7)
            int r7 = android.graphics.Color.parseColor(r7)
        L_0x00ed:
            r3 = 2
            int[] r3 = new int[r3]
            r3[r1] = r8
            r3[r0] = r7
            android.graphics.drawable.GradientDrawable r7 = new android.graphics.drawable.GradientDrawable
            android.graphics.drawable.GradientDrawable$Orientation r8 = android.graphics.drawable.GradientDrawable.Orientation.LEFT_RIGHT
            r7.<init>(r8, r3)
            if (r2 != 0) goto L_0x00fe
            goto L_0x0108
        L_0x00fe:
            r8 = 2131428331(0x7f0b03eb, float:1.8478303E38)
            android.view.View r8 = r2.findViewById(r8)
            r4 = r8
            android.view.ViewGroup r4 = (android.view.ViewGroup) r4
        L_0x0108:
            if (r4 != 0) goto L_0x010b
            goto L_0x0110
        L_0x010b:
            android.graphics.drawable.Drawable r7 = (android.graphics.drawable.Drawable) r7
            r4.setBackground(r7)
        L_0x0110:
            r6.addView(r2)
        L_0x0113:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.p205sa.biz.component.bizcard.BizCardItemViewGroup.m36469a(java.util.ArrayList, com.didi.global.globaluikit.richinfo.LEGORichInfo):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m36467a(BizCardItemViewGroup bizCardItemViewGroup, BizCardItemModel bizCardItemModel, View view) {
        Intrinsics.checkNotNullParameter(bizCardItemViewGroup, "this$0");
        Intrinsics.checkNotNullParameter(bizCardItemModel, "$model");
        bizCardItemViewGroup.m36468a(bizCardItemModel);
        DRouter.build(bizCardItemModel.getLink()).start();
    }

    /* renamed from: a */
    private final void m36468a(BizCardItemModel bizCardItemModel) {
        Map hashMap = new HashMap();
        hashMap.put("type", "extra_big");
        hashMap.put("id", bizCardItemModel.getCardID());
        OmegaSDKAdapter.trackEvent("ibt_gp_sa_adpanel_ck", (Map<String, Object>) hashMap);
    }
}
