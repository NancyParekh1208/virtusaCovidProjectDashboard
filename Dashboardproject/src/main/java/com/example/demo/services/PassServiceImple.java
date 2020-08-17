package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.PassRequest;
import com.example.demo.repository.PassRepository;




@Service
public class PassServiceImple implements PassService{
	
	@Autowired
	private PassRepository passRepository;
	
	@Override
	 public List < PassRequest > getAllPassRequests() {
       return passRepository.findAll();
   }

   @Override
   public void savePassRequest(PassRequest passrequest) {
       this.passRepository.save(passrequest);
   }
   
   @Override
   public PassRequest getPassRequestById(long id) {
       Optional < PassRequest > optional = passRepository.findById(id);
       PassRequest passrequest = null;
       if (optional.isPresent()) {
           passrequest = optional.get();
       } else {
           throw new RuntimeException(" Pass Request not found for id :: " + id);
       }
       return passrequest;
   }
   
   @Override
   public PassRequest searchPassRequest(PassRequest passrequest)
   {
   	return passRepository.findBySourceNameAndDestinationName(passrequest.getSourceName(), passrequest.getDestinationName());
   }
}
