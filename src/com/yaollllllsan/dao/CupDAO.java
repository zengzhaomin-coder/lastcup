package com.yaollllllsan.dao;

import com.yaollllllsan.bean.Cup;
import com.yaollllllsan.utils.DBHelper;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import java.sql.Connection;
import java.util.List;

public class CupDAO {
    /**
     * 显示所有信息
     * @return
     * @throws Exception
     */
    public List<Cup> getAllCup() throws Exception {
        Connection conn = DBHelper.getConnection();
        String sql = "select id, name, price, prodate from cup";
        try {
            return new QueryRunner().query(
                    conn, sql, new BeanListHandler<Cup>(Cup.class)
            );
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }

    /**
     * 删除功能
     * @param id
     * @throws Exception
     */
    public void delCup(String id) throws Exception {
        Connection conn = DBHelper.getConnection();
        String sql = "delete from cup where id = ?";
        try {
            new QueryRunner().update(conn, sql, id);
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }

    /**
     * 删除多条信息
     * @param ids
     * @throws Exception
     */
    public void delSome(String[] ids) throws Exception {
        // 这种方法更简单
        for (String id : ids) {
            delCup(id);
        }
//         Connection conn = DBHelper.getConnection();
//         String sql = "delete from cup where id in (";
//         for(int i = 0; i < ids.length; i++){
//             if (i == ids.length - 1){
//                 sql += "?)";
//                 break;
//             }
//             sql += "?,";
//         }
//         try {
//             new QueryRunner().update(conn, sql, ids);
//         } finally {
//             DbUtils.closeQuietly(conn);
//         }
//     }
}
