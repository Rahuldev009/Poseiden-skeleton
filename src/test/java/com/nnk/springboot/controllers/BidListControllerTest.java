package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.service.BidListService;
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
public class BidListControllerTest {

    @Mock
    BidListService bidListService;

    @InjectMocks
    BidListController bidListController;

    @Mock
    Model model;

    @Mock
    BindingResult bindingResult;

    @Test
    public void home() {
        String s = bidListController.home(model);
        Assert.assertEquals("bidList/list", s);
    }

    @Test
    public void addBidForm() {
        BidList bid = new BidList();
        bid.setBidListId(1);
        bid.setAccount("Account Test");
        bid.setType("Type Test");
        bid.setBidQuantity(10d);
        String s = bidListController.addBidForm(bid);
        Assert.assertEquals("bidList/add", s);
    }

    @Test
    public void validate() {
        BidList bid = new BidList();
        bid.setBidListId(1);
        bid.setAccount("Account Test");
        bid.setType("Type Test");
        bid.setBidQuantity(10d);
        String s = bidListController.validate(bid, bindingResult, model);
        Assert.assertEquals("redirect:/bidList/list", s);
    }

    @Test
    public void showUpdateForm() {
        BidList bid1 = new BidList();
        bid1.setBidListId(1);
        bid1.setAccount("Account Test");
        bid1.setType("Type Test");
        bid1.setBidQuantity(10d);
        String s = bidListController.showUpdateForm(1, model);
        Assert.assertEquals("bidList/update", s);
    }

    @Test
    public void updateBid() {
        BidList bid = new BidList();
        bid.setBidListId(1);
        bid.setAccount("Account Test");
        bid.setType("Type Test");
        bid.setBidQuantity(10d);
        String s = bidListController.updateBid(1, bid, bindingResult, model);
        Assert.assertEquals("redirect:/bidList/list", s);
    }

    @Test
    public void deleteBid() {
        BidList bid = new BidList();
        bid.setBidListId(1);
        bid.setAccount("Account Test");
        bid.setType("Type Test");
        bid.setBidQuantity(10d);
        String s = bidListController.deleteBid(1, model);
        Assert.assertEquals("redirect:/bidList/list", s);
    }

}