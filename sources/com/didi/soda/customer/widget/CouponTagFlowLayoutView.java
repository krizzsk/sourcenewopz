package com.didi.soda.customer.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.nova.assembly.p127ui.flowlayout.NovaFlowLayout;
import com.didi.soda.customer.foundation.rpc.entity.PromptEntity;
import com.didi.soda.customer.foundation.util.CollectionsUtil;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.didi.soda.customer.widget.text.CustomerSkinTextView;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;
import rui.config.RConfigConstants;

public class CouponTagFlowLayoutView extends NovaFlowLayout {

    /* renamed from: a */
    private static final long f41448a = 51;

    /* renamed from: b */
    private static final long f41449b = 42;

    /* renamed from: c */
    private int f41450c = 0;

    public CouponTagFlowLayoutView(Context context) {
        super(context);
    }

    public CouponTagFlowLayoutView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setData(PromptEntity promptEntity, int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(promptEntity);
        setData((List<PromptEntity>) arrayList, i);
    }

    public void setData(List<PromptEntity> list, int i) {
        this.f41450c = 0;
        m29338a(list, i);
    }

    public int getLineCounts() {
        return this.f41450c;
    }

    /* renamed from: a */
    private void m29338a(List<PromptEntity> list, int i) {
        TextView textView;
        float f;
        removeAllViews();
        ArrayList arrayList = new ArrayList();
        if (!CollectionsUtil.isEmpty(list)) {
            this.f41450c = 1;
            int i2 = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                PromptEntity promptEntity = list.get(i3);
                if (!TextUtils.isEmpty(promptEntity.content)) {
                    RelativeLayout relativeLayout = new RelativeLayout(getContext());
                    relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                    if (!TextUtils.isEmpty(promptEntity.tagImg)) {
                        ImageView a = m29335a(promptEntity.tagImg);
                        if (a == null) {
                            break;
                        }
                        relativeLayout.addView(a);
                        textView = m29339b(promptEntity.content);
                        relativeLayout.addView(textView);
                        m29336a(a, textView);
                        f = textView.getPaint().measureText(promptEntity.content) + ((float) ResourceHelper.getDimensionPixelSize(R.dimen.customer_51px));
                    } else {
                        textView = m29340c(promptEntity.content);
                        relativeLayout.addView(textView);
                        f = textView.getPaint().measureText(promptEntity.content);
                    }
                    int i4 = (int) f;
                    if (i3 == 0) {
                        i2 += i4 + textView.getPaddingLeft() + textView.getPaddingRight();
                    } else {
                        i2 += getChildSpacing() + i4 + textView.getPaddingLeft() + textView.getPaddingRight();
                    }
                    if (i2 > i && list.size() > 1) {
                        this.f41450c = 2;
                    }
                    arrayList.add(relativeLayout);
                }
            }
            addView(arrayList);
        }
    }

    /* renamed from: a */
    private ImageView m29335a(String str) {
        int identifier = getResources().getIdentifier(str, RConfigConstants.TYPE_DRAWABLE, getContext().getPackageName());
        if (identifier <= 0) {
            return null;
        }
        Drawable drawable = getResources().getDrawable(identifier);
        ImageView imageView = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams.addRule(9);
        layoutParams.addRule(6, R.id.customer_home_coupon_tv_tag);
        layoutParams.addRule(8, R.id.customer_home_coupon_tv_tag);
        imageView.setLayoutParams(layoutParams);
        imageView.setId(R.id.customer_home_coupon_iv_tag);
        imageView.setBackground(drawable);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        return imageView;
    }

    /* renamed from: a */
    private void m29336a(ImageView imageView, TextView textView) {
        post(new Runnable(textView, imageView) {
            public final /* synthetic */ TextView f$0;
            public final /* synthetic */ ImageView f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final void run() {
                CouponTagFlowLayoutView.m29337a(this.f$0, this.f$1);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m29337a(TextView textView, ImageView imageView) {
        int height = textView.getHeight();
        int i = (int) ((((long) height) * f41448a) / f41449b);
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        layoutParams.height = height;
        layoutParams.width = i;
        imageView.setLayoutParams(layoutParams);
    }

    /* renamed from: b */
    private TextView m29339b(String str) {
        CustomerSkinTextView customerSkinTextView = new CustomerSkinTextView(getContext());
        customerSkinTextView.setTextSize(1, 11.0f);
        customerSkinTextView.setMaxLines(1);
        customerSkinTextView.setGravity(17);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, DisplayUtils.dip2px(getContext(), 21.0f));
        customerSkinTextView.setBackground(getResources().getDrawable(R.drawable.customer_img_shop_coupon_tv));
        customerSkinTextView.setPadding(DisplayUtils.dip2px(getContext(), 4.0f), 0, DisplayUtils.dip2px(getContext(), 8.0f), 0);
        layoutParams.addRule(1, R.id.customer_home_coupon_iv_tag);
        customerSkinTextView.setLayoutParams(layoutParams);
        customerSkinTextView.setId(R.id.customer_home_coupon_tv_tag);
        customerSkinTextView.setEllipsize(TextUtils.TruncateAt.END);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(customerSkinTextView, IToolsService.FontType.MEDIUM);
        customerSkinTextView.setText(str);
        return customerSkinTextView;
    }

    /* renamed from: c */
    private TextView m29340c(String str) {
        CustomerSkinTextView customerSkinTextView = new CustomerSkinTextView(getContext());
        customerSkinTextView.setBackgroundResource(R.drawable.customer_skin_bg_topgun_home_act);
        customerSkinTextView.setTextSize(1, 11.0f);
        customerSkinTextView.setMaxLines(1);
        customerSkinTextView.setGravity(17);
        customerSkinTextView.setLayoutParams(new ViewGroup.LayoutParams(-2, DisplayUtils.dip2px(getContext(), 21.0f)));
        int dip2px = DisplayUtils.dip2px(getContext(), 8.0f);
        customerSkinTextView.setPadding(dip2px, 0, dip2px, 0);
        customerSkinTextView.setEllipsize(TextUtils.TruncateAt.END);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(customerSkinTextView, IToolsService.FontType.MEDIUM);
        customerSkinTextView.setText(str);
        return customerSkinTextView;
    }
}
