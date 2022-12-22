package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class TaxiDriverShareTripLetPayReq extends Message {
    public static final List<Item> DEFAULT_COMMON_TRIP_ITEMS = Collections.emptyList();
    public static final Integer DEFAULT_COMMON_TRIP_TOTAL = 0;
    public static final String DEFAULT_ORDER_ID = "";
    public static final Integer DEFAULT_OTHER_FEE = 0;
    public static final List<Item> DEFAULT_SELF_TRIP_ITEMS = Collections.emptyList();
    public static final Integer DEFAULT_SELF_TRIP_TOTAL = 0;
    public static final Integer DEFAULT_TIP = 0;
    public static final Integer DEFAULT_TRIP_TOTAL = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = Item.class, tag = 6)
    public final List<Item> common_trip_items;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer common_trip_total;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.STRING)
    public final String order_id;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer other_fee;
    @ProtoField(label = Message.Label.REPEATED, messageType = Item.class, tag = 4)
    public final List<Item> self_trip_items;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer self_trip_total;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer tip;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer trip_total;

    public TaxiDriverShareTripLetPayReq(String str, Integer num, Integer num2, List<Item> list, Integer num3, List<Item> list2, Integer num4, Integer num5) {
        this.order_id = str;
        this.trip_total = num;
        this.self_trip_total = num2;
        this.self_trip_items = immutableCopyOf(list);
        this.common_trip_total = num3;
        this.common_trip_items = immutableCopyOf(list2);
        this.tip = num4;
        this.other_fee = num5;
    }

    private TaxiDriverShareTripLetPayReq(Builder builder) {
        this(builder.order_id, builder.trip_total, builder.self_trip_total, builder.self_trip_items, builder.common_trip_total, builder.common_trip_items, builder.tip, builder.other_fee);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TaxiDriverShareTripLetPayReq)) {
            return false;
        }
        TaxiDriverShareTripLetPayReq taxiDriverShareTripLetPayReq = (TaxiDriverShareTripLetPayReq) obj;
        if (!equals((Object) this.order_id, (Object) taxiDriverShareTripLetPayReq.order_id) || !equals((Object) this.trip_total, (Object) taxiDriverShareTripLetPayReq.trip_total) || !equals((Object) this.self_trip_total, (Object) taxiDriverShareTripLetPayReq.self_trip_total) || !equals((List<?>) this.self_trip_items, (List<?>) taxiDriverShareTripLetPayReq.self_trip_items) || !equals((Object) this.common_trip_total, (Object) taxiDriverShareTripLetPayReq.common_trip_total) || !equals((List<?>) this.common_trip_items, (List<?>) taxiDriverShareTripLetPayReq.common_trip_items) || !equals((Object) this.tip, (Object) taxiDriverShareTripLetPayReq.tip) || !equals((Object) this.other_fee, (Object) taxiDriverShareTripLetPayReq.other_fee)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.order_id;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        Integer num = this.trip_total;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.self_trip_total;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        List<Item> list = this.self_trip_items;
        int i3 = 1;
        int hashCode4 = (hashCode3 + (list != null ? list.hashCode() : 1)) * 37;
        Integer num3 = this.common_trip_total;
        int hashCode5 = (hashCode4 + (num3 != null ? num3.hashCode() : 0)) * 37;
        List<Item> list2 = this.common_trip_items;
        if (list2 != null) {
            i3 = list2.hashCode();
        }
        int i4 = (hashCode5 + i3) * 37;
        Integer num4 = this.tip;
        int hashCode6 = (i4 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.other_fee;
        if (num5 != null) {
            i2 = num5.hashCode();
        }
        int i5 = hashCode6 + i2;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<TaxiDriverShareTripLetPayReq> {
        public List<Item> common_trip_items;
        public Integer common_trip_total;
        public String order_id;
        public Integer other_fee;
        public List<Item> self_trip_items;
        public Integer self_trip_total;
        public Integer tip;
        public Integer trip_total;

        public Builder() {
        }

        public Builder(TaxiDriverShareTripLetPayReq taxiDriverShareTripLetPayReq) {
            super(taxiDriverShareTripLetPayReq);
            if (taxiDriverShareTripLetPayReq != null) {
                this.order_id = taxiDriverShareTripLetPayReq.order_id;
                this.trip_total = taxiDriverShareTripLetPayReq.trip_total;
                this.self_trip_total = taxiDriverShareTripLetPayReq.self_trip_total;
                this.self_trip_items = TaxiDriverShareTripLetPayReq.copyOf(taxiDriverShareTripLetPayReq.self_trip_items);
                this.common_trip_total = taxiDriverShareTripLetPayReq.common_trip_total;
                this.common_trip_items = TaxiDriverShareTripLetPayReq.copyOf(taxiDriverShareTripLetPayReq.common_trip_items);
                this.tip = taxiDriverShareTripLetPayReq.tip;
                this.other_fee = taxiDriverShareTripLetPayReq.other_fee;
            }
        }

        public Builder order_id(String str) {
            this.order_id = str;
            return this;
        }

        public Builder trip_total(Integer num) {
            this.trip_total = num;
            return this;
        }

        public Builder self_trip_total(Integer num) {
            this.self_trip_total = num;
            return this;
        }

        public Builder self_trip_items(List<Item> list) {
            this.self_trip_items = checkForNulls(list);
            return this;
        }

        public Builder common_trip_total(Integer num) {
            this.common_trip_total = num;
            return this;
        }

        public Builder common_trip_items(List<Item> list) {
            this.common_trip_items = checkForNulls(list);
            return this;
        }

        public Builder tip(Integer num) {
            this.tip = num;
            return this;
        }

        public Builder other_fee(Integer num) {
            this.other_fee = num;
            return this;
        }

        public TaxiDriverShareTripLetPayReq build() {
            checkRequiredFields();
            return new TaxiDriverShareTripLetPayReq(this);
        }
    }

    public static final class Item extends Message {
        public static final Integer DEFAULT_ITEM_VALUE = 0;
        public static final String DEFAULT_NAME = "";
        @ProtoField(tag = 2, type = Message.Datatype.INT32)
        public final Integer item_value;
        @ProtoField(tag = 1, type = Message.Datatype.STRING)
        public final String name;

        public Item(String str, Integer num) {
            this.name = str;
            this.item_value = num;
        }

        private Item(Builder builder) {
            this(builder.name, builder.item_value);
            setBuilder(builder);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Item)) {
                return false;
            }
            Item item = (Item) obj;
            if (!equals((Object) this.name, (Object) item.name) || !equals((Object) this.item_value, (Object) item.item_value)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i = this.hashCode;
            if (i != 0) {
                return i;
            }
            String str = this.name;
            int i2 = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 37;
            Integer num = this.item_value;
            if (num != null) {
                i2 = num.hashCode();
            }
            int i3 = hashCode + i2;
            this.hashCode = i3;
            return i3;
        }

        public static final class Builder extends Message.Builder<Item> {
            public Integer item_value;
            public String name;

            public Builder() {
            }

            public Builder(Item item) {
                super(item);
                if (item != null) {
                    this.name = item.name;
                    this.item_value = item.item_value;
                }
            }

            public Builder name(String str) {
                this.name = str;
                return this;
            }

            public Builder item_value(Integer num) {
                this.item_value = num;
                return this;
            }

            public Item build() {
                return new Item(this);
            }
        }
    }
}
