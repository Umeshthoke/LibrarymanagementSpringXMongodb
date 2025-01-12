package com.example.BookManagementSystem.controller;

import com.example.BookManagementSystem.entity.LibraryMember;
import com.example.BookManagementSystem.repository.MemberRepo;
import com.example.BookManagementSystem.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    public ResponseEntity<?> getMemberById(@PathVariable String id){

         Optional<LibraryMember> libraryMember=libraryService.findfById(id);
         if(libraryMember.isPresent()){
             return  new ResponseEntity<>(libraryMember.get(), HttpStatus.OK);
         }else{

             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
         }
    }

    @PostMapping
    public ResponseEntity<?> addMember(@RequestBody LibraryMember member) {
        try {
            libraryService.saveEntry(member); // Attempt to save the member
            return ResponseEntity.status(HttpStatus.CREATED).body("Library member added successfully!");
        } catch (Exception e) {
            // Handle the exception and return an error response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while adding the member: " + e.getMessage());
        }
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable String id) {
        libraryService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
