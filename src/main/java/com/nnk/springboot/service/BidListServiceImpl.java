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
     * find the bidlist item by Id
     * @param id this is the id of bidlist item to be searched
     * @return bidlist object with the same Id
     */
    @Override
    public BidList getBidListById(int id) {
        return bidListRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Invalid BidList Id:" + id));
    }

    /**
     * find all items of bidlist
     * @return list of all bidlist items
     */
    @Override
    public List<BidList> getAllBidList() {
        return bidListRepository.findAll();
    }

    /**
     * save the bidlist item in the DB
     * @param bidList this is the item to be saved in the DB
     */
    @Override
    public void saveBidList(BidList bidList) {
        bidListRepository.save(bidList);
    }

    /**
     * update the bidlist item in the DB
     * @param bidList this is the item to be updated in the DB
     */
    @Override
    public void updateBidList(BidList bidList) {
        bidListRepository.save(bidList);
    }

    /**
     * delete the bidlist item in the DB
     * @param id this is the id of bidlist item to be deleted
     */
    @Override
    public void deleteBidList(int id) {
        BidList bidList = bidListRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException(("Invalid BidList Id:"+ id)));
        bidListRepository.delete(bidList);
    }

}
