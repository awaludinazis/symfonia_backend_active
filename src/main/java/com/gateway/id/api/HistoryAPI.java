package com.gateway.id.api;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gateway.id.dao.TbHistory;
import com.gateway.id.dao.TbProductFlowHeader;
import com.gateway.id.service.TbHistoryService;
import com.google.gson.Gson;

@RestController
@RequestMapping("api")
public class HistoryAPI {

	@Autowired
	TbHistoryService historyService;

	private static final Logger LOG = LoggerFactory.getLogger(HistoryAPI.class);

	@RequestMapping(path = "/history/ping", method = RequestMethod.GET)
	public ResponseEntity<String> echo() {
		return new ResponseEntity<String>("SUCCESS!!!", HttpStatus.OK);
	}

	@RequestMapping(path = "/history/insertHistoryData", method = RequestMethod.POST, headers = "Content-Type=application/json")
	public ResponseEntity<String> insertHistoryData(@RequestBody TbHistory history) {

		String result = "";
		Gson gson = new Gson();

		if (history != null && history.getMenu() != null) {
			try {

				result = historyService.insertHistoryData(history);

				return new ResponseEntity<String>(gson.toJson(result), HttpStatus.OK);

			} catch (Exception e) {
				LOG.error(e.getMessage());
				return new ResponseEntity<String>(gson.toJson("Gagal Menyimpan Data!"), HttpStatus.BAD_REQUEST);
			}
		}

		return new ResponseEntity<String>(gson.toJson("Data Kosong Harap Isi Data!"), HttpStatus.FORBIDDEN);
	}

	@RequestMapping(path = "/history/getAllData", method = RequestMethod.POST, headers = "Content-Type=application/json")
	public ResponseEntity<String> getAllData() {

		List<TbHistory> list = new ArrayList<>();
		String result = "";
		Gson gson = new Gson();

		try {

			list = historyService.getAllData();

			if (list.size() > 0) {
				result = gson.toJson(list);
			}

			return new ResponseEntity<String>(result, HttpStatus.OK);

		} catch (Exception e) {
			LOG.error(e.getMessage());
			return new ResponseEntity<String>(gson.toJson("Gagal Menyimpan Data!"), HttpStatus.BAD_REQUEST);
		}
	}

}
