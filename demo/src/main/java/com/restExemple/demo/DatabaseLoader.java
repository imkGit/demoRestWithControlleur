package com.restExemple.demo;



import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements ApplicationRunner {

   private CompagnieDAORepository compagnieRepository;
 
   @Autowired
   public DatabaseLoader(CompagnieDAORepository compagnieRepository) {
       this.compagnieRepository = compagnieRepository;
   }

   @Override
   public void run(ApplicationArguments args) throws Exception {
       this.compagnieRepository.save(new AirCompagnie("Tunisair",LocalDate.MIN, 
    		   LocalDate.MAX,"Paris","Tunis",new BigDecimal(300)));
       
       this.compagnieRepository.findByNomCompagnie("Tunisair").forEach(System.out::println);
   }
   
}