package com.douineau.testspringboot.service.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douineau.testspringboot.dao.api.IReaderDao;
import com.douineau.testspringboot.model.api.Reader;
import com.douineau.testspringboot.service.IGenericApiService;

@Service
public class ReaderService implements IGenericApiService<Reader> {
	
	@Autowired 
	private IReaderDao repo;

	@Override
	public Reader getObject(Integer id) {
		Optional<Reader> mayBe = repo.findById(id);
		if(mayBe.isPresent()) {
			return mayBe.get();
		} else {
			return null;
		}
	}
	
	@Override
	public List<Reader> getAllObjects() {
		return  (List<Reader>) repo.findAll();
	}

	@Override
	public String addObjects(List<Reader> objects) {
		repo.saveAll(objects);
		return "Objets de type : " + objects.getClass().getTypeName() + " bien insérés";
	}
}
