package com.gateway.id.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.gateway.id.dao.EbUser;
import com.gateway.id.dao.TbProductFlow;
import com.gateway.id.repository.EbUserPagingRepository;
import com.gateway.id.repository.EbUserRepository;

@Service
public class EbUserService {

	@Autowired
	EbUserRepository userRepository;

	@Autowired
	EbUserPagingRepository ebUserPagingRepository;

	public boolean saveUserData(String username, String password, Integer status, Integer roledId, Long id) {
		boolean result = false;
		EbUser ebUser = new EbUser();
		String hashPass = "";

		if (id != null) {
			ebUser = getUserById(id);

			if (ebUser.getId() != 0 && ebUser.getUsername() != null) {

				if(ebUser.getPassword().length() > 25) {
					hashPass = ebUser.getPassword();
				}else {
					hashPass = BCrypt.hashpw(password, BCrypt.gensalt(12));
				}
				

				ebUser.setCreatedBy(username);
				ebUser.setCreatedTm(new Date());
				ebUser.setModifiedBy(username);
				ebUser.setModifiedTm(new Date());
				ebUser.setPassword(hashPass);
				ebUser.setRoleId(roledId);
				ebUser.setStatus(status);
				ebUser.setUsername(username);

				userRepository.save(ebUser);

				result = true;

			} else {
				result = false;
			}
		} else {
			hashPass = BCrypt.hashpw(password, BCrypt.gensalt(12));

			ebUser.setCreatedBy(username);
			ebUser.setCreatedTm(new Date());
			ebUser.setModifiedBy(username);
			ebUser.setModifiedTm(new Date());
			ebUser.setPassword(hashPass);
			ebUser.setRoleId(roledId);
			ebUser.setStatus(status);
			ebUser.setUsername(username);

			userRepository.save(ebUser);
			
			result = true;
		}

		return result;

	}

	public List<EbUser> getListUser() {
		List<EbUser> list = new ArrayList<>();

		list = userRepository.findAll();

		return list;
	}

	public boolean getLoginAccess(String userName, String password) {
		EbUser ebUser = new EbUser();
		boolean isAuthenticated = false;

		ebUser = userRepository.findByUsername(userName);

		if (ebUser != null && ebUser.getPassword() != null && ebUser.getStatus() == 0) {
			isAuthenticated = BCrypt.checkpw(password, ebUser.getPassword());

			return isAuthenticated;
		} else {
			return isAuthenticated;
		}

	}

	public Page<EbUser> pagingAllData(int start, int length, String sort, String column) {
		Sort.Direction direction = Sort.Direction.ASC;

		if (sort.equalsIgnoreCase("desc")) {
			direction = Sort.Direction.DESC;
		}

		Pageable pageable = PageRequest.of(start, length, direction, column);

		Page<EbUser> page = ebUserPagingRepository.findAll(pageable);

		return page;
	}

	public EbUser getUserById(Long id) {

		EbUser ebUser = new EbUser();
		Optional<EbUser> user;

		if (id != null) {
			user = userRepository.findById(id);

			if (user != null && !user.toString().equalsIgnoreCase("Optional.empty")) {
				ebUser = user.get();
			}
			return ebUser;
		} else {
			return ebUser;
		}

	}

	public Boolean deleteById(Long id) {

		EbUser ebUser = new EbUser();
		Optional<EbUser> user;

		if (id != null) {
			user = userRepository.findById(id);

			if (user != null && !user.toString().equalsIgnoreCase("Optional.empty")) {
				ebUser = user.get();
				ebUser.setStatus(1);
				userRepository.save(ebUser);

				return Boolean.TRUE;
			}

		} else {
			return Boolean.FALSE;
		}

		return Boolean.FALSE;

	}

}
