package chap13.store.persistence;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import chap13.store.domain.PurchaseOrder;
import chap13.store.domain.PurchaseOrderRepository;

public class JpaPurchaseOrderRepository implements PurchaseOrderRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(PurchaseOrder order) {
		entityManager.persist(order);
	}

}
