package com.nowcoder.dao;

import com.nowcoder.entity.DiscussPost;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface DiscussPostMapper {
    /**SELECT * FROM user LIMIT 0,10 分页查询从0行开始,一页10行
     * where user_id = #{userId} 可能用到通过userid查询
     */
    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit);

    //@Param用于给参数起别名
    //如果只有一个参数,并且在<if>里,必须加别名!
    int selectDiscussPostRows(int userId);


}
