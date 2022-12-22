package com.didi.beatles.p099im.views;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.beatles.p099im.data.IMInnerData;
import com.didi.beatles.p099im.module.IMEmojiModule;
import com.didi.beatles.p099im.omega.IMMsgOmega;
import com.didi.beatles.p099im.picture.config.IMPictureMimeType;
import com.didi.beatles.p099im.utils.imageloader.BtsImageLoader;
import com.taxis99.R;
import java.util.HashMap;

/* renamed from: com.didi.beatles.im.views.IMRecommendEmojiView */
public class IMRecommendEmojiView extends LinearLayout {

    /* renamed from: e */
    private static final long f9928e = 4000;

    /* renamed from: a */
    private Context f9929a;

    /* renamed from: b */
    private ImageView f9930b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public RecommendListener f9931c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public IMEmojiModule f9932d;

    /* renamed from: f */
    private Handler f9933f;

    /* renamed from: com.didi.beatles.im.views.IMRecommendEmojiView$RecommendListener */
    public interface RecommendListener {
        void onClick(String str, String str2, String str3);
    }

    public IMRecommendEmojiView(Context context) {
        this(context, (AttributeSet) null);
    }

    public IMRecommendEmojiView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IMRecommendEmojiView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f9933f = new Handler();
        this.f9929a = context;
        m6699a();
    }

    /* renamed from: a */
    private void m6699a() {
        this.f9930b = (ImageView) LayoutInflater.from(this.f9929a).inflate(R.layout.im_recommond_emoji_view, this).findViewById(R.id.im_recommond_iv);
        setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (IMRecommendEmojiView.this.f9931c != null && IMRecommendEmojiView.this.f9932d != null) {
                    IMRecommendEmojiView.this.f9931c.onClick(IMRecommendEmojiView.this.f9932d.emojiId, IMRecommendEmojiView.this.f9932d.picName, IMRecommendEmojiView.this.f9932d.desc);
                    IMRecommendEmojiView.this.dismiss();
                    HashMap hashMap = new HashMap();
                    hashMap.put("name", IMRecommendEmojiView.this.f9932d.desc);
                    IMMsgOmega.getInstance().track("ddim_dy_all_icon_ck", hashMap);
                }
            }
        });
    }

    public void show(IMEmojiModule iMEmojiModule) {
        if (iMEmojiModule != null) {
            setVisibility(0);
            this.f9932d = iMEmojiModule;
            BtsImageLoader instance = BtsImageLoader.getInstance();
            instance.loadInto(IMInnerData.getInstance().getEmojiPrefix() + iMEmojiModule.picName + IMPictureMimeType.PNG, this.f9930b);
            this.f9933f.postDelayed(new Runnable() {
                public void run() {
                    if (IMRecommendEmojiView.this.isShown()) {
                        IMRecommendEmojiView.this.dismiss();
                    }
                }
            }, 4000);
        }
    }

    public void dismiss() {
        setVisibility(8);
    }

    public void setRecommondListener(RecommendListener recommendListener) {
        this.f9931c = recommendListener;
    }
}
