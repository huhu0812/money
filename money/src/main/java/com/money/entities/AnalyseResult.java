package com.money.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.money.utils.enums.AppeareType;

@Entity
public class AnalyseResult implements Serializable {
	private static final long serialVersionUID = -4907662459816805371L;
	@Id
	@GeneratedValue
	private Long id;
	@Enumerated(EnumType.STRING)
	@Column(length = 5, nullable = false)
	private AppeareType type;
	@Column(length = 18)
	private double r01;
	@Column(length = 18)
	private double r02;
	@Column(length = 18)
	private double r03;
	@Column(length = 18)
	private double r04;
	@Column(length = 18)
	private double r05;
	@Column(length = 18)
	private double r06;
	@Column(length = 18)
	private double r07;
	@Column(length = 18)
	private double r08;
	@Column(length = 18)
	private double r09;
	@Column(length = 18)
	private double r10;
	@Column(length = 18)
	private double r11;
	@Column(length = 18)
	private double r12;
	@Column(length = 18)
	private double r13;
	@Column(length = 18)
	private double r14;
	@Column(length = 18)
	private double r15;
	@Column(length = 18)
	private double r16;
	@Column(length = 18)
	private double r17;
	@Column(length = 18)
	private double r18;
	@Column(length = 18)
	private double r19;
	@Column(length = 18)
	private double r20;
	@Column(length = 18)
	private double r21;
	@Column(length = 18)
	private double r22;
	@Column(length = 18)
	private double r23;
	@Column(length = 18)
	private double r24;
	@Column(length = 18)
	private double r25;
	@Column(length = 18)
	private double r26;
	@Column(length = 18)
	private double r27;
	@Column(length = 18)
	private double r28;
	@Column(length = 18)
	private double r29;
	@Column(length = 18)
	private double r30;
	@Column(length = 18)
	private double r31;
	@Column(length = 18)
	private double r32;
	@Column(length = 18)
	private double r33;
	@Column(length = 18)
	private double b01;
	@Column(length = 18)
	private double b02;
	@Column(length = 18)
	private double b03;
	@Column(length = 18)
	private double b04;
	@Column(length = 18)
	private double b05;
	@Column(length = 18)
	private double b06;
	@Column(length = 18)
	private double b07;
	@Column(length = 18)
	private double b08;
	@Column(length = 18)
	private double b09;
	@Column(length = 18)
	private double b10;
	@Column(length = 18)
	private double b11;
	@Column(length = 18)
	private double b12;
	@Column(length = 18)
	private double b13;
	@Column(length = 18)
	private double b14;
	@Column(length = 18)
	private double b15;
	@Column(length = 18)
	private double b16;

	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedTime = new Date();

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AppeareType getType() {
		return this.type;
	}

	public void setType(AppeareType type) {
		this.type = type;
	}

	public double getR01() {
		return this.r01;
	}

	public void setR01(double r01) {
		this.r01 = r01;
	}

	public double getR02() {
		return this.r02;
	}

	public void setR02(double r02) {
		this.r02 = r02;
	}

	public double getR03() {
		return this.r03;
	}

	public void setR03(double r03) {
		this.r03 = r03;
	}

	public double getR04() {
		return this.r04;
	}

	public void setR04(double r04) {
		this.r04 = r04;
	}

	public double getR05() {
		return this.r05;
	}

	public void setR05(double r05) {
		this.r05 = r05;
	}

	public double getR06() {
		return this.r06;
	}

	public void setR06(double r06) {
		this.r06 = r06;
	}

	public double getR07() {
		return this.r07;
	}

	public void setR07(double r07) {
		this.r07 = r07;
	}

	public double getR08() {
		return this.r08;
	}

	public void setR08(double r08) {
		this.r08 = r08;
	}

	public double getR09() {
		return this.r09;
	}

	public void setR09(double r09) {
		this.r09 = r09;
	}

	public double getR10() {
		return this.r10;
	}

	public void setR10(double r10) {
		this.r10 = r10;
	}

	public double getR11() {
		return this.r11;
	}

	public void setR11(double r11) {
		this.r11 = r11;
	}

	public double getR12() {
		return this.r12;
	}

	public void setR12(double r12) {
		this.r12 = r12;
	}

	public double getR13() {
		return this.r13;
	}

	public void setR13(double r13) {
		this.r13 = r13;
	}

	public double getR14() {
		return this.r14;
	}

	public void setR14(double r14) {
		this.r14 = r14;
	}

	public double getR15() {
		return this.r15;
	}

	public void setR15(double r15) {
		this.r15 = r15;
	}

	public double getR16() {
		return this.r16;
	}

	public void setR16(double r16) {
		this.r16 = r16;
	}

	public double getR17() {
		return this.r17;
	}

	public void setR17(double r17) {
		this.r17 = r17;
	}

	public double getR18() {
		return this.r18;
	}

	public void setR18(double r18) {
		this.r18 = r18;
	}

	public double getR19() {
		return this.r19;
	}

	public void setR19(double r19) {
		this.r19 = r19;
	}

	public double getR20() {
		return this.r20;
	}

	public void setR20(double r20) {
		this.r20 = r20;
	}

	public double getR21() {
		return this.r21;
	}

	public void setR21(double r21) {
		this.r21 = r21;
	}

	public double getR22() {
		return this.r22;
	}

	public void setR22(double r22) {
		this.r22 = r22;
	}

	public double getR23() {
		return this.r23;
	}

	public void setR23(double r23) {
		this.r23 = r23;
	}

	public double getR24() {
		return this.r24;
	}

	public void setR24(double r24) {
		this.r24 = r24;
	}

	public double getR25() {
		return this.r25;
	}

	public void setR25(double r25) {
		this.r25 = r25;
	}

	public double getR26() {
		return this.r26;
	}

	public void setR26(double r26) {
		this.r26 = r26;
	}

	public double getR27() {
		return this.r27;
	}

	public void setR27(double r27) {
		this.r27 = r27;
	}

	public double getR28() {
		return this.r28;
	}

	public void setR28(double r28) {
		this.r28 = r28;
	}

	public double getR29() {
		return this.r29;
	}

	public void setR29(double r29) {
		this.r29 = r29;
	}

	public double getR30() {
		return this.r30;
	}

	public void setR30(double r30) {
		this.r30 = r30;
	}

	public double getR31() {
		return this.r31;
	}

	public void setR31(double r31) {
		this.r31 = r31;
	}

	public double getR32() {
		return this.r32;
	}

	public void setR32(double r32) {
		this.r32 = r32;
	}

	public double getR33() {
		return this.r33;
	}

	public void setR33(double r33) {
		this.r33 = r33;
	}

	public double getB01() {
		return this.b01;
	}

	public void setB01(double b01) {
		this.b01 = b01;
	}

	public double getB02() {
		return this.b02;
	}

	public void setB02(double b02) {
		this.b02 = b02;
	}

	public double getB03() {
		return this.b03;
	}

	public void setB03(double b03) {
		this.b03 = b03;
	}

	public double getB04() {
		return this.b04;
	}

	public void setB04(double b04) {
		this.b04 = b04;
	}

	public double getB05() {
		return this.b05;
	}

	public void setB05(double b05) {
		this.b05 = b05;
	}

	public double getB06() {
		return this.b06;
	}

	public void setB06(double b06) {
		this.b06 = b06;
	}

	public double getB07() {
		return this.b07;
	}

	public void setB07(double b07) {
		this.b07 = b07;
	}

	public double getB08() {
		return this.b08;
	}

	public void setB08(double b08) {
		this.b08 = b08;
	}

	public double getB09() {
		return this.b09;
	}

	public void setB09(double b09) {
		this.b09 = b09;
	}

	public double getB10() {
		return this.b10;
	}

	public void setB10(double b10) {
		this.b10 = b10;
	}

	public double getB11() {
		return this.b11;
	}

	public void setB11(double b11) {
		this.b11 = b11;
	}

	public double getB12() {
		return this.b12;
	}

	public void setB12(double b12) {
		this.b12 = b12;
	}

	public double getB13() {
		return this.b13;
	}

	public void setB13(double b13) {
		this.b13 = b13;
	}

	public double getB14() {
		return this.b14;
	}

	public void setB14(double b14) {
		this.b14 = b14;
	}

	public double getB15() {
		return this.b15;
	}

	public void setB15(double b15) {
		this.b15 = b15;
	}

	public double getB16() {
		return this.b16;
	}

	public void setB16(double b16) {
		this.b16 = b16;
	}

	public Date getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}

	@Override
	public String toString() {
		return "AnalyseResult [id=" + id + ", type=" + type + ", r01=" + r01 + ", r02=" + r02 + ", r03=" + r03
				+ ", r04=" + r04 + ", r05=" + r05 + ", r06=" + r06 + ", r07=" + r07 + ", r08=" + r08 + ", r09=" + r09
				+ ", r10=" + r10 + ", r11=" + r11 + ", r12=" + r12 + ", r13=" + r13 + ", r14=" + r14 + ", r15=" + r15
				+ ", r16=" + r16 + ", r17=" + r17 + ", r18=" + r18 + ", r19=" + r19 + ", r20=" + r20 + ", r21=" + r21
				+ ", r22=" + r22 + ", r23=" + r23 + ", r24=" + r24 + ", r25=" + r25 + ", r26=" + r26 + ", r27=" + r27
				+ ", r28=" + r28 + ", r29=" + r29 + ", r30=" + r30 + ", r31=" + r31 + ", r32=" + r32 + ", r33=" + r33
				+ ", b01=" + b01 + ", b02=" + b02 + ", b03=" + b03 + ", b04=" + b04 + ", b05=" + b05 + ", b06=" + b06
				+ ", b07=" + b07 + ", b08=" + b08 + ", b09=" + b09 + ", b10=" + b10 + ", b11=" + b11 + ", b12=" + b12
				+ ", b13=" + b13 + ", b14=" + b14 + ", b15=" + b15 + ", b16=" + b16 + ", updatedTime=" + updatedTime
				+ "]";
	}
}
