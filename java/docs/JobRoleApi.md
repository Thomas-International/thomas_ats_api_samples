# JobRoleApi

All URIs are relative to *https://dev-api.thomas.co/ats-open-api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createJobRole**](JobRoleApi.md#createJobRole) | **POST** /v1/jobRole | Create a new Job Role in the organisation
[**getJobRoleById**](JobRoleApi.md#getJobRoleById) | **GET** /v1/jobRole/{id} | Get a single Job Role
[**getJobRoles**](JobRoleApi.md#getJobRoles) | **GET** /v1/jobRole | Get a list of all open Job Roles

<a name="createJobRole"></a>
# **createJobRole**
> JobRole createJobRole(body)

Create a new Job Role in the organisation

Job Role object to create. Level, Learning, Page and Variety correspond to the 4 sections of the learning environment as documented here. Characteristics are the success characteristics as defined https://knowledge.thomas.co/en/articles/4363659-select-success-characteristics.These should be described in your integration using the same phrasing where possible

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.JobRoleApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

JobRoleApi apiInstance = new JobRoleApi();
JobRoleRequest body = new JobRoleRequest(); // JobRoleRequest | Request object
try {
    JobRole result = apiInstance.createJobRole(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling JobRoleApi#createJobRole");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**JobRoleRequest**](JobRoleRequest.md)| Request object | [optional]

### Return type

[**JobRole**](JobRole.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getJobRoleById"></a>
# **getJobRoleById**
> JobRole getJobRoleById(id)

Get a single Job Role

Get a single Job Role by Id

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.JobRoleApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

JobRoleApi apiInstance = new JobRoleApi();
UUID id = new UUID(); // UUID | 
try {
    JobRole result = apiInstance.getJobRoleById(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling JobRoleApi#getJobRoleById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | [**UUID**](.md)|  |

### Return type

[**JobRole**](JobRole.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getJobRoles"></a>
# **getJobRoles**
> List&lt;JobRole&gt; getJobRoles()

Get a list of all open Job Roles

Return a list of all open Job Roles

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.JobRoleApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

JobRoleApi apiInstance = new JobRoleApi();
try {
    List<JobRole> result = apiInstance.getJobRoles();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling JobRoleApi#getJobRoles");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;JobRole&gt;**](JobRole.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

