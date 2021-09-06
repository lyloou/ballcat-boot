package com.your.packages.finance;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author lilou
 * @since 2021/9/6
 */
@RestController
@RequestMapping("finance")
public class StockIndexController {

	@Resource
	protected SpringPipelineFactory springPipelineFactory;

	@Autowired
	private StockIndexItemGeccoService stockIndexItemGeccoService;

	@GetMapping("/start")
	public String start() {
		stockIndexItemGeccoService.start("zs_000001", 20210514, 20210903);
		return "started.";
	}

	@GetMapping("/scheduled")
	public String scheduled() {
		stockIndexItemGeccoService.sync();
		return "started.";
	}
}
