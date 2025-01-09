package com.example.BookManagementSystem.controller;

import com.example.BookManagementSystem.entity.LibraryMember;
import com.example.BookManagementSystem.repository.MemberRepo;
import com.example.BookManagementSystem.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/members")
public class LibraryMemberController {

    @Autowired
    private LibraryService libraryService;
    @Autowired
    private MemberRepo memberRepo;

    @GetMapping

    public List<LibraryMember>getAllMembers(){

        return libraryService.getAllMembers();
    }

    @GetMapping ("/{id}")

    public Optional<LibraryMember> getMemberById(@PathVariable String id){

        return libraryService.findfById(id);
    }

    @PostMapping

    public void addMember(@RequestBody LibraryMember member){

        libraryService.saveEntry(member);

    }

    @DeleteMapping ("/{id}")

    public void deleteById(@PathVariable String id){

        libraryService.deleteById(id);
    }
}
