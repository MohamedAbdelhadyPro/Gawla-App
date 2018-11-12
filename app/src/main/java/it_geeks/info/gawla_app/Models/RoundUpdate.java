package it_geeks.info.gawla_app.Models;

public class RoundUpdate {

    private String UpdateImage;

    private String UpdateSubject;

    private String UpdateTime;

    public RoundUpdate(String updateImage, String updateSubject, String updateTime) {
        UpdateImage = updateImage;
        UpdateSubject = updateSubject;
        UpdateTime = updateTime;
    }

    public String getUpdateImage() {
        return UpdateImage;
    }

    public void setUpdateImage(String updateImage) {
        UpdateImage = updateImage;
    }

    public String getUpdateSubject() {
        return UpdateSubject;
    }

    public void setUpdateSubject(String updateSubject) {
        UpdateSubject = updateSubject;
    }

    public String getUpdateTime() {
        return UpdateTime;
    }

    public void setUpdateTime(String updateTime) {
        UpdateTime = updateTime;
    }
}
