package main.config.customConfig;

import java.util.List;
import java.util.Map;

public class customConfig { //for jsonReader
    private List<String> sizes;
    private Map<String, Category> products;
    public static class Category {
        private SubCategory tops;
        private SubCategory bottoms;
    }

    public static class SubCategory {
        private List<Product> jackets;
        private List<Product> hoodies;
        private List<Product> tees;
        private List<Product> tanks;
        private List<Product> pants;
        private List<Product> shorts;
    }

    public static class Product {
        private List<String> sizes;
        private List<String> colors;
    }
}
