package com.nnk.springboot.service;

import com.nnk.springboot.domain.Trade;

import java.util.List;

public interface TradeService {

    public Trade getByIdTrade(int id);

    public List<Trade> getAllTrade();

    public void saveTrade(Trade trade);

    public void updateTrade(Trade trade);

    public void deleteTrade(int id);
}
