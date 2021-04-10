package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.service.TradeService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TradeControllerTest {

    @Mock
    TradeService tradeService;

    @InjectMocks
    TradeController tradeController;

    @Mock
    Model model;

    @Mock
    BindingResult bindingResult;

    @Test
    public void home_validateResponseURL() {
        String s = tradeController.home(model);
        Assert.assertEquals("trade/list", s);
    }

    @Test
    public void addUser_validateResponseURL() {
        Trade trade = new Trade();
        trade.setTradeId(1);
        trade.setAccount("Trade Account");
        trade.setType("Type");
        String s = tradeController.addUser(trade);
        Assert.assertEquals("trade/add", s);
    }

    @Test
    public void validate_validateResponseURL() {
        Trade trade = new Trade();
        trade.setTradeId(1);
        trade.setAccount("Trade Account");
        trade.setType("Type");
        String s = tradeController.validate(trade, bindingResult, model);
        Assert.assertEquals("redirect:/trade/list", s);
    }

    @Test
    public void showUpdateForm_validateResponseURL() {
        Trade trade = new Trade();
        trade.setTradeId(1);
        trade.setAccount("Trade Account");
        trade.setType("Type");
        String s = tradeController.showUpdateForm(1, model);
        Assert.assertEquals("trade/update", s);
    }

    @Test
    public void updateTrade_validateResponseURL() {
        Trade trade = new Trade();
        trade.setTradeId(1);
        trade.setAccount("Trade Account");
        trade.setType("Type");
        String s = tradeController.updateTrade(1, trade, bindingResult, model);
        Assert.assertEquals("redirect:/trade/list", s);
    }

    @Test
    public void deleteTrade_validateResponseURL() {
        Trade trade = new Trade();
        trade.setTradeId(1);
        trade.setAccount("Trade Account");
        trade.setType("Type");
        String s = tradeController.deleteTrade(1, model);
        Assert.assertEquals("redirect:/trade/list", s);
    }

}