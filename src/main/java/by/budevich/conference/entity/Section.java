package by.budevich.conference.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Asus on 27.12.2017.
 */
public class Section implements Serializable, Cloneable{
    private long sectionId;
    private long conferenceId;
    private String sectionName;
    private int maxNumberReports;
    private Date sectionBeginning;
    private Date sectionEnd;
    private String sectionAddress;
    private String sectionContent;
    private String sectionStatus;

    public Section () {}

    public Section(long sectionId, long conferenceId, String sectionName,
                   int maxNumberReports, Date sectionBeginning, Date sectionEnd,
                   String sectionAddress, String sectionContent, String sectionStatus) {
        this.sectionId = sectionId;
        this.conferenceId = conferenceId;
        this.sectionName = sectionName;
        this.maxNumberReports = maxNumberReports;
        this.sectionBeginning = sectionBeginning;
        this.sectionEnd = sectionEnd;
        this.sectionAddress = sectionAddress;
        this.sectionContent = sectionContent;
        this.sectionStatus = sectionStatus;
    }

    public Section (long conferenceId, String sectionName){
        this.conferenceId = conferenceId;
        this.sectionName = sectionName;
    }

    public long getSectionId() {
        return sectionId;
    }

    public void setSectionId(long sectionId) {
        this.sectionId = sectionId;
    }

    public long getConferenceId() {
        return conferenceId;
    }

    public void setConferenceId(long conferenceId) {
        this.conferenceId = conferenceId;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public int getMaxNumberReports() {
        return maxNumberReports;
    }

    public void setMaxNumberReports(int maxNumberReports) {
        this.maxNumberReports = maxNumberReports;
    }

    public Date getSectionBeginning() {
        return sectionBeginning;
    }

    public void setSectionBeginning(Date sectionBeginning) {
        this.sectionBeginning = sectionBeginning;
    }

    public Date getSectionEnd() {
        return sectionEnd;
    }

    public void setSectionEnd(Date sectionEnd) {
        this.sectionEnd = sectionEnd;
    }

    public String getSectionAddress() {
        return sectionAddress;
    }

    public void setSectionAddress(String sectionAddress) {
        this.sectionAddress = sectionAddress;
    }

    public String getSectionContent() {
        return sectionContent;
    }

    public void setSectionContent(String sectionContent) {
        this.sectionContent = sectionContent;
    }

    public String getSectionStatus() {
        return sectionStatus;
    }

    public void setSectionStatus(String sectionStatus) {
        this.sectionStatus = sectionStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Section section = (Section) o;

        if (sectionId != section.sectionId) return false;
        if (conferenceId != section.conferenceId) return false;
        if (maxNumberReports != section.maxNumberReports) return false;
        if (sectionName != null ? !sectionName.equals(section.sectionName) : section.sectionName != null) return false;
        if (sectionBeginning != null ? !sectionBeginning.equals(section.sectionBeginning) : section.sectionBeginning != null)
            return false;
        if (sectionEnd != null ? !sectionEnd.equals(section.sectionEnd) : section.sectionEnd != null) return false;
        if (sectionAddress != null ? !sectionAddress.equals(section.sectionAddress) : section.sectionAddress != null)
            return false;
        if (sectionContent != null ? !sectionContent.equals(section.sectionContent) : section.sectionContent != null)
            return false;
        return sectionStatus != null ? sectionStatus.equals(section.sectionStatus) : section.sectionStatus == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (sectionId ^ (sectionId >>> 32));
        result = 31 * result + (int) (conferenceId ^ (conferenceId >>> 32));
        result = 31 * result + (sectionName != null ? sectionName.hashCode() : 0);
        result = 31 * result + maxNumberReports;
        result = 31 * result + (sectionBeginning != null ? sectionBeginning.hashCode() : 0);
        result = 31 * result + (sectionEnd != null ? sectionEnd.hashCode() : 0);
        result = 31 * result + (sectionAddress != null ? sectionAddress.hashCode() : 0);
        result = 31 * result + (sectionContent != null ? sectionContent.hashCode() : 0);
        result = 31 * result + (sectionStatus != null ? sectionStatus.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Section{" +
                "sectionId=" + sectionId +
                ", conferenceId=" + conferenceId +
                ", sectionName='" + sectionName + '\'' +
                ", maxNumberReports=" + maxNumberReports +
                ", sectionBeginning=" + sectionBeginning +
                ", sectionEnd=" + sectionEnd +
                ", sectionAddress='" + sectionAddress + '\'' +
                ", sectionContent='" + sectionContent + '\'' +
                ", sectionStatus='" + sectionStatus + '\'' +
                '}';
    }
}



