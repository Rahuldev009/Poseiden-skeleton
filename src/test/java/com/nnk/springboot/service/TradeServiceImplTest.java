package com.nnk.springboot.service;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.repositories.TradeRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TradeServiceImplTest {
    @InjectMocks
    TradeServiceImpl tradeService;

    @Mock
    TradeRepository tradeRepository;

    @Test
    public void getByIdTrade() {
        Trade trade = new Trade();
        trade.setAccount("Trade Account");
        trade.setType("Type");
        trade.setTradeId(1);
        Mockito.when(tradeRepository.findById(1)).thenReturn(java.util.Optional.of(trade));
        Trade trade1 = tradeService.getByIdTrade(1);
        Assert.assertTrue(trade1.getTradeId() == 1);
    }

    @Test
    public void getAllTrade() {
        tradeService.getAllTrade();
        Mockito.verify(tradeRepository, Mockito.times(1)).findAll();
    }

    @Test
    public void saveTrade() {
        tradeService.saveTrade(new Trade());
        Mockito.verify(tradeRepository, Mockito.times(1)).save(Mockito.any(Trade.class));
    }

    @Test
    public void updateTrade() {
        tradeService.updateTrade(new Trade());
        Mockito.verify(tradeRepository, Mockito.times(1)).save(Mockito.any(Trade.class));
    }

    @Test
    public void deleteTrade() {
        Trade trade = new Trade();
        trade.setAccount("Trade Account");
        trade.setType("Type");
        trade.setTradeId(1);
        Mockito.when(tradeRepository.findById(1)).thenReturn(java.util.Optional.of(trade));
        tradeService.deleteTrade(1);
        Mockito.verify(tradeRepository, Mockito.times(1)).delete(Mockito.any(Trade.class));
    }

}