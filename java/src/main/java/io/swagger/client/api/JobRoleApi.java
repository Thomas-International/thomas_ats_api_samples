/*
 * Thomas Perform ATS Partner API
 * # API Description  This API exists for the purpose of connecting an Applicant Tracking System (ATS) to the Thomas Perform talent assessment platform for the purpose of submitting candidates for assessments and retrieving their scores and reports.  During development you will be provided with an organisation account on our sandbox developer platform and an API key for accessing. Once your integration is complete, our customers will be able to request connection to your application by contacting our Customer Success team.  # Authentication  The API key that has been provided needs to be passed as a Bearer token in the Authorization header of every call on this API. This key represents credentials for one organisation and one application. Any calls that omit this key or provide an incorrect key will recieve a HTTP status 401 error.  API keys will not expire automatically, but customer organisations can request to regenerate or disable them at any time.  # Job Role Assesment Order vs Assesment Order  There are two ways to submit candidates for Thomas Assessments.  * You can submit a candidate to a specific Job Role. This requires the candidate to take all three of our Assessments, and will provide job specific star ratings of the candidate's suitability to the role as well as the detailed assessment outcomes. You will also get access to our more detailed candidate profile page, with downloadable reports and interview guide. This is our recommended workflow for most Thomas Perform customers. * You can submit a candidate to just take a specific selection of assessments. This will provide the outcomes for the selected assessments, but no star ratings or candidate profile. This is only recommended for customers that have been through Thomas training for interpreting assessment outcomes.  # JobRoleAssessmentOrder workflow  ![Sequence Diagram](images/jobRoleSeq.png) * When setting up a vacancy workflow in your ATS, use the GET Role endpoint to present the user with a list of roles in Thomas Perform that they can submit candidates to.  * Optionally prompt the user to create a new role, and submit their specification using the POST Role endpoint. If using this approach, the meanings for the settings are described in [our knowledgebase](https://knowledge.thomas.co/en/articles/4363659-select-success-characteristics), and within Thomas Perform itself. Please use the same wording to describe the characteristics where possible. * Submit a candidate for tests, specifying at least their email address and the ID of the selected job role. The candidate will receive an email at this address inviting them to complete the assessments.   * Optionally include a Callback Url for notification of test completion. This is preferred to polling the results URL   * Optionally provide a unique Id for the AssessmentOrder. If you do not provide one, it will be generated for you.  * The email contains a link. Candidates will be able to create a new Thomas Profile account or log in to an existing one.    * If they have already completed assessments, they will not need to retake them and their results will be shared with you.    * If they create a new account, they will be offered three assessments to take. They may do them in any order, and you will recieve the results when all three have been completed. * If you specified a Callback Url, you will be notified that the tests are complete * Retrieve the test results and star ratings from the GET JobRoleAssessmentOrder endpoint, specifying the Id  # AssessmentOrder workflow ![Sequence Diagram](images/nonJobRoleSeq.png) * Submit a candidate for tests at the POST AssessmentOrder endpoint, specifying at least their email address and the tests you wish them to complete. The candidate will receive an email at this address inviting them to complete the assessments.   * Optionally include a Callback Url for notification of test completion. This is preferred to polling the results URL   * Optionally provide a unique Id for the AssessmentOrder. If you do not provide one, it will be generated for you.  * The email contains a link. Candidates will be able to create a new Thomas Profile account or log in to an existing one.    * If they have already completed assessments, they will not need to retake them and their results will be shared with you.    * If they create a new account, they will be offered the assessments you requested them to take. They may do them in any order, and you will recieve the results when all three have been completed. They may also take any tests you did not request, but these results will not be shared with you. * If you specified a Callback Url, you will be notified that the tests are complete * Retrieve the test results from the GET AssessmentOrder endpoint, specifying the Id  # Callback  When submitting a candidate for assessments, you can optionally specify a callback URL. When the candidate has completed their final requested assessment we will send a POST message to that URL with a body similar to the following.      {         \"id\": \"52F9DC5C-287B-430B-92E6-B393772EA359\",         \"resultEndpoint\": \"https://dev-api.thomas.co/ats-open-api/v1/jobRoleAssessmentOrder/52F9DC5C-287B-430B-92E6-B393772EA359\"            }  Any success HTTP response code (codes in the 2xx range) will acknowledge receipt of the notification. Any other response code or connection error will trigger a retry later. This notification is unauthenticated, so the candidate results must be retrieved from our own API at the endpoint specified, using our standard authorization token.  # Results page  ![Screenshot of results page](images/resultsPage.png) The results object for a JobRoleAssessmentOrder includes a URL to a results page and a PIN code that a user must enter to authenticate that page. The URL and PIN are specific to the individual JobRoleAssessmentOrder and do not provide access to other candidate data. The complete list of candidates for a role can be viewed only by users who have an account on Thomas Perform.  The results page provides more information about the candidate and their suitability to the role, as well as an interview guide providing recommended questions to ask during a job interview. All of this information can optionally be downloaded as a PDF report.
 *
 * OpenAPI spec version: v1
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package io.swagger.client.api;

import io.swagger.client.ApiCallback;
import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.ApiResponse;
import io.swagger.client.Configuration;
import io.swagger.client.Pair;
import io.swagger.client.ProgressRequestBody;
import io.swagger.client.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import io.swagger.client.model.JobRole;
import io.swagger.client.model.JobRoleRequest;
import io.swagger.client.model.ProblemDetails;
import java.util.UUID;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JobRoleApi {
    private ApiClient apiClient;

    public JobRoleApi() {
        this(Configuration.getDefaultApiClient());
    }

    public JobRoleApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for createJobRole
     * @param body Request object (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call createJobRoleCall(JobRoleRequest body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;
        
        // create path and map variables
        String localVarPath = "/v1/jobRole";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "Bearer" };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call createJobRoleValidateBeforeCall(JobRoleRequest body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        com.squareup.okhttp.Call call = createJobRoleCall(body, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Create a new Job Role in the organisation
     * Job Role object to create. Level, Learning, Page and Variety correspond to the 4 sections of the learning environment as documented here. Characteristics are the success characteristics as defined https://knowledge.thomas.co/en/articles/4363659-select-success-characteristics.These should be described in your integration using the same phrasing where possible
     * @param body Request object (optional)
     * @return JobRole
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public JobRole createJobRole(JobRoleRequest body) throws ApiException {
        ApiResponse<JobRole> resp = createJobRoleWithHttpInfo(body);
        return resp.getData();
    }

    /**
     * Create a new Job Role in the organisation
     * Job Role object to create. Level, Learning, Page and Variety correspond to the 4 sections of the learning environment as documented here. Characteristics are the success characteristics as defined https://knowledge.thomas.co/en/articles/4363659-select-success-characteristics.These should be described in your integration using the same phrasing where possible
     * @param body Request object (optional)
     * @return ApiResponse&lt;JobRole&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<JobRole> createJobRoleWithHttpInfo(JobRoleRequest body) throws ApiException {
        com.squareup.okhttp.Call call = createJobRoleValidateBeforeCall(body, null, null);
        Type localVarReturnType = new TypeToken<JobRole>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Create a new Job Role in the organisation (asynchronously)
     * Job Role object to create. Level, Learning, Page and Variety correspond to the 4 sections of the learning environment as documented here. Characteristics are the success characteristics as defined https://knowledge.thomas.co/en/articles/4363659-select-success-characteristics.These should be described in your integration using the same phrasing where possible
     * @param body Request object (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call createJobRoleAsync(JobRoleRequest body, final ApiCallback<JobRole> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = createJobRoleValidateBeforeCall(body, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<JobRole>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getJobRoleById
     * @param id  (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getJobRoleByIdCall(UUID id, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/v1/jobRole/{id}"
            .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "Bearer" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getJobRoleByIdValidateBeforeCall(UUID id, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling getJobRoleById(Async)");
        }
        
        com.squareup.okhttp.Call call = getJobRoleByIdCall(id, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Get a single Job Role
     * Get a single Job Role by Id
     * @param id  (required)
     * @return JobRole
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public JobRole getJobRoleById(UUID id) throws ApiException {
        ApiResponse<JobRole> resp = getJobRoleByIdWithHttpInfo(id);
        return resp.getData();
    }

    /**
     * Get a single Job Role
     * Get a single Job Role by Id
     * @param id  (required)
     * @return ApiResponse&lt;JobRole&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<JobRole> getJobRoleByIdWithHttpInfo(UUID id) throws ApiException {
        com.squareup.okhttp.Call call = getJobRoleByIdValidateBeforeCall(id, null, null);
        Type localVarReturnType = new TypeToken<JobRole>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get a single Job Role (asynchronously)
     * Get a single Job Role by Id
     * @param id  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getJobRoleByIdAsync(UUID id, final ApiCallback<JobRole> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getJobRoleByIdValidateBeforeCall(id, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<JobRole>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getJobRoles
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getJobRolesCall(final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/v1/jobRole";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "Bearer" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getJobRolesValidateBeforeCall(final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        com.squareup.okhttp.Call call = getJobRolesCall(progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Get a list of all open Job Roles
     * Return a list of all open Job Roles
     * @return List&lt;JobRole&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<JobRole> getJobRoles() throws ApiException {
        ApiResponse<List<JobRole>> resp = getJobRolesWithHttpInfo();
        return resp.getData();
    }

    /**
     * Get a list of all open Job Roles
     * Return a list of all open Job Roles
     * @return ApiResponse&lt;List&lt;JobRole&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<JobRole>> getJobRolesWithHttpInfo() throws ApiException {
        com.squareup.okhttp.Call call = getJobRolesValidateBeforeCall(null, null);
        Type localVarReturnType = new TypeToken<List<JobRole>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get a list of all open Job Roles (asynchronously)
     * Return a list of all open Job Roles
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getJobRolesAsync(final ApiCallback<List<JobRole>> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getJobRolesValidateBeforeCall(progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<JobRole>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
