package shop;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import search.SearchClientFactory;
import search.SearchDocument;

@Component
public class ProductService {

        private SearchClientFactory searchClientFactory;

        @Resource(name = "productSearchClientFactory")
        public void setSearchClientFactory(SearchClientFactory searchClientFactory) {
                this.searchClientFactory = searchClientFactory;
        }

        public void createProduct(ProductInfo pi) {
                searchClientFactory.create().addDocument(toSearchDocument(pi));
        }

        private SearchDocument toSearchDocument(ProductInfo pi) {
                return new SearchDocument();
        }
}
