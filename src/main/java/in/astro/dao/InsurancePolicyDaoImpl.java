package in.astro.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import in.astro.model.InsurancePolicy;
import in.astro.util.HibernateUtil;


public class InsurancePolicyDaoImpl implements InsurancePolicyDao {
	Session session = HibernateUtil.getSession();
	@Override
	public List<InsurancePolicy> getPageData(int pageSize, int startPos) {
		List<InsurancePolicy> list = null;
		try {
			@SuppressWarnings("unchecked")
			Query<InsurancePolicy> query = session.getNamedQuery("GET_ALL_POLICIES");
			query.setFirstResult(startPos);
			query.setMaxResults(pageSize);
			// Executing query
			list = query.getResultList();
		}catch (HibernateException he) {
			he.printStackTrace();
			throw he;
		} 
		catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return list;
	}

	@Override
	public Long getTotalRecordsCount() {
		Long count = 0L;
		try {
			Query query = session.getNamedQuery("GET_POLICIES_COUNT");
			List list = query.list();
			count = (Long)list.get(0);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return count;
	}

}
