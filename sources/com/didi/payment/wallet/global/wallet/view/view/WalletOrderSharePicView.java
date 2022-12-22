package com.didi.payment.wallet.global.wallet.view.view;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.payment.base.utils.UIUtil;
import com.didi.payment.commonsdk.view.RoundedImageView;
import com.didi.payment.wallet.global.wallet.contract.WalletOrderSharePicContract;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.unifiedPay.util.UIUtils;
import com.taxis99.R;

public class WalletOrderSharePicView implements WalletOrderSharePicContract.View {

    /* renamed from: a */
    private static final int f32456a = 3145728;

    /* renamed from: b */
    private View f32457b;

    /* renamed from: c */
    private Activity f32458c;

    /* renamed from: d */
    private ImageView f32459d;

    /* renamed from: e */
    private TextView f32460e;

    /* renamed from: f */
    private TextView f32461f;

    /* renamed from: g */
    private LinearLayout f32462g;

    /* renamed from: h */
    private TextView f32463h;

    /* renamed from: i */
    private TextView f32464i;

    /* renamed from: j */
    private TextView f32465j;

    /* renamed from: k */
    private RoundedImageView f32466k;

    /* renamed from: l */
    private ImageView f32467l;

    /* renamed from: m */
    private WalletOrderSharePicContract.WalletOrderSharePicAdapter f32468m;

    public WalletOrderSharePicView(Activity activity) {
        this.f32458c = activity;
        m23028a();
    }

    /* renamed from: a */
    private void m23028a() {
        View inflate = LayoutInflater.from(this.f32458c).inflate(R.layout.wallet_order_detail_share_pic_view, (ViewGroup) null);
        this.f32457b = inflate;
        this.f32465j = (TextView) inflate.findViewById(R.id.tv_order_detail_guide);
        RoundedImageView roundedImageView = (RoundedImageView) this.f32457b.findViewById(R.id.riv_order_detail_guide_icon);
        this.f32466k = roundedImageView;
        roundedImageView.setRectAdius((float) UIUtil.dip2px(this.f32458c, 20.0f));
        this.f32466k.setCornerType(3);
        this.f32467l = (ImageView) this.f32457b.findViewById(R.id.share_order_status_img);
        this.f32460e = (TextView) this.f32457b.findViewById(R.id.share_order_title);
        this.f32461f = (TextView) this.f32457b.findViewById(R.id.share_order_subtitle);
        this.f32462g = (LinearLayout) this.f32457b.findViewById(R.id.share_order_item_content);
        this.f32463h = (TextView) this.f32457b.findViewById(R.id.share_order_symbol);
        this.f32464i = (TextView) this.f32457b.findViewById(R.id.share_order_price);
    }

    public void setAdapter(WalletOrderSharePicContract.WalletOrderSharePicAdapter walletOrderSharePicAdapter) {
        this.f32468m = walletOrderSharePicAdapter;
    }

    public Bitmap createSharePic() {
        Bitmap bitmap = null;
        if (this.f32468m == null) {
            return null;
        }
        m23029b();
        this.f32457b.measure(View.MeasureSpec.makeMeasureSpec(UIUtils.getScreenWidth(this.f32458c), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        View view = this.f32457b;
        view.layout(0, 0, view.getMeasuredWidth(), this.f32457b.getMeasuredHeight());
        try {
            if (this.f32457b.getWidth() * this.f32457b.getHeight() * 4 < 3145728) {
                bitmap = Bitmap.createBitmap(this.f32457b.getWidth(), this.f32457b.getHeight(), Bitmap.Config.ARGB_8888);
            }
        } catch (Throwable unused) {
        }
        if (bitmap == null) {
            float f = 0.8f;
            while (((float) this.f32457b.getWidth()) * f * ((float) this.f32457b.getHeight()) * f * 2.0f > 3145728.0f) {
                try {
                    f /= 2.0f;
                } catch (Throwable unused2) {
                }
            }
            bitmap = Bitmap.createBitmap((int) (((float) this.f32457b.getWidth()) * f), (int) (((float) this.f32457b.getHeight()) * f), Bitmap.Config.RGB_565);
            if (bitmap != null) {
                Canvas canvas = new Canvas(bitmap);
                Matrix matrix = new Matrix();
                matrix.postScale(f, f);
                canvas.setMatrix(matrix);
                this.f32457b.draw(canvas);
            }
        } else {
            this.f32457b.draw(new Canvas(bitmap));
        }
        return bitmap;
    }

    /* renamed from: b */
    private void m23029b() {
        WalletOrderSharePicContract.WalletOrderSharePicAdapter walletOrderSharePicAdapter = this.f32468m;
        if (walletOrderSharePicAdapter != null) {
            String title = walletOrderSharePicAdapter.getTitle();
            if (TextUtils.isEmpty(title)) {
                this.f32460e.setVisibility(8);
            } else {
                this.f32460e.setVisibility(0);
                this.f32460e.setText(title);
                int titleColorId = this.f32468m.getTitleColorId();
                if (titleColorId != 0) {
                    this.f32460e.setTextColor(ResourcesHelper.getColor(this.f32458c, titleColorId));
                }
            }
            String subTitle = this.f32468m.getSubTitle();
            if (TextUtils.isEmpty(subTitle)) {
                this.f32461f.setVisibility(8);
            } else {
                this.f32461f.setVisibility(0);
                this.f32461f.setText(subTitle);
                int subTitleColorId = this.f32468m.getSubTitleColorId();
                if (subTitleColorId != 0) {
                    this.f32461f.setTextColor(subTitleColorId);
                }
                int subTitleBgColorId = this.f32468m.getSubTitleBgColorId();
                if (subTitleBgColorId != 0) {
                    GradientDrawable gradientDrawable = new GradientDrawable();
                    gradientDrawable.setColor(subTitleBgColorId);
                    gradientDrawable.setCornerRadius((float) UIUtil.dip2px(this.f32458c, 16.0f));
                    this.f32461f.setBackground(gradientDrawable);
                }
            }
            int statusImg = this.f32468m.getStatusImg();
            if (statusImg == 0) {
                this.f32467l.setVisibility(8);
            } else {
                this.f32467l.setVisibility(0);
                this.f32467l.setImageResource(statusImg);
            }
            this.f32463h.setText(this.f32468m.getSymbol());
            this.f32464i.setText(this.f32468m.getPrice());
            this.f32465j.setText(this.f32468m.getBannerText());
            this.f32462g.removeAllViews();
            View inflate = LayoutInflater.from(this.f32458c).inflate(R.layout.wallet_boleto_detail_title_view, this.f32462g, false);
            ((TextView) inflate.findViewById(R.id.pay_result_item_content)).setText(this.f32468m.getRechargementTitle());
            this.f32462g.addView(inflate);
            int rechargementItemCount = this.f32468m.getRechargementItemCount();
            for (int i = 0; i < rechargementItemCount; i++) {
                View rechargeItemView = this.f32468m.getRechargeItemView(this.f32462g, i);
                if (rechargeItemView != null) {
                    this.f32462g.addView(rechargeItemView);
                }
            }
            this.f32462g.addView(LayoutInflater.from(this.f32458c).inflate(R.layout.wallet_boleto_history_dash_line_view, this.f32462g, false));
            View inflate2 = LayoutInflater.from(this.f32458c).inflate(R.layout.wallet_boleto_detail_title_view, this.f32462g, false);
            ((TextView) inflate2.findViewById(R.id.pay_result_item_content)).setText(this.f32468m.getPayeementTitle());
            this.f32462g.addView(inflate2);
            int payeementItemCount = this.f32468m.getPayeementItemCount();
            for (int i2 = 0; i2 < payeementItemCount; i2++) {
                View payeeItemView = this.f32468m.getPayeeItemView(this.f32462g, i2);
                if (payeeItemView != null) {
                    this.f32462g.addView(payeeItemView);
                }
            }
        }
    }
}
