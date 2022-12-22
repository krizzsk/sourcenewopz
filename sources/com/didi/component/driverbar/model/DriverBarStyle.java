package com.didi.component.driverbar.model;

import com.google.gson.annotations.JsonAdapter;

@JsonAdapter(DriverBarStyleJsonAdapter.class)
public enum DriverBarStyle {
    JAPAN_STYLE,
    DEFAULT_STYLE
}
