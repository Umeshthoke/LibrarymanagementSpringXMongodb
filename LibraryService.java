package com.example.BookManagementSystem.service;


import com.example.BookManagementSystem.entity.LibraryMember;
import com.example.BookManagementSystem.repository.MemberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class LibraryService {

    @Autowired

    private MemberRepo memberRepo;

    //post mapping
    public void saveEntry(LibraryMember libraryMember){
        memberRepo.save(libraryMember);
    }

       //getmapping
    public List<LibraryMember> getAllMembers() {
        return memberRepo.findAll();
    }

       //getmapping byid
    public Optional<LibraryMember>findfById(String id){
        return memberRepo.findById(id);

    }


      //delete mapping
    public void deleteById(String id){
        memberRepo.deleteById(id);

    }

}
