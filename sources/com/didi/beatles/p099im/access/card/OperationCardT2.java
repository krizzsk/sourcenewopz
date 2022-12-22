package com.didi.beatles.p099im.access.card;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.beatles.p099im.access.msg.OperationMsgT2;
import com.didi.beatles.p099im.adapter.MessageAdapter;
import com.didi.beatles.p099im.event.IMSkipToMainActivityEvent;
import com.didi.beatles.p099im.manager.IMManager;
import com.didi.beatles.p099im.module.entity.IMMessage;
import com.didi.beatles.p099im.omega.OmegaUtil;
import com.didi.beatles.p099im.resource.IMResource;
import com.didi.beatles.p099im.utils.IMCommonUtil;
import com.didi.beatles.p099im.utils.IMJsonUtil;
import com.didi.beatles.p099im.utils.IMLog;
import com.didi.beatles.p099im.utils.IMViewUtil;
import com.didi.beatles.p099im.utils.imageloader.BtsImageLoader;
import com.didi.beatles.p099im.utils.imageloader.Callback;
import com.didi.beatles.p099im.views.IMTipsToast;
import com.didi.beatles.p099im.views.imageView.IMRoundedImageView;
import com.didi.beatles.p099im.views.messageCard.IMBaseRenderView;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import org.greenrobot.eventbus.EventBus;

/* renamed from: com.didi.beatles.im.access.card.OperationCardT2 */
public class OperationCardT2 extends IMBaseRenderView {

    /* renamed from: a */
    private TextView f8724a;

    /* renamed from: b */
    private TextView f8725b;

    /* renamed from: c */
    private IMRoundedImageView f8726c;

    /* renamed from: d */
    private ImageView f8727d;

    /* renamed from: e */
    private ImageView f8728e;

    /* renamed from: f */
    private View f8729f;

    /* renamed from: g */
    private View f8730g;

    /* renamed from: h */
    private View f8731h;

    /* renamed from: i */
    private boolean f8732i;

    /* renamed from: j */
    private OperationMsgT2 f8733j;

    /* access modifiers changed from: protected */
    public void onUpdateView() {
    }

    public OperationCardT2(Context context, MessageAdapter messageAdapter) {
        super(context, 1, messageAdapter);
    }

    /* access modifiers changed from: protected */
    public View onInflatView(ViewGroup viewGroup) {
        return this.inflater.inflate(R.layout.onemessage_operation_card_template2, viewGroup, false);
    }

    /* access modifiers changed from: protected */
    public void onFindViewById() {
        this.f8724a = (TextView) findViewById(R.id.onemessage_title);
        this.f8725b = (TextView) findViewById(R.id.onemessage_content);
        this.f8726c = (IMRoundedImageView) findViewById(R.id.onemessage_image);
        this.f8727d = (ImageView) findViewById(R.id.onemessage_new_flag);
        this.f8728e = (ImageView) findViewById(R.id.onemessage_over_time_flag);
        this.f8729f = findViewById(R.id.onemessage_image_container);
        this.f8731h = findViewById(R.id.overtime_cover);
        this.f8730g = findViewById(R.id.im_look_more_btn);
        this.f8726c.setCornerType(1);
        this.f8727d.setImageResource(IMResource.getDrawableID(R.drawable.im_nomix_onemessage_flag_new));
        this.f8728e.setImageResource(IMResource.getDrawableID(R.drawable.im_overtime_icon));
    }

    /* access modifiers changed from: protected */
    public void onSetUpView(IMMessage iMMessage) {
        OperationMsgT2 operationMsgT2 = (OperationMsgT2) IMJsonUtil.objectFromJson(iMMessage.getContent(), OperationMsgT2.class);
        this.f8733j = operationMsgT2;
        if (operationMsgT2 != null) {
            int windowWidth = IMViewUtil.getWindowWidth(getContext()) - IMViewUtil.dp2px(getContext(), 20.0f);
            ViewGroup.LayoutParams layoutParams = this.f8726c.getLayoutParams();
            layoutParams.width = windowWidth;
            if (this.f8733j.imageWidth == 0 || this.f8733j.imageHeight == 0) {
                layoutParams.height = (windowWidth * 264) / 710;
            } else {
                layoutParams.height = (int) (((float) windowWidth) * (((float) this.f8733j.imageHeight) / ((float) this.f8733j.imageWidth)));
            }
            this.f8726c.setLayoutParams(layoutParams);
            if (this.f8733j.overTime == 0 || System.currentTimeMillis() <= this.f8733j.overTime * 1000) {
                this.f8732i = false;
                this.f8731h.setVisibility(8);
                this.f8728e.setVisibility(8);
            } else {
                this.f8731h.setVisibility(0);
                this.f8728e.setVisibility(0);
                this.f8732i = true;
            }
            if (this.f8733j.title == null || this.f8733j.title.equals("")) {
                this.f8724a.setVisibility(8);
            } else {
                this.f8724a.setVisibility(0);
                this.f8724a.setText(this.f8733j.title);
            }
            if (this.f8733j.content == null || this.f8733j.content.equals("")) {
                this.f8725b.setVisibility(8);
            } else {
                this.f8725b.setVisibility(0);
                this.f8725b.setText(HighlightHelper.processHighlight(this.f8733j.content));
            }
            if (this.f8733j.image == null || this.f8733j.image.equals("")) {
                this.f8729f.setVisibility(8);
                this.f8726c.setVisibility(8);
                this.f8727d.setVisibility(8);
            } else {
                this.f8729f.setVisibility(0);
                this.f8726c.setVisibility(0);
                this.f8726c.setImageResource(IMResource.getDrawableID(R.drawable.im_nomix_onemessage_imagebg));
                if (this.f8733j.image.endsWith(".gif")) {
                    BtsImageLoader.getInstance().loadIntoAsGif(this.f8733j.image, this.f8726c, new Callback() {
                        public void onFailed() {
                        }

                        public void onStart() {
                        }

                        public void onSuccess(Bitmap bitmap) {
                        }
                    });
                } else {
                    BtsImageLoader.getInstance().loadInto((Object) this.f8733j.image, (View) this.f8726c, IMResource.getDrawableID(R.drawable.im_nomix_onemessage_imagebg));
                }
                if (iMMessage.isRead() || this.f8732i) {
                    this.f8727d.setVisibility(8);
                } else {
                    this.f8727d.setVisibility(0);
                }
            }
            if (TextUtils.isEmpty(this.f8733j.action)) {
                this.f8730g.setVisibility(8);
            } else {
                this.f8730g.setVisibility(0);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onViewClick() {
        IMLog.m6632e("OperationCardT2", "T2 onViewClick");
        OmegaUtil.trackOperationOmega(1002, this.message);
        if (!this.message.isRead()) {
            this.message.setIsRead(true);
            IMManager.getInstance().updateMessage(this.message);
            this.f8727d.setVisibility(8);
        }
        OperationMsgT2 operationMsgT2 = this.f8733j;
        String str = operationMsgT2 != null ? operationMsgT2.action : "";
        if (this.f8733j != null && !TextUtils.isEmpty(str)) {
            if (this.f8733j.overTime == 0 || System.currentTimeMillis() <= this.f8733j.overTime * 1000) {
                if (this.f8733j.luncherMode == 1) {
                    EventBus.getDefault().post(new IMSkipToMainActivityEvent(str));
                } else {
                    IMCommonUtil.startUriActivity(this.context, str);
                }
                OmegaUtil.trackOperationOmegaNew(this.message);
                return;
            }
            SystemUtils.showToast(IMTipsToast.makeText(getContext(), (CharSequence) IMResource.getString(R.string.im_over_time_tip), 1));
        }
    }
}
