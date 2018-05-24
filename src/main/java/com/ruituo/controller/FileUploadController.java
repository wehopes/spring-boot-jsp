package com.ruituo.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.List;


/**
 * description
 *
 * @author huijunjie
 * @date 2018-05-23 上午 10:08
 */
@Controller
public class FileUploadController {

    private Logger logger = Logger.getLogger(getClass());


   /**
    *TODO 单文件上传
    *
    *@param
    *@return
    */
    @RequestMapping("/toUpload")
    public String toUpload(){
        logger.info("跳转单文件上传页面");
        return "uploadFile";
    }

    @ResponseBody
    @RequestMapping("/upload")
    public String upload(@RequestParam("file")MultipartFile file) throws IOException{
        BufferedOutputStream outputStream = null;
        try {
             outputStream = new BufferedOutputStream(
                    new FileOutputStream(new File(file.getOriginalFilename())));
            logger.info("文件名称:"+file.getOriginalFilename());
            outputStream.write(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            outputStream.flush();
            outputStream.close();
        }
        return "上传成功";
    }


    /**
     *TODO 多文件上传
     *
     *@param
     *@return
     */
    @RequestMapping("/toMultiUpload")
    public String toMultiUpload(){
        logger.info("跳转多上传文件页面");
        return "multiUploadFile";
    }

    @ResponseBody
    @RequestMapping("/multiUpload")
    public String multiUpload(HttpServletRequest request) throws IOException{
        List<MultipartFile> files = ((MultipartHttpServletRequest)request).getFiles("file");
        for(MultipartFile file : files){
            BufferedOutputStream outputStream = null;
            try {
                outputStream = new BufferedOutputStream(
                        new FileOutputStream(new File(file.getOriginalFilename())));
                outputStream.write(file.getBytes());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                outputStream.flush();
                outputStream.close();
            }
        }
        return "上传成功";
    }
}
