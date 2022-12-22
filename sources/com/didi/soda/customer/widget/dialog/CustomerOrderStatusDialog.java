package com.didi.soda.customer.widget.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.app.nova.skeleton.dialog.Dialog;
import com.didi.app.nova.skeleton.dialog.TransformAnimation;
import com.didi.soda.customer.foundation.rpc.entity.OrderStatusFlowEntity;
import com.didi.soda.customer.foundation.util.StringUtils;
import com.didi.soda.customer.widget.DashLineView;
import com.taxis99.R;
import java.util.HashMap;
import java.util.List;

public class CustomerOrderStatusDialog extends Dialog {

    /* renamed from: a */
    private final List<OrderStatusFlowEntity> f41739a;

    /* renamed from: b */
    private View f41740b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Context f41741c;

    /* renamed from: d */
    private TextView f41742d;

    /* renamed from: e */
    private RecyclerView f41743e;

    public TransformAnimation getEnterAnimation() {
        return null;
    }

    public TransformAnimation getExitAnimation() {
        return null;
    }

    public void onDestroy() {
    }

    public void onDismiss() {
    }

    public void onShow() {
    }

    public CustomerOrderStatusDialog(Context context, List<OrderStatusFlowEntity> list) {
        this.f41739a = list;
        this.f41741c = context;
    }

    public View onCreate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        this.f41740b = layoutInflater.inflate(R.layout.customer_dialog_order_status, viewGroup, false);
        setCancelable(false);
        m29487e();
        return this.f41740b;
    }

    /* renamed from: e */
    private void m29487e() {
        this.f41743e = (RecyclerView) this.f41740b.findViewById(R.id.customer_custom_rv);
        TextView textView = (TextView) this.f41740b.findViewById(R.id.customer_tv_common_dialog_sub_action1);
        this.f41742d = textView;
        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                CustomerOrderStatusDialog.this.dismiss();
            }
        });
        this.f41743e.setNestedScrollingEnabled(true);
        this.f41743e.setLayoutManager(new LinearLayoutManager(this.f41741c));
        this.f41743e.setAdapter(new TimeAdapter(this.f41739a));
        this.f41743e.scrollToPosition(this.f41739a.size() - 1);
    }

    private class TimeAdapter extends RecyclerView.Adapter {
        /* access modifiers changed from: private */
        public List<OrderStatusFlowEntity> mData;

        public TimeAdapter(List<OrderStatusFlowEntity> list) {
            this.mData = list;
        }

        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.customer_dialog_order_status_item, viewGroup, false));
        }

        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            ((ViewHolder) viewHolder).setPosition(i);
        }

        public int getItemCount() {
            return this.mData.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            private ImageView mCircle;
            private TextView mDateTime;
            private TextView mDateTitle;
            /* access modifiers changed from: private */
            public DashLineView mLine;
            private View mShadowDown;
            private View mShadowUp;
            private OrderStatusFlowEntity mTimeData;

            public ViewHolder(View view) {
                super(view);
                view.getHeight();
                this.mShadowUp = view.findViewById(R.id.customer_vw_shadow_up);
                this.mLine = (DashLineView) view.findViewById(R.id.custom_vw_line);
                this.mShadowDown = view.findViewById(R.id.customer_vw_shadow_down);
                this.mCircle = (ImageView) view.findViewById(R.id.customer_iv_circle);
                this.mDateTime = (TextView) view.findViewById(R.id.customer_tv_date_time);
                this.mDateTitle = (TextView) view.findViewById(R.id.customer_tv_date_title);
            }

            public void setPosition(int i) {
                this.mTimeData = (OrderStatusFlowEntity) TimeAdapter.this.mData.get(i);
                if (i == 0) {
                    if (TimeAdapter.this.mData.size() >= 2) {
                        this.mDateTime.setTextColor(CustomerOrderStatusDialog.this.f41741c.getResources().getColor(R.color.rf_color_gery_3_60_999999));
                        this.mDateTitle.setTextColor(CustomerOrderStatusDialog.this.f41741c.getResources().getColor(R.color.rf_color_gery_3_60_999999));
                        this.mCircle.setBackground(CustomerOrderStatusDialog.this.f41741c.getResources().getDrawable(R.drawable.customer_shape_gray_circle));
                        this.mLine.setVisibility(0);
                        this.mShadowUp.setVisibility(0);
                        this.mShadowDown.setVisibility(8);
                    } else {
                        this.mDateTime.setTextColor(CustomerOrderStatusDialog.this.f41741c.getResources().getColor(R.color.customer_color_FF4A4B5C));
                        this.mDateTitle.setTextColor(CustomerOrderStatusDialog.this.f41741c.getResources().getColor(R.color.customer_color_FF4A4B5C));
                        this.mCircle.setBackground(CustomerOrderStatusDialog.this.f41741c.getResources().getDrawable(R.drawable.customer_shape_yellow_circle));
                        this.mLine.setVisibility(8);
                    }
                } else if (i < TimeAdapter.this.mData.size() - 1) {
                    this.mDateTime.setTextColor(CustomerOrderStatusDialog.this.f41741c.getResources().getColor(R.color.rf_color_gery_3_60_999999));
                    this.mDateTitle.setTextColor(CustomerOrderStatusDialog.this.f41741c.getResources().getColor(R.color.rf_color_gery_3_60_999999));
                    this.mCircle.setBackground(CustomerOrderStatusDialog.this.f41741c.getResources().getDrawable(R.drawable.customer_shape_gray_circle));
                    this.mLine.setVisibility(0);
                    this.mShadowUp.setVisibility(8);
                    this.mShadowDown.setVisibility(8);
                } else {
                    this.mDateTime.setTextColor(CustomerOrderStatusDialog.this.f41741c.getResources().getColor(R.color.customer_color_FF4A4B5C));
                    this.mDateTitle.setTextColor(CustomerOrderStatusDialog.this.f41741c.getResources().getColor(R.color.customer_color_FF4A4B5C));
                    this.mCircle.setBackground(CustomerOrderStatusDialog.this.f41741c.getResources().getDrawable(R.drawable.customer_shape_yellow_circle));
                    this.mShadowUp.setVisibility(8);
                    this.mShadowDown.setVisibility(0);
                }
                HashMap hashMap = new HashMap();
                hashMap.put("AM", Integer.valueOf(CustomerOrderStatusDialog.this.f41741c.getResources().getDimensionPixelSize(R.dimen.customer_text_size_20px)));
                hashMap.put("PM", Integer.valueOf(CustomerOrderStatusDialog.this.f41741c.getResources().getDimensionPixelSize(R.dimen.customer_text_size_20px)));
                StringUtils.difTextSize(this.mDateTime, this.mTimeData.statusTime, CustomerOrderStatusDialog.this.f41741c.getResources().getDimensionPixelSize(R.dimen.customer_text_size_28px), hashMap);
                this.mDateTitle.setText(this.mTimeData.statusDesc);
                this.itemView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                    public boolean onPreDraw() {
                        ViewHolder.this.itemView.getViewTreeObserver().removeOnPreDrawListener(this);
                        ViewGroup.LayoutParams layoutParams = ViewHolder.this.mLine.getLayoutParams();
                        layoutParams.height = ViewHolder.this.itemView.getMeasuredHeight();
                        ViewHolder.this.mLine.setLayoutParams(layoutParams);
                        ViewHolder.this.mLine.setHeight(ViewHolder.this.itemView.getMeasuredHeight());
                        return true;
                    }
                });
            }
        }
    }
}
