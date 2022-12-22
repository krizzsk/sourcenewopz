package com.didi.soda.customer.binder.abnormal.topgun;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.app.nova.support.view.recyclerview.binder.ItemBinder;
import com.didi.app.nova.support.view.recyclerview.binder.ItemViewHolder;
import com.didi.app.nova.support.view.recyclerview.decorator.ItemDecorator;
import com.didi.soda.customer.widget.abnormal.topgun.TopGunAbnormalView;
import com.taxis99.R;

public class TopGunAbnormalViewBinder extends ItemBinder<TopGunAbnormalRvModel, ViewHolder> {
    public TopGunAbnormalViewBinder() {
    }

    public TopGunAbnormalViewBinder(ItemDecorator itemDecorator) {
        super(itemDecorator);
    }

    public ViewHolder create(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return new ViewHolder(layoutInflater.inflate(R.layout.customer_binder_topgun_abnormal_view, viewGroup, false));
    }

    public void bind(ViewHolder viewHolder, TopGunAbnormalRvModel topGunAbnormalRvModel) {
        viewHolder.mAbnormalView.show(topGunAbnormalRvModel.getAbnormalVm());
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) viewHolder.mAbnormalLayout.getLayoutParams();
        layoutParams.height = topGunAbnormalRvModel.mHeight;
        viewHolder.mAbnormalLayout.setLayoutParams(layoutParams);
    }

    public Class<TopGunAbnormalRvModel> bindDataType() {
        return TopGunAbnormalRvModel.class;
    }

    class ViewHolder extends ItemViewHolder<TopGunAbnormalRvModel> {
        RelativeLayout mAbnormalLayout = ((RelativeLayout) findViewById(R.id.customer_abnormal_layout));
        TopGunAbnormalView mAbnormalView = ((TopGunAbnormalView) findViewById(R.id.customer_custom_abnormal));

        ViewHolder(View view) {
            super(view);
        }
    }
}
