package com.meli.reporting.example.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;


public class Movement {

    private final String DetailPayment = "payment";
    private final String DetailPaymentFund = "payment_fund";
    private final String DetailFinancingRate = "financing_rate";
    private final String DetailShippingFMB = "shipping_fbm";
    private final String DetailShipping = "shipping";
    private final String DetailShippingDS = "shipping_ds";
    private final String DetailShippingFF = "shipping_ff";
    private final String DetailShippingXD = "shipping_xd";
    private final String DetailShippingMP = "shipping_mp";
    private final String DetailSubsidizedShippingCBT = "subsidized_shipping_cbt";
    private final String DetailTaxWithholding = "tax_withholding";
    private final String DetailMPFee = "mp_fee";
    private final String DetailMELIFee = "meli_fee";
    private final String DetailMLFee = "ml_fee";
    private final String DetailAccountFund = "account_fund";
    private final String DetailPaymentAddition = "payment_addition";
    private final String DetailMoneyTransfer = "money_transfer";
    private final String DetailMELICharge = "meli_charge";
    private final String DetailSpecialFee = "special_fee";
    private final String DetailCBKRecovery = "cbk_recovery";
    private final String DetailWithdraw = "withdraw";
    private final String DetailReleaseInAdvance = "release_in_advance";
    private final String DetailCredit = "credit";
    private final String DetailMerchantCredit = "merchant_credit";
    private final String DetailMediation = "bpp_recovery";
    private final String DetailSpecialFund = "special_fund";
    private final String DetailShippingFPP = "shipping_fpp";


    // Constants for movement types.

    private final String TypeIncome  = "income";
    private final String TypeFee     = "fee";
    private final String TypeExpense = "expense";
    private final String TypeFund    = "fund";

    private final String LabelCancellation = "is_cancellation";
    private final String LabelPartial      = "partial";

    private final Long MovementClientIDCommission = 3284778745614693L;

    private final String FinancialEntityCoupon = "coupon";
    private final String FinancialEntityIget   = "iget";



    private Long id;
    private Long userID;
    private Long referenceID;
    private BigDecimal amount;
    private String currencyID;
    private String detail;
    private LocalDateTime dateCreated;
    private String movementType;
    private String financialEntity;
    private String siteID;
    private Long clientID;
    private List<String> labels;
    private LocalDateTime dateReleased;
    private Long originalMoveID;

    public Movement(Builder builder) {
        this.id = builder.id;
        this.userID = builder.userID;
        this.referenceID = builder.referenceID;
        this.amount = builder.amount;
        this.currencyID = builder.currencyID;
        this.detail = builder.detail;
        this.dateCreated = builder.dateCreated;
        this.movementType = builder.movementType;
        this.financialEntity = builder.financialEntity;
        this.siteID = builder.siteID;
        this.clientID = builder.clientID;
        this.labels = builder.labels;
        this.dateReleased = builder.dateReleased;
        this.originalMoveID = builder.originalMoveID;
    }

    public Long getId() {
        return id;
    }

    public Long getUserID() {
        return userID;
    }

    public Long getReferenceID() {
        return referenceID;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getCurrencyID() {
        return currencyID;
    }

    public String getDetail() {
        return detail;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public String getMovementType() {
        return movementType;
    }

    public String getFinancialEntity() {
        return financialEntity;
    }

    public String getSiteID() {
        return siteID;
    }

    public Long getClientID() {
        return clientID;
    }

    public List<String> getLabels() {
        return labels;
    }

    public LocalDateTime getDateReleased() {
        return dateReleased;
    }

    public Long getOriginalMoveID() {
        return originalMoveID;
    }

    // IsType returns true if typeMovement is equal than movement type, else false.
    public boolean isType(String typeMovement) {
        return this.getMovementType() != null && this.getMovementType().equals(typeMovement);
    }

    // IsFinancialEntity returns true if financialEntity is equal than movement financialEntity, else false.
    public boolean isFinancialEntity(String financialEntity) {
        return this.getFinancialEntity() != null && financialEntity.equals(this.getFinancialEntity());
    }

    // HasDetail returns true if any of the details is equal than movement detail, else false.
    public boolean hasDetail(String[] details) {
        for (String detail : details) {
            if (this.getDetail() != null && this.getDetail() == detail) {
                return true;
            }
        }
        return false;
    }

    // HasAnyLabel returns true if any of the labels is contained by the labels of the movement
    public boolean hasAnyLabel(String[] labels) {
        for (String label : labels) {
            for (String movLabel : this.getLabels()) {
                if (movLabel != null && movLabel.equals(label)) {
                    return true;
                }
            }
        }
        return false;
    }

    // HasClientID returns true if any of the clientIDs is equal than movement ClientID, else false.
    public boolean hasClientID(Long[] clientIDs) {
        for (Long clientID : clientIDs) {
            if this.getClientID() != null && this.getClientID().equals(clientID) {
                return true
            }
        }

        return false
    }

    // HasSiteID returns true if any of the siteIds are equal to the one of the movement, otherwise return false
    public boolean hasSiteID(String[] siteIDs) {
        for (String siteID :siteIDs) {
            if (this.getSiteID() != null && this.getSiteID().equals(siteID)) {
                return true;
            }
        }

        return false;
    }

    // IsFee returns if the movement type is a fee
    public boolean isFee() {
        return this.isType(TypeFee);
    }

    // IsIncome returns if the movement type is a income
    public boolean isIncome() {
        return this.IsType(TypeIncome)
    }

    // IsIncomePayment returns if the movement is an income and detail is payment
    public boolean isIncomePayment() {
        return this.IsIncome() && this.HasDetail(DetailPayment)
    }

    // IsFinancialFee returns if the movement is a fee and detail is payment_fund or financing_rate
    public boolean isFinancialFee() {
        return this.IsFee() && this.HasDetail(DetailPaymentFund, DetailFinancingRate)
    }

    // IsShippingFee returns if the movement is a fee and detail is shipping_fmb, shipping, shipping_ds,
// or shipping_ff, shipping_mp, shipping_xd, subsidized_shipping_cbt
    public boolean isShippingFee() {
        return this.IsFee() && this.HasDetail(DetailShippingFMB, DetailShipping, DetailShippingDS, DetailShippingFF, DetailShippingXD, DetailShippingMP, DetailSubsidizedShippingCBT)
    }

    // IsIncomeCoupon returns if the movement type is income and financial entity is a coupon
    public boolean isIncomeCoupon() {
        return this.IsIncome() && this.IsFinancialEntity(FinancialEntityCoupon)
    }

    // IsCouponFee returns if the movement type is fee and financial entity is a coupon
    public boolean isCouponFee() {
        return this.IsFee() && this.IsFinancialEntity(FinancialEntityCoupon)
    }

    // IsTax returns if the movement detail is tax_with_holding and its financial entity is not Iget
    public boolean isTax() {
        return this.HasDetail(DetailTaxWithholding) && !this.IsFinancialEntity(FinancialEntityIget)
    }

    // IsMercadoPagoFee returns if the movement is a fee and its detail is account_fund, payment, mp_fee, payment_addition, money_transfer or special_fee.
    public boolean isMercadoPagoFee() {
        return this.IsFee() && this.HasDetail(DetailAccountFund, DetailPayment, DetailMPFee, DetailPaymentAddition, DetailMoneyTransfer, DetailSpecialFee)
    }

    // IsMarketplaceFee returns if the movement is a fee and its detail is meli_charge, ml_fee or meli_fee.
    public boolean isMarketplaceFee() {
        return this.IsFee() && this.HasDetail(DetailMELICharge, DetailMLFee, DetailMELIFee)
    }

    // IsChargebackCancellation returns true if the movement has CBKRecovery detail and a cancellation label
    public boolean isChargebackCancellation() {
        return this.HasDetail(DetailCBKRecovery) && this.isCancellation()
    }

    // IsChargeback returns true if the movement has CBKRecovery detail and doesn't have a  cancellation label
    public boolean isChargeback() {
        return this.HasDetail(DetailCBKRecovery) && !this.isCancellation()
    }

    // IsPayment returns true if the movement has payment detail
    public boolean isPayment() {
        return this.HasDetail(DetailPayment)
    }

    // ContainsWithdraw returns true if the movement has withdraw detail
    func(m *Movement) ContainsWithdraw()

    {
        return this.HasDetail(DetailWithdraw)
    }

    // IsCommissionForAdvance returns true if the movement is type fee and has the release in advance detail and have the comission client ID
    public boolean isCommissionForAdvance() {
        return this.IsType(TypeFee) && this.HasDetail(DetailReleaseInAdvance) && this.HasClientID(MovementClientIDCommission)
    }

    // IsExpenseOrIncome returns true if the movement is type expense or income
    public boolean isExpenseOrIncome() {
        return this.IsType(TypeExpense) || this.IsType(TypeIncome)
    }

    // IsExpense returns true if the movement is type expense
    public boolean isExpense() {
        return this.IsType(TypeExpense)
    }

    // IsCredit returns true if the movement has credit detail
    public boolean isCredit() {
        return this.HasDetail(DetailCredit)
    }

    // IsMerchantCredit returns true if the movement has merchantCredit detail
    public boolean isMerchantCredit() {
        return this.HasDetail(DetailMerchantCredit)
    }

    // IsMediation returns true if the movement has Mediation detail
    public boolean isMediation() {
        return this.HasDetail(DetailMediation) //MovementDetailMediation
    }

    public boolean isCancellation() {
        return this.HasAnyLabel(LabelCancellation)
    }

    public boolean isPartial() {
        return this.HasAnyLabel(LabelPartial)
    }

    // IsPartialRefund returns true if the movement has the label IsCancellation and the label partial
    public boolean isPartialRefund() {
        return this.isCancellation() && this.isPartial()
    }

    // IsFullRefund returns true if the movement has the label IsCancellation and doesn't have the label partial
    public boolean isFullRefund() {
        return this.isCancellation() && !this.isPartial()
    }

    // IsMoneyTransfer returns true if the movement has the money transfer detail
    public boolean isMoneyTransfer() {
        return this.HasDetail(DetailMoneyTransfer)
    }

    // IsSpecialFund returns true if the movement is type fund and has special fund detail
    public boolean isSpecialFund() {
        return this.IsType(TypeFund) && this.HasDetail(DetailSpecialFund)
    }

    // IsFundShipping returns true if the movement is type fund and has shipping fpp detail
    public boolean isFundShipping() {
        return this.IsType(TypeFund) && this.HasDetail(DetailShippingFPP)
    }
*/

    public static final class Builder {
        private Long id;
        private Long userID;
        private Long referenceID;
        private BigDecimal amount;
        private String currencyID;
        private String detail;
        private LocalDateTime dateCreated;
        private String movementType;
        private String financialEntity;
        private String siteID;
        private Long clientID;
        private List<String> labels;
        private LocalDateTime dateReleased;
        private Long originalMoveID;

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withUserID(Long userID) {
            this.userID = userID;
            return this;
        }

        public Builder withReferenceID(Long referenceID) {
            this.referenceID = referenceID;
            return this;
        }

        public Builder withAmount(BigDecimal amount) {
            this.amount = amount;
            return this;
        }

        public Builder withCurrencyID(String currencyID) {
            this.currencyID = currencyID;
            return this;
        }

        public Builder withDetail(String detail) {
            this.detail = detail;
            return this;
        }

        public Builder withDateCreated(LocalDateTime dateCreated) {
            this.dateCreated = dateCreated;
            return this;
        }

        public Builder withMovementType(String movementType) {
            this.movementType = movementType;
            return this;
        }

        public Builder withFinancialEntity(String financialEntity) {
            this.financialEntity = financialEntity;
            return this;
        }

        public Builder withSiteID(String siteID) {
            this.siteID = siteID;
            return this;
        }

        public Builder withClientID(Long clientID) {
            this.clientID = clientID;
            return this;
        }

        public Builder withLabels(List<String> labels) {
            this.labels = labels;
            return this;
        }

        public Builder withDateReleased(LocalDateTime dateReleased) {
            this.dateReleased = dateReleased;
            return this;
        }

        public Builder withOriginalMoveID(Long originalMoveID) {
            this.originalMoveID = originalMoveID;
            return this;
        }

        public Movement build() {
            return new Movement(this);
        }
    }
}
