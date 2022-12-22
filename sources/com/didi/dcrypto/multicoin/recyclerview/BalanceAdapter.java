package com.didi.dcrypto.multicoin.recyclerview;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.dcrypto.model.AccountInfoMulticoinBalance;
import com.didi.dcrypto.util.ColorUtils;
import com.didi.dcrypto.util.DCryptoUtils;
import com.didi.dcrypto.util.DigitUtils;
import com.didi.dcrypto.util.MulticoinUtils;
import com.squareup.picasso.Picasso;
import com.taxis99.R;
import java.util.List;

public class BalanceAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* renamed from: a */
    private List<AccountInfoMulticoinBalance> f16485a;

    /* renamed from: b */
    private Context f16486b;

    /* renamed from: c */
    private String f16487c;

    public BalanceAdapter(List<AccountInfoMulticoinBalance> list, Context context, String str) {
        this.f16485a = list;
        this.f16486b = context;
        this.f16487c = str;
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.multicoin_balance_row_item, viewGroup, false));
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        AccountInfoMulticoinBalance accountInfoMulticoinBalance = this.f16485a.get(i);
        viewHolder.title.setText(accountInfoMulticoinBalance.getCrypto_title());
        try {
            viewHolder.amountBRL.setText(MulticoinUtils.getMulticoinCurrency(DigitUtils.getElvishedCurrency(Double.parseDouble(accountInfoMulticoinBalance.getAmount_brl()))));
        } catch (Exception unused) {
            TextView textView = viewHolder.amountBRL;
            textView.setText("R$ " + accountInfoMulticoinBalance.getAmount_brl());
        }
        try {
            double parseDouble = Double.parseDouble(accountInfoMulticoinBalance.getDaily_profit_loss());
            String elvishedCurrency = DigitUtils.getElvishedCurrency(parseDouble);
            if (parseDouble >= 0.0d) {
                TextView textView2 = viewHolder.PanL;
                textView2.setText("+" + MulticoinUtils.getMulticoinCurrency(elvishedCurrency));
            } else {
                TextView textView3 = viewHolder.PanL;
                textView3.setText("-" + MulticoinUtils.getMulticoinCurrency(elvishedCurrency));
            }
        } catch (Exception unused2) {
            TextView textView4 = viewHolder.PanL;
            textView4.setText("R$ " + accountInfoMulticoinBalance.getDaily_profit_loss());
        }
        try {
            double parseDouble2 = Double.parseDouble(accountInfoMulticoinBalance.getDaily_profit_loss());
            if (!DCryptoUtils.hostAppSource.equalsIgnoreCase("latour")) {
                if (parseDouble2 >= 0.0d) {
                    viewHolder.PanL.setTextColor(Color.parseColor(ColorUtils.DIDI_GREEN_MOUTON));
                } else {
                    viewHolder.PanL.setTextColor(Color.parseColor(ColorUtils.DIDI_RED));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            viewHolder.PanL.setTextColor(Color.parseColor(ColorUtils.DIDI_GREEN_MOUTON));
        }
        TextView textView5 = viewHolder.balanceAvailable;
        textView5.setText(accountInfoMulticoinBalance.getBalance_available() + " " + accountInfoMulticoinBalance.getCurrency_symbol().toUpperCase());
        if (!DCryptoUtils.hostAppSource.equalsIgnoreCase("latour") && !accountInfoMulticoinBalance.getIcon_url().equalsIgnoreCase("")) {
            Picasso.with(this.f16486b).load(accountInfoMulticoinBalance.getIcon_url()).placeholder((int) R.drawable.bottom_banner_pic_1).into(viewHolder.icon);
        }
    }

    public int getItemCount() {
        return this.f16485a.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView PanL;
        public TextView amountBRL;
        public TextView balanceAvailable;
        public ImageView icon;
        public TextView title;

        public ViewHolder(View view) {
            super(view);
            this.icon = (ImageView) view.findViewById(R.id.ivBalanceItemIcon);
            this.title = (TextView) view.findViewById(R.id.tvBalanceItemTitle);
            this.amountBRL = (TextView) view.findViewById(R.id.tvAmountBRL);
            this.PanL = (TextView) view.findViewById(R.id.tvDailyPL);
            this.balanceAvailable = (TextView) view.findViewById(R.id.tvBalanceAvailable);
        }
    }
}
