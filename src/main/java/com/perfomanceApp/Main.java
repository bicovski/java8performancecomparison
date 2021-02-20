package com.perfomanceApp;

import com.perfomanceApp.model.AbiProduct;
import com.perfomanceApp.model.Product;
import com.perfomanceApp.service.ProductOperations;
import org.apache.commons.lang3.time.StopWatch;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<AbiProduct> abiProductList = new ArrayList<>();
        List<Product> productList = new ArrayList<>();

        //create lists;
        for (long  i = 0; i < 2000000; i++) {
            productList.add(new Product(1, "Product Title"));
            abiProductList.add(new AbiProduct(1, "Product Title"));
            i++;
        }
        // add different elements for operations.
        abiProductList.add(new AbiProduct(23, "23"));
        abiProductList.add(new AbiProduct(15, "15"));

        productList.add(new Product(0, "23"));
        productList.add(new Product(0, "15"));


        System.out.println("productlist size:" + productList.size());

        //call the methods
        ProductOperations operations = new ProductOperations();

        // for time calculation apache common lang jar.
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        // you can call them one by one and compare the perfomance...
//        operations.calculateWithIterator(productList, abiProductList);  // TODO:  1. about 2 ms
//        operations.calculateWithForLoop(productList, abiProductList); //:TODO 2. about 3 ms
//        operations.calculateStream(productList, abiProductList); //:TODO 3. about 43 ms
 //        operations.calculateWithParallelStream(productList, abiProductList); //:TODO  4. about 50ms
//        operations.parallelStreamCountToOneMillion(); //TODO:  about 35 seconds
//        operations.streamCountToOneMillion(); // TODO: about 87 seconds



        stopWatch.stop();

       // productList.forEach(item -> System.out.println("productId:  " + item.getId() + "  product Title : " + item.getTitle()));
        System.out.println("Time: " + stopWatch.getTime());


    }


}
