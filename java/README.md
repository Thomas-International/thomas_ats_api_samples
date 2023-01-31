## Requirements

Building the API client library requires:
1. Java 1.7+
2. Maven/Gradle

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn clean install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn clean deploy
```

Refer to the [OSSRH Guide](http://central.sonatype.org/pages/ossrh-guide.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
  <groupId>io.swagger</groupId>
  <artifactId>swagger-java-client</artifactId>
  <version>1.0.0</version>
  <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "io.swagger:swagger-java-client:1.0.0"
```

### Others

At first generate the JAR by executing:

```shell
mvn clean package
```

Then manually install the following JARs:

* `target/swagger-java-client-1.0.0.jar`
* `target/lib/*.jar`

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java
import io.swagger.client.*;
import io.swagger.client.auth.*;
import io.swagger.client.model.*;
import io.swagger.client.api.AssessmentOrderApi;

import java.io.File;
import java.util.*;

public class AssessmentOrderApiExample {

    public static void main(String[] args) {
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
    }
}
import io.swagger.client.*;
import io.swagger.client.auth.*;
import io.swagger.client.model.*;
import io.swagger.client.api.AssessmentOrderApi;

import java.io.File;
import java.util.*;

public class AssessmentOrderApiExample {

    public static void main(String[] args) {
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
    }
}
```

## Documentation for API Endpoints

All URIs are relative to *https://dev-api.thomas.co/ats-open-api*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*AssessmentOrderApi* | [**createAssessmentOrder**](docs/AssessmentOrderApi.md#createAssessmentOrder) | **POST** /v1/assessmentOrder | Create a new Assessment Order
*AssessmentOrderApi* | [**getAssessmentOrderById**](docs/AssessmentOrderApi.md#getAssessmentOrderById) | **GET** /v1/assessmentOrder/{id} | Get a single Assessment Order by ID
*JobRoleApi* | [**createJobRole**](docs/JobRoleApi.md#createJobRole) | **POST** /v1/jobRole | Create a new Job Role in the organisation
*JobRoleApi* | [**getJobRoleById**](docs/JobRoleApi.md#getJobRoleById) | **GET** /v1/jobRole/{id} | Get a single Job Role
*JobRoleApi* | [**getJobRoles**](docs/JobRoleApi.md#getJobRoles) | **GET** /v1/jobRole | Get a list of all open Job Roles
*JobRoleAssessmentOrderApi* | [**createJobRoleAssessmentOrder**](docs/JobRoleAssessmentOrderApi.md#createJobRoleAssessmentOrder) | **POST** /v1/jobRoleAssessmentOrder | Create a new Job Role Assessment Order
*JobRoleAssessmentOrderApi* | [**getJobRoleAssessmentOrderById**](docs/JobRoleAssessmentOrderApi.md#getJobRoleAssessmentOrderById) | **GET** /v1/jobRoleAssessmentOrder/{id} | Get a single Job Role Assessment Order by ID
*JobRoleAssessmentOrderApi* | [**getJobRoleAssessmentOrders**](docs/JobRoleAssessmentOrderApi.md#getJobRoleAssessmentOrders) | **GET** /v1/jobRoleAssessmentOrder | Get Job Role Assessment Orders

## Documentation for Models

 - [AptitudeScore](docs/AptitudeScore.md)
 - [AssessmentOrderRequest](docs/AssessmentOrderRequest.md)
 - [AssessmentOrderResult](docs/AssessmentOrderResult.md)
 - [AssessmentScores](docs/AssessmentScores.md)
 - [AssessmentType](docs/AssessmentType.md)
 - [BehaviourScore](docs/BehaviourScore.md)
 - [JobRole](docs/JobRole.md)
 - [JobRoleAssessmentOrderRequest](docs/JobRoleAssessmentOrderRequest.md)
 - [JobRoleAssessmentOrderResult](docs/JobRoleAssessmentOrderResult.md)
 - [JobRoleCharacteristic](docs/JobRoleCharacteristic.md)
 - [JobRoleLearning](docs/JobRoleLearning.md)
 - [JobRoleLevel](docs/JobRoleLevel.md)
 - [JobRolePace](docs/JobRolePace.md)
 - [JobRoleRequest](docs/JobRoleRequest.md)
 - [JobRoleResults](docs/JobRoleResults.md)
 - [JobRoleVariety](docs/JobRoleVariety.md)
 - [PersonalityScore](docs/PersonalityScore.md)
 - [ProblemDetails](docs/ProblemDetails.md)
 - [Results](docs/Results.md)
 - [StarRatings](docs/StarRatings.md)

## Documentation for Authorization

Authentication schemes defined for the API:
### Bearer

- **Type**: API key
- **API key parameter name**: Authorization
- **Location**: HTTP header


## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author


