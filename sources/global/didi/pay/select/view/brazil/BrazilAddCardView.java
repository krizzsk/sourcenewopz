package global.didi.pay.select.view.brazil;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.taxis99.R;
import global.didi.pay.p236ui.theme.UnifiedPayThemeManager;

public class BrazilAddCardView extends LinearLayout {
    public TextView mTvAddCard;
    public TextView mTvInstallment;

    public BrazilAddCardView(Context context) {
        super(context);
        init(context);
    }

    public BrazilAddCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public BrazilAddCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.wallet_global_v_99_paymethod_add_card, this, true);
        TextView textView = (TextView) findViewById(R.id.tv_paymethod_add_card);
        this.mTvAddCard = textView;
        textView.setTextColor(getResources().getColorStateList(UnifiedPayThemeManager.getINS().getPayTheme(getContext()).getAddCardTxtColor()));
        this.mTvInstallment = (TextView) findViewById(R.id.tv_paymethod_installment);
        showInstallment((String) null);
    }

    public void setAddCardClickListener(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void setEnable(boolean z) {
        this.mTvAddCard.setEnabled(z);
    }

    public void showInstallment(String str) {
        this.mTvInstallment.setVisibility(!TextUtils.isEmpty(str) ? 0 : 8);
        this.mTvInstallment.setText(str);
    }
}
