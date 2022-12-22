package com.didi.soda.home.binder;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.didi.app.nova.support.view.recyclerview.binder.ItemViewHolder;
import com.didi.soda.customer.base.binder.logic.BinderLogic;
import com.didi.soda.customer.base.binder.logic.CustomerLogicItemBinder;
import com.didi.soda.customer.base.binder.logic.EmptyLogicRepo;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.util.FlyImageLoader;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.widget.text.RichTextView;
import com.didi.soda.home.binder.model.CategoryNotifyTipsModel;
import com.taxis99.R;

public class CategoryNotifyTipsBinder extends CustomerLogicItemBinder<CategoryItemTipsBinderLogic, CategoryNotifyTipsModel, ViewHolder> {

    /* renamed from: a */
    private static final String f42536a = "CategoryNotifyTipsBinder";

    public ViewHolder create(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return new ViewHolder(layoutInflater.inflate(R.layout.customer_binder_category_notify, viewGroup, false));
    }

    public void bind(ViewHolder viewHolder, CategoryNotifyTipsModel categoryNotifyTipsModel) {
        if (categoryNotifyTipsModel != null) {
            viewHolder.mTvNotifyContent.setText(categoryNotifyTipsModel.getContent());
            if (!TextUtils.isEmpty(categoryNotifyTipsModel.getImgUrl())) {
                viewHolder.mIvNotifyImg.setVisibility(0);
                FlyImageLoader.loadImage1x1(viewHolder.mIvNotifyImg.getContext(), categoryNotifyTipsModel.getImgUrl()).error((int) R.drawable.customer_icon_category_notify).dontAnimate().into(viewHolder.mIvNotifyImg);
            } else {
                viewHolder.mIvNotifyImg.setVisibility(8);
            }
            int color = ResourceHelper.getColor(R.color.rf_color_v2_brand1_6_a10);
            if (!TextUtils.isEmpty(categoryNotifyTipsModel.getBackColor())) {
                try {
                    color = Color.parseColor(categoryNotifyTipsModel.getBackColor());
                } catch (Exception e) {
                    LogUtil.m29100d(f42536a, e.getLocalizedMessage());
                }
            }
            viewHolder.itemView.setBackgroundColor(color);
        }
    }

    public Class<CategoryNotifyTipsModel> bindDataType() {
        return CategoryNotifyTipsModel.class;
    }

    public CategoryItemTipsBinderLogic onCreateBinderLogic() {
        return new CategoryItemTipsBinderLogic();
    }

    public static class ViewHolder extends ItemViewHolder<CategoryNotifyTipsModel> {
        /* access modifiers changed from: private */
        public ImageView mIvNotifyImg;
        /* access modifiers changed from: private */
        public RichTextView mTvNotifyContent;

        ViewHolder(View view) {
            super(view);
            this.mIvNotifyImg = (ImageView) view.findViewById(R.id.customer_iv_notify_img);
            this.mTvNotifyContent = (RichTextView) view.findViewById(R.id.customer_tv_category_notify_content);
        }
    }

    public static class CategoryItemTipsBinderLogic extends BinderLogic<EmptyLogicRepo> {
        public Class<EmptyLogicRepo> bindLogicRepoType() {
            return EmptyLogicRepo.class;
        }
    }
}
