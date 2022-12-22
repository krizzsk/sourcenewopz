package com.didichuxing.omega.sdk.uicomponents.treeview.holder;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.didichuxing.omega.sdk.uicomponents.treeview.model.TreeNode;

public class SimpleViewHolder extends TreeNode.BaseNodeViewHolder<Object> {
    public void toggle(boolean z) {
    }

    public SimpleViewHolder(Context context) {
        super(context);
    }

    public View createNodeView(TreeNode treeNode, Object obj) {
        TextView textView = new TextView(this.context);
        textView.setText(String.valueOf(obj));
        textView.setTextColor(-65536);
        return textView;
    }
}
