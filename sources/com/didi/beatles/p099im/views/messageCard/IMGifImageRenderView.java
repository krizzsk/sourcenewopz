package com.didi.beatles.p099im.views.messageCard;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.didi.beatles.p099im.adapter.MessageAdapter;
import com.didi.beatles.p099im.data.IMInnerData;
import com.didi.beatles.p099im.module.entity.IMMessage;
import com.didi.beatles.p099im.resource.IMResource;
import com.didi.beatles.p099im.utils.imageloader.BtsImageLoader;
import com.didi.beatles.p099im.utils.imageloader.Callback;
import com.taxis99.R;

/* renamed from: com.didi.beatles.im.views.messageCard.IMGifImageRenderView */
public class IMGifImageRenderView extends IMBaseRenderView {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public ImageView f10315a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public boolean f10316b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public ProgressBar f10317c;

    /* access modifiers changed from: protected */
    public void onUpdateView() {
    }

    public IMGifImageRenderView(Context context, int i, MessageAdapter messageAdapter) {
        super(context, i, messageAdapter);
    }

    /* access modifiers changed from: protected */
    public View onInflatView(ViewGroup viewGroup) {
        return this.inflater.inflate(R.layout.bts_im_mine_gifimage_message_item, viewGroup, false);
    }

    /* access modifiers changed from: protected */
    public void onFindViewById() {
        this.f10315a = (ImageView) findViewById(R.id.gif_photo_view);
        this.f10317c = (ProgressBar) findViewById(R.id.gif_progressBar);
    }

    /* access modifiers changed from: protected */
    public void onSetUpView(IMMessage iMMessage) {
        m7043a();
    }

    /* renamed from: a */
    private void m7043a() {
        if (this.message.getFid() != null && this.message.getFid().length() > 1) {
            m7045a(this.message.getFid());
        } else if (TextUtils.isEmpty(IMInnerData.getInstance().getEmojiPrefix())) {
            IMInnerData.getInstance().addEmojiPrefixObserver(new IMInnerData.IMEmojiPerfixListener() {
                public void emojiPrefixUpdate(String str) {
                    IMGifImageRenderView iMGifImageRenderView = IMGifImageRenderView.this;
                    iMGifImageRenderView.m7045a(str + IMGifImageRenderView.this.message.getContent());
                    IMInnerData.getInstance().removeEmojiPrefixObserver(this);
                }
            });
        } else {
            m7045a(IMInnerData.getInstance().getEmojiPrefix() + this.message.getContent());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m7045a(String str) {
        BtsImageLoader.getInstance().loadIntoAsGif(str, this.f10315a, new Callback() {
            public void onStart() {
                if (IMGifImageRenderView.this.f10317c != null) {
                    IMGifImageRenderView.this.f10317c.setVisibility(0);
                    boolean unused = IMGifImageRenderView.this.f10316b = false;
                }
            }

            public void onSuccess(Bitmap bitmap) {
                if (IMGifImageRenderView.this.f10317c != null) {
                    IMGifImageRenderView.this.f10317c.setVisibility(8);
                }
            }

            public void onFailed() {
                if (IMGifImageRenderView.this.f10317c != null) {
                    IMGifImageRenderView.this.f10315a.setImageResource(IMResource.getDrawableID(R.drawable.im_load_failed));
                    IMGifImageRenderView.this.f10317c.setVisibility(8);
                    boolean unused = IMGifImageRenderView.this.f10316b = true;
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onViewClick() {
        if (this.f10316b) {
            m7043a();
        }
    }
}
