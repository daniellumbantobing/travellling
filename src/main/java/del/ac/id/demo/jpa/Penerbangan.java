package del.ac.id.demo.jpa;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="t_penerbangan")
public class Penerbangan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	@Column(name="dari")
	private String dari;
	@Column(name="ke")
	private String ke;
	@Column(name="nomor")
	private String nomor;
	@Column(name="pergi")
	private String pergi;
	@Column(name="kembali")
	private String kembali;
	
	public Penerbangan() {}
	
	public Penerbangan(Long id, String dari, String ke, String nomor, String pergi, String kembali) {
		super();
		this.id = id;
		this.dari = dari;
		this.ke = ke;
		this.nomor = nomor;
		this.pergi = pergi;
		this.kembali = kembali;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDari() {
		return dari;
	}

	public void setDari(String dari) {
		this.dari = dari;
	}

	public String getKe() {
		return ke;
	}

	public void setKe(String ke) {
		this.ke = ke;
	}

	public String getNomor() {
		return nomor;
	}

	public void setNomor(String nomor) {
		this.nomor = nomor;
	}

	public String getPergi() {
		return pergi;
	}

	public void setPergi(String pergi) {
		this.pergi = pergi;
	}

	public String getKembali() {
		return kembali;
	}

	public void setKembali(String kembali) {
		this.kembali = kembali;
	}

	
	
}
