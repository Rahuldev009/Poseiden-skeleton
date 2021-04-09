package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.service.BidListService;
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
public class BidListController {
    private static final Logger logger = LogManager.getLogger(BidListController.class);

    private BidListService bidListService;

    @Autowired
    public void BidListController(BidListService bidListService) {
        this.bidListService = bidListService;
    }

    /**
     * The controller method which route to bidlist page and loads all the bidlists
     * @param model this contains the object and attributes which can be passed to the web page
     * @return String name of the web page to be loaded
     */
    @RequestMapping("/bidList/list")
    public String home(Model model) {
        List<BidList> bidLists = bidListService.getAllBidList();
        model.addAttribute("bidLists", bidLists);
        logger.info("all bidLists list"+ bidLists.toString());
        return "bidList/list";
    }

    /**
     * The controller method which route to add bidlist page
     * @param bid this contains the bidlist object needs to be updated in DB
     * @return String name of the web page to be loaded
     */
    @GetMapping("/bidList/add")
    public String addBidForm(BidList bid) {
        logger.info("bidlist to be added ");
        return "bidList/add";
    }

    /**
     * The controller method which checks for error in the Bidlist object and if not found add the entry in the DB
     * @param bid this contains the bidlist object needs to be added in DB
     * @param result contains the result of error checking
     * @param model this contains the object and attributes which can be passed to the web page
     * @return String name of the web page to be loaded
     */
    @PostMapping("/bidList/validate")
    public String validate(@Valid BidList bid, BindingResult result, Model model) {
        if (!result.hasErrors()) {
            logger.info("bidlist to be added "+ bid.toString());
            bidListService.saveBidList(bid);
            model.addAttribute("bidLists", bidListService.getAllBidList());
            return "redirect:/bidList/list";
        }
        return "bidList/add";
    }

    /**
     * The controller method which find the bidlist object needs to be updated
     * @param id of the bidlist object needs to be updated
     * @param model this contains the object and attributes which can be passed to the web page
     * @return String name of the web page to be loaded
     */
    @GetMapping("/bidList/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        BidList bidList = bidListService.getBidListById(id);
        logger.info("bidlist to be updated "+ bidList.toString());
        model.addAttribute("bidList", bidList);
        return "bidList/update";
    }

    /**
     * The controller method which checks for error in the Bidlist object and if not found update the entry in the DB
     * @param id of the bidlist object needs to be updated
     * @param bidList this contains the bidlist object needs to be updated in DB
     * @param result contains the result of error checking
     * @param model this contains the object and attributes which can be passed to the web page
     * @return String name of the web page to be loaded
     */
    @PostMapping("/bidList/update/{id}")
    public String updateBid(@PathVariable("id") Integer id, @Valid BidList bidList,
                            BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "bidList/update";
        }
        bidList.setBidListId(id);
        logger.info("bidlist to be updated "+ bidList.toString());
        bidListService.updateBidList(bidList);
        model.addAttribute("bidLists", bidListService.getAllBidList());
        return "redirect:/bidList/list";
    }

    /**
     * The controller method which find the bidlist object needs to be deleted
     * @param id of the bidlist object needs to be deleted
     * @param model this contains the object and attributes which can be passed to the web page
     * @return String name of the web page to be loaded
     */
    @GetMapping("/bidList/delete/{id}")
    public String deleteBid(@PathVariable("id") Integer id, Model model) {
        logger.info("bidlist to be deleted "+ bidListService.getBidListById(id).toString());
        bidListService.deleteBidList(id);
        model.addAttribute("bidLists", bidListService.getAllBidList());
        return "redirect:/bidList/list";
    }

}
