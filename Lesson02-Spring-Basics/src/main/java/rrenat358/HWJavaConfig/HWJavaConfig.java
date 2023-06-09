package rrenat358.HWJavaConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import ru.rrenat358.HWSpring.Product;

import java.util.List;

@Component
public class HWJavaConfig {
    Product product = new Product();

    @Bean
    public List<Object> ProductRepository(List<Object> list) {
        list.add(product.getId());
        list.add(product.getName());
        list.add(product.getPrice());
        return list;
    }


}
