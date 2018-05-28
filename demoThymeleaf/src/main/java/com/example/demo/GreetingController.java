/**
 * 
 */
package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 
 *
 */
@Controller
public class GreetingController {

	@Autowired
	private MessageSource messageSource;

	@RequestMapping("/greeting")
	public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
			Model model, Locale locale) {
		model.addAttribute("name", name);

		List<String> tl = findTableHeader(1, 1, locale);
		List<List<String>> td = findTableDatas(1, 1, locale);

		model.addAttribute("tableHeaders", tl);
		model.addAttribute("tableDatas", td);

		return "greeting";
	}

	/**
	 * テーブルのヘッダーカラム名を取得するダミーメソッドです。
	 * 
	 * @param tenantId
	 * @param tableId
	 * @param locale
	 * @return テーブルのヘッダーカラム名
	 */
	private List<String> findTableHeader(long tenantId, long tableId, Locale locale) {
		List<String> tableList = new ArrayList<String>();
		int maxNum = Integer
				.parseInt(messageSource.getMessage("table" + String.valueOf(tableId) + ".colNum", null, locale));
		for (int i = 0; i < maxNum; i++) {
			tableList.add(messageSource.getMessage("table" + String.valueOf(tableId) + ".headerName" + (i + 1), null,
					locale));
		}
		return tableList;
	}

	/**
	 * テーブルのデータを取得するダミーメソッドです。
	 * @param tenantId
	 * @param tableId
	 * @param locale
	 * @return
	 */
	private List<List<String>> findTableDatas(long tenantId, long tableId, Locale locale) {
		List<List<String>> dataList = new ArrayList<List<String>>();

		for (int i = 0; i < 10; i++) {
			List<String> workList = new ArrayList<String>();
			workList.add(String.valueOf(i+1));
			workList.add("ガス分析計" + String.valueOf(i+1));
			workList.add("運用中");
			workList.add(String.valueOf(1.5 * i));
			workList.add("ボイラー設備");
			workList.add("設備管理係");
			workList.add("15年");
			/* 本来は、tableIdからヘッダーカラム数をチェックする必要があるが、ここでは省略する。 */
			dataList.add(workList);
		}

		return dataList;
	}

	
}
