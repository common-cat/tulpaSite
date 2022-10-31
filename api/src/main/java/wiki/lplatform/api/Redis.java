package wiki.lplatform.api;

import redis.clients.jedis.Jedis;

public class Redis {
    public static void main(String[] args){
        Jedis jedis=new Jedis("localhost");
        System.out.println("start");
        jedis.set("test","test_________________");
        System.out.println("存储的:"+jedis.get("test"));
    }
}
