package com.rollinmoney.dto;

import java.math.BigDecimal;
import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter @Setter
public class HoldingDTO {
	long holdingId;
	long productId;
	String productType;
	long memberId;
	Integer quantity;
	Date buyDate;
	BigDecimal buyPrice;
	BigDecimal buyAmount;
	Date maturedAt;
	
}
