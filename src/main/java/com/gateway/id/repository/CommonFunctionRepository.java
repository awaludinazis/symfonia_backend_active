package com.gateway.id.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.gateway.id.dto.DownloadBasicPriceDto;

@Repository
public class CommonFunctionRepository {

	EntityManager em;

	public CommonFunctionRepository(EntityManager em) {
		this.em = em;
	}

	public List<DownloadBasicPriceDto> getFunctionProductFlow(String customerCode) {

		List<DownloadBasicPriceDto> list = new ArrayList<>();
		String baseQuery = "SELECT *\n" + "    FROM symfonia.sp_data_download_product(\n'" + customerCode + "'\n)";

		System.out.println(baseQuery);

		final Query query = em.createNativeQuery(baseQuery);

		List<Object[]> queryResultList = query.getResultList();

		if (queryResultList.size() > 0) {
			for (Object[] obj : queryResultList) {
				DownloadBasicPriceDto dto = new DownloadBasicPriceDto();

				dto.setNo(obj[0] == null ? "" : String.valueOf(obj[0]));
				dto.setProvinceOrigin(obj[1] == null ? "" : String.valueOf(obj[1]));
				dto.setCityOrigin(obj[2] == null ? "" : String.valueOf(obj[2]));
				dto.setProvinceDestination(obj[3] == null ? "" : String.valueOf(obj[3]));
				dto.setCityDestination(obj[4] == null ? "" : String.valueOf(obj[4]));
				dto.setProductCode(obj[5] == null ? "" : String.valueOf(obj[5]));
				dto.setPriceCode(obj[6] == null ? "" : String.valueOf(obj[6]));
				dto.setSla(obj[7] == null ? "" : String.valueOf(obj[7]));
				dto.setUpdated(obj[8] == null ? "" : String.valueOf(obj[8]));

				list.add(dto);
			}

		}
		return list;

	}
}
