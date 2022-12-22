package com.didiglobal.privacysdk.law.update;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.global.globaluikit.drawer.LEGOPopupWindow;
import com.didi.global.globaluikit.utils.UiUtils;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0004$%&'B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0019\u001a\u00020\u001a2\b\b\u0001\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\"H\u0002J\u0016\u0010#\u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u001b\u001a\u00020\u001cR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000¨\u0006("}, mo175978d2 = {"Lcom/didiglobal/privacysdk/law/update/LawPopDialogShowManager;", "", "()V", "content", "Landroid/widget/TextView;", "contentLayout", "Lcom/didiglobal/privacysdk/law/update/MaxHeightScrollView;", "dissmissListener", "Lcom/didiglobal/privacysdk/law/update/LawPopDialogShowManager$OnDismissListener;", "isShowing", "", "linkText", "linkTextLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "okButton", "popWidow", "Lcom/didi/global/globaluikit/drawer/LEGOPopupWindow;", "realView", "Landroid/view/View;", "realViewLayoutParams", "Landroid/widget/LinearLayout$LayoutParams;", "rootView", "Landroid/view/ViewGroup;", "titleView", "viewBg", "bindData", "", "dataBuilder", "Lcom/didiglobal/privacysdk/law/update/LawPopDialogShowManager$DataBuilder;", "init", "context", "Landroid/content/Context;", "realShow", "activity", "Landroid/app/Activity;", "show", "Data", "DataBuilder", "OnClickListener", "OnDismissListener", "PrivacySDK_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: LawPopDialogShowManager.kt */
public final class LawPopDialogShowManager {
    public static final LawPopDialogShowManager INSTANCE = new LawPopDialogShowManager();
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static LEGOPopupWindow f50667a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static boolean f50668b;

    /* renamed from: c */
    private static ViewGroup f50669c;

    /* renamed from: d */
    private static View f50670d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static OnDismissListener f50671e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public static MaxHeightScrollView f50672f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public static View f50673g;

    /* renamed from: h */
    private static LinearLayout.LayoutParams f50674h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public static TextView f50675i;

    /* renamed from: j */
    private static TextView f50676j;

    /* renamed from: k */
    private static TextView f50677k;

    /* renamed from: l */
    private static TextView f50678l;

    /* renamed from: m */
    private static ConstraintLayout f50679m;

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, mo175978d2 = {"Lcom/didiglobal/privacysdk/law/update/LawPopDialogShowManager$OnClickListener;", "", "onButtonClick", "", "popupWindow", "Landroid/widget/PopupWindow;", "onLinkClick", "linkUrlStr", "", "PrivacySDK_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: LawPopDialogShowManager.kt */
    public interface OnClickListener {
        void onButtonClick(PopupWindow popupWindow);

        void onLinkClick(PopupWindow popupWindow, String str);
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, mo175978d2 = {"Lcom/didiglobal/privacysdk/law/update/LawPopDialogShowManager$OnDismissListener;", "", "onDismiss", "", "PrivacySDK_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: LawPopDialogShowManager.kt */
    public interface OnDismissListener {
        void onDismiss();
    }

    static {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        f50674h = layoutParams;
    }

    private LawPopDialogShowManager() {
    }

    /* renamed from: a */
    private final void m36388a(Context context) {
        if (f50669c == null) {
            ViewGroup linearLayout = new LinearLayout(context);
            f50669c = linearLayout;
            if (linearLayout != null) {
                ((LinearLayout) linearLayout).setBackgroundColor(context.getResources().getColor(R.color.lego_color_70_0A121A));
                ViewGroup viewGroup = f50669c;
                if (viewGroup != null) {
                    ((LinearLayout) viewGroup).setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type android.widget.LinearLayout");
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type android.widget.LinearLayout");
            }
        }
        if (f50670d == null) {
            View view = null;
            View inflate = LayoutInflater.from(context).inflate(R.layout.layout_law_pop, (ViewGroup) null, false);
            f50670d = inflate;
            f50675i = inflate != null ? (TextView) inflate.findViewById(R.id.content) : null;
            View view2 = f50670d;
            f50676j = view2 != null ? (TextView) view2.findViewById(R.id.title) : null;
            View view3 = f50670d;
            f50677k = view3 != null ? (TextView) view3.findViewById(R.id.okButton) : null;
            View view4 = f50670d;
            f50678l = view4 != null ? (TextView) view4.findViewById(R.id.linkText) : null;
            View view5 = f50670d;
            f50679m = view5 != null ? (ConstraintLayout) view5.findViewById(R.id.linkTextLayout) : null;
            View view6 = f50670d;
            f50672f = view6 != null ? (MaxHeightScrollView) view6.findViewById(R.id.contentLayout) : null;
            View view7 = f50670d;
            if (view7 != null) {
                view = view7.findViewById(R.id.viewBg);
            }
            f50673g = view;
        }
        ViewGroup viewGroup2 = f50669c;
        if (viewGroup2 != null) {
            viewGroup2.removeAllViews();
        }
        ViewGroup viewGroup3 = f50669c;
        if (viewGroup3 != null) {
            viewGroup3.addView(f50670d, f50674h);
        }
    }

    /* renamed from: a */
    private final void m36389a(DataBuilder dataBuilder) {
        Data build = dataBuilder.build();
        TextView textView = f50676j;
        if (textView != null) {
            textView.setText(build.getTitle());
        }
        TextView textView2 = f50675i;
        if (textView2 != null) {
            textView2.setText(build.getContent());
        }
        TextView textView3 = f50678l;
        if (textView3 != null) {
            textView3.setText(build.getLinkText());
        }
        f50671e = build.getOnDismissListener();
        TextView textView4 = f50677k;
        if (textView4 != null) {
            textView4.setOnClickListener(new LawPopDialogShowManager$bindData$1(build));
        }
        ConstraintLayout constraintLayout = f50679m;
        if (constraintLayout != null) {
            constraintLayout.setOnClickListener(new LawPopDialogShowManager$bindData$2(build));
        }
        MaxHeightScrollView maxHeightScrollView = f50672f;
        if (maxHeightScrollView != null) {
            TextView textView5 = f50676j;
            if (textView5 == null) {
                Intrinsics.throwNpe();
            }
            maxHeightScrollView.bindView(textView5);
        }
        TextView textView6 = f50675i;
        if (textView6 != null) {
            textView6.post(LawPopDialogShowManager$bindData$3.INSTANCE);
        }
    }

    /* renamed from: a */
    private final void m36387a(Activity activity) {
        Context context = activity;
        LEGOPopupWindow lEGOPopupWindow = new LEGOPopupWindow(f50669c, -1, -1, f50670d, context, true, LawPopDialogShowManager$realShow$1.INSTANCE);
        f50667a = lEGOPopupWindow;
        if (lEGOPopupWindow != null) {
            lEGOPopupWindow.setSoftInputMode(16);
        }
        View view = f50670d;
        if (view != null) {
            view.setAnimation(AnimationUtils.loadAnimation(context, R.anim.lego_drawer_bottom_in));
        }
        LEGOPopupWindow lEGOPopupWindow2 = f50667a;
        if (lEGOPopupWindow2 != null) {
            lEGOPopupWindow2.setClippingEnabled(false);
        }
        LEGOPopupWindow lEGOPopupWindow3 = f50667a;
        if (lEGOPopupWindow3 != null) {
            lEGOPopupWindow3.setFocusable(true);
        }
        LEGOPopupWindow lEGOPopupWindow4 = f50667a;
        if (lEGOPopupWindow4 != null) {
            lEGOPopupWindow4.setBackgroundDrawable(new ColorDrawable(0));
        }
        LEGOPopupWindow lEGOPopupWindow5 = f50667a;
        if (lEGOPopupWindow5 != null) {
            lEGOPopupWindow5.setOutsideTouchable(false);
        }
        try {
            Window window = activity.getWindow();
            Intrinsics.checkExpressionValueIsNotNull(window, "activity.window");
            View decorView = window.getDecorView();
            Intrinsics.checkExpressionValueIsNotNull(decorView, "activity.window.decorView");
            LEGOPopupWindow lEGOPopupWindow6 = f50667a;
            if (lEGOPopupWindow6 != null) {
                lEGOPopupWindow6.showAtLocation(decorView, 80, 0, 0);
            }
            if (UiUtils.isNavigationBarExist(activity)) {
                View view2 = f50670d;
                ViewGroup.LayoutParams layoutParams = view2 != null ? view2.getLayoutParams() : null;
                if (layoutParams instanceof LinearLayout.LayoutParams) {
                    ((LinearLayout.LayoutParams) layoutParams).bottomMargin = UiUtils.getNavigationBarHeight(activity);
                }
            }
            f50668b = true;
        } catch (Exception unused) {
            f50668b = false;
        }
    }

    public final void show(Activity activity, DataBuilder dataBuilder) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        Intrinsics.checkParameterIsNotNull(dataBuilder, "dataBuilder");
        if (!activity.isFinishing() && !f50668b) {
            m36388a((Context) activity);
            m36389a(dataBuilder);
            m36387a(activity);
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\b¨\u0006\u001e"}, mo175978d2 = {"Lcom/didiglobal/privacysdk/law/update/LawPopDialogShowManager$Data;", "", "()V", "content", "", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "linkText", "getLinkText", "setLinkText", "linkUrl", "getLinkUrl", "setLinkUrl", "onClickListener", "Lcom/didiglobal/privacysdk/law/update/LawPopDialogShowManager$OnClickListener;", "getOnClickListener", "()Lcom/didiglobal/privacysdk/law/update/LawPopDialogShowManager$OnClickListener;", "setOnClickListener", "(Lcom/didiglobal/privacysdk/law/update/LawPopDialogShowManager$OnClickListener;)V", "onDismissListener", "Lcom/didiglobal/privacysdk/law/update/LawPopDialogShowManager$OnDismissListener;", "getOnDismissListener", "()Lcom/didiglobal/privacysdk/law/update/LawPopDialogShowManager$OnDismissListener;", "setOnDismissListener", "(Lcom/didiglobal/privacysdk/law/update/LawPopDialogShowManager$OnDismissListener;)V", "title", "getTitle", "setTitle", "PrivacySDK_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: LawPopDialogShowManager.kt */
    public static final class Data {
        private String content = "";
        private String linkText = "";
        private String linkUrl = "";
        private OnClickListener onClickListener;
        private OnDismissListener onDismissListener;
        private String title = "";

        public final String getTitle() {
            return this.title;
        }

        public final void setTitle(String str) {
            Intrinsics.checkParameterIsNotNull(str, "<set-?>");
            this.title = str;
        }

        public final String getContent() {
            return this.content;
        }

        public final void setContent(String str) {
            Intrinsics.checkParameterIsNotNull(str, "<set-?>");
            this.content = str;
        }

        public final String getLinkText() {
            return this.linkText;
        }

        public final void setLinkText(String str) {
            Intrinsics.checkParameterIsNotNull(str, "<set-?>");
            this.linkText = str;
        }

        public final String getLinkUrl() {
            return this.linkUrl;
        }

        public final void setLinkUrl(String str) {
            Intrinsics.checkParameterIsNotNull(str, "<set-?>");
            this.linkUrl = str;
        }

        public final OnClickListener getOnClickListener() {
            return this.onClickListener;
        }

        public final void setOnClickListener(OnClickListener onClickListener2) {
            this.onClickListener = onClickListener2;
        }

        public final OnDismissListener getOnDismissListener() {
            return this.onDismissListener;
        }

        public final void setOnDismissListener(OnDismissListener onDismissListener2) {
            this.onDismissListener = onDismissListener2;
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\bJ\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\bJ\u0010\u0010\r\u001a\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010\u0010\u001a\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\u0011J\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, mo175978d2 = {"Lcom/didiglobal/privacysdk/law/update/LawPopDialogShowManager$DataBuilder;", "", "()V", "data", "Lcom/didiglobal/privacysdk/law/update/LawPopDialogShowManager$Data;", "build", "setContent", "contentStr", "", "setLinkText", "linkTextStr", "setLinkUrl", "linkUrlStr", "setOnClickListener", "listener", "Lcom/didiglobal/privacysdk/law/update/LawPopDialogShowManager$OnClickListener;", "setOnDismissListener", "Lcom/didiglobal/privacysdk/law/update/LawPopDialogShowManager$OnDismissListener;", "setTitle", "titleStr", "PrivacySDK_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: LawPopDialogShowManager.kt */
    public static final class DataBuilder {
        private Data data = new Data();

        public final DataBuilder setTitle(String str) {
            Intrinsics.checkParameterIsNotNull(str, "titleStr");
            this.data.setTitle(str);
            return this;
        }

        public final DataBuilder setContent(String str) {
            Intrinsics.checkParameterIsNotNull(str, "contentStr");
            this.data.setContent(str);
            return this;
        }

        public final DataBuilder setLinkText(String str) {
            Intrinsics.checkParameterIsNotNull(str, "linkTextStr");
            this.data.setLinkText(str);
            return this;
        }

        public final DataBuilder setLinkUrl(String str) {
            Intrinsics.checkParameterIsNotNull(str, "linkUrlStr");
            this.data.setLinkUrl(str);
            return this;
        }

        public final DataBuilder setOnClickListener(OnClickListener onClickListener) {
            this.data.setOnClickListener(onClickListener);
            return this;
        }

        public final DataBuilder setOnDismissListener(OnDismissListener onDismissListener) {
            this.data.setOnDismissListener(onDismissListener);
            return this;
        }

        public final Data build() {
            return this.data;
        }
    }
}
