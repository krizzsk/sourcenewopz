package com.didi.beatles.p099im.views.messageCard;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.beatles.p099im.access.IMEngine;
import com.didi.beatles.p099im.access.utils.IMBusinessConfig;
import com.didi.beatles.p099im.adapter.MessageAdapter;
import com.didi.beatles.p099im.event.IMViewImageEvent;
import com.didi.beatles.p099im.module.entity.IMMessage;
import com.didi.beatles.p099im.resource.IMResource;
import com.didi.beatles.p099im.utils.IMLog;
import com.didi.beatles.p099im.utils.IMStreetUtils;
import com.didi.beatles.p099im.utils.IMViewUtil;
import com.didi.beatles.p099im.utils.imageloader.BtsImageLoader;
import com.didi.beatles.p099im.utils.imageloader.Callback;
import com.didi.beatles.p099im.views.imageView.IMRoundedImageView;
import com.taxis99.R;
import org.greenrobot.eventbus.EventBus;

/* renamed from: com.didi.beatles.im.views.messageCard.IMImageRenderView */
public class IMImageRenderView extends IMBaseRenderView {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f10318a = IMImageRenderView.class.getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public IMRoundedImageView f10319b;

    /* renamed from: c */
    private ProgressBar f10320c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public TextView f10321d;

    /* renamed from: e */
    private RelativeLayout.LayoutParams f10322e;

    /* renamed from: f */
    private int f10323f;

    /* renamed from: g */
    private View f10324g;

    /* renamed from: h */
    private TextView f10325h;

    /* access modifiers changed from: protected */
    public void onUpdateView() {
    }

    public IMImageRenderView(Context context, int i, MessageAdapter messageAdapter) {
        super(context, i, messageAdapter);
        this.f10323f = IMViewUtil.dp2px(context, 260.0f);
    }

    /* access modifiers changed from: protected */
    public View onInflatView(ViewGroup viewGroup) {
        return this.inflater.inflate(R.layout.bts_im_mine_image_message_item, viewGroup, false);
    }

    /* access modifiers changed from: protected */
    public void onFindViewById() {
        this.f10319b = (IMRoundedImageView) findViewById(R.id.img_item_view);
        this.f10320c = (ProgressBar) findViewById(R.id.img_progressBar);
        this.f10321d = (TextView) findViewById(R.id.tv_image_load_failed);
        this.f10324g = findViewById(R.id.img_expired_view);
        this.f10325h = (TextView) findViewById(R.id.illegalTextOnPicture);
    }

    /* access modifiers changed from: protected */
    public void onSetUpView(IMMessage iMMessage) {
        RelativeLayout.LayoutParams a = m7048a((float) iMMessage.getWidth(), (float) iMMessage.getHeight());
        this.f10322e = a;
        this.f10319b.setLayoutParams(a);
        this.f10321d.setText(IMResource.getString(R.string.im_tap_to_reload));
        IMViewUtil.hide((View) this.f10321d);
        if (IMStreetUtils.isExpiredPic(this.message)) {
            IMViewUtil.show(this.f10324g);
            IMBusinessConfig currentBusinessConfig = IMEngine.getInstance(getContext()).getCurrentBusinessConfig(this.message.getBusinessId());
            if (currentBusinessConfig != null && !TextUtils.isEmpty(currentBusinessConfig.getIllegalTextOnPicture())) {
                this.f10325h.setText(currentBusinessConfig.getIllegalTextOnPicture());
            }
            IMViewUtil.hide((View) this.f10319b);
            this.f10324g.getLayoutParams().width = this.f10322e.width;
            this.f10324g.getLayoutParams().height = this.f10322e.height;
            return;
        }
        IMViewUtil.show((View) this.f10319b);
        IMViewUtil.hide(this.f10324g);
        m7052b();
    }

    /* access modifiers changed from: protected */
    public void onViewClick() {
        if (!IMStreetUtils.isExpiredPic(this.message)) {
            if (this.f10321d.getVisibility() == 0) {
                m7052b();
            } else {
                EventBus.getDefault().post(new IMViewImageEvent(this.message));
            }
        }
    }

    private String getFilePath() {
        return TextUtils.isEmpty(this.message.getContent()) ? this.message.getFile_name() : this.message.getContent();
    }

    /* renamed from: b */
    private void m7052b() {
        if (this.mViewLocation == 2) {
            BtsImageLoader.getInstance().download(getFilePath(), this.f10322e.width, this.f10322e.height, new Callback() {
                public void onStart() {
                    IMViewUtil.hide((View) IMImageRenderView.this.f10321d);
                }

                public void onSuccess(Bitmap bitmap) {
                    IMImageRenderView.this.f10319b.setImageBitmap(bitmap);
                }

                public void onFailed() {
                    IMViewUtil.show((View) IMImageRenderView.this.f10321d);
                }
            });
        } else {
            BtsImageLoader.getInstance().loadInto((Object) getFilePath(), (View) this.f10319b, (Callback) new Callback() {
                public void onStart() {
                    IMViewUtil.hide((View) IMImageRenderView.this.f10321d);
                    IMImageRenderView.this.f10319b.setImageResource(R.drawable.im_picture_ic_image);
                    IMImageRenderView.this.m7053c();
                    String a = IMImageRenderView.f10318a;
                    IMLog.m6631d(a, "onStart load " + IMImageRenderView.this.message.getFile_name());
                }

                public void onSuccess(Bitmap bitmap) {
                    IMImageRenderView.this.m7055d();
                    String a = IMImageRenderView.f10318a;
                    IMLog.m6631d(a, "onSuccess load " + IMImageRenderView.this.message.getFile_name());
                }

                public void onFailed() {
                    IMImageRenderView.this.m7055d();
                    IMViewUtil.show((View) IMImageRenderView.this.f10321d);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m7053c() {
        if (this.f10320c != null && this.mViewLocation != 2) {
            this.f10320c.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m7055d() {
        ProgressBar progressBar = this.f10320c;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
    }

    /* renamed from: a */
    private RelativeLayout.LayoutParams m7048a(float f, float f2) {
        String str = f10318a;
        IMLog.m6631d(str, "before reSize width= " + f + " height= " + f2);
        int i = this.f10323f;
        if (f > ((float) i) || f2 > ((float) i)) {
            if (f >= f2) {
                int i2 = this.f10323f;
                f2 *= ((float) i2) / f;
                f = (float) i2;
            } else {
                int i3 = this.f10323f;
                f *= ((float) i3) / f2;
                f2 = (float) i3;
            }
        }
        float f3 = f2 + 0.5f;
        float f4 = f + 0.5f;
        String str2 = f10318a;
        IMLog.m6631d(str2, "after reSize width= " + f4 + " height= " + f3);
        return new RelativeLayout.LayoutParams((int) f4, (int) f3);
    }
}
