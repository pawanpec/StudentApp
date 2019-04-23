package com.lp.school.api.dao;

import java.util.ArrayList;
import java.util.List;

import com.lp.school.api.model.Campaign;
import org.springframework.stereotype.Repository;

@Repository
public class CampaignDAO {

  static int idCounter = 0;
  private static List<Campaign> list = new ArrayList<>();

  public List<Campaign> getAll() {
    return list;
  }

  public Campaign create(Campaign campaign) {
    idCounter = idCounter + 1;
    campaign.setId(idCounter);
    list.add(campaign);
    return campaign;
  }

  public Campaign update(Campaign campaign) {
    int index = list.indexOf(campaign);
    list.set(index, campaign);
    return campaign;
  }

  public Campaign findById(Integer id) {
    Campaign campaign = new Campaign();
    campaign.setId(id);
    int index = list.indexOf(campaign);
    return list.get(index);
  }
}
