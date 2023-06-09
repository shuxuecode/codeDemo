package com.zsx.dto;

/**
 * @author 
 * @date 2023/6/8
 */
public class WorkerDTO extends ParentDTO {
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "WorkerDTO{" +
                "title='" + title + '\'' +
                "} " + super.toString();
    }
}
