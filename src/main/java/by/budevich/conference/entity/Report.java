package by.budevich.conference.entity;

import java.io.Serializable;

/**
 * Created by Asus on 27.12.2017.
 */
public class Report  implements Serializable, Cloneable {
    private long reportId;
    private String reportName;
    private String reportTheses;
    private String reportStatus;
    private String reportContent;

    public Report () {}

    public Report(long reportId, String reportName, String reportTheses, String reportStatus, String reportContent) {
        this.reportId = reportId;
        this.reportName = reportName;
        this.reportTheses = reportTheses;
        this.reportStatus = reportStatus;
        this.reportContent = reportContent;
    }

    public Report (String reportName, String reportTheses){
        this.reportName = reportName;
        this.reportTheses = reportTheses;
    }

    public long getReportId() {
        return reportId;
    }

    public void setReportId(long reportId) {
        this.reportId = reportId;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public String getReportTheses() {
        return reportTheses;
    }

    public void setReportTheses(String reportTheses) {
        this.reportTheses = reportTheses;
    }

    public String getReportStatus() {
        return reportStatus;
    }

    public void setReportStatus(String reportStatus) {
        this.reportStatus = reportStatus;
    }

    public String getReportContent() {
        return reportContent;
    }

    public void setReportContent(String reportContent) {
        this.reportContent = reportContent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Report report = (Report) o;

        if (reportId != report.reportId) return false;
        if (reportName != null ? !reportName.equals(report.reportName) : report.reportName != null) return false;
        if (reportTheses != null ? !reportTheses.equals(report.reportTheses) : report.reportTheses != null)
            return false;
        if (reportStatus != null ? !reportStatus.equals(report.reportStatus) : report.reportStatus != null)
            return false;
        return reportContent != null ? reportContent.equals(report.reportContent) : report.reportContent == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (reportId ^ (reportId >>> 32));
        result = 31 * result + (reportName != null ? reportName.hashCode() : 0);
        result = 31 * result + (reportTheses != null ? reportTheses.hashCode() : 0);
        result = 31 * result + (reportStatus != null ? reportStatus.hashCode() : 0);
        result = 31 * result + (reportContent != null ? reportContent.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Report{" +
                "reportId=" + reportId +
                ", reportName='" + reportName + '\'' +
                ", reportTheses='" + reportTheses + '\'' +
                ", reportStatus='" + reportStatus + '\'' +
                ", reportContent='" + reportContent + '\'' +
                '}';
    }
}
