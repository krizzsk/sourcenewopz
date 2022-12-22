package com.didi.entrega.info.binder;

import android.text.Editable;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity;
import com.didi.entrega.customer.foundation.util.ResourceHelper;
import com.didi.entrega.customer.widget.text.RichTextView;
import com.didi.entrega.info.binder.StufRemarkBinder;
import com.didi.entrega.info.helper.InfoTextWatcher;
import com.didi.entrega.info.model.StuffRemarkModel;
import com.didi.rfusion.widget.RFEditText;
import com.taxis99.R;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, mo175978d2 = {"com/didi/entrega/info/binder/StufRemarkBinder$bind$1$1", "Lcom/didi/entrega/info/helper/InfoTextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: StufRemarkBinder.kt */
public final class StufRemarkBinder$bind$1$1 extends InfoTextWatcher {
    final /* synthetic */ StuffRemarkModel $item;
    final /* synthetic */ View $this_with;
    final /* synthetic */ StufRemarkBinder this$0;

    StufRemarkBinder$bind$1$1(StuffRemarkModel stuffRemarkModel, StufRemarkBinder stufRemarkBinder, View view) {
        this.$item = stuffRemarkModel;
        this.this$0 = stufRemarkBinder;
        this.$this_with = view;
    }

    public void afterTextChanged(Editable editable) {
        boolean z;
        super.afterTextChanged(editable);
        StuffRemarkModel stuffRemarkModel = this.$item;
        CommonInfoEntity.Remark stuffEntityData = stuffRemarkModel == null ? null : stuffRemarkModel.getStuffEntityData();
        if (stuffEntityData != null) {
            stuffEntityData.setContent(String.valueOf(editable));
        }
        this.this$0.setCurrentCount(editable == null ? 0 : editable.length());
        ((RichTextView) this.$this_with.findViewById(R.id.tv_text_count)).setText(this.this$0.getCurrentCount() + "/200");
        StufRemarkBinder.StuffRemarkCardClickListener clickListener = this.this$0.getClickListener();
        if (clickListener != null) {
            clickListener.onRemarkTextChange(this.$item);
        }
        if (editable != null && editable.length() == 200) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            ((RFEditText) this.$this_with.findViewById(R.id.etv_remark)).setBackground(ContextCompat.getDrawable(((RFEditText) this.$this_with.findViewById(R.id.etv_remark)).getContext(), R.drawable.info_contact_round_background_red_100));
            ((RichTextView) this.$this_with.findViewById(R.id.tv_text_count)).setText(ResourceHelper.getString(R.string.entrega_info_remark_text_count, Integer.valueOf(this.this$0.getCurrentCount()), 200));
            return;
        }
        ((RichTextView) this.$this_with.findViewById(R.id.tv_text_count)).setText(this.this$0.getCurrentCount() + "/200");
        ((RFEditText) this.$this_with.findViewById(R.id.etv_remark)).setBackground(ContextCompat.getDrawable(((RFEditText) this.$this_with.findViewById(R.id.etv_remark)).getContext(), R.drawable.info_contact_round_background_grey_12_7_97));
    }
}
