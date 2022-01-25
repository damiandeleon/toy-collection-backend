package com.company.collection.controller;

import com.company.collection.dao.ToyDao;
import com.company.collection.dto.Toy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/toys")
public class toyController {

    @Autowired
    private ToyDao toyDao;


    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Toy createToy(@RequestBody Toy toy){
        System.out.println(toy);

        toyDao.save(toy);
        return toy;
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public List<Toy> getAllToys() {
        System.out.println("GETTING ALL TOYS");
        return toyDao.findAll();
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Toy updateToy(@RequestBody Toy toy, @PathVariable Integer id){
        System.out.println("UPDATING TOY");
        return toyDao.save(toy);
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Optional<Toy> getToyById(@PathVariable Integer id){
        System.out.println("GETTING TOY");
        return toyDao.findById(id);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteToy(@PathVariable Integer id) {
        System.out.println("DELETING TOY");
        toyDao.delete(toyDao.getById(id));
    }
}
