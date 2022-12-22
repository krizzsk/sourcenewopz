package com.didichuxing.omega.sdk.uicomponents.treeview.holder;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didichuxing.omega.sdk.uicomponents.treeview.model.TreeNode;

public class ParentViewHolder extends TreeNode.BaseNodeViewHolder<Object> {
    public void toggle(boolean z) {
    }

    public ParentViewHolder(Context context) {
        super(context);
    }

    public View createNodeView(TreeNode treeNode, Object obj) {
        TextView textView = new TextView(this.context);
        textView.setText(String.valueOf(obj));
        textView.setTextColor(Color.argb(255, 230, 230, 230));
        ImageView imageView = new ImageView(this.context);
        imageView.setBackgroundColor(Color.argb(230, 230, 230, 230));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = 15;
        layoutParams.height = 15;
        imageView.setLeft(5);
        imageView.setRight(5);
        imageView.setLayoutParams(layoutParams);
        LinearLayout linearLayout = new LinearLayout(this.context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        linearLayout.setGravity(19);
        linearLayout.setLayoutParams(layoutParams2);
        linearLayout.addView(imageView);
        linearLayout.addView(textView);
        return linearLayout;
    }
}
