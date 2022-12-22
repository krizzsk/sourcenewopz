package com.didi.component.common.adapter;

import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\t\u001a\u00020\nJ\u001f\u0010\r\u001a\u0004\u0018\u0001H\u000e\"\b\b\u0000\u0010\u000e*\u00020\u00032\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\t\u001a\u00020\nR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, mo175978d2 = {"Lcom/didi/component/common/adapter/CommonRvVH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "mViews", "Landroid/util/SparseArray;", "getButton", "Landroid/widget/Button;", "id", "", "getImageView", "Landroid/widget/ImageView;", "getTargetView", "T", "(I)Landroid/view/View;", "getTextView", "Landroid/widget/TextView;", "common_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CommonRvVH.kt */
public final class CommonRvVH extends RecyclerView.ViewHolder {

    /* renamed from: a */
    private final SparseArray<View> f11468a = new SparseArray<>();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CommonRvVH(View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "itemView");
    }

    public final <T extends View> T getTargetView(int i) {
        T t = (View) this.f11468a.get(i);
        if (t == null) {
            t = this.itemView.findViewById(i);
            this.f11468a.put(i, t);
        }
        if (t == null) {
            return null;
        }
        return t;
    }

    public final TextView getTextView(int i) {
        return (TextView) getTargetView(i);
    }

    public final ImageView getImageView(int i) {
        return (ImageView) getTargetView(i);
    }

    public final Button getButton(int i) {
        return (Button) getTargetView(i);
    }
}
