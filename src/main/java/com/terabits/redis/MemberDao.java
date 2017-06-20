package com.terabits.redis;

import java.util.List;

/**
 * Created by Administrator on 2017/6/15.
 */
public interface MemberDao {
    boolean add(Member member);

    abstract boolean add(List<Member> list);

    void delete(String key);

    Member get(String keyId);

    public boolean update(final Member member);

    public List<Member> getMemberList(final String keyId);
}