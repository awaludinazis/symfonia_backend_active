package com.gateway.id.api;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gateway.id.dao.EbUser;
import com.gateway.id.dao.TbProductFlow;
import com.gateway.id.service.EbUserService;
import com.google.gson.Gson;

@RestController
@RequestMapping("api")
public class EbUserAPI {

	@Autowired
	EbUserService userService;

	private static final Logger LOG = LoggerFactory.getLogger(EbUserAPI.class);

	@RequestMapping(path = "/user/ping", method = RequestMethod.GET)
	public ResponseEntity<String> echo() {
		return new ResponseEntity<String>("SUCCESS!!!", HttpStatus.OK);
	}

	@RequestMapping(path = "/user/insertData", method = RequestMethod.POST)
	public ResponseEntity<Boolean> createCustomer(@RequestBody EbUser ebUser) {

		Boolean result = Boolean.FALSE;

		if (ebUser != null && ebUser.getUsername() != null) {
			try {

				result = userService.saveUserData(ebUser.getUsername(), ebUser.getPassword(), ebUser.getStatus(),
						ebUser.getRoleId(), ebUser.getId());

				return new ResponseEntity<Boolean>(result, HttpStatus.OK);

			} catch (Exception e) {
				LOG.error(e.getMessage());
				return new ResponseEntity<Boolean>(result, HttpStatus.BAD_REQUEST);
			}
		}

		return new ResponseEntity<Boolean>(result, HttpStatus.FORBIDDEN);
	}

	@PostMapping("/user/getMatchPassword")
	public ResponseEntity<Boolean> getMatchPassword(@RequestBody EbUser ebUser) {

		Boolean result = Boolean.FALSE;

		if (ebUser != null && ebUser.getUsername() != null && ebUser.getPassword() != null) {
			try {

				result = userService.getLoginAccess(ebUser.getUsername(), ebUser.getPassword());

				return new ResponseEntity<Boolean>(result, HttpStatus.OK);

			} catch (Exception e) {
				LOG.error(e.getMessage());
				return new ResponseEntity<Boolean>(result, HttpStatus.BAD_REQUEST);
			}
		}

		return new ResponseEntity<Boolean>(result, HttpStatus.FORBIDDEN);

	}

	@RequestMapping(path = "/user/getAllList", method = RequestMethod.POST)
	public ResponseEntity<String> getAllList() {

		List<EbUser> list = new ArrayList<>();
		String result = "";
		Gson gson = new Gson();

		list = userService.getListUser();

		if (list != null) {
			result = gson.toJson(list);

			return new ResponseEntity<String>(result, HttpStatus.OK);

		} else {
			return new ResponseEntity<String>(result, HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(path = "/user/getPagingAllList", method = RequestMethod.POST)
	public ResponseEntity<String> getPagingAllList(@RequestParam("start") int start, @RequestParam("length") int length,
			@RequestParam("sort") String sort, @RequestParam("column") String column) {

		Page<EbUser> page;
		List<EbUser> list = new ArrayList<>();
		String result = "";
		Gson gson = new Gson();

		page = userService.pagingAllData(start, length, sort, column);
//		list = page.getContent();

		if (page != null && page.getContent().size() > 0) {
			result = gson.toJson(page);

			return new ResponseEntity<String>(result, HttpStatus.OK);

		} else {
			return new ResponseEntity<String>(result, HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(path = "/user/getUserById", method = RequestMethod.POST)
	public ResponseEntity<String> getUserById(@RequestBody EbUser ebUser) {

		EbUser user = new EbUser();
		String result = "";
		Gson gson = new Gson();

		user = userService.getUserById(ebUser.getId());

		if (user != null) {
			result = gson.toJson(user);

			return new ResponseEntity<String>(result, HttpStatus.OK);

		} else {
			return new ResponseEntity<String>(result, HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(path = "/user/deleteById", method = RequestMethod.POST)
	public ResponseEntity<Boolean> deleteById(@RequestBody EbUser ebUser) {

		Boolean result = Boolean.FALSE;

		if (ebUser.getId() != null) {
			result = userService.deleteById(ebUser.getId());

			return new ResponseEntity<Boolean>(result, HttpStatus.OK);

		} else {
			return new ResponseEntity<Boolean>(result, HttpStatus.BAD_REQUEST);
		}

	}

}
