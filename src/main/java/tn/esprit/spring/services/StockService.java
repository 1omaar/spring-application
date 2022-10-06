package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.Stock;
import tn.esprit.spring.interfaces.IStock;
import tn.esprit.spring.repositories.IStockRepository;

import java.util.List;

@Service
@EnableScheduling
public class StockService implements IStock {
    @Autowired
    IStockRepository stockRepository;

    @Override
    public List<Stock> retrieveAllStocks() {
        return stockRepository.findAll();
    }

    @Override
    public Stock addStock(Stock s) {
        return stockRepository.save(s);
    }

    @Override
    public Stock updateStock(Stock s) {
        return stockRepository.save(s);
    }

    @Override
    public Stock retrieveStock(Long id) {
        return stockRepository.findById(id).orElse(null);
    }

    @Override
    public void removeStock(Long id) {
        stockRepository.deleteById(id);
    }

    @Override
    @Scheduled(cron = "0 10 14 * * ?", zone = "Africa/Tunis")
    public String retrieveStatusStock() {
        List<Stock> stockList = retrieveAllStocks();
        for (Stock stock : stockList
        ) {
            if (stock.getQteMin()>stock.getQte()){
                System.out.println("repture de stock");

            }
        }
    return null;
    }
}
