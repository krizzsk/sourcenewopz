package com.didi.beatles.p099im.views.messageCard;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.beatles.p099im.access.card.HighlightHelper;
import com.didi.beatles.p099im.api.entity.IMNewstandResponse;
import com.didi.beatles.p099im.utils.IMCommonUtil;
import com.didi.beatles.p099im.utils.imageloader.BtsImageLoader;
import com.taxis99.R;

/* renamed from: com.didi.beatles.im.views.messageCard.IMOneMessageCard2 */
public class IMOneMessageCard2 extends LinearLayout {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Context f10333a;

    /* renamed from: b */
    private TextView f10334b;

    /* renamed from: c */
    private TextView f10335c;

    /* renamed from: d */
    private ImageView f10336d;

    /* renamed from: e */
    private ImageView f10337e;

    /* renamed from: f */
    private View f10338f;

    public IMOneMessageCard2(Context context) {
        super(context);
        this.f10333a = context;
        m7060a();
    }

    public IMOneMessageCard2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f10333a = context;
        m7060a();
    }

    /* renamed from: a */
    private void m7060a() {
        View inflate = inflate(this.f10333a, R.layout.onemessage_profile_card_template2, this);
        this.f10334b = (TextView) inflate.findViewById(R.id.onemessage_title);
        this.f10335c = (TextView) inflate.findViewById(R.id.onemessage_content);
        this.f10336d = (ImageView) inflate.findViewById(R.id.onemessage_image);
        this.f10338f = inflate.findViewById(R.id.im_look_more_btn);
    }

    public void bindViewData(final IMNewstandResponse.NewStandMessage newStandMessage, int i) {
        if (newStandMessage != null) {
            if (!TextUtils.isEmpty(newStandMessage.title)) {
                this.f10334b.setText(newStandMessage.title);
            } else {
                this.f10334b.setVisibility(8);
            }
            if (!TextUtils.isEmpty(newStandMessage.content)) {
                this.f10335c.setText(HighlightHelper.processHighlight(newStandMessage.content));
            } else {
                this.f10335c.setVisibility(8);
            }
            BtsImageLoader.getInstance().loadRoundInto(newStandMessage.image, this.f10336d);
            setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    IMCommonUtil.startUriActivity(IMOneMessageCard2.this.f10333a, newStandMessage.action);
                }
            });
            if (TextUtils.isEmpty(newStandMessage.action)) {
                this.f10338f.setVisibility(8);
            } else {
                this.f10338f.setVisibility(0);
            }
        }
    }
}
