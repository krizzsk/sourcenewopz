package com.didi.payment.wallet.global.wallet.view.view.home;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieListener;
import com.airbnb.lottie.LottieResult;
import com.airbnb.lottie.LottieTask;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.payment.base.tracker.PayTracker;
import com.didi.payment.base.utils.GlideUtils;
import com.didi.payment.base.utils.UIUtil;
import com.didi.payment.base.view.PayRichInfo;
import com.didi.payment.transfer.utils.TransGlobalOmegaKey;
import com.didi.payment.wallet.global.model.resp.WalletHomeResp;
import com.didi.payment.wallet.global.wallet.contract.WalletHomeContract;
import com.didi.payment.wallet.global.wallet.view.view.WalletTriangleView;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.unifiedPay.util.UIUtils;
import com.taxis99.R;
import java.util.HashMap;
import java.util.concurrent.Callable;

public class WalletHomeAccountSectionOpStyleView extends WalletHomeAbsSectionView<WalletHomeResp.AccountSection, WalletHomeContract.Listener> implements View.OnClickListener {

    /* renamed from: a */
    private View f32556a;

    /* renamed from: b */
    private ImageView f32557b;

    /* renamed from: c */
    private TextView f32558c;

    /* renamed from: d */
    private TextView f32559d;

    /* renamed from: e */
    private TextView f32560e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public TextView f32561f;

    /* renamed from: g */
    private TextView f32562g;

    /* renamed from: h */
    private TextView f32563h;

    /* renamed from: i */
    private WalletTriangleView f32564i;

    /* renamed from: j */
    private TextView f32565j;

    /* renamed from: k */
    private View f32566k;

    /* renamed from: l */
    private View f32567l;

    /* renamed from: m */
    private WalletHomeOpCardButton f32568m;

    /* renamed from: n */
    private LottieAnimationView f32569n;

    /* renamed from: o */
    private View f32570o;

    /* renamed from: p */
    private WalletHomeResp.AccountSection f32571p;

    /* renamed from: q */
    private View f32572q;

    /* renamed from: r */
    private boolean f32573r;

    public WalletHomeAccountSectionOpStyleView(Context context) {
        super(context);
    }

    public WalletHomeAccountSectionOpStyleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public WalletHomeAccountSectionOpStyleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void init(Context context) {
        this.f32572q = LayoutInflater.from(context).inflate(R.layout.wallet_global_home_account_op_section, this, true);
        this.f32556a = findViewById(R.id.wallet_home_account_op_root_view);
        this.f32563h = (TextView) findViewById(R.id.tv_account_op_total_label);
        this.f32557b = (ImageView) findViewById(R.id.iv_account_op_account_promotion_bg);
        this.f32558c = (TextView) findViewById(R.id.tv_account_op_promotion_header);
        this.f32559d = (TextView) findViewById(R.id.tv_account_op_promotion_label);
        this.f32560e = (TextView) findViewById(R.id.tv_account_op_msg);
        this.f32561f = (TextView) findViewById(R.id.tv_account_op_msg2);
        this.f32562g = (TextView) findViewById(R.id.tv_account_op_details);
        this.f32565j = (TextView) findViewById(R.id.tv_account_op_interest_msg);
        this.f32568m = (WalletHomeOpCardButton) findViewById(R.id.tv_account_op_btn);
        this.f32569n = (LottieAnimationView) findViewById(R.id.lav_top_up_lottie);
        this.f32570o = findViewById(R.id.v_account_op_btn_mask);
        WalletTriangleView walletTriangleView = (WalletTriangleView) findViewById(R.id.wt_account_op_details_arrow);
        this.f32564i = walletTriangleView;
        walletTriangleView.setColor(ResourcesHelper.getColor(this.mContext, R.color.wallet_color_43CE96));
        this.f32566k = findViewById(R.id.v_account_op_bottom_left);
        this.f32567l = findViewById(R.id.v_account_op_bottom_right);
        this.f32568m.setOnClickListener(this);
        this.f32556a.setOnClickListener(this);
        this.f32560e.setOnClickListener(this);
        this.f32569n.setOnClickListener(this);
        this.f32562g.setOnClickListener(this);
    }

    public void updateContent(WalletHomeResp.AccountSection accountSection) {
        if (accountSection == null) {
            setVisibility(8);
            return;
        }
        WalletHomeResp.AccountSection accountSection2 = this.f32571p;
        this.f32571p = accountSection;
        setVisibility(0);
        this.f32563h.setText(accountSection.title);
        if (accountSection.promotionHeader != null) {
            accountSection.promotionHeader.bindTextView(this.f32558c);
            if (!TextUtils.isEmpty(accountSection.promotionLink)) {
                this.f32558c.setOnClickListener(this);
                this.f32557b.setOnClickListener(this);
                PayRichInfo.appendImageSpan(this.f32558c, R.drawable.wallet_global_home_account_op_promotion_arrow);
            }
            HashMap hashMap = new HashMap();
            hashMap.put(TransGlobalOmegaKey.KEY_ACCOUNT_STATUS, Integer.valueOf(accountSection.status));
            PayTracker.trackEvent("ibt_gp_didipay_top_banner_promo_sw", hashMap);
        }
        this.f32559d.setText(accountSection.promotionLabel);
        if (accountSection.statusMsg != null) {
            accountSection.statusMsg.bindTextView(this.f32560e);
            accountSection.statusMsg.bindTextView(this.f32561f);
        }
        if (TextUtils.isEmpty(accountSection.detailsMsg)) {
            this.f32564i.setVisibility(8);
            this.f32562g.setVisibility(8);
        } else {
            this.f32564i.setVisibility(0);
            this.f32562g.setVisibility(0);
            TextView textView = this.f32562g;
            textView.setText(accountSection.detailsMsg + " >");
        }
        if (accountSection.interestMsg != null) {
            accountSection.interestMsg.bindTextView(this.f32565j);
        }
        if (TextUtils.isEmpty(accountSection.detailsMsg) && accountSection.interestMsg == null) {
            setContentHeight(364);
        } else if (accountSection.interestMsg == null) {
            setContentHeight(404);
        } else if (!TextUtils.isEmpty(accountSection.detailsMsg) && accountSection.interestMsg != null) {
            setContentHeight(416);
        }
        if (!TextUtils.isEmpty(accountSection.buttonText)) {
            this.f32568m.setText(accountSection.buttonText);
            this.f32568m.showTopUpStyle();
        }
        m23063a(accountSection.promotionHeaderImageUrl);
        setContentBg(accountSection.contentBgColors);
        setMsgStatusDrawable(accountSection.status);
        showButtonAnimationIfNeeded(accountSection);
        m23061a(accountSection2);
    }

    private void setContentHeight(int i) {
        int dip2px = UIUtil.dip2px(getContext(), (float) i);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f32556a.getLayoutParams();
        marginLayoutParams.height = dip2px;
        this.f32556a.setLayoutParams(marginLayoutParams);
    }

    /* renamed from: a */
    private void m23061a(WalletHomeResp.AccountSection accountSection) {
        if (accountSection != null && this.f32571p != null && accountSection.status == 1 && this.f32571p.status == 1 && accountSection.statusMsg != null) {
            this.f32561f.setVisibility(0);
            accountSection.statusMsg.bindTextView(this.f32561f);
            int measuredHeight = this.f32561f.getMeasuredHeight();
            int measuredHeight2 = this.f32560e.getMeasuredHeight();
            this.f32561f.setTranslationY(0.0f);
            this.f32560e.setTranslationY((float) measuredHeight2);
            C113721 r0 = new DynamicAnimation.OnAnimationEndListener() {
                public void onAnimationEnd(DynamicAnimation dynamicAnimation, boolean z, float f, float f2) {
                    WalletHomeAccountSectionOpStyleView.this.f32561f.setVisibility(4);
                }
            };
            final SpringAnimation springAnimation = new SpringAnimation(this.f32561f, SpringAnimation.TRANSLATION_Y, (float) (-measuredHeight));
            springAnimation.getSpring().setDampingRatio(0.75f);
            springAnimation.getSpring().setStiffness(30.0f);
            springAnimation.addEndListener(r0);
            final SpringAnimation springAnimation2 = new SpringAnimation(this.f32560e, SpringAnimation.TRANSLATION_Y, 0.0f);
            springAnimation2.getSpring().setDampingRatio(0.75f);
            springAnimation2.getSpring().setStiffness(30.0f);
            post(new Runnable() {
                public void run() {
                    springAnimation.start();
                    springAnimation2.start();
                }
            });
        }
    }

    /* renamed from: a */
    private void m23063a(String str) {
        if (!TextUtils.isEmpty(str)) {
            int screenWidth = UIUtils.getScreenWidth(this.mContext);
            ViewGroup.LayoutParams layoutParams = this.f32557b.getLayoutParams();
            GlideUtils.loadSuperBigImageSafely(this.mContext, str, Math.max(500, screenWidth), Math.max(500, layoutParams != null ? layoutParams.height : UIUtil.dip2px(this.mContext, 160.0f)), this.f32557b);
        }
    }

    private void setContentBg(String[] strArr) {
        if (strArr != null && strArr.length > 1) {
            int[] iArr = new int[strArr.length];
            int i = 0;
            while (i < strArr.length) {
                try {
                    iArr[i] = Color.parseColor(strArr[i]);
                    i++;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, iArr);
            gradientDrawable.setShape(0);
            gradientDrawable.setGradientCenter(0.5f, 0.5f);
            this.f32556a.setBackground(gradientDrawable);
        }
    }

    private void setMsgStatusDrawable(int i) {
        this.f32560e.setCompoundDrawablesWithIntrinsicBounds(0, 0, (i == 0 || i == 1 || i == 2 || i == 3) ? R.drawable.wallet_global_home_status_msg_op_arrow : 0, 0);
        this.f32560e.setCompoundDrawablePadding(UIUtil.dip2px(getContext(), 9.0f));
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (this.mListener != null) {
            if (view.getId() == R.id.tv_account_op_btn || view.getId() == R.id.lav_top_up_lottie) {
                m23065b();
                ((WalletHomeContract.Listener) this.mListener).onAccountMainEnterClicked(this.f32571p);
            } else if (view.getId() == R.id.wallet_home_account_op_root_view) {
                ((WalletHomeContract.Listener) this.mListener).onWholeCardClicked(this.f32571p);
            } else if (view.getId() == R.id.tv_account_op_msg) {
                ((WalletHomeContract.Listener) this.mListener).onStatusMsgClicked(this.f32571p);
            } else if (view.getId() == R.id.tv_account_op_promotion_header || view.getId() == R.id.iv_account_op_account_promotion_bg) {
                ((WalletHomeContract.Listener) this.mListener).onPromotionHeaderClicked(this.f32571p);
            } else if (view.getId() == R.id.tv_account_op_details) {
                ((WalletHomeContract.Listener) this.mListener).onDetailsClicked(this.f32571p);
            }
        }
    }

    public void showButtonAnimationIfNeeded(WalletHomeResp.AccountSection accountSection) {
        if (!this.f32573r && this.f32569n != null && accountSection != null && !TextUtils.isEmpty(accountSection.buttonText)) {
            this.f32568m.setVisibility(4);
            this.f32573r = true;
            new LottieTask(new Callable<LottieResult<LottieComposition>>() {
                public LottieResult<LottieComposition> call() {
                    return WalletHomeAccountSectionOpStyleView.this.m23059a();
                }
            }).addListener(new LottieListener<LottieComposition>() {
                public void onResult(LottieComposition lottieComposition) {
                    WalletHomeAccountSectionOpStyleView.this.m23060a(lottieComposition);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public LottieResult<LottieComposition> m23059a() {
        String str = "button_pr.json";
        try {
            if (getResources().getConfiguration().locale.getLanguage().equalsIgnoreCase("en")) {
                str = "button_en.json";
            }
            return LottieCompositionFactory.fromJsonInputStreamSync(this.mContext.getAssets().open(str), (String) null);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m23060a(LottieComposition lottieComposition) {
        try {
            this.f32569n.setImageAssetsFolder("wallet_button_images/");
            this.f32569n.setComposition(lottieComposition);
            this.f32569n.setRepeatCount(-1);
            this.f32569n.playAnimation();
            this.f32568m.setVisibility(4);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: b */
    private void m23065b() {
        try {
            this.f32568m.setVisibility(0);
            if (this.f32569n != null) {
                if (this.f32569n.getParent() == null) {
                    this.f32569n = null;
                    return;
                }
                ((ViewGroup) this.f32569n.getParent()).removeView(this.f32569n);
                this.f32569n = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void setBackgroudStyle(int i) {
        if (i == 1) {
            this.f32556a.setBackgroundColor(getResources().getColor(R.color.wallet_color_EEFAF1));
            this.f32566k.setBackgroundResource(R.drawable.wallet_account_card_op_bottom_bg_left4pix);
            this.f32567l.setBackgroundResource(R.drawable.wallet_account_card_op_bottom_bg_left4pix);
        }
    }
}
