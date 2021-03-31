package com.nnk.springboot.service;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.repositories.BidListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BidListServiceImpl implements BidListService {

    private BidListRepository bidListRepository;

    @Autowired
    public void BidListServiceImpl(BidListRepository bidListRepository) {
        this.bidListRepository = bidListRepository;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public BidList getBidListById(int id) {
        return bidListRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Invalid BidList Id:" + id));
    }

    @Override
    public List<BidList> getAllBidList() {
        return bidListRepository.findAll();
    }

    @Override
    public void saveBidList(BidList bidList) {
        bidListRepository.save(bidList);
    }

    @Override
    public void updateBidList(BidList bidList) {
        bidListRepository.save(bidList);
    }

    @Override
    public void deleteBidList(int id) {
        BidList bidList = bidListRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException(("Invalid BidList Id:"+ id)));
        bidListRepository.delete(bidList);
    }

}
