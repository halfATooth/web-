package com.example.test.bean;

import lombok.Data;

@Data
public class MainPage {
    private String num;
    private String resume;
    private String blog;
    private String researchArea;
    private String courses;
    private String article;

    public MainPage(String num, String resume, String blog,
                    String researchArea, String courses, String article) {
        this.num = num;
        this.resume = resume;
        this.blog = blog;
        this.researchArea = researchArea;
        this.courses = courses;
        this.article = article;
    }
//    public void update(String num,String resume, String blog,String researchArea,
//                       String courses, String article){
//        if(num != null && !num.equals("")){
//            this.num = num;
//        }
//        if(resume != null && !resume.equals("")){
//            this.resume = resume;
//        }
//        if(blog != null && !blog.equals("")){
//            this.blog = blog;
//        }
//        if(researchArea != null && !researchArea.equals("")){
//            this.researchArea = researchArea;
//        }
//        if(courses != null && !courses.equals("")){
//            this.courses = courses;
//        }
//        if(article != null && !article.equals("")){
//            this.article = article;
//        }
//
//    }
}
