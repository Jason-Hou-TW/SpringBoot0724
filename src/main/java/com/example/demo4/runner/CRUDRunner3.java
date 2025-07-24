package com.example.demo4.runner;

import com.example.demo4.entity.Beverage;
import com.example.demo4.repository.BeverageRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j
@Order(3)
public class CRUDRunner3 implements CommandLineRunner {

    @Autowired
    private BeverageRepository repository;

    @Override
    public void run(String... args) throws Exception {
       // searchSMALL_COLA();

        searchPriceBetween();

    }


    private void searchSMALL_COLA() {
        repository.findByTitleAndDetailOrderByPriceAscAllIgnoreCase("COLA", "SMALL")
                .forEach(b -> log.info("search SMALL COLA:{}", b));
    }
    private void searchLatteLike() {
        repository.findByTitleLike("%latte%").forEach(b ->
                log.info("like latte:{}", b));
    }

    private void searchPriceBetween() {
        repository.findByPriceBetweenOrderByPriceAsc(55, 120)
                .forEach(b -> log.info("[55-120] beverage:{}", b));
    }
}
