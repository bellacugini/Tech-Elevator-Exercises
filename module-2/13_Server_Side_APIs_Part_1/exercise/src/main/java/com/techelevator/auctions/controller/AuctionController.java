package com.techelevator.auctions.controller;

import com.techelevator.auctions.dao.AuctionDao;
import com.techelevator.auctions.dao.MemoryAuctionDao;
import com.techelevator.auctions.model.Auction;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuctionController {

    private AuctionDao dao;

    public AuctionController() {
        this.dao = new MemoryAuctionDao();
    }

    @RequestMapping(path = "/auctions/{id}", method = RequestMethod.GET)
    public Auction get(@PathVariable int id) {
        return dao.get(id);
    }

    @RequestMapping(path= "/auctions", method=RequestMethod.POST)
    public Auction createAnAuction(@RequestBody Auction auction) {
        System.out.println("Called with the path /auctions");
        return dao.create(auction);
    }

    @RequestMapping(path= "/auctions", method=RequestMethod.GET)
    public List<Auction> list(@RequestParam (defaultValue = "" ) String title_like, @RequestParam (defaultValue = "0") double currentBid_lte) {
        if (!title_like.equals("") && (currentBid_lte > 0)) {
            return dao.searchByTitleAndPrice(title_like, currentBid_lte);
        }
        else if (!title_like.equals("") ){
            return dao.searchByTitle(title_like);
        }
        else if (currentBid_lte > 0) {
            return dao.searchByPrice(currentBid_lte);
        }
        else return dao.list();
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Auction> List(@RequestParam(value = "title_like", defaultValue = "") String title,
                              @RequestParam(value = "currentBid_lte", defaultValue = "0") double currentBid) {

        if( !title.isEmpty() && currentBid > 0) {
            return dao.searchByTitleAndPrice(title, currentBid);
        }
        else if( !title.isEmpty()) {
            return dao.searchByTitle(title);
        }
        else if(currentBid > 0) {
            return dao.searchByPrice(currentBid);
        } else {
            return dao.list();
        }
    }

}
