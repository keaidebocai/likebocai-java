package com.likebocai.oauth.mapper;

import com.likebocai.oauth.po.OauthUserPO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OauthUserMapper {
    OauthUserPO getOauthUserInfoByUserName(String userName);
}
