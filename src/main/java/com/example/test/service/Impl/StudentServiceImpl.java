package com.example.test.service.Impl;

import com.example.test.bean.Student;
import com.example.test.mapper.StudentMapper;
import com.example.test.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentMapper studentMapper;
    @Override
    public Map<String,String> addStudent(String studentName, String studentNum,
              Integer sex, Integer age, String birthday, String telephone,String pName,String pPosition,
              String pEnterDate,String pGraduateDate,String jName,String jPosition,String jEnterDate,
              String jGraduateDate,String sName,String sPosition,String sEnterDate,String sGraduateDate,
              Integer familyNum,String familyPosition,String fName,String fPhone,String fWorkplace,
              String mName,String mPhone,String mWorkplace) {
        Map<String,String> res = new HashMap<>();

        Student student = new Student();
        student = check(student,studentName,studentNum,sex,age,birthday,telephone,pName,pPosition,
                pEnterDate, pGraduateDate, jName, jPosition, jEnterDate,
                jGraduateDate, sName, sPosition, sEnterDate, sGraduateDate,
                familyNum, familyPosition, fName, fPhone, fWorkplace,
                mName, mPhone, mWorkplace);
        try {
            studentMapper.addStudent(student);
            res.put("code","0");
            res.put("msg","添加学生基本信息成功");
        }catch (Exception e){
            res.put("code","1");
            res.put("msg","添加学生基本信息失败");
            res.put("error", String.valueOf(e));
        }
        return res;
    }

    @Override
    public Map<String, String> updateStudent(Integer id,String studentName, String studentNum,
              Integer sex, Integer age, String birthday, String telephone,String pName,String pPosition,
              String pEnterDate,String pGraduateDate,String jName,String jPosition,String jEnterDate,
              String jGraduateDate,String sName,String sPosition,String sEnterDate,String sGraduateDate,
              Integer familyNum,String familyPosition,String fName,String fPhone,String fWorkplace,
              String mName,String mPhone,String mWorkplace) {
        Map<String, String> res = new HashMap<>();
        try {
        Student student = studentMapper.getStudent(studentMapper.getStuIdByNum(id));
        if(student == null){
            res.put("code","1");
            res.put("msg","更新失败，查无此人");
            return res;
        }else {
            student = check(student,studentName,studentNum,sex,age,birthday,telephone,pName,pPosition,
                    pEnterDate, pGraduateDate, jName, jPosition, jEnterDate,
                    jGraduateDate, sName, sPosition, sEnterDate, sGraduateDate,
                    familyNum, familyPosition, fName, fPhone, fWorkplace,
                    mName, mPhone, mWorkplace);
        }

            studentMapper.updateStudent(student);
            res.put("code","0");
            res.put("msg","更新成功");
        }catch (Exception e){
            res.put("code","2");
            res.put("msg","更新失败");
            res.put("error", String.valueOf(e));
        }
        return res;
    }

    @Override
    public Map<String, String> getStuBaseInfo(Integer id) {

        Student student = studentMapper.getStudent(id);
        Map<String,String> res = new HashMap<>();
        if(student == null){
            res.put("code","1");
            res.put("msg","查无此人");
            return res;
        }
        res = setInfo(res,student);
        if(student.getSex() == null){
            res.put("sex","0");
        }else res.put("sex",student.getSex()==1?"男":"女");
        return res;
    }

    @Override
    public Map<String, String> deleteStu(Integer id) {
        Map<String, String> res = new HashMap<>();
        try{
            Integer sid = studentMapper.getStuIdByNum(id);
            if(studentMapper.deleteStuBase(sid)){
                res.put("code","0");
                res.put("msg","删除成功");
            }else {
                res.put("code","1");
                res.put("msg","删除失败");
            }
        }catch (Exception e){
            res.put("code","2");
            res.put("msg","本无此人");
        }

        return res;
    }

    @Override
    public Integer getNById(Integer id) {
        Integer num = -1;
        try{
            num = studentMapper.getNumById(id);
        }catch (Exception e){
            num = -1;
            System.out.println("-------------------------");
            System.out.println(e);
        }
        return num;
    }

    private static Student check(Student student,String studentName, String studentNum,
             Integer sex, Integer age, String birthday, String telephone,String pName,String pPosition,
             String pEnterDate,String pGraduateDate,String jName,String jPosition,String jEnterDate,
             String jGraduateDate,String sName,String sPosition,String sEnterDate,String sGraduateDate,
             Integer familyNum,String familyPosition,String fName,String fPhone,String fWorkplace,
             String mName,String mPhone,String mWorkplace){

        if(studentName != null && !studentName.equals("undefined"))
            student.setStudentName(studentName);
        if(studentNum != null && !studentNum.equals("undefined"))
            student.setStudentNum(studentNum);
        if(age != null)
            student.setAge(age);
        if(sex != null)
            student.setSex(sex);
        if(telephone != null)
            student.setTelephone(telephone);
        if(birthday != null)
            student.setBirthday(birthday);

        if(pName != null && !pName.equals("undefined"))
            student.setPName(pName);
        if(pPosition != null && !pPosition.equals("undefined"))
            student.setPPosition(pPosition);
        if(pEnterDate != null && !pEnterDate.equals("undefined"))
            student.setPEnterDate(pEnterDate);
        if(pGraduateDate != null && !pGraduateDate.equals("undefined"))
            student.setPGraduateDate(pGraduateDate);
        if(jName != null && !jName.equals("undefined"))
            student.setJName(jName);
        if(jPosition != null && !jPosition.equals("undefined"))
            student.setJPosition(jPosition);
        if(jEnterDate != null && !jEnterDate.equals("undefined"))
            student.setJEnterDate(jEnterDate);
        if(jGraduateDate != null && !jGraduateDate.equals("undefined"))
            student.setJGraduateDate(jGraduateDate);
        if(sName != null && !sName.equals("undefined"))
            student.setSName(sName);
        if(sPosition != null && !sPosition.equals("undefined"))
            student.setSPosition(sPosition);
        if(sEnterDate != null && !sEnterDate.equals("undefined"))
            student.setSEnterDate(sEnterDate);
        if(sGraduateDate != null && !sGraduateDate.equals("undefined"))
            student.setSGraduateDate(sGraduateDate);

        if(familyNum != null )
            student.setFamilyNum(familyNum);
        if(familyPosition != null && !familyPosition.equals("undefined"))
            student.setFamilyPosition(familyPosition);
        if(fName != null && !fName.equals("undefined"))
            student.setFName(fName);
        if(fPhone != null && !fPhone.equals("undefined"))
            student.setFPhone(fPhone);
        if(fWorkplace != null && !fWorkplace.equals("undefined"))
            student.setFWorkplace(fWorkplace);
        if(mName != null && !mName.equals("undefined") )
            student.setMName(mName);
        if(mPhone != null && !mPhone.equals("undefined"))
            student.setMPhone(mPhone);
        if(mWorkplace != null && !mWorkplace.equals("undefined"))
            student.setMWorkplace(mWorkplace);

        return student;
    }
    private static Map<String, String> setInfo(Map<String, String> res,Student student){
        res.put("id",student.getId()+"");
        res.put("studentName",student.getStudentName());
        res.put("studentNum",student.getStudentNum());
        res.put("age",student.getAge()+"");
        res.put("birthday",student.getBirthday());
        res.put("telephone",student.getTelephone());

        res.put("pName",student.getPName());
        res.put("pPosition",student.getPPosition());
        res.put("pEnterDate",student.getPEnterDate());
        res.put("pGraduateDate",student.getPGraduateDate());
        res.put("jName",student.getJName());
        res.put("jPosition",student.getJPosition());
        res.put("jEnterDate",student.getJEnterDate());
        res.put("jGraduateDate",student.getJGraduateDate());
        res.put("sName",student.getSName());
        res.put("sPosition",student.getSPosition());
        res.put("sEnterDate",student.getSEnterDate());
        res.put("sGraduateDate",student.getSGraduateDate());

        res.put("familyNum",student.getFamilyNum()+"");
        res.put("familyPosition",student.getFamilyPosition());
        res.put("fName",student.getFName());
        res.put("fPhone",student.getFPhone());
        res.put("fWorkplace",student.getFWorkplace());
        res.put("mName",student.getMName());
        res.put("mPhone",student.getMPhone());
        res.put("mWorkplace",student.getMWorkplace());

        return res;
    }

}
