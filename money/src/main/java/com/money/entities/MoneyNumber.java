package com.money.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class MoneyNumber implements Serializable {

	private static final long serialVersionUID = 5541822813701375535L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(length = 14)
	private String date;

	@Column(length = 20)
	private String index;

	@ManyToOne
	@JoinColumn(name = "red_id")
	private Red red;

	@Column(length = 2)
	private String blue;

	@Column(length = 2)
	private String r01;
	@Column(length = 2)
	private String r02;
	@Column(length = 2)
	private String r03;
	@Column(length = 2)
	private String r04;
	@Column(length = 2)
	private String r05;
	@Column(length = 2)
	private String r06;
	@Column(length = 2)
	private String r07;
	@Column(length = 2)
	private String r08;
	@Column(length = 2)
	private String r09;
	@Column(length = 2)
	private String r10;
	@Column(length = 2)
	private String r11;
	@Column(length = 2)
	private String r12;
	@Column(length = 2)
	private String r13;
	@Column(length = 2)
	private String r14;
	@Column(length = 2)
	private String r15;
	@Column(length = 2)
	private String r16;
	@Column(length = 2)
	private String r17;
	@Column(length = 2)
	private String r18;
	@Column(length = 2)
	private String r19;
	@Column(length = 2)
	private String r20;
	@Column(length = 2)
	private String r21;
	@Column(length = 2)
	private String r22;
	@Column(length = 2)
	private String r23;
	@Column(length = 2)
	private String r24;
	@Column(length = 2)
	private String r25;
	@Column(length = 2)
	private String r26;
	@Column(length = 2)
	private String r27;
	@Column(length = 2)
	private String r28;
	@Column(length = 2)
	private String r29;
	@Column(length = 2)
	private String r30;
	@Column(length = 2)
	private String r31;
	@Column(length = 2)
	private String r32;
	@Column(length = 2)
	private String r33;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public Red getRed() {
		return red;
	}

	public void setRed(Red red) {
		this.red = red;
	}

	public String getBlue() {
		return blue;
	}

	public void setBlue(String blue) {
		this.blue = blue;
	}

	public String getR01() {
		return r01;
	}

	public void setR01(String r01) {
		this.r01 = r01;
	}

	public String getR02() {
		return r02;
	}

	public void setR02(String r02) {
		this.r02 = r02;
	}

	public String getR03() {
		return r03;
	}

	public void setR03(String r03) {
		this.r03 = r03;
	}

	public String getR04() {
		return r04;
	}

	public void setR04(String r04) {
		this.r04 = r04;
	}

	public String getR05() {
		return r05;
	}

	public void setR05(String r05) {
		this.r05 = r05;
	}

	public String getR06() {
		return r06;
	}

	public void setR06(String r06) {
		this.r06 = r06;
	}

	public String getR07() {
		return r07;
	}

	public void setR07(String r07) {
		this.r07 = r07;
	}

	public String getR08() {
		return r08;
	}

	public void setR08(String r08) {
		this.r08 = r08;
	}

	public String getR09() {
		return r09;
	}

	public void setR09(String r09) {
		this.r09 = r09;
	}

	public String getR10() {
		return r10;
	}

	public void setR10(String r10) {
		this.r10 = r10;
	}

	public String getR11() {
		return r11;
	}

	public void setR11(String r11) {
		this.r11 = r11;
	}

	public String getR12() {
		return r12;
	}

	public void setR12(String r12) {
		this.r12 = r12;
	}

	public String getR13() {
		return r13;
	}

	public void setR13(String r13) {
		this.r13 = r13;
	}

	public String getR14() {
		return r14;
	}

	public void setR14(String r14) {
		this.r14 = r14;
	}

	public String getR15() {
		return r15;
	}

	public void setR15(String r15) {
		this.r15 = r15;
	}

	public String getR16() {
		return r16;
	}

	public void setR16(String r16) {
		this.r16 = r16;
	}

	public String getR17() {
		return r17;
	}

	public void setR17(String r17) {
		this.r17 = r17;
	}

	public String getR18() {
		return r18;
	}

	public void setR18(String r18) {
		this.r18 = r18;
	}

	public String getR19() {
		return r19;
	}

	public void setR19(String r19) {
		this.r19 = r19;
	}

	public String getR20() {
		return r20;
	}

	public void setR20(String r20) {
		this.r20 = r20;
	}

	public String getR21() {
		return r21;
	}

	public void setR21(String r21) {
		this.r21 = r21;
	}

	public String getR22() {
		return r22;
	}

	public void setR22(String r22) {
		this.r22 = r22;
	}

	public String getR23() {
		return r23;
	}

	public void setR23(String r23) {
		this.r23 = r23;
	}

	public String getR24() {
		return r24;
	}

	public void setR24(String r24) {
		this.r24 = r24;
	}

	public String getR25() {
		return r25;
	}

	public void setR25(String r25) {
		this.r25 = r25;
	}

	public String getR26() {
		return r26;
	}

	public void setR26(String r26) {
		this.r26 = r26;
	}

	public String getR27() {
		return r27;
	}

	public void setR27(String r27) {
		this.r27 = r27;
	}

	public String getR28() {
		return r28;
	}

	public void setR28(String r28) {
		this.r28 = r28;
	}

	public String getR29() {
		return r29;
	}

	public void setR29(String r29) {
		this.r29 = r29;
	}

	public String getR30() {
		return r30;
	}

	public void setR30(String r30) {
		this.r30 = r30;
	}

	public String getR31() {
		return r31;
	}

	public void setR31(String r31) {
		this.r31 = r31;
	}

	public String getR32() {
		return r32;
	}

	public void setR32(String r32) {
		this.r32 = r32;
	}

	public String getR33() {
		return r33;
	}

	public void setR33(String r33) {
		this.r33 = r33;
	}

	@Override
	public String toString() {
		return "MoneyNumber [id=" + id + ", date=" + date + ", index=" + index + ", red=" + red + ", blue=" + blue
				+ ", r01=" + r01 + ", r02=" + r02 + ", r03=" + r03 + ", r04=" + r04 + ", r05=" + r05 + ", r06=" + r06
				+ ", r07=" + r07 + ", r08=" + r08 + ", r09=" + r09 + ", r10=" + r10 + ", r11=" + r11 + ", r12=" + r12
				+ ", r13=" + r13 + ", r14=" + r14 + ", r15=" + r15 + ", r16=" + r16 + ", r17=" + r17 + ", r18=" + r18
				+ ", r19=" + r19 + ", r20=" + r20 + ", r21=" + r21 + ", r22=" + r22 + ", r23=" + r23 + ", r24=" + r24
				+ ", r25=" + r25 + ", r26=" + r26 + ", r27=" + r27 + ", r28=" + r28 + ", r29=" + r29 + ", r30=" + r30
				+ ", r31=" + r31 + ", r32=" + r32 + ", r33=" + r33 + "]";
	}

}
