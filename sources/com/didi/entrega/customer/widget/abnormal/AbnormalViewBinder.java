package com.didi.entrega.customer.widget.abnormal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.app.nova.support.view.recyclerview.binder.ItemBinder;
import com.didi.app.nova.support.view.recyclerview.binder.ItemViewHolder;
import com.didi.app.nova.support.view.recyclerview.decorator.ItemDecorator;
import com.taxis99.R;

public class AbnormalViewBinder extends ItemBinder<AbnormalRvModel, ViewHolder> {
    public AbnormalViewBinder() {
    }

    public AbnormalViewBinder(ItemDecorator itemDecorator) {
        super(itemDecorator);
    }

    public ViewHolder create(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return new ViewHolder(layoutInflater.inflate(R.layout.entrega_customer_binder_abnormal_view, viewGroup, false));
    }

    public void bind(ViewHolder viewHolder, AbnormalRvModel abnormalRvModel) {
        viewHolder.mAbnormalView.show(abnormalRvModel.getAbnormalVm());
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) viewHolder.mAbnormalLayout.getLayoutParams();
        layoutParams.height = abnormalRvModel.mHeight;
        viewHolder.mAbnormalLayout.setLayoutParams(layoutParams);
    }

    public Class<AbnormalRvModel> bindDataType() {
        return AbnormalRvModel.class;
    }

    class ViewHolder extends ItemViewHolder<AbnormalRvModel> {
        RelativeLayout mAbnormalLayout = ((RelativeLayout) findViewById(R.id.entrega_customer_abnormal_layout));
        AbnormalView mAbnormalView = ((AbnormalView) findViewById(R.id.entrega_customer_abnormal_view));

        ViewHolder(View view) {
            super(view);
        }
    }
}
