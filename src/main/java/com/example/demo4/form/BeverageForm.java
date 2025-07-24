package com.example.demo4.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BeverageForm {
    private Long id;
    private String title;
    private String detail;
    private int price;
    private float sugar;
}