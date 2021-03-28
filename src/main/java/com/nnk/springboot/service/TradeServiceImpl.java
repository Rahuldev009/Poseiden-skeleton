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

    @Override
    public Trade getByIdTrade(int id) {
        return tradeRepository.getOne(id);
    }

    @Override
    public List<Trade> getAllTrade() {
        return tradeRepository.findAll();
    }

    @Override
    public void saveTrade(Trade trade) {
        tradeRepository.save(trade);
    }

    @Override
    public void updateTrade(Trade trade) {
        tradeRepository.save(trade);
    }

    @Override
    public void deleteTrade(int id) {
        tradeRepository.deleteById(id);
    }

}
