package com.video.util;

import ws.schild.jave.*;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

public class Video2PictureUtils {

    /**
     * 截取视频的一针作为封面图
     *
     * @param file          视频文件
     * @param picturePath 截取图片保存路径
     * @return
     */
    public static void getVideoPicture(File file, String picturePath,int seconds) {
        MultimediaObject multimediaObject = new MultimediaObject(file);
        try {
            MultimediaInfo info = multimediaObject.getInfo();
            VideoInfo videoInfo = info.getVideo();
            if (videoInfo != null) {
                VideoSize size = videoInfo.getSize();
                ScreenExtractor screenExtractor = new ScreenExtractor();
                File target = new File(picturePath);
                //截取视频作为图片保存
                /*
                 *第一个参数 视频源文件信息类
                 * 第二个参数 截取的宽度
                 * 第三个参数  截取的高度
                 * 第四个参数  截取的是那一帧 3000
                 * 第五个参数是  截取的图片质量 1-31   数字越小质量越高
                 *
                 **/
                screenExtractor.render(multimediaObject, size.getWidth(), size.getHeight(), seconds, target, 31);
            }
        } catch (EncoderException e) {
            e.printStackTrace();
        }
    }

}