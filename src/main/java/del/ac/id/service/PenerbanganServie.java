package del.ac.id.service;

import java.util.List;

import del.ac.id.demo.jpa.Penerbangan;

public interface PenerbanganServie {
	List<Penerbangan> getAllPenerbangan();
	void savePenerbangan(Penerbangan penerbangan);
	void deletePenerbanganId(long id);
	Penerbangan getPenerbanganById(long id);

}
