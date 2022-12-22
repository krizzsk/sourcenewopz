package com.didi.beatles.p099im.views.messageCard;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.beatles.p099im.access.card.HighlightHelper;
import com.didi.beatles.p099im.api.entity.IMNewstandResponse;
import com.didi.beatles.p099im.utils.IMCommonUtil;
import com.didi.sofa.utils.TimeUtils;
import com.taxis99.R;
import java.text.SimpleDateFormat;
import java.util.Date;

/* renamed from: com.didi.beatles.im.views.messageCard.IMOneMessageCard1 */
public class IMOneMessageCard1 extends LinearLayout {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Context f10328a;

    /* renamed from: b */
    private TextView f10329b;

    /* renamed from: c */
    private TextView f10330c;

    /* renamed from: d */
    private TextView f10331d;

    /* renamed from: e */
    private View f10332e;

    public IMOneMessageCard1(Context context) {
        super(context);
        this.f10328a = context;
        m7058a();
    }

    public IMOneMessageCard1(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f10328a = context;
        m7058a();
    }

    /* renamed from: a */
    private void m7058a() {
        View inflate = inflate(this.f10328a, R.layout.onemessage_profile_card_template1, this);
        this.f10329b = (TextView) inflate.findViewById(R.id.onemessage_title);
        this.f10330c = (TextView) inflate.findViewById(R.id.onemessage_content);
        this.f10331d = (TextView) inflate.findViewById(R.id.onemessage_time);
        this.f10332e = inflate.findViewById(R.id.im_look_more_btn);
    }

    public void bindViewData(final IMNewstandResponse.NewStandMessage newStandMessage, int i) {
        if (newStandMessage != null) {
            if (!TextUtils.isEmpty(newStandMessage.title)) {
                this.f10329b.setText(newStandMessage.title);
            } else {
                this.f10329b.setVisibility(8);
            }
            if (!TextUtils.isEmpty(newStandMessage.content)) {
                this.f10330c.setText(HighlightHelper.processHighlight(newStandMessage.content));
            } else {
                this.f10330c.setVisibility(8);
            }
            if (newStandMessage.timestamp == 0) {
                this.f10331d.setVisibility(8);
            } else {
                this.f10331d.setText(new SimpleDateFormat(TimeUtils.YEAR_HOUR).format(new Date(newStandMessage.timestamp)));
            }
            setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    IMCommonUtil.startUriActivity(IMOneMessageCard1.this.f10328a, newStandMessage.action);
                }
            });
            if (TextUtils.isEmpty(newStandMessage.action)) {
                this.f10332e.setVisibility(8);
            } else {
                this.f10332e.setVisibility(0);
            }
        }
    }
}
