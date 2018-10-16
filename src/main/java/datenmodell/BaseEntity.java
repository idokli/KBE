package datenmodell;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseEntity {
	
	private long id;
	
	private Date created;
	
	private Date lastModified;

}
