package ro.ubb.istudent.domain;

import com.mongodb.DuplicateKeyException;
import javassist.bytecode.DuplicateMemberException;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.CheckedOutputStream;

/**
 * Created by Deni on 22/11/2017.
 */

@Document(collection = "teachers")
public class Teacher implements Serializable {

    @Id
    private ObjectId idTeacher;

    private  String name;

    @DBRef
    private List<Course> courses;

    public Teacher(String name) {
        this.name = name;
        courses = new ArrayList<>();
    }

    public void addCourse(Course course) throws DuplicateMemberException {
        if(checkIdInList(course.getIdCourse()) == false)
            courses.add(course);
        else
            throw new DuplicateMemberException("Id already exists.");
    }

    public boolean checkIdInList(ObjectId id){
        for (Course c : courses)
            if(c.getIdCourse().equals(id))
                return true;
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Teacher teacher = (Teacher) o;

        if (!idTeacher.equals(teacher.idTeacher)) return false;
        if (name != null ? !name.equals(teacher.name) : teacher.name != null) return false;
        return courses != null ? courses.equals(teacher.courses) : teacher.courses == null;
    }

    @Override
    public int hashCode() {
        int result = idTeacher.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "idTeacher=" + idTeacher +
                ", name='" + name + '\'' +
                ", courses=" + courses +
                '}';
    }

    public ObjectId getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(ObjectId idTeacher) {
        this.idTeacher = idTeacher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
