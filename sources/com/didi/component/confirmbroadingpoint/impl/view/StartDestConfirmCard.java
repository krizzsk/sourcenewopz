package com.didi.component.confirmbroadingpoint.impl.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.global.globalgenerickit.GGKData;
import com.didi.global.globalgenerickit.GGKView;
import com.didi.global.globalgenerickit.GlobalGenericKit;
import com.didi.sdk.util.Utils;
import com.didi.travel.psnger.model.response.estimate.StartEndCardModel;
import com.taxis99.R;
import org.json.JSONException;
import org.json.JSONObject;

public class StartDestConfirmCard extends FrameLayout implements View.OnClickListener {

    /* renamed from: a */
    private Context f12684a;

    /* renamed from: b */
    private TextView f12685b;

    /* renamed from: c */
    private FrameLayout f12686c;

    /* renamed from: d */
    private StartDestConfirmView f12687d;

    /* renamed from: e */
    private TextView f12688e;

    /* renamed from: f */
    private LottieAnimationView f12689f;

    /* renamed from: g */
    private StartEndCardModel f12690g;

    /* renamed from: h */
    private View.OnClickListener f12691h;

    public StartDestConfirmCard(Context context) {
        super(context);
        m8629a();
    }

    public StartDestConfirmCard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m8629a();
    }

    public StartDestConfirmCard(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m8629a();
    }

    public void setConfirmBtnClickLis(View.OnClickListener onClickListener) {
        this.f12691h = onClickListener;
    }

    /* renamed from: a */
    private void m8629a() {
        Context context = getContext();
        this.f12684a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.g_departure_dest_card_layout, this);
        this.f12685b = (TextView) inflate.findViewById(R.id.confirm_pickup_dropoff_point_title);
        this.f12686c = (FrameLayout) inflate.findViewById(R.id.operation_container);
        this.f12687d = (StartDestConfirmView) inflate.findViewById(R.id.confirm_pickup_dropoff_point_view);
        TextView textView = (TextView) inflate.findViewById(R.id.confirm_btn);
        this.f12688e = textView;
        textView.setOnClickListener(this);
        this.f12689f = (LottieAnimationView) inflate.findViewById(R.id.animation_view);
    }

    public void bindData(StartEndCardModel startEndCardModel) {
        this.f12690g = startEndCardModel;
        if (startEndCardModel != null) {
            if (startEndCardModel.title == null || TextUtils.isEmpty(startEndCardModel.title.getContent())) {
                this.f12685b.setVisibility(8);
            } else {
                this.f12685b.setVisibility(0);
                startEndCardModel.title.bindTextView(this.f12685b);
            }
            if (startEndCardModel.xmlData != null) {
                try {
                    final GGKData parse = new GGKData().parse(new JSONObject(startEndCardModel.xmlData.toString()));
                    parse.setCDNCallback(new GGKData.CDNCallback() {
                        public void onCDNCached() {
                            StartDestConfirmCard.this.m8631a(parse);
                        }
                    });
                    m8631a(parse);
                } catch (JSONException e) {
                    e.printStackTrace();
                    this.f12686c.setVisibility(8);
                }
            } else {
                this.f12686c.setVisibility(8);
            }
            if (startEndCardModel.stationList == null || startEndCardModel.stationList.size() == 0) {
                this.f12687d.setVisibility(8);
            } else {
                this.f12687d.setVisibility(0);
                this.f12687d.setData(startEndCardModel.stationList);
            }
            this.f12688e.setText(getResources().getString(R.string.GRider_page_Order_tfYG));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8631a(GGKData gGKData) {
        GGKView createTemplateView = GlobalGenericKit.createTemplateView(this.f12684a, gGKData);
        if (createTemplateView != null && createTemplateView.getView() != null) {
            this.f12686c.setVisibility(0);
            this.f12686c.addView(createTemplateView.getView());
        }
    }

    /* renamed from: a */
    private void m8632a(boolean z, boolean z2) {
        if (z2) {
            this.f12689f.setRepeatCount(-1);
            this.f12689f.setVisibility(0);
            this.f12689f.playAnimation();
            this.f12688e.setVisibility(8);
            return;
        }
        this.f12688e.setVisibility(0);
        this.f12688e.setEnabled(z);
        this.f12689f.cancelAnimation();
        this.f12689f.setVisibility(8);
    }

    /* renamed from: b */
    private void m8633b() {
        this.f12689f.setRepeatCount(-1);
        this.f12689f.setVisibility(0);
        this.f12688e.setVisibility(8);
        this.f12689f.playAnimation();
    }

    public void hideLoading() {
        this.f12689f.setVisibility(8);
        this.f12689f.cancelAnimation();
        this.f12688e.setVisibility(0);
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (!Utils.isFastDoubleClick()) {
            this.f12691h.onClick(view);
            m8633b();
        }
    }
}
