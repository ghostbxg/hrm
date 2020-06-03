package com.shiro;

import com.dao.User1Dao;
import com.entity.User1;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserReaml extends AuthorizingRealm {

    @Autowired
    User1Dao user1Dao;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setRoles(user1Dao.queryUserRoles(principalCollection.toString()));
        simpleAuthorizationInfo.setStringPermissions(user1Dao.queryUserPerms(principalCollection.toString()));

        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        User1 user1 = user1Dao.queryByUsername(username);
        if(user1 == null){
            throw new UnknownAccountException();
        }else{
            return new SimpleAuthenticationInfo(token.getPrincipal(),user1.getUpassword(),getName());
        }
    }
}
