package chap13.store.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import chap13.store.domain.PaymentInfo;
import chap13.store.domain.PaymentInfoRepository;

public class JpaPaymentInfoRepository implements PaymentInfoRepository {

	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;

	@Override
	public void save(PaymentInfo paymentInfo) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.joinTransaction();
		entityManager.persist(paymentInfo);
	}

}
