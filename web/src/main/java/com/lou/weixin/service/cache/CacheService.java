package com.lou.weixin.service.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import javax.annotation.PostConstruct;

/**
 * @author loufeng
 * @date 2017/7/9 下午3:19.
 */
@Service("cache")
public class CacheService {
    private ShardedJedis jedis;
    @Autowired
    private ShardedJedisPool shardedJedisPool;

    @PostConstruct
    private void init() {
        jedis = shardedJedisPool.getResource();
    }

    public String getString(String key) {
        return jedis.get(key);
    }

    public boolean setString(String key, String value) {

        jedis.set(key, value);
        return true;
    }


}
