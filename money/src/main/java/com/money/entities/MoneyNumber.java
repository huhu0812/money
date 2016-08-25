package com.money.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class MoneyNumber
  implements Serializable
{
  private static final long serialVersionUID = 5541822813701375535L;
  @Id
  @GeneratedValue
  private Long id;
  @Column(length=14)
  private String date;
  @OneToOne
  @JoinColumn(name="number_id")
  private OriginalNumber number;
  
  public Long getId()
  {
    return this.id;
  }
  
  public void setId(Long id)
  {
    this.id = id;
  }
  
  public String getDate()
  {
    return this.date;
  }
  
  public void setDate(String date)
  {
    this.date = date;
  }
  
  public OriginalNumber getNumber()
  {
    return this.number;
  }
  
  public void setNumber(OriginalNumber number)
  {
    this.number = number;
  }
}