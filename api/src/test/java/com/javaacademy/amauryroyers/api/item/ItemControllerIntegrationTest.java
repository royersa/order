package com.javaacademy.amauryroyers.api.item;

import com.javaacademy.amauryroyers.domain.item.ItemRepository;
import com.javaacademy.amauryroyers.service.item.ItemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;

import static com.javaacademy.amauryroyers.api.item.ItemDTO.itemDTO;
import static org.junit.Assert.*;
import static org.springframework.boot.SpringApplication.run;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ItemControllerIntegrationTest.ItemControllerIntegrationTestRunner.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ItemControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Inject
    private ItemRepository itemRepository;

    @Test
    public void registerItem_givenAPostRequestOfAnItem_thenCreatesANewItem() {
        ItemDTO itemDTO = new TestRestTemplate()
                .postForObject(String.format("http://localhost:%s/%s", port, "item"),
                        itemDTO().withName("Nintendo Switch")
                                .withDescription("The brand new hybrid console!")
                                .withPrice("329.00")
                                .withAmount("10"),
                        ItemDTO.class);
    }

    @SpringBootApplication(scanBasePackageClasses = {ItemRepository.class, ItemService.class, ItemMapper.class})
    public static class ItemControllerIntegrationTestRunner{
        public static void main(String[] args) {
            run(ItemControllerIntegrationTestRunner.class, args);
        }
    }
}