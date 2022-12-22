package com.didi.beatles.p099im.views.messageCard;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.didi.beatles.p099im.adapter.MessageAdapter;
import com.didi.beatles.p099im.module.entity.IMMessage;
import com.taxis99.R;

/* renamed from: com.didi.beatles.im.views.messageCard.IMloadRenderView */
public class IMloadRenderView extends IMBaseRenderView {
    /* access modifiers changed from: protected */
    public void onFindViewById() {
    }

    /* access modifiers changed from: protected */
    public void onSetUpView(IMMessage iMMessage) {
    }

    /* access modifiers changed from: protected */
    public void onUpdateView() {
    }

    /* access modifiers changed from: protected */
    public void onViewClick() {
    }

    public IMloadRenderView(Context context, MessageAdapter messageAdapter) {
        super(context, 1, messageAdapter);
    }

    /* access modifiers changed from: protected */
    public View onInflatView(ViewGroup viewGroup) {
        return this.inflater.inflate(R.layout.bts_im_header_load, viewGroup, false);
    }
}
