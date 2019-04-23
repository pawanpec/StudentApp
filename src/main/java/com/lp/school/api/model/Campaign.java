package com.lp.school.api.model;

import java.util.Date;

public class Campaign {
  Integer id;
  String advertiserName;
  String agencyName;
  String campaignName;
  Integer budget;
  Date flightStartDate;
  Date flightEndDate;
  Integer marketingObjectiveId;
  Integer locationId;
  Integer industryId;

  public Campaign() {}

  public Campaign(
      Integer id,
      String advertiserName,
      String agencyName,
      String campaignName,
      Integer budget,
      Date flightStartDate,
      Date flightEndDate,
      Integer marketingObjectiveId,
      Integer locationId,
      Integer industryId) {
    this.id = id;
    this.advertiserName = advertiserName;
    this.agencyName = agencyName;
    this.campaignName = campaignName;
    this.budget = budget;
    this.flightStartDate = flightStartDate;
    this.flightEndDate = flightEndDate;
    this.marketingObjectiveId = marketingObjectiveId;
    this.locationId = locationId;
    this.industryId = industryId;
  }

  public Integer getLocationId() {
    return locationId;
  }

  public void setLocationId(Integer locationId) {
    this.locationId = locationId;
  }

  public Integer getIndustryId() {
    return industryId;
  }

  public void setIndustryId(Integer industryId) {
    this.industryId = industryId;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getAdvertiserName() {
    return advertiserName;
  }

  public void setAdvertiserName(String advertiserName) {
    this.advertiserName = advertiserName;
  }

  public String getAgencyName() {
    return agencyName;
  }

  public void setAgencyName(String agencyName) {
    this.agencyName = agencyName;
  }

  public String getCampaignName() {
    return campaignName;
  }

  public void setCampaignName(String campaignName) {
    this.campaignName = campaignName;
  }

  public Integer getBudget() {
    return budget;
  }

  public void setBudget(Integer budget) {
    this.budget = budget;
  }

  public Date getFlightStartDate() {
    return flightStartDate;
  }

  public void setFlightStartDate(Date flightStartDate) {
    this.flightStartDate = flightStartDate;
  }

  public Date getFlightEndDate() {
    return flightEndDate;
  }

  public void setFlightEndDate(Date flightEndDate) {
    this.flightEndDate = flightEndDate;
  }

  public Integer getMarketingObjectiveId() {
    return marketingObjectiveId;
  }

  public void setMarketingObjectiveId(Integer marketingObjectiveId) {
    this.marketingObjectiveId = marketingObjectiveId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Campaign campaign = (Campaign) o;

    return id != null ? id.equals(campaign.id) : campaign.id == null;
  }

  @Override
  public int hashCode() {
    return id != null ? id.hashCode() : 0;
  }
}
