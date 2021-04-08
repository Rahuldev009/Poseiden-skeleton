package com.nnk.springboot.service;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.repositories.TradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TradeServiceImpl implements TradeService {

    private TradeRepository tradeRepository;

    @Autowired
    public TradeServiceImpl(TradeRepository tradeRepository) {
        this.tradeRepository = tradeRepository;
    }

    /**
     * find the trade item by Id
     * @param id this is the id of trade item to be searched
     * @return trade object with the same Id
     */
    @Override
    public Trade getByIdTrade(int id) {
        return tradeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Trade Id:" + id));
    }

    /**
     * find all items of trade
     * @return list of all trade items
     */
    @Override
    public List<Trade> getAllTrade() {
        return tradeRepository.findAll();
    }

    /**
     * save the trade item in the DB
     * @param trade this is the item to be saved in the DB
     */
    @Override
    public void saveTrade(Trade trade) {
        tradeRepository.save(trade);
    }

    /**
     * update the trade item in the DB
     * @param trade this is the item to be updated in the DB
     */
    @Override
    public void updateTrade(Trade trade) {
        tradeRepository.save(trade);
    }

    /**
     * delete the trade item in the DB
     * @param id this is the id of trade item to be deleted
     */
    @Override
    public void deleteTrade(int id) {
       Trade trade = tradeRepository.findById(id).orElseThrow(() ->
               new IllegalArgumentException("Invalid Trade Id:" + id));
       tradeRepository.delete(trade);
    }

}
