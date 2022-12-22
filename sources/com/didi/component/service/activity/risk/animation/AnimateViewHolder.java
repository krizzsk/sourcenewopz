package com.didi.component.service.activity.risk.animation;

import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.recyclerview.widget.RecyclerView;

public interface AnimateViewHolder {
    void animateAddImpl(RecyclerView.ViewHolder viewHolder, ViewPropertyAnimatorListener viewPropertyAnimatorListener);

    void animateRemoveImpl(RecyclerView.ViewHolder viewHolder, ViewPropertyAnimatorListener viewPropertyAnimatorListener);

    void preAnimateAddImpl(RecyclerView.ViewHolder viewHolder);

    void preAnimateRemoveImpl(RecyclerView.ViewHolder viewHolder);
}
