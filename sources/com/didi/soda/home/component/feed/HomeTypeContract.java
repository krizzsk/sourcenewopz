package com.didi.soda.home.component.feed;

public interface HomeTypeContract {

    public enum HomeLoadingType {
        LOADING_FILTER_SHIMMER,
        LOADING_SHIMMER,
        LOADING_DIALOG,
        LOADING_DIALOG_WITH_BOX,
        LOADING_PULL,
        LOADING_PAGE
    }

    public enum HomeRefreshType {
        REFRESH_ALL,
        REFRESH_PARTIAL,
        REFRESH_APPEND
    }

    public enum HomeViewType {
        NORMAL,
        LOADING,
        ERROR,
        AREA_NOT_AVAILABLE
    }
}
