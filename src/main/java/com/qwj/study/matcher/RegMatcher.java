/**
 * Copyright (C), 2015-2018
 * FileName: RegMatcher
 * Author:   qianwenjun
 * Date:     2018/6/17 06:08
 * Description:
 */
package com.qwj.study.matcher;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 〈〉
 *
 * @author qianwenjun
 * @create 2018/6/17
 * @since 1.0.0
 */
public class RegMatcher {

    public static String getString(String str,String reg,int index) {
        String s;
        try {
            Pattern pattern = Pattern.compile(reg);
            Matcher matcher = pattern.matcher(str);
            matcher.find();
            s = matcher.group(index);
        }catch (IllegalStateException e){
            s="";
            System.out.println(e);
        }

        return s;
    }

    public static void test1() {
        Pattern pattern = Pattern.compile("Java");
        String str = "123Java456Java789Java";
        String[] result = pattern.split(str);
        for (String s : result) {
            System.out.println(s);
        }

        //split(CharSequence input， int limit)
        //当limit值大于所能返回的字符串的最多个数或者为负数，返回的字符串个数将不受限制，但结尾可能包含空串
        //而当limit=0时与split(CharSequence input)等价，但结尾的空串会被丢弃。
        result = pattern.split(str,10);
        System.out.println(result.length);

        result = pattern.split(str,-2);
        System.out.println(result.length);

        result = pattern.split(str,0);
        System.out.println(result.length);

        //Pattern类也自带一个静态匹配方法matches(String regex, CharSequence input)，
        // 但只能进行全字符串匹配并且只能返回是否匹配上的boolean值
        String test1 = "Java";
        String test2 = "Java123456";

        System.out.println(Pattern.matches("Java",test1));//返回true
        System.out.println(Pattern.matches("Java",test2));//返回false
    }

    public static void test2() {
        Pattern pattern = Pattern.compile("Java");
        String str = "123Java456Java789Java";
        Matcher matcher = pattern.matcher(str);
        System.out.println(matcher);

    }

    //Matcher类提供了三个返回boolean值得匹配方法：matches()，lookingAt()，find()，find(int start)，
    // 其中matches()用于全字符串匹配，
    // lookingAt从字符串最开头开始匹配满足的子串，
    // find()可以对任意位置字符串匹配,
    // find(int start),其中start为起始查找索引值。
    public static void test3() {
        Pattern pattern = Pattern.compile("Java");
        String test1 = "Java";
        String test2 = "Java1234";
        String test3 = "1234Java";

        Matcher matcher = pattern.matcher(test1);
        System.out.println("matchers全字符匹配test1结果："+matcher.matches());
        matcher = pattern.matcher(test2);
        System.out.println("matchers全字符匹配test2结果："+matcher.matches());


        matcher = pattern.matcher(test2);
        System.out.println("lookingAt匹配test2的结果："+matcher.lookingAt());
        matcher = pattern.matcher(test3);
        System.out.println("lookingAt匹配test3的结果："+matcher.lookingAt());

        matcher = pattern.matcher(test1);
        System.out.println("find匹配test1的结果："+matcher.find());//返回true
        matcher = pattern.matcher(test2);
        System.out.println("find匹配test2的结果："+matcher.find());//返回true
        matcher = pattern.matcher(test3);
        System.out.println("find匹配test3的结果："+matcher.find(2));//返回true
        matcher = pattern.matcher(test3);
        System.out.println("find(start)匹配test3的结果："+matcher.find(5));//返回false
    }


    //组是用括号划分的正则表达式，可以根据组的编号来引用这个组。
    // 组号为0表示整个表达式，组号为1表示被第一对括号括起的组，依次类推，例如A(B(C))D，组0是ABCD，组1是BC，组2是C。
    //Matcher类提供了start()，end()，group()分别用于返回字符串的起始索引，结束索引，以及匹配到到的字符串。
    public static void test4() {
        Pattern pattern = Pattern.compile("Java");
        String test = "123Java456Java";

        Matcher matcher = pattern.matcher(test);
        matcher.find();
        System.out.println(matcher.start());//返回3
        System.out.println(matcher.end());//返回7
        System.out.println(matcher.group());//返回Java

    }

    //Matcher类提供了start(int gropu)，end(int group)，group(int i)，groupCount()用于分组操作
    public static void test5() {
        Pattern pattern = Pattern.compile("(Java)(Python)");
        String test = "123JavaPython456";
        Matcher matcher = pattern.matcher(test);
        matcher.find();
        System.out.println(matcher.groupCount());//返回2

        System.out.println(matcher.group(1));//返回第一组匹配到的字符串"Java"，注意起始索引是1
        System.out.println(matcher.start(1));//返回3，第一组起始索引
        System.out.println(matcher.end(1));//返回7 第一组结束索引

        System.out.println(matcher.group(2));//返回第二组匹配到的字符串"Python"
        System.out.println(matcher.start(2));//返回7，第二组起始索引
        System.out.println(matcher.end(2));//返回13 第二组结束索引

    }


    public static void test6(int i,int index) {

        String s;

        Pattern pattern = Pattern.compile("(\\D{4})");
        String str = "123JavaPython456Java123Java";
        Matcher matcher = pattern.matcher(str);
//        String[] reslt = pattern.split(str);
//        Matcher matcher = pattern.matcher(reslt[i]);
        matcher.find();
        s = matcher.group(index);
        System.out.println(s);



    }

    public static void main(String[] args) {
//        String s = "var DATA ={\"kindStatus\":\"成功\",\"agent\":\"\",\"rushSuccess\":\"no\",\"orderId\":\"688906657182720687\",\"type\":\"coupon\",\"timedownCreate\":\"29:59\",\"isWaitPay\":false,\"isBarCode\":false,\"leftDays\":\"594\",\"isNotSubTypeLink\":true,\"order\":{\"actualPrice\":1,\"allowInputAgain\":false,\"appId\":2239,\"appItemId\":166776,\"brief\":\"【自动化】秒杀优惠券兑换-兑吧\",\"chargeMode\":\"mall\",\"consumerId\":100025007,\"consumerPayBackPrice\":0,\"consumerPayPrice\":0,\"consumerPayStatus\":\"none\",\"couponId\":1066781090775,\"credits\":1,\"developerBizId\":\"2844938\",\"developerId\":908,\"duibaActualPrice\":0,\"duibaPayStatus\":\"none\",\"facePrice\":1,\"failType\":0,\"finishTime\":1529185091000,\"flowworkStage\":\"Success-complete\",\"gmtCreate\":1529185091000,\"gmtModified\":1529185091000,\"id\":688906657182720687,\"ip\":\"115.238.95.186\",\"itemId\":28423,\"orderNum\":\"68890665718272C0687\",\"payStatus\":\"successs\",\"quantity\":1,\"relationType\":0,\"status\":\"success\",\"type\":\"coupon\",\"typeInt\":1},\"app\":{\"autoRecommend\":true,\"bannerEnable\":true,\"buttonEnable\":true,\"color\":\"#11c3bc\",\"developerId\":908,\"enable\":true,\"id\":2239,\"logo\":\"//yun.dui88.com/images/201705/mtcrqtwamk.png\",\"name\":\"(阿里云)hmx积分商城\",\"showItemNum\":50,\"title\":\"hmx积分商城（阿里云）\",\"unitName\":\"积分\"},\"androidDownloadUrl\":\"\",\"isDownloadUrlShowText\":false,\"btnUseExposure\":{},\"is58App\":false,\"kind\":\"success\",\"batch\":{\"toBeInsert\":false,\"toBeUpdate\":false,\"validEndDate\":1580486399000,\"validStartDate\":1528387200000},\"isLottery\":false,\"isSelfAppItemMode\":false,\"showCredits\":true,\"creditsName\":\"积分\",\"recommendDomain\":\"//activity.m.duibatest.com.cn\",\"iosDownloadUrl\":\"\",\"homeWebDomain\":\"//home.m.duibatest.com.cn\",\"isMobike\":false,\"showOrderNum\":true,\"actualPay\":\"1积分\",\"template\":\"【自动化】秒杀优惠券-兑吧\",\"itemKeyVO\":{\"appItemId\":166776,\"bannerImage\":\"//yun.dui88.com/images/201806/9nxmghfdi9.jpg\",\"description\":\"【自动化】秒杀优惠券兑换-兑吧&lt;br&gt;\",\"detailLink\":\"/mobile/detail?itemId=28423&amp;dbnewopen\",\"id\":166776,\"image\":\"//yun.dui88.com/images/201806/ixfi8unyvs.jpg\",\"itemId\":28423,\"itemKey\":{\"ambItemKey\":false,\"appId\":2239,\"appItem\":{\"addTime\":1528427168000,\"appId\":2239,\"bannerImgNew\":\"//yun.dui88.com/images/201806/lzazkk20pp.jpg\",\"credits\":1,\"customTag\":\"\",\"deleted\":false,\"exchangeTipTemplate\":\"【自动化】秒杀优惠券-兑吧\",\"extraInfo\":\"{\\\"buttonText\\\":\\\"\\\",\\\"label\\\":\\\"\\\"}\",\"facePrice\":50,\"gmtCreate\":1528427168000,\"gmtModified\":1528427263000,\"homeDisplay\":true,\"id\":166776,\"imageJson\":\"{\\\"smallImgNew\\\":\\\"\\\",\\\"bannerImgNew\\\":\\\"//yun.dui88.com/images/201806/lzazkk20pp.jpg\\\"}\",\"imageJsonMap\":\"{}\",\"isOwner\":false,\"itemId\":28423,\"limitDate\":\"no\",\"limitScope\":\"forever\",\"limitTimeBetween\":\"00:10-23:59\",\"minFacePrice\":1,\"operationsType\":1,\"owner\":false,\"payload\":195,\"smallImgNew\":\"\",\"sourceType\":0,\"status\":\"on\",\"type\":\"coupon\",\"vipLimitType\":0,\"vipLimits\":0},\"autoOff\":false,\"devSecSkill\":true,\"duibaAppItemMode\":true,\"item\":{\"actualPrice\":1,\"androidDownload\":\"\",\"autoRecommend\":false,\"bannerImage\":\"//yun.dui88.com/images/201806/9nxmghfdi9.jpg\",\"degree\":false,\"deleted\":false,\"description\":\"【自动化】秒杀优惠券兑换-兑吧&lt;br&gt;\",\"duibaType\":0,\"enable\":true,\"exchangeTipTemplate\":\"【自动化】秒杀优惠券-兑吧\",\"facePrice\":1,\"gmtCreate\":1528427084000,\"gmtModified\":1529042032000,\"id\":28423,\"immediatelyButton\":0,\"iosDownload\":\"\",\"iosOpen\":\"00\",\"itemExtraDto\":{\"bannerImgNew\":\"//yun.dui88.com/images/201806/lzazkk20pp.jpg\",\"btnText\":\"马上使用\",\"gmtCreate\":1528427084000,\"gmtModified\":1528427084000,\"id\":4753,\"imageJson\":\"{\\\"bannerImgNew\\\":\\\"//yun.dui88.com/images/201806/lzazkk20pp.jpg\\\"}\",\"imageJsonMap\":\"{}\",\"itemId\":28423,\"name4Admin\":\"【自动化】秒杀优惠券兑换-兑吧\",\"usePrompt\":\"【自动化】秒杀优惠券兑换-兑吧\"},\"limitDate\":\"no\",\"limitScope\":\"forever\",\"limitTimeBetween\":\"\",\"logo\":\"//yun.dui88.com/images/201806/949l088ffu.jpg\",\"marketPrice\":50,\"minCredits\":1,\"minFacePrice\":0,\"multiImage\":\"//yun.dui88.com/images/201806/ixfi8unyvs.jpg\",\"name\":\"【自动化】秒杀优惠券兑换-兑吧\",\"noStock\":false,\"operationsType\":65536,\"payload\":0,\"publishTime\":1528427150000,\"remaining\":5001,\"sales\":0,\"shutDown\":false,\"smallImage\":\"//yun.dui88.com/images/201806/ro86tg4gy4.png\",\"sourceType\":0,\"subType\":0,\"suggestDownload\":false,\"type\":\"coupon\",\"validEndDate\":1580486399000,\"whiteImage\":\"//yun.dui88.com/images/201806/ro86tg4gy4.png\"},\"itemDtoType\":\"coupon\",\"itemMode\":false,\"itemType\":\"coupon\",\"selfAppItemMode\":false,\"valid\":true},\"logo\":\"//yun.dui88.com/images/201806/949l088ffu.jpg\",\"markStatus\":0,\"multiImage\":\"//yun.dui88.com/images/201806/ixfi8unyvs.jpg\",\"price\":0.5,\"smallImage\":\"//yun.dui88.com/images/201806/ro86tg4gy4.png\",\"title\":\"【自动化】秒杀优惠券兑换-兑吧\",\"type\":\"coupon\",\"useStatus\":0,\"validEndDate\":1580486399000},\"needcredits\":\"1\",\"title\":\"【自动化】秒杀优惠券兑换-兑吧\",\"creditsNo\":\"no\",\"isShareMeta4Sina\":false,\"after\":1,\"consumer\":{\"addrArea\":\"西湖区\",\"addrCity\":\"杭州市\",\"addrDetail\":\"数娱大厦\",\"addrName\":\"胡梦新\",\"addrPhone\":\"18258853242\",\"addrProvince\":\"浙江省\",\"appId\":2239,\"credits\":368506,\"gmtCreate\":1509607206000,\"gmtModified\":1529185091000,\"id\":100025007,\"lastAlipay\":\"fail_acctunusual@126.com\",\"lastPhone\":\"18012341234\",\"lastRealname\":\"测试\",\"needUpdate\":true,\"notLoginUser\":false,\"partnerUserId\":\"2720\",\"unreadCount\":1475,\"vipLevel\":0},\"crecordTime\":\"2018-06-17 05:38:11\",\"btnText\":\"马上使用\",\"coupon\":{\"batchType\":0,\"code\":\"2312313066\",\"goodsCouponId\":1066781090775,\"orderId\":688906657182720687,\"password\":\"\",\"showType\":0},\"lottery\":\"{\\\"androidDownloadUrl\\\":\\\"\\\",\\\"orderType\\\":\\\"coupon\\\",\\\"info_type\\\":\\\"1\\\",\\\"agent\\\":\\\"\\\",\\\"os\\\":\\\"6\\\",\\\"login_type\\\":1,\\\"item_id\\\":28423,\\\"app_item_id\\\":\\\"\\\",\\\"button_type\\\":\\\"40002\\\",\\\"ip\\\":\\\"115.238.95.186\\\",\\\"openUrl\\\":\\\"\\\",\\\"confirm\\\":true,\\\"consumer_id\\\":100025007,\\\"duiba_activity_id\\\":\\\"\\\",\\\"domain\\\":\\\"//embedlog.duibatest.com.cn\\\",\\\"activity_type\\\":\\\"\\\",\\\"iosDownloadUrl\\\":\\\"\\\",\\\"activity_id\\\":\\\"\\\",\\\"app_id\\\":2239,\\\"isShowButton\\\":true,\\\"info\\\":\\\"688906657182720687\\\"}\",\"stInfo\":{\"consumer_id\":100025007,\"info_type\":1,\"os\":\"6\",\"login_type\":2239,\"item_id\":28423,\"app_item_id\":166776,\"button_type\":\"80002\",\"domain\":\"//embedlog.duibatest.com.cn\",\"ip\":\"115.238.95.186\",\"app_id\":2239,\"info\":28423},\"itemKey\":{\"$ref\":\"$.itemKeyVO.itemKey\"},\"creditsDomain\":\"//www.duibatest.com.cn\",\"openUrl\":\"\",\"showUse\":true,\"showBackButton\":true,\"sourceDesc\":\"1积分\",\"goodsDomain\":\"//goods.m.duibatest.com.cn\",\"tradeBackHome\":true,\"isWeibo\":false,\"isSwitchCloseCredits\":false,\"validEndDate\":\"2020-01-31\"};\n";
//        String reg  = "\"title\":\"(【.*?)\",";
//        System.out.println(getString(s,reg,1));
//        test1();
        test6(2,1);

    }
}