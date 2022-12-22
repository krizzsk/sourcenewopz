package com.didi.soda.customer.biz.popdialog.natived.view;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.app.nova.skeleton.image.RoundedCornersTransformation;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.rfusion.widget.button.RFMainButton;
import com.didi.soda.customer.biz.popdialog.natived.Contract;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.entity.NAPopDialogEntity;
import com.didi.soda.customer.foundation.util.FlyImageLoader;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\bH\u0016J\b\u0010\u0010\u001a\u00020\u0006H\u0016J\b\u0010\u0011\u001a\u00020\fH\u0016J\u0018\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0014J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\fJ\b\u0010\u001a\u001a\u00020\u0018H\u0014J\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001dH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000¨\u0006 "}, mo175978d2 = {"Lcom/didi/soda/customer/biz/popdialog/natived/view/SharePopDialogView;", "Lcom/didi/soda/customer/biz/popdialog/natived/Contract$AbsPopDialogView;", "()V", "mCouponDescTv", "Landroid/widget/TextView;", "mCouponInfoLayout", "Landroid/widget/RelativeLayout;", "mPopClose", "Landroid/widget/ImageView;", "mPopContent", "mPopImage", "mRootView", "Landroid/view/View;", "mShareBtn", "Lcom/didi/rfusion/widget/button/RFMainButton;", "getClosedView", "getContentView", "getRootView", "inflateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initView", "", "root", "onCreate", "updatePopDialog", "entity", "Lcom/didi/soda/customer/foundation/rpc/entity/NAPopDialogEntity;", "updateView", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SharePopDialogView.kt */
public final class SharePopDialogView extends Contract.AbsPopDialogView {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final float RADIUS = 8.0f;
    public static final String TAG = "SharePopDialogView";
    /* access modifiers changed from: private */

    /* renamed from: a */
    public View f40518a;

    /* renamed from: b */
    private ImageView f40519b;

    /* renamed from: c */
    private RelativeLayout f40520c;

    /* renamed from: d */
    private TextView f40521d;

    /* renamed from: e */
    private RFMainButton f40522e;

    /* renamed from: f */
    private ImageView f40523f;

    /* renamed from: g */
    private RelativeLayout f40524g;

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m28757a(View view) {
    }

    /* access modifiers changed from: protected */
    public View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        View inflate = layoutInflater.inflate(R.layout.customer_dialog_share_coupon_pop, viewGroup, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "it");
        initView(inflate);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…   initView(it)\n        }");
        return inflate;
    }

    public RelativeLayout getContentView() {
        RelativeLayout relativeLayout = this.f40524g;
        if (relativeLayout != null) {
            return relativeLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mPopContent");
        return null;
    }

    public final void initView(View view) {
        Intrinsics.checkNotNullParameter(view, "root");
        View findViewById = view.findViewById(R.id.customer_ll_pop_root);
        Intrinsics.checkNotNullExpressionValue(findViewById, "root.findViewById(R.id.customer_ll_pop_root)");
        this.f40518a = findViewById;
        View findViewById2 = view.findViewById(R.id.customer_iv_pop_image);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "root.findViewById(R.id.customer_iv_pop_image)");
        this.f40519b = (ImageView) findViewById2;
        View findViewById3 = view.findViewById(R.id.customer_share_coupon_info_rl);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "root.findViewById(R.id.c…mer_share_coupon_info_rl)");
        this.f40520c = (RelativeLayout) findViewById3;
        View findViewById4 = view.findViewById(R.id.customer_tv_coupon_desc);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "root.findViewById(R.id.customer_tv_coupon_desc)");
        this.f40521d = (TextView) findViewById4;
        View findViewById5 = view.findViewById(R.id.customer_btn_share);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "root.findViewById(R.id.customer_btn_share)");
        this.f40522e = (RFMainButton) findViewById5;
        View findViewById6 = view.findViewById(R.id.customer_iv_pop_close);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "root.findViewById(R.id.customer_iv_pop_close)");
        this.f40523f = (ImageView) findViewById6;
        View findViewById7 = view.findViewById(R.id.customer_rl_pop_share_content);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "root.findViewById(R.id.c…mer_rl_pop_share_content)");
        this.f40524g = (RelativeLayout) findViewById7;
    }

    public ImageView getClosedView() {
        ImageView imageView = this.f40523f;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mPopClose");
        return null;
    }

    /* access modifiers changed from: protected */
    public void onCreate() {
        super.onCreate();
        View view = this.f40518a;
        RFMainButton rFMainButton = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view = null;
        }
        view.setOnClickListener($$Lambda$SharePopDialogView$dUUEvShbL8Xxf_q4H2Z2BWGJiEc.INSTANCE);
        ImageView imageView = this.f40523f;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPopClose");
            imageView = null;
        }
        imageView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                SharePopDialogView.m28758a(SharePopDialogView.this, view);
            }
        });
        RFMainButton rFMainButton2 = this.f40522e;
        if (rFMainButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mShareBtn");
        } else {
            rFMainButton = rFMainButton2;
        }
        rFMainButton.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                SharePopDialogView.m28760b(SharePopDialogView.this, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m28758a(SharePopDialogView sharePopDialogView, View view) {
        Intrinsics.checkNotNullParameter(sharePopDialogView, "this$0");
        ((Contract.AbsPopDialogPresenter) sharePopDialogView.getPresenter()).onCloseBtnClick();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m28760b(SharePopDialogView sharePopDialogView, View view) {
        Intrinsics.checkNotNullParameter(sharePopDialogView, "this$0");
        ((Contract.AbsPopDialogPresenter) sharePopDialogView.getPresenter()).onBtnClick();
    }

    public void updatePopDialog(NAPopDialogEntity nAPopDialogEntity) {
        Intrinsics.checkNotNullParameter(nAPopDialogEntity, "entity");
        LogUtil.m29104i(TAG, "updatePopDialog");
        FlyImageLoader.ImageRequestWrapper diskCacheStrategy = FlyImageLoader.loadImageUnspecified(getScopeContext(), nAPopDialogEntity.info.imgUrl).diskCacheStrategy(FlyImageLoader.DATA);
        Intrinsics.checkNotNullExpressionValue(diskCacheStrategy, "loadImageUnspecified(sco…tegy(FlyImageLoader.DATA)");
        FlyImageLoader.ImageRequestWrapper listener = diskCacheStrategy.transform(new RoundedCornersTransformation(getContext(), DisplayUtils.dip2px(getContext(), 8.0f), 0, RoundedCornersTransformation.CornerType.TOP, true)).listener(new SharePopDialogView$updatePopDialog$1(this, nAPopDialogEntity));
        ImageView imageView = this.f40519b;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPopImage");
            imageView = null;
        }
        listener.into(imageView);
    }

    public View getRootView() {
        View view = this.f40518a;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m28759a(NAPopDialogEntity nAPopDialogEntity) {
        View view = null;
        try {
            if (nAPopDialogEntity.info != null) {
                String str = nAPopDialogEntity.info.text;
                Intrinsics.checkNotNullExpressionValue(str, "entity.info.text");
                boolean z = true;
                if (str.length() > 0) {
                    String str2 = nAPopDialogEntity.info.textColor;
                    Intrinsics.checkNotNullExpressionValue(str2, "entity.info.textColor");
                    if (str2.length() > 0) {
                        String str3 = nAPopDialogEntity.info.btnText;
                        Intrinsics.checkNotNullExpressionValue(str3, "entity.info.btnText");
                        if (str3.length() > 0) {
                            int color = ResourceHelper.getColor(R.color.rf_color_white_100_alpha_0);
                            String str4 = nAPopDialogEntity.info.textBackground;
                            Intrinsics.checkNotNullExpressionValue(str4, "entity.info.textBackground");
                            if (str4.length() <= 0) {
                                z = false;
                            }
                            if (z) {
                                color = Color.parseColor(nAPopDialogEntity.info.textBackground);
                            }
                            RelativeLayout relativeLayout = this.f40520c;
                            if (relativeLayout == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("mCouponInfoLayout");
                                relativeLayout = null;
                            }
                            Drawable background = relativeLayout.getBackground();
                            if (background != null) {
                                ((GradientDrawable) background).setColor(color);
                                TextView textView = this.f40521d;
                                if (textView == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("mCouponDescTv");
                                    textView = null;
                                }
                                textView.setText(nAPopDialogEntity.info.text);
                                int parseColor = Color.parseColor(nAPopDialogEntity.info.textColor);
                                TextView textView2 = this.f40521d;
                                if (textView2 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("mCouponDescTv");
                                    textView2 = null;
                                }
                                textView2.setTextColor(parseColor);
                                RFMainButton rFMainButton = this.f40522e;
                                if (rFMainButton == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("mShareBtn");
                                    rFMainButton = null;
                                }
                                rFMainButton.setText(nAPopDialogEntity.info.btnText);
                                showPopDialog(nAPopDialogEntity);
                                return;
                            }
                            throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            View view2 = this.f40518a;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            } else {
                view = view2;
            }
            view.setVisibility(8);
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/soda/customer/biz/popdialog/natived/view/SharePopDialogView$Companion;", "", "()V", "RADIUS", "", "TAG", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: SharePopDialogView.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
