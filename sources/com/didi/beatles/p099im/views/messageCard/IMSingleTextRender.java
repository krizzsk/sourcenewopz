package com.didi.beatles.p099im.views.messageCard;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.beatles.p099im.adapter.MessageAdapter;
import com.didi.beatles.p099im.module.entity.IMMessage;
import com.taxis99.R;

/* renamed from: com.didi.beatles.im.views.messageCard.IMSingleTextRender */
public class IMSingleTextRender extends IMBaseRenderView {

    /* renamed from: a */
    private TextView f10369a;

    /* access modifiers changed from: protected */
    public void onUpdateView() {
    }

    /* access modifiers changed from: protected */
    public void onViewClick() {
    }

    public IMSingleTextRender(Context context, int i, MessageAdapter messageAdapter) {
        super(context, i, messageAdapter);
    }

    /* access modifiers changed from: protected */
    public View onInflatView(ViewGroup viewGroup) {
        return this.inflater.inflate(R.layout.bts_im_item_single_textview, viewGroup, false);
    }

    /* access modifiers changed from: protected */
    public void onFindViewById() {
        this.f10369a = (TextView) findViewById(R.id.time_title);
    }

    /* access modifiers changed from: protected */
    public void onSetUpView(IMMessage iMMessage) {
        this.f10369a.setText(this.message.getContent());
    }
}
