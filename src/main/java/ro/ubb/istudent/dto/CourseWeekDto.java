package ro.ubb.istudent.dto;

import java.util.ArrayList;
import java.util.List;

public class CourseWeekDto implements Dto {

    private String idCourseWeek;

    private Integer nrOfWeekes;

    private List<CourseMaterialDto> courseMaterials;

    private List<LectureDto> lectures;


    public CourseWeekDto(String idCourseWeek, Integer nrOfWeekes) {
        this.idCourseWeek = idCourseWeek;
        this.nrOfWeekes = nrOfWeekes;
        courseMaterials = new ArrayList<>();
        lectures = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CourseWeekDto that = (CourseWeekDto) o;

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


    @Override
    public String toString() {
        return "CourseWeekDto{" +
                "idCourseWeek=" + idCourseWeek +
                ", nrOfWeekes=" + nrOfWeekes +
                ", courseMaterials=" + courseMaterials +
                ", lectures=" + lectures +
                '}';
    }

    public String getIdCourseWeek() {
        return idCourseWeek;
    }

    public void setIdCourseWeek(String idCourseWeek) {
        this.idCourseWeek = idCourseWeek;
    }

    public Integer getNrOfWeekes() {
        return nrOfWeekes;
    }

    public void setNrOfWeekes(Integer nrOfWeekes) {
        this.nrOfWeekes = nrOfWeekes;
    }

    public List<CourseMaterialDto> getCourseMaterials() {
        return courseMaterials;
    }

    public void setCourseMaterials(List<CourseMaterialDto> courseMaterials) {
        this.courseMaterials = courseMaterials;
    }

    public List<LectureDto> getLectures() {
        return lectures;
    }

    public void setLectures(List<LectureDto> lectures) {
        this.lectures = lectures;
    }
}