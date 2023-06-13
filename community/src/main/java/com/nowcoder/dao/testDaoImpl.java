package com.nowcoder.dao;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository
@Scope("prototype")
public class testDaoImpl  implements testDao{

    @Override
    public void select() {
        System.out.println("testDao");
    }
}
