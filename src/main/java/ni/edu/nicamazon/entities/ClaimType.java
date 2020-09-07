package ni.edu.nicamazon.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "E_CLAIM_TYPE")
public class ClaimType implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "CLAIM_TYPE", nullable = false)
    private String claimType;

    public String getClaimType() {
        return claimType;
    }

    public void setClaimType(String claimType) {
        this.claimType = claimType;
    }
}
