package by.budevich.conference.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by Asus on 15.01.2018.
 */
public class Conference implements Serializable, Cloneable{
    private long conferenceId;
    private String conferenceName;
    private String conferenceDescription;
    private int maxNumberParticipiants;
    private Timestamp conferenceBeginning;
    private Timestamp conferenceEnd;
    private String conferenceCountry;
    private String conferenceCity;
    private String conferenceAddress;
    private String conferenceContent;
    private String conferenceStatus = "RECRUITED";

    public Conference () {}

    public Conference(long conferenceId, String conferenceName, String conferenceDescription,
                      int maxNumberParticipiants, Timestamp conferenceBeginning, Timestamp conferenceEnd,
                      String conferenceCountry, String conferenceCity, String conferenceAddress,
                      String conferenceContent, String conferenceStatus) {
        this.conferenceId = conferenceId;
        this.conferenceName = conferenceName;
        this.conferenceDescription = conferenceDescription;
        this.maxNumberParticipiants = maxNumberParticipiants;
        this.conferenceBeginning = conferenceBeginning;
        this.conferenceEnd = conferenceEnd;
        this.conferenceCountry = conferenceCountry;
        this.conferenceCity = conferenceCity;
        this.conferenceAddress = conferenceAddress;
        this.conferenceContent = conferenceContent;
        this.conferenceStatus = conferenceStatus;
    }

    public Conference (String conferenceName){
        this.conferenceName = conferenceName;
    }

    public long getConferenceId() {
        return conferenceId;
    }

    public void setConferenceId(long conferenceId) {
        this.conferenceId = conferenceId;
    }

    public String getConferenceName() {
        return conferenceName;
    }

    public void setConferenceName(String conferenceName) {
        this.conferenceName = conferenceName;
    }

    public String getConferenceDescription() {
        return conferenceDescription;
    }

    public void setConferenceDescription(String conferenceDescription) {
        this.conferenceDescription = conferenceDescription;
    }

    public int getMaxNumberParticipiants() {
        return maxNumberParticipiants;
    }

    public void setMaxNumberParticipiants(int maxNumberParticipiants) {
        this.maxNumberParticipiants = maxNumberParticipiants;
    }

    public Timestamp getConferenceBeginning() {
        return conferenceBeginning;
    }

    public void setConferenceBeginning(Timestamp conferenceBeginning) {
        this.conferenceBeginning = conferenceBeginning;
    }

    public Timestamp getConferenceEnd() {
        return conferenceEnd;
    }

    public void setConferenceEnd(Timestamp conferenceEnd) {
        this.conferenceEnd = conferenceEnd;
    }

    public String getConferenceCountry() {
        return conferenceCountry;
    }

    public void setConferenceCountry(String conferenceCountry) {
        this.conferenceCountry = conferenceCountry;
    }

    public String getConferenceCity() {
        return conferenceCity;
    }

    public void setConferenceCity(String conferenceCity) {
        this.conferenceCity = conferenceCity;
    }

    public String getConferenceAddress() {
        return conferenceAddress;
    }

    public void setConferenceAddress(String conferenceAddress) {
        this.conferenceAddress = conferenceAddress;
    }

    public String getConferenceContent() {
        return conferenceContent;
    }

    public void setConferenceContent(String conferenceContent) {
        this.conferenceContent = conferenceContent;
    }

    public String getConferenceStatus() {
        return conferenceStatus;
    }

    public void setConferenceStatus(String conferenceStatus) {
        this.conferenceStatus = conferenceStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Conference that = (Conference) o;

        if (conferenceId != that.conferenceId) return false;
        if (maxNumberParticipiants != that.maxNumberParticipiants) return false;
        if (conferenceName != null ? !conferenceName.equals(that.conferenceName) : that.conferenceName != null)
            return false;
        if (conferenceDescription != null ? !conferenceDescription.equals(that.conferenceDescription) : that.conferenceDescription != null)
            return false;
        if (conferenceBeginning != null ? !conferenceBeginning.equals(that.conferenceBeginning) : that.conferenceBeginning != null)
            return false;
        if (conferenceEnd != null ? !conferenceEnd.equals(that.conferenceEnd) : that.conferenceEnd != null)
            return false;
        if (conferenceCountry != null ? !conferenceCountry.equals(that.conferenceCountry) : that.conferenceCountry != null)
            return false;
        if (conferenceCity != null ? !conferenceCity.equals(that.conferenceCity) : that.conferenceCity != null)
            return false;
        if (conferenceAddress != null ? !conferenceAddress.equals(that.conferenceAddress) : that.conferenceAddress != null)
            return false;
        if (conferenceContent != null ? !conferenceContent.equals(that.conferenceContent) : that.conferenceContent != null)
            return false;
        return conferenceStatus != null ? conferenceStatus.equals(that.conferenceStatus) : that.conferenceStatus == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (conferenceId ^ (conferenceId >>> 32));
        result = 31 * result + (conferenceName != null ? conferenceName.hashCode() : 0);
        result = 31 * result + (conferenceDescription != null ? conferenceDescription.hashCode() : 0);
        result = 31 * result + maxNumberParticipiants;
        result = 31 * result + (conferenceBeginning != null ? conferenceBeginning.hashCode() : 0);
        result = 31 * result + (conferenceEnd != null ? conferenceEnd.hashCode() : 0);
        result = 31 * result + (conferenceCountry != null ? conferenceCountry.hashCode() : 0);
        result = 31 * result + (conferenceCity != null ? conferenceCity.hashCode() : 0);
        result = 31 * result + (conferenceAddress != null ? conferenceAddress.hashCode() : 0);
        result = 31 * result + (conferenceContent != null ? conferenceContent.hashCode() : 0);
        result = 31 * result + (conferenceStatus != null ? conferenceStatus.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Conference{" +
                "conferenceId=" + conferenceId +
                ", conferenceName='" + conferenceName + '\'' +
                ", conferenceDescription='" + conferenceDescription + '\'' +
                ", maxNumberParticipiants=" + maxNumberParticipiants +
                ", conferenceBeginning=" + conferenceBeginning +
                ", conferenceEnd=" + conferenceEnd +
                ", conferenceCountry='" + conferenceCountry + '\'' +
                ", conferenceCity='" + conferenceCity + '\'' +
                ", conferenceAddress='" + conferenceAddress + '\'' +
                ", conferenceContent='" + conferenceContent + '\'' +
                ", conferenceStatus='" + conferenceStatus + '\'' +
                '}';
    }
}
