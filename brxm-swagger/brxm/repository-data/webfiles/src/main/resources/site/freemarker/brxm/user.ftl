<#include "../include/imports.ftl">
<#-- @ftlvariable name="user" type="org.example.vo.UserVo" -->

<div>
    <#if user?has_content>
        <h1>User details</h1>
        <p>
            ID: ${user.id} <br/>
            Name: ${user.name}
        </p>
    <#else>
        <h1>User not found</h1>
    </#if>

    <@hst.link var="userSiteMap" siteMapItemRefId="user"/>
    <a href="${userSiteMap}">Users overview</a>
</div>