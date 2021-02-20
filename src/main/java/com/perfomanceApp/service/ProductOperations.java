package com.perfomanceApp.service;

import com.perfomanceApp.model.AbiProduct;
import com.perfomanceApp.model.Product;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ProductOperations {

    public void  calculateWithParallelStream(List<Product> productList , List<AbiProduct> abiProductList ){
          productList.parallelStream().filter(item -> item.getId() == 0).
                forEach(item -> abiProductList.stream()
                        .filter(abiProduct -> abiProduct.getTitle().equals(item.getTitle()))
                        .forEach(value -> item.setId(value.getId())));
    }

    public void  calculateStream(List<Product> productList , List<AbiProduct> abiProductList ){
        productList.stream().filter(item -> item.getId() == 0).
                forEach(item -> abiProductList.stream()
                        .filter(abiProduct -> abiProduct.getTitle().equals(item.getTitle()))
                        .forEach(value -> item.setId(value.getId())));
    }

    public void  calculateWithForLoop(List<Product> productList , List<AbiProduct> abiProductList ){
        for(Product product : productList){
            if(product.getId() == 0){
                for(AbiProduct abiProduct : abiProductList){
                    if(abiProduct.getTitle().equals(product.getTitle())){
                        product.setId(abiProduct.getId());
                    }
                }
            }
        }
    }


    public void  calculateWithIterator(List<Product> productList , List<AbiProduct> abiProductList ){
           for (Iterator<Product> iterator = productList.iterator(); iterator.hasNext();){
                Product product = iterator.next();
            if(product.getId() == 0  &&  abiProductList != null){
                for (Iterator<AbiProduct> iterator2 = abiProductList.iterator(); iterator2.hasNext();){
                    AbiProduct abiProduct = iterator2.next();
                    if(abiProduct.getTitle().equals(product.getTitle())){
                        product.setId(abiProduct.getId());
                    }
                }
            }
        }
    }

    public void streamCountToOneMillion(){
         long count = Stream.iterate(0, n -> n + 1)
                 .limit(1_000_000)
                 .filter(ProductOperations::isPrime)
                 .peek(x -> System.out.format("%s\t", x))
                 .count();
        System.out.println("\nTotal: " + count);

    }

    public void parallelStreamCountToOneMillion(){
        long count = Stream.iterate(0, n -> n + 1)
                .limit(1_000_000)
                .parallel()
                .filter(ProductOperations::isPrime)
                .peek(x -> System.out.format("%s\t", x))
                .count();
        System.out.println("\nTotal: " + count);

    }

    public static boolean isPrime(int number) {
        if (number <= 1) return false;
        return !IntStream.rangeClosed(2, number / 2).anyMatch(i -> number % i == 0);
    }




}
