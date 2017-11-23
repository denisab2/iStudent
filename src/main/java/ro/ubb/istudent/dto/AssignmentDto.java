package ro.ubb.istudent.dto;

import org.bson.types.ObjectId;

import java.util.Date;

public class AssignmentDto implements Dto {

    private ObjectId idAssignment;

    private String description;

    private Date endDate;

    private ObjectId idCourse;


    public AssignmentDto(String description, Date endDate, ObjectId idCourse) {
        this.description = description;
        this.endDate = endDate;
        this.idCourse = idCourse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AssignmentDto that = (AssignmentDto) o;

        if (!idAssignment.equals(that.idAssignment)) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (endDate != null ? !endDate.equals(that.endDate) : that.endDate != null) return false;
        return idCourse != null ? idCourse.equals(that.idCourse) : that.idCourse == null;
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
                ", idCourse=" + idCourse +
                '}';
    }

    public ObjectId getIdAssignment() {
        return idAssignment;
    }

    public void setIdAssignment(ObjectId idAssignment) {
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

    public ObjectId getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(ObjectId idCourse) {
        this.idCourse = idCourse;
    }
}
