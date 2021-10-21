package com.company.collection.dao;

import com.company.collection.dto.Toy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToyDao extends JpaRepository<Toy, Integer> {

    List<Toy> findByFaction(String faction);

    List<Toy> findByToyLine(String toyLine);

}
