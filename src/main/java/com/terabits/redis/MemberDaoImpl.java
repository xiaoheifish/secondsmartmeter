package com.terabits.redis;

/**
 * Created by Administrator on 2017/6/15.
 */
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;
@Repository(value="memberDao")
public class MemberDaoImpl extends RedisGeneratorDao<String,Member> implements MemberDao{

    /**
     * 添加对象
     */
    @Override
    public boolean add(final Member member) {
        boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
            public Boolean doInRedis(RedisConnection connection)
                    throws DataAccessException {
                RedisSerializer<String> serializer = getRedisSerializer();
                byte[] key  = serializer.serialize(member.getId());
                byte[] electricity = serializer.serialize(member.getElectricity());
                return connection.setNX(key, electricity);
            }
        });
        return result;
    }

    /**
     * 添加集合
     */
    @Override
    public boolean add(final List<Member> list) {
        Assert.notEmpty(list);
        boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
            public Boolean doInRedis(RedisConnection connection)
                    throws DataAccessException {
                RedisSerializer<String> serializer = getRedisSerializer();
                for (Member member : list) {
                    byte[] key  = serializer.serialize(member.getId());
                    byte[] electricity = serializer.serialize(member.getElectricity());
                    connection.setNX(key, electricity);
                }
                return true;
            }
        }, false, true);
        return result;
    }

    /**
     * 删除对象 ,依赖key
     */
    @Override
    public void delete(String key) {
        List<String> list = new ArrayList<String>();
        list.add(key);
        delete(list);
    }

    /**
     * 删除集合 ,依赖key集合
     */
    public void delete(List<String> keys) {
        redisTemplate.delete(keys);
    }

    /**
     * 修改对象
     */
    public boolean update(final Member member) {
        String key = member.getId();
        if (get(key) == null) {
            throw new NullPointerException("数据行不存在, key = " + key);
        }
        boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
            public Boolean doInRedis(RedisConnection connection)
                    throws DataAccessException {
                RedisSerializer<String> serializer = getRedisSerializer();
                byte[] key  = serializer.serialize(member.getId());
                byte[] electricity = serializer.serialize(member.getElectricity());
                connection.set(key, electricity);
                return true;
            }
        });
        return result;
    }

    /**
     * 根据key获取对象
     */
    @Override
    public Member get(final String keyId) {
        Member result = redisTemplate.execute(new RedisCallback<Member>() {
            public Member doInRedis(RedisConnection connection)
                    throws DataAccessException {
                RedisSerializer<String> serializer = getRedisSerializer();
                byte[] key = serializer.serialize(keyId);
                byte[] value = connection.get(key);
                if (value == null) {
                    return null;
                }
                String electricity = serializer.deserialize(value);
                return new Member(keyId, electricity);
            }
        });
        return result;
    }
    /*
    * 根据由时间生成的key获取从1时到现在的每小时电量
    * */

    public List<Member> getMemberList(final String keyId){
        List<Member> member = new ArrayList<Member>();
        member = redisTemplate.execute(new RedisCallback<List<Member>>() {
            public List<Member> doInRedis(RedisConnection connection) throws DataAccessException {
                List<Member> members = new ArrayList<Member>();
                for(int i = 1; i < Integer.parseInt(keyId); i ++) {
                    RedisSerializer<String> serializer = getRedisSerializer();
                    byte[] key = serializer.serialize(Integer.toString(i));
                    byte[] value = connection.get(key);
                    String electricity = serializer.deserialize(value);
                    members.add(new Member(Integer.toString(i),electricity));
                }
                return members;
            }
        });
        return member;
    }
}