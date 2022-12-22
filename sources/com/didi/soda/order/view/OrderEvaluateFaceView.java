package com.didi.soda.order.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.rfusion.widget.RFIconView;
import com.didi.soda.customer.foundation.rpc.entity.order.OrderEvaluationScoreInfoEntity;
import com.didi.soda.customer.foundation.util.CollectionsUtil;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.taxis99.R;
import java.util.List;

public class OrderEvaluateFaceView extends FrameLayout {
    public static final int BAD_TAG = 0;
    public static final int GOOD_TAG = 1;

    /* renamed from: a */
    private TextView f43593a;

    /* renamed from: b */
    private TextView f43594b;

    /* renamed from: c */
    private RFIconView f43595c;

    /* renamed from: d */
    private RFIconView f43596d;

    /* renamed from: e */
    private int f43597e;

    /* renamed from: f */
    private List<OrderEvaluationScoreInfoEntity> f43598f;

    /* renamed from: g */
    private OnFaceClickListener f43599g;

    public interface OnFaceClickListener {
        boolean onFaceClick(int i);
    }

    public OrderEvaluateFaceView(Context context) {
        super(context);
        m30897a();
    }

    public OrderEvaluateFaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m30897a();
    }

    public OrderEvaluateFaceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m30897a();
    }

    public void setScoreInfo(int i, List<OrderEvaluationScoreInfoEntity> list) {
        this.f43598f = list;
        if (!CollectionsUtil.isEmpty(list)) {
            for (int i2 = 0; i2 < this.f43598f.size(); i2++) {
                if (i2 == 0 && !TextUtils.isEmpty(this.f43598f.get(0).desc)) {
                    this.f43593a.setText(this.f43598f.get(0).desc);
                }
                if (i2 == 1 && !TextUtils.isEmpty(this.f43598f.get(1).desc)) {
                    this.f43594b.setText(this.f43598f.get(1).desc);
                }
            }
            if (i == 2) {
                this.f43595c.setTextColor(ResourceHelper.getColor(R.color.rf_color_v2_grey1_3_a60));
                this.f43595c.setText(ResourceHelper.getString(R.string.rf_icon_v3_filled_poor));
                this.f43596d.setTextColor(ResourceHelper.getColor(R.color.rf_color_v2_grey1_9_a4));
                this.f43596d.setText(ResourceHelper.getString(R.string.rf_icon_v3_outlined_praise));
                ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f43593a, IToolsService.FontType.MEDIUM);
                ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f43594b, IToolsService.FontType.LIGHT);
                this.f43597e = i;
            } else if (i == 10) {
                this.f43596d.setTextColor(ResourceHelper.getColor(R.color.rf_color_v2_brand1_1_a100));
                this.f43596d.setText(ResourceHelper.getString(R.string.rf_icon_v3_filled_praise));
                this.f43595c.setTextColor(ResourceHelper.getColor(R.color.rf_color_v2_grey1_9_a4));
                this.f43595c.setText(ResourceHelper.getString(R.string.rf_icon_v3_outlined_poor));
                ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f43594b, IToolsService.FontType.MEDIUM);
                ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f43593a, IToolsService.FontType.LIGHT);
                this.f43597e = i;
            }
        }
    }

    public int getScore() {
        return this.f43597e;
    }

    public void setOnFaceClickListener(OnFaceClickListener onFaceClickListener) {
        this.f43599g = onFaceClickListener;
    }

    /* renamed from: a */
    private void m30897a() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.customer_widget_evaluate_face, this, true);
        this.f43596d = (RFIconView) inflate.findViewById(R.id.customer_iv_good_bg);
        this.f43595c = (RFIconView) inflate.findViewById(R.id.customer_iv_bad_bg);
        this.f43593a = (TextView) inflate.findViewById(R.id.customer_bad_tip);
        this.f43594b = (TextView) inflate.findViewById(R.id.customer_good_tip);
        ((LinearLayout) inflate.findViewById(R.id.customer_ll_bad_container)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                OrderEvaluateFaceView.this.m30899b(view);
            }
        });
        ((LinearLayout) inflate.findViewById(R.id.customer_ll_good_container)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                OrderEvaluateFaceView.this.m30898a(view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m30899b(View view) {
        OnFaceClickListener onFaceClickListener = this.f43599g;
        if (onFaceClickListener == null || !onFaceClickListener.onFaceClick(0)) {
            this.f43595c.setTextColor(ResourceHelper.getColor(R.color.rf_color_v2_grey1_3_a60));
            this.f43595c.setText(ResourceHelper.getString(R.string.rf_icon_v3_filled_poor));
            this.f43596d.setTextColor(ResourceHelper.getColor(R.color.rf_color_v2_grey1_9_a4));
            this.f43596d.setText(ResourceHelper.getString(R.string.rf_icon_v3_outlined_praise));
            ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f43593a, IToolsService.FontType.MEDIUM);
            ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f43594b, IToolsService.FontType.LIGHT);
            List<OrderEvaluationScoreInfoEntity> list = this.f43598f;
            if (list != null && list.size() > 0) {
                this.f43597e = this.f43598f.get(0).score;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m30898a(View view) {
        OnFaceClickListener onFaceClickListener = this.f43599g;
        if (onFaceClickListener == null || !onFaceClickListener.onFaceClick(1)) {
            this.f43596d.setTextColor(ResourceHelper.getColor(R.color.rf_color_v2_brand1_1_a100));
            this.f43596d.setText(ResourceHelper.getString(R.string.rf_icon_v3_filled_praise));
            this.f43595c.setTextColor(ResourceHelper.getColor(R.color.rf_color_v2_grey1_9_a4));
            this.f43595c.setText(ResourceHelper.getString(R.string.rf_icon_v3_outlined_poor));
            ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f43594b, IToolsService.FontType.MEDIUM);
            ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f43593a, IToolsService.FontType.LIGHT);
            List<OrderEvaluationScoreInfoEntity> list = this.f43598f;
            if (list != null && list.size() > 1) {
                this.f43597e = this.f43598f.get(1).score;
            }
        }
    }
}
