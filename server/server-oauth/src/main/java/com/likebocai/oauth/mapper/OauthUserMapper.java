package com.likebocai.oauth.mapper;

import com.likebocai.oauth.dto.UserRegisterDTO;
import com.likebocai.oauth.po.OauthUserPO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OauthUserMapper {
    /**
     * @author likebocai
     * @date 2024/12/26 15:47
     * @description: 根据用户名查询用户信息
     */
    OauthUserPO getOauthUserInfoByUserName(String userName);
    /**
     * @author likebocai
     * @date 2024/12/26 15:47
     * @description: 根据数据字段查询，此字段是否唯一
     */
    Integer getCountByFileName(String fileName, String text);
    /**
     * @author likebocai
     * @date 2024/12/26 15:47
     * @description: 用户注册
     */
    int userRegister(UserRegisterDTO userRegisterDTO);
}
