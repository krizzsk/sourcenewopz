package com.didi.entrega.home.component.feed.binder.banner;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.didi.app.nova.skeleton.image.FitType;
import com.didi.app.nova.skeleton.image.ImageRequestListener;
import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.customer.foundation.util.CustomerSystemUtil;
import com.didi.entrega.customer.foundation.util.FlyImageLoader;
import com.taxis99.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class RvBannerAdapter extends RecyclerView.Adapter<ItemViewHolder> {

    /* renamed from: d */
    private static final String f20679d = "RvBannerAdapter";

    /* renamed from: a */
    int f20680a;

    /* renamed from: b */
    FitType f20681b = FitType.FIT_None;

    /* renamed from: c */
    boolean f20682c = false;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final OnBannerImageDownLoadListener f20683e;

    /* renamed from: f */
    private final WeakReference<RvBanner> f20684f;

    /* renamed from: g */
    private List<String> f20685g;

    /* renamed from: h */
    private Context f20686h;

    /* renamed from: i */
    private int f20687i;

    /* renamed from: j */
    private float f20688j;

    RvBannerAdapter(RvBanner rvBanner, Context context, float f, List<String> list, OnBannerImageDownLoadListener onBannerImageDownLoadListener) {
        ArrayList arrayList = new ArrayList();
        this.f20685g = arrayList;
        this.f20686h = context;
        arrayList.clear();
        this.f20685g.addAll(list);
        this.f20684f = new WeakReference<>(rvBanner);
        this.f20687i = CustomerSystemUtil.getScreenWidth(this.f20686h) - this.f20686h.getResources().getDimensionPixelOffset(R.dimen.rf_dimen_64);
        this.f20688j = f;
        this.f20683e = onBannerImageDownLoadListener;
    }

    public int getItemCount() {
        if (this.f20682c) {
            return Integer.MAX_VALUE;
        }
        return this.f20685g.size();
    }

    public void onBindViewHolder(ItemViewHolder itemViewHolder, final int i) {
        if (this.f20682c) {
            i %= this.f20685g.size();
        }
        String str = this.f20685g.get(i);
        ViewGroup.LayoutParams layoutParams = itemViewHolder.mBannerImage.getLayoutParams();
        layoutParams.width = this.f20687i;
        layoutParams.height = getHeight();
        itemViewHolder.mBannerImage.setLayoutParams(layoutParams);
        if (itemViewHolder.mBannerImage.getTag() == null || !TextUtils.equals(itemViewHolder.mBannerImage.getTag().toString(), str)) {
            final long currentTimeMillis = System.currentTimeMillis();
            FlyImageLoader.loadImageUnspecified(this.f20686h, str).diskCacheStrategy(DiskCacheStrategy.DATA).placeholder((int) R.drawable.entrega_skin_img_placeholder_x2110).centerCrop().listener(new ImageRequestListener() {
                public boolean onException(Exception exc, boolean z) {
                    if (exc != null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(exc.getMessage());
                        sb.append(",getCause = ");
                        sb.append(exc.getCause() != null ? exc.getCause().getMessage() : "null");
                        String sb2 = sb.toString();
                        LogUtil.m14765i(RvBannerAdapter.f20679d, "down load image fail = " + sb2);
                    }
                    LogUtil.m14765i(RvBannerAdapter.f20679d, "time = " + (System.currentTimeMillis() - currentTimeMillis));
                    if (RvBannerAdapter.this.f20683e == null) {
                        return false;
                    }
                    RvBannerAdapter.this.f20683e.onFail(i);
                    return false;
                }

                public boolean onResourceReady(Object obj, boolean z, boolean z2) {
                    LogUtil.m14765i(RvBannerAdapter.f20679d, "time = " + (System.currentTimeMillis() - currentTimeMillis) + ",isFromMemoryCache = " + z + ",isFirstResource = " + z2);
                    if (RvBannerAdapter.this.f20683e == null) {
                        return false;
                    }
                    RvBannerAdapter.this.f20683e.onSuccess(i, System.currentTimeMillis() - currentTimeMillis);
                    return false;
                }
            }).into(itemViewHolder.mBannerImage);
            itemViewHolder.mBannerImage.setTag(str);
        }
        itemViewHolder.mBannerImageMark.setOnClickListener(new View.OnClickListener(i) {
            public final /* synthetic */ int f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                RvBannerAdapter.this.m15138a(this.f$1, view);
            }
        });
        LogUtil.m14765i(f20679d, "onBindViewHolder banner item width =" + this.f20687i + ",height = " + getHeight());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m15138a(int i, View view) {
        if (((RvBanner) this.f20684f.get()).mOnBannerClickListener != null) {
            ((RvBanner) this.f20684f.get()).mOnBannerClickListener.onBannerClick(i);
        }
    }

    public ItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.entrega_layout_banner_item, viewGroup, false);
        ViewGroup.LayoutParams layoutParams = inflate.getLayoutParams();
        layoutParams.width = this.f20687i;
        layoutParams.height = getHeight();
        inflate.setLayoutParams(layoutParams);
        if (layoutParams != null) {
            LogUtil.m14765i(f20679d, "onCreateViewHolder banner item width =" + layoutParams.width + ",height = " + layoutParams.height);
        }
        return new ItemViewHolder(inflate);
    }

    public int getHeight() {
        return (int) (((float) this.f20687i) * this.f20688j);
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
