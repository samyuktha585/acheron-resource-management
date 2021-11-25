package org.arm.resource.mngt.vo;

import org.arm.resource.mngt.entity.Campaign;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface CampaignMapper {
	CampaignMapper INSTANCE = Mappers.getMapper(CampaignMapper.class);
	CampaignVO fromCampaign(Campaign camaign);
	
}
