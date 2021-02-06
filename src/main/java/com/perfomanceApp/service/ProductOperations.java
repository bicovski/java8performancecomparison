package com.perfomanceApp.service;

import com.perfomanceApp.model.AbiProduct;
import com.perfomanceApp.model.Product;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class ProductOperations {

    public void  calculateWithParallelStream(List<Product> productList , List<AbiProduct> abiProductList ){
          productList.parallelStream().filter(item -> item.getId() == 0).
                forEach(item -> abiProductList.parallelStream()
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


}
