package com.didi.component.mapflow.infowindow.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.didi.theme.DidiThemeManager;
import com.didi.component.common.view.RichTextView;
import com.didi.component.mapflow.infowindow.model.BusComingModel;
import com.didi.component.mapflow.infowindow.model.DepartureModel;
import com.didi.sdk.util.ResourcesHelper;
import com.didichuxing.omega.sdk.Omega;
import com.taxis99.R;

public class DepartureInfoWindow extends LinearLayout {

    /* renamed from: a */
    private final int f14270a = 300;

    /* renamed from: b */
    private TextView f14271b;

    /* renamed from: c */
    private TextView f14272c;

    /* renamed from: d */
    private RichTextView f14273d;

    /* renamed from: e */
    private RichTextView f14274e;

    /* renamed from: f */
    private RichTextView f14275f;

    /* renamed from: g */
    private View f14276g;

    /* renamed from: h */
    private ImageView f14277h;

    /* renamed from: i */
    private View f14278i;

    /* renamed from: j */
    private View f14279j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public boolean f14280k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public IUpdateCallback f14281l;

    /* renamed from: m */
    private Bitmap[] f14282m;

    /* renamed from: n */
    private int f14283n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public int f14284o = 300;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public Handler f14285p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public Runnable f14286q = new Runnable() {
        public void run() {
            DepartureInfoWindow.this.updateLoadingImage();
            if (DepartureInfoWindow.this.f14281l != null) {
                DepartureInfoWindow.this.f14281l.update();
            }
            if (!DepartureInfoWindow.this.f14280k) {
                DepartureInfoWindow.this.f14285p.postDelayed(DepartureInfoWindow.this.f14286q, (long) DepartureInfoWindow.this.f14284o);
            }
        }
    };

    public interface IUpdateCallback {
        void update();
    }

    /* access modifiers changed from: protected */
    public int getLayoutId() {
        return R.layout.global_map_two_line_with_loading;
    }

    public DepartureInfoWindow(Context context) {
        super(context);
        m9935a(context);
    }

    /* renamed from: a */
    private void m9935a(Context context) {
        this.f14285p = new Handler(Looper.getMainLooper());
        inflate(getContext(), getLayoutId(), this);
        this.f14271b = (TextView) findViewById(R.id.left_data_item1);
        this.f14272c = (TextView) findViewById(R.id.left_data_item2);
        this.f14273d = (RichTextView) findViewById(R.id.right_tips);
        this.f14274e = (RichTextView) findViewById(R.id.right_txt);
        this.f14275f = (RichTextView) findViewById(R.id.right_etd_txt);
        this.f14277h = (ImageView) findViewById(R.id.left_loading);
        this.f14276g = findViewById(R.id.left_data);
        this.f14278i = findViewById(R.id.divider);
        this.f14279j = findViewById(R.id.arrow);
        this.f14282m = new Bitmap[]{BitmapFactory.decodeResource(getResources(), R.drawable.global_mapflow_loading_one), BitmapFactory.decodeResource(getResources(), R.drawable.global_mapflow_loading_two), BitmapFactory.decodeResource(getResources(), R.drawable.global_mapflow_loading_three)};
        try {
            int color = DidiThemeManager.getIns().getResPicker(context).getColor(R.attr.caution_color);
            this.f14271b.setTextColor(color);
            this.f14272c.setTextColor(color);
            this.f14275f.setTextColor(color);
        } catch (Resources.NotFoundException e) {
            Omega.trackError("comp-mapflow", e);
        }
    }

    public void setData(BusComingModel busComingModel) {
        showLoading(false);
        TextView textView = this.f14271b;
        textView.setText(busComingModel.getTime() + "");
        this.f14272c.setText(busComingModel.getTimeUnit());
        this.f14274e.setText(busComingModel.getPlace());
    }

    public void setData(DepartureModel departureModel) {
        showLoading(departureModel.isShowLoading());
        this.f14271b.setText(departureModel.getEtaValue());
        this.f14272c.setText(departureModel.getEtaUnit());
        this.f14274e.setText(departureModel.getMessage());
        if (TextUtils.isEmpty(departureModel.getEtd())) {
            this.f14275f.setVisibility(8);
            this.f14274e.setMaxLines(2);
        } else {
            this.f14275f.setVisibility(0);
            this.f14275f.setText(departureModel.getEtd());
            this.f14274e.setMaxLines(1);
        }
        if (this.f14273d != null) {
            if (TextUtils.isEmpty(departureModel.getMapStartPointText())) {
                this.f14273d.setVisibility(8);
            } else {
                this.f14273d.setVisibility(0);
                this.f14273d.setText(departureModel.getMapStartPointText());
            }
        }
        showArrow(departureModel.isArrow());
        showMessageOnly(departureModel.isMessageOnly());
        if (departureModel.isShowNearbyHint()) {
            this.f14271b.setMaxWidth(ResourcesHelper.getDimensionPixelSize(getContext(), R.dimen.mapflow_departure_info_nearcar_msg_max_width));
            this.f14271b.setTypeface(Typeface.defaultFromStyle(0));
            this.f14272c.setVisibility(8);
            return;
        }
        this.f14271b.setTypeface(Typeface.defaultFromStyle(1));
        this.f14272c.setVisibility(0);
    }

    public void setEtaValue(CharSequence charSequence) {
        this.f14271b.setText(charSequence);
    }

    public void setEtaUnit(CharSequence charSequence) {
        this.f14272c.setText(charSequence);
    }

    public void setRightText(CharSequence charSequence) {
        this.f14274e.setText(charSequence);
    }

    public void setUpdateCallback(IUpdateCallback iUpdateCallback) {
        this.f14281l = iUpdateCallback;
    }

    public void showLoadingState() {
        this.f14283n = 0;
        this.f14280k = false;
        this.f14285p.removeCallbacks(this.f14286q);
        this.f14285p.postDelayed(this.f14286q, (long) this.f14284o);
    }

    public void showLoadingStateOnly(boolean z) {
        showLoading(true);
        if (z) {
            this.f14278i.setVisibility(8);
            this.f14274e.setVisibility(8);
            return;
        }
        this.f14278i.setVisibility(0);
        this.f14274e.setVisibility(0);
    }

    public void setInterval(int i) {
        if (i > 0) {
            this.f14284o = i;
        }
    }

    public void hideLoadingState() {
        this.f14280k = true;
        this.f14285p.removeCallbacks(this.f14286q);
    }

    public void updateLoadingImage() {
        int i = this.f14283n + 1;
        this.f14283n = i;
        if (i < 0 || i >= this.f14282m.length) {
            this.f14283n = 0;
        }
        this.f14277h.setImageBitmap(this.f14282m[this.f14283n]);
    }

    public void showLoading(boolean z) {
        if (z) {
            this.f14277h.setVisibility(0);
            this.f14278i.setVisibility(0);
            this.f14276g.setVisibility(8);
            showLoadingState();
            return;
        }
        hideLoadingState();
        this.f14277h.setVisibility(8);
        this.f14276g.setVisibility(0);
        this.f14278i.setVisibility(0);
    }

    public void showArrow(boolean z) {
        if (z) {
            this.f14279j.setVisibility(0);
        } else {
            this.f14279j.setVisibility(8);
        }
    }

    public void showMessageOnly(boolean z) {
        if (z) {
            this.f14276g.setVisibility(8);
            this.f14278i.setVisibility(8);
            this.f14277h.setVisibility(8);
        }
    }
}
