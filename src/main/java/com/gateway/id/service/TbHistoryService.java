package com.gateway.id.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gateway.id.dao.TbHistory;
import com.gateway.id.repository.TbHistoryRepository;

@Service
public class TbHistoryService {

	@Autowired
	TbHistoryRepository historyRepository;

	public String insertHistoryData(TbHistory history) {
		String result = "";

		if (history != null && history.getMenu() != null) {
			TbHistory tbHistory = new TbHistory();

			tbHistory.setAction(history.getAction());
			tbHistory.setAuditrailDate(new Date());
			tbHistory.setMenu(history.getMenu());
			tbHistory.setRow_id(1234);
			tbHistory.setUsername(history.getUsername());

			historyRepository.save(tbHistory);

			return result = "success saving history";
		} else {
			return result = "data menu kosong! failed!";
		}
	}

	public List<TbHistory> getAllData() {
		List<TbHistory> historyList = new ArrayList<>();

		historyList = historyRepository.findAll();

		return historyList;
	}

}
