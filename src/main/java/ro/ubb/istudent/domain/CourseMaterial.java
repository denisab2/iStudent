package ro.ubb.istudent.domain;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * Created by Deni on 22/11/2017.
 */
@Document(collection = "courseMaterials")
public class CourseMaterial implements Serializable {


    @Id
    private ObjectId materialsId;

    private String description;

    private String filePath;

    private ObjectId idCourseWeek;

    public CourseMaterial(ObjectId materialsId, String description, String filePath, ObjectId idCourseWeek) {
        this.materialsId = materialsId;
        this.description = description;
        this.filePath = filePath;
        this.idCourseWeek = idCourseWeek;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CourseMaterial that = (CourseMaterial) o;

        if (!materialsId.equals(that.materialsId)) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (filePath != null ? !filePath.equals(that.filePath) : that.filePath != null) return false;
        return idCourseWeek != null ? idCourseWeek.equals(that.idCourseWeek) : that.idCourseWeek == null;
    }

    @Override
    public int hashCode() {
        int result = materialsId.hashCode();
        result = 31 * result + (filePath != null ? filePath.hashCode() : 0);
        return result;
    }

    public ObjectId getMaterialsId() {
        return materialsId;
    }

    public void setMaterialsId(ObjectId materialsId) {
        this.materialsId = materialsId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public ObjectId getIdCourseWeek() {
        return idCourseWeek;
    }

    public void setIdCourseWeek(ObjectId idCourseWeek) {
        this.idCourseWeek = idCourseWeek;
    }
}