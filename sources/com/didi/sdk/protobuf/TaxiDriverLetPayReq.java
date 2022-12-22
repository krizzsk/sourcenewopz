package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class TaxiDriverLetPayReq extends Message {
    public static final List<Item> DEFAULT_DETAIL = Collections.emptyList();
    public static final Boolean DEFAULT_IS_UPDATE = false;
    public static final String DEFAULT_ORDER_ID = "";
    public static final String DEFAULT_TOAST_CONTENT = "";
    public static final Float DEFAULT_TOTAL = Float.valueOf(0.0f);
    @ProtoField(label = Message.Label.REPEATED, messageType = Item.class, tag = 3)
    public final List<Item> detail;
    @ProtoField(tag = 5, type = Message.Datatype.BOOL)
    public final Boolean is_update;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.STRING)
    public final String order_id;
    @ProtoField(label = Message.Label.REQUIRED, tag = 4, type = Message.Datatype.STRING)
    public final String toast_content;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.FLOAT)
    public final Float total;

    public TaxiDriverLetPayReq(String str, Float f, List<Item> list, String str2, Boolean bool) {
        this.order_id = str;
        this.total = f;
        this.detail = immutableCopyOf(list);
        this.toast_content = str2;
        this.is_update = bool;
    }

    private TaxiDriverLetPayReq(Builder builder) {
        this(builder.order_id, builder.total, builder.detail, builder.toast_content, builder.is_update);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TaxiDriverLetPayReq)) {
            return false;
        }
        TaxiDriverLetPayReq taxiDriverLetPayReq = (TaxiDriverLetPayReq) obj;
        if (!equals((Object) this.order_id, (Object) taxiDriverLetPayReq.order_id) || !equals((Object) this.total, (Object) taxiDriverLetPayReq.total) || !equals((List<?>) this.detail, (List<?>) taxiDriverLetPayReq.detail) || !equals((Object) this.toast_content, (Object) taxiDriverLetPayReq.toast_content) || !equals((Object) this.is_update, (Object) taxiDriverLetPayReq.is_update)) {
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
        Float f = this.total;
        int hashCode2 = (hashCode + (f != null ? f.hashCode() : 0)) * 37;
        List<Item> list = this.detail;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 1)) * 37;
        String str2 = this.toast_content;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Boolean bool = this.is_update;
        if (bool != null) {
            i2 = bool.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<TaxiDriverLetPayReq> {
        public List<Item> detail;
        public Boolean is_update;
        public String order_id;
        public String toast_content;
        public Float total;

        public Builder() {
        }

        public Builder(TaxiDriverLetPayReq taxiDriverLetPayReq) {
            super(taxiDriverLetPayReq);
            if (taxiDriverLetPayReq != null) {
                this.order_id = taxiDriverLetPayReq.order_id;
                this.total = taxiDriverLetPayReq.total;
                this.detail = TaxiDriverLetPayReq.copyOf(taxiDriverLetPayReq.detail);
                this.toast_content = taxiDriverLetPayReq.toast_content;
                this.is_update = taxiDriverLetPayReq.is_update;
            }
        }

        public Builder order_id(String str) {
            this.order_id = str;
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

        public Builder toast_content(String str) {
            this.toast_content = str;
            return this;
        }

        public Builder is_update(Boolean bool) {
            this.is_update = bool;
            return this;
        }

        public TaxiDriverLetPayReq build() {
            checkRequiredFields();
            return new TaxiDriverLetPayReq(this);
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
