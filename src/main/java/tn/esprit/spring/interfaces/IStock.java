package tn.esprit.spring.interfaces;

import tn.esprit.spring.entities.Stock;

import java.util.List;

public interface IStock {
    public List<Stock> retrieveAllStocks();

    public Stock addStock(Stock s);

    public Stock updateStock(Stock s);

    public Stock retrieveStock(Long id);

    public void removeStock(Long id);
    public String retrieveStatusStock();
}
