package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class TaxiPassengerPaySuccReq extends Message {
    public static final String DEFAULT_CONTENT = "";
    public static final List<Item> DEFAULT_DETAIL = Collections.emptyList();
    public static final String DEFAULT_ORDER_ID = "";
    public static final Float DEFAULT_REWARD_FEE;
    public static final Float DEFAULT_TOTAL;
    public static final String DEFAULT_TRIP_ID = "";
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.STRING)
    public final String content;
    @ProtoField(label = Message.Label.REPEATED, messageType = Item.class, tag = 4)
    public final List<Item> detail;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.STRING)
    public final String order_id;
    @ProtoField(tag = 6, type = Message.Datatype.FLOAT)
    public final Float reward_fee;
    @ProtoField(tag = 3, type = Message.Datatype.FLOAT)
    public final Float total;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String trip_id;

    static {
        Float valueOf = Float.valueOf(0.0f);
        DEFAULT_TOTAL = valueOf;
        DEFAULT_REWARD_FEE = valueOf;
    }

    public TaxiPassengerPaySuccReq(String str, String str2, Float f, List<Item> list, String str3, Float f2) {
        this.order_id = str;
        this.content = str2;
        this.total = f;
        this.detail = immutableCopyOf(list);
        this.trip_id = str3;
        this.reward_fee = f2;
    }

    private TaxiPassengerPaySuccReq(Builder builder) {
        this(builder.order_id, builder.content, builder.total, builder.detail, builder.trip_id, builder.reward_fee);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TaxiPassengerPaySuccReq)) {
            return false;
        }
        TaxiPassengerPaySuccReq taxiPassengerPaySuccReq = (TaxiPassengerPaySuccReq) obj;
        if (!equals((Object) this.order_id, (Object) taxiPassengerPaySuccReq.order_id) || !equals((Object) this.content, (Object) taxiPassengerPaySuccReq.content) || !equals((Object) this.total, (Object) taxiPassengerPaySuccReq.total) || !equals((List<?>) this.detail, (List<?>) taxiPassengerPaySuccReq.detail) || !equals((Object) this.trip_id, (Object) taxiPassengerPaySuccReq.trip_id) || !equals((Object) this.reward_fee, (Object) taxiPassengerPaySuccReq.reward_fee)) {
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
        String str2 = this.content;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        Float f = this.total;
        int hashCode3 = (hashCode2 + (f != null ? f.hashCode() : 0)) * 37;
        List<Item> list = this.detail;
        int hashCode4 = (hashCode3 + (list != null ? list.hashCode() : 1)) * 37;
        String str3 = this.trip_id;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Float f2 = this.reward_fee;
        if (f2 != null) {
            i2 = f2.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<TaxiPassengerPaySuccReq> {
        public String content;
        public List<Item> detail;
        public String order_id;
        public Float reward_fee;
        public Float total;
        public String trip_id;

        public Builder() {
        }

        public Builder(TaxiPassengerPaySuccReq taxiPassengerPaySuccReq) {
            super(taxiPassengerPaySuccReq);
            if (taxiPassengerPaySuccReq != null) {
                this.order_id = taxiPassengerPaySuccReq.order_id;
                this.content = taxiPassengerPaySuccReq.content;
                this.total = taxiPassengerPaySuccReq.total;
                this.detail = TaxiPassengerPaySuccReq.copyOf(taxiPassengerPaySuccReq.detail);
                this.trip_id = taxiPassengerPaySuccReq.trip_id;
                this.reward_fee = taxiPassengerPaySuccReq.reward_fee;
            }
        }

        public Builder order_id(String str) {
            this.order_id = str;
            return this;
        }

        public Builder content(String str) {
            this.content = str;
            return this;
        }

        public Builder total(Float f) {
            this.total = f;
            return this;
        }

        public Builder detail(List<Item> list) {
            this.detail = checkForNulls(list);
            return this;
        }

        public Builder trip_id(String str) {
            this.trip_id = str;
            return this;
        }

        public Builder reward_fee(Float f) {
            this.reward_fee = f;
            return this;
        }

        public TaxiPassengerPaySuccReq build() {
            checkRequiredFields();
            return new TaxiPassengerPaySuccReq(this);
        }
    }

    public static final class Item extends Message {
        public static final Float DEFAULT_ITEM_VALUE = Float.valueOf(0.0f);
        public static final String DEFAULT_NAME = "";
        @ProtoField(tag = 2, type = Message.Datatype.FLOAT)
        public final Float item_value;
        @ProtoField(tag = 1, type = Message.Datatype.STRING)
        public final String name;

        public Item(String str, Float f) {
            this.name = str;
            this.item_value = f;
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
            Float f = this.item_value;
            if (f != null) {
                i2 = f.hashCode();
            }
            int i3 = hashCode + i2;
            this.hashCode = i3;
            return i3;
        }

        public static final class Builder extends Message.Builder<Item> {
            public Float item_value;
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

            public Builder item_value(Float f) {
                this.item_value = f;
                return this;
            }

            public Item build() {
                return new Item(this);
            }
        }
    }
}
