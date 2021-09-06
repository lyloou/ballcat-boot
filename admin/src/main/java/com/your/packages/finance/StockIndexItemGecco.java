package com.your.packages.finance;

import com.alibaba.fastjson.JSONArray;
import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.JSONPath;
import com.geccocrawler.gecco.annotation.RequestParameter;
import com.geccocrawler.gecco.annotation.Text;
import com.geccocrawler.gecco.request.HttpGetRequest;
import com.geccocrawler.gecco.spider.JsonBean;
import lombok.Data;

import java.util.List;

/**
 * @author lilou
 * @since 2021/9/6
 */
@Gecco(matchUrl = "https://q.stock.sohu.com/hisHq?code={indexCode}&start={start}&end={end}", pipelines = "stockIndexPipeline")
@Data
public class StockIndexItemGecco implements JsonBean {
	private static final long serialVersionUID = -7127412585200687225L;

	@RequestParameter("indexCode")
	private String indexCode;

	@RequestParameter("start")
	private String start;

	@RequestParameter("end")
	private String end;

	@Text
	@JSONPath("$[0].status")
	private Integer status;

	@Text
	@JSONPath("$[0].code")
	private String code;

	@Text
	@JSONPath("$[0].hq")
	private List<JSONArray> hq;


	public static void main(String[] args) {
		HttpGetRequest start = new HttpGetRequest("https://q.stock.sohu.com/hisHq?code=zs_000001&start=20210514&end=20210903");
		start.setCharset("GBK");
		GeccoEngine.create()
				.classpath("com.your.packages.finance")
				.start(start)
				.run();
	}
}
