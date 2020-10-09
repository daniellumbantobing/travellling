package del.ac.id.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import del.ac.id.demo.jpa.Penerbangan;
import del.ac.id.demo.jpa.PenerbanganRepository;


@Service
public class PenerbanganServiceImpl implements PenerbanganServie {
	@Autowired
	private PenerbanganRepository penerbanganRepository;

	@Override
	public List<Penerbangan> getAllPenerbangan() {
		return this.penerbanganRepository.findAll();
	}

	@Override
	public void savePenerbangan(Penerbangan penerbangan) {
		 this.penerbanganRepository.save(penerbangan);
		
	}

	@Override
	public void deletePenerbanganId(long id) {
		this.penerbanganRepository.deleteById(id);
		
	}

	@Override
	public Penerbangan getPenerbanganById(long id) {
		Optional<Penerbangan> optional = penerbanganRepository.findById(id);
		Penerbangan penerbangan = null;
		if(optional.isPresent()) {
			penerbangan = optional.get();
		}else {
			throw new RuntimeException("Employee tidak ditemukan");
		}
		return penerbangan;
	}
	
	

}
