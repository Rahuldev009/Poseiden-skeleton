package com.nnk.springboot.service;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.repositories.BidListRepository;
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
public class BidListServiceImplTest {

    @Mock
    BidListRepository bidListRepository;
    @InjectMocks
    private BidListServiceImpl bidListService;

    @Test
    public void getBidListById() {
        BidList bid = new BidList();
        bid.setAccount("Account Test");
        bid.setType("Type Test");
        bid.setBidQuantity(10d);
        bid.setBidListId(1);
        Mockito.when(bidListRepository.findById(1)).thenReturn(java.util.Optional.of(bid));
        BidList bidNew = bidListService.getBidListById(1);
        Assert.assertTrue(bidNew.getBidListId() == 1);
    }

    @Test
    public void getAllBidList() {
        bidListService.getAllBidList();
        Mockito.verify(bidListRepository, Mockito.times(1)).findAll();
    }

    @Test
    public void saveBidList() {
        bidListService.saveBidList(new BidList());
        Mockito.verify(bidListRepository, Mockito.times(1)).save(Mockito.any(BidList.class));
    }

    @Test
    public void updateBidList() {
        bidListService.updateBidList(new BidList());
        Mockito.verify(bidListRepository, Mockito.times(1)).save(Mockito.any(BidList.class));
    }

    @Test
    public void deleteBidList() {
        BidList bid = new BidList();
        bid.setAccount("Account Test");
        bid.setType("Type Test");
        bid.setBidQuantity(10d);
        bid.setBidListId(1);
        Mockito.when(bidListRepository.findById(1)).thenReturn(java.util.Optional.of(bid));
        bidListService.deleteBidList(1);
        Mockito.verify(bidListRepository, Mockito.times(1)).delete(Mockito.any(BidList.class));
    }
}