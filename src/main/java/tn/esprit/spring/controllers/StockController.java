package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entities.Stock;
import tn.esprit.spring.interfaces.IStock;

import java.util.List;

@RestController
@RequestMapping("/stock")
public class StockController {
    @Autowired
    IStock stockService;
    @GetMapping("getAll")
    List<Stock> affichageStock (){
        return stockService.retrieveAllStocks();
    }
   @PostMapping("/add")
    Stock addStock (@RequestBody Stock s){
        return  stockService.addStock(s);
    }
    @PutMapping("/update")
    Stock updateStock (@RequestBody Stock s){
        return stockService.updateStock(s);
    }
    @GetMapping("/get/{id}")
    Stock getByIdStock (@PathVariable("id") Long id){
        return  stockService.retrieveStock(id);
    }
    @DeleteMapping("/delete/{id}")
    void deleteStock (@PathVariable("id") Long id){
        stockService.removeStock(id);
    }
}
