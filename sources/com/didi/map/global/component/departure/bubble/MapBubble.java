package com.didi.map.global.component.departure.bubble;

public interface MapBubble {

    public interface OnClickListener {
        void onClick();
    }

    void setOnClickListener(OnClickListener onClickListener);
}
