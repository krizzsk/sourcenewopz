package com.didi.component.estimate.newui.view.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.taxis99.R;

public class TwoPriceViewHolder extends RecyclerView.ViewHolder {
    public View blankView;
    public ImageView choiceCheckBox;
    public TextView choiceText;

    public TwoPriceViewHolder(View view) {
        super(view);
        this.choiceCheckBox = (ImageView) view.findViewById(R.id.new_estimate_two_price_check_box);
        this.choiceText = (TextView) view.findViewById(R.id.new_estimate_two_price_tv);
        this.blankView = view.findViewById(R.id.new_estimate_two_price_blank);
    }
}
