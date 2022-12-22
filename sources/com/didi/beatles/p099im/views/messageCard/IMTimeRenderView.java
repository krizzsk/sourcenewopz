package com.didi.beatles.p099im.views.messageCard;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.beatles.p099im.access.style.IMStyleManager;
import com.didi.beatles.p099im.adapter.MessageAdapter;
import com.didi.beatles.p099im.module.entity.IMMessage;
import com.didi.beatles.p099im.utils.IMDateUtil;
import com.didi.beatles.p099im.utils.IMViewUtil;
import com.taxis99.R;
import java.util.Date;

/* renamed from: com.didi.beatles.im.views.messageCard.IMTimeRenderView */
public class IMTimeRenderView extends IMBaseRenderView {

    /* renamed from: a */
    private TextView f10402a;

    /* access modifiers changed from: protected */
    public void onUpdateView() {
    }

    /* access modifiers changed from: protected */
    public void onViewClick() {
    }

    public IMTimeRenderView(Context context, MessageAdapter messageAdapter) {
        super(context, 1, messageAdapter);
    }

    /* access modifiers changed from: protected */
    public View onInflatView(ViewGroup viewGroup) {
        return this.inflater.inflate(R.layout.bts_im_message_title_time, viewGroup, false);
    }

    /* access modifiers changed from: protected */
    public void onFindViewById() {
        this.f10402a = (TextView) findViewById(R.id.time_title);
    }

    /* access modifiers changed from: protected */
    public void onSetUpView(IMMessage iMMessage) {
        if (IMStyleManager.getCurBusinessStyle() == IMStyleManager.Style.GLOBAL_PSG) {
            this.f10402a.setTextSize(0, (float) IMViewUtil.dp2px(getContext(), 10.0f));
            this.f10402a.setTextColor(Color.parseColor("#FF919599"));
            this.f10402a.setTypeface(Typeface.DEFAULT_BOLD);
        }
        setTime(Long.valueOf(this.message.getCreateTime()));
    }

    public void setTime(Long l) {
        this.f10402a.setText(IMDateUtil.getMsgTimeDiffDesc(getContext(), new Date(l.longValue())));
    }
}
