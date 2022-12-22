package com.didi.component.openride.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.common.util.UIUtils;
import com.didi.component.common.widget.CircleImageView;
import com.didi.travel.psnger.model.response.PinCodeInfoResult;
import com.taxis99.R;

public class OpenRideDriverInfoPopWin implements View.OnClickListener {

    /* renamed from: a */
    private Context f14743a;

    /* renamed from: b */
    private View f14744b;

    /* renamed from: c */
    private PopupWindow f14745c;

    /* renamed from: d */
    private TextView f14746d;

    /* renamed from: e */
    private ImageView f14747e;

    /* renamed from: f */
    private CircleImageView f14748f;

    /* renamed from: g */
    private TextView f14749g;

    /* renamed from: h */
    private TextView f14750h;

    /* renamed from: i */
    private TextView f14751i;

    /* renamed from: j */
    private View.OnClickListener f14752j;

    public OpenRideDriverInfoPopWin(Context context, View view) {
        this.f14743a = context;
        this.f14744b = view;
        m10544a();
    }

    /* renamed from: a */
    private void m10544a() {
        GlobalOmegaUtils.trackEvent("Pas_99GO_drivermatch_sw");
        View inflate = LayoutInflater.from(this.f14743a).inflate(R.layout.global_open_ride_driver_info_pop_layout, (ViewGroup) null);
        this.f14746d = (TextView) inflate.findViewById(R.id.g_driver_info_pop_title);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.g_driver_info_pop_close);
        this.f14747e = imageView;
        imageView.setOnClickListener(this);
        this.f14748f = (CircleImageView) inflate.findViewById(R.id.g_driver_head_img);
        this.f14749g = (TextView) inflate.findViewById(R.id.g_driver_info_name);
        this.f14750h = (TextView) inflate.findViewById(R.id.g_driver_info_num);
        TextView textView = (TextView) inflate.findViewById(R.id.g_driver_info_pop_btn);
        this.f14751i = textView;
        textView.setOnClickListener(this);
        m10545b();
        this.f14745c = new PopupWindow(inflate, -1, -2);
    }

    /* renamed from: b */
    private void m10545b() {
        PinCodeInfoResult driverInfo = FormStore.getInstance().getDriverInfo();
        if (driverInfo != null) {
            this.f14748f.setBorderColor(-1447447);
            this.f14748f.setBorderWidth(UIUtils.dip2pxInt(this.f14743a, 0.5f));
            ((RequestBuilder) ((RequestBuilder) Glide.with(this.f14743a).load(driverInfo.avatar).placeholder((int) R.drawable.global_open_ride_driver_icon)).centerCrop()).into((ImageView) this.f14748f);
            this.f14749g.setText(driverInfo.driverName);
            TextView textView = this.f14750h;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(driverInfo.licenseNum);
            stringBuffer.append(" · ");
            stringBuffer.append(driverInfo.carTitle);
            textView.setText(stringBuffer);
        }
    }

    public void show() {
        this.f14745c.showAtLocation(this.f14744b, 80, 0, 0);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f14752j = onClickListener;
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        int id = view.getId();
        if (id == R.id.g_driver_info_pop_close) {
            this.f14745c.dismiss();
            this.f14752j.onClick(view);
        } else if (id == R.id.g_driver_info_pop_btn) {
            this.f14752j.onClick(view);
        }
    }

    public boolean isShowing() {
        PopupWindow popupWindow = this.f14745c;
        if (popupWindow == null) {
            return false;
        }
        return popupWindow.isShowing();
    }

    public void dismiss() {
        PopupWindow popupWindow = this.f14745c;
        if (popupWindow != null && popupWindow.isShowing()) {
            this.f14745c.dismiss();
        }
    }
}
