package ro.ubb.istudent.dto;

public class CourseMaterialDto implements Dto {


    private String materialsId;

    private String description;

    private String filePath;

    public CourseMaterialDto(String materialsId, String description, String filePath) {
        this.materialsId = materialsId;
        this.description = description;
        this.filePath = filePath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CourseMaterialDto that = (CourseMaterialDto) o;

        if (!materialsId.equals(that.materialsId)) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        return !(filePath != null ? !filePath.equals(that.filePath) : that.filePath != null);
    }

    @Override
    public int hashCode() {
        int result = materialsId.hashCode();
        result = 31 * result + (filePath != null ? filePath.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CourseMaterialDto{" +
                "materialsId=" + materialsId +
                ", description='" + description + '\'' +
                ", filePath='" + filePath + '\'' +
                '}';
    }

    public String getMaterialsId() {
        return materialsId;
    }

    public void setMaterialsId(String materialsId) {
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
}
