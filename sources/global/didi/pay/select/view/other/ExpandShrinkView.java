package global.didi.pay.select.view.other;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.taxis99.R;

public class ExpandShrinkView extends LinearLayout {
    private View mLessView;
    private View mMoreView;

    public ExpandShrinkView(Context context) {
        super(context);
        init(context);
    }

    public ExpandShrinkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public ExpandShrinkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.wallet_global_v_paymethod_list_expand_shrink, this, true);
        this.mMoreView = inflate.findViewById(R.id.tv_more);
        this.mLessView = inflate.findViewById(R.id.tv_less);
    }

    public void setIsExpand(boolean z) {
        if (z) {
            this.mMoreView.setVisibility(8);
            this.mLessView.setVisibility(0);
            return;
        }
        this.mMoreView.setVisibility(0);
        this.mLessView.setVisibility(8);
    }
}
