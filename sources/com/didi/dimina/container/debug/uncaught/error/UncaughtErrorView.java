package com.didi.dimina.container.debug.uncaught.error;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.dimina.container.util.ClipboardUtil;
import com.taxis99.R;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0006\u0010\u000e\u001a\u00020\u000fJ\u0012\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\rH\u0016J\u000e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000bR\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000¨\u0006\u0014"}, mo175978d2 = {"Lcom/didi/dimina/container/debug/uncaught/error/UncaughtErrorView;", "Landroid/widget/FrameLayout;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mData", "Lcom/didi/dimina/container/debug/uncaught/error/UncaughtErrorBean;", "mView", "Landroid/view/View;", "initView", "", "onClick", "v", "refreshUi", "data", "container_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: UncaughtErrorView.kt */
public final class UncaughtErrorView extends FrameLayout implements View.OnClickListener {

    /* renamed from: a */
    private View f16802a;

    /* renamed from: b */
    private UncaughtErrorBean f16803b;

    /* renamed from: c */
    private HashMap f16804c;

    public UncaughtErrorView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
    }

    public UncaughtErrorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this.f16804c;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this.f16804c == null) {
            this.f16804c = new HashMap();
        }
        View view = (View) this.f16804c.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this.f16804c.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UncaughtErrorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkParameterIsNotNull(context, "context");
        initView();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UncaughtErrorView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final void initView() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.dimina_uncaught_error_page, this, true);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "LayoutInflater.from(cont…t_error_page, this, true)");
        this.f16802a = inflate;
        View.OnClickListener onClickListener = this;
        ((TextView) _$_findCachedViewById(R.id.boardCopy)).setOnClickListener(onClickListener);
        ((TextView) _$_findCachedViewById(R.id.boardHide)).setOnClickListener(onClickListener);
    }

    public final void refreshUi(UncaughtErrorBean uncaughtErrorBean) {
        Intrinsics.checkParameterIsNotNull(uncaughtErrorBean, "data");
        TextView textView = (TextView) _$_findCachedViewById(R.id.titleTv);
        Intrinsics.checkExpressionValueIsNotNull(textView, "titleTv");
        textView.setText(uncaughtErrorBean.getInfo());
        TextView textView2 = (TextView) _$_findCachedViewById(R.id.contentTv);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "contentTv");
        textView2.setText(uncaughtErrorBean.getStack());
        this.f16803b = uncaughtErrorBean;
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.boardCopy) {
            UncaughtErrorBean uncaughtErrorBean = this.f16803b;
            if (uncaughtErrorBean == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mData");
            }
            if (uncaughtErrorBean != null) {
                ClipboardUtil.Companion companion = ClipboardUtil.Companion;
                Context context = getContext();
                Intrinsics.checkExpressionValueIsNotNull(context, "context");
                UncaughtErrorBean uncaughtErrorBean2 = this.f16803b;
                if (uncaughtErrorBean2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mData");
                }
                companion.setClipboardData(context, uncaughtErrorBean2.toString());
            }
        } else if (valueOf != null && valueOf.intValue() == R.id.boardHide) {
            UncaughtErrorPageManager.INSTANCE.dismiss();
        }
    }
}
