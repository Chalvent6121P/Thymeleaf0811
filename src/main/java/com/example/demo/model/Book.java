package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //
@NoArgsConstructor //=defaultConstructor無參數建構子
@AllArgsConstructor //有參數建構子
public class Book {
	int id;
	String bookName;
	int price;
}
