package com.meli.reporting.example.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Payment {

    private Long id;
    private LocalDateTime dateApproved;
    private String marketplace;
    private String splitterID;
    private BigDecimal totalPaidAmount;
    private Long installments;
    private String paymentTypeID;
    private String paymentMethodID;
    private String orderID;
    private UserInformation collector;
    private UserInformation payer;
    private String conceptID;
    private String externalReference;
    private String internalMetadataConcept;

    public Payment(Builder builder) {
        this.id = builder.id;
        this.dateApproved = builder.dateApproved;
        this.marketplace = builder.marketplace;
        this.splitterID = builder.splitterID;
        this.totalPaidAmount = builder.totalPaidAmount;
        this.installments = builder.installments;
        this.paymentTypeID = builder.paymentTypeID;
        this.paymentMethodID = builder.paymentMethodID;
        this.orderID = builder.orderID;
        this.collector = builder.collector;
        this.payer = builder.payer;
        this.conceptID = builder.conceptID;
        this.externalReference = builder.externalReference;
        this.internalMetadataConcept = builder.internalMetadataConcept;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getDateApproved() {
        return dateApproved;
    }

    public String getMarketplace() {
        return marketplace;
    }

    public String getSplitterID() {
        return splitterID;
    }

    public BigDecimal getTotalPaidAmount() {
        return totalPaidAmount;
    }

    public Long getInstallments() {
        return installments;
    }

    public String getPaymentTypeID() {
        return paymentTypeID;
    }

    public String getPaymentMethodID() {
        return paymentMethodID;
    }

    public String getOrderID() {
        return orderID;
    }

    public UserInformation getCollector() {
        return collector;
    }

    public UserInformation getPayer() {
        return payer;
    }

    public String getConceptID() {
        return conceptID;
    }

    public String getExternalReference() {
        return externalReference;
    }

    public String getInternalMetadataConcept() {
        return internalMetadataConcept;
    }

    static final class Builder {
        private Long id;
        private LocalDateTime dateApproved;
        private String marketplace;
        private String splitterID;
        private BigDecimal totalPaidAmount;
        private Long installments;
        private String paymentTypeID;
        private String paymentMethodID;
        private String orderID;
        private UserInformation collector;
        private UserInformation payer;
        private String conceptID;
        private String externalReference;
        private String internalMetadataConcept;

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withDateApproved(LocalDateTime dateApproved) {
            this.dateApproved = dateApproved;
            return this;
        }

        public Builder withMarketplace(String marketplace) {
            this.marketplace = marketplace;
            return this;
        }

        public Builder withSplitterID(String splitterID) {
            this.splitterID = splitterID;
            return this;
        }

        public Builder withTotalPaidAmount(BigDecimal totalPaidAmount) {
            this.totalPaidAmount = totalPaidAmount;
            return this;
        }

        public Builder withInstallments(Long installments) {
            this.installments = installments;
            return this;
        }

        public Builder withPaymentTypeID(String paymentTypeID) {
            this.paymentTypeID = paymentTypeID;
            return this;
        }

        public Builder withPaymentMethodID(String paymentMethodID) {
            this.paymentMethodID = paymentMethodID;
            return this;
        }

        public Builder withOrderID(String orderID) {
            this.orderID = orderID;
            return this;
        }

        public Builder withCollector(UserInformation collector) {
            this.collector = collector;
            return this;
        }

        public Builder withPayer(UserInformation payer) {
            this.payer = payer;
            return this;
        }

        public Builder withConceptID(String conceptID) {
            this.conceptID = conceptID;
            return this;
        }

        public Builder withExternalReference(String externalReference) {
            this.externalReference = externalReference;
            return this;
        }

        public Builder withInternalMetadataConcept(String internalMetadataConcept) {
            this.internalMetadataConcept = internalMetadataConcept;
            return this;
        }

        public Payment build() {
            return new Payment(this);
        }
    }
}
