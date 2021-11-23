package org.arm.resource.mngt.api;

import java.util.List;
import org.arm.resource.mngt.entity.Campaign;
import org.arm.resource.mngt.impl.ICampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CampaignController {
	@Autowired
	private ICampaignService campaignService;

	@GetMapping("/campaign")
	public ResponseEntity<List<Campaign>> allCamapaign() {
		List<Campaign> campaign = campaignService.getAllCampaign();
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "");
		headers.add("info", "");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(campaign);
	}
}
