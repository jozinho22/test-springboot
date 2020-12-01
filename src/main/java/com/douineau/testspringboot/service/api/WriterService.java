package com.douineau.testspringboot.service.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douineau.testspringboot.dao.api.IWriterDao;
import com.douineau.testspringboot.model.api.Writer;
import com.douineau.testspringboot.service.IGenericApiService;

@Service
public class WriterService implements IGenericApiService<Writer> {
	
	@Autowired
	private IWriterDao repo;

	@Override
	public Writer getObject(Integer id) {
		Optional<Writer> mayBe = repo.findById(id);
		if(mayBe.isPresent()) {
			return mayBe.get();
		} else {
			return null;
		}
	}
	
	@Override
	public List<Writer> getAllObjects() {
		return  (List<Writer>) repo.findAll();
	}

	@Override
	public String addObjects(List<Writer> objects) {
		repo.saveAll(objects);
		return "Objets de type : " + objects.getClass().getTypeName() + " bien insérés";
	}

}
