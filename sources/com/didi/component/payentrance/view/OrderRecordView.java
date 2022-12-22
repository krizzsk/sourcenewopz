package com.didi.component.payentrance.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.didi.component.payentrance.model.OrderRecord;
import com.taxis99.R;

public class OrderRecordView extends FrameLayout {

    /* renamed from: a */
    private Context f15001a;

    /* renamed from: b */
    private TextView f15002b;

    /* renamed from: c */
    private TextView f15003c;

    /* renamed from: d */
    private TextView f15004d;

    /* renamed from: e */
    private TextView f15005e;

    /* renamed from: f */
    private TextView f15006f;

    /* renamed from: g */
    private TextView f15007g;

    /* renamed from: h */
    private TextView f15008h;

    /* renamed from: i */
    private DriverIconImageView f15009i;

    /* renamed from: j */
    private TextView f15010j;

    /* renamed from: k */
    private TextView f15011k;

    /* renamed from: l */
    private TextView f15012l;

    /* renamed from: m */
    private OrderRecord f15013m;

    public OrderRecordView(Context context) {
        super(context);
        m10771a(context);
    }

    public OrderRecordView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m10771a(context);
    }

    public OrderRecordView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m10771a(context);
    }

    /* renamed from: a */
    private void m10771a(Context context) {
        this.f15001a = context;
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        inflate(this.f15001a, R.layout.global_pe_pay_order_record_view_layout, this);
        this.f15002b = (TextView) findViewById(R.id.business_name_tv);
        this.f15003c = (TextView) findViewById(R.id.price_unit_tv);
        this.f15004d = (TextView) findViewById(R.id.price_tv);
        this.f15005e = (TextView) findViewById(R.id.date_tv);
        this.f15006f = (TextView) findViewById(R.id.time_tv);
        this.f15007g = (TextView) findViewById(R.id.start_tv);
        this.f15008h = (TextView) findViewById(R.id.end_tv);
        this.f15009i = (DriverIconImageView) findViewById(R.id.driver_bar_circle_image);
        this.f15010j = (TextView) findViewById(R.id.diver_name_tv);
        this.f15011k = (TextView) findViewById(R.id.car_info_tv);
        this.f15012l = (TextView) findViewById(R.id.plate_data_tv);
    }

    public void show(OrderRecord orderRecord) {
        this.f15013m = orderRecord;
        if (orderRecord != null) {
            this.f15002b.setText(orderRecord.getBusinessName());
            this.f15003c.setText(this.f15013m.getPriceUnit());
            this.f15004d.setText(this.f15013m.getPrice());
            this.f15005e.setText(this.f15013m.getDate());
            this.f15006f.setText(this.f15013m.getTime());
            this.f15007g.setText(this.f15013m.getStart());
            this.f15008h.setText(this.f15013m.getEnd());
            this.f15010j.setText(this.f15013m.getDriverName());
            if (this.f15013m.getDriverIcon() != null) {
                this.f15009i.setImageBitmap(this.f15013m.getDriverIcon());
            } else {
                this.f15009i.setImageResource(R.drawable.global_pe_order_record_view_driver_head);
            }
            this.f15011k.setText(this.f15013m.getCarInfo());
            this.f15012l.setText(this.f15013m.getPlate());
            return;
        }
        this.f15002b.setText((CharSequence) null);
        this.f15003c.setText((CharSequence) null);
        this.f15004d.setText((CharSequence) null);
        this.f15005e.setText((CharSequence) null);
        this.f15006f.setText((CharSequence) null);
        this.f15007g.setText((CharSequence) null);
        this.f15008h.setText((CharSequence) null);
        this.f15010j.setText((CharSequence) null);
        this.f15009i.setImageResource(R.drawable.global_pe_order_record_view_driver_head);
        this.f15011k.setText((CharSequence) null);
        this.f15012l.setText((CharSequence) null);
    }
}
