package com.didi.beatles.p099im.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.beatles.p099im.api.entity.IMNewstandResponse;
import com.didi.beatles.p099im.utils.IMCommonUtil;
import com.didi.beatles.p099im.utils.imageloader.BtsImageLoader;
import com.taxis99.R;

/* renamed from: com.didi.beatles.im.adapter.GalleryAdapter */
public class GalleryAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* renamed from: a */
    private OnItemClickLitener f9043a;

    /* renamed from: b */
    private LayoutInflater f9044b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public IMNewstandResponse.ActivityInfo[] f9045c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Context f9046d;

    /* renamed from: com.didi.beatles.im.adapter.GalleryAdapter$OnItemClickLitener */
    public interface OnItemClickLitener {
        void onItemClick(View view, int i);
    }

    public void setOnItemClickLitener(OnItemClickLitener onItemClickLitener) {
        this.f9043a = onItemClickLitener;
    }

    public GalleryAdapter(Context context, IMNewstandResponse.ActivityInfo[] activityInfoArr) {
        this.f9046d = context;
        this.f9044b = LayoutInflater.from(context);
        this.f9045c = activityInfoArr;
    }

    /* renamed from: com.didi.beatles.im.adapter.GalleryAdapter$ViewHolder */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mImg;

        public ViewHolder(View view) {
            super(view);
        }
    }

    public int getItemCount() {
        return this.f9045c.length;
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = this.f9044b.inflate(R.layout.activity_index_gallery_item, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(inflate);
        viewHolder.mImg = (ImageView) inflate.findViewById(R.id.id_index_gallery_item_image);
        return viewHolder;
    }

    public void onBindViewHolder(ViewHolder viewHolder, final int i) {
        BtsImageLoader.getInstance().loadRoundInto((Object) this.f9045c[i].activity_img, (View) viewHolder.mImg, (int) R.drawable.im_activity_img_holder);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                IMCommonUtil.startUriActivity(GalleryAdapter.this.f9046d, GalleryAdapter.this.f9045c[i].activity_url);
            }
        });
    }
}
