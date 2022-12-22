package com.didi.component.common.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001(B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0016J\u001a\u0010\u001d\u001a\u00020\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001f\u001a\u00020\u0010H&J\b\u0010 \u001a\u00020\u0010H\u0016J\u0010\u0010!\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u0010H\u0016J\u0010\u0010\"\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u0010H&J\u0018\u0010#\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u0010H\u0016J\u0018\u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0010H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0012\"\u0004\b\u0019\u0010\u0014¨\u0006)"}, mo175978d2 = {"Lcom/didi/component/common/adapter/CommonRvAdapter;", "T", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/didi/component/common/adapter/CommonRvVH;", "mContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getMContext", "()Landroid/content/Context;", "mData", "", "getMData", "()Ljava/util/List;", "setMData", "(Ljava/util/List;)V", "mHeight", "", "getMHeight", "()I", "setMHeight", "(I)V", "mItemClickListener", "Lcom/didi/component/common/adapter/CommonRvAdapter$ItemClickListener;", "mWidth", "getMWidth", "setMWidth", "addItemClickListener", "", "listener", "bindData", "holder", "position", "getItemCount", "getItemViewType", "getLayoutResourceId", "onBindViewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ItemClickListener", "common_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CommonRvAdapter.kt */
public abstract class CommonRvAdapter<T> extends RecyclerView.Adapter<CommonRvVH> {
    private final Context mContext;
    private List<T> mData;
    private int mHeight = -3;
    /* access modifiers changed from: private */
    public ItemClickListener mItemClickListener;
    private int mWidth = -3;

    @Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, mo175978d2 = {"Lcom/didi/component/common/adapter/CommonRvAdapter$ItemClickListener;", "", "onItemClick", "", "holder", "Lcom/didi/component/common/adapter/CommonRvVH;", "position", "", "common_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CommonRvAdapter.kt */
    public interface ItemClickListener {
        void onItemClick(CommonRvVH commonRvVH, int i);
    }

    public abstract void bindData(CommonRvVH commonRvVH, int i);

    public abstract int getLayoutResourceId(int i);

    public CommonRvAdapter(Context context) {
        Intrinsics.checkNotNullParameter(context, "mContext");
        this.mContext = context;
    }

    public final Context getMContext() {
        return this.mContext;
    }

    public final List<T> getMData() {
        return this.mData;
    }

    public final void setMData(List<T> list) {
        this.mData = list;
    }

    public final int getMWidth() {
        return this.mWidth;
    }

    public final void setMWidth(int i) {
        this.mWidth = i;
    }

    public final int getMHeight() {
        return this.mHeight;
    }

    public final void setMHeight(int i) {
        this.mHeight = i;
    }

    public CommonRvVH onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.mContext).inflate(i, viewGroup, false);
        ViewGroup.LayoutParams layoutParams = inflate.getLayoutParams();
        int i2 = this.mWidth;
        if (i2 > 0) {
            layoutParams.width = i2;
        }
        int i3 = this.mHeight;
        if (i3 > 0) {
            layoutParams.height = i3;
        }
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        return new CommonRvVH(inflate);
    }

    public void onBindViewHolder(CommonRvVH commonRvVH, int i) {
        Intrinsics.checkNotNullParameter(commonRvVH, "holder");
        View view = commonRvVH.itemView;
        if (view != null) {
            view.setOnClickListener(new CommonRvAdapter$onBindViewHolder$1(this, commonRvVH, i));
        }
        bindData(commonRvVH, i);
    }

    public int getItemViewType(int i) {
        return getLayoutResourceId(i);
    }

    public int getItemCount() {
        List<T> list = this.mData;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public final void addItemClickListener(ItemClickListener itemClickListener) {
        Intrinsics.checkNotNullParameter(itemClickListener, "listener");
        this.mItemClickListener = itemClickListener;
    }
}
