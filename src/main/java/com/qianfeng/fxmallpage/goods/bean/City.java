package com.qianfeng.fxmallpage.goods.bean;


public class City {

  private long cityId;
  private String cityName;
  private String provinceId;
  private String firstLetter;
  private long isHot;
  private long state;


  public long getCityId() {
    return cityId;
  }

  public void setCityId(long cityId) {
    this.cityId = cityId;
  }


  public String getCityName() {
    return cityName;
  }

  public void setCityName(String cityName) {
    this.cityName = cityName;
  }


  public String getProvinceId() {
    return provinceId;
  }

  public void setProvinceId(String provinceId) {
    this.provinceId = provinceId;
  }


  public String getFirstLetter() {
    return firstLetter;
  }

  public void setFirstLetter(String firstLetter) {
    this.firstLetter = firstLetter;
  }


  public long getIsHot() {
    return isHot;
  }

  public void setIsHot(long isHot) {
    this.isHot = isHot;
  }


  public long getState() {
    return state;
  }

  public void setState(long state) {
    this.state = state;
  }

  public City(long cityId, String cityName, String provinceId, String firstLetter, long isHot, long state) {
    this.cityId = cityId;
    this.cityName = cityName;
    this.provinceId = provinceId;
    this.firstLetter = firstLetter;
    this.isHot = isHot;
    this.state = state;
  }

  public City() {
  }
}
