package com.didi.sdk.debug.language;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.taxis99.R;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\bH\u0016J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0016J\u0016\u0010\u0011\u001a\u00020\n2\u000e\b\u0001\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, mo175978d2 = {"Lcom/didi/sdk/debug/language/LanguageDebugAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/didi/sdk/debug/language/LanguageDebugItemViewHolder;", "()V", "model", "Ljava/util/ArrayList;", "Lcom/didi/sdk/debug/language/LanguageModel;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateList", "data", "TheOneSDKGlobal_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: LanguageDebugAdapter.kt */
public final class LanguageDebugAdapter extends RecyclerView.Adapter<LanguageDebugItemViewHolder> {

    /* renamed from: a */
    private ArrayList<LanguageModel> f35795a = new ArrayList<>();

    public LanguageDebugItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.viewholder_language_debug_item, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        return new LanguageDebugItemViewHolder(inflate);
    }

    public void onBindViewHolder(LanguageDebugItemViewHolder languageDebugItemViewHolder, int i) {
        Intrinsics.checkNotNullParameter(languageDebugItemViewHolder, "holder");
        LanguageModel languageModel = this.f35795a.get(i);
        Intrinsics.checkNotNullExpressionValue(languageModel, "model[position]");
        languageDebugItemViewHolder.bindData(languageModel);
    }

    public int getItemCount() {
        return this.f35795a.size();
    }

    public final void updateList(ArrayList<LanguageModel> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "data");
        this.f35795a.addAll(arrayList);
        notifyDataSetChanged();
    }
}
