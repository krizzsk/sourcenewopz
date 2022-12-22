package com.didi.map.sdk.departure.internal.rec;

public interface Square extends Comparable<Square> {
    public static final int DIR_LEFT = 0;
    public static final int DIR_RIGHT = 1;

    void apply();

    int getDirection();

    float getHeight();

    float getWidth();

    double getX();

    double getY();

    void handler(int i);

    void setDirection(int i);
}
