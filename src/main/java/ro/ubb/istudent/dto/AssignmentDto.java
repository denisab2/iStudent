package ro.ubb.istudent.dto;

import java.util.Date;

public class AssignmentDto implements Dto {

    private String idAssignment;

    private String description;

    private Date endDate;


    public AssignmentDto(String description, Date endDate) {
        this.description = description;
        this.endDate = endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AssignmentDto that = (AssignmentDto) o;

        if (!idAssignment.equals(that.idAssignment)) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
         return !(endDate != null ? !endDate.equals(that.endDate) : that.endDate != null);
    }

    @Override
    public int hashCode() {
        int result = idAssignment.hashCode();
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AssignmentDto{" +
                "idAssignment=" + idAssignment +
                ", description='" + description + '\'' +
                ", endDate=" + endDate +
                '}';
    }

    public String getIdAssignment() {
        return idAssignment;
    }

    public void setIdAssignment(String idAssignment) {
        this.idAssignment = idAssignment;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
