package guru.sfg.beer.order.service.bootstrap;

import guru.sfg.beer.order.service.domain.Customer;
import guru.sfg.beer.order.service.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Created by jt on 2019-06-06.
 */
@RequiredArgsConstructor
@Component
public class BeerOrderBootStrap implements CommandLineRunner {
    public static final String TASTING_ROOM = "Tasting Room";
    public static final String BEER_1_UPC = "123123123123";
    public static final String BEER_2_UPC = "073785456888";
    public static final String BEER_3_UPC = "763487556709";

    private final CustomerRepository customerRepository;

    @Override
    public void run(String... args) throws Exception {
        loadCustomerData();
    }

    private void loadCustomerData() {
        UUID uuid= UUID.randomUUID();
        if (customerRepository.count() == 0) {
            Customer customer = customerRepository.save(Customer.builder()
                    .customerName(TASTING_ROOM)
                    .apiKey(uuid)
                    .build());
            System.out.println(customer.getId());
        }
    }
}
