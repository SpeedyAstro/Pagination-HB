package in.astro.dao;

import java.util.List;

import in.astro.model.InsurancePolicy;


public interface InsurancePolicyDao {
	public List<InsurancePolicy> getPageData(int pageSize,int startPos);
	public Long getTotalRecordsCount();
}
