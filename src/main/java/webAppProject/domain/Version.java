package webAppProject.domain;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="version")
public class Version {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String version, description;
	
	@ManyToOne
	@JoinColumn(name="SCIid")
	private SCI sci;
	
	
	public Integer getId(){
		return id;
	}
	
	public void setId(Integer id){
		this.id = id;
	}
	
	public String getVersion(){
		return version;
	}
	
	public void setVersion(String version){
		this.version = version;
	}
	
	public String getDescription(){
		return description;
	}
	
	public void setDescription(String description){
		this.description = description;
	}
	
	public SCI getsci(){
		return this.sci;
	}
	
	public void setsci(SCI sci){
		this.sci = sci;
	}
	
	public String toString(){
		return version;
	}
	
}
