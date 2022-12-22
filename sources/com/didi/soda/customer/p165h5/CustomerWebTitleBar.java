package com.didi.soda.customer.p165h5;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.app.nova.skeleton.image.FitType;
import com.didi.app.nova.skeleton.image.ImageDownloadListener;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.soda.customer.foundation.rpc.entity.WebTitlebarConfigEntity;
import com.didi.soda.customer.foundation.util.CustomerSystemUtil;
import com.didi.soda.customer.foundation.util.FlyImageLoader;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.didi.soda.customer.widget.support.CustomerAppCompatTextView;
import com.didi.soda.customer.widget.text.IconTextView;
import com.taxis99.R;
import java.util.ArrayList;

/* renamed from: com.didi.soda.customer.h5.CustomerWebTitleBar */
public class CustomerWebTitleBar extends ConstraintLayout {

    /* renamed from: a */
    private IconTextView f41297a;

    /* renamed from: b */
    private TextView f41298b;

    /* renamed from: c */
    private LinearLayout f41299c;

    /* renamed from: d */
    private View f41300d;

    /* renamed from: e */
    private OnRightBtnsClickListener f41301e;

    /* renamed from: com.didi.soda.customer.h5.CustomerWebTitleBar$OnRightBtnsClickListener */
    public interface OnRightBtnsClickListener {
        void onRightRtnsClick(String str);
    }

    public CustomerWebTitleBar(Context context) {
        super(context);
        m29254a(context);
    }

    public CustomerWebTitleBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m29254a(context);
    }

    public CustomerWebTitleBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m29254a(context);
    }

    public void setTitleBarBg(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f41300d.setBackgroundColor(Color.parseColor(str));
        }
    }

    public void setTitleBarAlp(float f) {
        this.f41300d.getBackground().setAlpha((int) (f * 255.0f));
    }

    public void hiddenOrShowTitleBar(Integer num) {
        if (num == null || num.intValue() != 1) {
            this.f41300d.setVisibility(0);
        } else {
            this.f41300d.setVisibility(8);
        }
    }

    public void setBackBtnColor(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f41297a.setTextColor(Color.parseColor(str));
        }
    }

    public void setBackVisible(boolean z) {
        if (z) {
            this.f41297a.setVisibility(0);
        } else {
            this.f41297a.setVisibility(8);
        }
    }

    public void setTitleFontStyle(IToolsService.FontType fontType) {
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f41298b, fontType);
    }

    public void setTitleSize(int i) {
        this.f41298b.setTextSize(1, (float) i);
    }

    public void setTitlePosition(int i) {
        this.f41298b.setGravity(i);
    }

    public void setBackBtnAlp(float f) {
        IconTextView iconTextView = this.f41297a;
        iconTextView.setTextColor(iconTextView.getTextColors().withAlpha((int) (f * 255.0f)));
    }

    public void setBackOnClickListener(View.OnClickListener onClickListener) {
        this.f41297a.setOnClickListener(onClickListener);
    }

    public void setTitle(String str) {
        this.f41298b.setText(str);
    }

    public void setTitleColor(String str) {
        this.f41298b.setTextColor(Color.parseColor(str));
    }

    public void setTitleAlp(float f) {
        this.f41298b.setAlpha(f);
    }

    public void setRightBtnsClick(OnRightBtnsClickListener onRightBtnsClickListener) {
        this.f41301e = onRightBtnsClickListener;
    }

    public void setRightBtns(ArrayList<WebTitlebarConfigEntity.ButtonItemEntity> arrayList) {
        int i = 0;
        if (this.f41299c.getChildCount() == 0) {
            while (i < arrayList.size()) {
                m29255a(arrayList.get(i));
                i++;
            }
            return;
        }
        while (i < arrayList.size() && i < this.f41299c.getChildCount()) {
            m29253a(i, arrayList.get(i));
            i++;
        }
    }

    /* renamed from: a */
    private void m29254a(Context context) {
        inflate(context, R.layout.customer_item_web_title_bar, this);
        this.f41300d = findViewById(R.id.customer_cl_web_title_container);
        this.f41297a = (IconTextView) findViewById(R.id.customer_custom_web_title_back);
        this.f41298b = (TextView) findViewById(R.id.customer_custom_web_title_name);
        this.f41299c = (LinearLayout) findViewById(R.id.customer_iv_web_title_right_btns);
        this.f41298b.setMaxWidth(CustomerSystemUtil.getScreenWidth(getContext()) - DisplayUtils.dip2px(getContext(), 120.0f));
    }

    /* renamed from: a */
    private void m29255a(WebTitlebarConfigEntity.ButtonItemEntity buttonItemEntity) {
        if (buttonItemEntity.type == 1) {
            CustomerAppCompatTextView customerAppCompatTextView = new CustomerAppCompatTextView(getContext());
            customerAppCompatTextView.setText(buttonItemEntity.title);
            customerAppCompatTextView.setTextSize(1, 12.0f);
            customerAppCompatTextView.setFontType(IToolsService.FontType.LIGHT);
            customerAppCompatTextView.setTextColor(ResourceHelper.getColor(R.color.rf_color_gery_1_0_000000));
            customerAppCompatTextView.setAlpha(buttonItemEntity.alpha);
            customerAppCompatTextView.setGravity(16);
            customerAppCompatTextView.setOnClickListener(new View.OnClickListener(buttonItemEntity) {
                public final /* synthetic */ WebTitlebarConfigEntity.ButtonItemEntity f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    CustomerWebTitleBar.this.m29257b(this.f$1, view);
                }
            });
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, getContext().getResources().getDimensionPixelOffset(R.dimen.customer_48px));
            layoutParams.rightMargin = getContext().getResources().getDimensionPixelOffset(R.dimen.customer_5px);
            layoutParams.gravity = 16;
            this.f41299c.addView(customerAppCompatTextView, layoutParams);
            return;
        }
        ImageView imageView = new ImageView(getContext());
        imageView.setOnClickListener(new View.OnClickListener(buttonItemEntity) {
            public final /* synthetic */ WebTitlebarConfigEntity.ButtonItemEntity f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                CustomerWebTitleBar.this.m29256a(this.f$1, view);
            }
        });
        FlyImageLoader.loadImage1x1(getContext(), buttonItemEntity.currentIcon).into(imageView);
        imageView.setTag(R.id.customer_web_title_icon_tag, buttonItemEntity.currentIcon);
        if (!TextUtils.isEmpty(buttonItemEntity.preloadIcon)) {
            FlyImageLoader.loadImageDownLoadOnly(getContext(), FitType.FIT_1_1, buttonItemEntity.preloadIcon).downloadOnly((ImageDownloadListener) null);
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getContext().getResources().getDimensionPixelOffset(R.dimen.customer_48px), getContext().getResources().getDimensionPixelOffset(R.dimen.customer_48px));
        layoutParams2.rightMargin = getContext().getResources().getDimensionPixelOffset(R.dimen.customer_5px);
        this.f41299c.addView(imageView, layoutParams2);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m29257b(WebTitlebarConfigEntity.ButtonItemEntity buttonItemEntity, View view) {
        OnRightBtnsClickListener onRightBtnsClickListener = this.f41301e;
        if (onRightBtnsClickListener != null) {
            onRightBtnsClickListener.onRightRtnsClick(buttonItemEntity.action);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m29256a(WebTitlebarConfigEntity.ButtonItemEntity buttonItemEntity, View view) {
        OnRightBtnsClickListener onRightBtnsClickListener = this.f41301e;
        if (onRightBtnsClickListener != null) {
            onRightBtnsClickListener.onRightRtnsClick(buttonItemEntity.action);
        }
    }

    /* renamed from: a */
    private void m29253a(int i, WebTitlebarConfigEntity.ButtonItemEntity buttonItemEntity) {
        if (buttonItemEntity.type == 1) {
            ((TextView) this.f41299c.getChildAt(i)).setAlpha(buttonItemEntity.alpha);
            return;
        }
        ImageView imageView = (ImageView) this.f41299c.getChildAt(i);
        imageView.setAlpha(buttonItemEntity.alpha);
        if (buttonItemEntity.currentIcon != null && !buttonItemEntity.currentIcon.equals(imageView.getTag(R.id.customer_web_title_icon_tag))) {
            FlyImageLoader.loadImage1x1(getContext(), buttonItemEntity.currentIcon).into(imageView);
            imageView.setTag(R.id.customer_web_title_icon_tag, buttonItemEntity.currentIcon);
        }
    }
}
