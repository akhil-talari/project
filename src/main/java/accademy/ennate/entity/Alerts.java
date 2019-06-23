package accademy.ennate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Alerts {
    @Id //primary key
    @Column(columnDefinition = "VARCHAR(36)")
    private String vin;

    private String HighAlert;

    private String LowAlert;

    private String MediumAlert;

    public String getHighAlert() {
        return HighAlert;
    }

    public void setHighAlert(String highAlert) {
        HighAlert = highAlert;
    }

    public String getLowAlert() {
        return LowAlert;
    }

    public void setLowAlert(String lowAlert) {
        LowAlert = lowAlert;
    }

    public String getMediumAlert() {
        return MediumAlert;
    }

    public void setMediumAlert(String mediumAlert) {
        MediumAlert = mediumAlert;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }


}
