package com.didi.soda.home.component.feed.listener;

public interface HomeSortClickListener {
    Type getCurrentSortType();

    void onSortClick(Type type);

    void onSortOpen(int i);

    public enum Type {
        RECOMMEND(1),
        TIME(3),
        PRICE(4);
        
        private int mType;

        private Type(int i) {
            this.mType = i;
        }

        public int getValue() {
            return this.mType;
        }
    }
}
