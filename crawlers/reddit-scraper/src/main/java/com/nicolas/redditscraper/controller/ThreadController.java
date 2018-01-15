package com.nicolas.redditscraper.controller;

import com.nicolas.redditscraper.model.Thread;
import com.nicolas.redditscraper.service.ScrapingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/threads")
public class ThreadController {

    @Autowired
    private ScrapingService scrapingService;

    @GetMapping(path = "/hot")
    public ResponseEntity<List<Thread>> getHotThreads(@RequestParam("subreddits") String subreddits) {
        if (subreddits == null || subreddits.isEmpty()) {
            return ResponseEntity.badRequest().body(null);
        }
        try {
            List<String> subredditList = Arrays.asList(subreddits.split(";"));
            List<Thread> hotThreads = scrapingService.getHotThreads(subredditList);

            return ResponseEntity.ok(hotThreads);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
