package com.didiglobal.component.imentrance.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.didi.beatles.p099im.access.msg.IMMsg;
import com.didi.beatles.p099im.access.msg.IMMsgType;
import com.didi.global.globalgenerickit.eventtracker.Const;
import com.didi.raven.config.RavenKey;
import com.didiglobal.travel.infra.content.ContextKt;
import com.taxis99.R;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002./B\u0005¢\u0006\u0002\u0010\u0002J>\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00040\u000eH\u0007J\f\u0010\u000f\u001a\u00020\u0010*\u00020\nH\u0002J.\u0010\u0011\u001a\u00020\u0004*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\n2\u0017\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00040\u000e¢\u0006\u0002\b\u0016H\bJ\f\u0010\u0017\u001a\u00020\f*\u00020\nH\u0002J\u000e\u0010\u0018\u001a\u0004\u0018\u00010\u0012*\u00020\nH\u0002J8\u0010\u0019\u001a\u00020\u0004*\u00020\n2\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00040\u000eH\u0002JI\u0010\u001d\u001a\u00020\u001e*\u00020\n2:\b\u0004\u0010\u001d\u001a4\u0012\u0013\u0012\u00110\n¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0015\u0012\u0013\u0018\u00010\u0010¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\u00040\u001fH\bJ\u0014\u0010$\u001a\u00020\u0004*\u00020\b2\u0006\u0010%\u001a\u00020&H\u0002J!\u0010'\u001a\u00020\u0004*\u00020\n2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00100\u000eH\bJ\u001c\u0010)\u001a\u00020\u0004*\u00020\n2\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010*\u001a\u00020+H\u0002J\u0015\u0010,\u001a\u00020\u0004*\u00020\n2\u0006\u0010-\u001a\u00020\u0010H\b¨\u00060"}, mo175978d2 = {"Lcom/didiglobal/component/imentrance/view/MessageBubbleHelper;", "", "()V", "popupMessage", "", "context", "Landroid/content/Context;", "message", "Lcom/didi/beatles/im/access/msg/IMMsg;", "anchorView", "Landroid/view/View;", "tint", "", "onClick", "Lkotlin/Function1;", "actualVisible", "", "addViewLayoutWrapped", "Landroid/widget/FrameLayout;", "child", "params", "Landroid/widget/FrameLayout$LayoutParams;", "Lkotlin/ExtensionFunctionType;", "ensureHeight", "findRoot", "mountWithAnchor", "anchor", "xoff", "yoff", "onLayoutChange", "Lcom/didiglobal/component/imentrance/view/MessageBubbleHelper$AnchorLayoutObserver;", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "v", "attached", "showIn", "textView", "Landroid/widget/TextView;", "traverseAncestor", "block", "updateLocation", "tag", "Lcom/didiglobal/component/imentrance/view/MessageBubbleHelper$AnchorBubbleTag;", "visibleWithEnabled", "visible", "AnchorBubbleTag", "AnchorLayoutObserver", "comp-imentrance_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: MessageBubbleHelper.kt */
public final class MessageBubbleHelper {

    @Metadata(mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: MessageBubbleHelper.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[IMMsgType.values().length];
            iArr[IMMsgType.TYPE_TEXT_RECOMMEND.ordinal()] = 1;
            iArr[IMMsgType.TYPE_TEXT.ordinal()] = 2;
            iArr[IMMsgType.TYPE_VOICE.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void popupMessage(android.content.Context r15, com.didi.beatles.p099im.access.msg.IMMsg r16, android.view.View r17, int r18, kotlin.jvm.functions.Function1<? super android.view.View, kotlin.Unit> r19) {
        /*
            r14 = this;
            r6 = r14
            r0 = r15
            r1 = r16
            r2 = r17
            r3 = r19
            java.lang.String r4 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r4)
            java.lang.String r4 = "message"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r4)
            java.lang.String r4 = "anchorView"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r4)
            java.lang.String r4 = "onClick"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r4)
            r4 = 2131431096(0x7f0b0eb8, float:1.8483912E38)
            java.lang.Object r4 = r2.getTag(r4)
            boolean r5 = r4 instanceof com.didiglobal.component.imentrance.view.MessageBubbleHelper.AnchorBubbleTag
            r7 = 0
            if (r5 == 0) goto L_0x002b
            com.didiglobal.component.imentrance.view.MessageBubbleHelper$AnchorBubbleTag r4 = (com.didiglobal.component.imentrance.view.MessageBubbleHelper.AnchorBubbleTag) r4
            goto L_0x002c
        L_0x002b:
            r4 = r7
        L_0x002c:
            if (r4 != 0) goto L_0x002f
            goto L_0x004f
        L_0x002f:
            android.view.View r5 = r4.checkBubbleView()
            if (r5 != 0) goto L_0x0037
        L_0x0035:
            r5 = r7
            goto L_0x0046
        L_0x0037:
            boolean r8 = androidx.core.view.ViewCompat.isAttachedToWindow(r5)
            if (r8 == 0) goto L_0x003e
            goto L_0x003f
        L_0x003e:
            r5 = r7
        L_0x003f:
            if (r5 != 0) goto L_0x0042
            goto L_0x0035
        L_0x0042:
            kotlin.Pair r5 = kotlin.TuplesKt.m42317to(r4, r5)
        L_0x0046:
            if (r5 != 0) goto L_0x004e
            r4.clear()
            kotlin.Pair r7 = (kotlin.Pair) r7
            goto L_0x004f
        L_0x004e:
            r7 = r5
        L_0x004f:
            r4 = 2131435094(0x7f0b1e56, float:1.849202E38)
            r5 = 2131431097(0x7f0b0eb9, float:1.8483914E38)
            if (r7 != 0) goto L_0x0058
            goto L_0x0081
        L_0x0058:
            java.lang.Object r8 = r7.component1()
            com.didiglobal.component.imentrance.view.MessageBubbleHelper$AnchorBubbleTag r8 = (com.didiglobal.component.imentrance.view.MessageBubbleHelper.AnchorBubbleTag) r8
            java.lang.Object r7 = r7.component2()
            android.view.View r7 = (android.view.View) r7
            boolean r9 = r7 instanceof android.widget.FrameLayout
            if (r9 == 0) goto L_0x0081
            r9 = r7
            android.widget.FrameLayout r9 = (android.widget.FrameLayout) r9
            int r9 = r9.getId()
            if (r9 != r5) goto L_0x0081
            r14.m35943a((android.view.View) r7, (android.view.View) r2, (com.didiglobal.component.imentrance.view.MessageBubbleHelper.AnchorBubbleTag) r8)
            android.view.View r0 = r7.findViewById(r4)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 != 0) goto L_0x007d
            goto L_0x0080
        L_0x007d:
            r14.m35947a((com.didi.beatles.p099im.access.msg.IMMsg) r1, (android.widget.TextView) r0)
        L_0x0080:
            return
        L_0x0081:
            android.widget.FrameLayout r7 = new android.widget.FrameLayout
            r7.<init>(r15)
            r7.setId(r5)
            r5 = 2131234108(0x7f080d3c, float:1.8084372E38)
            r7.setBackgroundResource(r5)
            r5 = 10
            long r8 = com.didiglobal.travel.infra.dimens.ValueDimensionsKt.getDp((int) r5)
            int r8 = com.didiglobal.travel.infra.dimens.ValueDimensions.m47078toPxIntimpl(r8, r15)
            long r9 = com.didiglobal.travel.infra.dimens.ValueDimensionsKt.getDp((int) r5)
            int r5 = com.didiglobal.travel.infra.dimens.ValueDimensions.m47078toPxIntimpl(r9, r15)
            r9 = 4
            long r10 = com.didiglobal.travel.infra.dimens.ValueDimensionsKt.getDp((int) r9)
            int r10 = com.didiglobal.travel.infra.dimens.ValueDimensions.m47078toPxIntimpl(r10, r15)
            r11 = 0
            r7.setPaddingRelative(r8, r11, r5, r10)
            if (r18 == 0) goto L_0x00ba
            r5 = r7
            android.view.View r5 = (android.view.View) r5
            android.content.res.ColorStateList r8 = android.content.res.ColorStateList.valueOf(r18)
            androidx.core.view.ViewCompat.setBackgroundTintList(r5, r8)
        L_0x00ba:
            r7.setClipChildren(r11)
            android.view.ViewGroup$MarginLayoutParams r5 = new android.view.ViewGroup$MarginLayoutParams
            r8 = -2
            r5.<init>(r8, r8)
            r10 = 20
            long r12 = com.didiglobal.travel.infra.dimens.ValueDimensionsKt.getDp((int) r10)
            int r12 = com.didiglobal.travel.infra.dimens.ValueDimensions.m47078toPxIntimpl(r12, r15)
            r5.setMarginStart(r12)
            r5.setMarginEnd(r12)
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            android.view.ViewGroup$LayoutParams r5 = (android.view.ViewGroup.LayoutParams) r5
            r7.setLayoutParams(r5)
            r5 = r7
            android.view.View r5 = (android.view.View) r5
            r5.setVisibility(r9)
            r5.setEnabled(r11)
            androidx.appcompat.widget.AppCompatTextView r11 = new androidx.appcompat.widget.AppCompatTextView
            r11.<init>(r15)
            r11.setId(r4)
            android.text.TextUtils$TruncateAt r4 = android.text.TextUtils.TruncateAt.END
            r11.setEllipsize(r4)
            r4 = 1
            r11.setMaxLines(r4)
            r12 = 214(0xd6, float:3.0E-43)
            long r12 = com.didiglobal.travel.infra.dimens.ValueDimensionsKt.getDp((int) r12)
            int r12 = com.didiglobal.travel.infra.dimens.ValueDimensions.m47078toPxIntimpl(r12, r15)
            r11.setMaxWidth(r12)
            r12 = 2131100573(0x7f06039d, float:1.7813531E38)
            int r12 = com.didiglobal.travel.infra.content.ContextKt.colorOf(r15, r12)
            r11.setTextColor(r12)
            r12 = 1094713344(0x41400000, float:12.0)
            r11.setTextSize(r4, r12)
            r4 = r11
            android.widget.TextView r4 = (android.widget.TextView) r4
            r14.m35947a((com.didi.beatles.p099im.access.msg.IMMsg) r1, (android.widget.TextView) r4)
            android.view.View r11 = (android.view.View) r11
            android.widget.FrameLayout$LayoutParams r1 = new android.widget.FrameLayout$LayoutParams
            r1.<init>(r8, r8)
            r4 = 16
            r1.gravity = r4
            long r12 = com.didiglobal.travel.infra.dimens.ValueDimensionsKt.getDp((int) r10)
            int r4 = com.didiglobal.travel.infra.dimens.ValueDimensions.m47078toPxIntimpl(r12, r15)
            r1.setMarginEnd(r4)
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            android.view.ViewGroup$LayoutParams r1 = (android.view.ViewGroup.LayoutParams) r1
            r7.addView(r11, r1)
            androidx.appcompat.widget.AppCompatImageView r1 = new androidx.appcompat.widget.AppCompatImageView
            r1.<init>(r15)
            r4 = 2131233882(0x7f080c5a, float:1.8083914E38)
            r1.setImageResource(r4)
            android.view.View r1 = (android.view.View) r1
            android.widget.FrameLayout$LayoutParams r4 = new android.widget.FrameLayout$LayoutParams
            r4.<init>(r8, r8)
            r8 = 8388629(0x800015, float:1.1754973E-38)
            r4.gravity = r8
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            android.view.ViewGroup$LayoutParams r4 = (android.view.ViewGroup.LayoutParams) r4
            r7.addView(r1, r4)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            r4 = 0
            long r7 = com.didiglobal.travel.infra.dimens.ValueDimensionsKt.getDp((int) r9)
            int r0 = com.didiglobal.travel.infra.dimens.ValueDimensions.m47078toPxIntimpl(r7, r15)
            int r7 = -r0
            com.didiglobal.component.imentrance.view.MessageBubbleHelper$popupMessage$4 r0 = new com.didiglobal.component.imentrance.view.MessageBubbleHelper$popupMessage$4
            r0.<init>(r3)
            r8 = r0
            kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8
            r0 = r14
            r1 = r5
            r2 = r17
            r3 = r4
            r4 = r7
            r5 = r8
            r0.m35942a(r1, r2, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.component.imentrance.view.MessageBubbleHelper.popupMessage(android.content.Context, com.didi.beatles.im.access.msg.IMMsg, android.view.View, int, kotlin.jvm.functions.Function1):void");
    }

    /* renamed from: a */
    private final void m35947a(IMMsg iMMsg, TextView textView) {
        String str;
        IMMsgType iMMsgType = iMMsg.type;
        int i = iMMsgType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[iMMsgType.ordinal()];
        if (i == 1 || i == 2) {
            str = iMMsg.textContent;
        } else if (i != 3) {
            str = null;
        } else {
            Context context = textView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "textView.context");
            str = ContextKt.stringOf(context, R.string.global_im_content_voice);
        }
        textView.setText(str);
    }

    /* renamed from: a */
    private final void m35946a(FrameLayout frameLayout, View view, Function1<? super FrameLayout.LayoutParams, Unit> function1) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        function1.invoke(layoutParams);
        frameLayout.addView(view, layoutParams);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m35943a(View view, View view2, AnchorBubbleTag anchorBubbleTag) {
        int[] loc = anchorBubbleTag.getLoc();
        view2.getLocationInWindow(loc);
        view.setVisibility(0);
        view.setEnabled(true);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            marginLayoutParams.leftMargin = loc[0] + anchorBubbleTag.getXoff();
            marginLayoutParams.topMargin = (loc[1] + anchorBubbleTag.getYoff()) - m35948b(view);
            view.requestLayout();
        }
    }

    /* renamed from: a */
    private final void m35942a(View view, View view2, int i, int i2, Function1<? super View, Unit> function1) {
        FrameLayout a = m35940a(view2);
        if (a != null) {
            a.addView(view);
            AnchorBubbleTag anchorBubbleTag = new AnchorBubbleTag(view2, view, i, i2);
            C16667xf878c890 r4 = new C16667xf878c890(view2, this, view, anchorBubbleTag);
            r4.attach();
            anchorBubbleTag.setAnchorLayoutObserver(r4);
            view.setOnClickListener(new MessageBubbleHelper$mountWithAnchor$lambda20$$inlined$onClick$1(anchorBubbleTag, function1));
        }
    }

    /* renamed from: a */
    private final AnchorLayoutObserver m35941a(View view, Function2<? super View, ? super Boolean, Unit> function2) {
        MessageBubbleHelper$onLayoutChange$1 messageBubbleHelper$onLayoutChange$1 = new MessageBubbleHelper$onLayoutChange$1(function2, view);
        messageBubbleHelper$onLayoutChange$1.attach();
        return messageBubbleHelper$onLayoutChange$1;
    }

    /* renamed from: a */
    private final FrameLayout m35940a(View view) {
        ViewParent parent = view.getParent();
        do {
            if (parent instanceof FrameLayout) {
                FrameLayout frameLayout = (FrameLayout) parent;
                if (frameLayout.getId() == 16908290) {
                    return frameLayout;
                }
            }
            if (parent == null) {
                parent = null;
                continue;
            } else {
                parent = parent.getParent();
                continue;
            }
        } while (parent != null);
        return null;
    }

    /* renamed from: b */
    private final int m35948b(View view) {
        int height = view.getHeight();
        if (height > 0) {
            return height;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        view.measure(makeMeasureSpec, makeMeasureSpec);
        return view.getMeasuredHeight();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public final boolean m35949c(View view) {
        boolean z = true;
        while (view != null) {
            boolean z2 = false;
            if (view.getVisibility() != 0) {
                z = false;
                z2 = true;
            }
            if (z2) {
                break;
            }
            ViewParent parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        return z;
    }

    /* renamed from: a */
    private final void m35944a(View view, Function1<? super View, Boolean> function1) {
        while (view != null && !function1.invoke(view).booleanValue()) {
            ViewParent parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
    }

    @Metadata(mo175977d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0012\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\r\u001a\u00020\u000bJ\u0006\u0010\u000e\u001a\u00020\u000bJ\u000e\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0005J\u001f\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0002\u0010\u0014R\u001c\u0010\u0007\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\u00050\u00050\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, mo175978d2 = {"Lcom/didiglobal/component/imentrance/view/MessageBubbleHelper$AnchorLayoutObserver;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "Landroid/view/ViewTreeObserver$OnScrollChangedListener;", "Landroid/view/View$OnAttachStateChangeListener;", "v", "Landroid/view/View;", "(Landroid/view/View;)V", "viewRef", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "attach", "", "detach", "onGlobalLayout", "onScrollChanged", "onViewAttachedToWindow", "onViewDetachedFromWindow", "onViewLayoutChange", "attached", "", "(Landroid/view/View;Ljava/lang/Boolean;)V", "comp-imentrance_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: MessageBubbleHelper.kt */
    private static class AnchorLayoutObserver implements View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener {
        private final WeakReference<View> viewRef;

        public void onViewLayoutChange(View view, Boolean bool) {
            Intrinsics.checkNotNullParameter(view, RavenKey.VERSION);
        }

        public AnchorLayoutObserver(View view) {
            Intrinsics.checkNotNullParameter(view, RavenKey.VERSION);
            this.viewRef = new WeakReference<>(view);
        }

        public final void onGlobalLayout() {
            View view = (View) this.viewRef.get();
            if (view != null) {
                onViewLayoutChange(view, (Boolean) null);
            }
        }

        public final void onScrollChanged() {
            View view = (View) this.viewRef.get();
            if (view != null) {
                onViewLayoutChange(view, (Boolean) null);
            }
        }

        public final void onViewAttachedToWindow(View view) {
            Intrinsics.checkNotNullParameter(view, RavenKey.VERSION);
            view.getViewTreeObserver().addOnScrollChangedListener(this);
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
            onViewLayoutChange(view, true);
        }

        public final void onViewDetachedFromWindow(View view) {
            Intrinsics.checkNotNullParameter(view, RavenKey.VERSION);
            view.getViewTreeObserver().removeOnScrollChangedListener(this);
            view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            onViewLayoutChange(view, false);
        }

        public final void attach() {
            View view = (View) this.viewRef.get();
            if (view != null) {
                if (ViewCompat.isAttachedToWindow(view)) {
                    onViewAttachedToWindow(view);
                }
                view.addOnAttachStateChangeListener(this);
            }
        }

        public final void detach() {
            View view = (View) this.viewRef.get();
            if (view != null) {
                view.removeOnAttachStateChangeListener(this);
            }
        }
    }

    @Metadata(mo175977d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\u0006\u0010\u001e\u001a\u00020\u001fJ\b\u0010 \u001a\u0004\u0018\u00010\u0003J\u0006\u0010!\u001a\u00020\u001fJ\u0013\u0010\"\u001a\u00020\u00102\b\u0010#\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010$\u001a\u00020\u0006H\u0016J\u000f\u0010%\u001a\u0004\u0018\u00010\u0000*\u00020\u0003H\bJ\f\u0010&\u001a\u00020\u001f*\u00020\u0003H\u0002R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0010\u0012\f\u0012\n \u0013*\u0004\u0018\u00010\u00030\u00030\u0012X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0014\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0010\u0012\f\u0012\n \u0013*\u0004\u0018\u00010\u00030\u00030\u0012X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016¨\u0006'"}, mo175978d2 = {"Lcom/didiglobal/component/imentrance/view/MessageBubbleHelper$AnchorBubbleTag;", "", "target", "Landroid/view/View;", "bubble", "xoff", "", "yoff", "(Landroid/view/View;Landroid/view/View;II)V", "anchorLayoutObserver", "Lcom/didiglobal/component/imentrance/view/MessageBubbleHelper$AnchorLayoutObserver;", "getAnchorLayoutObserver", "()Lcom/didiglobal/component/imentrance/view/MessageBubbleHelper$AnchorLayoutObserver;", "setAnchorLayoutObserver", "(Lcom/didiglobal/component/imentrance/view/MessageBubbleHelper$AnchorLayoutObserver;)V", "attached", "", "bubbleRef", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "identification", "getIdentification", "()I", "loc", "", "getLoc", "()[I", "targetRef", "getXoff", "getYoff", "attach", "", "checkBubbleView", "clear", "equals", "other", "hashCode", "bubbleTag", "removeFromParent", "comp-imentrance_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: MessageBubbleHelper.kt */
    private static final class AnchorBubbleTag {
        private AnchorLayoutObserver anchorLayoutObserver;
        private boolean attached;
        private final WeakReference<View> bubbleRef;
        private final int identification;
        private final int[] loc = {0, 0};
        private final WeakReference<View> targetRef;
        private final int xoff;
        private final int yoff;

        public AnchorBubbleTag(View view, View view2, int i, int i2) {
            Intrinsics.checkNotNullParameter(view, "target");
            Intrinsics.checkNotNullParameter(view2, Const.BUBBLE);
            this.xoff = i;
            this.yoff = i2;
            this.identification = view.hashCode() + view2.hashCode();
            this.targetRef = new WeakReference<>(view);
            this.bubbleRef = new WeakReference<>(view2);
        }

        public final int getXoff() {
            return this.xoff;
        }

        public final int getYoff() {
            return this.yoff;
        }

        public final int getIdentification() {
            return this.identification;
        }

        public final int[] getLoc() {
            return this.loc;
        }

        public final AnchorLayoutObserver getAnchorLayoutObserver() {
            return this.anchorLayoutObserver;
        }

        public final void setAnchorLayoutObserver(AnchorLayoutObserver anchorLayoutObserver2) {
            this.anchorLayoutObserver = anchorLayoutObserver2;
        }

        public int hashCode() {
            return this.identification;
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof AnchorBubbleTag)) {
                return false;
            }
            AnchorBubbleTag anchorBubbleTag = (AnchorBubbleTag) obj;
            if (this.identification == anchorBubbleTag.identification && this.xoff == anchorBubbleTag.xoff && this.yoff == anchorBubbleTag.yoff) {
                return true;
            }
            return false;
        }

        public final void attach() {
            if (!this.attached) {
                View view = (View) this.targetRef.get();
                if (view != null) {
                    Object tag = view.getTag(R.id.global_im_entrance_message_bubble_tag);
                    AnchorBubbleTag anchorBubbleTag = tag instanceof AnchorBubbleTag ? (AnchorBubbleTag) tag : null;
                    if (anchorBubbleTag != null) {
                        Intrinsics.areEqual((Object) anchorBubbleTag, (Object) this);
                    }
                    view.setTag(R.id.global_im_entrance_message_bubble_tag, this);
                }
                this.attached = true;
            }
        }

        public final void clear() {
            View view;
            if (this.attached && (view = (View) this.targetRef.get()) != null && Intrinsics.areEqual((Object) this, view.getTag(R.id.global_im_entrance_message_bubble_tag))) {
                view.setTag(R.id.global_im_entrance_message_bubble_tag, "");
                AnchorLayoutObserver anchorLayoutObserver2 = getAnchorLayoutObserver();
                if (anchorLayoutObserver2 != null) {
                    anchorLayoutObserver2.detach();
                }
                View view2 = (View) this.bubbleRef.get();
                if (view2 != null) {
                    removeFromParent(view2);
                }
            }
        }

        public final View checkBubbleView() {
            return (View) this.bubbleRef.get();
        }

        private final void removeFromParent(View view) {
            ViewParent parent = view.getParent();
            if (parent != null) {
                ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
                if (viewGroup != null) {
                    viewGroup.removeView(view);
                }
            }
        }

        private final AnchorBubbleTag bubbleTag(View view) {
            Object tag = view.getTag(R.id.global_im_entrance_message_bubble_tag);
            if (tag instanceof AnchorBubbleTag) {
                return (AnchorBubbleTag) tag;
            }
            return null;
        }
    }

    /* renamed from: a */
    private final void m35945a(View view, boolean z) {
        view.setVisibility(z ? 0 : 4);
        view.setEnabled(z);
    }
}
