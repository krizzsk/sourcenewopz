package com.didi.payment.utilities.scan;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.payment.base.tracker.PayTracker;
import com.didi.sdk.view.SimplePopupBase;
import com.didi.unifiedPay.util.UIUtils;
import com.taxis99.R;

public class CsScanGuideDialog extends SimplePopupBase {

    /* renamed from: a */
    private static final int f31668a = 6291456;

    /* renamed from: b */
    private ViewGroup f31669b;

    /* renamed from: c */
    private ImageView f31670c;

    /* renamed from: d */
    private TextView f31671d;

    /* renamed from: e */
    private TextView f31672e;

    /* renamed from: f */
    private Listener f31673f;

    /* renamed from: g */
    private Bitmap f31674g;

    /* renamed from: h */
    private Bitmap f31675h;

    /* renamed from: i */
    private boolean f31676i;

    /* renamed from: j */
    private boolean f31677j;

    /* renamed from: k */
    private int f31678k = R.string.cs_utilities_entrance_scan_guide_explain_2;

    /* renamed from: l */
    private int f31679l = R.string.cs_utilities_entrance_scan_guide_get;

    public interface Listener {
        void onScanGuideShownOver(CsScanGuideDialog csScanGuideDialog);
    }

    /* access modifiers changed from: protected */
    public int getLayout() {
        return R.layout.cs_dialog_utilities_scan_guide_layout;
    }

    public static CsScanGuideDialog show(FragmentActivity fragmentActivity, Boolean bool, Listener listener) {
        CsScanGuideDialog csScanGuideDialog = new CsScanGuideDialog();
        Bundle bundle = new Bundle();
        bundle.putBoolean("isMexico", bool.booleanValue());
        csScanGuideDialog.setArguments(bundle);
        csScanGuideDialog.f31673f = listener;
        csScanGuideDialog.show(fragmentActivity.getSupportFragmentManager(), "scan_guide_dialog");
        return csScanGuideDialog;
    }

    public void onStart() {
        super.onStart();
        try {
            Window window = getDialog().getWindow();
            window.setBackgroundDrawable(new ColorDrawable(0));
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            attributes.height = -1;
            attributes.dimAmount = 0.0f;
            attributes.flags |= 2;
            attributes.flags |= 1024;
            attributes.gravity = 80;
            window.setAttributes(attributes);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void initView() {
        this.f31669b = (ViewGroup) this.mRootView.findViewById(R.id.fl_utilities_scan_guide_image_layout);
        this.f31670c = (ImageView) this.mRootView.findViewById(R.id.iv_utilities_scan_guide_image);
        this.f31671d = (TextView) this.mRootView.findViewById(R.id.tv_utilities_scan_explain);
        this.f31672e = (TextView) this.mRootView.findViewById(R.id.tv_utilities_scan_next);
        m22471d();
        this.f31672e.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                CsScanGuideDialog.this.m22469b();
            }
        });
        m22467a();
        PayTracker.trackEvent("ibt_didipay_pay_boleto_guide_first_sw");
    }

    /* renamed from: a */
    private void m22467a() {
        this.f31674g = decodeBitmapFromResource(R.drawable.cs_utilities_scan_guide_image_1);
        this.f31675h = decodeBitmapFromResource(R.drawable.cs_utilities_scan_guide_image_2);
        this.f31670c.setImageBitmap(this.f31674g);
    }

    public Bitmap decodeBitmapFromResource(int i) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            options.inPreferredConfig = Bitmap.Config.RGB_565;
            BitmapFactory.decodeResource(getResources(), i, options);
            options.inSampleSize = calculateInSampleSize(options);
            options.inJustDecodeBounds = false;
            return BitmapFactory.decodeResource(getResources(), i, options);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public int calculateInSampleSize(BitmapFactory.Options options) {
        int i = options.outHeight;
        int i2 = options.outWidth;
        int i3 = i * i2 * 2;
        int i4 = 2;
        while (i3 > f31668a) {
            i4 *= 2;
            i3 = (i / i4) * (i2 / i4) * 2;
        }
        return i4;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m22469b() {
        if (this.f31676i) {
            PayTracker.trackEvent("ibt_didipay_pay_boleto_guide_second_ck");
            Listener listener = this.f31673f;
            if (listener != null) {
                listener.onScanGuideShownOver(this);
            }
            dismiss();
            return;
        }
        PayTracker.trackEvent("ibt_didipay_pay_boleto_guide_first_ck");
        this.f31676i = true;
        m22470c();
    }

    /* renamed from: c */
    private void m22470c() {
        PayTracker.trackEvent("ibt_didipay_pay_boleto_guide_second_sw");
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f31669b.getLayoutParams();
        layoutParams.setMargins(0, 0, 0, 0);
        layoutParams.addRule(13);
        this.f31669b.setLayoutParams(layoutParams);
        this.f31669b.setBackground((Drawable) null);
        this.f31671d.setText(this.f31678k);
        this.f31672e.setText(this.f31679l);
        this.f31674g = null;
        Bitmap bitmap = this.f31675h;
        if (bitmap == null) {
            this.f31670c.setImageBitmap(decodeBitmapFromResource(R.drawable.cs_utilities_scan_guide_image_2));
        } else {
            this.f31670c.setImageBitmap(bitmap);
        }
        this.f31670c.setScaleType(ImageView.ScaleType.FIT_XY);
        this.f31670c.setAdjustViewBounds(true);
        this.f31670c.setMaxWidth(UIUtils.getScreenWidth(getActivity()));
        this.f31670c.setMaxHeight(UIUtils.getScreenHeight(getActivity()));
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f31670c.getLayoutParams();
        layoutParams2.width = -1;
        layoutParams2.height = -2;
        layoutParams2.setMargins(0, 0, 0, 0);
        this.f31670c.setLayoutParams(layoutParams2);
    }

    /* renamed from: d */
    private void m22471d() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            boolean z = arguments.getBoolean("isMexico", false);
            this.f31677j = z;
            if (z) {
                this.f31671d.setText(R.string.Fintech_Payment_SKUs_Please_find_ArhM);
                this.f31672e.setText(R.string.Fintech_Payment_SKUs_Continue_oqFC);
                this.f31678k = R.string.Fintech_Payment_SKUs_Place_the_SmPf;
                this.f31679l = R.string.Fintech_Payment_SKUs_I_see_dOSB;
            }
        }
    }
}
