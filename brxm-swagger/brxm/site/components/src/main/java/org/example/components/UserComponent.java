package org.example.components;

import org.apache.commons.lang.StringUtils;
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

public class UserComponent extends BaseHstComponent {

    @Override
    public void doBeforeRender(HstRequest request, HstResponse response) throws HstComponentException {
        Logger logger = LoggerFactory.getLogger(UserComponent.class);

        // Getting the Spring bean
        DefaultApi defaultApi = HstServices.getComponentManager().getComponent("org.example.user.api.DefaultApi");

        UserVo userVo = null;

        String id = getComponentLocalParameter("userId");
        if(StringUtils.isNumeric(id)) {
            User userById = null;
            try {
                userById = defaultApi.getUserById(Integer.parseInt(id));
                userVo = new UserVo(userById);
            } catch (ApiException e) {
                logger.error("Getting user failed. Error: " + e.getMessage());
            }
        }

        // Put the object on the request
        request.setAttribute("user", userVo);
    }
}
