package ro.ubb.istudent.domain;

import javassist.bytecode.DuplicateMemberException;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Deni on 22/11/2017.
 */

@Document(collection = "courseWeeks")
public class CourseWeek implements Serializable {

    @Id
    private ObjectId idCourseWeek;

    private Integer nrOfWeekes;

    @DBRef
    private List<CourseMaterial> courseMaterials;

    @DBRef
    private List<Lecture> lectures;



    public void addLecture(Lecture lecture) throws DuplicateMemberException {
        if(checkIdInListLecture(lecture.getLectureId()) == false)
            lectures.add(lecture);
        else
            throw new DuplicateMemberException("Id already exists.");
    }

    public boolean checkIdInListLecture(ObjectId id){
        for (Lecture c : lectures)
            if(c.getLectureId().equals(id))
                return true;
        return false;
    }


    public void addCourseMaterial(CourseMaterial courseMat) throws DuplicateMemberException {
        if(checkIdInListMaterial(courseMat.getMaterialsId()) == false)
            courseMaterials.add(courseMat);
        else
            throw new DuplicateMemberException("Id already exists.");
    }

    public boolean checkIdInListMaterial(ObjectId id){
        for (CourseMaterial c : courseMaterials)
            if(c.getMaterialsId().equals(id))
                return true;
        return false;
    }


    public CourseWeek(ObjectId idCourseWeek, Integer nrOfWeekes) {
        this.idCourseWeek = idCourseWeek;
        this.nrOfWeekes = nrOfWeekes;
        courseMaterials = new ArrayList<>();
        lectures = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CourseWeek that = (CourseWeek) o;

        if (!idCourseWeek.equals(that.idCourseWeek)) return false;
        if (nrOfWeekes != null ? !nrOfWeekes.equals(that.nrOfWeekes) : that.nrOfWeekes != null) return false;
        if (courseMaterials != null ? !courseMaterials.equals(that.courseMaterials) : that.courseMaterials != null)
            return false;
        return lectures != null ? lectures.equals(that.lectures) : that.lectures == null;
    }

    @Override
    public int hashCode() {
        int result = idCourseWeek.hashCode();
        result = 31 * result + (nrOfWeekes != null ? nrOfWeekes.hashCode() : 0);
        return result;
    }

    public ObjectId getIdCourseWeek() {
        return idCourseWeek;
    }

    public void setIdCourseWeek(ObjectId idCourseWeek) {
        this.idCourseWeek = idCourseWeek;
    }

    public Integer getNrOfWeekes() {
        return nrOfWeekes;
    }

    public void setNrOfWeekes(Integer nrOfWeekes) {
        this.nrOfWeekes = nrOfWeekes;
    }

    public List<CourseMaterial> getCourseMaterials() {
        return courseMaterials;
    }

    public void setCourseMaterials(List<CourseMaterial> courseMaterials) {
        this.courseMaterials = courseMaterials;
    }

    public List<Lecture> getLectures() {
        return lectures;
    }

    public void setLectures(List<Lecture> lectures) {
        this.lectures = lectures;
    }
}
