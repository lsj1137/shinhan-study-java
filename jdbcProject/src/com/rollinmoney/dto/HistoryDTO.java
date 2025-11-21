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
public class HistoryDTO {
	long historyId;
	long memberId;
	Date recordDate;
	BigDecimal total_asset;
}
