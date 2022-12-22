package global.didi.pay.select.model;

import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class PayMethodItemInfo implements Serializable {
    public String cardIndex;
    public int channelId;
    public String copyWriting;
    public int depositStatus = 0;
    public String discount;
    public String iconUrl;
    public String info;
    public int infoStyle = 0;
    public boolean isEnabled = true;
    public boolean isSelected = false;
    public String label;
    public String marketing;
    public int status = 0;
    public int style = 2;
    public String subTitle;
    public int subTitleStyle = 0;
    public String subTitleTip;
    public String title;
    public int titleStyle = 0;

    public static class Button {
        public static final int ARROW = 2;
        public static final int GROUP = 4;
        public static final int SELECT = 1;
        public static final int TOP_UP = 3;
    }

    public static class DepositStatus {
        public static final int DEFAULT = 0;
        public static final int SIGNED_AND_BALANCE_INSUFFICIENT = 2;
        public static final int SIGNED_AND_BALANCE_SUFFICIENT = 1;
        public static final int UNSIGNED_AND_BALANCE_INSUFFICIENT = 3;
    }

    public static class Status {
        public static final int EXPIRED = 3;
        public static final int SIGNED = 1;
        public static final int UNSIGNED = 0;
        public static final int WAIT_VERIFY = 2;
    }

    public static class TextStyle {
        public static final int TEXT_BLACK_BOLD = 3;
        public static final int TEXT_DEFAULT = 0;
        public static final int TEXT_GRAY = 2;
        public static final int TEXT_RED = 1;
    }

    @Target({ElementType.PARAMETER})
    @Retention(RetentionPolicy.SOURCE)
    public @interface TextStyleEnum {
    }
}
