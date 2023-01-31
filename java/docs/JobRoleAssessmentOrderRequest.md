# JobRoleAssessmentOrderRequest

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | An ID to represent this instance of a candidate being tested against a role |  [optional]
**email** | **String** | The candidate&#x27;s email address. They will receive an email inviting them to take the tests | 
**roleId** | [**UUID**](UUID.md) | The ID of the Job Role | 
**callbackUrl** | **String** | The callback url to send Assessments results  Example: https://yourapi.example.com/notifyResults/ |  [optional]
