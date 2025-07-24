package com.example.demo4.repository;

import com.example.demo4.entity.Beverage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BeverageRepository extends CrudRepository<Beverage,Long> {
    Page<Beverage> findAll(Pageable pageable);
    Page<Beverage> findByOrderByPriceAsc(Pageable pageable);

    List<Beverage> findByPriceBetweenOrderByPriceAsc(int min,int max);

    List<Beverage> findByOrderByPriceAsc();

    List<Beverage> findByOrderByPriceDesc();

    //List<Beverage> findByOrderByDiscountAsc();
    List<Beverage> findMatchByTitle(String t);

    List<Beverage> findMatchByTitleOrderByPriceAsc(String title);

    Integer countByTitle(String t);

    List<Beverage> findByTitleIgnoreCaseOrderByPriceAsc(String title);

    List<Beverage> findByTitleAndDetailOrderByPriceAscAllIgnoreCase(String title, String detail);

    List<Beverage> findByTitleLike(String title);
}
