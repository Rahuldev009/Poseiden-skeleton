package com.nnk.springboot.service;

import com.nnk.springboot.domain.BidList;
import org.springframework.stereotype.Service;

import java.util.List;


public interface BidListService {

    public BidList getBidListById (int id);

    public List <BidList> getAllBidList ();

    public void saveBidList(BidList bidList);

    public void updateBidList(BidList bidList);

    public void deleteBidList(int id);

}
