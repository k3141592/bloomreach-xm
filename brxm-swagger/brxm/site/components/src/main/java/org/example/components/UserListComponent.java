package org.example.components;

import org.example.user.ApiException;
import org.example.user.api.DefaultApi;
import org.example.user.model.User;
import org.example.vo.UserVo;
import org.hippoecm.hst.component.support.bean.BaseHstComponent;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.hippoecm.hst.site.HstServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserListComponent extends BaseHstComponent {

    @Override
    public void doBeforeRender(HstRequest request, HstResponse response) throws HstComponentException {
        Logger logger = LoggerFactory.getLogger(UserListComponent.class);

        // Getting the Spring bean
        DefaultApi defaultApi = HstServices.getComponentManager().getComponent("org.example.user.api.DefaultApi");

        List<UserVo> userVoList = new ArrayList<>();

        List<User> users = new ArrayList<>();
        try {
            users = defaultApi.usersGet();
        } catch (ApiException e) {
            logger.error("Gettign all users failed. Error: " + e.getMessage());
        }
        userVoList = users.stream().map(user -> new UserVo(user)).collect(Collectors.toList());

        // Put the object on the request
        request.setAttribute("users", userVoList);
    }
}
