package com.bishe.controller;

import com.bishe.bean.*;
import com.bishe.mapper.ShopMapper;
import com.bishe.mapper.UserMapper;
import com.bishe.util.RedisUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@RestController
public class ShopController {
    @Autowired
    ShopMapper shopMapper;
    @Autowired
    RedisUtil redisUtil;
    @Resource
    UserMapper userMapper;

    /**
     * 商品创建
     * @param map 传入的map集合
     * @return 是否创建成功
     */
    @RequestMapping("/token/shopCreate")
    public String list(@RequestBody Map<String,String> map,@RequestHeader Map<String, String> headers){
        String token = headers.get("token");
        System.out.println(token);
        User user = (User)redisUtil.get(token);
        System.out.println(user);
        int userId = user.getId();
        String shopName = map.get("shopName");
        double shopPrice =  Double.parseDouble(map.get("shopPrice"));
        String shopIntroduction = map.get("shopIntroduction");
//      String shopHeadPicture = map.get("shopHeadPicture");
        String shopHeadPicture="/pic/shopTiShi.png";
        String shopFamily = map.get("shopFamily");
        String shopCc = map.get("shopCc");

        Shop shop = new Shop();
        shop.setShopCc(shopCc);
        shop.setUserID(userId);
        shop.setShopName(shopName);
        shop.setShopFamily(shopFamily);
        shop.setShopPrice(shopPrice);
        shop.setShopIntroduction(shopIntroduction);
        shop.setShopHeadPicture(shopHeadPicture);
        shop.setAuditStatus("0");
        System.out.println(shop.getId());
        int isTrue = shopMapper.shopCreate(shop);
        System.out.println(shop.getId());
        shopMapper.shopMainPictureCreate(shop);
        if(isTrue > 0) {
            return "商品创建成功";
        }
        return "商品创建失败";
    }

    /**
     * 获取用户商品信息
     * 返回商品数量，商品信息
     */
    @RequestMapping("/token/getShopAccount")
    public UserShopMessage getShopAccount(@RequestBody Map<String,String> map,@RequestHeader Map<String, String> headers){
        String token = headers.get("token");
        System.out.println(token);
        User user = (User)redisUtil.get(token);
        System.out.println(user);
        UserShopMessage userShopMessage = new UserShopMessage();
        int count = shopMapper.getShopAccount(user.getId());
        int curPage = Integer.parseInt(map.get("page"));
        int pageSize = 5;
//        int min = (curPage-1)*pageSize;
        int offset = pageSize*(curPage-1);
        List<Shop> list = shopMapper.getShopMessage(user.getId(),pageSize,offset);
        userShopMessage.setShops(list);
        userShopMessage.setAccount(count);
        return userShopMessage;
    }
    /**
     * 通过商品id查找商品
     * 返回该商品的全部信息
     */
    @RequestMapping("/token/getShopById")
    public Shop getShopById(@RequestBody Map<String,String> map,@RequestHeader Map<String, String> headers){
        String token = headers.get("token");
        System.out.println(token);
        User user = (User)redisUtil.get(token);
        System.out.println(user);
        Shop shop = shopMapper.getShopById(Integer.parseInt(map.get("id")));
        System.out.println("shop为"+shop);
        return shop;
    }

    /**
     * 修改商品信息
     */
    @RequestMapping("/token/updateShop")
    public String updateShopBy(@RequestBody String jsonStr,@RequestHeader Map<String, String> headers){
        String token = headers.get("token");
        User user = (User)redisUtil.get(token);

        JSONObject json = JSONObject.fromObject(jsonStr);
        Map map =  (Map) json.get("shop");
        String auditStatus = (String) map.get("auditStatus");
        auditStatus = getString(auditStatus);

        int shoHeadPicUploadId = (int)map.get("id");
        List list = (List) json.get("mainPic");
        ShopMainPicture shopMainPicture = new ShopMainPicture();
        shopMapper.updateShopMainPic("",shoHeadPicUploadId);
        if(list.size() >= 1) {
            String url1 = (String) JSONObject.fromObject(list.get(0)).get("url");
            shopMapper.updateShopMainPic_1(url1,shoHeadPicUploadId);
        }
        if(list.size() >= 2) {
            String url2 = (String) JSONObject.fromObject(list.get(1)).get("url");
            shopMapper.updateShopMainPic_2(url2,shoHeadPicUploadId);
        }
        if(list.size() >= 3) {
            String url3 = (String) JSONObject.fromObject(list.get(2)).get("url");
            shopMapper.updateShopMainPic_3(url3,shoHeadPicUploadId);
        }
        if(list.size() >= 4) {
            String url4 = (String) JSONObject.fromObject(list.get(3)).get("url");
            shopMapper.updateShopMainPic_4(url4,shoHeadPicUploadId);
        }
        if(list.size() >= 5) {
            String url5 = (String) JSONObject.fromObject(list.get(4)).get("url");
            shopMapper.updateShopMainPic_5(url5,shoHeadPicUploadId);
        }
        if(list.size() >= 6) {
            String url6 = (String) JSONObject.fromObject(list.get(5)).get("url");
            shopMapper.updateShopMainPic_6(url6,shoHeadPicUploadId);
        }
        if(list.size() >= 7) {
            String url7 = (String) JSONObject.fromObject(list.get(6)).get("url");
            shopMapper.updateShopMainPic_7(url7,shoHeadPicUploadId);
        }
        if(list.size() >= 8) {
            String url8 = (String) JSONObject.fromObject(list.get(7)).get("url");
            shopMapper.updateShopMainPic_8(url8,shoHeadPicUploadId);
        }
        if(list.size() >= 9) {
            String url9 = (String) JSONObject.fromObject(list.get(8)).get("url");
            shopMapper.updateShopMainPic_9(url9,shoHeadPicUploadId);
        }
        if(list.size() >= 10) {
            String url10 = (String) JSONObject.fromObject(list.get(9)).get("url");
            shopMapper.updateShopMainPic_10(url10,shoHeadPicUploadId);
        }
        Shop shop = new Shop();
        shop.setId((int)map.get("id"));
        shop.setShopName((String)map.get("shopName"));
        shop.setShopFamily((String) map.get("shopFamily"));
        String shopPrice = (String) map.get("shopPrice").toString();
        shop.setShopPrice(Double.valueOf(shopPrice));
        shop.setShopHeadPicture((String) map.get("shopHeadPicture"));
        shop.setAuditStatus(auditStatus);
        shop.setShopIntroduction((String) map.get("shopIntroduction"));
        int bool = shopMapper.updateShop(shop);
        if(bool > 0) {
            return "成功";
        }
        return "失败";
    }

    private String getString(String auditStatus) {
        if(auditStatus.equals("未上架")){
            auditStatus = "0";
        }
        if(auditStatus.equals("已上架")){
            auditStatus = "1";
        }
        if(auditStatus.equals("待发货")){
            auditStatus = "2";
        }
        if(auditStatus.equals("待收货")){
            auditStatus = "3";
        }
        if(auditStatus.equals("已收货")){
            auditStatus = "4";
        }
        return auditStatus;
    }

    @RequestMapping("/token/getShopMainPic")
    public ShopMainPicture getShopMainPic(@RequestBody Map<String,String> map) {
        int id = Integer.parseInt(map.get("id"));
        System.out.println("id为"+id);
        ShopMainPicture shopMainPicture = shopMapper.getShopMainPicByShopID(id);
        System.out.println(shopMainPicture);
        return shopMainPicture;
    }

    /**
     *通过多种条件搜索商品
     */
    @RequestMapping("token/searchShopBycondition")
    public List<Shop> searchShopBycondition(@RequestBody Map map){

//        double minPrice =  map.get("minPrice");
        SearchShopConditionBean searchShopConditionBean = new SearchShopConditionBean();
//        searchShopConditionBean.setPx((int)map.get("value"));
        double priceMin = 0;
        double priceMax = 10000;
        List shopFamily = new ArrayList();
        List Cc = new ArrayList();
        if(map.get("minPrice")!=null && !map.get("minPrice").equals("")){
            priceMin = Double.valueOf((String) map.get("minPrice")) ;
        }
        if(map.get("maxPrice")!=null && !map.get("maxPrice").equals("")){
            priceMax = Double.valueOf((String) map.get("maxPrice")) ;
        }
        searchShopConditionBean.setPriceMin(priceMin);
        searchShopConditionBean.setPriceMax(priceMax);
        if(map.get("value") != null && !map.get("value").equals("")){
            searchShopConditionBean.setPx((int)map.get("value"));
        }else {
            searchShopConditionBean.setPx(1);
        }
        Cc = (ArrayList)map.get("Cc");
        shopFamily = (ArrayList)map.get("shopFamily");
        for(int i = 0; i < Cc.size();i++){
            if ((int)Cc.get(i) == 1){
                searchShopConditionBean.setS("true");
            }
            if ((int)Cc.get(i) == 2){
                searchShopConditionBean.setM("true");
            }
            if ((int)Cc.get(i) == 3){
                searchShopConditionBean.setL("true");
            }
            if ((int)Cc.get(i) == 4){
                searchShopConditionBean.setXL("true");
            }
            if ((int)Cc.get(i) == 5){
                searchShopConditionBean.setXXL("true");
            }
        }
        for(int i = 0; i < shopFamily.size();i++) {
            if ((int)shopFamily.get(i) == 1){
                searchShopConditionBean.setQuju("true");
            }
            if ((int)shopFamily.get(i) == 2){
                searchShopConditionBean.setZhiju("true");
            }
            if ((int)shopFamily.get(i) == 3){
                searchShopConditionBean.setRuqun("true");
            }
            if ((int)shopFamily.get(i) == 4){
                searchShopConditionBean.setBeizi("true");
            }
            if ((int)shopFamily.get(i) == 5){
                searchShopConditionBean.setXuanduan("true");
            }
            if ((int)shopFamily.get(i) == 1){
                searchShopConditionBean.setGaoyao("true");
            }
            if ((int)shopFamily.get(i) == 1){
                searchShopConditionBean.setYuanlin("true");
            }
            if ((int)shopFamily.get(i) == 1){
                searchShopConditionBean.setZhuzi("true");
            }
        }
        List<Shop> shops = new ArrayList<>();
        if(shopFamily.size() == 0 && Cc.size() == 0) {
            shops = shopMapper.searchShopBycondition3(searchShopConditionBean);
        }
        if(shopFamily.size() > 0 && Cc.size() == 0) {
            shops = shopMapper.searchShopBycondition1(searchShopConditionBean);
        }
        if(shopFamily.size() == 0 && Cc.size() > 0) {
            shops = shopMapper.searchShopBycondition2(searchShopConditionBean);
        }
        if(shopFamily.size() > 0 && Cc.size() > 0) {
            shops = shopMapper.searchShopBycondition(searchShopConditionBean);
        }
        return shops;
    }

    /**
     * 模糊查询商品
     */
    @RequestMapping("token/searchShopByKey")
    public List<Shop> searchShopByKey(@RequestBody Map map) {
        String key = (String) map.get("key");
        List<Shop> shops = shopMapper.searchShopByKey(key);
        return shops;
    }

    /**
     * 修改商品状态
     */
    @RequestMapping("token/updateAuditStatus")
    public void updateAuditStatus(@RequestBody Map map) {
        int id = (int) map.get("id");
        String auditStatus = getString((String) map.get("auditStatus"));
        int tt = Integer.valueOf(auditStatus)+1;
        auditStatus = String.valueOf(tt);
        int t  = shopMapper.updateAuditStatus(auditStatus,id);
    }
    /**
     * 确认收货
     */
    @RequestMapping("token/qrsh")
    public void qrsh(@RequestBody Map map) {
        int id = (int) map.get("id");
        String auditStatus = getString((String) map.get("auditStatus"));
        int tt = Integer.valueOf(auditStatus)+1;
        auditStatus = String.valueOf(tt);
        int t  = shopMapper.updateAuditStatus(auditStatus,id);
        Shop shop =  shopMapper.getShopById(id);
        double price = shop.getShopPrice();
        int czUserID = shop.getUserID();
        User user = userMapper.getUserById(czUserID);
        double allPrice = Double.valueOf(user.getBalance()) + price;
        userMapper.czBalance(String.valueOf(allPrice),czUserID);

    }
}
