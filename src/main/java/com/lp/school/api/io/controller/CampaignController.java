package com.lp.school.api.io.controller;

import java.util.List;

import com.lp.school.api.dao.CampaignDAO;
import com.lp.school.api.model.Campaign;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;

@Api(tags = {"campaign"})
@RestController
@RequestMapping({"/campaign"})
public class CampaignController {

  private final Logger logger = LoggerFactory.getLogger(CampaignController.class);
  @Autowired private CampaignDAO campaignDAO;

  @GetMapping
  public List<Campaign> getAll() {
    return campaignDAO.getAll();
  }

  @GetMapping(path = {"/{id}"})
  public Campaign findById(@PathVariable Integer id) {
    logger.info("fetching data for {}", id);
    return campaignDAO.findById(id);
  }

  @PostMapping
  public Campaign create(@RequestBody Campaign campaign) {

    return campaignDAO.create(campaign);
  }

  @PutMapping
  public Campaign update(@RequestBody Campaign campaign) {

    return campaignDAO.update(campaign);
  }
}
