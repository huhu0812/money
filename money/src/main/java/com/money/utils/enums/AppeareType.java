package com.money.utils.enums;

public enum AppeareType
{
  TEN("10", "last 10", 10),  FIFTEEN("15", "last 15", 15),  THRITY("30", "last 30", 30),  FIFTY("50", "last 50", 50),  HUNDRED("100", "last 100", 100),  ALL("0", "All", 0);
  
  private String description;
  private String type;
  private int number;
  
  private AppeareType(String type, String description, int number)
  {
    this.type = type;
    this.description = description;
    this.number = number;
  }
  
  public static boolean isAll(AppeareType type)
  {
    return type.getType().equals(ALL.type);
  }
  
  public static AppeareType getMax()
  {
    AppeareType result = null;
    AppeareType[] arrayOfAppeareType;
    int j = (arrayOfAppeareType = values()).length;
    for (int i = 0; i < j; i++)
    {
      AppeareType type = arrayOfAppeareType[i];
      if (result == null) {
        result = type;
      } else if (result.getNumber() < type.getNumber()) {
        result = type;
      }
    }
    return result;
  }
  
  public String getDescription()
  {
    return this.description;
  }
  
  public void setDescription(String description)
  {
    this.description = description;
  }
  
  public String getType()
  {
    return this.type;
  }
  
  public void setType(String type)
  {
    this.type = type;
  }
  
  public int getNumber()
  {
    return this.number;
  }
  
  public void setNumber(int number)
  {
    this.number = number;
  }
}
