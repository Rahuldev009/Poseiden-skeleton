package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.service.TradeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class TradeController {
    private static final Logger logger = LogManager.getLogger(TradeController.class);

    private TradeService tradeService;

    @Autowired
    public void TradeController(TradeService tradeService) {
        this.tradeService = tradeService;
    }

    /**
     * The controller method which route to trade page and loads all the trade
     * @param model this contains the object and attributes which can be passed to the web page
     * @return String name of the web page to be loaded
     */
    @RequestMapping("/trade/list")
    public String home(Model model) {
        List<Trade> trades = tradeService.getAllTrade();
        model.addAttribute("trades", trades);
        return "trade/list";
    }

    /**
     * The controller method which route to add trade page
     * @param bid this contains the trade object needs to be updated in DB
     * @return String name of the web page to be loaded
     */
    @GetMapping("/trade/add")
    public String addUser(Trade bid) {
        return "trade/add";
    }

    /**
     * The controller method which checks for error in the trade object and if not found add the entry in the DB
     * @param trade this contains the trade object needs to be added in DB
     * @param result contains the result of error checking
     * @param model this contains the object and attributes which can be passed to the web page
     * @return String name of the web page to be loaded
     */
    @PostMapping("/trade/validate")
    public String validate(@Valid Trade trade, BindingResult result, Model model) {
        if (!result.hasErrors()) {
            tradeService.saveTrade(trade);
            model.addAttribute("trades", tradeService.getAllTrade());
            return "redirect:/trade/list";
        }
        return "trade/add";
    }

    /**
     * The controller method which find the trade object needs to be updated
     * @param id of the trade object needs to be updated
     * @param model this contains the object and attributes which can be passed to the web page
     * @return String name of the web page to be loaded
     */
    @GetMapping("/trade/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        Trade trade = tradeService.getByIdTrade(id);
        model.addAttribute("trade", trade);
        return "trade/update";
    }

    /**
     * The controller method which checks for error in the trade object and if not found update the entry in the DB
     * @param id of the trade object needs to be updated
     * @param trade this contains the trade object needs to be updated in DB
     * @param result contains the result of error checking
     * @param model this contains the object and attributes which can be passed to the web page
     * @return String name of the web page to be loaded
     */
    @PostMapping("/trade/update/{id}")
    public String updateTrade(@PathVariable("id") Integer id, @Valid Trade trade,
                              BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "trade/update";
        }
        trade.setTradeId(id);
        tradeService.updateTrade(trade);
        model.addAttribute("trades", tradeService.getAllTrade());
        return "redirect:/trade/list";
    }

    /**
     * The controller method which find the trade object needs to be deleted
     * @param id of the trade object needs to be deleted
     * @param model this contains the object and attributes which can be passed to the web page
     * @return String name of the web page to be loaded
     */
    @GetMapping("/trade/delete/{id}")
    public String deleteTrade(@PathVariable("id") Integer id, Model model) {
        tradeService.deleteTrade(id);
        model.addAttribute("trades", tradeService.getAllTrade());
        return "redirect:/trade/list";
    }

}
