package com.didi.sdk.debug.language;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, mo175978d2 = {"Lcom/didi/sdk/debug/language/LanguageDebugItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "rootView", "titleView", "Landroid/widget/TextView;", "bindData", "", "model", "Lcom/didi/sdk/debug/language/LanguageModel;", "TheOneSDKGlobal_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: LanguageDebugItemViewHolder.kt */
public final class LanguageDebugItemViewHolder extends RecyclerView.ViewHolder {

    /* renamed from: a */
    private TextView f35796a;

    /* renamed from: b */
    private View f35797b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LanguageDebugItemViewHolder(View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.f35797b = view;
        this.f35796a = (TextView) view.findViewById(R.id.text);
    }

    public final void bindData(LanguageModel languageModel) {
        Intrinsics.checkNotNullParameter(languageModel, "model");
        TextView textView = this.f35796a;
        if (textView != null) {
            textView.setText(languageModel.getTitle());
        }
        View view = this.f35797b;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    LanguageDebugItemViewHolder.m25347a(LanguageModel.this, view);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m25347a(LanguageModel languageModel, View view) {
        Intrinsics.checkNotNullParameter(languageModel, "$model");
        Function1<String, Unit> titleAction = languageModel.getTitleAction();
        if (titleAction != null) {
            Unit invoke = titleAction.invoke(languageModel.getTitle());
        }
    }
}
