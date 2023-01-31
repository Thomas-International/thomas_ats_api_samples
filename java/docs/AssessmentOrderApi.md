# AssessmentOrderApi

All URIs are relative to *https://dev-api.thomas.co/ats-open-api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createAssessmentOrder**](AssessmentOrderApi.md#createAssessmentOrder) | **POST** /v1/assessmentOrder | Create a new Assessment Order
[**getAssessmentOrderById**](AssessmentOrderApi.md#getAssessmentOrderById) | **GET** /v1/assessmentOrder/{id} | Get a single Assessment Order by ID

<a name="createAssessmentOrder"></a>
# **createAssessmentOrder**
> AssessmentOrderResult createAssessmentOrder(body)

Create a new Assessment Order

Create a new Assessment Order. The candidate will receive an email inviting them to complete the selected assessments

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.AssessmentOrderApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AssessmentOrderApi apiInstance = new AssessmentOrderApi();
AssessmentOrderRequest body = new AssessmentOrderRequest(); // AssessmentOrderRequest | Request object
try {
    AssessmentOrderResult result = apiInstance.createAssessmentOrder(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AssessmentOrderApi#createAssessmentOrder");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**AssessmentOrderRequest**](AssessmentOrderRequest.md)| Request object | [optional]

### Return type

[**AssessmentOrderResult**](AssessmentOrderResult.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getAssessmentOrderById"></a>
# **getAssessmentOrderById**
> AssessmentOrderResult getAssessmentOrderById(id)

Get a single Assessment Order by ID

Get a single Assessment Order including the results if completed

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.AssessmentOrderApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AssessmentOrderApi apiInstance = new AssessmentOrderApi();
String id = "id_example"; // String | 
try {
    AssessmentOrderResult result = apiInstance.getAssessmentOrderById(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AssessmentOrderApi#getAssessmentOrderById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |

### Return type

[**AssessmentOrderResult**](AssessmentOrderResult.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

