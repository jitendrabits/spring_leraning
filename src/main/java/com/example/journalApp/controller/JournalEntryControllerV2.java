package com.example.journalApp.controller;

import com.example.journalApp.entity.JournalEntry;
import com.example.journalApp.entity.User;
import com.example.journalApp.service.JournalEntryService;
import com.example.journalApp.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// this is howw the flow look like  controller ----> service ---> repository
//this is /journal aplly on the class
@RestController
@RequestMapping("/journal")
public class JournalEntryControllerV2 {


    @Autowired
    private JournalEntryService journalEntryService;
    @Autowired
    private UserService userService;


    @GetMapping("{username}")
    public ResponseEntity<?> getAllJounralEntriesOfUser(@PathVariable String username) {
     //   System.out.print(username);
        User user=userService.findByUserName(username);
    List<JournalEntry>all=user.getJournalEntries();
    if(all!=null && !all.isEmpty()){

        return new ResponseEntity<>(all, HttpStatus.OK);
    }

          return new ResponseEntity<>( HttpStatus.NOT_FOUND);
    }


    @PostMapping("{username}")
    public ResponseEntity<JournalEntry> createEntry(@RequestBody JournalEntry myentry,@PathVariable String username) {
        try {
           // myentry.setDate(LocalDateTime.now());
            journalEntryService.saveEntry(myentry,username);
            return  new ResponseEntity<>(myentry,HttpStatus.CREATED);
        }catch (Exception e){

            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("id/{myid}")
    public ResponseEntity<JournalEntry> getJournalEntitybyId(@PathVariable ObjectId myid) {
        Optional<JournalEntry> journalEntry = journalEntryService.findbyid(myid);

        if (journalEntry.isPresent()) {

            return new ResponseEntity<>(journalEntry.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

     @DeleteMapping("id/{username}/{myid}")
    public void deleteJournalEntitybyId(@PathVariable ObjectId myid,@PathVariable String username) {
        System.out.print(username);
        journalEntryService.deleteById(myid,username);

       // return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @PutMapping("id/{username}/{myid}")
    //only this part is not implemented
    public JournalEntry updateJournalEntitybyId(@PathVariable ObjectId myid, @RequestBody JournalEntry newEntry,@PathVariable String username) {

        JournalEntry old = journalEntryService.findbyid(myid).orElse(null);
//
//        if (old != null) {
//            //agr title null and empty nahi hai to to newentry.title krdo else do old.title
//            old.setTitle(newEntry.getTitle() != null && !newEntry.getTitle().equals("") ? newEntry.getTitle() : old.getTitle());
//            old.setContent(newEntry.getContent() != null && !newEntry.getContent().equals("") ? newEntry.getContent() : old.getContent());
//        }
//        journalEntryService.saveEntry(old, user);
//        return old;

return null;
    }
}
