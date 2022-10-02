package com.example.test.service.Impl;

import com.example.test.bean.HeadImg;
import com.example.test.controller.UpDownloadImgController;
import com.example.test.mapper.HeadImgMapper;
import com.example.test.service.UpDownloadImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
@Service
public class UpDownloadServiceImpl implements UpDownloadImgService {
    @Autowired
    private HeadImgMapper headImgMapper;
    @Override
    public Map<String, String> upload(MultipartFile img, String studentNum) {
        Map<String,String> res = new HashMap<>();
        //获取文件名
        String fileName = img.getOriginalFilename();
        //获取文件后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        //重新生成文件名
        fileName = studentNum + suffixName;
        //指定本地文件夹存储图片，写到需要保存的目录下/home/lhs/project/headImg/
        String s = "D:\\IDEA-workspace\\web\\src\\main\\res\\headImg/";
//        String filePath = s.substring(6);

        String ss = headImgMapper.getFileName(studentNum);
        if(ss == null){
            headImgMapper.addImg(new HeadImg(studentNum,fileName));
        }else {
            headImgMapper.updateImg(new HeadImg(studentNum,fileName));
        }

        try {
            //将图片保存到static文件夹里
            img.transferTo(new File(s + fileName));
            res.put("code","0");
            res.put("msg","上传成功");
        } catch (Exception e) {
            e.printStackTrace();
            res.put("code","1");
            res.put("msg","上传失败");
        }
        return res;
    }

    @Override
    public void download(HttpServletResponse response, String num) {
        Map<String,String> res = new HashMap<>();
        try {
            // path是指想要下载的文件的路径/home/lhs/project/otherImg/a.png
            String fileName = headImgMapper.getFileName(num);
            if(fileName == null)return;
            File file = new File("D:\\IDEA-workspace\\web\\src\\main\\res\\headImg/"+fileName);
//            log.info(file.getPath());
            // 获取文件名
            String filename = file.getName();
            // 获取文件后缀名
            String ext = filename.substring(filename.lastIndexOf(".") + 1).toLowerCase();
//            log.info("文件后缀名：" + ext);

            // 将文件写入输入流
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStream fis = new BufferedInputStream(fileInputStream);
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();

            // 清空response
            response.reset();
            // 设置response的Header
            response.setCharacterEncoding("UTF-8");
            //Content-Disposition的作用：告知浏览器以何种方式显示响应返回的文件，用浏览器打开还是以附件的形式下载到本地保存
            //attachment表示以附件方式下载   inline表示在线打开   "Content-Disposition: inline; filename=文件名.mp3"
            // filename表示文件的默认名称，因为网络传输只支持URL编码的相关支付，因此需要将文件名URL编码后进行传输,前端收到后需要反编码才能获取到真正的名称
            response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(filename, "UTF-8"));
            // 告知浏览器文件的大小
            response.addHeader("Content-Length", "" + file.length());
            OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream");
            outputStream.write(buffer);
            outputStream.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
