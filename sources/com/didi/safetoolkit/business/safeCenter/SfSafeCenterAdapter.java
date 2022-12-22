package com.didi.safetoolkit.business.safeCenter;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.safetoolkit.business.safeCenter.model.SfCenterCardModel;
import com.didi.safetoolkit.imageloader.SfImageLoaderHolder;
import com.didi.safetoolkit.util.SfAppUtils;
import com.taxis99.R;
import java.util.List;

public class SfSafeCenterAdapter extends RecyclerView.Adapter {
    public static final int TYPE_ADD_TRUSTED = 2;
    public static final int TYPE_BANNER = 1;

    /* renamed from: a */
    private List<SfCenterCardModel> f34411a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public CardClickListener f34412b;

    public interface CardClickListener {
        void onClick(SfCenterCardModel sfCenterCardModel);
    }

    public void setData(List<SfCenterCardModel> list) {
        if (list != null) {
            this.f34411a = list;
            notifyDataSetChanged();
        }
    }

    public void setCardClickListener(CardClickListener cardClickListener) {
        this.f34412b = cardClickListener;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 1) {
            return new BannerViewHolder(viewGroup);
        }
        if (i != 2) {
            return new CommonViewHolder(viewGroup);
        }
        return new CommonViewHolder(viewGroup);
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        ((BaseViewHolder) viewHolder).bindData(this.f34411a.get(i));
    }

    public int getItemViewType(int i) {
        return this.f34411a.get(i).typeLocal;
    }

    public int getItemCount() {
        List<SfCenterCardModel> list = this.f34411a;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    private abstract class BaseViewHolder extends RecyclerView.ViewHolder {
        public abstract void bindData(SfCenterCardModel sfCenterCardModel);

        public BaseViewHolder(View view) {
            super(view);
        }
    }

    private class BannerViewHolder extends BaseViewHolder {
        private ImageView bannerView = ((ImageView) this.itemView.findViewById(R.id.banner_iv));
        private TextView contentView = ((TextView) this.itemView.findViewById(R.id.card_sub_title));
        private TextView titleView = ((TextView) this.itemView.findViewById(R.id.card_main_title));

        public BannerViewHolder(ViewGroup viewGroup) {
            super(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sf_item_card_banner, viewGroup, false));
        }

        public void bindData(final SfCenterCardModel sfCenterCardModel) {
            if (sfCenterCardModel != null) {
                if (!TextUtils.isEmpty(sfCenterCardModel.title)) {
                    this.titleView.setVisibility(0);
                    this.titleView.setText(sfCenterCardModel.title);
                } else {
                    this.titleView.setVisibility(8);
                }
                if (!TextUtils.isEmpty(sfCenterCardModel.content)) {
                    this.contentView.setVisibility(0);
                    this.contentView.setText(sfCenterCardModel.content);
                } else {
                    this.contentView.setVisibility(8);
                }
                if (!TextUtils.isEmpty(sfCenterCardModel.bannerUrl)) {
                    this.bannerView.setVisibility(0);
                    ImageView imageView = this.bannerView;
                    if (imageView == null || imageView.getContext() == null || !SfAppUtils.isBrazilPackage(this.bannerView.getContext())) {
                        SfImageLoaderHolder.getInstance(this.titleView.getContext()).loadInto(sfCenterCardModel.bannerUrl, this.bannerView, R.drawable.sf_center_place_holder);
                    } else {
                        SfImageLoaderHolder.getInstance(this.titleView.getContext()).loadInto(sfCenterCardModel.bannerUrl, this.bannerView, R.drawable.sf_center_place_holder_4_99);
                    }
                } else {
                    this.bannerView.setVisibility(8);
                }
                this.itemView.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        if (SfSafeCenterAdapter.this.f34412b != null) {
                            SfSafeCenterAdapter.this.f34412b.onClick(sfCenterCardModel);
                        }
                    }
                });
            }
        }
    }

    private class CommonViewHolder extends BaseViewHolder {
        private TextView btn = ((TextView) this.itemView.findViewById(R.id.card_btn_text));
        private TextView contentView = ((TextView) this.itemView.findViewById(R.id.card_sub_title));
        private TextView titleView = ((TextView) this.itemView.findViewById(R.id.card_main_title));

        public CommonViewHolder(ViewGroup viewGroup) {
            super(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sf_item_card_common, viewGroup, false));
        }

        public void bindData(final SfCenterCardModel sfCenterCardModel) {
            if (sfCenterCardModel != null) {
                this.titleView.setText(sfCenterCardModel.title);
                this.contentView.setText(sfCenterCardModel.content);
                this.btn.setText(sfCenterCardModel.btnText);
                this.itemView.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        if (SfSafeCenterAdapter.this.f34412b != null) {
                            SfSafeCenterAdapter.this.f34412b.onClick(sfCenterCardModel);
                        }
                    }
                });
            }
        }
    }
}
