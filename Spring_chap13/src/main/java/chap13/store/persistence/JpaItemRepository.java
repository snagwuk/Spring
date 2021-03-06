package chap13.store.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import chap13.store.domain.Item;
import chap13.store.domain.ItemRepository;

public class JpaItemRepository implements ItemRepository
{
    
    private EntityManagerFactory entityManagerFactory;
    
    public void setEntityManagerFactory(EntityManagerFactory emf)
    {
        this.entityManagerFactory = emf;
    }
    
    @Override
    public Item findById(Integer itemId)
    {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.joinTransaction();
        return entityManager.find(Item.class, itemId);
    }
    
}
