# JobRoleAssessmentOrderApi

All URIs are relative to *https://dev-api.thomas.co/ats-open-api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createJobRoleAssessmentOrder**](JobRoleAssessmentOrderApi.md#createJobRoleAssessmentOrder) | **POST** /v1/jobRoleAssessmentOrder | Create a new Job Role Assessment Order
[**getJobRoleAssessmentOrderById**](JobRoleAssessmentOrderApi.md#getJobRoleAssessmentOrderById) | **GET** /v1/jobRoleAssessmentOrder/{id} | Get a single Job Role Assessment Order by ID
[**getJobRoleAssessmentOrders**](JobRoleAssessmentOrderApi.md#getJobRoleAssessmentOrders) | **GET** /v1/jobRoleAssessmentOrder | Get Job Role Assessment Orders

<a name="createJobRoleAssessmentOrder"></a>
# **createJobRoleAssessmentOrder**
> JobRoleAssessmentOrderResult createJobRoleAssessmentOrder(body)

Create a new Job Role Assessment Order

Create a new Job Role Assessment Order. The candidate will receive an email inviting them to complete the assessments

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.JobRoleAssessmentOrderApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

JobRoleAssessmentOrderApi apiInstance = new JobRoleAssessmentOrderApi();
JobRoleAssessmentOrderRequest body = new JobRoleAssessmentOrderRequest(); // JobRoleAssessmentOrderRequest | Request object
try {
    JobRoleAssessmentOrderResult result = apiInstance.createJobRoleAssessmentOrder(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling JobRoleAssessmentOrderApi#createJobRoleAssessmentOrder");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**JobRoleAssessmentOrderRequest**](JobRoleAssessmentOrderRequest.md)| Request object | [optional]

### Return type

[**JobRoleAssessmentOrderResult**](JobRoleAssessmentOrderResult.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getJobRoleAssessmentOrderById"></a>
# **getJobRoleAssessmentOrderById**
> JobRoleAssessmentOrderResult getJobRoleAssessmentOrderById(id)

Get a single Job Role Assessment Order by ID

Get a single Job Role Assessment Order including the results if completed

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.JobRoleAssessmentOrderApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

JobRoleAssessmentOrderApi apiInstance = new JobRoleAssessmentOrderApi();
String id = "id_example"; // String | 
try {
    JobRoleAssessmentOrderResult result = apiInstance.getJobRoleAssessmentOrderById(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling JobRoleAssessmentOrderApi#getJobRoleAssessmentOrderById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |

### Return type

[**JobRoleAssessmentOrderResult**](JobRoleAssessmentOrderResult.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getJobRoleAssessmentOrders"></a>
# **getJobRoleAssessmentOrders**
> List&lt;JobRoleAssessmentOrderResult&gt; getJobRoleAssessmentOrders(jobRoleId, complete)

Get Job Role Assessment Orders

Return all Job Role Assessment Orders that match the specified filter options

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.JobRoleAssessmentOrderApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

JobRoleAssessmentOrderApi apiInstance = new JobRoleAssessmentOrderApi();
String jobRoleId = "jobRoleId_example"; // String | Job Role ID
Boolean complete = true; // Boolean | Complete status
try {
    List<JobRoleAssessmentOrderResult> result = apiInstance.getJobRoleAssessmentOrders(jobRoleId, complete);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling JobRoleAssessmentOrderApi#getJobRoleAssessmentOrders");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **jobRoleId** | **String**| Job Role ID |
 **complete** | **Boolean**| Complete status | [optional]

### Return type

[**List&lt;JobRoleAssessmentOrderResult&gt;**](JobRoleAssessmentOrderResult.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

