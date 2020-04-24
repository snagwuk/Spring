package chap12.store.dao;

import chap12.store.domain.Item;

public interface ItemDao {

	Item findById(Integer itemId);

}
