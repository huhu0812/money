package com.money.entities;

import com.money.utils.enums.AppeareType;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class AnalyseResult
  implements Serializable
{
  private static final long serialVersionUID = -4907662459816805371L;
  @Id
  @GeneratedValue
  private Long id;
  @Enumerated(EnumType.STRING)
  @Column(length=5, nullable=false)
  private AppeareType type;
  @Column(length=6)
  private int r01;
  @Column(length=6)
  private int r02;
  @Column(length=6)
  private int r03;
  @Column(length=6)
  private int r04;
  @Column(length=6)
  private int r05;
  @Column(length=6)
  private int r06;
  @Column(length=6)
  private int r07;
  @Column(length=6)
  private int r08;
  @Column(length=6)
  private int r09;
  @Column(length=6)
  private int r10;
  @Column(length=6)
  private int r11;
  @Column(length=6)
  private int r12;
  @Column(length=6)
  private int r13;
  @Column(length=6)
  private int r14;
  @Column(length=6)
  private int r15;
  @Column(length=6)
  private int r16;
  @Column(length=6)
  private int r17;
  @Column(length=6)
  private int r18;
  @Column(length=6)
  private int r19;
  @Column(length=6)
  private int r20;
  @Column(length=6)
  private int r21;
  @Column(length=6)
  private int r22;
  @Column(length=6)
  private int r23;
  @Column(length=6)
  private int r24;
  @Column(length=6)
  private int r25;
  @Column(length=6)
  private int r26;
  @Column(length=6)
  private int r27;
  @Column(length=6)
  private int r28;
  @Column(length=6)
  private int r29;
  @Column(length=6)
  private int r30;
  @Column(length=6)
  private int r31;
  @Column(length=6)
  private int r32;
  @Column(length=6)
  private int r33;
  @Column(length=6)
  private int b01;
  @Column(length=6)
  private int b02;
  @Column(length=6)
  private int b03;
  @Column(length=6)
  private int b04;
  @Column(length=6)
  private int b05;
  @Column(length=6)
  private int b06;
  @Column(length=6)
  private int b07;
  @Column(length=6)
  private int b08;
  @Column(length=6)
  private int b09;
  @Column(length=6)
  private int b10;
  @Column(length=6)
  private int b11;
  @Column(length=6)
  private int b12;
  @Column(length=6)
  private int b13;
  @Column(length=6)
  private int b14;
  @Column(length=6)
  private int b15;
  @Column(length=6)
  private int b16;
  
  public Long getId()
  {
    return this.id;
  }
  
  public void setId(Long id)
  {
    this.id = id;
  }
  
  public AppeareType getType()
  {
    return this.type;
  }
  
  public void setType(AppeareType type)
  {
    this.type = type;
  }
  
  public int getR01()
  {
    return this.r01;
  }
  
  public void setR01(int r01)
  {
    this.r01 = r01;
  }
  
  public int getR02()
  {
    return this.r02;
  }
  
  public void setR02(int r02)
  {
    this.r02 = r02;
  }
  
  public int getR03()
  {
    return this.r03;
  }
  
  public void setR03(int r03)
  {
    this.r03 = r03;
  }
  
  public int getR04()
  {
    return this.r04;
  }
  
  public void setR04(int r04)
  {
    this.r04 = r04;
  }
  
  public int getR05()
  {
    return this.r05;
  }
  
  public void setR05(int r05)
  {
    this.r05 = r05;
  }
  
  public int getR06()
  {
    return this.r06;
  }
  
  public void setR06(int r06)
  {
    this.r06 = r06;
  }
  
  public int getR07()
  {
    return this.r07;
  }
  
  public void setR07(int r07)
  {
    this.r07 = r07;
  }
  
  public int getR08()
  {
    return this.r08;
  }
  
  public void setR08(int r08)
  {
    this.r08 = r08;
  }
  
  public int getR09()
  {
    return this.r09;
  }
  
  public void setR09(int r09)
  {
    this.r09 = r09;
  }
  
  public int getR10()
  {
    return this.r10;
  }
  
  public void setR10(int r10)
  {
    this.r10 = r10;
  }
  
  public int getR11()
  {
    return this.r11;
  }
  
  public void setR11(int r11)
  {
    this.r11 = r11;
  }
  
  public int getR12()
  {
    return this.r12;
  }
  
  public void setR12(int r12)
  {
    this.r12 = r12;
  }
  
  public int getR13()
  {
    return this.r13;
  }
  
  public void setR13(int r13)
  {
    this.r13 = r13;
  }
  
  public int getR14()
  {
    return this.r14;
  }
  
  public void setR14(int r14)
  {
    this.r14 = r14;
  }
  
  public int getR15()
  {
    return this.r15;
  }
  
  public void setR15(int r15)
  {
    this.r15 = r15;
  }
  
  public int getR16()
  {
    return this.r16;
  }
  
  public void setR16(int r16)
  {
    this.r16 = r16;
  }
  
  public int getR17()
  {
    return this.r17;
  }
  
  public void setR17(int r17)
  {
    this.r17 = r17;
  }
  
  public int getR18()
  {
    return this.r18;
  }
  
  public void setR18(int r18)
  {
    this.r18 = r18;
  }
  
  public int getR19()
  {
    return this.r19;
  }
  
  public void setR19(int r19)
  {
    this.r19 = r19;
  }
  
  public int getR20()
  {
    return this.r20;
  }
  
  public void setR20(int r20)
  {
    this.r20 = r20;
  }
  
  public int getR21()
  {
    return this.r21;
  }
  
  public void setR21(int r21)
  {
    this.r21 = r21;
  }
  
  public int getR22()
  {
    return this.r22;
  }
  
  public void setR22(int r22)
  {
    this.r22 = r22;
  }
  
  public int getR23()
  {
    return this.r23;
  }
  
  public void setR23(int r23)
  {
    this.r23 = r23;
  }
  
  public int getR24()
  {
    return this.r24;
  }
  
  public void setR24(int r24)
  {
    this.r24 = r24;
  }
  
  public int getR25()
  {
    return this.r25;
  }
  
  public void setR25(int r25)
  {
    this.r25 = r25;
  }
  
  public int getR26()
  {
    return this.r26;
  }
  
  public void setR26(int r26)
  {
    this.r26 = r26;
  }
  
  public int getR27()
  {
    return this.r27;
  }
  
  public void setR27(int r27)
  {
    this.r27 = r27;
  }
  
  public int getR28()
  {
    return this.r28;
  }
  
  public void setR28(int r28)
  {
    this.r28 = r28;
  }
  
  public int getR29()
  {
    return this.r29;
  }
  
  public void setR29(int r29)
  {
    this.r29 = r29;
  }
  
  public int getR30()
  {
    return this.r30;
  }
  
  public void setR30(int r30)
  {
    this.r30 = r30;
  }
  
  public int getR31()
  {
    return this.r31;
  }
  
  public void setR31(int r31)
  {
    this.r31 = r31;
  }
  
  public int getR32()
  {
    return this.r32;
  }
  
  public void setR32(int r32)
  {
    this.r32 = r32;
  }
  
  public int getR33()
  {
    return this.r33;
  }
  
  public void setR33(int r33)
  {
    this.r33 = r33;
  }
  
  public int getB01()
  {
    return this.b01;
  }
  
  public void setB01(int b01)
  {
    this.b01 = b01;
  }
  
  public int getB02()
  {
    return this.b02;
  }
  
  public void setB02(int b02)
  {
    this.b02 = b02;
  }
  
  public int getB03()
  {
    return this.b03;
  }
  
  public void setB03(int b03)
  {
    this.b03 = b03;
  }
  
  public int getB04()
  {
    return this.b04;
  }
  
  public void setB04(int b04)
  {
    this.b04 = b04;
  }
  
  public int getB05()
  {
    return this.b05;
  }
  
  public void setB05(int b05)
  {
    this.b05 = b05;
  }
  
  public int getB06()
  {
    return this.b06;
  }
  
  public void setB06(int b06)
  {
    this.b06 = b06;
  }
  
  public int getB07()
  {
    return this.b07;
  }
  
  public void setB07(int b07)
  {
    this.b07 = b07;
  }
  
  public int getB08()
  {
    return this.b08;
  }
  
  public void setB08(int b08)
  {
    this.b08 = b08;
  }
  
  public int getB09()
  {
    return this.b09;
  }
  
  public void setB09(int b09)
  {
    this.b09 = b09;
  }
  
  public int getB10()
  {
    return this.b10;
  }
  
  public void setB10(int b10)
  {
    this.b10 = b10;
  }
  
  public int getB11()
  {
    return this.b11;
  }
  
  public void setB11(int b11)
  {
    this.b11 = b11;
  }
  
  public int getB12()
  {
    return this.b12;
  }
  
  public void setB12(int b12)
  {
    this.b12 = b12;
  }
  
  public int getB13()
  {
    return this.b13;
  }
  
  public void setB13(int b13)
  {
    this.b13 = b13;
  }
  
  public int getB14()
  {
    return this.b14;
  }
  
  public void setB14(int b14)
  {
    this.b14 = b14;
  }
  
  public int getB15()
  {
    return this.b15;
  }
  
  public void setB15(int b15)
  {
    this.b15 = b15;
  }
  
  public int getB16()
  {
    return this.b16;
  }
  
  public void setB16(int b16)
  {
    this.b16 = b16;
  }
}
