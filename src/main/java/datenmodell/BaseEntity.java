package datenmodell;

import java.util.Date;

import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseEntity {
	
	@Id
	private long id;
	
	private Date created;
	
	private Date lastModified;

}
