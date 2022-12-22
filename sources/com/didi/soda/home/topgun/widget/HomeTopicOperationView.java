package com.didi.soda.home.topgun.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.didi.app.nova.skeleton.image.RoundedCornersTransformation;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.soda.customer.foundation.rpc.entity.TofuEntity;
import com.didi.soda.customer.foundation.rpc.entity.topgun.ComponentEntity;
import com.didi.soda.customer.foundation.tracker.model.ModuleModelV2;
import com.didi.soda.customer.foundation.util.BitmapUtil;
import com.didi.soda.customer.foundation.util.FlyImageLoader;
import com.didi.soda.customer.widget.support.CustomerAppCompatImageView;
import com.didi.soda.datasource.parser.FeedPayload;
import com.taxis99.R;

public class HomeTopicOperationView extends FrameLayout {

    /* renamed from: a */
    ImageView f43156a;

    /* renamed from: b */
    View f43157b;

    /* renamed from: c */
    private int f43158c;

    /* renamed from: d */
    private Drawable f43159d;

    public HomeTopicOperationView(Context context) {
        super(context);
        m30532a();
    }

    public HomeTopicOperationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m30532a();
    }

    public HomeTopicOperationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m30532a();
    }

    public void updateItemModel(TopicOperationItemModel topicOperationItemModel, View.OnClickListener onClickListener) {
        FlyImageLoader.loadImageUnspecified(getContext(), topicOperationItemModel.mTopicImageUrl).placeholder(this.f43159d).error(this.f43159d).diskCacheStrategy(FlyImageLoader.DATA).transform(new RoundedCornersTransformation(getContext(), this.f43158c, 0, RoundedCornersTransformation.CornerType.ALL, true)).into(this.f43156a);
        if (TextUtils.isEmpty(topicOperationItemModel.mClickUrl)) {
            setClickable(false);
            return;
        }
        setClickable(true);
        this.f43157b.setOnClickListener(onClickListener);
    }

    /* renamed from: a */
    private void m30532a() {
        this.f43156a = new CustomerAppCompatImageView(getContext());
        View view = new View(getContext());
        this.f43157b = view;
        view.setBackgroundResource(R.drawable.customer_selector_trans_to_4cff);
        addView(this.f43156a, new FrameLayout.LayoutParams(-1, -1));
        addView(this.f43157b, new FrameLayout.LayoutParams(-1, -1));
        this.f43158c = DisplayUtils.dip2px(getContext(), 5.0f);
        this.f43159d = BitmapUtil.getRoundedDrawable(getContext(), R.drawable.customer_skin_img_topgun_placeholder_tofu, this.f43158c);
    }

    public static class TopicOperationItemModel extends ModuleModelV2 {
        public String mActId;
        public String mClickUrl;
        public String mTopicImageUrl;

        public static TopicOperationItemModel newInstance(ComponentEntity componentEntity, TofuEntity tofuEntity, FeedPayload feedPayload, int i) {
            TopicOperationItemModel topicOperationItemModel = new TopicOperationItemModel();
            topicOperationItemModel.mTopicImageUrl = tofuEntity.img;
            topicOperationItemModel.mClickUrl = tofuEntity.url;
            topicOperationItemModel.mActId = tofuEntity.f41046id;
            if (feedPayload != null) {
                topicOperationItemModel.mRecId = feedPayload.mRecId;
                topicOperationItemModel.mPageId = feedPayload.mPageId;
                topicOperationItemModel.mPageInModule = feedPayload.mPageIndex;
                topicOperationItemModel.mRowInModule = feedPayload.mComponentIndex;
                topicOperationItemModel.mColumnInModule = i;
                topicOperationItemModel.mAbsoluteIndex = feedPayload.mComponentIndex;
                topicOperationItemModel.mPageFilter = feedPayload.mPageFilter;
            }
            topicOperationItemModel.mComponentId = componentEntity.mComponentId;
            topicOperationItemModel.mComponentType = componentEntity.mType;
            topicOperationItemModel.mIndexInModule = componentEntity.mPosition;
            return topicOperationItemModel;
        }
    }
}
