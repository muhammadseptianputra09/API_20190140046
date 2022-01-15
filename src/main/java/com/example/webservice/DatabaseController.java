/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.webservice;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Unang
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/Penjualan")
public class DatabaseController {
    @Autowired
    RepositoryPenjualan repositoryPenjualan;
            
    @PostMapping(value = "/addPenjualan")
    public Penjualan addPenjualan(@RequestBody Penjualan Param)
    {
        repositoryPenjualan.save(Param);
        return Param;
    }
    
    @GetMapping(value = "/allPenjualan")
    public List<Penjualan> allPenjualan()
    {
        return repositoryPenjualan.findAll();
    }
    
    @PutMapping(value = "/updatePenjualan")
    public Penjualan updatePenjualan(@RequestBody Penjualan Param)
    {
       return repositoryPenjualan.save(Param);
    }
    
    @DeleteMapping(value = "/hapusPenjualan")
    public List<Penjualan> hapusPenjualan(@RequestParam int id)
    {
        repositoryPenjualan.deleteById(id);
        List<Penjualan> Penjualanlist = repositoryPenjualan.findAll();
        return Penjualanlist;
    }
    @GetMapping ("/alltoPenjualan")
    public Penjualan  addPenjualan(@RequestParam int id)
    {
      return repositoryPenjualan.findById(id).get();  
    }
}
