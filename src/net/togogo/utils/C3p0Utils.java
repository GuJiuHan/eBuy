package net.togogo.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import net.togogo.bean.easybuy_news;
import net.togogo.bean.easybuy_order;
import net.togogo.bean.easybuy_order_detail;
import net.togogo.bean.easybuy_product;
import net.togogo.bean.easybuy_product_category;
import net.togogo.bean.easybuy_user;
import net.togogo.bean.easybuy_user_address;
import net.togogo.bean.result;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class C3p0Utils {
    static QueryRunner queryRunner = new QueryRunner(new ComboPooledDataSource());
    //将查询到的多条结果封装到javabean中
    public static <T> List<T> BeanListHandlers(String sql, BeanListHandler<T> beanListHandler) {
        List<T> list = null;

        try {
            list = (List) queryRunner.query(sql, beanListHandler);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static <T> List<T> BeanListHandlers(String sql, BeanListHandler<T> beanListHandler,Object...param) {
        List<T> list = null;

        try {
            list = (List) queryRunner.query(sql, beanListHandler,param);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    //BeanHandler(Class<T> type)
    //得到一条结果
    public static <T> T getBeanHandlers(String sql, BeanHandler<T> beanHandler, Object ...param) {
        T objects = null;
       try{
             objects = queryRunner.query(sql, beanHandler, param);

        } catch (SQLException e) {
            e.printStackTrace();
        }
       return objects;
    }





    public static int ProUpdate(String sql,Object ...param){
       int count =0;
        try {
         count =   queryRunner.update(sql,param);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  count;
    }

}
