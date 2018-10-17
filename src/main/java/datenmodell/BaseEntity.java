package datenmodell;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created")
//	@Column(name = "created", nullable = false, insertable = false)
	@Generated(GenerationTime.INSERT)
	private Date createdOn;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated")
	//@Column(name = "updated", nullable = false, updatable = false, insertable = false)
	@Generated(GenerationTime.ALWAYS)
	private Date lastModifiedOn;

	@PrePersist
	public void initTimeStamps() {
		if (createdOn == null) {
			createdOn = new Date();
		}
		lastModifiedOn = createdOn;
	}
	
	@PreUpdate
	public void updateTimeStamp() {
		lastModifiedOn = new Date();
	}
}
