package com.maronecom.first.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maronecom.first.models.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{}
