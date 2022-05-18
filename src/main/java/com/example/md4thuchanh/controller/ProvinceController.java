package com.example.md4thuchanh.controller;

import com.example.md4thuchanh.model.Country;
import com.example.md4thuchanh.model.Province;
import com.example.md4thuchanh.service.Country.ICountryService;
import com.example.md4thuchanh.service.province.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
@CrossOrigin("*")
public class ProvinceController {

    @Autowired
    private IProvinceService provinceService;

    @Autowired
    private ICountryService countryService;

    @ModelAttribute("countries")
    public Iterable<Country> countries(){
        return countryService.findAll();
    }
//
//    @GetMapping("")
//    public ModelAndView showList(){
//        ModelAndView modelAndView = new ModelAndView("listProvince");
//        modelAndView.addObject("province", provinceService.findAll());
//        return modelAndView;
//    }

    @GetMapping("/province")
    public ResponseEntity<Iterable<Province>> getAll(){
        Iterable<Province> provinces = provinceService.findAll();
        return new ResponseEntity<>(provinces, HttpStatus.OK);
    }

    @PostMapping("/province")
    public ResponseEntity<Province> createNewProvince(@RequestBody Province province){
        provinceService.save(province);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/province/{id}")
    public ResponseEntity<Province> deleteProvince(@PathVariable Long id){
        Optional<Province> provinceOptional = provinceService.findById(id);
        provinceService.remove(id);
        return new ResponseEntity<>(provinceOptional.get(),HttpStatus.NO_CONTENT);
    }

    @PutMapping("/province/{id}")
    public ResponseEntity<Province> editProvince(@PathVariable Long id, @RequestBody Province province){
        Optional<Province> provinceOptional = provinceService.findById(id);
        province.setId(provinceOptional.get().getId());
        if (!provinceOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        provinceService.save(province);
        return new ResponseEntity<>(provinceOptional.get(), HttpStatus.OK);
    }
}
