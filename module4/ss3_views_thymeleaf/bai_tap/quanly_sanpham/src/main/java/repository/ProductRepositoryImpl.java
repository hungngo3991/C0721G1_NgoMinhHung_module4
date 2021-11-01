package repository;

import model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepositoryImpl implements IProductRepository {
    private static final Map<Integer, Product> productList;

    static {

        productList = new HashMap<>();
        productList.put(1, new Product(1, "Samsung Galaxy S20 FE 5G", 20000000.0, "New generation", "Samsung"));
        productList.put(2, new Product(2, "Samsung Galaxy S21 Ultra", 18000000.0, "New generation", "Samsung"));
        productList.put(3, new Product(3, "Samsung Galaxy S20 FE", 15000000.0, "Old generation", "Samsung"));


    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productList.values());
    }

    @Override
    public void save(Product product) {
        productList.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return productList.get(id);
    }

    @Override
    public void update(int id, Product product) {
        productList.put(id, product);
    }

    @Override
    public void remove(int id) {
        productList.remove(id);
    }

    @Override
    public List<Product> search(String string) {
        List<Product> productList = findAll();
        List<Product> productListSearch = new ArrayList<>();
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getName().contains(string)) {
                productListSearch.add(productList.get(i));
            }
        }
        return productListSearch;
    }
}