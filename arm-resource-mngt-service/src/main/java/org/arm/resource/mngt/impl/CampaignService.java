package org.arm.resource.mngt.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.arm.resource.mngt.dataaccess.CampaignRepository;
import org.arm.resource.mngt.entity.Campaign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CampaignService implements ICampaignService {
@Autowired
CampaignRepository campaignRepository;

public List<Campaign> getAllCampaign() {
	campaignRepository.findAll().forEach(System.out:: println);;
	return campaignRepository.findAll();

}

}
