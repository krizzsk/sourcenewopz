package com.didi.app.nova.support.view.recyclerview.util;

public interface PayloadProvider<M> {
    boolean areContentsTheSame(M m, M m2);

    Object getChangePayload(M m, M m2);
}
