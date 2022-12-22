package com.didi.beatles.p099im.access.card;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.beatles.p099im.access.msg.OperationMsgT3;
import com.didi.beatles.p099im.access.utils.Parser;
import com.didi.beatles.p099im.adapter.MessageAdapter;
import com.didi.beatles.p099im.module.entity.IMMessage;
import com.didi.beatles.p099im.views.imageView.IMNetworkImageView;
import com.didi.beatles.p099im.views.messageCard.IMBaseRenderView;
import com.taxis99.R;

/* renamed from: com.didi.beatles.im.access.card.OperationCardT3 */
public class OperationCardT3 extends IMBaseRenderView {

    /* renamed from: a */
    private ViewGroup f8734a;

    /* access modifiers changed from: protected */
    public void onUpdateView() {
    }

    /* access modifiers changed from: protected */
    public void onViewClick() {
    }

    public OperationCardT3(Context context, MessageAdapter messageAdapter) {
        super(context, 1, messageAdapter);
    }

    /* access modifiers changed from: protected */
    public View onInflatView(ViewGroup viewGroup) {
        return this.inflater.inflate(R.layout.onemessage_operation_card_template3, viewGroup, false);
    }

    /* access modifiers changed from: protected */
    public void onFindViewById() {
        this.f8734a = (ViewGroup) findViewById(R.id.onemessage_group);
    }

    /* access modifiers changed from: protected */
    public void onSetUpView(IMMessage iMMessage) {
        OperationMsgT3 parseOperationMsgT3 = Parser.parseOperationMsgT3(iMMessage.getContent());
        if (parseOperationMsgT3 != null) {
            for (OperationMsgT3.OperationMsgT3Item a : parseOperationMsgT3.items) {
                this.f8734a.addView(m5825a(a));
            }
        }
    }

    /* renamed from: a */
    private View m5825a(OperationMsgT3.OperationMsgT3Item operationMsgT3Item) {
        View inflate = this.inflater.inflate(R.layout.onemessage_operation_card_template3item, (ViewGroup) null, false);
        ((IMNetworkImageView) inflate.findViewById(R.id.onemessage_icon)).loadImageUrl(operationMsgT3Item.icon, R.drawable.im_default_circle_mask);
        ((TextView) inflate.findViewById(R.id.onemessage_title)).setText(operationMsgT3Item.title);
        return inflate;
    }
}
