package com.didi.component.mapflow.infowindow.widget;

import android.content.Context;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.component.mapflow.infowindow.model.NewWaitArrivalWithTipsModel;
import com.taxis99.R;

public class NewWaitArrivalInfoWindow extends LinearLayout {

    /* renamed from: a */
    private TextView f14306a;

    /* renamed from: b */
    private TextView f14307b;

    /* renamed from: c */
    private TextView f14308c;

    /* renamed from: d */
    private TextView f14309d;

    /* renamed from: e */
    private TextView f14310e;

    public NewWaitArrivalInfoWindow(Context context) {
        super(context);
        m9954a();
    }

    /* renamed from: a */
    private void m9954a() {
        inflate(getContext(), R.layout.global_map_new_wait_arrival_info_window, this);
        this.f14306a = (TextView) findViewById(R.id.message);
        this.f14307b = (TextView) findViewById(R.id.eta);
        this.f14308c = (TextView) findViewById(R.id.eda);
        this.f14309d = (TextView) findViewById(R.id.eda_count);
        this.f14310e = (TextView) findViewById(R.id.address);
    }

    public void setEta(String str) {
        this.f14307b.setText(str);
    }

    public void setEda(String str) {
        if ("0".equals(str)) {
            str = "0.1";
        }
        this.f14308c.setText(str);
    }

    public void setEdaCount(String str) {
        this.f14309d.setText(str);
    }

    public void setAddress(String str) {
        this.f14310e.setText(str);
    }

    public void setData(NewWaitArrivalWithTipsModel newWaitArrivalWithTipsModel) {
        if (newWaitArrivalWithTipsModel != null) {
            if (newWaitArrivalWithTipsModel.isShowEdit()) {
                this.f14306a.setVisibility(0);
            } else {
                this.f14306a.setVisibility(8);
            }
            if (!TextUtils.isEmpty(newWaitArrivalWithTipsModel.getEta())) {
                setEta(newWaitArrivalWithTipsModel.getEta());
            }
            if (!TextUtils.isEmpty(newWaitArrivalWithTipsModel.getEda())) {
                setEda(newWaitArrivalWithTipsModel.getEda());
            }
            if (!TextUtils.isEmpty(newWaitArrivalWithTipsModel.getEdaCount())) {
                setEdaCount(newWaitArrivalWithTipsModel.getEdaCount());
            }
            if (!TextUtils.isEmpty(newWaitArrivalWithTipsModel.getAddress())) {
                setAddress(newWaitArrivalWithTipsModel.getAddress());
            }
        }
    }
}
