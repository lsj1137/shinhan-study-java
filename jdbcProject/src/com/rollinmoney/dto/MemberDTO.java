package com.rollinmoney.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter @Setter
public class MemberDTO {
	Long memberId;
	BigDecimal cash;
}
