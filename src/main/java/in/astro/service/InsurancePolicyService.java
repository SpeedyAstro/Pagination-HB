package in.astro.service;

import java.util.List;

import in.astro.dto.InsurancePolicyDTO;

public interface InsurancePolicyService {
	public long fetchPagesCount(int pageSize);

	public List<InsurancePolicyDTO> fetchPageData(int pageSize, int pageNo);

}
