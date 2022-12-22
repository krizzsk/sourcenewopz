package com.didi.unifylogin.utils.customview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.util.ToastHelper;
import com.didi.unifylogin.base.model.LoginModel;
import com.didi.unifylogin.base.net.LoginRpcCallbackV2;
import com.didi.unifylogin.base.net.pojo.request.GetCaptchaParam;
import com.didi.unifylogin.base.net.pojo.response.GetCaptchaResponse;
import com.didichuxing.foundation.rpc.RpcRequest;
import com.didichuxing.foundation.rpc.RpcResponseProxy;
import com.taxis99.R;
import java.io.IOException;

public class CaptchaImageView extends LinearLayout implements View.OnClickListener {

    /* renamed from: a */
    RelativeLayout f44951a;

    /* renamed from: b */
    ImageView f44952b;

    /* renamed from: c */
    LinearLayout f44953c;

    /* renamed from: d */
    boolean f44954d = true;

    /* renamed from: e */
    Bitmap f44955e;

    /* renamed from: f */
    private String f44956f;

    /* renamed from: g */
    private int f44957g = -1;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public OnRefreshListener f44958h = null;

    public interface OnRefreshListener {
        void onRefresh();
    }

    public void setScene(int i) {
        this.f44957g = i;
    }

    public CaptchaImageView(Context context) {
        super(context);
        m32230a(context);
    }

    public CaptchaImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m32230a(context);
    }

    public CaptchaImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m32230a(context);
    }

    /* renamed from: a */
    private void m32230a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.login_unify_layout_v_captcha_imageview, this);
        RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.rl_captcha);
        this.f44951a = relativeLayout;
        relativeLayout.setOnClickListener(this);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.image_captcha);
        this.f44952b = imageView;
        imageView.setOnClickListener(this);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.ll_refresh);
        this.f44953c = linearLayout;
        linearLayout.setOnClickListener(this);
    }

    public void setRefreshListener(OnRefreshListener onRefreshListener) {
        this.f44958h = onRefreshListener;
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        int id = view.getId();
        if (id == R.id.ll_refresh) {
            getCaptcha(view.getContext());
        } else if (id == R.id.image_captcha) {
            getCaptcha(view.getContext());
        }
    }

    public void getCaptcha(Context context) {
        if (this.f44954d) {
            LoginModel.getNet(context).getCaptcha(new GetCaptchaParam(context, this.f44957g).setCell(this.f44956f), new LoginRpcCallbackV2<GetCaptchaResponse>() {
                public void onSuccess(RpcResponseProxy<GetCaptchaResponse> rpcResponseProxy) {
                    super.onSuccess(rpcResponseProxy);
                    GetCaptchaResponse content = rpcResponseProxy.getContent();
                    CaptchaImageView.this.f44954d = true;
                    if (content == null || TextUtils.isEmpty(content.captcha)) {
                        if (CaptchaImageView.this.f44955e == null || content.errno != 0) {
                            CaptchaImageView captchaImageView = CaptchaImageView.this;
                            captchaImageView.f44955e = BitmapFactory.decodeResource(captchaImageView.getResources(), R.drawable.login_unify_img_captcha_default);
                        }
                        CaptchaImageView.this.f44952b.setImageBitmap(CaptchaImageView.this.f44955e);
                        if (content == null || TextUtil.isEmpty(content.error)) {
                            ToastHelper.showShortError(CaptchaImageView.this.getContext(), (int) R.string.login_unify_str_captcha_failed);
                        } else {
                            ToastHelper.showShortError(CaptchaImageView.this.getContext(), content.error);
                        }
                    } else {
                        CaptchaImageView captchaImageView2 = CaptchaImageView.this;
                        captchaImageView2.f44955e = captchaImageView2.stringtoBitmap(content.captcha);
                        CaptchaImageView.this.f44952b.setImageBitmap(CaptchaImageView.this.f44955e);
                        if (CaptchaImageView.this.f44958h != null) {
                            CaptchaImageView.this.f44958h.onRefresh();
                        }
                    }
                }

                public void onFailure(RpcRequest rpcRequest, IOException iOException) {
                    super.onFailure(rpcRequest, iOException);
                    CaptchaImageView.this.f44954d = true;
                    CaptchaImageView captchaImageView = CaptchaImageView.this;
                    captchaImageView.f44955e = BitmapFactory.decodeResource(captchaImageView.getResources(), R.drawable.login_unify_img_captcha_default);
                    CaptchaImageView.this.f44952b.setImageBitmap(CaptchaImageView.this.f44955e);
                    ToastHelper.showShortError(CaptchaImageView.this.getContext(), (int) R.string.login_unify_net_error);
                }
            });
        }
    }

    public void recycleBitmap() {
        if (this.f44955e != null) {
            this.f44952b.setImageBitmap((Bitmap) null);
            this.f44955e.recycle();
        }
    }

    public void setRefreshVisible() {
        this.f44953c.setVisibility(0);
    }

    public void setPhone(String str) {
        this.f44956f = str;
    }

    public Bitmap stringtoBitmap(String str) {
        try {
            byte[] decode = Base64.decode(str, 0);
            return BitmapFactory.decodeByteArray(decode, 0, decode.length);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
