package ro.ubb.istudent.dto;
import org.bson.types.ObjectId;

public class LectureDto implements Dto {

    private ObjectId lectureId;

    private String description;

    private String filePath;

    private ObjectId idCourseWeek;

    public LectureDto(ObjectId lectureId, String description, String filePath, ObjectId idCourseWeek) {
        this.lectureId = lectureId;
        this.description = description;
        this.filePath = filePath;
        this.idCourseWeek = idCourseWeek;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LectureDto lecture = (LectureDto) o;

        if (!lectureId.equals(lecture.lectureId)) return false;
        if (description != null ? !description.equals(lecture.description) : lecture.description != null) return false;
        if (filePath != null ? !filePath.equals(lecture.filePath) : lecture.filePath != null) return false;
        return idCourseWeek != null ? idCourseWeek.equals(lecture.idCourseWeek) : lecture.idCourseWeek == null;
    }

    @Override
    public int hashCode() {
        int result = lectureId.hashCode();
        result = 31 * result + (filePath != null ? filePath.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "LectureDto{" +
                "lectureId=" + lectureId +
                ", description='" + description + '\'' +
                ", filePath='" + filePath + '\'' +
                ", idCourseWeek=" + idCourseWeek +
                '}';
    }

    public ObjectId getLectureId() {
        return lectureId;
    }

    public void setLectureId(ObjectId lectureId) {
        this.lectureId = lectureId;
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
