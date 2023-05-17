package org.a204.hourgoods.domain.deal.exception;

import org.a204.hourgoods.global.error.GlobalBaseException;
import org.a204.hourgoods.global.error.GlobalErrorCode;

public class TradeLocationNotFoundException extends GlobalBaseException {
	public TradeLocationNotFoundException() {
		super(GlobalErrorCode.TRADE_LOCATION_NOT_FOUND);
	}
}
