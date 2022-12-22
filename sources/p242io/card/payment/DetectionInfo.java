package p242io.card.payment;

/* renamed from: io.card.payment.DetectionInfo */
public class DetectionInfo {
    public boolean bottomEdge;
    public boolean complete;
    public CreditCard detectedCard;
    public int expiry_month;
    public int expiry_year;
    public float focusScore;
    public boolean leftEdge;
    public int num_frames_scanned;
    public int[] prediction;
    public boolean rightEdge;
    public long system_time_card_number_completion_time;
    public long system_time_expiry_completion_time;
    public long system_time_scanner_begin_time;
    public long time_card_number_completion_time;
    public long time_expiry_completion_time;
    public long time_scanner_begin_time;
    public boolean topEdge;

    public DetectionInfo() {
        this.complete = false;
        int[] iArr = new int[16];
        this.prediction = iArr;
        iArr[0] = -1;
        iArr[15] = -1;
        this.detectedCard = new CreditCard();
    }

    public DetectionInfo(DetectionInfo detectionInfo) {
        this();
        if (detectionInfo != null) {
            this.system_time_scanner_begin_time = detectionInfo.system_time_scanner_begin_time;
            this.system_time_card_number_completion_time = detectionInfo.system_time_card_number_completion_time;
            this.system_time_expiry_completion_time = detectionInfo.system_time_expiry_completion_time;
        }
    }

    public CreditCard creditCard() {
        String str = new String();
        for (int i = 0; i < 16; i++) {
            int[] iArr = this.prediction;
            if (iArr[i] < 0 || iArr[i] >= 10) {
                break;
            }
            str = str + String.valueOf(this.prediction[i]);
        }
        this.detectedCard.cardNumber = str;
        this.detectedCard.expiryMonth = this.expiry_month;
        this.detectedCard.expiryYear = this.expiry_year;
        return this.detectedCard;
    }

    /* access modifiers changed from: package-private */
    public boolean detected() {
        return this.topEdge && this.bottomEdge && this.rightEdge && this.leftEdge;
    }

    public int numVisibleEdges() {
        return (this.topEdge ? 1 : 0) + (this.bottomEdge ? 1 : 0) + (this.leftEdge ? 1 : 0) + (this.rightEdge ? 1 : 0);
    }

    public boolean predicted() {
        return this.complete;
    }

    public boolean sameEdgesAs(DetectionInfo detectionInfo) {
        return detectionInfo.topEdge == this.topEdge && detectionInfo.bottomEdge == this.bottomEdge && detectionInfo.leftEdge == this.leftEdge && detectionInfo.rightEdge == this.rightEdge;
    }
}
