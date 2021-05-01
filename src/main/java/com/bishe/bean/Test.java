package com.bishe.bean;

public class Test {
    public static void main(String[] args) {
        String USER_XZQH = "430102";
        String sql = " select t.NAME_ SZ,z.NAME_ QX,t.ID_ from OS_GROUP t left join OS_GROUP z on t.PARENT_ID_ = z.GROUP_ID_\n" +
                "where t.TYPE_ = '0' and t.RANK_LEVEL_ = 3 and t.ID_ LIKE '"+USER_XZQH+"%'\n" +
                "order by t.ID_";

        System.out.println(sql);
    }
}
