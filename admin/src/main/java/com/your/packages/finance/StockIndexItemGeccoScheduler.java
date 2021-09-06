package com.your.packages.finance;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author lilou
 * @since 2021/9/6
 */
@Component
@Slf4j
public class StockIndexItemGeccoScheduler {
	@Autowired
	private StockIndexItemGeccoService stockIndexItemGeccoService;

	/**
	 * 15:02:00
	 */
	@Scheduled(cron = "0 2 15 * * *")
	public void syncStockIndex() {
		stockIndexItemGeccoService.sync();
	}
}
