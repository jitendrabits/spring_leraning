//package com.example.journalApp.controller;
//
//import com.example.journalApp.entity.JournalEntry;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
////this is /journal aplly on the class
//@RestController
//@RequestMapping("/journal")
//public class JournalEntryController {
//
//    private Map<Long, JournalEntry> journalEntries =new HashMap<>();
//
//    @GetMapping() // get method  http://localhost:8080/journal
//    public List<JournalEntry>getAll(){
//
//        return new ArrayList<>(journalEntries.values());
//    }
//    @GetMapping("one") // get method  http://localhost:8080/journal
//    public Map<Long, JournalEntry>getone(){
//
//        return new HashMap<>(journalEntries);
//    }
//
//    @PostMapping
//    public boolean createEntry(@RequestBody JournalEntry myentry){
//
//        journalEntries.put(myentry.getId(), myentry);
//        return true;
//    }
//
//    @GetMapping("id/{myid}")
//    public JournalEntry getJournalEntitybyId(@PathVariable Long myid){
//
//        return journalEntries.get(myid);
//
//    }
//    @DeleteMapping("id/{myid}")
//    public JournalEntry deleteJournalEntitybyId(@PathVariable Long myid){
//
//        return journalEntries.remove(myid);
//
//    }
//    @PutMapping("id/{myid}")
//    public JournalEntry updateJournalEntitybyId(@PathVariable Long myid,@RequestBody JournalEntry myentry){
//
//        return journalEntries.put(myid,myentry);
//
//    }
//}
