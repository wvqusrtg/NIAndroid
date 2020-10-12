package com.citicbank.lz.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

/**
 * @ProjectName: ERP_APP
 * @Package: com.citicbank.erp.utils
 * @ClassName: TimeUtil
 * @Description: java类作用描述
 * @Author: nixs | Email:1911398892@qq.com
 * @CreateDate: 2019-11-16 14:02
 * @UpdateUser: nixs
 * @UpdateDate: 2019-11-16 14:02
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class TimeUtil {

    /**
     * 获取系统当前时间
     *
     * @return
     */
    public static String getCurrentTime() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        return format.format(date);
    }

    public static String getCurrentTime(String formatStr) {
        SimpleDateFormat format = new SimpleDateFormat(formatStr);
        Date date = new Date(System.currentTimeMillis());
        return format.format(date);
    }

    public static void getDeltTime(String expireTime) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        Date dateNow = new Date(System.currentTimeMillis());
        Date parse = format.parse(format.format(dateNow));
        Date date = format.parse(expireTime);
        long between = date.getTime() - dateNow.getTime();
        System.out.println("---时间间隔(精确到秒):"+between/1000);
        long day = between / (24 * 60 * 60 * 1000);
        long hour = (between / (60 * 60 * 1000) - day * 24);
        long min = ((between / (60 * 1000)) - day * 24 * 60 - hour * 60);
        long s = (between / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
        System.out.println(day + "天" + hour + "小时" + min + "分" + s + "秒");
    }

    public static String getDeltTimeStr(String expireTime) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        Date dateNow = new Date(System.currentTimeMillis());
        Date date = format.parse(expireTime);
        long between = date.getTime() - dateNow.getTime();
        /*long day = between / (24 * 60 * 60 * 1000);
        long hour = (between / (60 * 60 * 1000) - day * 24);
        long min = ((between / (60 * 1000)) - day * 24 * 60 - hour * 60);
        long s = (between / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
        System.out.println(day + "天" + hour + "小时" + min + "分" + s + "秒");*/
        return between/1000+"";
    }

    /**
     * 生成一个startNum 到 endNum之间的随机数(不包含endNum的随机数)
     * @param-startNum
     * @param endNum
     * @return
     */
    public static ArrayList getRandomNum(int count, int endNum){

        Random random = new Random();

        ArrayList<Integer> arrayNum = new ArrayList<>();
        int randomValue;
        while(arrayNum.size() < count){
            randomValue = random.nextInt(endNum);
            if(!arrayNum.contains(randomValue)){
                arrayNum.add(randomValue);
            }
        }
        return arrayNum;
    }

    public static void main(String args[]) throws ParseException {
        System.out.println("---Hello World!---");
        //String temp = "13.00";
        //String temp = "0.10";
        //String temp = "0.1";
        String temp = "1";

        //System.out.println(getCurrentTime());


        /*for (int i=0;i<10;i++){
            int random = new Random().nextInt(2)+1;
            System.out.println(random);
            System.out.println("是否整除："+random%2);
        }*/

        for (int i=0;i<10;i++){
            //System.out.println(getCurrentTime("yyyyMMddHHmmsssss"));
        }

        String temps = "2020000011|5555|5555|8566|86588";
        //System.out.println(temps.length());

        String timeExpire = "20200927151500";
        //getDeltTime(timeExpire);
        //System.out.println(getDeltTimeStr(timeExpire));

    }

}