package com.example.BookManagementSystem.repository;

import com.example.BookManagementSystem.entity.LibraryMember;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MemberRepo extends MongoRepository<LibraryMember, String> {
}
