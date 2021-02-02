package com.video.util;

import com.video.util1.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class VideoUtils {

    private static Map<String, Integer> sizeBitRateMap;

    static {
        sizeBitRateMap = new HashMap<>();
        sizeBitRateMap.put("1920*1080", 4992);
        sizeBitRateMap.put("1280*720", 2496);
        sizeBitRateMap.put("1024*576", 1856);
        sizeBitRateMap.put("840*480", 1216);
        sizeBitRateMap.put("768*432", 1088);
        sizeBitRateMap.put("640*360", 896);
        sizeBitRateMap.put("424*240", 576);
    }

    /**
     * @param source     源文件
     * @param targetPath 转码后的路径
     * @param bitTate 分辨率
     */
    public static   void process2MP4(File source, String targetPath,String bitTate) throws EncoderException {

        MultimediaObject multimediaObject = new MultimediaObject(source);

        VideoAttributes video = new VideoAttributes();
        //设置视频编码
        video.setCodec("libx264");
        File target = new File(targetPath);
        AudioAttributes audio = new AudioAttributes();
        //设置编码器名称
        audio.setCodec("aac");
        if (bitTate != null && !"".equals(bitTate)){
            setVideoSize(bitTate, multimediaObject, video);
        }
        EncodingAttributes attrs = new EncodingAttributes();
        //设置转换后的格式
        attrs.setFormat("mp4");
        attrs.setAudioAttributes(audio);
        attrs.setVideoAttributes(video);
        Encoder encoder = new Encoder();
        encoder.encode(multimediaObject, target, attrs);

    }

    private static void setVideoSize(String bitTate, MultimediaObject multimediaObject, VideoAttributes video) throws EncoderException {
        String[] wh = bitTate.split("\\*");
        //设置视频分辨率
        VideoInfo videoInfo = multimediaObject.getInfo().getVideo();
        VideoSize videoSize = videoInfo.getSize();
        int width = videoSize.getWidth();
        int height = videoSize.getHeight();
        double rate = (width * 1.0) / height ;
        if(wh.length==2){
            double dbHeight = (Integer.valueOf(wh[0])) / rate;
            video.setSize(new VideoSize(Integer.valueOf(wh[0]),new Double(dbHeight).intValue()));
        }
    }

    public static String getUUID(){
        UUID uuid = UUID.randomUUID();
        String uuirStr = uuid.toString().replaceAll("-", "");
        return  uuirStr;
    }

    public static String getUrl(){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        String localAddr = request.getLocalAddr();
        int serverPort = request.getServerPort();
        return "http://"+localAddr +":"+ serverPort;
    }

}