package com.didi.soda.customer.blocks.card;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.didi.app.nova.skeleton.image.RoundedCornersTransformation;
import com.didi.soda.customer.blocks.BlocksConst;
import com.didi.soda.customer.foundation.imageloader.FitWidthTransformation;
import com.didi.soda.customer.foundation.util.CustomerExtentionKt;
import com.didi.soda.customer.foundation.util.FlyImageLoader;
import com.didi.soda.home.topgun.binder.model.HomeHorizontalScrollTopicRvModel;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0011\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\rH\u0002J.\u0010\u0013\u001a\u00020\u00142&\u0010\u0015\u001a\"\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016j\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u0017J0\u0010\u0018\u001a\u00020\u00142&\u0010\u0015\u001a\"\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016j\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u0017H\u0002J0\u0010\u0019\u001a\u00020\u00142&\u0010\u0015\u001a\"\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016j\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u0017H\u0002J0\u0010\u001a\u001a\u00020\u00142&\u0010\u0015\u001a\"\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016j\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u0017H\u0002J0\u0010\u001b\u001a\u00020\u00142&\u0010\u0015\u001a\"\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016j\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u0017H\u0002J\f\u0010\u0013\u001a\u00020\u0014*\u00020\u0003H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, mo175978d2 = {"Lcom/didi/soda/customer/blocks/card/Skin;", "", "topicWidget", "Lcom/didi/soda/customer/blocks/card/TopicWidget;", "(Lcom/didi/soda/customer/blocks/card/TopicWidget;)V", "backgroundGD", "Landroid/graphics/drawable/GradientDrawable;", "colors", "", "", "orientation", "Landroid/graphics/drawable/GradientDrawable$Orientation;", "secondImageUrl", "", "thirdResourceType", "Lcom/didi/soda/customer/blocks/card/ResourceType;", "thirdResourceUrl", "parseColor", "str", "update", "", "props", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "updateAngle", "updateColor", "updateSecondImage", "updateThirdResource", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.soda.customer.blocks.card.a */
/* compiled from: TopicWidget.kt */
final class C13680a {

    /* renamed from: a */
    private final TopicWidget f40608a;

    /* renamed from: b */
    private List<Integer> f40609b = new ArrayList();

    /* renamed from: c */
    private String f40610c = "";

    /* renamed from: d */
    private String f40611d = "";

    /* renamed from: e */
    private ResourceType f40612e = ResourceType.Png;

    /* renamed from: f */
    private GradientDrawable.Orientation f40613f = GradientDrawable.Orientation.LEFT_RIGHT;

    /* renamed from: g */
    private GradientDrawable f40614g;

    public C13680a(TopicWidget topicWidget) {
        Intrinsics.checkNotNullParameter(topicWidget, "topicWidget");
        this.f40608a = topicWidget;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius((float) CustomerExtentionKt.getPx(R.dimen.customer_12px));
        Unit unit = Unit.INSTANCE;
        this.f40614g = gradientDrawable;
    }

    /* renamed from: b */
    private final void m28854b(HashMap<String, Object> hashMap) {
        this.f40609b.clear();
        if (hashMap != null) {
            try {
                Object obj = hashMap.get(BlocksConst.WIDGET_PARAMS_BG_COLOR);
                JsonArray<JsonElement> jsonArray = obj instanceof JsonArray ? (JsonArray) obj : null;
                if (jsonArray != null) {
                    for (JsonElement asString : jsonArray) {
                        this.f40609b.add(Integer.valueOf(m28852a(asString.getAsString())));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (this.f40609b.size() == 1) {
            this.f40609b.add(Integer.valueOf(this.f40609b.get(0).intValue()));
        }
        if (this.f40609b.size() == 0) {
            this.f40609b.add(Integer.valueOf(CustomerExtentionKt.getColor(R.color.rf_color_white_100_FFFFFF)));
            this.f40609b.add(Integer.valueOf(CustomerExtentionKt.getColor(R.color.rf_color_white_100_FFFFFF)));
        }
    }

    /* renamed from: c */
    private final void m28855c(HashMap<String, Object> hashMap) {
        GradientDrawable.Orientation orientation;
        Object obj;
        String str = null;
        if (!(hashMap == null || (obj = hashMap.get(BlocksConst.WIDGET_PARAMS_ANGLE)) == null)) {
            str = obj.toString();
        }
        int i = 0;
        if (str != null) {
            try {
                i = Integer.parseInt(str);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (i == 0) {
            orientation = GradientDrawable.Orientation.LEFT_RIGHT;
        } else if (i == 45) {
            orientation = GradientDrawable.Orientation.BL_TR;
        } else if (i == 90) {
            orientation = GradientDrawable.Orientation.BOTTOM_TOP;
        } else if (i == 135) {
            orientation = GradientDrawable.Orientation.BR_TL;
        } else if (i == 180) {
            orientation = GradientDrawable.Orientation.RIGHT_LEFT;
        } else if (i == 225) {
            orientation = GradientDrawable.Orientation.TR_BL;
        } else if (i == 270) {
            orientation = GradientDrawable.Orientation.TOP_BOTTOM;
        } else if (i != 315) {
            orientation = GradientDrawable.Orientation.LEFT_RIGHT;
        } else {
            orientation = GradientDrawable.Orientation.TL_BR;
        }
        this.f40613f = orientation;
    }

    /* renamed from: d */
    private final void m28856d(HashMap<String, Object> hashMap) {
        Object obj;
        String str = null;
        if (!(hashMap == null || (obj = hashMap.get(BlocksConst.WIDGET_PARAMS_BG_IMAGE)) == null)) {
            str = obj.toString();
        }
        if (str == null) {
            str = "";
        }
        this.f40610c = str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0005, code lost:
        r5 = r5.get(com.didi.soda.customer.blocks.BlocksConst.WIDGET_PARAMS_ICON_IMAGE);
     */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m28857e(java.util.HashMap<java.lang.String, java.lang.Object> r5) {
        /*
            r4 = this;
            r0 = 0
            if (r5 != 0) goto L_0x0005
        L_0x0003:
            r5 = r0
            goto L_0x0012
        L_0x0005:
            java.lang.String r1 = "icon_img"
            java.lang.Object r5 = r5.get(r1)
            if (r5 != 0) goto L_0x000e
            goto L_0x0003
        L_0x000e:
            java.lang.String r5 = r5.toString()
        L_0x0012:
            if (r5 != 0) goto L_0x0017
            java.lang.String r5 = ""
            goto L_0x0028
        L_0x0017:
            r1 = 0
            r2 = 2
            java.lang.String r3 = ".json"
            boolean r0 = kotlin.text.StringsKt.endsWith$default(r5, r3, r1, r2, r0)
            if (r0 == 0) goto L_0x0024
            com.didi.soda.customer.blocks.card.ResourceType r0 = com.didi.soda.customer.blocks.card.ResourceType.Lottie
            goto L_0x0026
        L_0x0024:
            com.didi.soda.customer.blocks.card.ResourceType r0 = com.didi.soda.customer.blocks.card.ResourceType.Png
        L_0x0026:
            r4.f40612e = r0
        L_0x0028:
            r4.f40611d = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.customer.blocks.card.C13680a.m28857e(java.util.HashMap):void");
    }

    /* renamed from: a */
    public final void mo102451a(HashMap<String, Object> hashMap) {
        m28854b(hashMap);
        m28855c(hashMap);
        m28856d(hashMap);
        m28857e(hashMap);
        m28853a(this.f40608a);
    }

    /* renamed from: a */
    private final void m28853a(TopicWidget topicWidget) {
        this.f40614g.setColors(CollectionsKt.toIntArray(this.f40609b));
        this.f40614g.setOrientation(this.f40613f);
        ((RelativeLayout) topicWidget.findViewById(R.id.customer_home_topic_bg)).setBackground(this.f40614g);
        ((ImageView) topicWidget.findViewById(R.id.customer_topic_second_image_view)).setVisibility(8);
        boolean z = false;
        if (this.f40610c.length() > 0) {
            ((ImageView) topicWidget.findViewById(R.id.customer_topic_second_image_view)).setVisibility(0);
            FlyImageLoader.ImageRequestWrapper diskCacheStrategy = FlyImageLoader.loadImageUnspecified(topicWidget.getContext(), this.f40610c).dontAnimate().diskCacheStrategy(FlyImageLoader.DATA);
            Context context = topicWidget.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            diskCacheStrategy.transform(new FitWidthTransformation(context), new RoundedCornersTransformation(topicWidget.getContext(), CustomerExtentionKt.getPx(R.dimen.customer_12px), 0, RoundedCornersTransformation.CornerType.ALL, false)).intoDrawableImageView(topicWidget.getContext(), (ImageView) topicWidget.findViewById(R.id.customer_topic_second_image_view), new Skin$update$1(topicWidget));
        }
        ((LottieAnimationView) topicWidget.findViewById(R.id.customer_topic_third_lottie_view)).setVisibility(8);
        ((ImageView) topicWidget.findViewById(R.id.customer_topic_third_image_view)).setVisibility(8);
        if (!(this.f40611d.length() > 0)) {
            return;
        }
        if (this.f40612e == ResourceType.Lottie) {
            ((LottieAnimationView) topicWidget.findViewById(R.id.customer_topic_third_lottie_view)).setVisibility(0);
            ((LottieAnimationView) topicWidget.findViewById(R.id.customer_topic_third_lottie_view)).setAnimationFromUrl(this.f40611d);
            HomeHorizontalScrollTopicRvModel rvModel = topicWidget.getRvModel();
            if (rvModel != null && rvModel.mIsPlayHandAnim) {
                z = true;
            }
            if (!z) {
                ((LottieAnimationView) topicWidget.findViewById(R.id.customer_topic_third_lottie_view)).playAnimation();
                HomeHorizontalScrollTopicRvModel rvModel2 = topicWidget.getRvModel();
                if (rvModel2 != null) {
                    rvModel2.mIsPlayHandAnim = true;
                    return;
                }
                return;
            }
            return;
        }
        ((ImageView) topicWidget.findViewById(R.id.customer_topic_third_image_view)).setVisibility(0);
        FlyImageLoader.loadImageUnspecified(topicWidget.getContext(), this.f40611d).dontAnimate().into((ImageView) topicWidget.findViewById(R.id.customer_topic_third_image_view));
    }

    /* renamed from: a */
    private final int m28852a(String str) {
        CharSequence charSequence = str;
        if (charSequence == null || charSequence.length() == 0) {
            CustomerExtentionKt.getColor(R.color.rf_color_white_100_FFFFFF);
        }
        try {
            return Color.parseColor(str);
        } catch (Exception e) {
            e.printStackTrace();
            return CustomerExtentionKt.getColor(R.color.rf_color_white_100_FFFFFF);
        }
    }
}
