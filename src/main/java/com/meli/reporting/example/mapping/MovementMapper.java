package com.meli.reporting.example.mapping;

import com.meli.reporting.example.domain.Movement;
import com.meli.reporting.example.domain.Payment;

import java.math.BigDecimal;
import java.util.List;

/*

// MapTotalFeeAmount returns the total fee amount from the payment
func MapTotalFeeAmount(movements coredto.Movements) (feeAmount corenullable.NullableDecimal) {
	filter := func(movement *coredto.Movement) bool {
		return movement.IsFee()
	}

	return movements.SumAmount(filter)
}

// MapFinancialFeeAmount returns the total financial fee amount from the payment.
// Sums all financial fee movements.
func MapFinancialFeeAmount(movements coredto.Movements) (feeAmount corenullable.NullableDecimal) {
	filter := func(movement *coredto.Movement) bool {
		return movement.IsFinancialFee()
	}

	return movements.SumAmount(filter)
}

// MapShippingFeeAmount returns the total shipping fee amount from the payment.
// Sums all shipping fee movements.
func MapShippingFeeAmount(movements coredto.Movements) (feeAmount corenullable.NullableDecimal) {
	filter := func(movement *coredto.Movement) bool {
		return movement.IsShippingFee()
	}

	return movements.SumAmount(filter)
}

// MapTaxAmount returns the total tax amount from the payment.
// Sums all tax movements.
func MapTaxAmount(movements coredto.Movements) (feeAmount corenullable.NullableDecimal) {
	filter := func(movement *coredto.Movement) bool {
		return movement.IsTax()
	}

	return movements.SumAmount(filter)
}

// MapIncomeCouponAmount returns the total income coupons amount from the payment.
// Sums all income coupons movements (coupons absorbed by MELI).
func MapIncomeCouponAmount(movements coredto.Movements) (incomeCouponAmount corenullable.NullableDecimal) {
	filter := func(movement *coredto.Movement) bool {
		return movement.IsIncomeCoupon()
	}

	return movements.SumAmount(filter)
}

// MapCouponFeeAmount returns the total fee coupons amount from the payment.
// Sums all fee coupons movements (coupons absorbed by seller).
func MapCouponFeeAmount(movements coredto.Movements) (couponFeeAmount corenullable.NullableDecimal) {
	filter := func(movement *coredto.Movement) bool {
		return movement.IsCouponFee()
	}

	return movements.SumAmount(filter)
}

// MapMercadoPagoFeeAmount returns the total mercado pago fee amount from the payment.
// Sums all mercado pago fee movements.
func MapMercadoPagoFeeAmount(movements coredto.Movements) (feeAmount corenullable.NullableDecimal) {
	filter := func(movement *coredto.Movement) bool {
		return movement.IsMercadoPagoFee()
	}

	return movements.SumAmount(filter)
}

// MapMarketplaceFeeAmount returns the total marketplace fee amount from the payment.
// Sums all marketplace fee movements.
func MapMarketplaceFeeAmount(movements coredto.Movements) (feeAmount corenullable.NullableDecimal) {
	filter := func(movement *coredto.Movement) bool {
		return movement.IsMarketplaceFee()
	}

	return movements.SumAmount(filter)
}

// MapExternalReference returns the external reference of the payment.
func MapExternalReference(payment coredto.Payment) corenullable.NullableString {
	return payment.ExternalReference()
}

// MapSiteID returns the site id of the payment.
func MapSiteID(payment coredto.Payment) (siteID corenullable.NullableString) {
	if len(payment.Movements()) > 0 {
		anyMovement := payment.Movements()[0]
		siteID = anyMovement.SiteID()
	}
	return
}

// MapInstallments returns the installments of the payment.
func MapInstallments(payment coredto.Payment) corenullable.NullableInt64 {
	return payment.Installments()
}

// MapPaymentTypeID returns the payment type id of the payment.
func MapPaymentTypeID(payment coredto.Payment) corenullable.NullableString {
	return payment.PaymentTypeID()
}

// MapPaymentMethodID returns the payment method id of the payment.
func MapPaymentMethodID(payment coredto.Payment) corenullable.NullableString {
	return payment.PaymentMethodID()
}

// MapDateApproved returns the date approved of the payment.
func MapDateApproved(payment coredto.Payment) corenullable.NullableTime {
	return payment.DateApproved()
}

// MapOrderID returns the order id of the payment.
func MapOrderID(payment coredto.Payment) corenullable.NullableString {
	return payment.OrderID()
}

// MapTotalAmount returns the sum of all the movements amount of a payment
func MapTotalAmount(movements coredto.Movements) corenullable.NullableDecimal {
	filter := func(movement *coredto.Movement) bool {
		return true
	}

	return movements.SumAmount(filter)
}

// MapCurrencyID returns attribute currency id in movement.
func MapCurrencyID(payment coredto.Payment) (currencyID corenullable.NullableString) {
	if len(payment.Movements()) > 0 {
		anyMovement := payment.Movements()[0]
		currencyID = anyMovement.CurrencyID()
	}
	return
}

// MapReleasedDate returns the last released created date from the movements of the payment
func MapReleasedDate(movements coredto.Movements) (releasedDate corenullable.NullableTime) {
	for _, m := range movements {
		currentReleaseDate := m.DateCreated()
		if m.DateReleased().HasValue() {
			currentReleaseDate = m.DateReleased()
		}
		if !releasedDate.HasValue() {
			releasedDate = currentReleaseDate
		} else if currentReleaseDate.Value().After(releasedDate.Value()) {
			releasedDate = currentReleaseDate
		}
	}
	return
}

 */
public class MovementMapper {

    /**
     * returns the id of the payment
     * @param payment
     * @return the payment id
     */
    public Long mapPaymentID(Payment payment) {
        return payment.getId();
    }

    /**
     * returns the amount of the movement of type income payment
     * @param movements
     * @return
     */
    public BigDecimal mapIncomePaymentAmount(List<Movement> movements){
        return movements.stream()
                .filter(Movement::isIncome)
                .map(Movement::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

}