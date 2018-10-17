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

import lombok.AccessLevel;
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

	@Setter(value = AccessLevel.NONE)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created")
	private Date createdOn;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated")
	private Date lastModifiedOn;
	public final boolean isNew() {
        return this.id == null;
    }

    @PrePersist
    public void prePersist() {
        this.audit();
    }

    @PreUpdate
    public void preUpdate() {
        this.audit();
    }
    
    private void audit() {
        if (this.isNew()) {
            this.createdOn = new Date();
        }
        this.lastModifiedOn = new Date();
    }
}
