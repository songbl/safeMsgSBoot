package com.songbl.safemsg;

import com.songbl.safemsg.common.utils.DateUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class CommonbootApplicationTests {

    @Test
    void contextLoads() {
        Date date = new Date();
        String date2 =DateUtils.format(date,"yyyy-MM-dd HH:mm:ss");
        System.out.println("时间是"+date2);
    }

}
