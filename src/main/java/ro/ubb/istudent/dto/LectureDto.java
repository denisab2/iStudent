package ro.ubb.istudent.dto;

public class LectureDto implements Dto {

    private String lectureId;

    private String description;

    private String filePath;

    public LectureDto(String lectureId, String description, String filePath) {
        this.lectureId = lectureId;
        this.description = description;
        this.filePath = filePath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LectureDto lecture = (LectureDto) o;

        if (!lectureId.equals(lecture.lectureId)) return false;
        if (description != null ? !description.equals(lecture.description) : lecture.description != null) return false;
        return !(filePath != null ? !filePath.equals(lecture.filePath) : lecture.filePath != null);
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
                '}';
    }

    public String getLectureId() {
        return lectureId;
    }

    public void setLectureId(String lectureId) {
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
}
