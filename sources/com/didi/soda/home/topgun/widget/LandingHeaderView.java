package com.didi.soda.home.topgun.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.soda.customer.blocks.BlocksConst;
import com.didi.soda.customer.blocks.view.AutoSizeTextView;
import com.didi.soda.customer.foundation.imageloader.FitWidthTransformation;
import com.didi.soda.customer.foundation.rpc.entity.TabInfoEntity;
import com.didi.soda.customer.foundation.util.CustomerExtentionKt;
import com.didi.soda.customer.foundation.util.FlyImageLoader;
import com.didi.soda.customer.widget.text.RichTextView;
import com.didi.soda.home.topgun.binder.model.LandingHeaderRvModel;
import com.didi.soda.home.widget.TabsView;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ*\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\f0\u0012J\u0010\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0010H\u0002J,\u0010\u0016\u001a\u00020\f2\"\u0010\u0017\u001a\u001e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\u0018j\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a`\u001bH\u0002R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/widget/LandingHeaderView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bgAspect", "", "bindData", "", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "headerRvModel", "Lcom/didi/soda/home/topgun/binder/model/LandingHeaderRvModel;", "clickCallBack", "Lkotlin/Function1;", "Lcom/didi/soda/customer/foundation/rpc/entity/TabInfoEntity;", "setBgImage", "model", "setLogImg", "props", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: LandingHeaderView.kt */
public final class LandingHeaderView extends ConstraintLayout {

    /* renamed from: a */
    private float f43187a;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public LandingHeaderView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public LandingHeaderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void _$_clearFindViewByIdCache() {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LandingHeaderView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LandingHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.customer_item_landing_header, this);
        setLayoutParams(new ViewGroup.MarginLayoutParams(-1, -2));
        this.f43187a = ((float) DisplayUtils.getScreenWidth(context)) / 750.0f;
    }

    private final void setBgImage(LandingHeaderRvModel landingHeaderRvModel) {
        CharSequence img = landingHeaderRvModel.getImg();
        if (img == null || img.length() == 0) {
            ((ImageView) findViewById(R.id.customer_landing_header_image)).setBackgroundColor(CustomerExtentionKt.getColor(R.color.rf_color_white_100_FFFFFF));
        } else {
            ((ImageView) findViewById(R.id.customer_landing_header_image)).setBackgroundColor(CustomerExtentionKt.getColor(R.color.rf_color_white_100_alpha_0));
            FlyImageLoader.ImageRequestWrapper dontAnimate = FlyImageLoader.loadImage1x1(getContext(), landingHeaderRvModel.getImg()).dontAnimate();
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            dontAnimate.transform(new FitWidthTransformation(context)).into((ImageView) findViewById(R.id.customer_landing_header_image));
        }
        String ambientImg = landingHeaderRvModel.getAmbientImg();
        if (!TextUtils.isEmpty(ambientImg)) {
            ((ImageView) findViewById(R.id.customer_landing_header_fro_img)).setVisibility(0);
            FlyImageLoader.loadImageUnspecified(getContext(), ambientImg).dontAnimate().into((ImageView) findViewById(R.id.customer_landing_header_fro_img));
            return;
        }
        ((ImageView) findViewById(R.id.customer_landing_header_fro_img)).setVisibility(8);
    }

    private final void setLogImg(HashMap<String, Object> hashMap) {
        Object obj = hashMap.get(BlocksConst.WIDGET_PARAMS_ICON_IMAGE);
        String obj2 = obj == null ? null : obj.toString();
        CharSequence charSequence = obj2;
        if (charSequence == null || charSequence.length() == 0) {
            ((ImageView) findViewById(R.id.custom_landing_header_logo_img)).setVisibility(8);
            return;
        }
        ((ImageView) findViewById(R.id.custom_landing_header_logo_img)).setVisibility(0);
        FlyImageLoader.loadImage1x1(getContext(), obj2).dontAnimate().into((ImageView) findViewById(R.id.custom_landing_header_logo_img));
    }

    public final void bindData(ScopeContext scopeContext, LandingHeaderRvModel landingHeaderRvModel, Function1<? super TabInfoEntity, Unit> function1) {
        Intrinsics.checkNotNullParameter(scopeContext, "scopeContext");
        Intrinsics.checkNotNullParameter(landingHeaderRvModel, "headerRvModel");
        Intrinsics.checkNotNullParameter(function1, "clickCallBack");
        setBgImage(landingHeaderRvModel);
        ((ConstraintLayout) findViewById(R.id.customer_landing_header_content_layout)).setVisibility(0);
        CharSequence title = landingHeaderRvModel.getTitle();
        boolean z = true;
        if (title == null || title.length() == 0) {
            ((AutoSizeTextView) findViewById(R.id.customer_landing_header_title)).setVisibility(8);
        } else {
            ((AutoSizeTextView) findViewById(R.id.customer_landing_header_title)).setVisibility(0);
            ((AutoSizeTextView) findViewById(R.id.customer_landing_header_title)).setText(landingHeaderRvModel.getTitle());
        }
        CharSequence subTitle = landingHeaderRvModel.getSubTitle();
        if (subTitle == null || subTitle.length() == 0) {
            ((RichTextView) findViewById(R.id.customer_landing_header_subtitle)).setVisibility(8);
        } else {
            ((RichTextView) findViewById(R.id.customer_landing_header_subtitle)).setVisibility(0);
            ((RichTextView) findViewById(R.id.customer_landing_header_subtitle)).setText(landingHeaderRvModel.getSubTitle());
        }
        Collection tabs = landingHeaderRvModel.getTabs();
        if (!(tabs == null || tabs.isEmpty()) || landingHeaderRvModel.getTab() != null) {
            List arrayList = new ArrayList();
            Collection tabs2 = landingHeaderRvModel.getTabs();
            if (tabs2 != null && !tabs2.isEmpty()) {
                z = false;
            }
            if (z) {
                TabInfoEntity tab = landingHeaderRvModel.getTab();
                if (tab != null) {
                    arrayList.add(tab);
                }
            } else {
                List<TabInfoEntity> tabs3 = landingHeaderRvModel.getTabs();
                Intrinsics.checkNotNull(tabs3);
                arrayList.addAll(tabs3);
            }
            ((TabsView) findViewById(R.id.customer_landing_header_tabs)).setVisibility(0);
            ((TabsView) findViewById(R.id.customer_landing_header_tabs)).bindData(scopeContext, arrayList, function1);
            return;
        }
        ((TabsView) findViewById(R.id.customer_landing_header_tabs)).setVisibility(8);
    }
}
