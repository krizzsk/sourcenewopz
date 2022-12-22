package com.didi.component.savingcenter;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.component.business.util.UiUtils;
import com.didi.component.common.util.GLog;
import com.didi.sdk.view.LazyInflateView;
import com.didi.travel.psnger.model.response.GlobalRichInfo;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.apache.commons.p071io.IOUtils;

@Metadata(mo175977d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010L\u001a\u00020)H\u0002J\b\u0010M\u001a\u00020<H\u0016J\b\u0010N\u001a\u00020OH\u0016J\u0010\u0010P\u001a\u00020O2\u0006\u0010Q\u001a\u00020<H\u0014J\u0015\u0010R\u001a\u00020O2\b\u0010S\u001a\u0004\u0018\u00010)¢\u0006\u0002\u0010-J\u0006\u0010T\u001a\u00020OJ\u0012\u0010U\u001a\u00020O2\b\u0010V\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010W\u001a\u00020O2\b\u0010X\u001a\u0004\u0018\u00010\u001dH\u0016J\u0018\u0010Y\u001a\u00020O2\u0006\u0010Z\u001a\u00020\u00172\u0006\u0010[\u001a\u00020\u0007H\u0016J\u0017\u0010\\\u001a\u00020O2\b\u0010]\u001a\u0004\u0018\u00010)H\u0016¢\u0006\u0002\u0010-J\u0012\u0010^\u001a\u00020O2\b\u0010_\u001a\u0004\u0018\u00010`H\u0016J\u0010\u0010a\u001a\u00020O2\u0006\u0010Z\u001a\u00020\u0017H\u0016J\b\u0010b\u001a\u00020OH\u0016J\u0017\u0010c\u001a\u00020O2\b\u0010S\u001a\u0004\u0018\u00010)H\u0016¢\u0006\u0002\u0010-R\u0014\u0010\u0006\u001a\u00020\u0007XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020#X.¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001e\u0010(\u001a\u0004\u0018\u00010)X\u000e¢\u0006\u0010\n\u0002\u0010.\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010/\u001a\u000200X.¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001a\u00105\u001a\u000206X.¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001a\u0010;\u001a\u00020<X.¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001a\u0010A\u001a\u00020)X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001c\u0010F\u001a\u0004\u0018\u00010GX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010K¨\u0006d"}, mo175978d2 = {"Lcom/didi/component/savingcenter/SavingCenterView;", "Lcom/didi/sdk/view/LazyInflateView;", "Lcom/didi/component/savingcenter/ISavingCenterView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "mHandler", "Landroid/os/Handler;", "getMHandler", "()Landroid/os/Handler;", "setMHandler", "(Landroid/os/Handler;)V", "mIcon", "Lcom/facebook/drawee/view/SimpleDraweeView;", "getMIcon", "()Lcom/facebook/drawee/view/SimpleDraweeView;", "setMIcon", "(Lcom/facebook/drawee/view/SimpleDraweeView;)V", "mIsPlay", "", "getMIsPlay", "()Z", "setMIsPlay", "(Z)V", "mPresenter", "Lcom/didi/component/savingcenter/AbsSavingCenterPresenter;", "getMPresenter", "()Lcom/didi/component/savingcenter/AbsSavingCenterPresenter;", "setMPresenter", "(Lcom/didi/component/savingcenter/AbsSavingCenterPresenter;)V", "mSavingCenterContainer", "Landroid/widget/FrameLayout;", "getMSavingCenterContainer", "()Landroid/widget/FrameLayout;", "setMSavingCenterContainer", "(Landroid/widget/FrameLayout;)V", "mShowTime", "", "getMShowTime", "()Ljava/lang/Integer;", "setMShowTime", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "mSideLayout", "Landroid/widget/RelativeLayout;", "getMSideLayout", "()Landroid/widget/RelativeLayout;", "setMSideLayout", "(Landroid/widget/RelativeLayout;)V", "mSideTextView", "Landroid/widget/TextView;", "getMSideTextView", "()Landroid/widget/TextView;", "setMSideTextView", "(Landroid/widget/TextView;)V", "mView", "Landroid/view/View;", "getMView", "()Landroid/view/View;", "setMView", "(Landroid/view/View;)V", "orinWidth", "getOrinWidth", "()I", "setOrinWidth", "(I)V", "scan", "Landroid/widget/ImageView;", "getScan", "()Landroid/widget/ImageView;", "setScan", "(Landroid/widget/ImageView;)V", "caculateWith", "getView", "hideSideText", "", "onInflate", "inflated", "play", "hideDelay", "playDelay", "setIcon", "url", "setPresenter", "presenter", "setScanVisible", "isShow", "deepLink", "setShowTime", "showTime", "setSideText", "scSideText", "Lcom/didi/travel/psnger/model/response/GlobalRichInfo;", "setVisible", "showDefaultIcon", "showSideText", "comp-savingcenter_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SavingCenterView.kt */
public final class SavingCenterView extends LazyInflateView implements ISavingCenterView {

    /* renamed from: a */
    private final String f15479a = "SavingCenterView";

    /* renamed from: b */
    private AbsSavingCenterPresenter f15480b;

    /* renamed from: c */
    private int f15481c;

    /* renamed from: d */
    private boolean f15482d;

    /* renamed from: e */
    private Integer f15483e = 0;

    /* renamed from: f */
    private ImageView f15484f;
    public Handler mHandler;
    public SimpleDraweeView mIcon;
    public FrameLayout mSavingCenterContainer;
    public RelativeLayout mSideLayout;
    public TextView mSideTextView;
    public View mView;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SavingCenterView(Context context) {
        super(context, (ViewGroup) null, R.layout.saving_center_layout);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final String getTAG() {
        return this.f15479a;
    }

    public final View getMView() {
        View view = this.mView;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mView");
        return null;
    }

    public final void setMView(View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.mView = view;
    }

    public final AbsSavingCenterPresenter getMPresenter() {
        return this.f15480b;
    }

    public final void setMPresenter(AbsSavingCenterPresenter absSavingCenterPresenter) {
        this.f15480b = absSavingCenterPresenter;
    }

    public final SimpleDraweeView getMIcon() {
        SimpleDraweeView simpleDraweeView = this.mIcon;
        if (simpleDraweeView != null) {
            return simpleDraweeView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mIcon");
        return null;
    }

    public final void setMIcon(SimpleDraweeView simpleDraweeView) {
        Intrinsics.checkNotNullParameter(simpleDraweeView, "<set-?>");
        this.mIcon = simpleDraweeView;
    }

    public final FrameLayout getMSavingCenterContainer() {
        FrameLayout frameLayout = this.mSavingCenterContainer;
        if (frameLayout != null) {
            return frameLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mSavingCenterContainer");
        return null;
    }

    public final void setMSavingCenterContainer(FrameLayout frameLayout) {
        Intrinsics.checkNotNullParameter(frameLayout, "<set-?>");
        this.mSavingCenterContainer = frameLayout;
    }

    public final RelativeLayout getMSideLayout() {
        RelativeLayout relativeLayout = this.mSideLayout;
        if (relativeLayout != null) {
            return relativeLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mSideLayout");
        return null;
    }

    public final void setMSideLayout(RelativeLayout relativeLayout) {
        Intrinsics.checkNotNullParameter(relativeLayout, "<set-?>");
        this.mSideLayout = relativeLayout;
    }

    public final TextView getMSideTextView() {
        TextView textView = this.mSideTextView;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mSideTextView");
        return null;
    }

    public final void setMSideTextView(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.mSideTextView = textView;
    }

    public final Handler getMHandler() {
        Handler handler = this.mHandler;
        if (handler != null) {
            return handler;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mHandler");
        return null;
    }

    public final void setMHandler(Handler handler) {
        Intrinsics.checkNotNullParameter(handler, "<set-?>");
        this.mHandler = handler;
    }

    public final int getOrinWidth() {
        return this.f15481c;
    }

    public final void setOrinWidth(int i) {
        this.f15481c = i;
    }

    public final boolean getMIsPlay() {
        return this.f15482d;
    }

    public final void setMIsPlay(boolean z) {
        this.f15482d = z;
    }

    public final Integer getMShowTime() {
        return this.f15483e;
    }

    public final void setMShowTime(Integer num) {
        this.f15483e = num;
    }

    public final ImageView getScan() {
        return this.f15484f;
    }

    public final void setScan(ImageView imageView) {
        this.f15484f = imageView;
    }

    /* access modifiers changed from: protected */
    public void onInflate(View view) {
        Intrinsics.checkNotNullParameter(view, "inflated");
        GLog.m7965d(this.f15479a, "onInflate");
        setMView(view);
        View findViewById = getMView().findViewById(R.id.saving_center_icon);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mView.findViewById(R.id.saving_center_icon)");
        setMIcon((SimpleDraweeView) findViewById);
        this.f15484f = (ImageView) getMView().findViewById(R.id.scan);
        View findViewById2 = getMView().findViewById(R.id.saving_center_container);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mView.findViewById(R.id.saving_center_container)");
        setMSavingCenterContainer((FrameLayout) findViewById2);
        View findViewById3 = getMView().findViewById(R.id.saving_center_side_text_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "mView.findViewById(R.id.…_center_side_text_layout)");
        setMSideLayout((RelativeLayout) findViewById3);
        View findViewById4 = getMView().findViewById(R.id.saving_center_side_text);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "mView.findViewById(R.id.saving_center_side_text)");
        setMSideTextView((TextView) findViewById4);
        getMSideTextView().setHorizontallyScrolling(true);
        getMIcon().setOnClickListener(new SavingCenterView$onInflate$1(this));
        getMSideLayout().setOnClickListener(new SavingCenterView$onInflate$2(this));
        setMHandler(new Handler(Looper.getMainLooper()));
    }

    public void setScanVisible(boolean z, String str) {
        Intrinsics.checkNotNullParameter(str, SDKConstants.PARAM_DEEP_LINK);
        if (z || this.isInflated) {
            super.inflate();
            getMSavingCenterContainer().setVisibility(z ? 0 : 4);
            ImageView imageView = this.f15484f;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            RelativeLayout mSideLayout2 = getMSideLayout();
            if (mSideLayout2 != null) {
                mSideLayout2.setVisibility(8);
            }
            SimpleDraweeView mIcon2 = getMIcon();
            if (mIcon2 != null) {
                mIcon2.setVisibility(8);
            }
            ImageView imageView2 = this.f15484f;
            if (imageView2 != null) {
                imageView2.setOnClickListener(new SavingCenterView$setScanVisible$1(str));
                return;
            }
            return;
        }
        GLog.m7965d(this.f15479a, "set invisible but not infalte yet ignore");
    }

    public void setVisible(boolean z) {
        if (z || this.isInflated) {
            super.inflate();
            getMSavingCenterContainer().setVisibility(z ? 0 : 4);
            ImageView imageView = this.f15484f;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            RelativeLayout mSideLayout2 = getMSideLayout();
            if (mSideLayout2 != null) {
                mSideLayout2.setVisibility(0);
            }
            SimpleDraweeView mIcon2 = getMIcon();
            if (mIcon2 != null) {
                mIcon2.setVisibility(0);
                return;
            }
            return;
        }
        GLog.m7965d(this.f15479a, "set invisible but not infalte yet ignore");
    }

    public void showDefaultIcon() {
        setIcon("res://" + this.mContext.getPackageName() + IOUtils.DIR_SEPARATOR_UNIX + R.drawable.saving_center_icon_default);
    }

    public void setIcon(String str) {
        super.inflate();
        if (str != null) {
            if (Intrinsics.areEqual((Object) str, getMIcon().getTag())) {
                playDelay();
                return;
            }
            getMIcon().setController(((PipelineDraweeControllerBuilder) ((PipelineDraweeControllerBuilder) Fresco.newDraweeControllerBuilder().setUri(Uri.parse(str)).setControllerListener(new SavingCenterView$setIcon$build$1(this, str))).setAutoPlayAnimations(true)).build());
        }
    }

    public final void playDelay() {
        Integer num = this.f15483e;
        if (num == null || num.intValue() != 0) {
            getMHandler().postDelayed(new SavingCenterView$playDelay$1(this), 500);
        }
    }

    public void setSideText(GlobalRichInfo globalRichInfo) {
        super.inflate();
        if (globalRichInfo != null) {
            globalRichInfo.bindTextView(getMSideTextView());
        }
    }

    public void showSideText(Integer num) {
        super.inflate();
        getMHandler().postDelayed(new SavingCenterView$showSideText$1(this, num), 1000);
    }

    public void hideSideText() {
        GLog.m7965d(this.f15479a, "hideSideText");
        if (this.isInflated) {
            super.inflate();
            getMHandler().removeCallbacksAndMessages((Object) null);
            if (this.f15481c != 0) {
                getMSideTextView().setWidth(this.f15481c);
            }
            getMSideLayout().setVisibility(4);
        }
    }

    public void setShowTime(Integer num) {
        this.f15483e = num;
    }

    public final void play(Integer num) {
        GLog.m7965d(this.f15479a, "play");
        CharSequence text = getMSideTextView().getText();
        Intrinsics.checkNotNullExpressionValue(text, "mSideTextView.text");
        if (!(text.length() == 0) && !this.f15482d) {
            this.f15482d = true;
            int a = m11151a();
            this.f15481c = a;
            GLog.m7965d(this.f15479a, Intrinsics.stringPlus("play orinWidth ", Integer.valueOf(a)));
            int dip2px = UiUtils.dip2px(this.mContext, 50.0f);
            ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{dip2px, this.f15481c});
            ofInt.setDuration(500);
            ofInt.addUpdateListener(new SavingCenterView$play$1(this));
            ofInt.start();
            getMSideLayout().setVisibility(0);
            getMHandler().postDelayed(new SavingCenterView$play$2(this, dip2px), (long) (num == null ? 3000 : num.intValue()));
            AbsSavingCenterPresenter absSavingCenterPresenter = this.f15480b;
            if (absSavingCenterPresenter != null) {
                absSavingCenterPresenter.trackSideBarShow();
            }
        }
    }

    /* renamed from: a */
    private final int m11151a() {
        int dip2px = UiUtils.dip2px(this.mContext, 76.0f);
        Object[] array = new Regex("\n").split(getMSideTextView().getText().toString(), 0).toArray(new String[0]);
        if (array != null) {
            String[] strArr = (String[]) array;
            int length = strArr.length;
            String str = "";
            int i = 0;
            int i2 = 0;
            while (i < length) {
                String str2 = strArr[i];
                i++;
                if (str2 != null && i2 < str2.length()) {
                    i2 = str2.length();
                    str = str2;
                }
            }
            if (i2 > 35) {
                str = str.substring(0, 35);
                Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String…ing(startIndex, endIndex)");
                GLog.m7965d(this.f15479a, Intrinsics.stringPlus("maxStr:", str));
            }
            Rect rect = new Rect();
            getMSideTextView().getPaint().getTextBounds(str, 0, str.length(), rect);
            return rect.width() + dip2px + 10;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    public View getView() {
        View realView = getRealView();
        Intrinsics.checkNotNullExpressionValue(realView, "getRealView()");
        return realView;
    }

    public void setPresenter(AbsSavingCenterPresenter absSavingCenterPresenter) {
        this.f15480b = absSavingCenterPresenter;
    }
}
