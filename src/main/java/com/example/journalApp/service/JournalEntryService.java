package com.example.journalApp.service;

import com.example.journalApp.entity.JournalEntry;
import com.example.journalApp.entity.User;
import com.example.journalApp.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepository;
    @Autowired
    private UserService userService;

    @Transactional
    public void saveEntry(JournalEntry journalEntry, String username) {
        User user=userService.findByUserName(username);
        journalEntry.setDate(LocalDateTime.now());
        JournalEntry saved = journalEntryRepository.save(journalEntry);
        user.getJournalEntries().add(saved);
        userService.saveEntry(user);
    }

    public List<JournalEntry> getAll() {

        return journalEntryRepository.findAll();
    }

    public  Optional<JournalEntry> findbyid(ObjectId myid) {

      //  System.out.print(journalEntryRepository.findById(myid).orElse(null));

        Optional<JournalEntry> res=journalEntryRepository.findById(myid);
        if(res==null){
            return null;
        }

        return res;
    }


    public void deleteById(ObjectId myid, String username) {
    User user=userService.findByUserName(username);
    System.out.print(username);
        user.getJournalEntries().removeIf(x->x.getId().equals(myid));
        userService.saveEntry(user);
        journalEntryRepository.deleteById(myid);
    }

    public JournalEntry updateById(ObjectId myid,@RequestBody JournalEntry myentry) {

        return null;

    }

}
