package com.didi.soda.customer.binder.banner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.didi.app.nova.skeleton.image.FitType;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.util.CustomerSystemUtil;
import com.didi.soda.customer.foundation.util.FlyImageLoader;
import com.taxis99.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class RvBannerAdapter extends RecyclerView.Adapter<ItemViewHolder> {

    /* renamed from: d */
    private static final String f40397d = "RvBannerAdapter";

    /* renamed from: a */
    int f40398a;

    /* renamed from: b */
    FitType f40399b = FitType.FIT_None;

    /* renamed from: c */
    boolean f40400c = false;

    /* renamed from: e */
    private final WeakReference<RvBanner> f40401e;

    /* renamed from: f */
    private List<String> f40402f;

    /* renamed from: g */
    private Context f40403g;

    /* renamed from: h */
    private int f40404h;

    /* renamed from: i */
    private float f40405i;

    RvBannerAdapter(RvBanner rvBanner, Context context, float f, List<String> list) {
        ArrayList arrayList = new ArrayList();
        this.f40402f = arrayList;
        this.f40403g = context;
        arrayList.clear();
        this.f40402f.addAll(list);
        this.f40401e = new WeakReference<>(rvBanner);
        this.f40404h = CustomerSystemUtil.getScreenWidth(this.f40403g) - this.f40403g.getResources().getDimensionPixelOffset(R.dimen.rf_dimen_64);
        this.f40405i = f;
    }

    public int getItemCount() {
        if (this.f40400c) {
            return Integer.MAX_VALUE;
        }
        return this.f40402f.size();
    }

    public void onBindViewHolder(ItemViewHolder itemViewHolder, int i) {
        if (this.f40400c) {
            i %= this.f40402f.size();
        }
        ViewGroup.LayoutParams layoutParams = itemViewHolder.mBannerImage.getLayoutParams();
        layoutParams.width = this.f40404h;
        layoutParams.height = getHeight();
        itemViewHolder.mBannerImage.setLayoutParams(layoutParams);
        FlyImageLoader.loadImageUnspecified(this.f40403g, this.f40402f.get(i)).diskCacheStrategy(DiskCacheStrategy.DATA).placeholder((int) R.drawable.customer_skin_img_placeholder_x2110).centerCrop().into(itemViewHolder.mBannerImage);
        itemViewHolder.mBannerImageMark.setOnClickListener(new View.OnClickListener(i) {
            public final /* synthetic */ int f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                RvBannerAdapter.this.m28654a(this.f$1, view);
            }
        });
        LogUtil.m29104i(f40397d, "onBindViewHolder banner item width =" + this.f40404h + ",height = " + getHeight());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m28654a(int i, View view) {
        if (((RvBanner) this.f40401e.get()).mOnBannerClickListener != null) {
            ((RvBanner) this.f40401e.get()).mOnBannerClickListener.onBannerClick(i);
        }
    }

    public int getHeight() {
        return (int) (((float) this.f40404h) * this.f40405i);
    }

    public ItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_banner_item, viewGroup, false);
        ViewGroup.LayoutParams layoutParams = inflate.getLayoutParams();
        layoutParams.width = this.f40404h;
        layoutParams.height = getHeight();
        inflate.setLayoutParams(layoutParams);
        if (layoutParams != null) {
            LogUtil.m29104i(f40397d, "onCreateViewHolder banner item width =" + layoutParams.width + ",height = " + layoutParams.height);
        }
        return new ItemViewHolder(inflate);
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {
        ImageView mBannerImage;
        View mBannerImageMark;

        ItemViewHolder(View view) {
            super(view);
            this.mBannerImage = (ImageView) view.findViewById(R.id.iv_banner_icon);
            this.mBannerImageMark = view.findViewById(R.id.iv_banner_icon_mark);
        }
    }
}
