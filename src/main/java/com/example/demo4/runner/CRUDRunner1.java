package com.example.demo4.runner;

import com.example.demo4.entity.Beverage;
import com.example.demo4.repository.BeverageRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Order(1)
public class CRUDRunner1 implements CommandLineRunner {

    @Autowired
    private BeverageRepository repository;

    @Override
    public void run(String... args) throws Exception {
        log.info("repository={}",repository);
        initDB();
    }

    private void initDB() {
        Beverage b1 = new Beverage();
        b1.setTitle("Tall ice coffee");
        b1.setDetail("Americano");
        b1.setPrice(120);
        b1.setSugar(0.0f);
        Beverage b2 = new Beverage();
        b2.setTitle("Hot grande latte");
        b2.setDetail("3 shot espresso+70% hot milk+...");
        b2.setPrice(200);
        b2.setSugar(0.0f);
        repository.save(b1);
        repository.save(b2);
    }
}
