<#include "../include/imports.ftl">
<#-- @ftlvariable name="users" type="java.util.List" -->
<#-- @ftlvariable name="user" type="org.example.vo.UserVo" -->

<@hst.link var="userSiteMap" siteMapItemRefId="user"/>

<#if userById?has_content>
    <div>
        <h1>User details</h1>
        <p>
            ID: ${userById.id} <br/>
            Name: ${userById.name}
        </p>
        <a href="${userSiteMap}">Users overview</a>
    </div>
</#if>

<#if users?has_content>
    <h1>All users</h1>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Name</th>
        </tr>
        </thead>
        <tbody>
        <#list users as user>
            <tr>
                <td acope="row">
                    <a href="${userSiteMap}/${user.id}">
                        ${user.id}
                    </a>
                </td>
                <td>${user.name}</td>
            </tr>
        </#list>
        </tbody>
    </table>
</#if>