package ro.ubb.istudent.domain;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Deni on 22/11/2017.
 */
@Document(collection = "assignments")
public class Assignment implements Serializable {

    @Id
    private ObjectId idAssignment;

    private String description;

    private Date endDate;

    private ObjectId idCourse;


    public Assignment(String description, Date endDate, ObjectId idCourse) {
        this.description = description;
        this.endDate = endDate;
        this.idCourse = idCourse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Assignment that = (Assignment) o;

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
